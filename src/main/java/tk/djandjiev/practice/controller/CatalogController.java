package tk.djandjiev.practice.controller;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.djandjiev.practice.service.country.CountryService;
import tk.djandjiev.practice.service.doctype.DocTypeService;
import tk.djandjiev.practice.to.CountryTO;
import tk.djandjiev.practice.to.DocTypeTO;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController {
  private static final Logger log = getLogger(CatalogController.class);

  @Autowired
  private CountryService countryService;

  @Autowired
  private DocTypeService docTypeService;

  @GetMapping(value = "/countries")
  public List<CountryTO> getAllCountries() {
    log.info("get all countries");
    return countryService.getAll();
  }

  @GetMapping(value = "/docs")
  public List<DocTypeTO> getAllDocTypes() {
    log.info("get all document types");
    return docTypeService.getAll();
  }
}
