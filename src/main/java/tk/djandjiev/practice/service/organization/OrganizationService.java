package tk.djandjiev.practice.service.organization;

import java.util.List;
import tk.djandjiev.practice.to.organization.OrganizationRequest;
import tk.djandjiev.practice.to.organization.OrganizationTO;
import tk.djandjiev.practice.to.organization.SimplifiedOrganizationTO;

/**
 * Service для работы с Organization.
 * */
public interface OrganizationService {

  /**
   * Получить все объекты Organization.
   * @param request параметры запроса.
   * @return упрощенный список организаций в соответствии с параметрами запроса.
   * */
  List<SimplifiedOrganizationTO> getAll(OrganizationRequest request);

  /**
   * Получить объект Organization по идентификатору.
   * @param id идентификатор организации.
   * @return
   * */
  OrganizationTO get(Integer id);

  /**
   * Сохранить Organization.
   * @param org объект для сохранения.
   * */
  void save(OrganizationTO org);

  /**
   * Обновить Organization.
   * @param org объект для сохранения.
   * */
  void update(OrganizationTO org);
}
