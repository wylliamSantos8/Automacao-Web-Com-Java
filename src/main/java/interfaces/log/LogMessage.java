package interfaces.log;

import static interfaces.log.LogWeb.portoLogger;
import static interfaces.web.IErros.exceptionStackTrace;
import static interfaces.web.IErros.throwableStackTrace;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogMessage {
	private static Logger logger = LogWeb.getLogger(LogMessage.class);

	public static class Builder {

		private String message = "";
		private String stackTrace = "";
		private String element = "";

		public String info() {
			portoLogger.info(message);

			if (!element.isEmpty())
				logger.info(String.format("Elemento: [%s].", element));

			if (!stackTrace.isEmpty())
				logger.info(stackTrace);

			return message;

		}

		public String warn() {
			portoLogger.warn(message);

			if (!element.isEmpty())
				logger.warn(String.format("Elemento: [%s].", element));

			if (!stackTrace.isEmpty())
				logger.warn(stackTrace);

			return message;
		}

		public String error() {
			portoLogger.error(message);

			if (!element.isEmpty())
				logger.error(String.format("Elemento: [%s].", element));

			if (!stackTrace.isEmpty())
				logger.error(stackTrace);

			return message;
		}

		public Builder withMessage(String message, Object... args) {
			this.message = String.format(message, args);
			return this;
		}

		public Builder withStackTrace(Exception e) {
			this.stackTrace = exceptionStackTrace(e);
			return this;
		}

		public Builder withStackTrace(Throwable t) {
			this.stackTrace = throwableStackTrace(t);
			return this;
		}

		public Builder withElement(WebElement elemento) {
			this.element = elemento.toString();
			return this;
		}

		public Builder withElement(By elemento) {
			this.element = elemento.toString();
			return this;
		}

	}

	public static Builder builder() {
		return new Builder();
	}
}
