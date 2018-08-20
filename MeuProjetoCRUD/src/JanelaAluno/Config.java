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
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Toolkit;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
public class Config extends Login {
	
	int ee;
	public JFrame frmMeuCrud;
	public String anterior = "";
	protected Object btnlocal;
	private JTextField tfNome;
	private JTextField tfemail;
	private JTextField tftelefone;
	public static Aluno aluno;
	private JTextField tfIdade;
	private MaskFormatter mascaraFone;
	public ResultSet dados = null;
	public static int voltar=0;
	//public static Aluno aluno;
	
	File file=null;
	FileInputStream fis=null;
	public String caminho=null;
	JFileChooser explorer = new JFileChooser();
	private JLabel lblFotoPerfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Config window = new Config();
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
	public Config() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeuCrud = new JFrame();
		frmMeuCrud.getContentPane().setBackground(Color.BLACK);
		frmMeuCrud.setIconImage(Toolkit.getDefaultToolkit().getImage(Config.class.getResource("/47 - Copia.png")));
		frmMeuCrud.setTitle("MEU CRUD - Alunos Cadastrados");
		frmMeuCrud.setBounds(100, 100, 784, 494);
		frmMeuCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuCrud.getContentPane().setLayout(null);
		frmMeuCrud.setResizable(false);
		frmMeuCrud.setLocationRelativeTo(null);
		
		JButton btnSalvar = new JButton("Salvar");
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
					JOptionPane.showMessageDialog(null, "Informe uma idade Válida!");
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
		
		JButton btnNewButton = new JButton("Redefinir Senha:");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String senha1 = JOptionPane.showInputDialog("Escreva sua nova Senha");
				String senha2 = JOptionPane.showInputDialog("Reescreva a sua nova senha");
				if(senha1.equals(senha2)) {
					CRUDAlunos alt = new CRUDAlunos();
					alt.alterarSenha(senha1, id);
						JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
					}else {
						JOptionPane.showMessageDialog(null, "Erro ao alterar senha!");
					}
					
				}
		});
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(479, 96, 299, 38);
		frmMeuCrud.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(0, 98, 500, 35);
		frmMeuCrud.getContentPane().add(lblNewLabel_1);
		
		lblFotoPerfil = new JLabel("");
		lblFotoPerfil.setForeground(Color.WHITE);
		lblFotoPerfil.setBackground(Color.WHITE);
		lblFotoPerfil.setBounds(510, 142, 258, 198);
		frmMeuCrud.getContentPane().add(lblFotoPerfil);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(460, 4, 333, 25);
		frmMeuCrud.getContentPane().add(lblNewLabel_5);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(93, 263, 86, 20);
		frmMeuCrud.getContentPane().add(tfIdade);
		tfIdade.setColumns(10);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnNewButton.setBounds(20, 420, 250, 35);
		frmMeuCrud.getContentPane().add(btnNewButton);
		
		try {
			mascaraFone = new MaskFormatter("## ####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tftelefone = new JFormattedTextField(mascaraFone);
		tftelefone.setColumns(10);
		tftelefone.setBounds(115, 305, 135, 20);
		frmMeuCrud.getContentPane().add(tftelefone);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTelefone.setBounds(19, 302, 86, 21);
		frmMeuCrud.getContentPane().add(lblTelefone);
		btnSalvar.setBounds(373, 420, 140, 35);
		frmMeuCrud.getContentPane().add(btnSalvar);
		
		JLabel lblSenha = new JLabel("Idade:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSenha.setBounds(23, 260, 60, 21);
		frmMeuCrud.getContentPane().add(lblSenha);
		
		tfemail = new JTextField();
		tfemail.setColumns(10);
		tfemail.setBounds(92, 224, 229, 20);
		frmMeuCrud.getContentPane().add(tfemail);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(25, 221, 100, 21);
		frmMeuCrud.getContentPane().add(lblEmail);
		
		tfNome = new JTextField();
		tfNome.setBounds(92, 188, 229, 20);
		frmMeuCrud.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					PlaAluno.main(null);
					frmMeuCrud.dispose();
			}
		});
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(633, 420, 126, 35);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		JLabel lblNomeCtfnoompleto = DefaultComponentFactory.getInstance().createTitle("Nome:");
		lblNomeCtfnoompleto.setForeground(Color.WHITE);
		lblNomeCtfnoompleto.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNomeCtfnoompleto.setBounds(24, 180, 70, 30);
		frmMeuCrud.getContentPane().add(lblNomeCtfnoompleto);
		
		JButton btnTrocarFoto = new JButton("Alterar Foto");
		btnTrocarFoto.setBackground(Color.LIGHT_GRAY);
		btnTrocarFoto.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnTrocarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF IMAGENS","jpg","gif","png");
				 explorer.setFileFilter(filter);
				 int resposta = explorer.showOpenDialog(null);
				 
				 if(resposta == explorer.APPROVE_OPTION) {
					 caminho = explorer.getSelectedFile().getAbsolutePath();
					 
					 ImageIcon icone = new ImageIcon(caminho);
					 icone.setImage(icone.getImage().getScaledInstance(168, 138, 100));
					 lblFotoPerfil.setIcon(icone);
				 }
			}
		});
		btnTrocarFoto.setBounds(568, 351, 196, 35);
		frmMeuCrud.getContentPane().add(btnTrocarFoto);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(0, 0, 778, 33);
		frmMeuCrud.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(623, 396, 46, 14);
		frmMeuCrud.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\A.png"));
		lblNewLabel.setBounds(153, 44, 293, 161);
		frmMeuCrud.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Chapeu azul.png"));
		lblNewLabel_3.setBounds(437, 32, 190, 71);
		frmMeuCrud.getContentPane().add(lblNewLabel_3);
		//System.out.println(EntraAluno.volt);
		if(EntraAluno.volt==0) {
			PreencheTelaC();
		}else {
			PreencheTela();
		}
		
	}// fim do método inicialize
	
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
