package interfaces.web;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.web.DriverWeb;
import interfaces.log.LogWeb;

public interface IEspera {
	static Logger logger = LogWeb.getLogger(IEspera.class);
	long TIMEOUT = 40;

	default void esperarSerClicavel(By elemento, int tempoEmSegundos) {
		try {
			logger.info(String.format(
					"Realizar a ação do método [esperarElementoSerClicavel] com elemento [%s] por %d segundos", elemento,
					tempoEmSegundos));
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoEmSegundos);
			wait.until(ExpectedConditions.elementToBeClickable(elemento));
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
	}

	
	default void esperarSerClicavel(WebElement elemento, int tempoEmSegundos) {
		try {
			logger.info(String.format(
					"Realizar a ação do método [esperarElementoSerClicavel] com elemento [%s] por %d segundos", elemento,
					tempoEmSegundos));
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoEmSegundos);
			wait.until(ExpectedConditions.elementToBeClickable(elemento));
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
	}

	default WebElement esperarElementoExistir(By elemento, int tempoEmSegundos) {
		logger.info(String.format("Realizar a ação do método [esperarElementoExistir] por %d segundos.", tempoEmSegundos));
		try {
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoEmSegundos);
			return wait.until(ExpectedConditions.presenceOfElementLocated(elemento));
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
		return null;
	}
	
	default void esperarPadrao(int tempoEmSegundos) {
		logger.info(String.format("Realizar a ação do método [esperarPadrao] por %d segundos.", tempoEmSegundos));

		try {
			Thread.sleep(tempoEmSegundos * 1000L);
		} catch (InterruptedException e) {
			logger.error(" -- ERRO: Tempo excedido '");
			Assert.fail(LocalDateTime.now() + " Tempo excedido '");
			Thread.currentThread().interrupt();
		}
	}

	default void esperarPaginaSerCarregada(int tempoEmSegundos) {
		try {
			logger.info(String.format("Realizar a ação do método [esperarPaginaSerCarregada] por %d segundos.",
					tempoEmSegundos));
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoEmSegundos);
			wait.until((dr -> ((JavascriptExecutor) dr)
					.executeScript("return document.readyState").equals("complete")));
		
		} catch (Exception e) {
			logger.error(" -- ERRO: Página atual não foi carregada totalmente em " + tempoEmSegundos + ".");
			Assert.fail(LocalDateTime.now() + " --  Página atual não foi carregada totalmente em " + tempoEmSegundos
					+ ". -->" + e.getMessage());
		}
	}

	default void esperarElementoSerVisivel(By elemento, int tempoEmSegundos, String descricaoDoPasso) {
		try {
			logger.info("----" + descricaoDoPasso);
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoEmSegundos);
			wait.until(ExpectedConditions.visibilityOf(DriverWeb.getDriver().findElement(elemento)));
			logger.info(" Realizou a ação do método [esperarElementoSerVisivel] "
					+ " da classe " + IEspera.class.toString() + " com o elemento " + "[ " + elemento + " ]"
					+ " com o tempo de espera : [ " + tempoEmSegundos+ " ]");			
		} catch (NoSuchElementException e) {
			logger.warn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
	}

}