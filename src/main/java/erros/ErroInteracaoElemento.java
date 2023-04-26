package erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import interfaces.log.LogMessage;

public class ErroInteracaoElemento extends AssertionError {
	private static final long serialVersionUID = -9145998444937890997L;
	private static String defaultMessage = "Ocorreu um erro ao interagir com elemento.";

	public ErroInteracaoElemento() {
		LogMessage.builder().withMessage(defaultMessage).error();
	}

	public ErroInteracaoElemento(String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).error());		
	}

	public ErroInteracaoElemento(Throwable t) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).error());
	}

	public ErroInteracaoElemento(Exception e) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).error());
	}
	
	public ErroInteracaoElemento(By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withElement(elemento).error());
	}
	
	public ErroInteracaoElemento(WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Throwable t, By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Exception e, By elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Throwable t, WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Exception e, WebElement elemento) {
		super(LogMessage.builder().withMessage(defaultMessage).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Throwable t, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(t).error());
	}

	public ErroInteracaoElemento(Exception e, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem, args).withStackTrace(e).error());
	}

	public ErroInteracaoElemento(Throwable t, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Exception e, By elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(e).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Throwable t, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(t).withElement(elemento).error());
	}

	public ErroInteracaoElemento(Exception e, WebElement elemento, String mensagem, Object... args) {
		super(LogMessage.builder().withMessage(mensagem).withStackTrace(e).withElement(elemento).error());
	}
}
