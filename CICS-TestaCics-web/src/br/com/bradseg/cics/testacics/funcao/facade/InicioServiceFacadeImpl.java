package br.com.bradseg.cics.testacics.funcao.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.bradseg.bsad.framework.core.exception.BusinessException;
import br.com.bradseg.bsad.framework.core.exception.IntegrationException;
import br.com.bradseg.bsad.framework.core.message.Message;
import br.com.bradseg.cics.testacics.funcao.dao.InicioDao;

/**
 * Descrição do serviço
 * 
 * @author Bradesco Seguros
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class InicioServiceFacadeImpl implements InicioServiceFacade {

	@Autowired
	private InicioDao inicioDao;

	/*
	 * (non-Javadoc)
	 */
	public String consultarSaudacao(String saudacao) {

		// Caso o nome informado seja BSAD,
		if (saudacao.equalsIgnoreCase("bsad")) {
			// Lançar uma IntegrationException apenas para exemplificação.
			throw new IntegrationException(new Message("msg.erro.nome.proibido", saudacao));
		}

		// Caso o nome informado seja BSP,
		if (saudacao.equalsIgnoreCase("bsp")) {
			// Lançar uma BusinessException apenas para exemplificação.
			throw new BusinessException(new Message("msg.erro.nome.proibido", saudacao));
		}

		if (null == saudacao || "".equals(saudacao)) {
			saudacao = "[digite uma mensagem aqui]";
		}

		return saudacao;
	}

	public void setInicioDao(InicioDao obj) {
		this.inicioDao = obj;
	}

}
