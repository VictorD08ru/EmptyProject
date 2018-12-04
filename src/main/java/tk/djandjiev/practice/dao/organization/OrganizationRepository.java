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
   * @param name
   * @param inn
   * @param isActive
   * @return
   * */
  List<Organization> getAll(@NotNull String name, String inn, Boolean isActive);

  /**
   * Получить объект Organization по идентификатору.
   * @param id
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
