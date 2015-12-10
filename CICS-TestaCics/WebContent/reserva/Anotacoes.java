/*		<<- Anotações Gerais ->>
 		
 		Ctrl+espaço - Completa a digitalização de um termo existente. Ex.: syso e Ctrl+espaço completa para System.out.println();
 		Ctrl+Shift+O - Atalho para importar classes (basta posicionar o cursor no local dos import);
  		Alt+Shift+X, J - Atalho para executar a classe principal;
  		Ctrl+F2 - Exibe a documentação de uma classe interna selecionada;
  		F3 - Atalho para abrir o local de definição de uma chamada de classe ou método selecionado;
  		Alt+Left - Retorna para o local anterior ao F3;
 		Sempre que for acessar o banco de dados, chama um método de serviço, que chama um método do DAO, que acessa o banco.
 		Para criar métodos get e set automaticamente: botão direito > Source > Generate Getters and Setters
 		
 		Procedimentos para exportar um projeto para ser executado em máquinas sem eclipse:
			1. botão direito no projeto > exportar > Java > Runnable JAR file > Next
			2. Em Lauch configuration, selecionar o projeto que deseja.
			3. Em Library, selecionar uma das três opções (primeira e segunda testada e ok)
			4. Definir o local para exportação em Export destination e clicar em Finish;
			5. Pronto! Só executar.
 		
 		>> SWING
 		
 		Foi usado um outro eclipse (CD-ROM\Eclipse\eclipseSwing01) para trabalhar com Swing,
 		pois neste eclipse tem o plugin WindowBuilder;
 		Obs.: para usar o outro eclipse (Indigo), tem que baixar e instalar o plugin Windows Builder;
 		
 		Para criar um projeto: File/New/Project/Java Project
 		Para criar uma classe: File/New/Class (Definir o nome e marcar a opção public static void main(String[] args));
  
  		Para criar a Tela, clica no botão Create new visual class/Swing/JFrame (barra de Ferramentas), e define o nome da Classe;
  		
  		>> SERVLET
  		
  		Para usar o eclipse para aplicações Web, tem que instalar o Tomcat;
  		Para cada projeto no eclipse, clique e arraste-o sobre a linha "Tomcat..." na aba Servers ou botão direito sobre a linha,
  		Add and Remove, selecionar os projetos desejados da esquerda para direita e Finish.
  		Caso a aba não esteja visível, clique em Window\Show View\Other...\Server\Servers
  		
  		Para executar:

			http://localhost:8080/servlet-01/exercicio/alomundo.html, onde "/exercicio/alomundo.html" corresponde ao html que
			chamará a aplicação. 
		
		Para executar Java seja no servidor Apache ou IIS tem que instalar o Tomcat como um módulo de um deles.
		
		>> Parâmetro de requisição vem do browser.
		
		Após um acesso a páginas java, o Tomcat cria dois objetos no servidor: request e response;
		request - que recebe as requisições html;
		
		O que faz uma classe ser um Servlet é o fato dela extender a classe HttpServlet;
		
		Sempre que tiver valor que muda a cada requisição do cliente, NUNCA deve usar variável de instância;
		
		O nome do projeto no eclipse não necessariamente é o mesmo nome da aplicação no servidor. Por padrão tem o mesmo nome.
		Porém, para mudar: botão direito no projeto/properties/Web Project Settings
		
		Para que o banco seja reconhecido pelo eclipse, tem que colocar o arquivo do banco "ojdbc14" na pasta de instalação do
		Tomcat "...\apache-tomcat-7.0.27\lib" se não vai dar erro;
		
		Para aplicação web, nunca se cria uma biblioteca do tipo "JPA 2.0" para armazenar os ".jar". Os ".jar" tem que ser 
		armazenado na pasta WebContent/WEB-INF;
		
		Ciclo de vida de um servlet: o método init é executado uma única vez, o método doGet é executado várias vezes e o 
		método destroy é executado uma única vez (quando o servidor é desligado ou o Tomcat é parado pelo administrador, ou 
		quando não há espaço na memória).
		
		Os objetos request e response é criado para cada requisição do browser. Em uma sessão podem ser criados vários objetos
		request e response;
		
		Objeto request - armazena todas as informações provenientes do browser do usuário;
		
		request.getParameter() - recupera dados (parâmetros) passados pelo navegador;
		request.getAttribute() - recupera dados (atribuídos) passados pelo usuário com o método setAttribute();
				
		Objeto response - cria um buffer de 8 kb para cada sessão que armazena dos dados que serão enviados de volta para o servidor.
		Só após o fim do servlet os dados contidos no buffer é enviado para o browser;
		
		Objeto aplicação - é criado para cada aplicação e recebe uma lista de dois valores por linha, um valor chave e um objeto.
		Esse objeto pode receber uma chave (String) e um objeto de vários servlet, desde que seja da mesma aplicação;
		
		Objeto sessão - ingloba várias requisições do usuário. Recebe uma chave e uma valor associado;
		
		Os quatro escopo de página do JAVA são: Objeto requisição, sessão, aplicação e página;
		
		Para ativar o Tomcat no projeto: botão direito no projeto > Properties > Targeted Runtimes > marcar o Apache Tomcat;
		
		Todos os dados passados pelo navegador são do tipo String, com excessão de upload de arquivos, que são binários;
		
		Para configurar pool de conexões no Tomcat usa-se o arquivo context.xml (WebContent/META-INF).
		
		
		>> JSP
		
		GoF - padrão de projeto que diz que tem que ter um classe para cada comando (incluir, excluir, alterar e exibir)
			  a classe de comando tem que ter um comando executar que passa o objeto request
		
		-------------------------------//----------------------------------
		
		Os comentários acima já forão passados a limpo
		
		Criar projeto Java depois do curso (profissionalmente):
		Para fazer um projeto, não usar como base o projeto do exercício 14, fazer o 10 e testar, depois o 11 e testar e assim sucessivamente até o 14.
		
		Todas as classes Java possuem o método hastCode(), que é implementada na classe Object
		
		Ctrl+Shift+R - atalho para abrir o código de um recurso na perspectiva Java, como por exemplo, abrir um Servlet selecionado;
		
		Comentário JPS é: <%-- --%>
		
		Um Forward propaga o objeto request;
		
		Para toda página .jsp é criado o escopo de página (objeto PageContext);
		
		>> STRUTS
		
		Como a classe de controle não é feita mais pelo desenvolvedor e sim pertencente ao Struts (ActionServlet), a fabrica do spring deve ser
		criada na classe Action e injetar a classe de serviço na classe action.
		
		Classes Action tem um método para cada classe;
		Casses DespatchAction tem uma classe com vários métodos;
		
		Para todo formulário em Struts tem que ter uma classe associada, que o Struts chama de form-bean. Esta classe, que está definida no arquivo
		struts-config.xml, recebe o conteúdo digitado no formulário e o armazena;
		
		Existem 2 tipos de form-bean do próprio struts, não havendo necessidade de criar manualmente um form-bean:
			DynaActionForm - muito raramente usa esse tipo de form-bean, pois ele não faz validação dos campos (possui o método validate() que 
							 não faz nada). Form-bean usado quando não se deseja validar os campos.
			DynaValidatorForm - form-bean usado para validação dos campos do formulário;
		
		
		>> Ciclo de vida do Struts
		
		Ações executadas em aplicações Struts após a requisição de uma aplicação:
		
		1. Identifica a aplicação;
		2. Abre o Web.xml desta aplicação;
		3. Verifica se existe um mapeamento .do (se não, a url está incompleta e executa o arquivo definido em welcome-file-list. Este arquivo pode direcionar para um mapeamento .do);
		4. Existindo mapeamento .do, é realizado um forward para o ActionServlet, que passa a assumir o controle da aplicação;
		5. O ActionServlet procura por um módulo de aplicação na tag init-param no Web.xml (Ex.: config/abc). Não existindo ele busca pela módulo padrão (config);
		6. Encontrando um dos módulos de aplicação, o ActionServlet busca pelo Mapeamento de Ação, configurado na tag init-param, e encontrado dentro do arquivo struts-config.xml ;
		7. No arquivo struts-config.xml é localizada a tag Action-mappings, contendo a página .jsp a ser carregada.
		
		
		Quando não se define o escopo que deseja buscar, por exemplo: invez de ${pageScope.reserva.cor} digitar ${reserva.cor}, e procurada 
		pela reserva na seguinte ordem de escopos:
		
		1. Escopo de página;
		2. Escopo de request;
		3. Escopo de sessão;
		4. Escopo de aplicação;
		
		Toda requisição .do e forward são verificadas no struts-config.xml, onde está configurada a próxima etapa/página;
		
		
			Como Ativar o Validator em um Form Dinâmico:
			============================================

			1. Configurar o plugin do Validator no struts-config.xml
			   - Validator-rules.xml
			   - validation.xml
			
			2. Definir no struts-config.xml o form bean dinâmico que é do tipo  
			   DynaValidatorForm.
			
			3. Definir no arquivo validation.xml o form bean que será validado.
			
			4. Colocar na página JSP o tag <html:errors/> para exibir os erros.
			
			5. Definir no Message Resource Bundle (ApplicationResources.propertites) do módulo de aplicação as 
			   entradas que são utilizadas pelo tag <html:errors/> e as 
			   mensagens de erro do validator.	
		
  		
  		Em um form-bean do tipo DynaValidatorForm, todos os campos devem ser "tipados" como String, com excessão para checkbox que deve ser Boolean
  		e campos type="hidden" que deve ser Long, pois o usuário não digita valor nenhum.
  		
  		
  		O exercício 14 de Struts é o exercício "completão", ou seja, terá todos os melhores e aplicáveis recursos visto no curso. É, na verdade,
  		tudo que foi visto dos exercícios 10 a 13 de Struts.

*/
 
/*	Aula18 - 2013/09/14
		
		<<- STRUTS ->>
		
	
		
		

*/
