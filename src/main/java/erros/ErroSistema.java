package erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import interfaces.log.LogMessage;

public class ErroSistema extends AssertionError {
	private static final long serialVersionUID = -42759536757942704L;
	private static String defaultMessage = "Ocorreu um erro de sistema.";

	public ErroSistema() {
		LogMessage.builder().withMessage(defaultMessage).error();
	}

	public ErroSistema(String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).error());		
	}

	public ErroSistema(Throwable t) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).error());
	}

	public ErroSistema(Exception e) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).error());
	}
	
	public ErroSistema(By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withElement(elemento).error());
	}
	
	public ErroSistema(WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withElement(elemento).error());
	}

	public ErroSistema(Throwable t, By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).withElement(elemento).error());
	}

	public ErroSistema(Exception e, By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).withElement(elemento).error());
	}

	public ErroSistema(Throwable t, WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).withElement(elemento).error());
	}

	public ErroSistema(Exception e, WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).withElement(elemento).error());
	}

	public ErroSistema(Throwable t, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).error());
	}

	public ErroSistema(Exception e, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).error());
	}

	public ErroSistema(Throwable t, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(t).withElement(elemento).error());
	}

	public ErroSistema(Exception e, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(e).withElement(elemento).error());
	}

	public ErroSistema(Throwable t, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(t).withElement(elemento).error());
	}

	public ErroSistema(Exception e, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(e).withElement(elemento).error());
	}
}
