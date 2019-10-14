package co.com.devco.certificacion.gmail.exceptions;

public class CorreoElectronicoErroneo extends AssertionError{
	
	public CorreoElectronicoErroneo (String message, Throwable cause) {
		super(message, cause);
	}
}
