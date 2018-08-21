package JanelaAluno;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;


import Banco.Conexao;
import CRUD.CRUDAlunos;
import Instituição.LoginInstitu;


import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.awt.SystemColor;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Cadastrar_login extends LoginInstitu{

	private JFrame frame;
	private JPasswordField pfsenha;
	private JPasswordField pfCsenha;
	private JTextField tfemail;
	private JTextField tel;
	private JTextField tfnome;
	private String sexo;
	public static String anterior = "";
	private JTextField tfUsuario;
	private JRadioButton fem;
	private JRadioButton mas;
	private MaskFormatter mascaraFone;
	private JComboBox<String> cbEscola;
	private JSpinner SpIdade;
	public static String idC;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrar_login window = new Cadastrar_login();
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
	public Cadastrar_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastrar_login.class.getResource("/47 - Copia.png")));
		frame.setBounds(100, 100, 782, 624);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfUsuario.setText(null);
				tfnome.setText(null);
				fem.setSelected(false);
				mas.setSelected(true);
				tfemail.setText(null);
				tel.setText(null);
				pfsenha.setText(null);
				pfCsenha.setText(null);
			}
		});
		
		SpIdade = new JSpinner();
		
		SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(1, 505, 290, 24);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_7.setBounds(278, 505, 128, 24);
		frame.getContentPane().add(lblNewLabel_7);
		SpIdade.setModel(model);
		SpIdade.setEditor(new JSpinner.NumberEditor(SpIdade, "#"));

		
		
		SpIdade.setBounds(76, 229, 80, 20);
		frame.getContentPane().add(SpIdade);
		
		JLabel label_4 = new JLabel("*");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(261, 303, 12, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_2 = new JLabel("*");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(261, 156, 12, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(261, 199, 12, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_1 = new JLabel("*");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(258, 372, 12, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("*");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setBounds(271, 337, 12, 14);
		frame.getContentPane().add(label);
		
		JLabel lblInstituio = new JLabel("Institui\u00E7\u00E3o:");
		lblInstituio.setForeground(Color.WHITE);
		lblInstituio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblInstituio.setBounds(7, 443, 107, 24);
		frame.getContentPane().add(lblInstituio);
		
		cbEscola = new JComboBox<String>();
		cbEscola.setBounds(104, 448, 233, 20);
		frame.getContentPane().add(cbEscola);
		
		
		ResultSet dados=null;
		String sql="SELECT * FROM instituição";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			while(dados.next()){
				String escolas = dados.getString("nome");
				cbEscola.addItem(escolas);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		btnLimpar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnLimpar.setBounds(613, 556, 164, 39);
		frame.getContentPane().add(btnLimpar);
		
		tfUsuario = new JTextField();
		tfUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfUsuario.setBackground(Color.WHITE);
			}
		});
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfUsuario.setForeground(Color.BLACK);
		tfUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(77, 155, 177, 20);
		frame.getContentPane().add(tfUsuario);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUsurio.setBounds(5, 150, 85, 24);
		frame.getContentPane().add(lblUsurio);
		
		tfnome = new JTextField();
		tfnome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfnome.setBackground(Color.WHITE);

			}
		});
		tfnome.setForeground(Color.BLACK);
		tfnome.setHorizontalAlignment(SwingConstants.LEFT);
		tfnome.setColumns(10);
		tfnome.setBounds(74, 193, 177, 20);
		frame.getContentPane().add(tfnome);
		
		try {
			mascaraFone = new MaskFormatter("## ####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tel = new JFormattedTextField(mascaraFone);
		tel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tel.setBackground(Color.WHITE);

			}
		});
		tel.setColumns(10);
		tel.setBounds(86, 336, 177, 20);
		frame.getContentPane().add(tel);
		
		tfemail = new JTextField();
		tfemail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfemail.setBackground(Color.WHITE);
			}
		});
		tfemail.setColumns(10);
		tfemail.setBounds(73, 302, 177, 20);
		frame.getContentPane().add(tfemail);
		
		pfCsenha = new JPasswordField();
		pfCsenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfCsenha.setBackground(Color.WHITE);
			}
		});
		pfCsenha.setBounds(151, 408, 177, 20);
		frame.getContentPane().add(pfCsenha);
		
		pfsenha = new JPasswordField();
		pfsenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfsenha.setBackground(Color.WHITE);

			}
		});
		pfsenha.setBounds(76, 371, 177, 20);
		frame.getContentPane().add(pfsenha);
		
		mas = new JRadioButton("Masculino");
		mas.setBackground(Color.BLACK);
		mas.setForeground(Color.WHITE);
		mas.setSelected(true);
		mas.setBounds(164, 261, 109, 23);
		frame.getContentPane().add(mas);
		
		fem = new JRadioButton("Feminino");
		fem.setBackground(Color.BLACK);
		fem.setForeground(Color.WHITE);
		fem.setBounds(73, 261, 89, 23);
		frame.getContentPane().add(fem);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTelefone.setBounds(6, 333, 107, 24);
		frame.getContentPane().add(lblTelefone);
		
		JLabel email = new JLabel("Email:");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		email.setBounds(10, 297, 53, 24);
		frame.getContentPane().add(email);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSexo.setBounds(10, 259, 67, 24);
		frame.getContentPane().add(lblSexo);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIdade.setBounds(11, 224, 95, 24);
		frame.getContentPane().add(lblIdade);
		
		JLabel lblnome = new JLabel("Nome:");
		lblnome.setForeground(Color.WHITE);
		lblnome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblnome.setBounds(9, 190, 85, 24);
		frame.getContentPane().add(lblnome);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSenha.setBounds(8, 367, 72, 24);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setForeground(Color.WHITE);
		lblConfirmarSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblConfirmarSenha.setBounds(7, 403, 155, 24);
		frame.getContentPane().add(lblConfirmarSenha);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBackground(Color.LIGHT_GRAY);
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String usuario = tfUsuario.getText().toString();
				if(usuario.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe um usuário válido");
					tfUsuario.setBackground(new Color(178, 34, 34));
					return;
				}
				ResultSet usuarios;
				String sql34 ="SELECT * FROM alunos WHERE usuario=?";
				PreparedStatement stmt34;
				try {
					stmt34 = Conexao.conexao.prepareStatement(sql34);
					stmt34.setString(1, usuario);
					usuarios = stmt34.executeQuery();
					stmt34.execute();
					stmt34.close();
					if(usuarios.next()) {
						if(usuario.equals(usuarios.getString("usuario"))) {
							JOptionPane.showMessageDialog(null, "Usuário já existente!");
							tfUsuario.setText(null);
							return;
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}				
				
				
				String Nome = tfnome.getText();
				if(Nome.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe um nome válido");
					tfnome.setBackground(new Color(178, 34, 34));

					return;
				}
				
				if(!(tfemail.getText().contains("@") && tfemail.getText().contains("."))) {
					JOptionPane.showMessageDialog(null, "E-mail invalido!");
					tfemail.setBackground(new Color(178, 34, 34));
					return;
				}
				if(pfsenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira uma senha!");
					pfsenha.setBackground(new Color(178, 34, 34));
					return;
				}
				if(pfsenha.getText().equals(pfCsenha.getText())) {
					senha = String.copyValueOf(pfCsenha.getPassword());
					pfsenha.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "As senhas não estão iguais");
					pfCsenha.setBackground(new Color(178, 34, 34));
					pfsenha.setBackground(new Color(178, 34, 34));
					pfsenha.setText(null);
					pfCsenha.setText(null);
					return;
				}
				
				
				
				CRUDAlunos salvar = new  CRUDAlunos();
				if(mas.isSelected()) {
					sexo = "M";
				}
				if(fem.isSelected()) {
					sexo = "F";
				}
				
				
				ResultSet descola=null;
				String nomeEsc =  (String) cbEscola.getSelectedItem();
				String sql = "SELECT * FROM instituição WHERE nome =?";
			 
			 try {
				PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
				stmt.setString(1, nomeEsc);
				descola = stmt.executeQuery();
				stmt.execute();
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 String escola = null;
			 try {
				if(descola.next()) {
					escola = descola.getString("id"); 
				 }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				int idade = (int) SpIdade.getValue();
				boolean resposta = salvar.novoAluno(usuario,Nome,idade,
						sexo, tfemail.getText(), tel.getText() , senha,Integer.parseInt(escola));
				if(resposta){
					JOptionPane.showMessageDialog(null, "Novo usuário cadastrado com sucesso");
					
					ResultSet dd=null;
					EntraAluno.volt = 0;
					
					String sql3 ="SELECT * FROM alunos";
					try {
						PreparedStatement stmt = Conexao.conexao.prepareStatement(sql3);
						//stmt.setString(1, usuario);
						dd = stmt.executeQuery();
						stmt.execute();
						stmt.close();
						
						if(dd.last()) {
							idC = dd.getString("idaluno");
							System.out.println(idC);
							PlaAluno.main(new String[] {String.valueOf(idC)});
							EntraAluno.vtt=0;
							frame.dispose();
						}
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar novo usuário");
					
				}
			}
				});
		btnSalvar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnSalvar.setBounds(2, 556, 164, 39);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				EntraAluno.main(null);
			}
		});
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBounds(337, 556, 164, 39);
		frame.getContentPane().add(btnVoltar);
		frame.setResizable(false);//impede a tela de ser redimensionada
		frame.setLocationRelativeTo(null);//faz com que a tela apareça no centro
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(fem);
		bg.add(mas);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(621, 68, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(0, 82, 365, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(362, 87, 442, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel label_5 = new JLabel("*");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(329, 409, 12, 14);
		frame.getContentPane().add(label_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(393, 505, 383, 24);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Cadastro.png"));
		lblNewLabel_1.setBounds(297, -160, 518, 439);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(393, 198, 345, 229);
		frame.getContentPane().add(lblNewLabel_4);
	}

	private void JSpinner(SpinnerModel spIdade2) {
		// TODO Auto-generated method stub
		
	}

	private SpinnerModel SpIdade(int i, int j, double maxValue, int k) {
		// TODO Auto-generated method stub
		return null;
	}
}