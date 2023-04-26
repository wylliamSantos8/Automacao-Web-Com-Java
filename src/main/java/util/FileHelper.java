package util;

import java.io.File;

public class FileHelper {

	private static String fs = File.separator;

	private FileHelper() {
	}

	/**
	 * Formata as pastas definidas para um caminho do projeto. Exemplo: No windows:
	 * projectFolder("src", "test", "resources") -> System.getProperty("user.dir") +
	 * "/src/test/resources/"
	 * 
	 * @param caminho A(s) pasta(s) usada(s) para definir o caminho no sistema.
	 * @return Uma String contendo o caminho específicado, com a raíz do projeto e
	 *         os separadores específicos do sistema.
	 */
	public static String projectFolder(String... caminho) {
		return String.format("%s%s%s%s", System.getProperty("user.dir"), fs, String.join(fs, caminho), fs);
	}

	/**
	 * Formata as pastas definidas para um caminho do projeto. Exemplo (Windows):
	 * projectFolder("src", "main", "java", "util", "FileHelper.java") ->
	 * System.getProperty("user.dir") + "/src/main/java/util/FileHelper.java"
	 * 
	 * @param caminho A(s) pasta(s) usada(s) para definir o caminho no sistema,
	 *                sendo o último argumento o arquivo com extensão.
	 * @return Uma String contendo o arquivo com caminho específicado, com a raíz do
	 *         projeto e os separadores específicos do sistema.
	 */
	public static String projectFile(String... caminho) {
		return String.format("%s%s%s", System.getProperty("user.dir"), fs, String.join(fs, caminho));
	}

	/**
	 * Substitui todas as barras (/) da String definida pelo separador específico do
	 * sistema.
	 * 
	 * @param caminho A String a ser formatada. Exemplo: "src/test/java".
	 * @return A String com os separadores corretos.
	 */
	public static String formatFileSeparator(String caminho) {
		return caminho.replace("/", fs);
	}

	
}
