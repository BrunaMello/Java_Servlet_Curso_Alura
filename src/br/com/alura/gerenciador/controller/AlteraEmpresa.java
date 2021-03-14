package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class AlteraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// lendo os parametros que vem do formulario
		String paramId = request.getParameter("id");
		String nomeEmpresaString = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");

		String nome = String.valueOf(nomeEmpresaString);

		// fazendo parsing com o id
		Integer id = Integer.valueOf(paramId);

		// fazendo parsing com a data
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		System.out.println("Id: " + id + " Nome: " + nome + " Data: " + dataAbertura + ".");

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaId(id);
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);

		
		return "redirect:entrada?acao=ListaEmpresa";

	}
}
