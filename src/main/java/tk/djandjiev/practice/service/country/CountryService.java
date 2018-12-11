package tk.djandjiev.practice.service.country;

import java.util.List;
import tk.djandjiev.practice.to.CountryTO;

/**
 * Service для работы с Country.
 * */
public interface CountryService {

  /**
   * Получить все объекты DocType.
   * @return список типов документов, удостоверяющих личность.
   * */
  List<CountryTO> getAll();
}
