package tk.djandjiev.practice.dao.organization;

import static tk.djandjiev.practice.util.OrganizationData.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.djandjiev.practice.AbstractTest;
import tk.djandjiev.practice.model.Organization;
import tk.djandjiev.practice.util.TestUtil;

public class OrganizationRepositoryTest extends AbstractTest {

  @Autowired
  private OrganizationRepository repository;

  @Test
  public void testGetAll() {
    List<Organization> actual = repository.getAll("%ООО%", null, null);
    TestUtil.assertMatch(
        actual,
        Arrays.asList(ORG_0, ORG_1, ORG_3),
        Arrays.asList(ORG_ID0, ORG_ID1, ORG_ID3));
  }

  @Test
  public void testGetAllEmpty() {
    Assertions.assertThat(repository.getAll("ОО", null, null))
        .isEqualTo(Collections.emptyList());
  }

  @Test
  public void testGet() {
    Organization actual = repository.get(ORG_ID2);
    TestUtil.assertMatch(actual, ORG_2, ORG_ID2);
  }

  @Test
  public void testGetNull() {
    Assert.assertNull(repository.get(1));
  }

  @Test
  public void testCreate() {
    Organization created = getCreated();
    Organization actual = repository.save(created);
    Assertions.assertThat(actual).isEqualToIgnoringGivenFields(created, "id");
  }

  @Test
  public void testUpdate() {
    Organization updated = repository.get(ORG_ID3);
    updated.setIsActive(false);
    updated.setPhone("4991991999");
    Organization actual = repository.save(updated);
    TestUtil.assertMatch(actual, updated, ORG_ID3);
  }
}