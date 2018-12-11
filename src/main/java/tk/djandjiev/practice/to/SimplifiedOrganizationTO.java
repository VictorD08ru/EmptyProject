package tk.djandjiev.practice.to;

import javax.validation.constraints.Size;

/**
 * DTO упрощенной сущности Organization.
 * */
public class SimplifiedOrganizationTO {
  private Integer id;

  @Size(max = 255)
  private String name;

  private Boolean isActive;

  public SimplifiedOrganizationTO() {
  }

  public SimplifiedOrganizationTO(Integer id, String name, Boolean isActive) {
    this.id = id;
    this.name = name;
    this.isActive = isActive;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  @Override
  public String toString() {
    return "SimplifiedOrganizationTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", isActive=" + isActive +
        '}';
  }
}
