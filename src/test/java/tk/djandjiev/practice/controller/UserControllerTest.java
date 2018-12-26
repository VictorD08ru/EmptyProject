package tk.djandjiev.practice.controller;

import static tk.djandjiev.practice.util.UserData.SIMPLE_USER_7;
import static tk.djandjiev.practice.util.UserData.SIMPLE_USER_8;
import static tk.djandjiev.practice.util.UserData.USER_ID1;
import static tk.djandjiev.practice.util.UserData.USER_ID2;
import static tk.djandjiev.practice.util.UserData.USER_ID3;
import static tk.djandjiev.practice.util.UserData.USER_TO_2;
import static tk.djandjiev.practice.util.UserData.getCreated;

import java.time.LocalDate;
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
import tk.djandjiev.practice.service.user.UserService;
import tk.djandjiev.practice.to.message.DataMessage;
import tk.djandjiev.practice.to.message.SuccessMessage;
import tk.djandjiev.practice.to.user.SimplifiedUserTO;
import tk.djandjiev.practice.to.user.UserRequest;
import tk.djandjiev.practice.to.user.UserTO;

public class UserControllerTest extends AbstractControllerTest {

  @Autowired
  private UserService service;

  @Test
  public void testGetAll() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<UserRequest> requestEntity = new HttpEntity<>(
        new UserRequest(10004, null, null,
            null, null, "21", "643"),
        headers);
    ResponseEntity<DataMessage<List<SimplifiedUserTO>>> entity = restTemplate.exchange(
        ROOT_URL + UserController.USER_URL + "/list",
        HttpMethod.POST,
        requestEntity,
        new ParameterizedTypeReference<DataMessage<List<SimplifiedUserTO>>>() {});

    Assert.assertNotNull(entity);
    Assert.assertNotNull(entity.getBody());
    Assert.assertNotNull(entity.getBody().getData());
    Assertions.assertThat(entity.getBody().getData())
        .usingFieldByFieldElementComparator()
        .isEqualTo(Arrays.asList(SIMPLE_USER_7, SIMPLE_USER_8));
  }

  @Test
  public void testGet() {
    ResponseEntity<DataMessage<UserTO>> entity = restTemplate.exchange(
        ROOT_URL + UserController.USER_URL + "/" + USER_ID2,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<DataMessage<UserTO>>() {});

    Assert.assertNotNull(entity);
    Assert.assertNotNull(entity.getBody());
    Assert.assertNotNull(entity.getBody().getData());
    Assertions.assertThat(entity.getBody().getData())
        .isEqualToComparingFieldByField(USER_TO_2);
  }

  @Test
  public void testUpdate() {
    UserTO updated = service.get(USER_ID1);
    updated.setSecondName(null);
    updated.setDocCode(null);
    updated.setPosition("Заместитель генерального директора по внутриэкономической деятельности");
    updated.setDocDate(LocalDate.now());

    DataMessage<UserTO> message = new DataMessage<>(updated);
    ResponseEntity<SuccessMessage> responseEntity = restTemplate.postForEntity(ROOT_URL +
            UserController.USER_URL + "/update",
        message,
        SuccessMessage.class);

    Assert.assertNotNull(responseEntity);
    Assert.assertNotNull(responseEntity.getBody());
    Assertions.assertThat(responseEntity.getBody())
        .isEqualToComparingFieldByField(new SuccessMessage());
  }

  @Test
  public void testSave() {
    DataMessage<UserTO> message = new DataMessage<>(getCreated());
    ResponseEntity<SuccessMessage> responseEntity = restTemplate.postForEntity(ROOT_URL +
        UserController.USER_URL + "/save", message, SuccessMessage.class);

    Assert.assertNotNull(responseEntity);
    Assert.assertNotNull(responseEntity.getBody());
    Assertions.assertThat(responseEntity.getBody())
        .isEqualToComparingFieldByField(new SuccessMessage());
  }
}