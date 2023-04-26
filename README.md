# **Documentação de utilização do Framework **

# Como configurar o ambiente para execução dos testes:

1. Instalar o JDK8
2. Instalar o Maven : https://dicasdejava.com.br/como-instalar-o-maven-no-windows/
3. Configurar as variaveis de ambiente : https://confluence.atlassian.com/confbr1/configurando-a-variavel-java_home-no-windows-933709538.html
4. Importar o projeto para a IDE de desenvolvimento(Eclipse ou Intellij Idea).

# Como executar os testes no framework:

1. Acessar o arquivo CucumberExecuteTest na pasta src/test/java/executar
2. Inserir a TAG desejada dentro da opção tags
3. Clicar em Run

Obs: no momento da execução caso o Runner solicite a versão do Junit, a versão 4 deve ser escolhida nas configurações.

### Observações Importantes Sobre a Execução dos Cenários

1. Para este projeto, os cenários devem ser executados separadamente, com as Tags @Desafio1 e @Desafio2.
	
2. O @Desafio1 pode ser executado diversas vezes, pois não possui dependência de massa de dados.
	
3. Mas para a execução do @Desafio2, primeiro é necessário limpar todos os registros de Teste Sicredi existentes no site, 
   pois um dos steps valida a existencia de uma mensagem que indica que somente um registro existe em tela na hora da deleção,
   se existirem mais registros o cenários vai quebrar, pois o resultado obtido é diferente do resultado esperado.

### Evidências

1. Na pasta Evidências é possível visualizar uma página HTML com o Status da execução dos cenários, pode ser aberta em qualquer navegador.

 Evidencias/Status - Automação de Testes.html
 
### Integração Contínua 

1. Na raiz do projeto se encontra um arquivos JenkinsFile para integração contínua.

### BDD - Boas Práticas:


1. Não repetir o mesmo passo dentro da mesma funcionalidade (Recomendado).
	Quais os problemas disso? O problema se dá principalmente nos casos de validações, ou seja, no step 'Entao'.
	Pensando no teste de API, digamos que será validado o status de erro 401 para um cenário e o status 403 para outro cenário.
	Ex.:

 ```
 Cenario: cenario 1 
      Dado que nao tenho credenciais validas
      Quando eu realizar uma requisicao para o website da alelo refeicao 
      Entao eu devo obter o status de erro

 Cenario: cenario 2 
     Dado que eu tenho credenciais validas 
     Quando eu realizar uma requisicao para o website da alelo refeicao sem informar o token 
     Entao eu devo obter o status de erro 
 ```
Qual o problema? Pois bem, repare que os passos são iguais mas as validações são diferentes. Isso deixa o código de automação pouco reutilizável, 	porque obrigará o automatizador a escrever um script de validação específico para tratar qual validação de erro executar no momento da execução do teste.

O ideal é diferenciá-los, pois isso mantém o código limpo e com um nível maior de reutilização. 

*Recomendamos que os passos sejam sempre diferentes, pois evitarão problemas futuros.*

Exemplo correto:
 ```
 Cenario: cenario 1 
      Dado que nao tenho credenciais validas
      Quando eu realizar uma requisicao para o website da alelo refeicao 
      Entao eu devo obter o status de erro 401

 Cenario: cenario 2 
     Dado que eu tenho credenciais validas 
     Quando eu realizar uma requisicao para o website da alelo refeicao sem informar o token 
     Entao eu devo obter o status de erro 403
 ```

2. Contexto só deve ser utilizado para 'Dado' e/ou 'Entao'.

3. Tomar cuidado ao utilizar palavras reservadas e caracteres reservados.
	
*Exemplo de palavras reservadas: Dado, Quando, E, Entao.*

Exemplo de erro: 
`Quando eu informar nome E informar senha. ` (Repare que o 'E' está em maiúsculo, constituindo-se como palavra reservada).

*Nesses casos de uso, o ideal é utilizar em letra minúscula, diferindo-se da palavra reservada).*

Exemplo certo: 
 `Quando eu informar nome e informar senha. ` (Perceba agora que o 'E' está em minúsculo).
	

*Exemplo de caracteres reservados:*
Sobre caracteres reservados, o indicado é primeiro verificar a versão do Cucumber e depois, pois cada versão possui tipos diferentes de carácteres especiais.

[link para verificar as palavras reservadas da última versão do cucumber](https://docs.cucumber.io/gherkin/reference/#keywords )


# Dicas codificação:
Saiba que aplicar boas práticas durante a codificação resulta em um código bem estruturado, limpo, conciso e de fácil compreensão, 
e esta melhoria da qualidade do código viabiliza o aumento da produtividade do time em todas as fases de qualquer processo de software.

Manutenção do código:

1° Métodos genéricos:

* Um método deve ter somente uma responsabilidade e se adequar a todas as chamadas.

2° Responsabilidade de classes:

* Métodos de interação não devem misturar-se com métodos de validação. Por isso foi criada uma interface chamada IValidacoes que é específica para isso. Cada classe deve ter somente métodos para os quais ela foi programada para ter. Por exemplo, o screenshot não deve ser misturado com a classe que contém métodos de interação com a página. São coisas distintas. 
* Cada classe deve comportar métodos do tipo dela. Se a classe é de Driver, devem permanecer somente métodos referente ao driver. Se a classe é de interação com a página, devem ter somente métodos de interação.

3° Pasta "target":
 A pasta target é dinâmica de acordo com o maven. Se você der um comando do maven, a primeira coisa que ele vai fazer é limpar toda a pasta "target".
    Se o desejo for apagar todos os "screenshots", recomendo a seguinte solução para o caso dos prints:
	* Portanto, lembre-se que os arquivos da pasta target são temporários.

4° 

* Manter uma classe por funcionalidade  
* Aconselhável utilizar uma classe pageObjects para cada interface do sistema
* Utilizar uma classe separada para conter os métodos que são necessários ao projeto e que não estejam no framework. Ou seja, qualquer método extra referente ao projeto, não deverá ficar nas classes do framework, mas sim nessa classe específica

5° Evitar a utilização de nomenclatura inadequada no repositório ou nas branches. Elas não causam grandes impactos negativos no cronograma do projeto, mas dificultam a identificação do código a ser evoluído. 

6° Outra atitude a ser evitada é a adição de arquivos desnecessários no sistema de controle de versão. Estes arquivos podem deixar o repositório grande e confuso e tornar o processo de atualização do código demorado.

7° A falta de critérios pré-estabelecidos de formatação do código, o desleixo, a falta de atenção ou a ausência do sentido de coletividade do código e do empenho por parte de membros do time são alguns dos fatores que prejudicam o trabalho.

8° A indentação é um dos aspectos visuais mais importantes para facilitar ou dificultar a leitura e o entendimento do código. Primeiramente é importante decidir se serão empregados tabulações ou espaços, e depois, definir o tamanho da indentação. Normalmente, utiliza-se quatro espaços.

9° Outra boa prática é criar nomes consistentes para as classes, variáveis e constantes. Apenas pelo nome destes elementos deve ser possível entender a razão de existirem ou o que fazem. Não há um limite sugerido para o tamanho dos nomes.

10° A utilização de poucos comentários também é primordial para a manutenção de um código limpo e conciso. Pode parecer contraditório, mas comentários demais poluem o código. Além disso, se for necessário adicionar comentários para explicar o objetivo de uma classe, método, variável ou qualquer outro módulo, é porque o nome deste elemento ou o código aninhado nele pode ser melhorado.


