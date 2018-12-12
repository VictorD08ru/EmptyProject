package tk.djandjiev.practice.dao.organization;

import java.util.List;
import tk.djandjiev.practice.model.Organization;
import tk.djandjiev.practice.to.organization.OrganizationRequest;

/**
 * Repository для работы с Organization.
 * */
public interface OrganizationRepository {

  /**
   * Получить все объекты Organization.
   * @param request параметры запроса.
   * @return список организаций в соответствии с параметрами запроса
   * */
  List<Organization> getAll(OrganizationRequest request);

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
