package tk.djandjiev.practice.service.user;

import static tk.djandjiev.practice.util.UserData.*;

import java.time.LocalDate;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.djandjiev.practice.AbstractTest;
import tk.djandjiev.practice.to.user.UserRequest;
import tk.djandjiev.practice.to.user.UserTO;

public class UserServiceTest extends AbstractTest {

  @Autowired
  private UserService userService;

  @Test
  public void testGetAll() {
    Assertions.assertThat(userService.getAll(new UserRequest(10005)))
        .usingFieldByFieldElementComparator()
        .isEqualTo(Arrays.asList(SIMPLE_USER_9, SIMPLE_USER_10));
    Assertions.assertThat(
            userService.getAll(
                new UserRequest(10004, null, null,
                    null, null, "21", "643")))
        .usingFieldByFieldElementComparator()
        .isEqualTo(Arrays.asList(SIMPLE_USER_7, SIMPLE_USER_8));
  }

  @Test
  public void testGet() {
    Assertions.assertThat(userService.get(USER_ID4)).isEqualToComparingFieldByField(USER_TO_4);
  }

  @Test
  public void testCreate() {
    UserTO created = getCreated();
    userService.save(created);
    UserTO actual = userService.get(USER_ID_NEW);
    Assertions.assertThat(actual)
        .isEqualToIgnoringGivenFields(created, "id", "citizenshipName");
  }

  @Test
  public void testCreateWithNulls() {
    UserTO created = getCreatedWithNulls();
    userService.save(created);
    UserTO actual = userService.get(USER_ID_NEW);
    created.setDocName(null);
    created.setDocNumber(null);
    created.setDocDate(null);
    Assertions.assertThat(actual)
        .isEqualToIgnoringGivenFields(created, "id", "citizenshipName");
  }

  @Test
  public void testUpdate() {
    UserTO updated = userService.get(USER_ID3);
    String secondName = updated.getSecondName();
    String docCode = updated.getDocCode();
    updated.setSecondName(null);
    updated.setDocCode(null);
    updated.setPosition("Главный курьер");
    updated.setDocDate(LocalDate.now());

    userService.save(updated);
    updated.setSecondName(secondName);
    updated.setDocCode(docCode);
    UserTO actual = userService.get(USER_ID3);
    Assertions.assertThat(actual).isEqualToComparingFieldByField(updated);
  }
}