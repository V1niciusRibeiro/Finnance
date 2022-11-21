package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testes
 */
@WebServlet("/testes")
public class testes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> msg = new ArrayList<String>();
	
		msg.add("E"+"Teeeste erro\n hasgeiuq uigfie rkdgquyi liuhy iebmnoiqw ybuyfdasiqoy ffdasjuio 87a fuas");
		msg.add("S"+"Teeeste suceso");
		msg.add("A"+"Teeeste aviso");
		msg.add("I"+"Teeeste info");
		
		request.setAttribute("Msg", msg);
		request.getRequestDispatcher("ExibeMensagem.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
