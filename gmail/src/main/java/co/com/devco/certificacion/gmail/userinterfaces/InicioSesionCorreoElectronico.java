package co.com.devco.certificacion.gmail.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InicioSesionCorreoElectronico {
	
	public static final Target EMAIL = Target.the("Campo correo electrónico")
			.locatedBy("//input[@id='identifierId']");
	
	public static final Target BTN_SIGUIENTE_EMAIL = Target.the("Botón Siguiente correo electrónico")
			.locatedBy("//div[@id='identifierNext']");
	
	public static final Target MESAJE_ERROR_EMAIL = Target.the("Mensaje de error de correo electrónico")
			.locatedBy("//div[@class='GQ8Pzc']");
}
