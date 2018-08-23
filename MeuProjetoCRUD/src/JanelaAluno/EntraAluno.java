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
import java.awt.Toolkit;



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
		frmEntraInstitu.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Imagem\\img\\students-cap.png"));
		frmEntraInstitu.setTitle("APPROFE");
		frmEntraInstitu.getContentPane().setBackground(Color.BLACK);
		frmEntraInstitu.setBounds(100, 100, 780, 699);
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
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEntraInstitu.setVisible(false);
				Cadastrar_login.main(null);
			}
		});
		JButton btnLogar = new JButton("LOGAR");
		btnLogar.setBackground(Color.LIGHT_GRAY);
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
				frmEntraInstitu.dispose();
			}
		});
		btnLogar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnLogar.setForeground(Color.BLACK);
		btnLogar.setBounds(107, 331, 164, 39);
		frmEntraInstitu.getContentPane().add(btnLogar);
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnCadastrar.setBounds(511, 331, 164, 39);
		frmEntraInstitu.getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Bot\u00E3o png.png"));
		lblNewLabel_5.setBounds(96, 267, 185, 190);
		frmEntraInstitu.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Bot\u00E3o png.png"));
		lblNewLabel_6.setBounds(498, 242, 185, 239);
		frmEntraInstitu.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(0, 555, 458, 33);
		frmEntraInstitu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega em p\u00E9.jpg"));
		lblNewLabel_15.setBounds(381, 131, 24, 446);
		frmEntraInstitu.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(0, 101, 347, 33);
		frmEntraInstitu.getContentPane().add(lblNewLabel_2);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBounds(309, 616, 164, 39);
		frmEntraInstitu.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(453, 555, 321, 33);
		frmEntraInstitu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(344, 101, 430, 33);
		frmEntraInstitu.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(381, 106, 46, 14);
		frmEntraInstitu.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setBounds(180, 530, 46, 14);
		frmEntraInstitu.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega em p\u00E9.jpg"));
		lblNewLabel_10.setBounds(396, 80, 62, -2);
		frmEntraInstitu.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(381, 7, 46, 14);
		frmEntraInstitu.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setBounds(412, 106, 46, 14);
		frmEntraInstitu.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\fundo1111.png"));
		lblNewLabel_4.setBounds(0, 117, 793, 443);
		frmEntraInstitu.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel_9.setBounds(138, 7, 495, 113);
		frmEntraInstitu.getContentPane().add(lblNewLabel_9);
	}
}
