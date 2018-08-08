package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection conexao = null;
	
	public static Connection getConexao() {
		//Connection conexao = null;
		//"jdbc:mysql//127.0.0.1:3307/alunos"
		String url = "jdbc:mysql://localhost:3307/alunos";              	//************** MSTSC    
																			//************** IP 189.91.101.54   Porta 3392   
																			//************** Usuario Senai 		Senha @ABCabc123
																			//************** MySql    Porta 3308    Usuario/senha root
		try {
			conexao = DriverManager.getConnection(url,"root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro os conectar-se ao banco de dados");
		}
		return conexao;
	}
}
