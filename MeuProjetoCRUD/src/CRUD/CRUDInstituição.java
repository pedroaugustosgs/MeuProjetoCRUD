package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;

public class CRUDInstituição {

	Conexao c = new Conexao();
	//insert
	public boolean novaInstitu(String n, String cnpj,String e,String f,String s) {
		String sql = "INSERT INTO instituição (nome,cnpj,email,fone,senha) "
				+ "VALUES (?,?,?,?,?)";
		try {
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
			stmt.setString(1, n);
			stmt.setString(2, cnpj);
			stmt.setString(3, e);
			stmt.setString(4, f);
			stmt.setString(5, s);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selecionaInsitu() {
		ResultSet tabela = null;
		String sql = "SELECT * FROM instituição";
		try {
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
			tabela = stmt.executeQuery();
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ocorreu um erro ao selecionar os dados");
			return tabela=null;
		}
		return tabela;
	}
	
	public ResultSet procurainsituição(String n) {
		ResultSet tabela = null;
		String sql = "SELECT * FROM instituição WHERE cnpj LIKE ?";
		try {
			PreparedStatement s = Conexao.getConexao().prepareStatement(sql);
			s.setString(1, "%"+n+"%");
			tabela = s.executeQuery();
			s.execute();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao selecionar os dados da insituição!");
			tabela = null;
		}
		return tabela;
		
		
	}
	public boolean alterarAluno(
			String n,int i,String e, String f,int id) {
		String sql = "UPDATE alunos "
				+ "SET nome=?, idade=?,email=?,fone=? "
				+ "WHERE idaluno = ?";
		try {
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
			stmt.setString(1, n);
			stmt.setInt(2, i);
			stmt.setString(3, e);
			stmt.setString(4, f);
			
			stmt.setInt(5, id);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
		
	}

