package tk.djandjiev.practice.to.office;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import tk.djandjiev.practice.util.View;

/**
 * DTO сущности Office.
 * */
public class OfficeTO implements Serializable {

  @NotNull(groups = View.Updateable.class, message = "id can not be null")
  private Integer id;

  @NotNull(groups = View.Updateable.class, message = "name can not be null")
  @Size(max = 255)
  private String name;

  @NotNull(groups = View.Updateable.class, message = "address can not be null")
  @Size(max = 255)
  private String address;

  @Size(max = 20)
  private String phone;

  private Boolean isActive;

  @NotNull(groups = View.Saveable.class, message = "orgId can not be null")
  private Integer orgId;

  public OfficeTO() {
  }

  public OfficeTO(Integer id, @Size(max = 255) String name,
      @Size(max = 255) String address,
      @Size(max = 20) String phone, Boolean isActive, Integer orgId) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.isActive = isActive;
    this.orgId = orgId;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  public Integer getOrgId() {
    return orgId;
  }

  public void setOrgId(Integer orgId) {
    this.orgId = orgId;
  }

  @Override
  public String toString() {
    return "OfficeTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", phone='" + phone + '\'' +
        ", isActive=" + isActive +
        ", orgId=" + orgId +
        '}';
  }
}
