package tk.djandjiev.practice.controller;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.djandjiev.practice.service.user.UserService;
import tk.djandjiev.practice.to.message.DataMessage;
import tk.djandjiev.practice.to.message.SuccessMessage;
import tk.djandjiev.practice.to.user.SimplifiedUserTO;
import tk.djandjiev.practice.to.user.UserRequest;
import tk.djandjiev.practice.to.user.UserTO;

@RestController
@RequestMapping(value = UserController.USER_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  private static final Logger log = getLogger(UserController.class);

  static final String USER_URL = "/user";

  @Autowired
  private UserService service;

  @PostMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE)
  public DataMessage<List<SimplifiedUserTO>> getAll(@RequestBody UserRequest request) {
    log.info("get all users with specified parameters with office id: {}.", request.getOfficeId());
    List<SimplifiedUserTO> data = service.getAll(request);

    return new DataMessage(data);
  }

  @GetMapping(value = "/{id}")
  public DataMessage<UserTO> get(@PathVariable("id") Integer id) {
    log.info("get user with id: {}.", id);
    UserTO data = service.get(id);
    if (data == null) {
      throw new IllegalArgumentException("user with id: " + id + " not found");
    }

    return new DataMessage(data);
  }

  @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
  public SuccessMessage update(@RequestBody UserTO userTO) {
    log.info("Update user with id: {}.", userTO.getId());
    if (userTO.getId() == null || userTO.getFirstName() == null || userTO.getPosition() == null) {
      throw new IllegalArgumentException("required parameters are null.");
    }
    service.save(userTO);

    return new SuccessMessage();
  }

  @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
  public SuccessMessage save(@RequestBody UserTO userTO) {
    log.info("Create new office of organization with id: {}.");
    if (userTO.getFirstName() == null || userTO.getPosition() == null) {
      throw new IllegalArgumentException("required parameters are null.");
    }
    service.save(userTO);

    return new SuccessMessage();
  }
}
