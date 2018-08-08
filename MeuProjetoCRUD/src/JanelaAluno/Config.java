package JanelaAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.text.MaskFormatter;


import Banco.Conexao;
import CRUD.Aluno;
import CRUD.CRUDAlunos;

import javax.swing.JButton;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Toolkit;

import javax.swing.JFormattedTextField;
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
		frmMeuCrud.setBounds(100, 100, 784, 550);
		frmMeuCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuCrud.getContentPane().setLayout(null);
		frmMeuCrud.setResizable(false);
		frmMeuCrud.setLocationRelativeTo(null);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
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
				
				CRUDAlunos alterar = new CRUDAlunos();
				if(alterar.alterarAluno(nome, idade, email, fone, id)) {
					JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao alterar o aluno!");
				}
				
			}
		});
		
		JButton btnNewButton = new JButton("Redefinir Senha:");
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
		
		tfIdade = new JTextField();
		tfIdade.setBounds(101, 138, 86, 20);
		frmMeuCrud.getContentPane().add(tfIdade);
		tfIdade.setColumns(10);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton.setBounds(280, 252, 194, 39);
		frmMeuCrud.getContentPane().add(btnNewButton);
		
		try {
			mascaraFone = new MaskFormatter("## ####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tftelefone = new JFormattedTextField(mascaraFone);
		tftelefone.setColumns(10);
		tftelefone.setBounds(101, 169, 135, 20);
		frmMeuCrud.getContentPane().add(tftelefone);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblTelefone.setBounds(0, 169, 146, 21);
		frmMeuCrud.getContentPane().add(lblTelefone);
		btnSalvar.setBounds(0, 496, 119, 26);
		frmMeuCrud.getContentPane().add(btnSalvar);
		
		JLabel lblSenha = new JLabel("Idade:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblSenha.setBounds(0, 137, 146, 21);
		frmMeuCrud.getContentPane().add(lblSenha);
		
		tfemail = new JTextField();
		tfemail.setColumns(10);
		tfemail.setBounds(528, 138, 229, 20);
		frmMeuCrud.getContentPane().add(tfemail);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblEmail.setBounds(451, 135, 180, 21);
		frmMeuCrud.getContentPane().add(lblEmail);
		
		tfNome = new JTextField();
		tfNome.setBounds(528, 169, 229, 20);
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
		btnVoltar.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(652, 496, 126, 26);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		JLabel lblNomeCtfnoompleto = DefaultComponentFactory.getInstance().createTitle("Nome Completo:");
		lblNomeCtfnoompleto.setForeground(Color.WHITE);
		lblNomeCtfnoompleto.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblNomeCtfnoompleto.setBounds(374, 161, 193, 30);
		frmMeuCrud.getContentPane().add(lblNomeCtfnoompleto);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(0, 303, 446, 30);
		frmMeuCrud.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(456, 311, 46, 14);
		frmMeuCrud.getContentPane().add(lblNewLabel_1);
		//System.out.println(EntraAluno.volt);
		if(EntraAluno.volt==0) {
			PreencheTelaC();
		}else {
			PreencheTela();
		}
		System.out.println(Cadastrar_login.id);
		
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
		
		
	}
	public void PreencheTelaC() {
		String sql = "SELECT * FROM alunos WHERE idaluno=?";
		PreparedStatement stmt;
		try {
			stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setInt(1, Cadastrar_login.id);
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
		
		
	}
	
}
