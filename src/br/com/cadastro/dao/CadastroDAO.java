package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastro.factory.ConnectionFactory;
import br.com.cadastro.model.Cadastro;

public class CadastroDAO {

	public void save(Cadastro cadastro) {
		
		String sql = "INSERT INTO cadastro(nome) VALUES (?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cadastro.getNome());
			
			pstm.execute();
			System.out.println("Cadastrado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				} if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Cadastro> getCadastros(){
		
		String sql = "SELECT * FROM cadastro";
		
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Cadastro cadastro = new Cadastro();
				
				cadastro.setNome(rset.getString("nome"));
				
				cadastros.add(cadastro);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(rset!=null) {
				rset.close();
			}
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
			} 
		} catch (Exception e) {
			e.printStackTrace();
			}
		}

		return cadastros;
	}
	
	public void update(Cadastro cadastro) {
		
		String sql = "UPDATE cadastro set nome = ? where id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cadastro.getNome());
			pstm.setInt(2, cadastro.getId());
			
			pstm.execute();
			
			System.out.println("Dados alterados com sucesso!!!");
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try{
				if(pstm != null) {
					pstm.close();
				}
				if(conn!=null){
					conn.close();				
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void delete(Cadastro cadastro) {
		
		String sql = "DELETE FROM cadastro where id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, cadastro.getId());
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(pstm != null) {
					pstm.close();
				}
				if(conn!=null){
					conn.close();				
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
