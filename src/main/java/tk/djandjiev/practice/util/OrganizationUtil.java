package tk.djandjiev.practice.util;

import java.util.List;
import java.util.stream.Collectors;
import tk.djandjiev.practice.model.Organization;
import tk.djandjiev.practice.to.OrganizationTO;

public class OrganizationUtil {
  private OrganizationUtil() {}

  public static OrganizationTO getTO(Organization org) {
    return new OrganizationTO(org.getId(), org.getName(), org.getActive());
  }

  public static List<OrganizationTO> getTOList(List<Organization> list) {
    return list.stream().map(OrganizationUtil::getTO).collect(Collectors.toList());
  }
}
