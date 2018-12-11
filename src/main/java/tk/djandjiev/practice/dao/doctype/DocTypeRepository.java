package tk.djandjiev.practice.dao.doctype;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import tk.djandjiev.practice.model.DocType;

/**
 * Repository для работы с DocType (только чтение).
 * */
public interface DocTypeRepository {

  /**
   * Получить все объекты DocType.
   * @return список типов документов, удостоверяющих личность, из справочника.
   * */
  @Query("SELECT d FROM DocType d ORDER BY d.code")
  List<DocType> getAll();
}
