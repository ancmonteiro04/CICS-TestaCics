package br.com.bradseg.cics.testacics.funcao.facade;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import br.com.bradseg.bsad.framework.core.exception.BusinessException;
import br.com.bradseg.bsad.framework.core.exception.IntegrationException;
import br.com.bradseg.cics.testacics.funcao.dao.InicioDao;

public class InicioServiceFacadeTest {

	private InicioServiceFacadeImpl funcionalidadeService = new InicioServiceFacadeImpl();

	private InicioDao mock;

	@Before
	public void setup() {
		// Criar mock do dao InicioDao.
		mock = EasyMock.createMock(InicioDao.class);

		// Utilizar o mock no serviço InicioService.
		funcionalidadeService.setInicioDao(mock);
	}

	@Test
	public void consultarSaudacaoEspecifica() {
		String result = funcionalidadeService.consultarSaudacao("Fulano");
		Assert.assertEquals("Fulano", result);
	}

	@Test(expected = IntegrationException.class)
	public void consultarSaudacaoComBsad() {
		funcionalidadeService.consultarSaudacao("bsad");
	}

	@Test(expected = BusinessException.class)
	public void consultarSaudacaoComBsp() {
		funcionalidadeService.consultarSaudacao("bsp");
	}

}
