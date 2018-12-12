package tk.djandjiev.practice.util;

import tk.djandjiev.practice.to.organization.OrganizationRequest;
import tk.djandjiev.practice.to.organization.OrganizationTO;
import tk.djandjiev.practice.to.organization.SimplifiedOrganizationTO;

/**
 * Данные Organization для тестирования.
 * */
public class OrganizationData {

  public static final Integer ORG_ID0 = 10000;
  public static final Integer ORG_ID1 = 10001;
  public static final Integer ORG_ID2 = 10002;
  public static final Integer ORG_ID3= 10003;
  public static final Integer NEW_ORG_ID4= 10004;

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

  public static final OrganizationRequest ORGANIZATION_REQUEST = new OrganizationRequest(
      "ООО");

  public static OrganizationTO getCreated() {
    return new OrganizationTO(
        null, "ООО Ромашка", "Общество с ограниченной ответственностью Ромашка",
        "7720666777", "772001001", "г. Москва, Зеленый просп, 12",
        "4956660088", true);
  }
}
