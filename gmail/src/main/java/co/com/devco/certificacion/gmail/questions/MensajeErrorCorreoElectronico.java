package co.com.devco.certificacion.gmail.questions;

import static co.com.devco.certificacion.gmail.userinterfaces.InicioSesionCorreoElectronico.MESAJE_ERROR_EMAIL;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MensajeErrorCorreoElectronico implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(MESAJE_ERROR_EMAIL).viewedBy(actor).asString();
	}
	
	public static MensajeErrorCorreoElectronico is() {
		return new MensajeErrorCorreoElectronico();
	}

}
