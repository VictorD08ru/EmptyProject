package tk.djandjiev.practice.to.message;

/**
 * Класс-обертка для выходных данных.
 * */
public class DataMessage<T> {

  private T data;

  public DataMessage() {
  }

  public DataMessage(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "DataMessage{" + data + '}';
  }
}
