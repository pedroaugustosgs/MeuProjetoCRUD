package JanelaAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.text.MaskFormatter;


import Banco.Conexao;
import CRUD.Aluno;
import CRUD.CRUDAlunos;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Toolkit;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
public class Perfil extends Login {
	
	int ee;
	public JFrame frmMeuCrud;
	public String anterior = "";
	protected Object btnlocal;
	public static Aluno aluno;
	private MaskFormatter mascaraFone;
	public ResultSet dados = null;
	public static int voltar=0;
	//public static Aluno aluno;
	
	File file=null;
	FileInputStream fis=null;
	public String caminho=null;
	JFileChooser explorer = new JFileChooser();
	private JLabel lblFotoPerfil;
	private JLabel tftelefone;
	private JLabel tfIdade;
	private JLabel tfemail;
	private JLabel tfNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil window = new Perfil();
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
	public Perfil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeuCrud = new JFrame();
		frmMeuCrud.getContentPane().setBackground(Color.BLACK);
		frmMeuCrud.setIconImage(Toolkit.getDefaultToolkit().getImage(Perfil.class.getResource("/47 - Copia.png")));
		frmMeuCrud.setTitle("MEU CRUD - Alunos Cadastrados");
		frmMeuCrud.setBounds(100, 100, 787, 535);
		frmMeuCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuCrud.getContentPane().setLayout(null);
		frmMeuCrud.setResizable(false);
		frmMeuCrud.setLocationRelativeTo(null);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBackground(Color.LIGHT_GRAY);
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tfNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe um nome valido!");
					tfNome.requestFocus();
					return;
				}
				String nome = tfNome.getText().toString();
				
				if(!(tfemail.getText().contains("@") && tfemail.getText().contains("."))) {
					JOptionPane.showMessageDialog(null, "E-mail invalido!");
					tfemail.requestFocus();
					return;
				}
				String email = tfemail.getText().toString();
				
				if(tftelefone.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe um telefone!");
					tftelefone.requestFocus();
					return;		
				}
				String fone = tftelefone.getText().toString();
				
				if(tfIdade.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe uma idade V�lida!");
					tfIdade.requestFocus();
					return;
				}
				String idade = tfIdade.getText().toString();
				
				if(caminho != null) {
					file = new File(caminho);
					try {
						fis = new FileInputStream(file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				///***********************************************************************
				String sql = "UPDATE alunos "
						+ "SET nome=?, idade=?,email=?,fone=?,foto=? "
						+ "WHERE idaluno = ?";
				try {
					PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
					stmt.setString(1, nome);
					stmt.setString(2, idade);
					stmt.setString(3, email);
					stmt.setString(4, fone);
					if(caminho==null) {
						stmt.setBinaryStream(5, fis, 0);
					}else {
						stmt.setBinaryStream(5, fis,file.length());
					}
					stmt.setString(6, id);
					stmt.execute();
					stmt.close();
					JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
					PlaAluno.main(null);
					frmMeuCrud.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao alterar o aluno!");
				}
				/*CRUDAlunos alterar = new CRUDAlunos();
				if(alterar.alterarAluno(nome, idade, email, fone, id)) {
					JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao alterar o aluno!");
				}*/
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(-27, 101, 463, 35);
		frmMeuCrud.getContentPane().add(lblNewLabel_1);
		
		lblFotoPerfil = new JLabel("");
		lblFotoPerfil.setForeground(Color.WHITE);
		lblFotoPerfil.setBackground(Color.WHITE);
		lblFotoPerfil.setBounds(577, 146, 190, 189);
		frmMeuCrud.getContentPane().add(lblFotoPerfil);
		lblFotoPerfil.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
		
		try {
			mascaraFone = new MaskFormatter("## ####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTelefone.setBounds(18, 339, 86, 21);
		frmMeuCrud.getContentPane().add(lblTelefone);
		btnSalvar.setBounds(1, 467, 164, 39);
		frmMeuCrud.getContentPane().add(btnSalvar);
		
		JLabel lblSenha = new JLabel("Idade:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSenha.setBounds(20, 287, 60, 21);
		frmMeuCrud.getContentPane().add(lblSenha);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(20, 234, 74, 21);
		frmMeuCrud.getContentPane().add(lblEmail);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					PlaAluno.main(null);
					frmMeuCrud.dispose();
			}
		});
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(617, 467, 164, 39);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		JLabel lblNomeCtfnoompleto = DefaultComponentFactory.getInstance().createTitle("Nome:");
		lblNomeCtfnoompleto.setForeground(Color.WHITE);
		lblNomeCtfnoompleto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNomeCtfnoompleto.setBounds(21, 180, 70, 30);
		frmMeuCrud.getContentPane().add(lblNomeCtfnoompleto);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(623, 396, 46, 14);
		frmMeuCrud.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Chapeu azul.png"));
		lblNewLabel_3.setBounds(425, 42, 152, 71);
		frmMeuCrud.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(1, 436, 389, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_8.setBounds(379, 436, 402, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(-12, -4, 453, 35);
		frmMeuCrud.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(433, -4, 389, 35);
		frmMeuCrud.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(428, 102, 394, 33);
		frmMeuCrud.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\A.png"));
		lblNewLabel_5.setBounds(147, 30, 406, 189);
		frmMeuCrud.getContentPane().add(lblNewLabel_5);
		
		tfNome = new JLabel("New label");
		tfNome.setBounds(88, 187, 221, 21);
		frmMeuCrud.getContentPane().add(tfNome);
		
		tfemail = new JLabel("New label");
		tfemail.setBounds(96, 236, 187, 20);
		frmMeuCrud.getContentPane().add(tfemail);
		
		tfIdade = new JLabel("New label");
		tfIdade.setBounds(84, 286, 89, 23);
		frmMeuCrud.getContentPane().add(tfIdade);
		
		tftelefone = new JLabel("New label");
		tftelefone.setBounds(106, 340, 225, 22);
		frmMeuCrud.getContentPane().add(tftelefone);
		//System.out.println(EntraAluno.volt);
		if(EntraAluno.volt==0) {
			PreencheTelaC();
		}else {
			PreencheTela();
		}
		
	}// fim do m�todo inicialize
	
	public void PreencheTela() {
		String sql = "SELECT * FROM alunos WHERE idaluno=?";
		PreparedStatement stmt;
		try {
			stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, id);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			if(dados.next()) {
				tfNome.setText(dados.getString("nome"));
				tfemail.setText(dados.getString("email"));
				tfIdade.setText(dados.getString("idade"));
				tftelefone.setText(dados.getString("fone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Blob blob=null;
		try {
			blob = dados.getBlob("foto");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedImage bi = null;
		InputStream is = null;
		if(blob!=null) {
			try {
				is = blob.getBinaryStream();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				bi = ImageIO.read(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 ImageIcon icone = new ImageIcon(bi);
			 icone.setImage(icone.getImage().getScaledInstance(168, 138, 100));
			 lblFotoPerfil.setIcon(icone);	
		}
	}
	public void PreencheTelaC() {
		String sql = "SELECT * FROM alunos WHERE idaluno=?";
		PreparedStatement stmt;
		try {
			stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, Cadastrar_login.idC);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			if(dados.next()) {
				tfNome.setText(dados.getString("nome"));
				tfemail.setText(dados.getString("email"));
				tfIdade.setText(dados.getString("idade"));
				tftelefone.setText(dados.getString("fone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Blob blob=null;
		try {
			blob = dados.getBlob("foto");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedImage bi = null;
		InputStream is = null;
		if(blob!=null) {
			try {
				is = blob.getBinaryStream();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				bi = ImageIO.read(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 ImageIcon icone = new ImageIcon(bi);
			 icone.setImage(icone.getImage().getScaledInstance(168, 138, 100));
			 lblFotoPerfil.setIcon(icone);	
	}
	}
}
