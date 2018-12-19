package tk.djandjiev.practice.dao.document;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.djandjiev.practice.model.Document;
/**
 * Реализация интерфейса DocumentRepository.
 * @see tk.djandjiev.practice.dao.document.DocumentRepository
 * */
@Repository
@Transactional(readOnly = true)
public class DocumentRepositoryImpl implements DocumentRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Document getByCodeAndNumber(String code, String number) {
    List<Document> list = em.createNamedQuery(Document.GET_BY_CODE_AND_NUM, Document.class)
        .setParameter(1, code)
        .setParameter(2, number)
        .getResultList();
    return DataAccessUtils.singleResult(list);
  }
}
