package tk.djandjiev.practice.dao.organization;

import java.util.List;
import javax.validation.constraints.NotNull;
import tk.djandjiev.practice.model.Organization;

/**
 * Repository для работы с Organization.
 * */
public interface OrganizationRepository {

  /**
   * Получить все объекты Organization.
   * @param name название организации.
   * @param inn ИНН организации.
   * @param isActive статус активности организации (функционирует/не вункционирует).
   * @return список организаций в соответствии с параметрами запроса
   * */
  List<Organization> getAll(@NotNull String name, String inn, Boolean isActive);

  /**
   * Получить объект Organization по идентификатору.
   * @param id идентификатор организации.
   * @return
   * */
  Organization get(Integer id);

  /**
   * Сохранить Organization.
   * @param org
   * @return
   * */
  Organization save(Organization org);
}
