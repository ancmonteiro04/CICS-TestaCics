package br.com.bradseg.cics.testacics.funcao.action;
	
import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import br.com.bradseg.cics.testacics.funcao.facade.InicioServiceFacade;

import com.opensymphony.xwork2.Action;

public class InicioActionTest {

	private InicioAction inicioAction;

	private InicioServiceFacade mock;

	@Before
	@SuppressWarnings("serial")
	public void setup() {
		inicioAction = new InicioAction() {

			/**
			 * Substituição do método getText(String) para facilitar os testes unitários das actions.
			 */
			@Override
			public String getText(String key) {
				// Retorna a própria chave da mensagem.
				return key;
			}

			@Override
			public String getText(String key, String[] args) {
				// Retorna a própria chave da mensagem.
				return key;
			}
		};
		// Criar mock do serviço InicioService.
		mock = EasyMock.createMock(InicioServiceFacade.class);

		inicioAction.setInicioServiceFacade(mock);
	}

	@Test
	public void inicio() {
		String result = inicioAction.inicio();

		// verificar se retornou sucesso.
		Assert.assertEquals(Action.SUCCESS, result);
		// verificar se retornou uma mensagem de validação.
		Assert.assertEquals(1, inicioAction.getActionMessages().size());
	}

	@Test
	public void consultarSaudacao() {
		// preparar mock para este cenário
		EasyMock.expect(mock.consultarSaudacao("Fulano")).andReturn("Olá, Fulano");

		// preparar mock para ser utilizado
		EasyMock.replay(mock);

		// inicializar nome
		inicioAction.setNome("Fulano");

		String result = inicioAction.consultarSaudacao();

		// verificar se retornou sucesso.
		Assert.assertEquals(Action.SUCCESS, result);
		// verificar se retornou uma mensagem.
		Assert.assertEquals(1, inicioAction.getActionMessages().size());
		// verificar se retornou a mensagem de saudação
		Assert.assertEquals("msg.sucesso.saudacao.mensagem", inicioAction.getActionMessages().iterator().next());
		// verificar se o getNome() retorna o nome passado.
		Assert.assertEquals("Fulano", inicioAction.getNome());
		// verificar se o mock foi chamado como esperado
		EasyMock.verify(mock);
	}

	@Test
	public void consultarSaudacaoComErro() {
		// inicializar nome
		inicioAction.setNome("");

		String result = inicioAction.consultarSaudacao();

		// verificar se retornou sucesso.
		Assert.assertEquals(Action.INPUT, result);
		// verificar se retornou uma mensagem.
		Assert.assertEquals(1, inicioAction.getActionErrors().size());
		// verificar se retornou a mensagem de saudação
		Assert.assertEquals("msg.erro.campo.obrigatorio", inicioAction.getActionErrors().iterator().next());
		// verificar se o getNome() retorna o nome passado.
		Assert.assertEquals("", inicioAction.getNome());
	}
}
