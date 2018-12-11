package tk.djandjiev.practice.dao.office;

import java.util.List;
import tk.djandjiev.practice.model.Office;

/**
 * Repository для работы с Office.
 * */
public interface OfficeRepository {

  /**
   * Получить все объекты Office по идентификатору Organization.
   * @return список офисов организации.
   * */
  List<Office> getAll(Integer organizationId);

  /**
   * Получить объект Office по собственному идентификатору и идентификатору Organization.
   * @param id
   * @return объект Office.
   * */
  Office get(Integer id);

  /**
   * Сохранить Office.
   * @param office
   * @param organizationId идентификатор организации, которой принадлежит офис.
   * @return сохраненный объект.
   * */
  Office save(Office office, Integer organizationId);
}
