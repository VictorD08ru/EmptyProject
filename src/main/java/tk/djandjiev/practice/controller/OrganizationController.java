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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.djandjiev.practice.service.organization.OrganizationService;
import tk.djandjiev.practice.to.OrganizationTO;
import tk.djandjiev.practice.to.SimplifiedOrganizationTO;

@RestController
@RequestMapping(
    value = OrganizationController.ORGANIZATION_URL,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController {
  private static final Logger log = getLogger(OrganizationController.class);

  static final String ORGANIZATION_URL = "/organization";

  @Autowired
  private OrganizationService service;

  @GetMapping(value = "/list")
  public List<SimplifiedOrganizationTO> getAll(
      @RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "inn", required = false) String inn,
      @RequestParam(value = "isActive", required = false) Boolean isActive) {
    log.info("getAll with params name: '{}', inn: '{}', isActive: '{}'", name, inn, isActive);
    if (name == null || name.isEmpty()) {
      name = "%";
    } else {
      name = "%" + name + "%";
    }
    return service.getAll(name, inn, isActive);
  }

  @GetMapping(value = "/{id}")
  public OrganizationTO get(@PathVariable("id") Integer id) {
    log.info("get organization with id: {}", id);
    return service.get(id);
  }

  @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String update(@RequestBody OrganizationTO org) {
    log.info("Update organization with id: ", org.getId());
    service.update(org);
    //TODO: replace stub
    return "success";
  }

  @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody OrganizationTO org) {
    log.info("Create new organization");
    service.create(org);
    //TODO: replace stub
    return "success";
  }
}
