package tk.djandjiev.practice.dao.office;

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
import tk.djandjiev.practice.model.Office;
import tk.djandjiev.practice.util.ValidationUtil;

/**
 * Реализация интерфейса OfficeRepository.
 * @see tk.djandjiev.practice.dao.office.OfficeRepository
 * */
@Repository
@Transactional(readOnly = true)
public class OfficeRepositoryImpl implements OfficeRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Office> getAll(@NotNull Integer orgId, String name, String phone, Boolean isActive) {
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Office> criteriaQuery = builder.createQuery(Office.class);
    Root<Office> root = criteriaQuery.from(Office.class);
    List<Predicate> predicates = new ArrayList<>();
    predicates.add(builder.equal(root.get("organization").get("id"), orgId));

    if (name != null) {
      if (name.isEmpty()) {
        name = "%";
      } else {
        name = "%" + name + "%";
      }
      predicates.add(builder.like(root.get("name"), name));
    }
    if (phone != null) {
      if (phone.isEmpty()) {
        phone = "%";
      } else {
        phone = "%" + name + "%";
      }
      predicates.add(builder.like(root.get("phone"), phone));
    }

    if (isActive != null) {
      predicates.add(builder.equal(root.get("isActive"), isActive));
    }
    criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
    criteriaQuery.orderBy(builder.asc(root.get("id")));

    return em.createQuery(criteriaQuery).getResultList();
  }

  @Override
  public Office get(Integer id) {
    return em.find(Office.class, id);
  }

  @Override
  @Transactional
  public Office save(Office office) {
    ValidationUtil.notNull(office);
    if (ValidationUtil.isNew(office)) {
      em.persist(office);
      return office;
    } else {
      return em.merge(office);
    }
  }
}
