package interfaces.web;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import drivers.web.DriverWeb;
import interfaces.log.LogWeb;

public interface IAlert {

	static Logger logger = LogWeb.getLogger(IAlert.class);

	default void aceitarAlerta() {
		try {
			logger.info("Realizar a ação do método [aceitarAlerta] na tela.");
			Alert alert = DriverWeb.getDriver().switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			logger.error(" -- ERRO: NAO ha alerta presente na tela.");
			Assert.fail(LocalDateTime.now() + " NAO ha alerta presente na tela.");
		} catch (Exception e) {
			logger.error(" -- ERRO: erro ao aceitar alerta:" + e.getMessage());
			Assert.fail(LocalDateTime.now() + "erro ao aceitar alerta: " + e.getMessage());
		}
	}

	default void escreverNoAlerta(String texto) {
		try {
			logger.info(String.format("Realizar a ação do método [escreverNoAlerta] com o texto [%s].", texto));
			Alert alert = DriverWeb.getDriver().switchTo().alert();
			alert.sendKeys(texto);
		} catch (Exception e) {
			logger.error(" -- ERRO: erro ao escrever o texto: " + texto + " no alerta:" + e.getMessage());
			Assert.fail(LocalDateTime.now() + " erro ao escrever o texto: " + texto + " no alerta: " + e.getMessage());
		}
	}
}