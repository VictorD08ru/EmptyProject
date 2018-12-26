package tk.djandjiev.practice.controller;

import static tk.djandjiev.practice.util.OfficeData.OFFICE_ID2;
import static tk.djandjiev.practice.util.OfficeData.OFFICE_ID5;
import static tk.djandjiev.practice.util.OfficeData.OFFICE_TO_2;
import static tk.djandjiev.practice.util.OfficeData.SIMPLE_OFFICE_0;
import static tk.djandjiev.practice.util.OfficeData.SIMPLE_OFFICE_1;
import static tk.djandjiev.practice.util.OfficeData.SIMPLE_OFFICE_2;
import static tk.djandjiev.practice.util.OfficeData.getCreated;

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
import tk.djandjiev.practice.service.office.OfficeService;
import tk.djandjiev.practice.to.message.DataMessage;
import tk.djandjiev.practice.to.message.SuccessMessage;
import tk.djandjiev.practice.to.office.OfficeRequest;
import tk.djandjiev.practice.to.office.OfficeTO;
import tk.djandjiev.practice.to.office.SimplifiedOfficeTO;
import tk.djandjiev.practice.util.OrganizationData;

public class OfficeControllerTest extends AbstractControllerTest {

  @Autowired
  private OfficeService service;

  @Test
  public void testGetAll() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<OfficeRequest> requestEntity = new HttpEntity<>(
        new OfficeRequest(OrganizationData.ORG_ID0), headers);
    ResponseEntity<DataMessage<List<SimplifiedOfficeTO>>> entity = restTemplate.exchange(
        ROOT_URL + OfficeController.OFFICE_URL + "/list",
        HttpMethod.POST,
        requestEntity,
        new ParameterizedTypeReference<DataMessage<List<SimplifiedOfficeTO>>>() {});

    Assert.assertNotNull(entity);
    Assert.assertNotNull(entity.getBody());
    Assert.assertNotNull(entity.getBody().getData());
    Assertions.assertThat(entity.getBody().getData())
        .usingFieldByFieldElementComparator()
        .isEqualTo(Arrays.asList(SIMPLE_OFFICE_0, SIMPLE_OFFICE_1, SIMPLE_OFFICE_2));
  }

  @Test
  public void testGet() {
    ResponseEntity<DataMessage<OfficeTO>> entity = restTemplate.exchange(
        ROOT_URL + OfficeController.OFFICE_URL + "/" + OFFICE_ID2,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<DataMessage<OfficeTO>>() {});

    Assert.assertNotNull(entity);
    Assert.assertNotNull(entity.getBody());
    Assert.assertNotNull(entity.getBody().getData());
    Assertions.assertThat(entity.getBody().getData())
        .isEqualToIgnoringGivenFields(OFFICE_TO_2, "orgId");
  }

  @Test
  public void testUpdate() {
    OfficeTO updated = service.get(OFFICE_ID5);
    updated.setIsActive(null);
    updated.setPhone(null);
    updated.setAddress("г. Москва, Красная площадь, 2");
    DataMessage<OfficeTO> message = new DataMessage<>(updated);
    ResponseEntity<SuccessMessage> responseEntity = restTemplate.postForEntity(ROOT_URL +
            OfficeController.OFFICE_URL + "/update",
        message,
        SuccessMessage.class);

    Assert.assertNotNull(responseEntity);
    Assert.assertNotNull(responseEntity.getBody());
    Assertions.assertThat(responseEntity.getBody())
        .isEqualToComparingFieldByField(new SuccessMessage());
  }

  @Test
  public void testSave() {
    DataMessage<OfficeTO> message = new DataMessage<>(getCreated());
    ResponseEntity<SuccessMessage> responseEntity = restTemplate.postForEntity(ROOT_URL +
        OfficeController.OFFICE_URL + "/save", message, SuccessMessage.class);

    Assert.assertNotNull(responseEntity);
    Assert.assertNotNull(responseEntity.getBody());
    Assertions.assertThat(responseEntity.getBody())
        .isEqualToComparingFieldByField(new SuccessMessage());
  }
}