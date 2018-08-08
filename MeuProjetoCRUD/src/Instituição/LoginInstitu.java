package Instituição;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


import Menu_principal.Principal2;

import java.awt.SystemColor;
import java.awt.Color;

public class LoginInstitu extends Principal2{
	
	

	public JFrame frame;
	
	private JTextField tfcnpj;
	private JPasswordField pfSenha;
	private JButton btnEntrar;
	private MaskFormatter tcnpj;
	public String senha;
	public String login;
	public String usuario;
	public String conCnpj;
	public String conSenha;
	public static int id;
	
	Connection conexao; //conectorpara ligar o banco de dados
	protected java.sql.Statement stmt; //afirmação componente usado para passar os comandos SQL
	protected ResultSet tabela; //variável para armazenar o resultado do select

	
	private JLabel lblImagem;
	private JLabel lblNewLabel;
	private JButton btnVoltar;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInstitu window = new LoginInstitu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginInstitu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntraInstitu.main(null);
				frame.dispose();
			}
		});
		btnVoltar.setForeground(SystemColor.textHighlight);
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(45, 313, 201, 40);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblcnpj = new JLabel("CNPJ:");
		lblcnpj.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblcnpj.setBounds(126, 216, 95, 30);
		frame.getContentPane().add(lblcnpj);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSenha.setBounds(126, 257, 95, 30);
		frame.getContentPane().add(lblSenha);
		
		try {
			tcnpj = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfcnpj = new JFormattedTextField(tcnpj);
		tfcnpj.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					pfSenha.requestFocus();
				}
			}
		});
		tfcnpj.setColumns(10);
		tfcnpj.setBounds(231, 224, 188, 20);
		frame.getContentPane().add(tfcnpj);
		
		pfSenha = new JPasswordField();
		pfSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEntrar.doClick();
				}
			}
		});
		pfSenha.setBounds(231, 265, 188, 20);
		frame.getContentPane().add(pfSenha);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBackground(SystemColor.textHighlightText);
		btnEntrar.setForeground(SystemColor.textHighlight);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login = tfcnpj.getText(); //preenche a variável login com o conteudo do tfUsuario
				senha = String.copyValueOf(pfSenha.getPassword()); //preenche a variavel senha com o conteudo de pfSenha
				
				try {
					tabela = stmt.executeQuery("select * from instituição where cnpj = '"+login+"' and senha = '"+senha+"'");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao acessar os dados!");//msg caso o select falhe
					e.printStackTrace();
					return;
				}
				try {
				if(tabela.next()) {
								id = tabela.getInt("id");
								Principal.main(null);
								frame.dispose();
								
			}else{
				JOptionPane.showMessageDialog(null, "CNPJ ou senha incorretos!");
				//.setBackground(new Color(255, 0, 0));
				tfcnpj.setText(null);
				pfSenha.setText(null);
				return;
				
		}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	});
		btnEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEntrar.setBounds(313, 313, 201, 40);
		frame.getContentPane().add(btnEntrar);
		
		//Jlabel utilizado para utilizar uma imagem
		lblImagem = new JLabel("");
		ImageIcon logo = new ImageIcon("C:\\\\Users\\\\SENAI\\\\Desktop\\\\LoginSenhaDB\\\\fiemg3.png");
		logo.setImage(logo.getImage().getScaledInstance(414, 89, 100));
		lblImagem.setIcon(new ImageIcon(LoginInstitu.class.getResource("/47 - Copia.png")));
		lblImagem.setBounds(106, 21, 329, 168);
		frame.getContentPane().add(lblImagem);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginInstitu.class.getResource("/x2.png")));
		lblNewLabel.setBounds(0, 0, 572, 364);
		frame.getContentPane().add(lblNewLabel);
		//fim jlabel lblImagem
		
		
		
		frame.setResizable(false);//impede a tela de ser redimensionada
		frame.setLocationRelativeTo(null);//faz com que a tela apareça no centro
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3307/alunos","root","root");
		} catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco de dados");
		}
		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
