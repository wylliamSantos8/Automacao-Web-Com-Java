package interfaces.web;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.junit.Assert;

import drivers.web.DriverWeb;
import interfaces.log.LogWeb;

public interface IAcoesBrowser {
	
	static Logger logger = LogWeb.getLogger(IAcoesBrowser.class);
	
	default void abrirUrl(String url) {
		try {
			logger.info(String.format("Realizar a ação do método [abrirUrl] para acessar [%s].", url));
			DriverWeb.getDriver().get(url);
		} catch (Exception e) {
			logger.error(" -- ERRO: erro ao abrir url: " + url);
			Assert.fail(LocalDateTime.now() + "erro ao abrir url: " + url);
		}
	}

}