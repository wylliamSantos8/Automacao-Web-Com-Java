Feature: Desafio Sicredi

Background:
	Given que acesso o site "https://www.grocerycrud.com/v1.x/demo/bootstrap_theme"

@ProvaSicredi @CadastrarCustomer @Desafio1
  Scenario: Desafio 1 - Adicionar Customer no Grid
    When mudar o valor da combo Select version para "Bootstrap V4 Theme"
    And clicar no botão "Add Customer"
    And preencher os campos do formulário 
    And clicar no botão "Save"
		Then validar a mensagem "Your data has been successfully stored into the database. Edit Customer or Go back to list"
		
@ProvaSicredi @DeletarCustomer @Desafio2
  Scenario: Desafio 2 - Deletar Customer no Grid
    When mudar o valor da combo Select version para "Bootstrap V4 Theme"
    And clicar no botão "Add Customer"
    And preencher os campos do formulário 
    And clicar no botão "Save"
		Then validar a mensagem "Your data has been successfully stored into the database. Edit Customer or Go back to list"
		And clicar no link "Go back to list"
		And clicar na coluna Search Name e digitar o conteúdo do Name "Teste Sicredi" 
		And clicar no checkbox abaixo da palavra Actions
		And clicar no botão "Delete"
    And validar o texto "Are you sure that you want to delete this 1 item?"
    And clicar no botão Delete da popup
		Then Adicione uma asserção na mensagem "Your data has been successfully deleted from the database."
		
		
		