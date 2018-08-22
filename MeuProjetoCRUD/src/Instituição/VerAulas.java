package Instituição;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


import Banco.Conexao;
import CRUD.Aluno;
import CRUD.CRUDAlunos;
import JanelaAluno.ConfirmaAula;
import JanelaAluno.ModeloDaTabela;
import JanelaAluno.VisualizaAulas;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VerAulas extends LoginInstitu{

	public JFrame frmMeuCrud;
	private JTextField tfProcurar;
	public static JButton btnProcurar;
	private JTable tabela; 
	 String pegaEscola=null;
	 ResultSet alunos=null;
	 ResultSet aulas=null;     
	 private JLabel lblNewLabel_1;
	 private JLabel lblNewLabel;
	 private JLabel lblNewLabel_2;
	 private JLabel lblNewLabel_3;
	 private JLabel lblNewLabel_4;
	 private JLabel lblNewLabel_5;
	 private JLabel lblNewLabel_7;
	 private JLabel lblNewLabel_6;
	 
	 public String ids[]= new String[100];
		int cont=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerAulas window = new VerAulas();
					window.frmMeuCrud.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VerAulas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeuCrud = new JFrame();
		frmMeuCrud.getContentPane().setBackground(Color.BLACK);
		frmMeuCrud.setIconImage(Toolkit.getDefaultToolkit().getImage(VerAulas.class.getResource("/47 - Copia.png")));
		frmMeuCrud.setTitle("MEU CRUD - Alunos Cadastrados");
		frmMeuCrud.setBounds(100, 100, 887, 525);
		frmMeuCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuCrud.getContentPane().setLayout(null);
		frmMeuCrud.setResizable(false);
		frmMeuCrud.setLocationRelativeTo(null);
		
		tfProcurar = new JTextField();
		tfProcurar.setBackground(Color.BLACK);
		
		tfProcurar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {  //se apertou enter
					btnProcurar.doClick(); //da o clique
				}
			}
		});
		tfProcurar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(tfProcurar.getText().toString().equalsIgnoreCase("Entre com o nome a ser procurado")) {
					tfProcurar.setForeground(Color.BLACK);
					tfProcurar.setText(null);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(tfProcurar.getText().isEmpty()) {
					tfProcurar.setForeground(Color.LIGHT_GRAY);
					tfProcurar.setText("Entre com o nome a ser procurado");
				}
					
			}
		});
		
		tabela = new JTable();
		tabela.setForeground(Color.BLACK);
		tabela.setBackground(Color.WHITE);
		tabela.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				int linha = tabela.getSelectedRow();
				System.out.println(ids[tabela.getSelectedRow()]);
				VisualizaAulas.main(new String[] {ids[tabela.getSelectedRow()]});
				  //*****************************
				frmMeuCrud.dispose();
				
				/*int linha = tabela.getSelectedRow();
				Aluno alunoEdit = new Aluno();
			    alunoEdit.setUsuario(tabela.getValueAt(linha, 1).toString());
			    ResultSet dados=null;
			    String sql = "Select * from alunos WHERE usuario = ?";
			    PreparedStatement s;
				try {
					s = Conexao.conexao.prepareStatement(sql);
					s.setString(1, alunoEdit.getUsuario());
					dados = s.executeQuery();
					s.execute();
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
				
			   
			    
			    try {
			    	if(dados.next()) {
	
						alunoEdit.setNome(dados.getString("nome"));
						
						alunoEdit.setUsuario(dados.getString("usuario"));
						
						alunoEdit.setSenha(dados.getString("senha"));
						
						alunoEdit.setIdade(dados.getInt("idade"));
					    
					    alunoEdit.setSexo(dados.getString("sexo"));
					   
					    alunoEdit.setEmail(dados.getString("email"));
					    
					    alunoEdit.setFone(dados.getString("fone"));
					    
			    	}else {
			    		JOptionPane.showMessageDialog(null, "Erro ao capturar os dados da tabela");
			    	}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    //EditarRemover editar = new EditarRemover();
			    //editar.aluno = alunoEdit;
			    EditarRemover.aluno = alunoEdit;
			    EditarRemover.main(null);
			    frmMeuCrud.dispose();*/
			}
			
		});
			
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
			lblNewLabel_4.setBounds(-11, 84, 460, 39);
			frmMeuCrud.getContentPane().add(lblNewLabel_4);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
			lblNewLabel.setBounds(-3, 394, 328, 32);
			frmMeuCrud.getContentPane().add(lblNewLabel);
		
			JScrollPane scrollPane = new JScrollPane(tabela);
			scrollPane.setBounds(226, 198, 398, 185);
			frmMeuCrud.getContentPane().add(scrollPane);
		tfProcurar.setForeground(Color.WHITE);
		tfProcurar.setText("Entre com o nome a ser procurado");
		tfProcurar.setBounds(89, 150, 604, 26);
		frmMeuCrud.getContentPane().add(tfProcurar);
		tfProcurar.setColumns(10);
		
		btnProcurar = new JButton("PROCURAR");
		btnProcurar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnProcurar.setForeground(Color.BLACK);
		btnProcurar.setBackground(Color.LIGHT_GRAY);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfProcurar.getText().equals("Entre com o nome a ser procurado")) {
					criaTabela(new CRUDAlunos().selecionaAlunos());
				}else {
					criaTabela(new CRUDAlunos().procuraNomeAluno(tfProcurar.getText().toString()));	
				}
			}
		});
		btnProcurar.setBounds(703, 144, 164, 39);
		frmMeuCrud.getContentPane().add(btnProcurar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMeuCrud.dispose();
				Principal.main(null);
			}
		});
		btnVoltar.setBounds(2, 456, 164, 39);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(278, 396, 484, 29);
		frmMeuCrud.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(755, 396, 124, 29);
		frmMeuCrud.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 38, 46, 14);
		frmMeuCrud.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(399, 89, 489, 29);
		frmMeuCrud.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Lupa.png"));
		lblNewLabel_7.setBounds(729, 210, 146, 175);
		frmMeuCrud.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Solicite Uma Nova Aula (4).jpg"));
		lblNewLabel_6.setBounds(310, 22, 255, 67);
		frmMeuCrud.getContentPane().add(lblNewLabel_6);
		
		
		
		criaTabela(pegaAula());
		
	}// fim do método inicialize
	
	//responsavel por definir os parametros da tabela
	public void criaTabela(ResultSet dados) {
		String[] colunas = {"materia","conteudo","local","professor"};
		ArrayList<Object> linhas = new ArrayList<>();
		
		try {
			while (dados.next()) {
								
				boolean continuar=false;
				Date data = new Date();
				Date hoje = new Date();
				
				try {
					data = dados.getDate("DiaUmaVez");
					if(dados.getString("DiaUmaVez").equals("1969-12-31")) {
						continuar = true;
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continuar=true;
					//e.printStackTrace();
				}
				
				//SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				
				if(data.before(hoje) && continuar==false) {
					continue;
				}
				
				ids[cont++]=dados.getString("idaula");
				
				
				linhas.add(new Object[] {
						
						
						Materia(dados.getString("materia")),
						dados.getString("conteudo"),
						dados.getString("local"),
						NomeProf(dados.getString("professor")),  /////////****************************ERRO*******************************//////////
						//dados.getString("sexo").equals("M")?"Masculino":"Feminino",
						//dados.getString("email"),
						//dados.getString("fone"),
						} );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao preencher a tabela");
		}
		ModeloDaTabela modelo = new ModeloDaTabela(colunas, linhas);
		tabela.setModel(modelo);
		
		
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
		
		tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(2).setResizable(false);

		
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		  
		tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);

	}
	
	public String NomeProf(int id) {
		String nomeProf=null;
		ResultSet dadosProf=null;
		//String sql = "SELECT * FROM dependentes WHERE idSocio = ?";
		String sql = "SELECT * FROM alunos "
				+ "INNER JOIN aulas ON alunos.idaluno = aulas.professor Where professor = ?";
		try {
			PreparedStatement s = Banco.Conexao.conexao.prepareStatement(sql);
			s.setInt(1, id); //
			dadosProf = s.executeQuery();
			s.execute();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(dadosProf.next()) {
				nomeProf = dadosProf.getString("nome");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomeProf;
	}
	
	public ResultSet pegaAula() {
		String sql1 ="SELECT * FROM aulas INNER JOIN alunos ON alunos.idaluno = aulas.professor WHERE escola=?";
		//String sql1 ="SELECT * FROM alunos WHERE escola=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql1);
			stmt.setInt(1, id);
			alunos = stmt.executeQuery();
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alunos;
		                                         //*********************************************ERRO******************************************/
	}
public String Materia(String m){

		
		String materia=null;
		
		if(m.equals("RED")) {
			materia="REDAÇÃO";
		}
		if(m.equals("MAT")) {
			materia="MATEMÁTICA";
		}
		if(m.equals("QUI")) {
			materia="QUÍMICA";
		}
		if(m.equals("FIS")) {
			materia="FÍSICA";
		}
		if(m.equals("BIO")) {
			materia="BIOLOGIA";
		}
		if(m.equals("HIS")) {
			materia="HISTÓRIA";
		}
		if(m.equals("GEO")) {
			materia="GEOGRAFIA";
		}
		if(m.equals("PORT")) {
			materia="PORTUGUÊS";
		}
		if(m.equals("FILOS")) {
			materia="FILOSOFIA";
		}
		if(m.equals("ING")) {
			materia="INGLÊS";
		}
		if(m.equals("ESP")) {
			materia="ESPANHOL";
		}
		if(m.equals("LIT")) {
			materia="LITERATURA";
		}
		if(m.equals("SOCIO")) {
			materia="SOCIOLOGIA";
		}
		return materia;
	}
public String NomeProf(String idAula2) {
	String nomeProf=null;
	ResultSet dadosAula=null;

	String idprof=null;
	ResultSet ddNome;
	String sql ="Select * From aulas Where idaula=?";
	try {
		PreparedStatement s = Conexao.conexao.prepareStatement(sql);
		s.setString(1, idAula2);
		dadosAula = s.executeQuery();
		s.execute();
		s.close();
		if(dadosAula.next()) {
			idprof = dadosAula.getString("professor");
		} 
		String sql2="Select * From alunos Where idAluno=?";
		PreparedStatement stmt = Conexao.conexao.prepareStatement(sql2);
		stmt.setString(1, idprof);
		ddNome = stmt.executeQuery();
		stmt.execute();
		stmt.close();
		if(ddNome.next()) {
			nomeProf = ddNome.getString("nome");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return nomeProf;
}
 }
