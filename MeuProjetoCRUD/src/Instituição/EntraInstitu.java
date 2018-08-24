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
import java.awt.Toolkit;



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
		frmEntraInstitu.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Imagem\\img\\students-cap.png"));
		frmEntraInstitu.setTitle("Approfe");
		frmEntraInstitu.getContentPane().setBackground(Color.BLACK);
		frmEntraInstitu.setBounds(100, 100, 797, 630);
		frmEntraInstitu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntraInstitu.getContentPane().setLayout(null);
		frmEntraInstitu.setResizable(false);
		frmEntraInstitu.setLocationRelativeTo(null);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEntraInstitu.setVisible(false);
				Principal2.main(null);
			}
		});
		JButton btnLogar = new JButton("LOGAR");
		btnLogar.setBackground(Color.LIGHT_GRAY);
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginInstitu.main(null);
				frmEntraInstitu.dispose();
			}
		});
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Institu.main(null);
				frmEntraInstitu.dispose();
			}
		});
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnCadastrar.setBounds(542, 288, 164, 39);
		frmEntraInstitu.getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Bot\u00E3o png.png"));
		lblNewLabel_2.setBounds(527, 219, 276, 200);
		frmEntraInstitu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(0, 96, 465, 30);
		frmEntraInstitu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(459, 96, 344, 30);
		frmEntraInstitu.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega em p\u00E9.jpg"));
		lblNewLabel_7.setBounds(394, 99, 69, 423);
		frmEntraInstitu.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(0, 515, 442, 30);
		frmEntraInstitu.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(429, 515, 362, 30);
		frmEntraInstitu.getContentPane().add(lblNewLabel_4);
		btnLogar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnLogar.setForeground(Color.BLACK);
		btnLogar.setBounds(57, 288, 164, 39);
		frmEntraInstitu.getContentPane().add(btnLogar);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBounds(331, 561, 164, 39);
		frmEntraInstitu.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Bot\u00E3o png.png"));
		lblNewLabel_5.setBounds(45, 220, 276, 200);
		frmEntraInstitu.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\fundo1111.png"));
		lblNewLabel.setBounds(-3, 101, 794, 423);
		frmEntraInstitu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel_8.setBounds(149, -15, 391, 142);
		frmEntraInstitu.getContentPane().add(lblNewLabel_8);
	}
}
