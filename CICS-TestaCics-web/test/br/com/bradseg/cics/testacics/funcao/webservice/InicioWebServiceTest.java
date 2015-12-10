package br.com.bradseg.cics.testacics.funcao.webservice;


import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import br.com.bradseg.cics.testacics.funcao.facade.InicioServiceFacade;

public class InicioWebServiceTest {

	private InicioWebService funcionalidadeWebService;

	private InicioServiceFacade mock;

	@Before
	public void setup() {
		funcionalidadeWebService = new InicioWebService();

		// Criar mock do serviço funcionalidadeService.
		mock = EasyMock.createMock(InicioServiceFacade.class);

		// Utilizar o mock na action InicioWebService.
		funcionalidadeWebService.setInicioService(mock);
	}

	@Test
	public void consultarSaudacao() {
		// preparar mock para este cenário
		EasyMock.expect(mock.consultarSaudacao("Fulano")).andReturn("Olá, Fulano");

		// preparar mock para ser utilizado
		EasyMock.replay(mock);

		String result = funcionalidadeWebService.consultarSaudacao("Fulano");

		// verificar se retornou a saudação esperada.
		Assert.assertEquals("Olá, Fulano", result);

		// verificar se o mock foi chamado como esperado
		EasyMock.verify(mock);
	}

}
