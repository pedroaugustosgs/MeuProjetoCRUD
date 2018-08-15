package Instituição;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Instituição.Cadastro_Institu;
import Instituição.LoginInstitu;
import Menu_principal.Principal2;



public class EntraInstitu extends Principal2{

	private JFrame frmEntraInstitu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntraInstitu window = new EntraInstitu();
					window.frmEntraInstitu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EntraInstitu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEntraInstitu = new JFrame();
		frmEntraInstitu.getContentPane().setBackground(Color.BLACK);
		frmEntraInstitu.setBounds(100, 100, 797, 630);
		frmEntraInstitu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntraInstitu.getContentPane().setLayout(null);
		frmEntraInstitu.setResizable(false);
		frmEntraInstitu.setLocationRelativeTo(null);
		JButton btnLogar = new JButton("LOGAR");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginInstitu.main(null);
				frmEntraInstitu.dispose();
			}
		});
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEntraInstitu.setVisible(false);
				Principal2.main(null);
			}
		});
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("D:\\chapeu.png"));
		lblNewLabel_11.setBounds(361, 22, 151, 63);
		frmEntraInstitu.getContentPane().add(lblNewLabel_11);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnVoltar.setBounds(590, 569, 201, 33);
		frmEntraInstitu.getContentPane().add(btnVoltar);
		btnLogar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnLogar.setForeground(Color.BLACK);
		btnLogar.setBounds(57, 288, 201, 33);
		frmEntraInstitu.getContentPane().add(btnLogar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Institu.main(null);
				frmEntraInstitu.dispose();
			}
		});
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnCadastrar.setBounds(531, 275, 201, 33);
		frmEntraInstitu.getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Bot\u00E3o png.png"));
		lblNewLabel.setBounds(42, 209, 303, 205);
		frmEntraInstitu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Bot\u00E3o png.png"));
		lblNewLabel_2.setBounds(515, 158, 228, 282);
		frmEntraInstitu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(0, 515, 442, 30);
		frmEntraInstitu.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(429, 515, 362, 30);
		frmEntraInstitu.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(0, 21, 465, 30);
		frmEntraInstitu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(447, 21, 344, 30);
		frmEntraInstitu.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\1.png"));
		lblNewLabel_7.setBounds(-77, 44, 415, 473);
		frmEntraInstitu.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\1.png"));
		lblNewLabel_10.setBounds(396, 44, 385, 485);
		frmEntraInstitu.getContentPane().add(lblNewLabel_10);
	}
}
