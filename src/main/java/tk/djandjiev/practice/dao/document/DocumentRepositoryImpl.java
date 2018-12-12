package tk.djandjiev.practice.dao.document;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.djandjiev.practice.model.DocType;
import tk.djandjiev.practice.model.Document;
import tk.djandjiev.practice.util.ValidationUtil;

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
  public List<Document> getAll() {
    return em.createNamedQuery(Document.ALL_SORTED, Document.class).getResultList();
  }

  @Override
  public Document get(Integer id) {
    return em.find(Document.class, id);
  }

  @Override
  @Transactional
  public Document save(Document doc, Integer docTypeId) {
    DocType type = em.find(DocType.class, docTypeId);
    ValidationUtil.notNull(doc);
    doc.setType(type);
    if (ValidationUtil.isNew(doc)) {
      em.persist(doc);
      return doc;
    } else {
      return em.merge(doc);
    }
  }
}
