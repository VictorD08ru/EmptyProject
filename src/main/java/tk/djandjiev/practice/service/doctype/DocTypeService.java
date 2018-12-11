package tk.djandjiev.practice.service.doctype;

import java.util.List;
import tk.djandjiev.practice.to.DocTypeTO;

/**
 * Service для работы с DocType.
 * */
public interface DocTypeService {

  /**
   * Получить все объекты DocType.
   * @return список типов документов, удостоверяющих личность.
   * */
  List<DocTypeTO> getAll();

}
