package tk.djandjiev.practice.dao.office;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.djandjiev.practice.model.Office;
import tk.djandjiev.practice.model.Organization;
import tk.djandjiev.practice.util.ValidationUtil;

/**
 * Реализация интерфейса OfficeRepository.
 * @see tk.djandjiev.practice.dao.office.OfficeRepository
 * */
@Repository
@Transactional(readOnly = true)
public class OfficeRepositoryImpl implements OfficeRepository {

  @Autowired
  private EntityManager em;

  @Override
  public List<Office> getAll(Integer organizationId) {
    return em.createNamedQuery(Office.ALL_SORTED, Office.class)
        .setParameter(1, organizationId).getResultList();
  }

  @Override
  public Office get(Integer id) {
    return em.find(Office.class, id);
  }

  @Override
  @Transactional
  public Office save(Office office, Integer organizationId) {
    Organization org = em.find(Organization.class, organizationId);
    ValidationUtil.notNull(office);
    office.setOrganization(org);
    if (ValidationUtil.isNew(office)) {
      em.persist(office);
      return office;
    } else {
      return em.merge(office);
    }
  }
}
