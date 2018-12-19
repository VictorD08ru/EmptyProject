package tk.djandjiev.practice.service.office;

import java.util.List;
import tk.djandjiev.practice.to.office.OfficeRequest;
import tk.djandjiev.practice.to.office.OfficeTO;
import tk.djandjiev.practice.to.office.SimplifiedOfficeTO;

/**
 * Service для работы с Office.
 * */
public interface OfficeService {

  /**
   * Получить все объекты Office по идентификатору Organization.
   * @param request параметры запроса.
   * @return упрощенный список офисов организации.
   * */
  List<SimplifiedOfficeTO> getAll(OfficeRequest request);

  /**
   * Получить объект Office по идентификатору.
   * @param id
   * @return
   * */
  OfficeTO get(Integer id);

  /**
   * Сохранить объект Office.
   * @param officeTO
   * */
  void save(OfficeTO officeTO);

}
