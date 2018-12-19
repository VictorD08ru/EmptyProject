package tk.djandjiev.practice.dao.doctype;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.djandjiev.practice.model.DocType;

/**
 * Реализация интерфейса CountryRepository.
 * @see tk.djandjiev.practice.dao.country.CountryRepository
 * */
@Repository
@Transactional(readOnly = true)
public class DocTypeRepositoryImpl implements DocTypeRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<DocType> getAll() {
    return em.createNamedQuery(DocType.ALL_SORTED, DocType.class).getResultList();
  }

  @Override
  public DocType getByCode(String code) {
    List<DocType> list = em.createNamedQuery(DocType.GET_BY_CODE, DocType.class)
        .setParameter(1, code).getResultList();
    return DataAccessUtils.singleResult(list);
  }
}
