package executar;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import drivers.web.DriverWeb;
import interfaces.web.IPrint;

public class ComplementosAfter implements IPrint {

	@After
	public void tearDown(Scenario cenario) throws IOException {

		DriverWeb.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		String printPath = printAndSave(cenario);
		Reporter.addScreenCaptureFromPath(printPath, "Evidencias");
		System.out.println("RESULTADO: \n" + retornaStatusCenario(cenario));
		DriverWeb.finalizarDriver();

	}

	private String retornaStatusCenario(Scenario scenario) {
		String texto = null;
		if (scenario.getStatus().contentEquals("passed")) {
			texto = retornaStatusPositivo().toString();
		} else {
			texto = retornaStatusNegativo().toString();
		}
		return texto;
	}

	private StringBuffer retornaStatusPositivo() {
		StringBuffer stringBuilder = new StringBuffer();
		stringBuilder.append("╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗╔╗─╔╗\n");
		stringBuilder.append("║╔═╗║║╔═╗║║╔═╗║║╔═╗║║╔═╗║║║─║║\n");
		stringBuilder.append("║╚═╝║║║─║║║╚══╗║╚══╗║║─║║║║─║║\n");
		stringBuilder.append("║╔══╝║╚═╝║╚══╗║╚══╗║║║─║║║║─║║\n");
		stringBuilder.append("║║───║╔═╗║║╚═╝║║╚═╝║║╚═╝║║╚═╝║\n");
		stringBuilder.append("╚╝───╚╝─╚╝╚═══╝╚═══╝╚═══╝╚═══╝\n");
		return stringBuilder;
	}

	private StringBuffer retornaStatusNegativo() {
		StringBuffer stringBuilder = new StringBuffer();
		stringBuilder.append("╔═══╗╔═══╗╔╗───╔╗─╔╗╔═══╗╔╗─╔╗\n");
		stringBuilder.append("║╔══╝║╔═╗║║║───║║─║║║╔═╗║║║─║║\n");
		stringBuilder.append("║╚══╗║║─║║║║───║╚═╝║║║─║║║║─║║\n");
		stringBuilder.append("║╔══╝║╚═╝║║║─╔╗║╔═╗║║║─║║║║─║║\n");
		stringBuilder.append("║║───║╔═╗║║╚═╝║║║─║║║╚═╝║║╚═╝║\n");
		stringBuilder.append("╚╝───╚╝─╚╝╚═══╝╚╝─╚╝╚═══╝╚═══╝\n");
		return stringBuilder;
	}

}
