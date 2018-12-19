package tk.djandjiev.practice.to;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * DTO сущности DocType.
 * */
public class DocTypeTO implements Serializable {

  @Size(max = 255)
  @NotBlank(message = "name cannot be null")
  private String name;

  @Size(max = 10)
  @NotBlank(message = "code cannot be null")
  private String code;

  public DocTypeTO() {
  }

  public DocTypeTO(
      @Size(max = 255) @NotBlank(message = "name cannot be null") String name,
      @Size(max = 10) @NotBlank(message = "code cannot be null") String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "DocTypeTO{" +
        "name='" + name + '\'' +
        ", code='" + code + '\'' +
        '}';
  }
}
