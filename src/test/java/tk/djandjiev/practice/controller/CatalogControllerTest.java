package tk.djandjiev.practice.controller;

import static tk.djandjiev.practice.util.CatalogData.COUNTRY_TO_LIST;
import static tk.djandjiev.practice.util.CatalogData.DOC_TYPE_TO_LIST;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import tk.djandjiev.practice.to.CountryTO;
import tk.djandjiev.practice.to.DocTypeTO;
import tk.djandjiev.practice.to.message.DataMessage;

public class CatalogControllerTest extends AbstractControllerTest {

  @Test
  public void testGetAllCountries() {
    ResponseEntity<DataMessage<List<CountryTO>>> entity = restTemplate
        .exchange(ROOT_URL + "/countries",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<DataMessage<List<CountryTO>>>() {});

    Assert.assertNotNull(entity);
    Assert.assertNotNull(entity.getBody());
    Assert.assertNotNull(entity.getBody().getData());
    Assertions.assertThat(entity.getBody().getData())
        .usingFieldByFieldElementComparator()
        .isEqualTo(COUNTRY_TO_LIST);
  }

  @Test
  public void testGetAllDocTypes() {
    ResponseEntity<DataMessage<List<DocTypeTO>>> entity = restTemplate
        .exchange(ROOT_URL + "/docs",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<DataMessage<List<DocTypeTO>>>() {});

    Assert.assertNotNull(entity);
    Assert.assertNotNull(entity.getBody());
    Assert.assertNotNull(entity.getBody().getData());
    Assertions.assertThat(entity.getBody().getData())
        .usingFieldByFieldElementComparator()
        .isEqualTo(DOC_TYPE_TO_LIST);
  }
}