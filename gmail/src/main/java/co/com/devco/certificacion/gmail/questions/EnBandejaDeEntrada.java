package co.com.devco.certificacion.gmail.questions;


import static co.com.devco.certificacion.gmail.userinterfaces.BandejaDeEntrada.CORREOS_RECIBIDOS;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class EnBandejaDeEntrada implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		CORREOS_RECIBIDOS.resolveFor(actor).waitUntilPresent();
		return Text.of(CORREOS_RECIBIDOS).viewedBy(actor).asString().toLowerCase();
	}
	
	public static EnBandejaDeEntrada ExisTeLaPestania() {
		return new EnBandejaDeEntrada();
	}

}
