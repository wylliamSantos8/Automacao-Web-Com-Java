package erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import interfaces.log.LogMessage;

public class ErroAutomacao extends AssertionError {
	private static final long serialVersionUID = 3949578720833058049L;
	private static final String defaultMessage = "Ocorreu um erro de automação.";

	public ErroAutomacao() {
		LogMessage.builder().withMessage(defaultMessage).error();
	}

	public ErroAutomacao(String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).error());
	}

	public ErroAutomacao(Throwable t) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).error());
	}

	public ErroAutomacao(Exception e) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).error());
	}

	public ErroAutomacao(By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withElement(elemento).error());
	}

	public ErroAutomacao(WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withElement(elemento).error());
	}

	public ErroAutomacao(Throwable t, By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).withElement(elemento).error());
	}

	public ErroAutomacao(Exception e, By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).withElement(elemento).error());
	}

	public ErroAutomacao(Throwable t, WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).withElement(elemento).error());
	}

	public ErroAutomacao(Exception e, WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).withElement(elemento).error());
	}

	public ErroAutomacao(Throwable t, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).error());
	}

	public ErroAutomacao(Exception e, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).error());
	}

	public ErroAutomacao(Throwable t, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(t).withElement(elemento).error());
	}

	public ErroAutomacao(Exception e, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(e).withElement(elemento).error());
	}

	public ErroAutomacao(Throwable t, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(t).withElement(elemento).error());
	}

	public ErroAutomacao(Exception e, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(e).withElement(elemento).error());
	}
}
