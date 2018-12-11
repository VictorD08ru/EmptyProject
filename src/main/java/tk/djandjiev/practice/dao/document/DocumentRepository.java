package tk.djandjiev.practice.dao.document;

import java.util.List;
import tk.djandjiev.practice.model.Document;

/**
 * Repository для работы с Document.
 * */
public interface DocumentRepository {

  /**
   * Получить все объекты Document.
   * @return список документов пользователей.
   * */
  List<Document> getAll();

  /**
   * Получить объект Document по идентификатору.
   * @param id идентификатор документа.
   * @return
   * */
  Document get(Integer id);

  /**
   * Сохранить Document.
   * @param doc
   * @param docTypeId идентификатор типа удостоверения личности.
   * @return сохраненный объект.
   * */
  Document save(Document doc, Integer docTypeId);
}
