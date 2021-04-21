package exceptions;

public class UnsuccessfulConnectionException extends RuntimeException {

    public UnsuccessfulConnectionException(String message) {
        super (message);
    }
}
