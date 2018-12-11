package tk.djandjiev.practice.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Абстрактная сущность справочника.
 * */
@MappedSuperclass
public abstract class AbstractCatalog extends AbstractBaseEntity {
  @NotBlank
  @Size(max = 10)
  @Column(name = "code", nullable = false)
  protected String code;

  @Size(max = 255)
  @Column
  protected String name;

  protected AbstractCatalog() {
  }

  protected AbstractCatalog(
      @NotBlank @Size(max = 10) String code,
      @Size(max = 255) String name) {
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("Catalog %s (%s, %s:'%s')", getClass().getName(), id, code, name);
  }
}
