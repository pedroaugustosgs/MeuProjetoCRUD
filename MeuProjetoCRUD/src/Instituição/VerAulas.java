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

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

public class VerAulas extends LoginInstitu{

	public JFrame frmMeuCrud;
	private JTextField tfProcurar;
	public static JButton btnProcurar;
	private JTable tabela; 
	 String pegaEscola=null;
	 ResultSet alunos=null;
	 ResultSet aulas=null;     
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
		frmMeuCrud.setIconImage(Toolkit.getDefaultToolkit().getImage(VerAulas.class.getResource("/47 - Copia.png")));
		frmMeuCrud.setTitle("MEU CRUD - Alunos Cadastrados");
		frmMeuCrud.setBounds(100, 100, 799, 340);
		frmMeuCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuCrud.getContentPane().setLayout(null);
		frmMeuCrud.setResizable(false);
		frmMeuCrud.setLocationRelativeTo(null);
		
		tfProcurar = new JTextField();
		
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
		tabela.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				int linha = tabela.getSelectedRow();
				ResultSet dadostabela = pegaAula();
				try {
					dadostabela.absolute(linha+1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					AlteraAula.main(new String[] {dadostabela.getString("idaula")});
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  //*****************************
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
		
			JScrollPane scrollPane = new JScrollPane(tabela);
			scrollPane.setBounds(31, 48, 671, 203);
			frmMeuCrud.getContentPane().add(scrollPane);
		tfProcurar.setForeground(Color.LIGHT_GRAY);
		tfProcurar.setText("Entre com o nome a ser procurado");
		tfProcurar.setBounds(31, 11, 591, 26);
		frmMeuCrud.getContentPane().add(tfProcurar);
		tfProcurar.setColumns(10);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnProcurar.setForeground(SystemColor.textHighlight);
		btnProcurar.setBackground(SystemColor.textHighlightText);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfProcurar.getText().equals("Entre com o nome a ser procurado")) {
					criaTabela(new CRUDAlunos().selecionaAlunos());
				}else {
					criaTabela(new CRUDAlunos().procuraNomeAluno(tfProcurar.getText().toString()));	
				}
			}
		});
		btnProcurar.setBounds(626, 9, 157, 28);
		frmMeuCrud.getContentPane().add(btnProcurar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(SystemColor.textHighlight);
		btnVoltar.setBackground(SystemColor.textHighlightText);
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMeuCrud.dispose();
				Principal.main(null);
			}
		});
		btnVoltar.setBounds(31, 262, 122, 39);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		
		
		criaTabela(pegaAula());
		
	}// fim do método inicialize
	
	//responsavel por definir os parametros da tabela
	public void criaTabela(ResultSet dados) {
		String[] colunas = {"materia","conteudo","local","professor"};
		ArrayList<Object> linhas = new ArrayList<>();
		
		try {
			while (dados.next()) {
								
				/*String sql ="SELECT * FROM aulas WHERE professor=?";
				PreparedStatement s = Conexao.conexao.prepareStatement(sql);
				s.setString(1, alunos.getString("idaluno"));
				aulas = s.executeQuery();
				s.execute();
				s.close();*/
				
				linhas.add(new Object[] {
						dados.getString("materia"),
						dados.getString("conteudo"),
						dados.getString("local"),
						dados.getString("professor"),
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
	
	
 }
