package interfaces.web;

import static interfaces.web.IEspera.TIMEOUT;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import drivers.web.DriverWeb;
import interfaces.log.LogWeb;

public interface IProcurar {
	static Logger logger = LogWeb.getLogger(IProcurar.class);


	default boolean procurarElemento(By elemento) {
		boolean retorno = false;
		try {			
			logger.info(String.format("Realizar a ação do método [procurarElemento] com o elemento [%s].", elemento));
			retorno = DriverWeb.getDriver().findElement(elemento) != null;
		} catch (NoSuchElementException e) {
			logger.error(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.error(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.error(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
		return retorno;
	}
	
	default boolean existe(By by) {
		logger.info("[existe]");

		WebDriver driver = DriverWeb.getDriver();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return !DriverWeb.getDriver().findElements(by).isEmpty();
		} finally {
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		}
	}

}