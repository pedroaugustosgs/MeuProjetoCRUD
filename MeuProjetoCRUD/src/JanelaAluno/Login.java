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

import Banco.Conexao;
import Instituição.Principal;
import Menu_principal.Principal2;

import java.awt.SystemColor;
import java.awt.Color;

public class Login extends Principal2{
	
	public JFrame frame;
	public static String id;
	private JTextField tfUsuario;
	private MaskFormatter tusuario;
	private JPasswordField pfSenha;
	private JButton btnEntrar;
	static ResultSet  dados;
	int tamanho = 10;

	
	Connection conexao; //conectorpara ligar o banco de dados
	protected java.sql.Statement stmt; //afirmação componente usado para passar os comandos SQL
	protected ResultSet tabela; //variável para armazenar o resultado do select
	protected static String login;

	protected String senha;
	
	Principal janelaPrincipal = new Principal();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	
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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 577, 395);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal2.main(null);
				frame.dispose();
			}
		});
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(73, 313, 164, 39);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUsuario.setBounds(126, 216, 95, 30);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSenha.setBounds(126, 257, 95, 30);
		frame.getContentPane().add(lblSenha);
		
	
		
		tfUsuario = new JTextField();
		tfUsuario.setForeground(Color.WHITE);
		tfUsuario.setBackground(Color.BLACK);
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
		pfSenha.setForeground(Color.WHITE);
		pfSenha.setBackground(Color.BLACK);
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
		btnEntrar.setBackground(Color.LIGHT_GRAY);
		btnEntrar.setForeground(Color.BLACK);
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
		btnEntrar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnEntrar.setBounds(308, 313, 164, 39);
		frame.getContentPane().add(btnEntrar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel.setBounds(114, 32, 447, 135);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(0, 166, 490, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(486, 166, 85, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(0, 0, 385, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(366, 0, 215, 28);
		frame.getContentPane().add(lblNewLabel_4);
		ImageIcon logo = new ImageIcon("C:\\\\Users\\\\SENAI\\\\Desktop\\\\LoginSenhaDB\\\\fiemg3.png");
		logo.setImage(logo.getImage().getScaledInstance(414, 89, 100));
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
			stmt = Conexao.conexao.createStatement();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
}
