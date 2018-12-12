package tk.djandjiev.practice.to.office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeRequest {

  @NotNull
  private Integer orgId;

  @Size(max = 255)
  private String name;

  @Size(max = 20)
  private String phone;
  private Boolean isActive;

  public OfficeRequest() {
  }

  public OfficeRequest(@NotNull Integer orgId) {
    this.orgId = orgId;
  }

  public OfficeRequest(@NotNull Integer orgId,
      @Size(max = 255) String name,
      @Size(max = 20) String phone, Boolean isActive) {
    this.orgId = orgId;
    this.name = name;
    this.phone = phone;
    this.isActive = isActive;
  }

  public Integer getOrgId() {
    return orgId;
  }

  public void setOrgId(Integer orgId) {
    this.orgId = orgId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }
}
