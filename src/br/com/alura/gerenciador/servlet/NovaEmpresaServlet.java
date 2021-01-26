package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando Empresa");
		
		String nomeEmpresa = request.getParameter("nome"); //retorna sempre uma string!
		String dataEmpresa = request.getParameter("dataEmpresa"); //retorna uma string por isso tem que fazer o parsing
		
		
		//transformando string em date (parsing)
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		//criando uma empresa 
		Empresa empresa = new Empresa();
		
		
		//setando o nome da empresa
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		
		// criando banco 
		Banco banco = new Banco();
		
		//adicionando empresa no banco
		banco.adiciona(empresa);
		
		
		//chamar o jsp
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		
		//pendurar o nome da empresa na requisicao
		request.setAttribute("empresa" /*serve como apelido que vai usar no jsp*/ , empresa.getNome());
		
		//ir para a pagina 
		rd.forward(request, response);
		
		
		
		//service atende get e post 
		//doPost atende somente post 
		//goGet atende somente get
	}
	
	

}
