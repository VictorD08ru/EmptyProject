package tk.djandjiev.practice.to.office;


public class OfficeTO {

  private Integer id;
  private String name;
  private String address;
  private String phone;
  private Boolean isActive;
  private Integer orgId;

  public OfficeTO() {
  }

  public OfficeTO(Integer id, String name, String address, String phone, Boolean isActive,
      Integer orgId) {
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
