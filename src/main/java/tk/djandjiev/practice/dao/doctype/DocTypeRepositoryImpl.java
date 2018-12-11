package tk.djandjiev.practice.dao.doctype;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private EntityManager em;

  @Override
  public List<DocType> getAll() {
    return em.createNamedQuery(DocType.ALL_SORTED, DocType.class).getResultList();
  }
}
