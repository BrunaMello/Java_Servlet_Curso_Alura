package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class NovaEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
System.out.println("Cadastrando nova Empresa");
		
		String nomeEmpresa = request.getParameter("nome"); //retorna sempre uma string!
		String paramDataEmpresa = request.getParameter("data"); //retorna uma string por isso tem que fazer o parsing, 
		//esse get parameter data esta pegando o nome do form jsp
		
		
		//transformando string em date (parsing)
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
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
		
		//pendurar o nome da empresa na requisicao, nao vai funcionar porque a requisicao so vale para o primeiro servlet 
		request.setAttribute("empresa" /*serve como apelido que vai usar no jsp*/ , empresa.getNome());
		
		
		return "redirect:entrada?acao=ListaEmpresa";
		
	}
		

}
