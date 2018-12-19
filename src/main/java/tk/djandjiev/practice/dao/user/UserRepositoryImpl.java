package tk.djandjiev.practice.dao.user;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.djandjiev.practice.model.User;
import tk.djandjiev.practice.util.ValidationUtil;

/**
 * Реализация интерфейса UserRepository.
 * @see tk.djandjiev.practice.dao.user.UserRepository
 * */
@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<User> getAll(@NotNull Integer officeId,
      String firstName,
      String secondName,
      String middleName,
      String position,
      String docCode,
      String citizenshipCode) {
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<User> query = builder.createQuery(User.class);
    Root<User> root = query.from(User.class);
    List<Predicate> predicates = new ArrayList<>();
    predicates.add(builder.equal(root.get("office").get("id"), officeId));

    if (firstName != null) {
      if (firstName.isEmpty()) {
        firstName = "%";
      } else {
        firstName = "%" + firstName + "%";
      }
      predicates.add(builder.like(root.get("firstName"), firstName));
    }
    if (secondName != null) {
      if (secondName.isEmpty()) {
        secondName = "%";
      } else {
        secondName = "%" + secondName + "%";
      }
      predicates.add(builder.like(root.get("secondName"), secondName));
    }
    if (middleName != null) {
      if (middleName.isEmpty()) {
        middleName = "%";
      } else {
        middleName = "%" + middleName + "%";
      }
      predicates.add(builder.like(root.get("middleName"), middleName));
    }
    if (position != null) {
      if (position.isEmpty()) {
        position = "%";
      } else {
        position = "%" + position + "%";
      }
      predicates.add(builder.like(root.get("position"), position));
    }
    if (docCode != null) {
      predicates.add(builder.equal(root.get("document").get("type").get("code"), docCode));
    }
    if (citizenshipCode != null) {
      predicates.add(builder.equal(root.get("country").get("code"), citizenshipCode));
    }

    query.select(root).where(predicates.toArray(new Predicate[]{}));
    query.orderBy(builder.asc(root.get("firstName")));

    return em.createQuery(query).getResultList();
  }

  @Override
  public User get(Integer id) {
    return em.find(User.class, id);
  }

  @Override
  @Transactional
  public User save(User user) {
    ValidationUtil.notNull(user);
    if (ValidationUtil.isNew(user)) {
      em.persist(user);
      return user;
    } else {
      return em.merge(user);
    }
  }
}
