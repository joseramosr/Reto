package co.com.devco.certificacion.gmail.tasks;

import static co.com.devco.certificacion.gmail.userinterfaces.InicioSesionCorreoElectronico.BTN_SIGUIENTE_EMAIL;
import static co.com.devco.certificacion.gmail.userinterfaces.InicioSesionCorreoElectronico.EMAIL;

import java.util.List;

import co.com.devco.certificacion.gmail.models.DatosInicioSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarCorreoElectronico implements Task{
	
	private List<DatosInicioSesion> listDatosInicioSesion;
	
	public IngresarCorreoElectronico(List<DatosInicioSesion> listDatosInicioSesion) {
		this.listDatosInicioSesion = listDatosInicioSesion;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(listDatosInicioSesion.get(0).getEmail()).into(EMAIL),
				Click.on(BTN_SIGUIENTE_EMAIL));
		
	}
	
	public static IngresarCorreoElectronico conCredencial(List<DatosInicioSesion> listDatosInicioSesion) {
		return Tasks.instrumented(IngresarCorreoElectronico.class, listDatosInicioSesion);
	}
	
	
	
}
