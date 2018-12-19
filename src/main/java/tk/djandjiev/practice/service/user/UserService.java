package tk.djandjiev.practice.service.user;

import java.util.List;
import tk.djandjiev.practice.to.user.SimplifiedUserTO;
import tk.djandjiev.practice.to.user.UserRequest;
import tk.djandjiev.practice.to.user.UserTO;

/**
 * Service для работы с User.
 * */
public interface UserService {

  /**
   * Получить все объекты Office по идентификатору Organization.
   * @param request параметры запроса.
   * @return упрощенный список офисов организации.
   * */
  List<SimplifiedUserTO> getAll(UserRequest request);

  /**
   * Получить объект User по идентификатору.
   * @param id
   * @return
   * */
  UserTO get(Integer id);

  /**
   * Сохранить объект User.
   * @param userTO
   * */
  void save(UserTO userTO);

}
