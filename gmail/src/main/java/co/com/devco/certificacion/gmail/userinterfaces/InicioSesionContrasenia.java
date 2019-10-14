package co.com.devco.certificacion.gmail.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InicioSesionContrasenia {
	
	public static final Target CONTRASENIA = Target.the("Campo contraseña")
			.locatedBy("//input[@name='password']");
	
	public static final Target BTN_SIGUIENTE_CONTRASENIA = Target.the("Botón Siguiente contraseña")
			.locatedBy("//div[@id='passwordNext']");
	
	public static final Target MESAJE_ERROR_CONTRASENIA = Target.the("Mensaje de error de contraseña")
			.locatedBy("//div[@jsname='B34EJ']/span");
}
