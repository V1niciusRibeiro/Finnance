package br.com.fiap.fintech.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.Dao.Categoria.CategoriaDAO;
import br.com.fiap.fintech.Dao.ContaUsuario.ContaUsuarioDAO;
import br.com.fiap.fintech.Dao.Movimentacao.MovimentacaoDAO;
import br.com.fiap.fintech.entity.Categoria;
import br.com.fiap.fintech.entity.ContaUsuario;
import br.com.fiap.fintech.entity.Movimentacao;
import br.com.fiap.fintech.exception.DBException;


@WebServlet("/ServletMovimentacao")
public class ServletMovimentacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Integer cd_usuario;
	private Integer cd_conta;
	
	private ContaUsuarioDAO conta_dao;
	private MovimentacaoDAO mov_dao;
	private CategoriaDAO cat_dao;
	private List<String> msg;
	
	private String redirect;	
	
	@Override
	public void init() throws ServletException {
		super.init();
		conta_dao = DAOFactory.getContaDAO();
		mov_dao   = DAOFactory.getMovimentacaoDAO();
		cat_dao   = DAOFactory.getCategoriaDAO();
		msg       = new ArrayList<String>();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException{

		cd_usuario = Integer.parseInt(request.getParameter("User"));
		cd_conta   = Integer.parseInt(request.getParameter("Account"));
		
		if (request.getParameter("Action") != null) {
			if (request.getParameter("Action").toUpperCase().trim().equals("TRNOPEN")) {
				
				String  mode 			= request.getParameter("Method").substring(0,3);
				Integer cd_movimentacao = Integer.parseInt(request.getParameter("Method").substring(3));
				request.setAttribute("MovimentacaoTRN", new ControllerMovimentacaoTRN(mode, cd_usuario, cd_conta, cd_movimentacao));

			} else {

				request.getSession().setAttribute("Title", "Movimentações");
				request.getSession().setAttribute("h1", "Histórico Movimentações");
			
				List<String> titles = new ArrayList<String>();
				String[] values = "L10Tipo-L40Categoria-L30Valor-C10Data-C05-C05".split("-");
				for (int i = 0 ; i < values.length ; i++) {
					titles.add(values[i]);
				}
				
				request.getSession().setAttribute("Titles", titles);
				
				List<Movimentacao> movimentacoes = mov_dao.getAllByConta(cd_usuario, cd_conta);		
				request.getSession().setAttribute("Movimentacoes", movimentacoes);
			}
		
			request.getRequestDispatcher("Listagem.jsp").forward(request, response);

		} else {
			ExecuteMethod(request, response, request.getParameter("Method"));
			response.sendRedirect(redirect+"?User="+cd_usuario+"&Account="+cd_conta+"&Action=Show");
		}
	}
	
	
	private void ExecuteMethod(HttpServletRequest request, HttpServletResponse response, String mode)
			  throws ServletException, IOException{
		
		redirect = "ServletMovimentacao";
		if (mode.substring(0,3).equals("INS")) {
			if (mode.length() > 3) {
				redirect = "ServletHome";
			}
		}
		
		try {
			
			Integer   cd_movimentacao = mode.substring(0,3).equals("INS") ? 0 : Integer.parseInt(request.getParameter("Code_Mov"));
			Categoria categoria 	  = cat_dao.getByID(Integer.parseInt(request.getParameter("Categoria")));
			Double 	  vl_movimentacao = Double.parseDouble(request.getParameter("Valor"));
			String    tp_movimentacao = request.getParameter("Tipo").toUpperCase().trim();
			Calendar  dt_movimentacao = Calendar.getInstance();
			dt_movimentacao.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Data")));
			
			Movimentacao movimentacao = new Movimentacao(cd_usuario, cd_conta, cd_movimentacao, categoria, dt_movimentacao, vl_movimentacao, tp_movimentacao);

			int multiplicador = 1;

			switch (mode.substring(0,3)) {
				case "INS":
					mov_dao.insertByID(movimentacao);
					break;
				
				case "UPD":
					mov_dao.updateByID(movimentacao);				
					break;

				case "DLT":
					mov_dao.deleteByID(cd_usuario, cd_conta, cd_movimentacao);
					multiplicador = -1;
					break;
			}
			
			
			ContaUsuario user_account = conta_dao.getByID(cd_usuario, cd_conta);
			user_account.setVl_saldo(user_account.getVl_saldo() + (movimentacao.getVl_movimentacao() * (movimentacao.getTp_movimentacao().equals("R") ? multiplicador : (multiplicador*-1))));
			conta_dao.updateByID(user_account);		

			msg.add("S"+"Movimentação Salva!");
			
		} catch (DBException db) {
			msg.add("E"+"Falha ao Conectar com o Banco de Dados!");
			System.out.println(db);
		} catch (Exception e) {
			msg.add("E"+"Valores Inválidos!");
			System.out.println(e);
		}	
	}
	
}
