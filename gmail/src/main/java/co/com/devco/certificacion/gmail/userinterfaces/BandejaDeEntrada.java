package co.com.devco.certificacion.gmail.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BandejaDeEntrada {
	
	public static final Target CORREOS_RECIBIDOS = Target.the("Pestaña de correos recibidos")
			.locatedBy("//a[@title='Recibidos']");

}
