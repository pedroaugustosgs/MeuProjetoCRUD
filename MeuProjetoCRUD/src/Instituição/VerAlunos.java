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
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VerAlunos extends LoginInstitu{

	public JFrame frmMeuCrud;
	private JTextField tfProcurar;
	public static JButton btnProcurar;
	private JTable tabela; 
	 String pegaEscola=null;
	 private JLabel lblNewLabel;
	 private JLabel lblNewLabel_1;
	 private JLabel lblNewLabel_2;
	 private JLabel lblNewLabel_3;
	 private JLabel lblNewLabel_4;
	 private JLabel lblNewLabel_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerAlunos window = new VerAlunos();
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
	public VerAlunos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeuCrud = new JFrame();
		frmMeuCrud.getContentPane().setBackground(Color.BLACK);
		frmMeuCrud.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Imagem\\img\\students-cap.png"));
		frmMeuCrud.setTitle("Alunos");
		frmMeuCrud.setBounds(100, 100, 821, 500);
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
					tfProcurar.setForeground(Color.WHITE);
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
				
				EditarRemover.main(new String[] {String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0))});
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
			
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
			lblNewLabel_2.setBounds(1, 98, 305, 28);
			frmMeuCrud.getContentPane().add(lblNewLabel_2);
			
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
			lblNewLabel_3.setBounds(298, 98, 269, 28);
			frmMeuCrud.getContentPane().add(lblNewLabel_3);
		
			JScrollPane scrollPane = new JScrollPane(tabela);
			scrollPane.setBounds(64, 178, 671, 203);
			frmMeuCrud.getContentPane().add(scrollPane);
		tfProcurar.setForeground(Color.WHITE);
		tfProcurar.setText("Entre com o nome a ser procurado");
		tfProcurar.setBounds(65, 137, 562, 26);
		frmMeuCrud.getContentPane().add(tfProcurar);
		tfProcurar.setColumns(10);
		
		btnProcurar = new JButton("PROCURAR");
		btnProcurar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnProcurar.setForeground(Color.BLACK);
		btnProcurar.setBackground(Color.LIGHT_GRAY);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfProcurar.getText().equals("Entre com o nome a ser procurado")) {
					ResultSet dados=null;
					String sq="SELECT * FROM alunos WHERE escola=?";
					try {
						PreparedStatement stmt = Conexao.conexao.prepareStatement(sq);
						stmt.setInt(1, id);
						dados = stmt.executeQuery();
						stmt.execute();
						stmt.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					ResultSet dadosLike;
					String sql="SELECT * FROM alunos WHERE nome LIKE ? AND escola=? ORDER BY nome";
					try {
						PreparedStatement s = Conexao.conexao.prepareStatement(sql);
						s.setString(1, "%"+tfProcurar.getText()+"%");
						s.setInt(2, id);
						dadosLike = s.executeQuery();
						s.execute();
						s.close();
						
						criaTabela(dadosLike);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnProcurar.setBounds(641, 128, 164, 39);
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
		btnVoltar.setBounds(1, 432, 164, 39);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(-4, 392, 469, 29);
		frmMeuCrud.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(461, 394, 354, 24);
		frmMeuCrud.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(565, 100, 250, 24);
		frmMeuCrud.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\usuaaaaa.jpg"));
		lblNewLabel_5.setBounds(240, 11, 327, 88);
		frmMeuCrud.getContentPane().add(lblNewLabel_5);
		ResultSet alunos=null;
		String sql1 ="SELECT * FROM alunos WHERE escola=?";
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
		
		criaTabela(alunos);
		
	}// fim do método inicialize
	
	//responsavel por definir os parametros da tabela
	public void criaTabela(ResultSet dados) {
		String[] colunas = {"USUÁRIO","NOME","IDADE","SEXO","E-MAIL","TELEFONE"};
		ArrayList<Object> linhas = new ArrayList<>();
		
		try {
			while (dados.next()) {
				pegaEscola = dados.getString("escola");
				
				linhas.add(new Object[] {
						dados.getString("usuario"),
						dados.getString("nome"),
						dados.getString("idade"),
						dados.getString("sexo").equals("M")?"Masculino":"Feminino",
						dados.getString("email"),
						dados.getString("fone"),
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
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		  
		tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(4).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(5).setCellRenderer(centralizado);
	}
	
	
 }
