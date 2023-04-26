package executar;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import drivers.web.DriverWeb;
import enums.Browser;

public class ComplementosBefore {
	
	public static Scenario cenario;

	@Before
	public void before(Scenario scenario) {
		DriverWeb.getDriver(Browser.CHROME, false);
		DriverWeb.getDriver().manage().deleteAllCookies();
		cenario = scenario;
	}
}