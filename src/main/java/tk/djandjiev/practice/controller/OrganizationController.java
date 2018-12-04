package tk.djandjiev.practice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = OrganizationController.ORGANIZATION_URL, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrganizationController {
  static final String ORGANIZATION_URL = "/organization";


}
