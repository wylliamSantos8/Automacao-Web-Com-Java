package erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import interfaces.log.LogMessage;

public class ErroMassaDeDados extends AssertionError {
	private static final long serialVersionUID = 1587161918087929354L;
	private static String defaultMessage = "Ocorreu um erro de massa de dados.";

	public ErroMassaDeDados() {
		LogMessage.builder().withMessage(defaultMessage).error();
	}

	public ErroMassaDeDados(String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).error());		
	}

	public ErroMassaDeDados(Throwable t) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).error());
	}

	public ErroMassaDeDados(Exception e) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).error());
	}
	
	public ErroMassaDeDados(By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withElement(elemento).error());
	}
	
	public ErroMassaDeDados(WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withElement(elemento).error());
	}

	public ErroMassaDeDados(Throwable t, By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).withElement(elemento).error());
	}

	public ErroMassaDeDados(Exception e, By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).withElement(elemento).error());
	}

	public ErroMassaDeDados(Throwable t, WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).withElement(elemento).error());
	}

	public ErroMassaDeDados(Exception e, WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).withElement(elemento).error());
	}

	public ErroMassaDeDados(Throwable t, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).error());
	}

	public ErroMassaDeDados(Exception e, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).error());
	}

	public ErroMassaDeDados(Throwable t, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(t).withElement(elemento).error());
	}

	public ErroMassaDeDados(Exception e, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(e).withElement(elemento).error());
	}

	public ErroMassaDeDados(Throwable t, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(t).withElement(elemento).error());
	}

	public ErroMassaDeDados(Exception e, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(e).withElement(elemento).error());
	}
}
