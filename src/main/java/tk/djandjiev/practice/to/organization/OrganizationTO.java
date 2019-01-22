package tk.djandjiev.practice.to.organization;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import tk.djandjiev.practice.util.View;

/**
 * DTO сущности Organization.
 * */
public class OrganizationTO {

  @NotNull(groups = View.Updateable.class, message = "id can not be null")
  private Integer id;

  @Size(max = 255)
  @NotBlank(message = "name can not be null")
  private String name;

  @Size(max = 255)
  @NotBlank(message = "full name can not be null")
  private String fullName;

  @Pattern(regexp = "\\d{10}", message = "field INN must contain only 10 digits")
  @NotBlank(message = "INN can not be null")
  private String inn;

  @Pattern(regexp = "\\d{9}", message = "field KPP must contain only 9 digits")
  @NotBlank(message = "KPP can not be null")
  private String kpp;

  @Size(max = 255)
  @NotBlank(message = "address can not be null")
  private String address;

  @Size(max = 20)
  private String phone;

  private Boolean isActive;

  public OrganizationTO() {
  }

  public OrganizationTO(Integer id, String name, String fullName, String inn, String kpp,
      String address, String phone, Boolean isActive) {
    this.id = id;
    this.name = name;
    this.fullName = fullName;
    this.inn = inn;
    this.kpp = kpp;
    this.address = address;
    this.phone = phone;
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

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getInn() {
    return inn;
  }

  public void setInn(String inn) {
    this.inn = inn;
  }

  public String getKpp() {
    return kpp;
  }

  public void setKpp(String kpp) {
    this.kpp = kpp;
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

  @Override
  public String toString() {
    return "OrganizationTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", fullName='" + fullName + '\'' +
        ", inn='" + inn + '\'' +
        ", kpp='" + kpp + '\'' +
        ", address='" + address + '\'' +
        ", phone='" + phone + '\'' +
        ", isActive=" + isActive +
        '}';
  }
}
