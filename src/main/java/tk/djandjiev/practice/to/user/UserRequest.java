package tk.djandjiev.practice.to.user;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Сущность параметров запроса User.
 * */
public class UserRequest implements Serializable {

  @NotNull(message = "officeId can not be null")
  private Integer officeId;

  @Size(max = 100)
  private String firstName;

  @Size(max = 100)
  private String lastName;

  @Size(max = 100)
  private String middleName;

  @Size(max = 255)
  private String position;

  @Size(max = 10)
  private String docCode;

  @Size(max = 10)
  private String citizenshipCode;

  public UserRequest() {
  }

  public UserRequest(@NotNull Integer officeId) {
    this.officeId = officeId;
  }

  public UserRequest(@NotNull Integer officeId,
      @Size(max = 100) String firstName,
      @Size(max = 100) String lastName,
      @Size(max = 100) String middleName,
      @Size(max = 255) String position,
      @Size(max = 10) String docCode,
      @Size(max = 10) String citizenshipCode) {
    this.officeId = officeId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.position = position;
    this.docCode = docCode;
    this.citizenshipCode = citizenshipCode;
  }

  public Integer getOfficeId() {
    return officeId;
  }

  public void setOfficeId(Integer officeId) {
    this.officeId = officeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  public String getDocCode() {
    return docCode;
  }

  public void setDocCode(String docCode) {
    this.docCode = docCode;
  }

  public String getCitizenshipCode() {
    return citizenshipCode;
  }

  public void setCitizenshipCode(String citizenshipCode) {
    this.citizenshipCode = citizenshipCode;
  }

  @Override
  public String toString() {
    return "UserRequest{" +
        "officeId=" + officeId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", position='" + position + '\'' +
        ", docCode='" + docCode + '\'' +
        ", citizenshipCode='" + citizenshipCode + '\'' +
        '}';
  }
}
