package br.com.alura.gerenciador.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.controller.Acao;


//@WebServlet(urlPatterns="/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Requisitando a acao
		String paramAcao = request.getParameter("acao");
		
		
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null; 
//		boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		
//		if(acaoProtegida && usuarioNaoLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
		
		
		
		//comeco da mudanca dos ifs para OO
		//carregar o nome da classe corretamente
		String nomeDaClasse = "br.com.alura.gerenciador.controller." + paramAcao;
		
		String nomeRequisicao;
		try {
			//carregando a classe com o nome da string 
			Class classe = Class .forName(nomeDaClasse);
			
			//criando uma nova instancia e objeto
			Object obj = classe.newInstance();
			
			//fazer o casting do obj com a interface
			Acao acao = (Acao) obj;
			
			//chamar o metodo executa
		 nomeRequisicao = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		
		//separando a String em duas partes 
		String[] tipoEEndereco = nomeRequisicao.split(":");
		//condicional para usar ou o despacther ou o request conforme a necessidade
		if(tipoEEndereco[0].equals("forward")) {
			
			// endereco para onde o dispachador vai
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);

			// comando para dispchador ir
			rd.forward(request, response);
			
			
		} else {
			
			//redirecionando para a listaempresa depois de remover a empresa
			response.sendRedirect(tipoEEndereco[1]);
			
		}
		
	}
	


//	if (paramAcao.equals("ListaEmpresa")) {
//
//		ListaEmpresa acao = new ListaEmpresa();
//		nomeRequisicao = acao.executa(request, response);
//
//	} else if (paramAcao.equals("RemoveEmpresa")) {
//
//		RemoveEmpresa acao = new RemoveEmpresa();
//		nomeRequisicao = acao.executa(request, response);
//
//	} else if (paramAcao.equals("MostraEmpresas")) {
//
//		MostraEmpresas acao = new MostraEmpresas();
//		nomeRequisicao = acao.executa(request, response);
//
//	} else if (paramAcao.equals("NovaEmpresa")) {
//
//		NovaEmpresa acao = new NovaEmpresa();
//		nomeRequisicao = acao.executa(request, response);
//
//	} else if (paramAcao.equals("AlteraEmpresa")) {
//
//		AlteraEmpresa acao = new AlteraEmpresa();
//		nomeRequisicao = acao.executa(request, response);
//
//	} else if (paramAcao.equals("NovaEmpresaForm")) {
//
//		NovaEmpresaForm acao = new NovaEmpresaForm();
//		nomeRequisicao = acao.executa(request, response);
//
//	}
//	
}
