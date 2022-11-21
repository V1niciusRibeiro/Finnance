package br.com.fiap.fintech.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.Dao.Aplicacao.AplicacaoDAO;
import br.com.fiap.fintech.Dao.Investimento.InvestimentoDAO;
import br.com.fiap.fintech.entity.Aplicacao;
import br.com.fiap.fintech.entity.Investimento;
import br.com.fiap.fintech.entity.Movimentacao;
import br.com.fiap.fintech.util.Function;


@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Integer cd_usuario;
	private Integer cd_conta;
	private ControllerFluxoCaixa controller_fluxo;
	
	private AplicacaoDAO    aplic_dao;
	private InvestimentoDAO invest_dao;
	
	private List<String> msg;
	private Calendar     today;
	private Locale       local_br;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		invest_dao = DAOFactory.getInvestimentoDAO();
		aplic_dao  = DAOFactory.getAplicacapDAO();

		msg 	 = new ArrayList<String>();
		today 	 = Calendar.getInstance();
		local_br = new Locale("pt","BR");	
	
	}
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException{

		cd_usuario = Integer.parseInt(request.getParameter("User"));
		cd_conta   = Integer.parseInt(request.getParameter("Account"));
					
		if (request.getParameter("Action").toUpperCase().trim().equals("SHOW")) {

			controller_fluxo = new ControllerFluxoCaixa(cd_usuario, cd_conta, local_br, today);
			LoadFluxoCaixa(request,response);

			LoadInvestimento(request,response);

		} else {
			
			String mode = request.getParameter("Method");
			request.setAttribute("MovimentacaoTRN", new ControllerMovimentacaoTRN(mode, cd_usuario, cd_conta, 0));
		}
		
		request.setAttribute("Msg", msg);
		request.getRequestDispatcher("Home.jsp").forward(request, response);		
	}
	
	
	private void LoadFluxoCaixa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		request.getSession().setAttribute("MonthInFull", controller_fluxo.getMonth());
		
		try {

			request.setAttribute("ContaSaldo", controller_fluxo.getSaldoConta());

			Double total_receitas = 0.00;
			Double total_despesas = 0.00;
			List<Movimentacao> movimentacoes = controller_fluxo.getMovimentacoes();

			Integer count_rec = 0;
			Integer count_des = 0;
			List<Movimentacao> receitas = new ArrayList<Movimentacao>();
			List<Movimentacao> despesas = new ArrayList<Movimentacao>();
			
			
			for (Movimentacao movimentacao : movimentacoes) {

				if("R".equals(movimentacao.getTp_movimentacao().toUpperCase().trim())) {
					
					total_receitas = total_receitas + movimentacao.getVl_movimentacao();
					
					if (count_rec < 5) {
						receitas.add(movimentacao);
						count_rec ++;
					}
			
				} else{
					
					total_despesas = total_despesas + movimentacao.getVl_movimentacao();	
					
					if (count_des < 5) {
						despesas.add(movimentacao);
						count_des ++;
					}
				}
			}
			
			
			request.setAttribute("TotalReceita", Function.DoubleToCurrency(total_receitas, local_br));
			request.setAttribute("TotalDespesa", Function.DoubleToCurrency(total_despesas, local_br));
			
			request.setAttribute("Receitas", receitas);
			request.setAttribute("Despesas", despesas);
			
			request.setAttribute("Remaining_Rec", controller_fluxo.checkRemaining(count_rec));
			request.setAttribute("Remaining_Des", controller_fluxo.checkRemaining(count_des));
			
		} catch(Exception e) {

			request.setAttribute("ValuesError_FC", "--");
			msg.add("E"+"Falha ao Obter os Dados do Fluxo de Caixa. Usuário / Conta Inexistente ou Falha na sua Conexão.");
		}
	}
	
	
	private void LoadInvestimento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		List<Investimento> lista = invest_dao.getAll();
		request.setAttribute("investimentos", lista);
		
		List<Aplicacao> list = aplic_dao.getAll();
		request.setAttribute("aplicacoes", list);
	}	
}
