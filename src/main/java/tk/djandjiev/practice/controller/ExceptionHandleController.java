package tk.djandjiev.practice.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tk.djandjiev.practice.to.message.ErrorMessage;

@RestControllerAdvice
public class ExceptionHandleController {

  @JsonProperty("error")
  @ExceptionHandler(Exception.class)
  public ErrorMessage exceptionHandle(Exception e) {
    return new ErrorMessage(e.getMessage());
  }
}
