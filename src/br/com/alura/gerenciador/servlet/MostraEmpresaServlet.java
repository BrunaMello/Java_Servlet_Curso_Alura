package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class MostraEmpresaServlet
 */
@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Mostando Empresa");

		//lendo e fazendo o parsing do parametro
		String paramId = request.getParameter("id");
		
		//parsing
		Integer id = Integer.valueOf(paramId);

		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaId(id);
		
		System.out.println(empresa.getId());
		System.out.println(empresa.getNome());
		
		//levando o atributo para dentro do form
		request.setAttribute("empresa", empresa);
		
		//indo para a pagina jsp junto com os atributos
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
		

	}

}
