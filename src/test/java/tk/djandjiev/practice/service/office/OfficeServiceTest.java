package tk.djandjiev.practice.service.office;

import static tk.djandjiev.practice.util.OfficeData.*;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.djandjiev.practice.AbstractTest;
import tk.djandjiev.practice.to.office.OfficeRequest;
import tk.djandjiev.practice.to.office.OfficeTO;
import tk.djandjiev.practice.util.OrganizationData;

public class OfficeServiceTest extends AbstractTest {

  @Autowired
  private OfficeService service;

  @Test
  public void testGetAll() {
    OfficeRequest request = new OfficeRequest(OrganizationData.ORG_ID0);
    Assertions.assertThat(service.getAll(request))
        .usingFieldByFieldElementComparator().isEqualTo(
            Arrays.asList(SIMPLE_OFFICE_0, SIMPLE_OFFICE_1, SIMPLE_OFFICE_2));
  }

  @Test
  public void testGet() {
    OfficeTO officeTO = service.get(OFFICE_ID4);
    System.out.println(officeTO);
    Assertions.assertThat(officeTO)
        .isEqualToIgnoringGivenFields(OFFICE_TO_4, "orgId");
  }

  @Test
  public void testCreate() {
    OfficeTO created = getCreated();
    service.save(created);
    created.setId(OFFICE_ID_NEW);
    Assertions.assertThat(service.get(OFFICE_ID_NEW))
        .isEqualToIgnoringGivenFields(created, "orgId");
    Assertions.assertThat(service.getAll(new OfficeRequest(OrganizationData.ORG_ID2)))
        .usingFieldByFieldElementComparator().isEqualTo(Arrays.asList(SIMPLE_OFFICE_4, created));
  }

  @Test
  public void testUpdate() {
    OfficeTO updated = service.get(OFFICE_ID5);
    updated.setIsActive(null);
    String expectedPhone = updated.getPhone();
    updated.setPhone(null);
    updated.setAddress("г. Москва, Красная площадь, 2");
    service.save(updated);
    OfficeTO actual = service.get(OFFICE_ID5);
    updated.setPhone(expectedPhone);
    updated.setIsActive(true);
    Assertions.assertThat(actual).isEqualToComparingFieldByField(updated);
    Assert.assertTrue(actual.getIsActive());
    Assert.assertEquals(expectedPhone, actual.getPhone());
  }
}