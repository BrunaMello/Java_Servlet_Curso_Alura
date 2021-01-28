package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//pegando as empresas 
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		//pendurando a lista no request 
		request.setAttribute("empresas", lista);
		
		//endereco para onde o dispachador vai
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		
		//comando para dispchador ir 
		rd.forward(request, response);
		
		
		
		
	}

}
