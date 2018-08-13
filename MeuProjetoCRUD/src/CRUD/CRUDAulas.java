package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Banco.Conexao;

public class CRUDAulas {
	
	public boolean novaAula(String m,String c,int s,int t,int q,int Qui,int sex,int sab,int dom, int cedo,int tar,int noi,String local,int prof,int vagas,
			String DeManha,String ateManha, String DeTarde,String AteTarde, String DeNoite, String AteNoite,Date date, String DeUmaVez, String AteUmaVez) {
		
		String sql="INSERT INTO aulas (materia,conteudo,segunda,terca,quarta,quinta,sexta,sabado,domingo,cedo,tarde,noite,local,professor,vagas,DeManha,AteManha,"
				+ "DeTarde,AteTarde,DeNoite,AteNoite,DiaUmaVez,DeUmaVez,AteUmaVez)"
				+" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, m);
			stmt.setString(2, c);
			stmt.setInt(3, s);
			stmt.setInt(4, t);
			stmt.setInt(5, q);
			stmt.setInt(6, Qui);
			stmt.setInt(7, sex);
			stmt.setInt(8, sab);
			stmt.setInt(9, dom);
			stmt.setInt(10, cedo);
			stmt.setInt(11, tar);
			stmt.setInt(12, noi);
			stmt.setString(13, local);
			stmt.setInt(14, prof);
			stmt.setInt(15, vagas);
			stmt.setString(16, DeManha);
			stmt.setString(17, ateManha);
			stmt.setString(18, DeTarde);
			stmt.setString(19, AteTarde);
			stmt.setString(20, DeNoite);
			stmt.setString(21, AteNoite);
			SimpleDateFormat simples = new SimpleDateFormat("yyyy/MM/dd");
			
			if(date != null) {
				long d = date.getTime();
				stmt.setDate(22, new java.sql.Date(d));
			}else {
				 long d = 0000-00-00;
				stmt.setDate(22, new java.sql.Date(d));
			}
			
			stmt.setString(23, DeUmaVez);
			stmt.setString(24, AteUmaVez);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ResultSet pegaAula() {
		ResultSet aulas=null;
		String sql ="SELECT * FROM aulas";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			aulas = stmt.executeQuery();
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aulas;
	}
	
	
}
