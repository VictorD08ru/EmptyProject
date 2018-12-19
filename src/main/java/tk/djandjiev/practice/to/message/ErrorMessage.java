package tk.djandjiev.practice.to.message;

public class ErrorMessage {

  private String error;

  public String getError() {
    return error;
  }

  public ErrorMessage(String error) {
    this.error = error;
  }

  @Override
  public String toString() {
    return "ErrorMessage{'" + error + "'}";
  }
}
