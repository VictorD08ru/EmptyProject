package tk.djandjiev.practice.dao.document;

import tk.djandjiev.practice.model.Document;

/**
 * Repository для работы с Document.
 * */
public interface DocumentRepository {

  /**
   * Получить объект Document по коду из справочника типов документов и номеру документа.
   * @param code код документа удочтоверения личности из справочника.
   * @param number номер удостоверения личности.
   * @return
   * */
  Document getByCodeAndNumber(String code, String number);

}
