package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	//criando um obj do tipo empresa para adicionar todas as empresas criadas ao banco
	private static List<Empresa> listaEmpresas = new ArrayList<>();
	
	//adicionando bloco estatico para quando abrir o programa ja ter duas empresas cadastradas
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		
		//chamando a lista para add empresa dentro dela
		listaEmpresas.add(empresa);
		
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresas;
	}
	
	
	
	

}
