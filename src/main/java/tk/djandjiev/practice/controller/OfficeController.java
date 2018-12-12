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
import tk.djandjiev.practice.service.office.OfficeService;
import tk.djandjiev.practice.to.office.OfficeRequest;
import tk.djandjiev.practice.to.office.OfficeTO;
import tk.djandjiev.practice.to.office.SimplifiedOfficeTO;

@RestController
@RequestMapping(
    value = OfficeController.OFFICE_URL,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeController {

  private static final Logger log = getLogger(OfficeController.class);

  public static final String OFFICE_URL = "/office";

  @Autowired
  private OfficeService service;

  @GetMapping(value = "/list")
  public List<SimplifiedOfficeTO> getAll(@RequestBody OfficeRequest request) {
    log.info("get all offices of organization with id: {}.", request.getOrgId());
    return getAll(request);
  }

  @GetMapping(value = "/{id}")
  public OfficeTO get(@PathVariable("id") Integer id) {
    log.info("get office with id: {}.", id);
    return service.get(id);
  }


  @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String update(@RequestBody OfficeTO officeTO) {
    log.info("Update office with id: {}.", officeTO.getId());
    if (officeTO.getId() == null || officeTO.getName() == null || officeTO.getAddress() == null) {
      throw new IllegalArgumentException("required parameters are null.");
    }
    service.save(officeTO);
    //TODO: replace stub
    return "success";
  }

  @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody OfficeTO officeTO) {
    log.info("Create new office of organization with id: {}.");
    service.save(officeTO);
    //TODO: replace stub
    return "success";
  }
}
