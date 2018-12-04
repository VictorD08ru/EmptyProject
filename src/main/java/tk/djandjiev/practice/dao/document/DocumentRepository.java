package tk.djandjiev.practice.dao.document;

import java.util.List;
import tk.djandjiev.practice.model.Document;

/**
 * Repository для работы с Document.
 * */
public interface DocumentRepository {

  /**
   * Получить все объекты Document.
   * @return
   * */
  List<Document> getAll();

  /**
   * Получить объект Document по идентификатору.
   * @param id
   * @return
   * */
  Document get(Integer id);

  /**
   * Сохранить Document.
   * @param doc
   * @param docTypeId
   * @return
   * */
  Document save(Document doc, Integer docTypeId);
}
