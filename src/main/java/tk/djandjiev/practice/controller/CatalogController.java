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
import tk.djandjiev.practice.to.message.DataMessage;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController {
  private static final Logger log = getLogger(CatalogController.class);

  @Autowired
  private CountryService countryService;

  @Autowired
  private DocTypeService docTypeService;

  @GetMapping(value = "/countries")
  public DataMessage<List<CountryTO>> getAllCountries() {
    log.info("get all countries");
    List<CountryTO> data = countryService.getAll();

    return new DataMessage<>(data);
  }

  @GetMapping(value = "/docs")
  public DataMessage<List<DocTypeTO>> getAllDocTypes() {
    log.info("get all document types");
    List<DocTypeTO> data = docTypeService.getAll();

    return new DataMessage<>(data);
  }
}
