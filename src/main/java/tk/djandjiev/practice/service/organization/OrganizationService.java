package tk.djandjiev.practice.service.organization;

import java.util.List;
import javax.validation.constraints.NotNull;
import tk.djandjiev.practice.to.OrganizationTO;
import tk.djandjiev.practice.to.SimplifiedOrganizationTO;

/**
 * Service для работы с Organization.
 * */
public interface OrganizationService {

  /**
   * Получить все объекты Organization.
   * @param name название организации,
   * @param inn ИНН организации,
   * @param isActive работает ли организация.
   * @return список организаций в соответствии с параметрами запроса
   * */
  List<SimplifiedOrganizationTO> getAll(@NotNull String name, String inn, Boolean isActive);

  /**
   * Получить объект Organization по идентификатору.
   * @param id идентификатор организации.
   * @return
   * */
  OrganizationTO get(Integer id);

  /**
   * Создать Organization.
   * @param org объект для сохранения.
   * */
  void create(OrganizationTO org);

  /**
   * Обновить Organization.
   * @param org объект для сохранения.
   * */
  void update(OrganizationTO org);
}
