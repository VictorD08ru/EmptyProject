package tk.djandjiev.practice.to.organization;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Сущность параметров запроса Organization.
 * */
public class OrganizationRequest implements Serializable {

  @NotNull
  @Size(max = 255)
  private String name;

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
}
