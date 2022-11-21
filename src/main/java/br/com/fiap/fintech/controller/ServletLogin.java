package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.Dao.Usuario.UsuarioDAO;
import br.com.fiap.fintech.entity.Usuario;
import br.com.fiap.fintech.util.CriptografiaUtils;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;
	private List<String> msg;


	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getUsuarioDAO();
        msg = new ArrayList<String>();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException{
		try {

			String email = request.getParameter("email");
			String senha = CriptografiaUtils.criptografar(request.getParameter("senha")).trim();

			Usuario usuario = dao.validarUsuario(email, senha);

			if (usuario != null) {

				Integer cd_usuario = usuario.getCd_usuario();
				Integer cd_conta   = 1;

				request.getSession().setAttribute("CurrentPage", "Home");
				request.getSession().setAttribute("UserEmail" , usuario.getEmail());
				request.getSession().setAttribute("UserName" , usuario.getNm_usuario());
				response.sendRedirect("ServletHome?User="+cd_usuario+"&Account="+cd_conta+"&Action=Show");

			} else {

				msg.add("E"+"Usuário e/ou senha inválidos");
				request.setAttribute("Msg", msg);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		} catch (Exception e) {

			msg.add("E"+"Falha ao Conectar com o Banco de Dados!");
			request.setAttribute("Msg", msg);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}
}
