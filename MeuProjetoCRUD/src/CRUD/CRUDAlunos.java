package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;

public class CRUDAlunos {
	
	Conexao c = new Conexao();
	//insert
	public boolean novoAluno(String u, String n,int i,String s,String e,String f,String se,int escola) {
		String sql = "INSERT INTO alunos (usuario, nome,idade,sexo,email,fone,senha,escola) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, u);
			stmt.setString(2, n);
			stmt.setInt(3, i);
			stmt.setString(4, s);
			stmt.setString(5, e);
			stmt.setString(6, f);
			stmt.setString(7, se);
			stmt.setInt(8,escola);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	//delete
	public boolean removeAluno(int id) {
		String sql = "DELETE FROM alunos WHERE idaluno=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alterarSenha(
			String s,String id) {
		String sql = "UPDATE alunos "
				+ "SET senha=? WHERE idaluno =?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, s);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	public boolean alterarAluno(
			String n,String i,String e, String f,String id) {
		String sql = "UPDATE alunos "
				+ "SET nome=?, idade=?,email=?,fone=?,foto=? "
				+ "WHERE idaluno = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, n);
			stmt.setString(2, i);
			stmt.setString(3, e);
			stmt.setString(4, f);
			stmt.setString(5, id);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selecionaAlunos() {
		ResultSet tabela = null;
		String sql = "SELECT * FROM alunos";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
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
	
	public ResultSet procuraNomeAluno(String n) {
		ResultSet tabela = null;
		String sql = "SELECT * FROM alunos WHERE nome LIKE ?";
		try {
			PreparedStatement s = Conexao.conexao.prepareStatement(sql);
			s.setString(1, "%"+n+"%");
			tabela = s.executeQuery();
			s.execute();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao selecionar os dados do aluno!");
			tabela = null;
		}
		return tabela;
		
		
	}
	public boolean novoAlunologin(String l, String s) {
		String sql = "INSERT INTO login (login,senha) "
				+ "VALUES (?,?)";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, l);
			stmt.setString(2, s);
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
