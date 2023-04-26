package interfaces.web;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.web.DriverWeb;
import interfaces.log.LogWeb;

public interface IClique {
	static Logger logger = LogWeb.getLogger(IClique.class);
	long TIMEOUT = 40;

	default Boolean clicar(By elemento) {
		try {
			logger.info(String.format("Realizar a ação do método [clicar] com o elemento [%s].", elemento));
			DriverWeb.getDriver().manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
			new WebDriverWait(DriverWeb.getDriver(), TIMEOUT).until(ExpectedConditions.elementToBeClickable(elemento))
					.click();
		} catch (NoSuchElementException e) {
			logger.error(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.error(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.error(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		} catch (Exception e) {
			logger.error(" -- ERRO: erro ao clicar no elemento:" + elemento);
			Assert.fail(LocalDateTime.now() + "erro ao clicar no elemento:" + elemento);
		}
		return true;
	}

}