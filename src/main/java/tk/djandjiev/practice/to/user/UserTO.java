package tk.djandjiev.practice.to.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * DTO сущности User.
 * */
public class UserTO implements Serializable {

  private Integer id;

  @NotNull
  @Size(max = 100)
  private String firstName;

  @Size(max = 100)
  private String secondName;

  @Size(max = 100)
  private String middleName;

  @NotNull
  @Size(max = 255)
  private String position;

  @Size(max = 20)
  private String phone;

  @Size(max = 255)
  private String docName;

  @Size(max = 10)
  private String docCode;

  @Size(max = 20)
  private String docNumber;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate docDate;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Size(max = 255)
  private String citizenshipName;

  @Size(max = 10)
  private String citizenshipCode;
  private Boolean isIdentified;
  private Integer officeId;

  public UserTO() {
  }

  public UserTO(Integer id,
      @NotNull @Size(max = 100) String firstName,
      @Size(max = 100) String secondName,
      @Size(max = 100) String middleName,
      @NotNull @Size(max = 255) String position,
      @Size(max = 20) String phone,
      @Size(max = 255) String docName,
      @Size(max = 10) String docCode,
      @Size(max = 20) String docNumber, LocalDate docDate,
      @Size(max = 255) String citizenshipName,
      @Size(max = 10) String citizenshipCode, Boolean isIdentified, Integer officeId) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.middleName = middleName;
    this.position = position;
    this.phone = phone;
    this.docName = docName;
    this.docCode = docCode;
    this.docNumber = docNumber;
    this.docDate = docDate;
    this.citizenshipName = citizenshipName;
    this.citizenshipCode = citizenshipCode;
    this.isIdentified = isIdentified;
    this.officeId = officeId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getDocCode() {
    return docCode;
  }

  public void setDocCode(String docCode) {
    this.docCode = docCode;
  }

  public String getDocName() {
    return docName;
  }

  public void setDocName(String docName) {
    this.docName = docName;
  }

  public String getDocNumber() {
    return docNumber;
  }

  public void setDocNumber(String docNumber) {
    this.docNumber = docNumber;
  }

  public LocalDate getDocDate() {
    return docDate;
  }

  public void setDocDate(LocalDate docDate) {
    this.docDate = docDate;
  }

  public String getCitizenshipCode() {
    return citizenshipCode;
  }

  public void setCitizenshipCode(String citizenshipCode) {
    this.citizenshipCode = citizenshipCode;
  }

  public Boolean getIsIdentified() {
    return isIdentified;
  }

  public void setIsIdentified(Boolean isIdentified) {
    this.isIdentified = isIdentified;
  }

  public Integer getOfficeId() {
    return officeId;
  }

  public void setOfficeId(Integer officeId) {
    this.officeId = officeId;
  }

  public String getCitizenshipName() {
    return citizenshipName;
  }

  public void setCitizenshipName(String citizenshipName) {
    this.citizenshipName = citizenshipName;
  }

  @Override
  public String toString() {
    return "UserTO{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", secondName='" + secondName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", position='" + position + '\'' +
        ", phone='" + phone + '\'' +
        ", docCode='" + docCode + '\'' +
        ", docName='" + docName + '\'' +
        ", docNumber='" + docNumber + '\'' +
        ", docDate=" + docDate +
        ", citizenshipName='" + citizenshipName + '\'' +
        ", citizenshipCode='" + citizenshipCode + '\'' +
        ", isIdentified=" + isIdentified +
        ", officeId=" + officeId +
        '}';
  }
}
