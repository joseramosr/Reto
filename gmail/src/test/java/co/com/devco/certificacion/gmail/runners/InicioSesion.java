package co.com.devco.certificacion.gmail.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import cucumber.api.SnippetType;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ="src/test/resources/features/inicio_sesion.feature",
snippets = SnippetType.CAMELCASE,
glue="co.com.devco.certificacion.gmail.stepdefinitions")

public class InicioSesion {

}
