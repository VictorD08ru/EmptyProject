package tk.djandjiev.practice.service.country;

import static tk.djandjiev.practice.util.CatalogData.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.djandjiev.practice.AbstractTest;

public class CountryServiceTest extends AbstractTest {

  @Autowired
  private CountryService service;

  @Test
  public void testGetAll() {
    Assertions.assertThat(service.getAll()).usingFieldByFieldElementComparator()
        .isEqualTo(COUNTRY_TO_LIST);
  }
}