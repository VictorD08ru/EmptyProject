package tk.djandjiev.practice.model;

import java.util.Objects;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Базовая сущность - общий абстрактный предок для всех моделей с полем id.
 * */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Integer id;

  public Integer getId() {
    return id;
  }

  @Override
  public String toString() {
    return String.format("Entity %s (%s)", getClass().getName(), id);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractBaseEntity that = (AbstractBaseEntity) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return id == null ? 0 : id;
  }
}
