package tk.djandjiev.practice.to.office;

import javax.validation.constraints.Size;

/**
 * DTO упрощенной сущности Office.
 * */
public class SimplifiedOfficeTO {

  private Integer id;

  @Size(max = 255)
  private String name;

  private Boolean isActive;

  public SimplifiedOfficeTO() {
  }

  public SimplifiedOfficeTO(Integer id,
      @Size(max = 255) String name, Boolean isActive) {
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
    return "SimplifiedOfficeTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", isActive=" + isActive +
        '}';
  }
}
