package co.com.devco.certificacion.gmail.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import java.util.List;
import co.com.devco.certificacion.gmail.exceptions.InicioDeSesionInvalido;
import co.com.devco.certificacion.gmail.exceptions.ContraseniaErronea;
import co.com.devco.certificacion.gmail.exceptions.CorreoElectronicoErroneo;
import co.com.devco.certificacion.gmail.models.DatosInicioSesion;
import co.com.devco.certificacion.gmail.questions.EnBandejaDeEntrada;
import co.com.devco.certificacion.gmail.questions.MensajeErrorContrasenia;
import co.com.devco.certificacion.gmail.questions.MensajeErrorCorreoElectronico;
import co.com.devco.certificacion.gmail.tasks.IngresarContrasenia;
import co.com.devco.certificacion.gmail.tasks.IngresarCorreoElectronico;
import co.com.devco.certificacion.gmail.utils.drivers.SuDriver;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class InicioSesionStepDefinitions {
	
	@Before
	public void Inicio() {
		OnStage.setTheStage(OnlineCast.ofStandardActors());	
	}
	
	@Dado("^que el (.*) se encuentra en la página de inicio de sesión de Gmail$")
	public void queElAnalistaSeEncuentraEnLaPáginaDeInicioDeSesiónDeGmail(String actorName) {
		theActorCalled(actorName).can(BrowseTheWeb.with(SuDriver.Chrome().enGmail()));
	}


	@Cuando("^el Analista inicia sesión$")
	public void elAnalistaIniciaSesión(List<DatosInicioSesion> ListaDatosInicioSesion) {
		theActorInTheSpotlight().attemptsTo(IngresarCorreoElectronico.conCredencial(ListaDatosInicioSesion),
				IngresarContrasenia.conCredencial(ListaDatosInicioSesion));
	}
	
	@Entonces("^deberá visualizar los correos (.*)$")
	public void deberáVisualizarLosCorreosRecibidos(String resutadoEsperado) {
		theActorInTheSpotlight().should(seeThat(EnBandejaDeEntrada.ExisTeLaPestania(), equalTo(resutadoEsperado))
				.orComplainWith(InicioDeSesionInvalido.class, "NO SE PUDO INICIAR SESION - CREDENCIALES INCORRECTAS"));
	}
	
	@Cuando("^el Analista ingresa un email inválido$")
	public void elAnalistaIngresaUnEmailInválido(List<DatosInicioSesion> ListaDatosInicioSesion) {
		theActorInTheSpotlight().attemptsTo(IngresarCorreoElectronico.conCredencial(ListaDatosInicioSesion));
	}
	
	@Entonces("^deberá visualizar mensaje de error de correo electrónico inválido$")
	public void deberáVisualizarMensajeDeErrorDeCorreoElectrónicoInválido() {
		theActorInTheSpotlight().should(seeThat(MensajeErrorCorreoElectronico.is(), equalTo("Ingresa un número de teléfono o correo electrónico válidos"))
		.orComplainWith(CorreoElectronicoErroneo.class, "CAMPO DE EMAIL EN BLANCO O CUENTA NO ENCONTRADA"));
	}
	
	@Cuando("^el Analista ingresa una contraseña incorrecta$")
	public void elAnalistaIngresaUnaContraseñaIncorrecta(List<DatosInicioSesion> ListaDatosInicioSesion) {
		theActorInTheSpotlight().attemptsTo(IngresarCorreoElectronico.conCredencial(ListaDatosInicioSesion),
			IngresarContrasenia.conCredencial(ListaDatosInicioSesion));	
	}


	@Entonces("^deberá visualizar mensaje de error de contraseña incorrecta$")
	public void deberáVisualizarMensajeDeErrorDeContraseñaIncorrecta() {
		theActorInTheSpotlight().should(seeThat(MensajeErrorContrasenia.is(), equalTo("La contraseña es incorrecta. Vuelve a intentarlo o haz clic en ¿Olvidaste la contraseña? para restablecerla."))
		.orComplainWith(ContraseniaErronea.class, "EMAIL EN BLANCO, INVALIDO O NO ENCONTRADO"));
	}
	
	@Cuando("^el Analista deja el campo de correo electrónico en blanco$")
	public void elAnalistaDejaElCampoDeCorreoElectrónicoEnBlanco(List<DatosInicioSesion> ListaDatosInicioSesion) {
		theActorInTheSpotlight().attemptsTo(IngresarCorreoElectronico.conCredencial(ListaDatosInicioSesion));
	}


	@Entonces("^deberá visualizar mensaje de error para introducir dirección de correo electrónico$")
	public void deberáVisualizarMensajeDeErrorParaIntroducirDirecciónDeCorreoElectrónico() {
		theActorInTheSpotlight().should(seeThat(MensajeErrorCorreoElectronico.is(), equalTo("Ingresa un correo electrónico o número de teléfono"))
		.orComplainWith(CorreoElectronicoErroneo.class, "EL CAMPO DE CORREO ELECTRÓNICO FUE DILIGENCIADO"));
	}

	@Cuando("^el Analista deja el campo de contraseña en blanco$")
	public void elAnalistaDejaElCampoDeContraseñaEnBlanco(List<DatosInicioSesion> ListaDatosInicioSesion) {
		theActorInTheSpotlight().attemptsTo(IngresarCorreoElectronico.conCredencial(ListaDatosInicioSesion),
		IngresarContrasenia.conCredencial(ListaDatosInicioSesion));	
	}

	@Entonces("^deberá visualizar mensaje de error para introducir una contraseña$")
	public void deberáVisualizarMensajeDeErrorParaIntroducirUnaContraseña() {
		theActorInTheSpotlight().should(seeThat(MensajeErrorContrasenia.is(), equalTo("Ingresar una contraseña"))
		.orComplainWith(ContraseniaErronea.class, "EMAIL EN BLANCO, INVALIDO, NO ENCONTRADO O SE HA INGRESADO CONTRASEÑA "));
	}

}
