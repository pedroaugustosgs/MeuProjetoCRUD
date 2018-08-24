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

	public JFrame frmApprofe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmApprofe.setVisible(true);
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
		frmApprofe = new JFrame();
		frmApprofe.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Imagem\\img\\students-cap.png"));
		frmApprofe.setTitle("Approfe");
		frmApprofe.getContentPane().setBackground(Color.BLACK);
		frmApprofe.setBounds(100, 100, 826, 522);
		frmApprofe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmApprofe.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("SAIR");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Você realmente deseja sair?",
						"Alerta",
						JOptionPane.YES_NO_OPTION);
				
				
				if (resposta == JOptionPane.YES_OPTION) {
				frmApprofe.setVisible(false);
				Principal2.main(null);

				}
				if (resposta == JOptionPane.NO_OPTION) {
					
				}
				
				
			}
			});
		
		JButton btnAulas = new JButton("VISUALIZAR AULAS");
		btnAulas.setBackground(Color.LIGHT_GRAY);
		btnAulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerAulas.main(null);
				frmApprofe.dispose();
			}
		});
		btnAulas.setForeground(Color.BLACK);
		btnAulas.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnAulas.setBounds(495, 204, 281, 40);
		frmApprofe.getContentPane().add(btnAulas);
		btnNewButton_1.setBounds(325, 443, 211, 40);
		frmApprofe.getContentPane().add(btnNewButton_1);
		
		JButton btnVisualizarAlunos = new JButton("VISUALIZAR USU\u00C1RIOS");
		btnVisualizarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmApprofe.setVisible(false);
				VerAlunos.main(null);
			}
		});
		btnVisualizarAlunos.setForeground(Color.BLACK);
		btnVisualizarAlunos.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVisualizarAlunos.setBackground(Color.LIGHT_GRAY);
		btnVisualizarAlunos.setBounds(24, 204, 281, 39);
		frmApprofe.getContentPane().add(btnVisualizarAlunos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(0, 395, 470, 24);
		frmApprofe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(463, 395, 357, 24);
		frmApprofe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(0, 87, 492, 35);
		frmApprofe.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(478, 87, 342, 35);
		frmApprofe.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega em p\u00E9.jpg"));
		lblNewLabel_5.setBounds(424, 94, 61, 302);
		frmApprofe.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Bot\u00E3o png.png"));
		lblNewLabel_6.setBounds(67, 133, 251, 202);
		frmApprofe.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\1.png"));
		lblNewLabel_4.setBounds(-51, 93, 478, 314);
		frmApprofe.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\Imagem\\img\\Bot\u00E3o png.png"));
		lblNewLabel_9.setBounds(533, 94, 330, 289);
		frmApprofe.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\1.png"));
		lblNewLabel_7.setBounds(385, 94, 478, 302);
		frmApprofe.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel_8.setBounds(268, -14, 455, 117);
		frmApprofe.getContentPane().add(lblNewLabel_8);
		
		frmApprofe.setResizable(false);//impede a tela de ser redimensionada
		frmApprofe.setLocationRelativeTo(null);//faz com que a tela apareça no centro
	}
}
