package Instituição;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;

import Instituição.VerAlunos;
import Menu_principal.Principal2;

import java.awt.Toolkit;

public class Principal {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/47 - Copia.png")));
		frame.setBounds(100, 100, 826, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Você realmente deseja sair?",
						"Alerta",
						JOptionPane.YES_NO_OPTION);
				
				
				if (resposta == JOptionPane.YES_OPTION) {
				frame.setVisible(false);
				Principal2.main(null);

				}
				if (resposta == JOptionPane.NO_OPTION) {
					
				}
				
				
			}
			});
		
		JButton btnAulas = new JButton("Visualizar Aulas");
		btnAulas.setBackground(Color.WHITE);
		btnAulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerAulas.main(null);
				frame.dispose();
			}
		});
		btnAulas.setForeground(Color.BLACK);
		btnAulas.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnAulas.setBounds(531, 200, 211, 40);
		frame.getContentPane().add(btnAulas);
		btnNewButton_1.setBounds(313, 430, 211, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnVisualizarAlunos = new JButton("Visualizar Usu\u00E1rios");
		btnVisualizarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				VerAlunos.main(null);
			}
		});
		btnVisualizarAlunos.setForeground(Color.BLACK);
		btnVisualizarAlunos.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnVisualizarAlunos.setBackground(Color.WHITE);
		btnVisualizarAlunos.setBounds(81, 200, 211, 40);
		frame.getContentPane().add(btnVisualizarAlunos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(0, 378, 470, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(463, 378, 357, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Bot\u00E3o png.png"));
		lblNewLabel_3.setBounds(81, 140, 166, 164);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Bot\u00E3o png.png"));
		lblNewLabel_6.setBounds(531, 131, 250, 185);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Coluna grega em p\u00E9.jpg"));
		lblNewLabel_4.setBounds(409, 76, 59, 305);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(0, 45, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_8.setBounds(0, 48, 414, 35);
		frame.getContentPane().add(lblNewLabel_8);
		

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\1.png"));
		lblNewLabel_5.setBounds(0, 94, 414, 284);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_9.setBounds(409, 45, 411, 40);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\1.png"));
		lblNewLabel_2.setBounds(409, 94, 411, 287);
		frame.getContentPane().add(lblNewLabel_2);
		
		frame.setResizable(false);//impede a tela de ser redimensionada
		frame.setLocationRelativeTo(null);//faz com que a tela apareça no centro
	}
}
