package tk.djandjiev.practice.to.message;

/**
 * Класс-обертка сообщения об успешном выполнении операции.
 * */
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
