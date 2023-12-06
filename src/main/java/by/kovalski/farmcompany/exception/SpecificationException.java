package by.kovalski.farmcompany.exception;

public class SpecificationException extends Exception{


  public SpecificationException(String message) {
    super(message);
  }

  public SpecificationException(String message, Throwable cause) {
    super(message, cause);
  }
}
