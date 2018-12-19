package tk.djandjiev.practice.to.user;

import java.io.Serializable;
import javax.validation.constraints.Size;

/**
 * DTO упрощенной сущности User.
 * */
public class SimplifiedUserTO implements Serializable {

  private Integer id;

  @Size(max = 100)
  private String firstName;

  @Size(max = 100)
  private String secondName;

  @Size(max = 100)
  private String middleName;

  @Size(max = 255)
  private String position;

  public SimplifiedUserTO() {
  }

  public SimplifiedUserTO(Integer id,
      @Size(max = 100) String firstName,
      @Size(max = 100) String secondName,
      @Size(max = 100) String middleName,
      @Size(max = 255) String position) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.middleName = middleName;
    this.position = position;
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

  @Override
  public String toString() {
    return "SimplifiedUserTO{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + secondName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", position='" + position + '\'' +
        '}';
  }
}
