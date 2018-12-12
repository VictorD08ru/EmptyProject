package tk.djandjiev.practice.dao.office;

import java.util.List;
import tk.djandjiev.practice.model.Office;
import tk.djandjiev.practice.to.office.OfficeRequest;

/**
 * Repository для работы с Office.
 * */
public interface OfficeRepository {

  /**
   * Получить все объекты Office по идентификатору Organization.
   * @param request  параметры запроса.
   * @return список офисов организации.
   * */
  List<Office> getAll(OfficeRequest request);

  /**
   * Получить объект Office по собственному идентификатору и идентификатору Organization.
   * @param id
   * @return
   * */
  Office get(Integer id);

  /**
   * Сохранить Office.
   * @param office
   * @return сохраненный объект.
   * */
  Office save(Office office);
}
