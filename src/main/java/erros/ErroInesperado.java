package erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import interfaces.log.LogMessage;

public class ErroInesperado extends AssertionError {
	private static final long serialVersionUID = 56587072717382301L;
	private static String defaultMessage = "Ocorreu um erro inesperado.";

	public ErroInesperado() {
		LogMessage.builder().withMessage(defaultMessage).error();
	}

	public ErroInesperado(String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).error());		
	}

	public ErroInesperado(Throwable t) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).error());
	}

	public ErroInesperado(Exception e) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).error());
	}
	
	public ErroInesperado(By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withElement(elemento).error());
	}
	
	public ErroInesperado(WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withElement(elemento).error());
	}
	
	public ErroInesperado(By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}
	
	public ErroInesperado(WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withElement(elemento).error());
	}

	public ErroInesperado(Throwable t, By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInesperado(Exception e, By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInesperado(Throwable t, WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInesperado(Exception e, WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInesperado(Throwable t, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).error());
	}

	public ErroInesperado(Exception e, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).error());
	}

	public ErroInesperado(Throwable t, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInesperado(Exception e, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInesperado(Throwable t, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInesperado(Exception e, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(e).withElement(elemento).error());
	}
}
