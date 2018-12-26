package tk.djandjiev.practice.controller;

import static tk.djandjiev.practice.util.OrganizationData.ORGANIZATION_REQUEST;
import static tk.djandjiev.practice.util.OrganizationData.ORG_ID2;
import static tk.djandjiev.practice.util.OrganizationData.ORG_TO_2;
import static tk.djandjiev.practice.util.OrganizationData.SIMPLE_ORG_0;
import static tk.djandjiev.practice.util.OrganizationData.SIMPLE_ORG_1;
import static tk.djandjiev.practice.util.OrganizationData.SIMPLE_ORG_3;
import static tk.djandjiev.practice.util.OrganizationData.getCreated;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import tk.djandjiev.practice.service.organization.OrganizationService;
import tk.djandjiev.practice.to.message.DataMessage;
import tk.djandjiev.practice.to.message.SuccessMessage;
import tk.djandjiev.practice.to.organization.OrganizationRequest;
import tk.djandjiev.practice.to.organization.OrganizationTO;
import tk.djandjiev.practice.to.organization.SimplifiedOrganizationTO;

public class OrganizationControllerTest extends AbstractControllerTest {

  @Autowired
  private OrganizationService service;

  @Test
  public void testGetAll() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<OrganizationRequest> requestEntity = new HttpEntity<>(ORGANIZATION_REQUEST, headers);

    ResponseEntity<DataMessage<List<SimplifiedOrganizationTO>>> entity = restTemplate
        .exchange(ROOT_URL + OrganizationController.ORGANIZATION_URL + "/list",
            HttpMethod.POST,
            requestEntity,
            new ParameterizedTypeReference<DataMessage<List<SimplifiedOrganizationTO>>>() {});

    Assert.assertNotNull(entity);
    Assert.assertNotNull(entity.getBody());
    Assert.assertNotNull(entity.getBody().getData());
    Assertions.assertThat(entity.getBody().getData())
        .usingFieldByFieldElementComparator()
        .isEqualTo(Arrays.asList(SIMPLE_ORG_0, SIMPLE_ORG_1, SIMPLE_ORG_3));
  }

  @Test
  public void testGet() {
    ResponseEntity<DataMessage<OrganizationTO>> entity = restTemplate.exchange(ROOT_URL +
            OrganizationController.ORGANIZATION_URL + "/" + ORG_ID2,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<DataMessage<OrganizationTO>>() {});

    Assert.assertNotNull(entity);
    Assert.assertNotNull(entity.getBody());
    Assert.assertNotNull(entity.getBody().getData());
    Assertions.assertThat(entity.getBody().getData())
        .isEqualToComparingFieldByField(ORG_TO_2);
  }

  @Test
  public void testUpdate() {
    OrganizationTO updated = service.get(ORG_ID2);
    updated.setIsActive(false);
    updated.setPhone("4991991999");
    DataMessage<OrganizationTO> message = new DataMessage<>(updated);

    ResponseEntity<SuccessMessage> responseEntity = restTemplate.postForEntity(ROOT_URL +
        OrganizationController.ORGANIZATION_URL + "/" + ORG_ID2, message, SuccessMessage.class);

    Assert.assertNotNull(responseEntity);
    Assert.assertNotNull(responseEntity.getBody());
    Assertions.assertThat(responseEntity.getBody())
        .isEqualToComparingFieldByField(new SuccessMessage());
  }

  @Test
  public void testSave() {
    DataMessage<OrganizationTO> message = new DataMessage<>(getCreated());
    ResponseEntity<SuccessMessage> responseEntity = restTemplate.postForEntity(ROOT_URL +
        OrganizationController.ORGANIZATION_URL + "/save", message, SuccessMessage.class);

    Assert.assertNotNull(responseEntity);
    Assert.assertNotNull(responseEntity.getBody());
    Assertions.assertThat(responseEntity.getBody())
        .isEqualToComparingFieldByField(new SuccessMessage());
  }
}