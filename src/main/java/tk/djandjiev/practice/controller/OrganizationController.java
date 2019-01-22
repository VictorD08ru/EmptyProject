package tk.djandjiev.practice.controller;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.djandjiev.practice.service.organization.OrganizationService;
import tk.djandjiev.practice.util.View;
import tk.djandjiev.practice.to.message.DataMessage;
import tk.djandjiev.practice.to.message.SuccessMessage;
import tk.djandjiev.practice.to.organization.OrganizationRequest;
import tk.djandjiev.practice.to.organization.OrganizationTO;
import tk.djandjiev.practice.to.organization.SimplifiedOrganizationTO;

@RestController
@RequestMapping(
    value = OrganizationController.ORGANIZATION_URL,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController {

  private static final Logger log = getLogger(OrganizationController.class);

  static final String ORGANIZATION_URL = "/organization";

  @Autowired
  private OrganizationService service;

  @PostMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE)
  public DataMessage<List<SimplifiedOrganizationTO>> getAll(
      @Valid @RequestBody OrganizationRequest request) {
    log.info("getAll with specified parameters.");

    List<SimplifiedOrganizationTO> data = service.getAll(request);

    return new DataMessage<>(data);
  }

  @GetMapping(value = "/{id}")
  public DataMessage<OrganizationTO> get(@PathVariable("id") Integer id) {
    log.info("get organization with id: {}.", id);
    OrganizationTO data = service.get(id);
    if (data == null) {
      throw new IllegalArgumentException("organization with id: " + id + " not found");
    }

    return new DataMessage<>(data);
  }

  @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
  public SuccessMessage update(@Validated(View.Updateable.class) @RequestBody OrganizationTO org) {
    log.info("Update organization with id: {}.", org.getId());
    service.update(org);

    return new SuccessMessage();
  }

  @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
  public SuccessMessage save(@Valid @RequestBody OrganizationTO org) {
    log.info("Create new organization");
    service.save(org);

    return new SuccessMessage();
  }
}
