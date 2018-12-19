package tk.djandjiev.practice.controller;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import tk.djandjiev.practice.to.message.DataMessage;
import tk.djandjiev.practice.to.organization.OrganizationTO;
import tk.djandjiev.practice.util.OrganizationData;

public class OrganizationControllerTest extends AbstractControllerTest {

  @Test
  public void testGetAll() {

  }

  @Test
  public void testGet() {
    DataMessage<OrganizationTO> message = restTemplate.exchange(ROOT_URL +
            OrganizationController.ORGANIZATION_URL + "/" +
            OrganizationData.ORG_ID2,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<DataMessage<OrganizationTO>>() {}).getBody();

    Assert.assertNotNull(message);
    Assert.assertNotNull(message.getData());
    Assertions.assertThat(message.getData())
        .isEqualToComparingFieldByField(OrganizationData.ORG_TO_2);
  }

  @Test
  public void testpUdate() {
  }

  @Test
  public void testSave() {
  }
}