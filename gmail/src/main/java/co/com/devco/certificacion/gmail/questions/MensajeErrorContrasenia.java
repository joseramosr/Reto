package co.com.devco.certificacion.gmail.questions;

import static co.com.devco.certificacion.gmail.userinterfaces.InicioSesionContrasenia.MESAJE_ERROR_CONTRASENIA;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MensajeErrorContrasenia implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(MESAJE_ERROR_CONTRASENIA).viewedBy(actor).asString().replaceAll("\"", "");
	}
	
	public static MensajeErrorContrasenia is() {
		return new MensajeErrorContrasenia();
	}
}
