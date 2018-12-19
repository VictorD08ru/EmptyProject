package tk.djandjiev.practice.dao.doctype;

import java.util.List;
import tk.djandjiev.practice.model.DocType;

/**
 * Repository для работы с DocType (только чтение).
 * */
public interface DocTypeRepository {

  /**
   * Получить все объекты DocType.
   * @return список типов документов, удостоверяющих личность, из справочника.
   * */
  List<DocType> getAll();

  /**
   * Получить объект DocType по коду.
   * @param code
   * @return
   * */
  DocType getByCode(String code);
}
