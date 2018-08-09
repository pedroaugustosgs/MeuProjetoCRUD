package Instituição;

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
import CRUD.CRUDInstituição;

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

public class Cadastro_Institu { // CADASTRA A INSTITUICAO

	private JFrame frame;
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
	public Cadastro_Institu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1021, 648);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JLabel label_8 = new JLabel("*");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(442, 133, 12, 14);
		frame.getContentPane().add(label_8);
		
		JLabel label_7 = new JLabel("*");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(358, 424, 12, 14);
		frame.getContentPane().add(label_7);
		
		JLabel label_6 = new JLabel("*");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(301, 363, 12, 14);
		frame.getContentPane().add(label_6);
		
		JLabel label_5 = new JLabel("*");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(927, 424, 12, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_4 = new JLabel("*");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(970, 128, 12, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_3 = new JLabel("*");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(927, 363, 12, 14);
		frame.getContentPane().add(label_3);


		tfCSenha = new JPasswordField();
		tfCSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfCSenha.setBackground(Color.WHITE);

			}
		});
		tfCSenha.setColumns(10);
		tfCSenha.setBounds(145, 427, 203, 23);
		frame.getContentPane().add(tfCSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setForeground(Color.WHITE);
		lblConfirmarSenha.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblConfirmarSenha.setBounds(0, 424, 149, 23);
		frame.getContentPane().add(lblConfirmarSenha);
		JButton btnLimpar = new JButton("Limpar");
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
		btnLimpar.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		btnLimpar.setBounds(852, 580, 167, 40);
		frame.getContentPane().add(btnLimpar);
		
		JLabel lblE = new JLabel("Institui\u00E7\u00E3o:");
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblE.setBounds(517, 128, 100, 23);
		frame.getContentPane().add(lblE);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setForeground(Color.WHITE);
		lblCnpj.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblCnpj.setBounds(656, 419, 62, 23);
		frame.getContentPane().add(lblCnpj);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblEmail.setBounds(0, 128, 100, 23);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblTelefone.setBounds(656, 358, 84, 23);
		frame.getContentPane().add(lblTelefone);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblSenha.setBounds(0, 358, 74, 23);
		frame.getContentPane().add(lblSenha);
		
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tfCnpj = new JFormattedTextField(mascaraCNPJ);
		tfCnpj.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				tfCnpj.setBackground(Color.WHITE);

			}
		});
		tfCnpj.setBounds(714, 423, 203, 20);
		frame.getContentPane().add(tfCnpj);
		tfCnpj.setColumns(10);
		
		tfInstitu = new JTextField();
		tfInstitu.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfInstitu.setBackground(Color.WHITE);

			}
		});
		tfInstitu.setBounds(611, 127, 357, 20);
		frame.getContentPane().add(tfInstitu);
		tfInstitu.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfEmail.setBackground(Color.WHITE);

			}
		});
		tfEmail.setColumns(10);
		tfEmail.setBounds(63, 132, 381, 20);
		frame.getContentPane().add(tfEmail);
		
		try {
			mascaraFone = new MaskFormatter("## ####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tfTelefone = new JFormattedTextField(mascaraFone);
		tfTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfTelefone.setBackground(Color.WHITE);

			}
		});
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(750, 361, 167, 22);
		frame.getContentPane().add(tfTelefone);
		

		tfSenha = new JPasswordField();
		tfSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfSenha.setBackground(Color.WHITE);

			}
		});
		tfSenha.setColumns(10);
		tfSenha.setBounds(82, 361, 203, 23);
		frame.getContentPane().add(tfSenha);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntraInstitu.main(null);
				frame.dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		btnVoltar.setBounds(0, 580, 212, 40);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(Color.LIGHT_GRAY);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnpj = tfCnpj.getText().toString();
				if(tfCnpj.getText().contains("  .   .   /    -  ")) {
					JOptionPane.showMessageDialog(null, "Insira um CNPJ válido!");
					tfCnpj.setBackground(new Color(178, 34, 34));
					return;
				}
				ResultSet cnpjInsti;
				String sql34 ="SELECT * FROM instituição WHERE cnpj=?";
				PreparedStatement stmt34;
				try {
					stmt34 = Conexao.conexao.prepareStatement(sql34);
					stmt34.setString(1, cnpj);
					cnpjInsti = stmt34.executeQuery();
					stmt34.execute();
					stmt34.close();
					if(cnpjInsti.next()) {
						if(cnpj.equals(cnpjInsti.getString("cnpj"))) {
							JOptionPane.showMessageDialog(null, "CNPJ já existente!");
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
					JOptionPane.showMessageDialog(null, "Informe um nome de instituição válida");
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
					JOptionPane.showMessageDialog(null, "As senhas não estão iguais");
					tfSenha.setText(null);
					tfCSenha.setText(null);
					tfSenha.requestFocus();
					return;
				}
				
				String senha = tfCSenha.getText().toString();
				CRUDInstituição insert = new CRUDInstituição();
				if(insert.novaInstitu(inst, cnpj, email,fone , senha)) {
					JOptionPane.showMessageDialog(null, "Nova instituição cadastrada com sucesso!");
					Principal.main(null);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar a instituição!");
				}
			}
		});
		btnSalvar.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		btnSalvar.setBounds(442, 580, 172, 40);
		frame.getContentPane().add(btnSalvar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(865, 151, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(-11, 66, 485, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(662, 62, 357, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(472, 62, 194, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(0, 507, 493, 31);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(490, 511, 252, 23);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_7.setBounds(740, 511, 333, 23);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\chapeu.png"));
		lblNewLabel_8.setBounds(234, 149, 568, 289);
		frame.getContentPane().add(lblNewLabel_8);
		
		

	}
}
