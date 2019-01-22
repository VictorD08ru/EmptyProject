package tk.djandjiev.practice.controller;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tk.djandjiev.practice.to.message.ErrorMessage;

@RestControllerAdvice
public class ExceptionHandleController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorMessage validationExceptionHandle(MethodArgumentNotValidException e) {
    FieldError fieldError = e.getBindingResult().getFieldError();
    String message = fieldError != null ? fieldError.getDefaultMessage() : e.getMessage();
    return new ErrorMessage(message);
  }

  @ExceptionHandler(Exception.class)
  public ErrorMessage exceptionHandle(Exception e) {
    return new ErrorMessage(e.getMessage());
  }
}
