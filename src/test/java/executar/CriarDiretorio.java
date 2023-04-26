package executar;

import java.io.File;

public class CriarDiretorio {

	private static final String caminhoDiretorio = System.getProperty("user.dir").concat(File.separator).concat("Evidencias");
	
	/**
	 * Validar se o diretório Evidencias existe
	 */
	public void validarDiretorio() {
		File diretorio = new File(caminhoDiretorio);
		if (!diretorio.exists()) {
			criarDiretorio();
		}
	}
	
	/**
	 * Cria diretório e subdiretorios 
	 */
	private void criarDiretorio() {
		File diretorio = new File(caminhoDiretorio);
		diretorio.mkdirs();
		File subPrints = new File(diretorio,"Prints_Sucesso");
		subPrints.mkdirs();
		File subPrintsDeErro = new File(diretorio, "Prints_Erro");
		subPrintsDeErro.mkdirs();
	}	
}
