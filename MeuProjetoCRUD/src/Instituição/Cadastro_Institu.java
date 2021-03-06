package Institui��o;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import Banco.Conexao;
import CRUD.CRUDInstitui��o;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;

public class Cadastro_Institu { // CADASTRA A INSTITUICAO

	private JFrame frmCadastro;
	private JTextField tfCnpj;
	private JTextField tfInstitu;
	private JTextField tfEmail;
	private JFormattedTextField tfTelefone;
	private JTextField tfSenha;
	private MaskFormatter mascaraCNPJ;
	private MaskFormatter mascaraFone;
	private JTextField tfCSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Institu window = new Cadastro_Institu();
					window.frmCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro_Institu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Imagem\\img\\students-cap.png"));
		frmCadastro.setTitle("Cadastro");
		frmCadastro.getContentPane().setBackground(Color.BLACK);
		frmCadastro.setBounds(100, 100, 815, 529);
		frmCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		frmCadastro.setLocationRelativeTo(null);
		frmCadastro.setResizable(false);
		
		JLabel label_8 = new JLabel("*");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(394, 147, 12, 14);
		frmCadastro.getContentPane().add(label_8);
		
		JLabel label_7 = new JLabel("*");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(379, 370, 12, 14);
		frmCadastro.getContentPane().add(label_7);
		
		JLabel label_6 = new JLabel("*");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(289, 328, 12, 14);
		frmCadastro.getContentPane().add(label_6);
		
		JLabel label_4 = new JLabel("*");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(289, 193, 12, 14);
		frmCadastro.getContentPane().add(label_4);
		
		JLabel label_3 = new JLabel("*");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(304, 237, 12, 14);
		frmCadastro.getContentPane().add(label_3);


