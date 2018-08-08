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
		frmEntraInstitu.setBounds(100, 100, 587, 396);
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
		btnVoltar.setForeground(new Color(0, 191, 255));
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnVoltar.setBounds(182, 324, 201, 33);
		frmEntraInstitu.getContentPane().add(btnVoltar);
		btnLogar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogar.setForeground(new Color(0, 191, 255));
		btnLogar.setBounds(182, 236, 201, 33);
		frmEntraInstitu.getContentPane().add(btnLogar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Institu.main(null);
				frmEntraInstitu.dispose();
			}
		});
		btnCadastrar.setForeground(new Color(0, 191, 255));
		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCadastrar.setBounds(182, 280, 201, 33);
		frmEntraInstitu.getContentPane().add(btnCadastrar);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(EntraInstitu.class.getResource("/47 - Copia.png")));
		lblImage.setBounds(103, 11, 339, 158);
		frmEntraInstitu.getContentPane().add(lblImage);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(EntraInstitu.class.getResource("/Principal (2).png")));
		lblNewLabel.setBounds(0, 2, 581, 366);
		frmEntraInstitu.getContentPane().add(lblNewLabel);
	}
}
