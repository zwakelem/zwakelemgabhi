package za.co.discovery.assignment.zwakelemgabhi.exception;

/**
 * Thrown to indicate that a Node does not exist
 */
public class NodeDoesNotExistException extends RuntimeException {

  /**
   * Constructor that takes message
   *
   * @param message detailed description of the Exception
   */
  public NodeDoesNotExistException(String message) {
    super(message);
  }

}
