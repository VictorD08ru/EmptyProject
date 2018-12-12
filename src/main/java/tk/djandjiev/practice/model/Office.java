package tk.djandjiev.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Сущность офиса соответствующей организации.
 * */
@Entity
@Table(indexes = {
    @Index(
        name = "office_name_index",
        columnList = "name")
})
@NamedQueries({
    @NamedQuery(name = Office.ALL_SORTED, 
        query = "SELECT o FROM Office o WHERE o.organization.id = ?1 ORDER BY o.name")
})
public class Office extends AbstractBaseEntity {
  
  public static final String ALL_SORTED = "Office.getAllSorted";

  @NotBlank
  @Size(max = 255)
  @Column(name = "name", nullable = false)
  private String name;

  @NotBlank
  @Size(max = 255)
  @Column(name = "address", nullable = false)
  private String address;

  @Size(max = 20)
  @Column(name = "phone")
  private String phone;

  @Column(name = "is_active", nullable = false)
  private Boolean isActive;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "organization_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Organization organization;

  public Office() {
  }

  public Office(
      @NotBlank @Size(max = 255) String name,
      @NotBlank @Size(max = 255) String address,
      @Size(max = 20) String phone, @NotNull Boolean isActive,
      @NotNull Organization organization) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.isActive = isActive;
    this.organization = organization;
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

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }
}
