package interfaces.web;

import java.io.File;
import java.time.LocalDateTime;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import cucumber.api.Scenario;
import drivers.web.DriverWeb;
import util.FileHelper;

public interface IPrint {

	default String printAndSave(Scenario scenario) {

		String pastaDeEvidencias = FileHelper.projectFolder("Evidencias");
		String pastaSucesso = FileHelper.projectFolder("Evidencias", "Prints_Sucesso");
		String pastaErro = FileHelper.projectFolder("Evidencias", "Prints_Erro");
		String destino;
		String nome = LocalDateTime.now().toString().replace("-", "_").replace(":", "_").replace("\\.", "_")
				.replace("T", "_");

		IUtils utils = new IUtils() {
		};
		IEspera espera = new IEspera() {
		};

		espera.esperarPaginaSerCarregada(60);

		try {
			utils.diretorioExiste(pastaDeEvidencias);

			if (scenario.isFailed()) {
				destino = pastaErro;
				utils.diretorioExiste(destino);
				Shutterbug.shootPage(DriverWeb.getDriver(), ScrollStrategy.WHOLE_PAGE_CHROME, 5000, true).withName(nome)
						.save(destino);
				return "Prints_Erro" + File.separator + nome + ".png";

			} else {
				destino = pastaSucesso;
				utils.diretorioExiste(destino);
				Shutterbug.shootPage(DriverWeb.getDriver(), ScrollStrategy.WHOLE_PAGE_CHROME, 5000, true).withName(nome)
						.save(destino);
				return "Prints_Sucesso" + File.separator + nome + ".png";
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Ocorreu um erro inesperado.");
		}
	}

}
