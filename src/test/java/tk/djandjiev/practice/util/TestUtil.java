package tk.djandjiev.practice.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import tk.djandjiev.practice.model.AbstractBaseEntity;

public class TestUtil {
  public static <T extends AbstractBaseEntity> void assertMatch(
      T actual,
      T expected,
      Integer expectedId) {
    assertThat(actual).isEqualToIgnoringGivenFields(expected, "id");
    assertThat(actual.getId()).isEqualTo(expectedId);
  }

  public static <T extends AbstractBaseEntity> void assertMatch(
      Collection<T> actual,
      Collection<T> expected,
      Collection<Integer> expectedIds) {
    assertThat(actual).usingElementComparatorIgnoringFields("id").isEqualTo(expected);
    List<Integer> actualIds = actual
        .stream()
        .map(AbstractBaseEntity::getId)
        .collect(Collectors.toList());
    assertThat(actualIds).isEqualTo(expectedIds);
  }
}
