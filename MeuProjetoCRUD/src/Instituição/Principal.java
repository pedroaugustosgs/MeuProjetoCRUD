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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/47 - Copia.png")));
		frame.setBounds(100, 100, 826, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_1.setForeground(SystemColor.textHighlight);
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
		btnAulas.setForeground(SystemColor.textHighlight);
		btnAulas.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		btnAulas.setBounds(316, 225, 211, 40);
		frame.getContentPane().add(btnAulas);
		btnNewButton_1.setBounds(316, 327, 211, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/47 - Copia.png")));
		lblNewLabel_1.setBounds(484, -14, 326, 194);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnVisualizarAlunos = new JButton("Visualizar Usu\u00E1rios");
		btnVisualizarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				VerAlunos.main(null);
			}
		});
		btnVisualizarAlunos.setForeground(SystemColor.textHighlight);
		btnVisualizarAlunos.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnVisualizarAlunos.setBackground(Color.WHITE);
		btnVisualizarAlunos.setBounds(316, 276, 211, 40);
		frame.getContentPane().add(btnVisualizarAlunos);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Principal (2).png")));
		lblNewLabel.setBounds(-105, 0, 925, 494);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setResizable(false);//impede a tela de ser redimensionada
		frame.setLocationRelativeTo(null);//faz com que a tela apareça no centro
	}
}
