package utils;

import java.text.Normalizer;

import drivers.web.DriverWeb;
import interacoes.InteracaoWeb;

public class Iteracao implements InteracaoWeb {
	
	private WaitHelper waitHelper;

/**
	 * @see Inicializa o construtor da classe e cria o objeto.
	 * @return
	 */

	public synchronized WaitHelper getWaitHelper() {
		return (waitHelper == null) ? new WaitHelper(DriverWeb.getDriver()) : waitHelper;
	}
	
	
	/**
	 * Remove os acentos.
	 * @param texto O texto
	 * @return O string
	 */
	public static String removeAcentos(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}