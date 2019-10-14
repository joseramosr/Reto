package co.com.devco.certificacion.gmail.tasks;

import static co.com.devco.certificacion.gmail.userinterfaces.InicioSesionContrasenia.BTN_SIGUIENTE_CONTRASENIA;
import static co.com.devco.certificacion.gmail.userinterfaces.InicioSesionContrasenia.CONTRASENIA;
import java.util.List;
import co.com.devco.certificacion.gmail.models.DatosInicioSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarContrasenia implements Task{
	
	private List<DatosInicioSesion> listDatosInicioSesion;
	
	public IngresarContrasenia(List<DatosInicioSesion> listDatosInicioSesion) {
		this.listDatosInicioSesion = listDatosInicioSesion;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(listDatosInicioSesion.get(0).getContrasenia()).into(CONTRASENIA),
				Click.on(BTN_SIGUIENTE_CONTRASENIA));
	}
	
	public static IngresarContrasenia conCredencial(List<DatosInicioSesion> listDatosInicioSesion) {
		return Tasks.instrumented(IngresarContrasenia.class, listDatosInicioSesion);
	}
}
