package Menu_principal;

import java.awt.EventQueue;

import javax.swing.JFrame;



import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import Instituição.EntraInstitu;

import JanelaAluno.EntraAluno;
import javax.swing.SwingConstants;

import Banco.Conexao;


public class Principal2 {

	public static int tela;
	public JFrame frmMeuProjetoCrud;
	public int anterior;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal2 window = new Principal2();
					window.frmMeuProjetoCrud.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

	/**
	 * Create the application.
	 */
	public Principal2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Conexao.getConexao();
		frmMeuProjetoCrud = new JFrame();
		frmMeuProjetoCrud.getContentPane().setBackground(Color.BLACK);
		frmMeuProjetoCrud.setTitle("MEU PROJETO CRUD");
		frmMeuProjetoCrud.setBounds(100, 100, 1001, 606);
		frmMeuProjetoCrud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMeuProjetoCrud.getContentPane().setLayout(null);
		
		frmMeuProjetoCrud.setResizable(false);
		frmMeuProjetoCrud.setLocationRelativeTo(null);
		
		JButton sair = new JButton("SAIR");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Você realmente deseja sair?",
						"Alerta",
						JOptionPane.YES_NO_OPTION); 
				
				
				if (resposta == JOptionPane.YES_OPTION) {
					frmMeuProjetoCrud.dispose();
				}
			}
		});
		sair.setForeground(Color.BLACK);
		sair.setFont(new Font("DialogInput", Font.BOLD, 25));
		sair.setBackground(Color.LIGHT_GRAY);
		sair.setBounds(429, 530, 164, 39);
		frmMeuProjetoCrud.getContentPane().add(sair);
		
		JButton btnVisualizarAlunos = new JButton("INSTITUIÇÃO");
		btnVisualizarAlunos.setBackground(Color.LIGHT_GRAY);
		btnVisualizarAlunos.setForeground(Color.BLACK);
		btnVisualizarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//anterior=1;
				frmMeuProjetoCrud.setVisible(false);
				EntraInstitu.main(null);
			}
		});
		btnVisualizarAlunos.setFont(new Font("DialogInput", Font.BOLD, 25));
		btnVisualizarAlunos.setBounds(115, 388, 230, 39);
		frmMeuProjetoCrud.getContentPane().add(btnVisualizarAlunos);
		
		JButton btnSair = new JButton("ALUNO");
		btnSair.setForeground(Color.BLACK); 
		btnSair.setBackground(Color.LIGHT_GRAY); 
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntraAluno.main(null);
				frmMeuProjetoCrud.dispose(); //********************************************** chat = id remetente, id destinatario, mensagem, data e hora, sempre insert
			}
		});
		btnSair.setFont(new Font("DialogInput", Font.BOLD, 25));
		btnSair.setBounds(710, 388, 140, 39);
		frmMeuProjetoCrud.getContentPane().add(btnSair);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(150, 148, 46, 14);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(356, 530, 46, 14);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(0, 446, 431, 99);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(429, 483, 324, 24);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(748, 480, 247, 30);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega em p\u00E9.jpg"));
		lblNewLabel_3.setBounds(493, 114, 27, 82);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega em p\u00E9.jpg"));
		lblNewLabel_7.setBounds(493, 193, 46, 291);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\escola.png"));
		lblNewLabel_6.setBounds(133, 207, 200, 187);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\aluno.png"));
		lblNewLabel_8.setBounds(676, 193, 200, 214);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_10.setBounds(0, 96, 333, 49);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_11.setBounds(329, 104, 178, 32);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_12.setBounds(506, 98, 489, 45);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(474, 113, 46, 14);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon("D:\\1.png"));
		lblNewLabel_15.setBounds(659, 122, 46, 14);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setIcon(new ImageIcon("D:\\Imagem\\img\\fundo.png"));
		lblNewLabel_13.setBounds(0, 126, 496, 358);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setIcon(new ImageIcon("D:\\Imagem\\img\\fundo.png"));
		lblNewLabel_14.setBounds(516, 126, 479, 358);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel_16.setBounds(250, 0, 472, 118);
		frmMeuProjetoCrud.getContentPane().add(lblNewLabel_16);
	}
}
