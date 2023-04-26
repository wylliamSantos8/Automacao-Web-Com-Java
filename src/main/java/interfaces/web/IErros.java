package interfaces.web;

import static interfaces.web.IEspera.TIMEOUT;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import drivers.web.*;
import erros.ErroAutomacao;
import erros.ErroInesperado;
import erros.ErroSistema;
import erros.ErrorFactory;
import interfaces.log.LogWeb;

public interface IErros {
	Logger logger = LogWeb.getLogger(IErros.class);

	final static By registroNaoEncontrado = By.xpath("//p[text()='Registro não encontrado.']");
	
	/**
	 * LISTA DE TODOS OS ERROS MAPEADOS E SUAS MENSAGENS DE ERRO
	 */
	@SuppressWarnings("serial")
	final static Map<By, String[]> erros = new HashMap<By, String[]>() {
		{
			put(registroNaoEncontrado, new String[] {"ErroSistema", "Registro não encontrado."});
		}
	};

	final static By[] errosFinal = {  };
	
	/**
	 * Sempre checar as mensagens do modal primeiro.
	 */
	final static By[] mensagensDoSistema = {  };

	/**
	 * Checar se o elemento de erro existe em tela, retornando um throw se positivo.
	 * 
	 * @param elemento
	 */
	default void checarErro(By elemento) {
		if (DriverWeb.getDriver().findElements(elemento).size() > 0) {
			logger.warn(String.format("Erro encontrado no elemento [%s].", elemento));
			String[] args = erros.get(elemento);
			ErrorFactory.throwError(args[0], args[1]);
		}
	}

	/**
	 * Checar se algum elemento da lista de erros existe em tela, retornando um
	 * throw se positivo.
	 * 
	 * @param listaDeElementos
	 */
	default void checarErros(By[] listaDeElementos) {
		try {
			DriverWeb.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			checarMensagensDoSistema();

			for (By elementoErro : listaDeElementos) {
				logger.info(String.format("Checando se o erro é no elemento [%s].", elementoErro.toString()));

				checarErro(elementoErro);
			}
			throw new ErroInesperado("Erro não reconhecido.");
		} catch (Throwable t) {
			throw t;

		} finally {
			DriverWeb.getDriver().manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		}
	}

	/**
	 * Checa se existe alguma mensagem de erro no sistema, retornando o conteúdo
	 * para o log.
	 */
	default void checarMensagensDoSistema() {
		for (By mensagem : mensagensDoSistema) {
			try {
				DriverWeb.getDriver().findElement(mensagem);
				String mensagemErro = new IObter() {
				}.obterTexto(mensagem, "Obter mensagem de erro do sistema.");
				
				throw new ErroSistema(mensagemErro);
			} catch (ErroSistema | ErroAutomacao e) {
				throw e;
			} catch (Exception e) {
			}
		}
	}

	default void checarErrosFinal() {
		checarErros(errosFinal);
	}

	/**
	 * Transforma o StackTrace do Throwable em String.
	 * 
	 * @param t
	 * @return
	 */
	public static String throwableStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}

	/**
	 * Transforma o StackTrace da Exception em String.
	 * 
	 * @param e
	 * @return
	 */
	public static String exceptionStackTrace(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}

	/**
	 * Passa o stackTrace do throwable para o logger.
	 * 
	 * @param t
	 */
	public static void logThrowable(Throwable t) {
		logger.warn("StackTrace do erro:", t);
	}
}
