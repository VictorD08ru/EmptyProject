package tk.djandjiev.practice.to.message;

public class SuccessMessage {

  private String result = "success";

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "SuccessMessage{'" + result + "'}";
  }
}
