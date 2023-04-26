package paginas;

import static org.junit.Assert.assertEquals;

import java.text.MessageFormat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import drivers.web.DriverWeb;
import elementos.ElementosGrocery;
import erros.ErroAutomacao;
import interacoes.InteracaoWeb;
import utils.Iteracao;

public class GroceryPagina extends ElementosGrocery implements InteracaoWeb{
	
	private Iteracao utils = new Iteracao();
	
	public void acessarSistema(String url) {
		logger.info(MessageFormat.format("Acessando a URl {0}", url));
		abrirUrl(url);
		utils.getWaitHelper().waitForElementsToLoad(30);
	}
	
	public void selecionarVersao(String versao) {
		logger.info("Alterar a Versão dp Thema da Tela.");
		esperarElementoSerVisivel(CBXVERSAO, 10, "Aguardar Elemento Existir na Tela.");
		selecionarCombo(CBXVERSAO, versao);
	}
	
	  public void clicarEm(String botao) {
		  logger.info("Redirecionando Metódo de Clicar.");
		  esperarPadrao(3);
	        switch (botao) {
	            case "Add Customer":
	                clicar(BTNADD);
	                break;
	            case "Save":
	                clicar(BTNSAVE);
	                break;
	            case "Go back to list":
	                clicar(BTNBACKTOLIST);
	                break;
	            case "Delete":
	                clicar(BTNDELETE);
	                break;
	            case "DeleteModal":
	                clicar(BTNDELETEMODALCONF);
	                break;

	            default:
	                throw new ErroAutomacao("Menu não definido no método [clicarMenu].");
	        }
	    }

	  public void preencherFormulario() {
		  preencherCampoName();
		  preencherCampoLastName();
		  preencherCampoContactFirtName();
		  preencherCampoPhone();
		  preencherCampoAdressLine1();
		  preencherCampoAdressLine2();
		  preencherCampoCity();
		  preencherCampoState();
		  preencherCampoPostalCode();
		  preencherCampoCountry();
		  preencherCampoFromEmployeer();
		  preencherCampoCreditLimit();
		  
	  }
	  
	  public void preencherCampoName() {
		  logger.info("Preencher o Campo Name.");
		  esperarElementoSerVisivel(TXTNAME, 10, "Aguardar Elemento Existir na Tela.");
		  escrever(TXTNAME, "Teste Sicredi");
	  }
	  
	  public void preencherCampoLastName() {
		  logger.info("Preencher o Campo Last Name.");
		  esperarElementoSerVisivel(TXTLASTNAME, 10, "Aguardar Elemento Existir na Tela.");
		  escrever(TXTLASTNAME, "Teste");
	  }
	  
	  public void preencherCampoContactFirtName() {
		  logger.info("Preencher o Campo Contact Firt Name.");
		  esperarElementoSerVisivel(TXTCONTACTFIRTNAME, 10, "Aguardar Elemento Existir na Tela.");
		  escrever(TXTCONTACTFIRTNAME, "Wylliam Alves dos Santos");
	  }
	  
	  public void preencherCampoPhone() {
		  logger.info("Preencher o Campo Phone.");
		  esperarElementoSerVisivel(TXTPHONE, 10, "Aguardar Elemento Existir na Tela.");
		  escreverUmaLetraPorVez(TXTPHONE, "51 9999-9999");
	  }
	  
	  public void preencherCampoAdressLine1() {
		  logger.info("Preencher o Campo AdressLine 1.");
		  esperarElementoSerVisivel(TXTADRESSLINE1, 10, "Aguardar Elemento Existir na Tela.");
		  escrever(TXTADRESSLINE1, "Av Assis Brasil, 3970");
	  }
	  
	  public void preencherCampoAdressLine2() {
		  logger.info("Preencher o Campo AdressLine 2.");
		  esperarElementoSerVisivel(TXTADRESSLINE2, 10, "Aguardar Elemento Existir na Tela.");
		  escrever(TXTADRESSLINE2, "Torre D");
	  }
	  
