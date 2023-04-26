package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import paginas.GroceryPagina;

public class GrocerySteps {
	
	GroceryPagina grocery = new GroceryPagina();
	
	@Given("^que acesso o site \"([^\"]*)\"$")
	public void queAcessoOSite(String url) throws Throwable {
		grocery.acessarSistema(url);
	}
	
	@When("^mudar o valor da combo Select version para \"([^\"]*)\"$")
	public void mudarOValorDaComboSelectVersionPara(String versao) throws Throwable {
	    grocery.selecionarVersao(versao);
	}

	@When("^clicar no botão \"([^\"]*)\"$")
	public void clicarNoBotão(String botao) throws Throwable {
		grocery.clicarEm(botao);
	}

	@When("^preencher os campos do formulário$")
	public void preencherOsCamposDoFormulário() throws Throwable {
	  grocery.preencherFormulario();
	}

	@Then("^validar a mensagem \"([^\"]*)\"$")
	public void validarAMensagem(String mensagem) throws Throwable {
	    grocery.validarCadastroComSucesso(mensagem);
	}
	
	@When("^clicar no link \"([^\"]*)\"$")
	public void clicarNoLink(String botao) throws Throwable {
	    grocery.clicarEm(botao);
	}

	@When("^clicar na coluna Search Name e digitar o conteúdo do Name \"([^\"]*)\"$")
	public void clicarNaColunaSearchNameEDigitarOConteúdoDoName(String nome) throws Throwable {
	   grocery.pesquisarNome(nome);
	}

	@When("^clicar no checkbox abaixo da palavra Actions$")
	public void clicarNoCheckboxAbaixoDaPalavraActions() throws Throwable {
	    grocery.clicarCheckbox();
	}

	@When("^validar o texto \"([^\"]*)\"$")
	public void validarOTexto(String mensagem) throws Throwable {
	    grocery.validarMensagemConfirmacao(mensagem);
	}

	@When("^Adicione uma asserção na mensagem \"([^\"]*)\"$")
	public void adicioneUmaAsserçãoNaMensagem(String mensagem) throws Throwable {
	    grocery.validarMensagemDelecao(mensagem);
	}
	
	@When("^clicar no botão Delete da popup$")
	public void clicarNoBotãoDeleteDaPopup() throws Throwable {
	    grocery.clicarEm("DeleteModal");
	}

}
