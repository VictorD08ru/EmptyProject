package tk.djandjiev.practice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Сущность пользователя.
 * */
@Entity
@Table(indexes = {
    @Index(
        name = "ix_user_first_name",
        columnList = "first_name")
})
public class User extends AbstractBaseEntity {

  @NotBlank
  @Size(max = 100)
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Size(max = 100)
  @Column(name = "second_name")
  private String secondName;

  @Size(max = 100)
  @Column(name = "middle_name")
  private String middleName;

  @NotBlank
  @Size(max = 255)
  @Column(name = "position", nullable = false)
  private String position;

  @Size(max = 20)
  @Column(name = "phone")
  private String phone;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "doc_id")
  private Document document;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "country_id")
  private Country country;

  @Column(name = "is_identified")
  private Boolean isIdentified;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "office_id")
  private Office office;

  public User() {
  }

  public User(
      @NotBlank @Size(max = 100) String firstName,
      @Size(max = 100) String secondName,
      @Size(max = 100) String middleName,
      @NotBlank @Size(max = 255) String position,
      @Size(max = 20) String phone, Document document, Country country,
      @NotNull Boolean isIdentified, Office office) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.middleName = middleName;
    this.position = position;
    this.phone = phone;
    this.document = document;
    this.country = country;
    this.isIdentified = isIdentified;
    this.office = office;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Document getDocument() {
    return document;
  }

  public void setDocument(Document document) {
    this.document = document;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public Boolean getisIdentified() {
    return isIdentified;
  }

  public void setisIdentified(Boolean isIdentified) {
    this.isIdentified = isIdentified;
  }

  public Office getOffice() {
    return office;
  }

  public void setOffice(Office office) {
    this.office = office;
  }
}
