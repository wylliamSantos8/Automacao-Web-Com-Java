package interfaces.web;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import drivers.web.DriverWeb;
import interfaces.log.LogWeb;

public interface ICombo extends IEspera {
	static Logger logger = LogWeb.getLogger(ICombo.class);


	default void selecionarCombo(By elemento, String valor) {
		logger.info(String.format("Realizar a ação do método [selecionarCombo] com o elemento [%s] e o valor [%s].",
				elemento, valor));
		try {
			WebElement webElement = DriverWeb.getDriver().findElement(elemento);
			Select combo = new Select(webElement);
			combo.selectByVisibleText(valor);
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


	/**
	 * Clicar no combo pela posição (index)
	 * 
	 * @param elemento
	 * @param posicao
	 */
	default void selecionarCombo(By elemento, int posicao) {
		try {
			logger.info(String.format("Realizar a ação do método [selecionarCombo] com o elemento [%s] e o valor [%s].",
					elemento, posicao));
			WebElement webElement = DriverWeb.getDriver().findElement(elemento);
			Select combo = new Select(webElement);
			if (posicao == -1) {
				combo.selectByIndex(combo.getOptions().size() - 1);
			} else {
				combo.selectByIndex(posicao);
			}
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
	
	/**
	 * Clicar no combo pela posição (index)
	 * 
	 * @param elemento
	 * @param posicao
	 */
	default void selecionarCombo(WebElement elemento, int posicao) {
		try {
			logger.info(String.format("Realizar a ação do método [selecionarCombo] com o elemento [%s] e o valor [%s].", elemento, posicao));
			Select combo = new Select(elemento);
			combo.selectByIndex(posicao);
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
}
