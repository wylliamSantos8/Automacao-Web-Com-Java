package executar;

import java.io.File;
import java.util.Arrays;

public class ValidarEvidencias {
	
	
	/**
	 * Deleta os prints a cada nova execução
	 */
	public void deletarPrints() {
		validaSePossuiArquivos(naPastaDeEvidencia("Prints_Erro"));
		validaSePossuiArquivos(naPastaDeEvidencia("Prints_Sucesso"));
	}
	/**
	 * Veriica se possui arquivos na pasta desejada
	 * @param caminho
	 */
	private void validaSePossuiArquivos(String caminho) {
		try {
			File file = new File(caminho);
			if (file.listFiles().length > 0) {
				Arrays.stream(file.listFiles()).forEach(File::delete);
			}
		} catch (Exception e) {
			System.out.println("Não foi possível excluir os prints");
		}
	}
	
	/**
	 * Retorna a pasta com as evidencias.
	 * @param nomeDaPasta
	 * @return
	 */
	private String naPastaDeEvidencia(String nomeDaPasta) {
		return System.getProperty("user.dir")
				.concat(File.separator
				.concat("Evidencias")
				.concat(File.separator.concat(nomeDaPasta)));
	}
}
