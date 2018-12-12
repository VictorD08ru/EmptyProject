package tk.djandjiev.practice.to.organization;

import javax.validation.constraints.NotNull;

public class OrganizationRequest {

  @NotNull
  private String name;
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
