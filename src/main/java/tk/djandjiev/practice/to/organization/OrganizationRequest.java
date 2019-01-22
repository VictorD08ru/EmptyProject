package tk.djandjiev.practice.to.organization;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Сущность параметров запроса Organization.
 * */
public class OrganizationRequest implements Serializable {

  @NotNull(message = "name can not be null")
  @Size(max = 255)
  private String name;

  @Pattern(regexp = "\\d{0,10}", message = "INN must contain only digits")
  @Size(max = 10)
  private String inn;

  private Boolean isActive;

  public OrganizationRequest() {
  }

  public OrganizationRequest(@NotNull String name) {
    this.name = name;
  }

  public OrganizationRequest(@NotNull String name, String inn, Boolean isActive) {
    this(name);
    this.inn = inn;
    this.isActive = isActive;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInn() {
    return inn;
  }

  public void setInn(String inn) {
    this.inn = inn;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  @Override
  public String toString() {
    return "OrganizationRequest{" +
        "name='" + name + '\'' +
        ", inn='" + inn + '\'' +
        ", isActive=" + isActive +
        '}';
  }
}
