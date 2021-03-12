package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Banco {
	
	//criando um obj do tipo empresa para adicionar todas as empresas criadas ao banco
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	//simulando uma chave primaria de um banco de dados
	private static Integer chaveSequencial = 1;
	
	//adicionando bloco estatico para quando abrir o programa ja ter duas empresas cadastradas
	static {
		Empresa empresa = new Empresa();
		//fazendo o encremento das chaves primarias
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		
		lista.add(empresa);
		lista.add(empresa2);
		
		Usuario user1 = new Usuario();
		user1.setLogin("Bruna");
		user1.setSenha("1234");
		
		Usuario user2 = new Usuario();
		user2.setLogin("Marcelo");
		user2.setSenha("4321");
		
		listaUsuarios.add(user1);
		listaUsuarios.add(user2);
		
		
	}

	public void adiciona(Empresa empresa) {
		
		empresa.setId(Banco.chaveSequencial++);
		
		//chamando a lista para add empresa dentro dela
		Banco.lista.add(empresa);
		
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
	}

	public void editaEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.;
			}
		}
		
	}

	public Empresa buscaEmpresaId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {

		for(Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
	
	
	
	

}
