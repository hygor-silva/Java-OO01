package br.com.cadastro.application;

import br.com.cadastro.dao.CadastroDAO;
import br.com.cadastro.model.Cadastro;

public class TesteCadastro {

	public static void main(String[] args) {
		
		CadastroDAO cadastroDao = new CadastroDAO();
		
		Cadastro cadastro = new Cadastro();
		cadastro.setNome("João");
		cadastroDao.save(cadastro);
		
		
		for(Cadastro c: cadastroDao.getCadastros()) {
			System.out.println("Nome: "+ c.getNome() );
		}
		
		Cadastro cadastro1 = new Cadastro();
		cadastro1.setNome("Fernando");
		cadastro1.setId(2);
		
		cadastroDao.update(cadastro1);
		
		Cadastro cadastro2 = new Cadastro();
		cadastro2.setId(3);
		
		cadastroDao.delete(cadastro2);

	}
}
