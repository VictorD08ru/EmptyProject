package tk.djandjiev.practice.service.organization;

import static tk.djandjiev.practice.util.OrganizationData.*;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.djandjiev.practice.AbstractTest;
import tk.djandjiev.practice.to.organization.OrganizationTO;

public class OrganizationServiceTest extends AbstractTest {

  @Autowired
  private OrganizationService service;

  @Test
  public void testGetAll() {
    Assertions.assertThat(service.getAll(ORGANIZATION_REQUEST))
        .usingFieldByFieldElementComparator()
        .isEqualTo(Arrays.asList(SIMPLE_ORG_0, SIMPLE_ORG_1, SIMPLE_ORG_3));
  }

  @Test
  public void testGet() {
    Assertions.assertThat(service.get(ORG_ID2)).isEqualToComparingFieldByField(ORG_TO_2);
  }

  @Test
  public void testCreate() {
    OrganizationTO created = getCreated();
    service.save(created);
    created.setId(NEW_ORG_ID4);
    Assertions.assertThat(service.getAll(ORGANIZATION_REQUEST))
        .usingFieldByFieldElementComparator()
        .isEqualTo(Arrays.asList(SIMPLE_ORG_0, SIMPLE_ORG_1, SIMPLE_ORG_3, created));
  }

  @Test
  public void testUpdate() {
    OrganizationTO updated = service.get(ORG_ID2);
    updated.setIsActive(false);
    updated.setPhone("4991991999");
    service.update(updated);
    Assertions.assertThat(service.get(ORG_ID2)).isEqualToComparingFieldByField(updated);
  }
}