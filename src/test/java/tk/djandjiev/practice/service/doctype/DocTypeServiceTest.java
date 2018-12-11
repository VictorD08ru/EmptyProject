package tk.djandjiev.practice.service.doctype;

import static tk.djandjiev.practice.util.CatalogData.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.djandjiev.practice.AbstractTest;

public class DocTypeServiceTest extends AbstractTest {

  @Autowired
  private DocTypeService docTypeService;

  @Test
  public void testGetAll() {
    Assertions.assertThat(docTypeService.getAll()).usingFieldByFieldElementComparator()
        .isEqualTo(DOC_TYPE_TO_LIST);
  }
}