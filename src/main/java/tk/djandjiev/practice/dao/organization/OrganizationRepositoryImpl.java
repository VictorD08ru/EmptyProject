package tk.djandjiev.practice.dao.organization;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.djandjiev.practice.model.Organization;
import tk.djandjiev.practice.to.organization.OrganizationRequest;
import tk.djandjiev.practice.util.ValidationUtil;

/**
 * Реализация интерфейса OrganizationRepository.
 * @see tk.djandjiev.practice.dao.organization.OrganizationRepository
 * */
@Repository
@Transactional(readOnly = true)
public class OrganizationRepositoryImpl implements OrganizationRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Organization> getAll(OrganizationRequest request) {
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);
    Root<Organization> root = criteriaQuery.from(Organization.class);
    List<Predicate> predicates = new ArrayList<>();
    String name = request.getName();

    if (name.isEmpty()) {
      name = "%";
    } else {
      name = "%" + name + "%";
    }
    predicates.add(builder.like(root.get("name"), name));
    if (request.getInn() != null
        && request.getInn().length() <= 10
        && !request.getInn().matches(".*[\\D].*")) {
      predicates.add(builder.like(root.get("inn"), request.getInn() + "%"));
    }
    if (request.getIsActive() != null) {
      predicates.add(builder.equal(root.get("isActive"), request.getIsActive()));
    }
    criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
    criteriaQuery.orderBy(builder.asc(root.get("id")));
    return em.createQuery(criteriaQuery).getResultList();
  }

  @Override
  public Organization get(Integer id) {
    return em.find(Organization.class, id);
  }

  @Override
  @Transactional
  public Organization save(Organization org) {
    ValidationUtil.notNull(org);
    if (ValidationUtil.isNew(org)) {
      em.persist(org);
      return org;
    } else {
      return em.merge(org);
    }
  }
}
