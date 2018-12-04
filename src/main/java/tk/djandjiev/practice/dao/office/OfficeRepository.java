package tk.djandjiev.practice.dao.office;

import java.util.List;
import tk.djandjiev.practice.model.Office;

/**
 * Repository для работы с Office.
 * */
public interface OfficeRepository {

  /**
   * Получить все объекты Office по идентификатору Organization.
   * @return
   * */
  List<Office> getAll(Integer organizationId);

  /**
   * Получить объект Office по cобственному идентификатору и идентификатору Organization.
   * @param id
   * @return
   * */
  Office get(Integer id);

  /**
   * Сохранить Office.
   * @param office
   * @param organizationId
   * @return
   * */
  Office save(Office office, Integer organizationId);
}
