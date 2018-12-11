package tk.djandjiev.practice.util;

import tk.djandjiev.practice.model.Organization;
import tk.djandjiev.practice.to.OrganizationTO;
import tk.djandjiev.practice.to.SimplifiedOrganizationTO;

/**
 * Данные Organization для тестирования.
 * */
public class OrganizationData {
  public static final Integer ORG_ID0 = 10000;
  public static final Integer ORG_ID1 = 10001;
  public static final Integer ORG_ID2 = 10002;
  public static final Integer ORG_ID3= 10003;
  public static final Integer NEW_ORG_ID4= 10004;

  public static final Organization ORG_0 = new Organization(
      "ООО Азбука", "Общество с ограниченной ответственностью Азбука",
      "7720123456", "772001001", "г. Москва, Зеленый просп, 10",
      "4951234567", true);
  public static final Organization ORG_1 = new Organization(
      "ООО Букварь", "Общество с ограниченной ответственностью Букварь",
      "7720123457", "772001001", "г. Москва, Кусковая ул, 17",
      "4951234568", true);
  public static final Organization ORG_2 = new Organization(
      "АО Велес", "Акционерное общество Велес",
      "7714123456", "771401001", "г. Москва, Беговой пр-д, 8",
      "4951234568", true);
  public static final Organization ORG_3 = new Organization(
      "ООО Домовой", "Общество с ограниченной ответственностью Домовой",
      "7714123457", "771401001", "г. Москва, Ленинградский просп., 31А, стр. 1",
      "4951234569", true);

  public static final SimplifiedOrganizationTO SIMPLE_ORG_0 = new SimplifiedOrganizationTO(
      ORG_ID0, "ООО Азбука", true);
  public static final SimplifiedOrganizationTO SIMPLE_ORG_1 = new SimplifiedOrganizationTO(
      ORG_ID1, "ООО Букварь", true);
  public static final SimplifiedOrganizationTO SIMPLE_ORG_2 = new SimplifiedOrganizationTO(
      ORG_ID2, "АО Велес", true);
  public static final SimplifiedOrganizationTO SIMPLE_ORG_3 = new SimplifiedOrganizationTO(
      ORG_ID3, "ООО Домовой", true);

  public static final OrganizationTO ORG_TO_2 = new OrganizationTO(
      ORG_ID2, "АО Велес", "Акционерное общество Велес",
      "7714123456", "771401001", "г. Москва, Беговой пр-д, 8",
      "4951234568", true);

  public static Organization getCreated() {
    return new Organization(
        "ООО Ромашка", "Общество с ограниченной ответственностью Ромашка",
        "7720666777", "772001001", "г. Москва, Зеленый просп, 12",
        "4956660088", true);
  }

  public static OrganizationTO getCreatedTO() {
    return new OrganizationTO(
        null, "ООО Ромашка", "Общество с ограниченной ответственностью Ромашка",
        "7720666777", "772001001", "г. Москва, Зеленый просп, 12",
        "4956660088", true);
  }
}
