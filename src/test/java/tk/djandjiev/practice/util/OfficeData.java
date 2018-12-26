package tk.djandjiev.practice.util;

import static tk.djandjiev.practice.util.OrganizationData.*;

import tk.djandjiev.practice.to.office.OfficeTO;
import tk.djandjiev.practice.to.office.SimplifiedOfficeTO;

/**
 * Данные Office для тестирования.
 * */
public class OfficeData {
  public static final Integer OFFICE_ID0 = 10000;
  public static final Integer OFFICE_ID1 = 10001;
  public static final Integer OFFICE_ID2 = 10002;
  public static final Integer OFFICE_ID3 = 10003;
  public static final Integer OFFICE_ID4 = 10004;
  public static final Integer OFFICE_ID5 = 10005;
  public static final Integer OFFICE_ID_NEW = 10006;

  public static final OfficeTO OFFICE_TO_0 = new OfficeTO(OFFICE_ID0,
      "Главный офис", "г. Москва, Зеленый просп, 10",
      "4951234567", true, ORG_ID0);
  public static final OfficeTO OFFICE_TO_1 = new OfficeTO(OFFICE_ID1,
      "Офис на Варшавском шоссе", "г. Москва, Варшавское шоссе, 141",
      "4951231122", true, ORG_ID0);
  public static final OfficeTO OFFICE_TO_2 = new OfficeTO(OFFICE_ID2,
      "Офис на Ленинградском проспекте", "г. Москва, Ленинградский просп, 9",
      "4951231133", true, ORG_ID0);
  public static final OfficeTO OFFICE_TO_3 = new OfficeTO(OFFICE_ID3,
      "Головной офис", "г. Москва, Кусковая ул, 17",
      "4951234568", true, ORG_ID1);
  public static final OfficeTO OFFICE_TO_4 = new OfficeTO(OFFICE_ID4,
      "Центральный офис", "г. Москва, Беговой пр-д, 8",
      "4951234568", true, ORG_ID2);
  public static final OfficeTO OFFIC_TO_5 = new OfficeTO(OFFICE_ID5,
      "Домовой на Ленинградке", "г. Москва, Ленинградский просп., 31А, стр. 1",
      "4951234569", true, ORG_ID3);

  public static final SimplifiedOfficeTO SIMPLE_OFFICE_0 = new SimplifiedOfficeTO(OFFICE_ID0,
      "Главный офис", true);
  public static final SimplifiedOfficeTO SIMPLE_OFFICE_1 = new SimplifiedOfficeTO(OFFICE_ID1,
      "Офис на Варшавском шоссе", true);
  public static final SimplifiedOfficeTO SIMPLE_OFFICE_2 = new SimplifiedOfficeTO(OFFICE_ID2,
      "Офис на Ленинградском проспекте", true);
  public static final SimplifiedOfficeTO SIMPLE_OFFICE_3 = new SimplifiedOfficeTO(OFFICE_ID3,
      "Головной офис", true);
  public static final SimplifiedOfficeTO SIMPLE_OFFICE_4 = new SimplifiedOfficeTO(OFFICE_ID4,
      "Центральный офис", true);
  public static final SimplifiedOfficeTO SIMPLE_OFFICE_5 = new SimplifiedOfficeTO(OFFICE_ID5,
      "Домовой на Ленинградке", true);

  public static OfficeTO getCreated() {
    return new OfficeTO(null, "Новый офис", "г. Москва, Красная площадь, 1",
        null, null, OrganizationData.ORG_ID2);
  }
}
