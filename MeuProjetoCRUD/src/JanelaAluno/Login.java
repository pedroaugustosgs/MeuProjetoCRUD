package JanelaAluno;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Banco.Conexao;
import Instituição.Principal;
import Menu_principal.Principal2;

import java.awt.SystemColor;
import java.awt.Color;

public class Login extends Principal2{
	
	public JFrame frame;
	public static String id;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JButton btnEntrar;
	static ResultSet  dados;
	
	Connection conexao; //conectorpara ligar o banco de dados
	protected java.sql.Statement stmt; //afirmação componente usado para passar os comandos SQL
	protected ResultSet tabela; //variável para armazenar o resultado do select
	protected static String login;

	protected String senha;
	
	Principal janelaPrincipal = new Principal();
	private JLabel lblImagem;
	private JLabel lblNewLabel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 392);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal2.main(null);
				frame.dispose();
			}
		});
		btnVoltar.setForeground(SystemColor.textHighlight);
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(73, 313, 201, 40);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUsuario.setBounds(126, 216, 95, 30);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSenha.setBounds(126, 257, 95, 30);
		frame.getContentPane().add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					pfSenha.requestFocus();
				}
			}
		});
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(231, 224, 188, 20);
		frame.getContentPane().add(tfUsuario);
		
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
				login = tfUsuario.getText(); //preenche a variável login com o conteudo do tfUsuario
				senha = String.copyValueOf(pfSenha.getPassword()); //preenche a variavel senha com o conteudo de pfSenha
				
				try {
					tabela = stmt.executeQuery("select * from alunos where usuario = '"+login+"' and senha = '"+senha+"'");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao acessar os dados!");//msg caso o select falhe
					e.printStackTrace();
					return;
				}
				try {
				if(tabela.next()) {
								id = tabela.getString("idaluno");
								EntraAluno.volt = 1;
								EntraAluno.vtt=1;
								PlaAluno.main(new String[] {id});
								frame.dispose();
								
								
			}else{
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
				tfUsuario.setText(null);
				pfSenha.setText(null);
				return;
		}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			}
		});
		btnEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEntrar.setBounds(308, 313, 201, 40);
		frame.getContentPane().add(btnEntrar);
		
		//Jlabel utilizado para utilizar uma imagem
		lblImagem = new JLabel("");
		ImageIcon logo = new ImageIcon("C:\\\\Users\\\\SENAI\\\\Desktop\\\\LoginSenhaDB\\\\fiemg3.png");
		logo.setImage(logo.getImage().getScaledInstance(414, 89, 100));
		lblImagem.setBounds(106, 21, 329, 168);
		frame.getContentPane().add(lblImagem);
		
		lblNewLabel = new JLabel("New label");
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
			stmt = Conexao.getConexao().createStatement();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
}
