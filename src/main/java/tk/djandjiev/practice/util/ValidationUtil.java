package tk.djandjiev.practice.util;

import org.springframework.util.Assert;
import tk.djandjiev.practice.model.AbstractBaseEntity;

/**
 * Класс упрощения валидации объектов.
 * */
public class ValidationUtil {

  private ValidationUtil() {}

  public static <T> void notNull(T obj) {
    Assert.notNull(obj, obj + "must not be null");
  }

  public static <T extends AbstractBaseEntity> boolean isNew(T obj) {
    return obj.getId() == null;
  }
}
