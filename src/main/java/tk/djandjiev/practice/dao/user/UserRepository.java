package tk.djandjiev.practice.dao.user;

import java.util.List;
import javax.validation.constraints.NotNull;
import tk.djandjiev.practice.model.User;

/**
 * Repository для работы с User
 * */
public interface UserRepository {

  /**
   * Получить все объекты User.
   * @return
   * */
  List<User> getAll(@NotNull Integer officeId,
      String firstName,
      String secondName,
      String middleName,
      String position,
      String docCode,
      String citizenshipCode);

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
