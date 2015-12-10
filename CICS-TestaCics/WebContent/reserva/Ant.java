/*		<<- Anota��es Gerais ->>
 		
 		Ctrl+espa�o - Completa a digitaliza��o de um termo existente. Ex.: syso e Ctrl+espa�o completa para System.out.println();
 		Ctrl+Shift+O - Atalho para importar classes (basta posicionar o cursor no local dos import);
  		Alt+Shift+X, J - Atalho para executar a classe principal;
  		Ctrl+F2 - Exibe a documenta��o de uma classe interna selecionada;
  		F3 - Atalho para abrir o local de defini��o de uma chamada de classe ou m�todo selecionado;
  		Alt+Left - Retorna para o local anterior ao F3;
 		Sempre que for acessar o banco de dados, chama um m�todo de servi�o, que chama um m�todo do DAO, que acessa o banco.
 		Para criar m�todos get e set automaticamente: bot�o direito > Source > Generate Getters and Setters
 		
 		Procedimentos para exportar um projeto para ser executado em m�quinas sem eclipse:
			1. bot�o direito no projeto > exportar > Java > Runnable JAR file > Next
			2. Em Lauch configuration, selecionar o projeto que deseja.
			3. Em Library, selecionar uma das tr�s op��es (primeira e segunda testada e ok)
			4. Definir o local para exporta��o em Export destination e clicar em Finish;
			5. Pronto! S� executar.
 		
 		>> SWING
 		
 		Foi usado um outro eclipse (CD-ROM\Eclipse\eclipseSwing01) para trabalhar com Swing,
 		pois neste eclipse tem o plugin WindowBuilder;
 		Obs.: para usar o outro eclipse (Indigo), tem que baixar e instalar o plugin Windows Builder;
 		
 		Para criar um projeto: File/New/Project/Java Project
 		Para criar uma classe: File/New/Class (Definir o nome e marcar a op��o public static void main(String[] args));
  
  		Para criar a Tela, clica no bot�o Create new visual class/Swing/JFrame (barra de Ferramentas), e define o nome da Classe;
  		
  		>> SERVLET
  		
  		Para usar o eclipse para aplica��es Web, tem que instalar o Tomcat;
  		Para cada projeto no eclipse, clique e arraste-o sobre a linha "Tomcat..." na aba Servers ou bot�o direito sobre a linha,
  		Add and Remove, selecionar os projetos desejados da esquerda para direita e Finish.
  		Caso a aba n�o esteja vis�vel, clique em Window\Show View\Other...\Server\Servers
  		
  		Para executar:

			http://localhost:8080/servlet-01/exercicio/alomundo.html, onde "/exercicio/alomundo.html" corresponde ao html que
			chamar� a aplica��o. 
		
		Para executar Java seja no servidor Apache ou IIS tem que instalar o Tomcat como um m�dulo de um deles.
		
		>> Par�metro de requisi��o vem do browser.
		
		Ap�s um acesso a p�ginas java, o Tomcat cria dois objetos no servidor: request e response;
		request - que recebe as requisi��es html;
		
		O que faz uma classe ser um Servlet � o fato dela extender a classe HttpServlet;
		
		Sempre que tiver valor que muda a cada requisi��o do cliente, NUNCA deve usar vari�vel de inst�ncia;
		
		O nome do projeto no eclipse n�o necessariamente � o mesmo nome da aplica��o no servidor. Por padr�o tem o mesmo nome.
		Por�m, para mudar: bot�o direito no projeto/properties/Web Project Settings
		
		Para que o banco seja reconhecido pelo eclipse, tem que colocar o arquivo do banco "ojdbc14" na pasta de instala��o do
		Tomcat "...\apache-tomcat-7.0.27\lib" se n�o vai dar erro;
		
		Para aplica��o web, nunca se cria uma biblioteca do tipo "JPA 2.0" para armazenar os ".jar". Os ".jar" tem que ser 
		armazenado na pasta WebContent/WEB-INF;
		
		Ciclo de vida de um servlet: o m�todo init � executado uma �nica vez, o m�todo doGet � executado v�rias vezes e o 
		m�todo destroy � executado uma �nica vez (quando o servidor � desligado ou o Tomcat � parado pelo administrador, ou 
		quando n�o h� espa�o na mem�ria).
		
		Os objetos request e response � criado para cada requisi��o do browser. Em uma sess�o podem ser criados v�rios objetos
		request e response;
		
		Objeto request - armazena todas as informa��es provenientes do browser do usu�rio;
		
		request.getParameter() - recupera dados (par�metros) passados pelo navegador;
		request.getAttribute() - recupera dados (atribu�dos) passados pelo usu�rio com o m�todo setAttribute();
				
		Objeto response - cria um buffer de 8 kb para cada sess�o que armazena dos dados que ser�o enviados de volta para o servidor.
		S� ap�s o fim do servlet os dados contidos no buffer � enviado para o browser;
		
		Objeto aplica��o - � criado para cada aplica��o e recebe uma lista de dois valores por linha, um valor chave e um objeto.
		Esse objeto pode receber uma chave (String) e um objeto de v�rios servlet, desde que seja da mesma aplica��o;
		
		Objeto sess�o - ingloba v�rias requisi��es do usu�rio. Recebe uma chave e uma valor associado;
		
		Os quatro escopo de p�gina do JAVA s�o: Objeto requisi��o, sess�o, aplica��o e p�gina;
		
		Para ativar o Tomcat no projeto: bot�o direito no projeto > Properties > Targeted Runtimes > marcar o Apache Tomcat;
		
		Todos os dados passados pelo navegador s�o do tipo String, com excess�o de upload de arquivos, que s�o bin�rios;
		
		Para configurar pool de conex�es no Tomcat usa-se o arquivo context.xml (WebContent/META-INF).
		
		
		>> JSP
		
		GoF - padr�o de projeto que diz que tem que ter um classe para cada comando (incluir, excluir, alterar e exibir)
			  a classe de comando tem que ter um comando executar que passa o objeto request
		
		-------------------------------//----------------------------------
		
		Os coment�rios acima j� for�o passados a limpo
		
		Criar projeto Java depois do curso (profissionalmente):
		Para fazer um projeto, n�o usar como base o projeto do exerc�cio 14, fazer o 10 e testar, depois o 11 e testar e assim sucessivamente at� o 14.
		
		Todas as classes Java possuem o m�todo hastCode(), que � implementada na classe Object
		
		Ctrl+Shift+R - atalho para abrir o c�digo de um recurso na perspectiva Java, como por exemplo, abrir um Servlet selecionado;
		
		Coment�rio JPS �: <%-- --%>
		
		Um Forward propaga o objeto request;
		
		Para toda p�gina .jsp � criado o escopo de p�gina (objeto PageContext);
		
		>> STRUTS
		
		Como a classe de controle n�o � feita mais pelo desenvolvedor e sim pertencente ao Struts (ActionServlet), a fabrica do spring deve ser
		criada na classe Action e injetar a classe de servi�o na classe action.
		
		Classes Action tem um m�todo para cada classe;
		Casses DespatchAction tem uma classe com v�rios m�todos;
		
		Para todo formul�rio em Struts tem que ter uma classe associada, que o Struts chama de form-bean. Esta classe, que est� definida no arquivo
		struts-config.xml, recebe o conte�do digitado no formul�rio e o armazena;
		
		Existem 2 tipos de form-bean do pr�prio struts, n�o havendo necessidade de criar manualmente um form-bean:
			DynaActionForm - muito raramente usa esse tipo de form-bean, pois ele n�o faz valida��o dos campos (possui o m�todo validate() que 
							 n�o faz nada). Form-bean usado quando n�o se deseja validar os campos.
			DynaValidatorForm - form-bean usado para valida��o dos campos do formul�rio;
		
		
		>> Ciclo de vida do Struts
		
		A��es executadas em aplica��es Struts ap�s a requisi��o de uma aplica��o:
		
		1. Identifica a aplica��o;
		2. Abre o Web.xml desta aplica��o;
		3. Verifica se existe um mapeamento .do (se n�o, a url est� incompleta e executa o arquivo definido em welcome-file-list. Este arquivo pode direcionar para um mapeamento .do);
		4. Existindo mapeamento .do, � realizado um forward para o ActionServlet, que passa a assumir o controle da aplica��o;
		5. O ActionServlet procura por um m�dulo de aplica��o na tag init-param no Web.xml (Ex.: config/abc). N�o existindo ele busca pela m�dulo padr�o (config);
		6. Encontrando um dos m�dulos de aplica��o, o ActionServlet busca pelo Mapeamento de A��o, configurado na tag init-param, e encontrado dentro do arquivo struts-config.xml ;
		7. No arquivo struts-config.xml � localizada a tag Action-mappings, contendo a p�gina .jsp a ser carregada.
		
		
		Quando n�o se define o escopo que deseja buscar, por exemplo: invez de ${pageScope.reserva.cor} digitar ${reserva.cor}, e procurada 
		pela reserva na seguinte ordem de escopos:
		
		1. Escopo de p�gina;
		2. Escopo de request;
		3. Escopo de sess�o;
		4. Escopo de aplica��o;
		
		Toda requisi��o .do e forward s�o verificadas no struts-config.xml, onde est� configurada a pr�xima etapa/p�gina;
		
		
			Como Ativar o Validator em um Form Din�mico:
			============================================

			1. Configurar o plugin do Validator no struts-config.xml
			   - Validator-rules.xml
			   - validation.xml
			
			2. Definir no struts-config.xml o form bean din�mico que � do tipo  
			   DynaValidatorForm.
			
			3. Definir no arquivo validation.xml o form bean que ser� validado.
			
			4. Colocar na p�gina JSP o tag <html:errors/> para exibir os erros.
			
			5. Definir no Message Resource Bundle (ApplicationResources.propertites) do m�dulo de aplica��o as 
			   entradas que s�o utilizadas pelo tag <html:errors/> e as 
			   mensagens de erro do validator.	
		
  		
  		Em um form-bean do tipo DynaValidatorForm, todos os campos devem ser "tipados" como String, com excess�o para checkbox que deve ser Boolean
  		e campos type="hidden" que deve ser Long, pois o usu�rio n�o digita valor nenhum.
  		
  		
  		O exerc�cio 14 de Struts � o exerc�cio "complet�o", ou seja, ter� todos os melhores e aplic�veis recursos visto no curso. �, na verdade,
  		tudo que foi visto dos exerc�cios 10 a 13 de Struts.

*/
 
/*	Aula18 - 2013/09/14
		
		<<- STRUTS ->>
		
	
		
		

*/
