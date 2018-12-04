package tk.djandjiev.practice.dao.user;

import java.util.List;
import tk.djandjiev.practice.model.User;

/**
 * Repository для работы с User
 * */
public interface UserRepository {

  /**
   * Получить все объекты User.
   * @return
   * */
  List<User> getAll();

  /**
   * Получить объект User по идентификатору.
   * @param id
   * @return
   * */
  User get(Integer id);

  /**
   * Сохранить User.
   * @param user
   * @return
   * */
  User save(User user);
}
