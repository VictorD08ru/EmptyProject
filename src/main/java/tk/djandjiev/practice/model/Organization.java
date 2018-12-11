package tk.djandjiev.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Сущность организации.
 * */
@Entity
@Table(indexes = {
    @Index(
        name = "organization_name_index",
        columnList = "name"),
    @Index(
        name = "organization_name_inn_unique_index",
        columnList = "name, inn",
        unique = true)
})
public class Organization extends AbstractBaseEntity {

  @NotBlank
  @Size(max = 255)
  @Column(name = "name", nullable = false)
  private String name;

  @NotBlank
  @Size(max = 255)
  @Column(name = "full_name", nullable = false)
  private String fullName;

  @NotBlank
  @Size(min = 10, max = 10)
  @Column(name = "inn", nullable = false)
  private String inn;

  @NotBlank
  @Size(min = 9, max = 9)
  @Column(name = "kpp", nullable = false)
  private String kpp;

  @NotBlank
  @Size(max = 255)
  @Column(name = "address", nullable = false)
  private String address;

  @Size(max = 20)
  @Column(name = "phone")
  private String phone;

  @Column(name = "is_active", columnDefinition = "boolean default true")
  private Boolean isActive;

  public Organization() {
  }

  public Organization(
      @NotBlank @Size(max = 255) String name,
      @NotBlank @Size(max = 255) String fullName,
      @NotBlank @Size(min = 10, max = 10) String inn,
      @NotBlank @Size(min = 9, max = 9) String kpp,
      @NotBlank @Size(max = 255) String address,
      @Size(max = 20) String phone, Boolean isActive) {
    this.name = name;
    this.fullName = fullName;
    this.inn = inn;
    this.kpp = kpp;
    this.address = address;
    this.phone = phone;
    this.isActive = isActive;
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
}
