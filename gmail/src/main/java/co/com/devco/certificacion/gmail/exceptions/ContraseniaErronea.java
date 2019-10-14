package co.com.devco.certificacion.gmail.exceptions;

public class ContraseniaErronea extends AssertionError{

	public ContraseniaErronea (String message, Throwable cause) {
		super(message, cause);
	}
}
