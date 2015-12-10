package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Reserva;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servico.ReservaAppService;
import util.Util;
import excecao.AplicacaoException;

public class ReservaActions extends DispatchAction 
{	
	ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

	private ReservaAppService reservaAppService = (ReservaAppService)
		fabrica.getBean ("reservaAppService");

	public ActionForward recuperaTodasReservas(ActionMapping mapping,
                                               ActionForm form,
                                               HttpServletRequest request,
                                               HttpServletResponse response)
    	throws Exception 
	{	
		List<Reserva> reservas = reservaAppService.recuperaReservas();

     	if (reservas.size() != 0)
   		{	
     		request.setAttribute("reservas", reservas);
			
     		return mapping.findForward("Listar");
   		}
   		else
		{	
   			return mapping.findForward("Inexistente");
    	}
  	}

	public ActionForward salvaOuAtualizaReserva(ActionMapping mapping,
                                                ActionForm form,
                                                HttpServletRequest request,
                                                HttpServletResponse response)
    	throws Exception 
	{	
		Reserva umaReserva = new Reserva(
			             (Long)((DynaValidatorForm)form).get("numero"),
			             (String)((DynaValidatorForm)form).get("enderecoEmail"),
			             (String)((DynaValidatorForm)form).get("cor"),
			             ((Boolean)((DynaValidatorForm)form).get("tetoSolar")).booleanValue(),
			             ((Boolean)((DynaValidatorForm)form).get("vidroEletrico")).booleanValue(),
			             (String)((DynaValidatorForm)form).get("portas"),
	    Util.strToDouble((String)((DynaValidatorForm)form).get("valorLocacao")),
	      Util.strToDate((String)((DynaValidatorForm)form).get("dataLocacao")),
			             (String)((DynaValidatorForm)form).get("agencia"));
		
		
//		Reserva umaReserva = new Reserva();
//		RequestUtils.populate(umaReserva, request);
			             
		if (umaReserva.getNumero() == 0)
		{	
			umaReserva.setNumero(null);
			
			reservaAppService.inclui(umaReserva);

			request.setAttribute("reserva", umaReserva);

	     	return mapping.findForward("Exibir");
		}
		else
		{	
			try
			{	reservaAppService.altera(umaReserva);
				
				request.setAttribute("reserva", umaReserva);
				
				return mapping.findForward("Exibir");
			}
			catch(AplicacaoException e)
			{	
				return mapping.findForward("Inexistente");			
			}
		}
	}

	public ActionForward removeReserva(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response)
        throws Exception 
    {	
        long numero;

        try
        {	numero = Long.parseLong(request.getParameter("numero"));
        }
        catch(NumberFormatException e)
        {	numero = -1L;
        }

        try
        {	
        	reservaAppService.exclui(numero);
            
        	return recuperaTodasReservas(mapping, form, request, response);
        }
        catch(AplicacaoException e)
        {
            return mapping.findForward("Inexistente");
        }
    }

	public ActionForward recuperaUmaReserva(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response)
    	throws Exception 
	{	
		String numString = request.getParameter("numero");

    	long numero;
    	
    	try 
    	{   numero = Long.parseLong(numString); 
    	}
    	catch(NumberFormatException e) 
    	{   numero = -1L; 
    	}
    
    	Reserva reserva;
    	
    	try
    	{	
    		reserva = reservaAppService.recuperaUmaReserva(numero);

    		request.setAttribute("reserva", reserva);
				
			return mapping.findForward("Exibir");
    	}
    	catch(AplicacaoException e)
    	{	
    		return mapping.findForward("Inexistente");
    	}
   	}

	public ActionForward recuperaUmaReservaParaAlterar(ActionMapping mapping,
                                                       ActionForm form,
                                                       HttpServletRequest request,
                                                       HttpServletResponse response)
        throws Exception 
    {	
		String numString = request.getParameter("numero");

		long numero;

		try 
		{   numero = Long.parseLong(numString); 
		}
		catch(NumberFormatException e) 
		{   numero = -1L; 
		}

		try
		{	
			Reserva reserva = reservaAppService.recuperaUmaReserva(numero);

	    	((DynaValidatorForm)form).set("numero", reserva.getNumero());
			((DynaValidatorForm)form).set("enderecoEmail", reserva.getEnderecoEmail());
			((DynaValidatorForm)form).set("cor", reserva.getCor());
			((DynaValidatorForm)form).set("tetoSolar", reserva.getTetoSolar());
			((DynaValidatorForm)form).set("vidroEletrico", reserva.getVidroEletrico());
			((DynaValidatorForm)form).set("portas", reserva.getPortas());
			((DynaValidatorForm)form).set("valorLocacao", Util.doubleToStr(reserva.getValorLocacao()));
			((DynaValidatorForm)form).set("dataLocacao", Util.dateToStr(reserva.getDataLocacao()));
			((DynaValidatorForm)form).set("agencia", reserva.getAgencia());
				
			return mapping.findForward("Editar");
		}
		catch(AplicacaoException e)
		{	
			return mapping.findForward("Inexistente");
		}
    }
}