	  public void preencherCampoCity() {
		  logger.info("Preencher o Campo City.");
		  esperarElementoSerVisivel(TXTCITY, 10, "Aguardar Elemento Existir na Tela.");
		  escrever(TXTCITY, "Porto Alegre");
	  }
	  
	  public void preencherCampoState() {
		  logger.info("Preencher o Campo State.");
		  esperarElementoSerVisivel(TXTSTATE, 10, "Aguardar Elemento Existir na Tela.");
		  escrever(TXTSTATE, "RS");
	  }
	  
	  public void preencherCampoPostalCode() {
		  logger.info("Preencher o Campo Postal Code.");
		  esperarElementoSerVisivel(TXTPOSTALCODE, 10, "Aguardar Elemento Existir na Tela.");
		  escreverUmaLetraPorVez(TXTPOSTALCODE, "91000-000");
	  }
	  
	  public void preencherCampoCountry() {
		  logger.info("Preencher o Campo Country.");
		  esperarElementoSerVisivel(TXTCOUNTRY, 10, "Aguardar Elemento Existir na Tela.");
		  escrever(TXTCOUNTRY, "Brasil ");
	  }
	  
	  public void preencherCampoFromEmployeer() {
		  logger.info("Preencher o Campo From Employeer.");
		  esperarElementoSerVisivel(DIVFROMIMPLOYEER, 10, "Aguardar Elemento Existir na Tela.");
		  moverParaElementoeClicar(DIVFROMIMPLOYEER);
		  clicar(DIVFROMIMPLOYEER);
		  
		  escrever(TXTPESQUISAREMPLOYEER, "FIXTER");
		  WebElement campoEmployeer = DriverWeb.getDriver().findElement(ElementosGrocery.TXTPESQUISAREMPLOYEER);
		  campoEmployeer.sendKeys(Keys.ENTER);
	  }
	  
	  public void preencherCampoCreditLimit() {
		  logger.info("Preencher o Campo Credit Limit.");
		  esperarElementoSerVisivel(TXTCREDITLIMIT, 10, "Aguardar Elemento Existir na Tela.");
		  escrever(TXTCREDITLIMIT, "200");
	  }
	  
	  public void validarCadastroComSucesso(String mensagem) {
		  logger.info("Validar o Cadastro Realizado com Sucesso.");
		  esperarPadrao(3);
          assertEquals(mensagem, obterTexto(MSGSUCESSO, "Obter Texto da Label"));
	  }
	  
	  public void pesquisarNome(String nome) {
		  logger.info("Preencher o Campo de Pesquisa Nome.");
		  esperarPadrao(5);
		  esperarElementoSerVisivel(TXTPESQUISARNOME, 60, "Aguardar Elemento Existir na Tela.");
		  escrever(TXTPESQUISARNOME, nome);
		  WebElement campoPesquisa = DriverWeb.getDriver().findElement(ElementosGrocery.TXTPESQUISARNOME);
		  campoPesquisa.sendKeys(Keys.ENTER);
		  esperarPadrao(5);
	  }
	  
	  public void clicarCheckbox() {
		  logger.info("Clicar CheckBox.");
		  esperarElementoSerVisivel(CHKTODOS, 60, "Aguardar Elemento Existir na Tela.");
		  clicar(CHKTODOS);
		  esperarPadrao(2);
	  }
	  
	  public void validarMensagemConfirmacao(String mensagem) {
		  logger.info("Validar Mensagem de Confirmação.");
		  esperarPadrao(5);
          assertEquals(mensagem, obterTexto(MSGCONFIRMACAO, "Obter Texto da Label."));
	  }
	  
	  public void validarMensagemDelecao(String mensagem) {
		  logger.info("Validar Mensagem de Confirmação de Exclusão.");
		  esperarPadrao(3);
		  assertEquals(mensagem, obterTexto(MSGSUCESSODELETE, "Obter Texto da Label."));
	  }
	  
}
