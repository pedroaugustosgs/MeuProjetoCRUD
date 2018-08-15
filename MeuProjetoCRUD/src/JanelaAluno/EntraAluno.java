package JanelaAluno;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import Menu_principal.Principal2;
import javax.swing.SwingConstants;



public class EntraAluno extends Principal2{

	private JFrame frmEntraInstitu;
	public static int volt;
	public static int vtt=1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntraAluno window = new EntraAluno();
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
	public EntraAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEntraInstitu = new JFrame();
		frmEntraInstitu.getContentPane().setBackground(Color.BLACK);
		frmEntraInstitu.setBounds(100, 100, 780, 699);
		frmEntraInstitu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntraInstitu.getContentPane().setLayout(null);
		frmEntraInstitu.setResizable(false);
		frmEntraInstitu.setLocationRelativeTo(null);
		JButton btnLogar = new JButton("LOGAR");
		btnLogar.setBackground(Color.LIGHT_GRAY);
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
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
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel_9.setBounds(161, 16, 458, 139);
		frmEntraInstitu.getContentPane().add(lblNewLabel_9);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnVoltar.setBounds(305, 617, 201, 33);
		frmEntraInstitu.getContentPane().add(btnVoltar);
		btnLogar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnLogar.setForeground(Color.BLACK);
		btnLogar.setBounds(73, 315, 201, 33);
		frmEntraInstitu.getContentPane().add(btnLogar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEntraInstitu.setVisible(false);
				Cadastrar_login.main(null);
			}
		});
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnCadastrar.setBounds(526, 315, 201, 33);
		frmEntraInstitu.getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel.setBounds(0, 573, 458, 33);
		frmEntraInstitu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(453, 573, 321, 33);
		frmEntraInstitu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(0, 62, 458, 33);
		frmEntraInstitu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(453, 62, 321, 33);
		frmEntraInstitu.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Bot\u00E3o png.png"));
		lblNewLabel_4.setBounds(67, 237, 269, 193);
		frmEntraInstitu.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Bot\u00E3o png.png"));
		lblNewLabel_6.setBounds(500, 219, 274, 239);
		frmEntraInstitu.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(412, 106, 46, 14);
		frmEntraInstitu.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(381, 106, 46, 14);
		frmEntraInstitu.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("D:\\Coluna grega em p\u00E9.jpg"));
		lblNewLabel_13.setBounds(397, 89, 46, 488);
		frmEntraInstitu.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setBounds(180, 530, 46, 14);
		frmEntraInstitu.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("D:\\1.png"));
		lblNewLabel_11.setBounds(-21, 89, 408, 500);
		frmEntraInstitu.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon("D:\\1.png"));
		lblNewLabel_15.setBounds(381, 89, 393, 488);
		frmEntraInstitu.getContentPane().add(lblNewLabel_15);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		label.setBounds(381, 78, 46, 14);
		frmEntraInstitu.getContentPane().add(label);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega em p\u00E9.jpg"));
		lblNewLabel_10.setBounds(396, 0, 62, 78);
		frmEntraInstitu.getContentPane().add(lblNewLabel_10);
	}
}
