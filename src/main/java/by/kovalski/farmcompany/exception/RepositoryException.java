package by.kovalski.farmcompany.exception;

public class RepositoryException extends Exception{
  public RepositoryException(String message) {
    super(message);
  }

  public RepositoryException() {
    super();
  }

  public RepositoryException(Throwable cause) {
    super(cause);
  }

  public RepositoryException(String message, Throwable cause) {
    super(message, cause);
  }
}
