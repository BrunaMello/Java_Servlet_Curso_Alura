package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controller.Acao;

//@WebFilter(urlPatterns="/entrada")
public class ControladorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		
		//fazendo o cast
		System.out.println("ControladorFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// Requisitando a acao
		String paramAcao = request.getParameter("acao");

		String nomeDaClasse = "br.com.alura.gerenciador.controller." + paramAcao;

		String nomeRequisicao;
		try {
			// carregando a classe com o nome da string
			Class classe = Class.forName(nomeDaClasse);

			// criando uma nova instancia e objeto
			Object obj = classe.newInstance();

			// fazer o casting do obj com a interface
			Acao acao = (Acao) obj;

			// chamar o metodo executa
			nomeRequisicao = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		// separando a String em duas partes
		String[] tipoEEndereco = nomeRequisicao.split(":");
		// condicional para usar ou o despacther ou o request conforme a necessidade
		if (tipoEEndereco[0].equals("forward")) {

			// endereco para onde o dispachador vai
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);

			// comando para dispchador ir
			rd.forward(request, response);

		} else {

			// redirecionando para a listaempresa depois de remover a empresa
			response.sendRedirect(tipoEEndereco[1]);

		}

	}

}
