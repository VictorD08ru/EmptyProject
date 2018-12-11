package tk.djandjiev.practice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
        name = "user_first_name_index",
        columnList = "first_name")
})
@NamedQueries({
    @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u ORDER BY u.firstName")
})
public class User extends AbstractBaseEntity {

  public static final String ALL_SORTED = "User.getAllSorted";

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

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
  @JoinColumn(name = "doc_id")
  private Document document;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
  @JoinColumn(name = "country_id")
  private Document country;

  @NotNull
  @Column(name = "is_defined", nullable = false)
  private Boolean isDefined;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
  @JoinColumn(name = "office_id")
  private Office office;

  public User() {
  }

  public User(
      @NotBlank @Size(max = 100) String firstName,
      @Size(max = 100) String secondName,
      @Size(max = 100) String middleName,
      @NotBlank @Size(max = 255) String position,
      @Size(max = 20) String phone, Document document, Document country,
      @NotNull Boolean isDefined, Office office) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.middleName = middleName;
    this.position = position;
    this.phone = phone;
    this.document = document;
    this.country = country;
    this.isDefined = isDefined;
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

  public Document getCountry() {
    return country;
  }

  public void setCountry(Document country) {
    this.country = country;
  }

  public Boolean getDefined() {
    return isDefined;
  }

  public void setDefined(Boolean defined) {
    isDefined = defined;
  }

  public Office getOffice() {
    return office;
  }

  public void setOffice(Office office) {
    this.office = office;
  }
}
