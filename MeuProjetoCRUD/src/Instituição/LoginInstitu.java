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
	private JButton btnVoltar;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_7;
	
	
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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 577, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntraInstitu.main(null);
				frame.dispose();
			}
		});
		
		lblNewLabel_7 = new JLabel("Senha:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(128, 256, 64, 24);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(0, 147, 496, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel = new JLabel("CNPJ:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(128, 219, 64, 26);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(488, 149, 96, 26);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel_3.setBounds(53, 22, 478, 148);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(0, -1, 496, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(488, -3, 83, 30);
		frame.getContentPane().add(lblNewLabel_2);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(79, 315, 164, 39);
		frame.getContentPane().add(btnVoltar);
		
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
		tfcnpj.setBounds(192, 223, 195, 21);
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
		pfSenha.setBounds(192, 259, 195, 21);
		frame.getContentPane().add(pfSenha);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBackground(Color.LIGHT_GRAY);
		btnEntrar.setForeground(Color.BLACK);
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
		btnEntrar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnEntrar.setBounds(328, 317, 164, 39);
		frame.getContentPane().add(btnEntrar);
		ImageIcon logo = new ImageIcon("C:\\\\Users\\\\SENAI\\\\Desktop\\\\LoginSenhaDB\\\\fiemg3.png");
		logo.setImage(logo.getImage().getScaledInstance(414, 89, 100));
		
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