		tfCSenha = new JPasswordField();
		tfCSenha.setBackground(Color.BLACK);
		tfCSenha.setForeground(Color.WHITE);
		tfCSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCSenha.setBackground(Color.BLACK);

			}
		});
		tfCSenha.setColumns(10);
		tfCSenha.setBounds(166, 368, 203, 23);
		frmCadastro.getContentPane().add(tfCSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setForeground(Color.WHITE);
		lblConfirmarSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblConfirmarSenha.setBounds(16, 357, 150, 39);
		frmCadastro.getContentPane().add(lblConfirmarSenha);
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(Color.BLACK);
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfCnpj.setText(null);
				tfInstitu.setText(null);
				tfEmail.setText(null);
				tfTelefone.setText(null);
				tfSenha.setText(null);
				tfCSenha.setText(null);
			}
		});
		btnLimpar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnLimpar.setBounds(640, 460, 167, 40);
		frmCadastro.getContentPane().add(btnLimpar);
		
		JLabel lblE = new JLabel("Institui\u00E7\u00E3o:");
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblE.setBounds(16, 142, 100, 23);
		frmCadastro.getContentPane().add(lblE);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setForeground(Color.WHITE);
		lblCnpj.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCnpj.setBounds(16, 193, 62, 23);
		frmCadastro.getContentPane().add(lblCnpj);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(16, 232, 84, 23);
		frmCadastro.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTelefone.setBounds(16, 272, 90, 23);
		frmCadastro.getContentPane().add(lblTelefone);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSenha.setBounds(16, 323, 74, 23);
		frmCadastro.getContentPane().add(lblSenha);
		
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tfCnpj = new JFormattedTextField(mascaraCNPJ);
		tfCnpj.setForeground(Color.WHITE);
		tfCnpj.setBackground(Color.BLACK);
		tfCnpj.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				tfCnpj.setBackground(Color.BLACK);

			}
		});
		tfCnpj.setBounds(84, 193, 203, 23);
		frmCadastro.getContentPane().add(tfCnpj);
		tfCnpj.setColumns(10);
		
		tfInstitu = new JTextField();
		tfInstitu.setForeground(Color.WHITE);
		tfInstitu.setBackground(Color.BLACK);
		tfInstitu.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInstitu.setBackground(Color.BLACK);

			}
		});
		tfInstitu.setBounds(120, 145, 271, 23);
		frmCadastro.getContentPane().add(tfInstitu);
		tfInstitu.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBackground(Color.BLACK);
		tfEmail.setForeground(Color.WHITE);
		tfEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfEmail.setBackground(Color.BLACK);

			}
		});
		tfEmail.setColumns(10);
		tfEmail.setBounds(97, 235, 204, 23);
		frmCadastro.getContentPane().add(tfEmail);
		
		try {
			mascaraFone = new MaskFormatter("## ####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tfTelefone = new JFormattedTextField(mascaraFone);
		tfTelefone.setForeground(Color.WHITE);
		tfTelefone.setBackground(Color.BLACK);
		tfTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTelefone.setBackground(Color.BLACK);

			}
		});
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(97, 275, 167, 22);
		frmCadastro.getContentPane().add(tfTelefone);
		

		tfSenha = new JPasswordField();
		tfSenha.setForeground(Color.WHITE);
		tfSenha.setBackground(Color.BLACK);
		tfSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfSenha.setBackground(Color.BLACK);

			}
		});
		tfSenha.setColumns(10);
		tfSenha.setBounds(82, 326, 203, 23);
		frmCadastro.getContentPane().add(tfSenha);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntraInstitu.main(null);
				frmCadastro.dispose();
			}
		});
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBounds(2, 461,164, 39);
		frmCadastro.getContentPane().add(btnVoltar);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.LIGHT_GRAY);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnpj = tfCnpj.getText().toString();
				if(tfCnpj.getText().contains("  .   .   /    -  ")) {
					JOptionPane.showMessageDialog(null, "Insira um CNPJ v�lido!");
					tfCnpj.setBackground(new Color(178, 34, 34));
					return;
				}
				ResultSet cnpjInsti;
				String sql34 ="SELECT * FROM institui��o WHERE cnpj=?";
				PreparedStatement stmt34;
				try {
					stmt34 = Conexao.conexao.prepareStatement(sql34);
					stmt34.setString(1, cnpj);
					cnpjInsti = stmt34.executeQuery();
					stmt34.execute();
					stmt34.close();
					if(cnpjInsti.next()) {
						if(cnpj.equals(cnpjInsti.getString("cnpj"))) {
							JOptionPane.showMessageDialog(null, "CNPJ j� existente!");
							tfCnpj.setText(null);
							return;
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String inst = tfInstitu.getText().toString();
				if(inst.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe um nome de institui��o v�lida");
					tfInstitu.setBackground(new Color(178, 34, 34));
					return;
				}
				if(!(tfEmail.getText().contains("@") && tfEmail.getText().contains("."))) {
					JOptionPane.showMessageDialog(null, "E-mail invalido!");
					tfEmail.setBackground(new Color(178, 34, 34));
					
					return;
				}
				String fone = tfTelefone.getText().toString();
				
				String email = tfEmail.getText().toString();
				if(tfSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira uma senha!");
					tfSenha.setBackground(new Color(178, 34, 34));
					return;
				}
				if(tfSenha.getText().equals(tfCSenha.getText())) {
					 String senha = String.copyValueOf(((JPasswordField) tfCSenha).getPassword());
					tfSenha.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "As senhas n�o est�o iguais");
					tfSenha.setText(null);
					tfCSenha.setText(null);
					tfSenha.requestFocus();
					return;
				}
				
				String senha = tfCSenha.getText().toString();
				CRUDInstitui��o insert = new CRUDInstitui��o();
				if(insert.novaInstitu(inst, cnpj, email,fone , senha)) {
					JOptionPane.showMessageDialog(null, "Nova institui��o cadastrada com sucesso!");
					Principal.main(null);
					frmCadastro.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar a institui��o!");
				}
			}
		});
		btnSalvar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnSalvar.setBounds(325, 460, 172, 40);
		frmCadastro.getContentPane().add(btnSalvar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(865, 151, 46, 14);
		frmCadastro.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(0, 407, 493, 31);
		frmCadastro.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(490, 411, 252, 23);
		frmCadastro.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_7.setBounds(725, 411, 333, 23);
		frmCadastro.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(0, 79, 286, 23);
		frmCadastro.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(257, 79, 485, 23);
		frmCadastro.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(725, 79, 100, 23);
		frmCadastro.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Solicite Uma Nova Aula (2).jpg"));
		lblNewLabel.setBounds(205, -22, 509, 131);
		frmCadastro.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Imagem\\img\\escola.png"));
		label.setBounds(515, 154, 224, 212);
		frmCadastro.getContentPane().add(label);
		
		

	}
}
