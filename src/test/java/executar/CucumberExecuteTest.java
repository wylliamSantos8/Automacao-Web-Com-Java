package executar;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import drivers.web.DriverWeb;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(features = "src/test/resources/features/", 
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Evidencias/Status - Automacao de Testes.html",
				"pretty",
				"html:src/test/resources/relatorios/cucumber-reports/",
				"json:src/test/resources/relatorios/cucumber-reports/cucumber.json",
				"junit:src/test/resources/relatorios/cucumber-reports/Cucumber.xml"}, 
		glue = {""}, 
		tags = "@Desafio2", 
		snippets = SnippetType.CAMELCASE,
		monochrome = true, 
		dryRun = false, 
		strict = false)
public class CucumberExecuteTest {

	@BeforeClass
	public static void setarConfiguracoes() {
		new CriarDiretorio().validarDiretorio();
		new ValidarEvidencias().deletarPrints();
	}
	
	@AfterClass
	public static void fecharNavegador() {	
		DriverWeb.finalizarDriver();
	}
}