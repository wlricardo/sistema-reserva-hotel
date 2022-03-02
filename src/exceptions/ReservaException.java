package exceptions;

public class ReservaException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public ReservaException(String msg) {
        super(msg);
    }    
}