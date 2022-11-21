package br.com.fiap.fintech.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.entity.Usuario;

@WebFilter("/*")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		List<String> msg = new ArrayList<String>();
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String url = req.getRequestURI();
		String email = (String) session.getAttribute("UserEmail");
		
		
		if (email == null && !url.contains("Login") && !url.contains("Resources") && !url.contains("NovaConta") && !url.contains("Cadastro")) {
		
			msg.add("E"+"Entre com um Email e Senha!");
			request.setAttribute("Msg", msg);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
	
		} else {

			if (!url.contains("Login") && !url.contains("Resources") && !url.contains("NovaConta") && !url.contains("Cadastro")) {
				
				Integer cd_usuario = Integer.parseInt(request.getParameter("User"));
				Usuario usuario    = DAOFactory.getUsuarioDAO().getByID(cd_usuario);
				
				if (usuario != null) {
					
					if (!usuario.getEmail().toUpperCase().trim().equals(email.toUpperCase().trim())) {
						request.getRequestDispatcher("Login.jsp").forward(request, response);
						
					} else {chain.doFilter(request, response);}

				} else {request.getRequestDispatcher("Login.jsp").forward(request, response);}
		
			} else {chain.doFilter(request, response);}
		}
	}
}
