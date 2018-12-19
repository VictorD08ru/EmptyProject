package tk.djandjiev.practice.dao.office;

import java.util.List;
import javax.validation.constraints.NotNull;
import tk.djandjiev.practice.model.Office;

/**
 * Repository для работы с Office.
 * */
public interface OfficeRepository {

  /**
   * Получить все объекты Office по идентификатору Organization.
   * @param orgId идентификатор Organization.
   * @param name название офиса.
   * @param phone телефон офиса.
   * @param isActive статус активности офиса (функционирует/не вункционирует).
   * @return список офисов организации.
   * */
  List<Office> getAll(@NotNull Integer orgId, String name, String phone, Boolean isActive);

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
