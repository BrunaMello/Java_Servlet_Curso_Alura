package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class MostraEmpresas implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
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
		
		
		return "forward:formAlteraEmpresa.jsp";	
	}

}
