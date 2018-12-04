package tk.djandjiev.practice.dao.country;

import java.util.List;
import tk.djandjiev.practice.model.Country;

/**
 * Repository для работы с Country (только чтение).
 * */
public interface CountryRepository {

  /**
   * Получить все объекты Country.
   * @return
   * */
  List<Country> getAll();

  /**
   * Получить объект Country по идентификатору.
   * @param id
   * @return
   * */
  Country get(Integer id);

  /**
   * Получить объект Country по коду.
   * @param code
   * @return
   * */
  Country getByCode(String code);
}
