package Instituição;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Banco.Conexao;
import CRUD.Aluno;
import CRUD.CRUDAlunos;
import CRUD.CRUDInstituição;


import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

public class EditarRemover {

	public JFrame frame;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfTelefone;

	public static Aluno aluno;
	private JLabel lblIdade;
	private JSpinner SpinerSprend;
	public static String idAluno; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		idAluno =args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarRemover window = new EditarRemover();
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
	public EditarRemover() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EditarRemover.class.getResource("/47 - Copia.png")));
		frame.setBounds(100, 100, 852, 712);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		SpinerSprend = new JSpinner();
		SpinerSprend.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor = (int) SpinerSprend.getValue();
				if(valor<1) {
					SpinerSprend.setValue(1);
				}
				if(valor>100) {
					SpinerSprend.setValue(100);
				}
				
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(-8, 185, 492, 23);
		frame.getContentPane().add(lblNewLabel_6);
		SpinerSprend.setBounds(63, 436, 88, 20);
		frame.getContentPane().add(SpinerSprend);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNome.setBounds(405, 436, 64, 15);
		frame.getContentPane().add(lblNome);
		
		lblIdade = new JLabel("Idade:");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIdade.setBounds(3, 436, 64, 15);
		frame.getContentPane().add(lblIdade);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(405, 492, 64, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTelefone.setBounds(3, 492, 88, 15);
		frame.getContentPane().add(lblTelefone);
		
		/*ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbFeminino);
		grupo.add(rbMasculino);
		grupo.add(rbaluprof);
		*/
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(SystemColor.control);
		btnEditar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CRUDInstituição editar = new CRUDInstituição();
					int idade = (int) SpinerSprend.getValue();
					
					editar.alterarAluno(tfNome.getText(),
							idade,
							tfEmail.getText(),
							tfTelefone.getText(),
							Integer.parseInt(idAluno));                  //*********************************************ERRO******************************************//
					
					JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados do aluno");
				}
				VerAlunos.main(null);
				frame.dispose();
			}
		});
		btnEditar.setBounds(0, 651, 131, 33);
		frame.getContentPane().add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(SystemColor.control);
		btnRemover.setForeground(Color.BLACK);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUDAlunos remover = new CRUDAlunos();
				
				int resposta = JOptionPane.showConfirmDialog(null, "Você realmente deseja remover este aluno?",
						"Alerta",
						JOptionPane.YES_NO_OPTION);
				
				
				if (resposta == JOptionPane.YES_OPTION) {
					remover.removeAluno(aluno.getIdAluno());
					JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");
				}
				if (resposta == JOptionPane.NO_OPTION) {
					return;
				}
					VerAlunos.main(null);
					frame.dispose();
			}
		});
		
		
		btnRemover.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnRemover.setBounds(407, 651, 118, 33);
		frame.getContentPane().add(btnRemover);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(SystemColor.control);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VerAlunos.main(null);
				frame.dispose();
			}
		});
		btnCancelar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnCancelar.setBounds(715, 651, 131, 33);
		frame.getContentPane().add(btnCancelar);
		
		tfNome = new JTextField();
		tfNome.setBounds(462, 436, 374, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(479, 492, 357, 20);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(91, 492, 168, 20);
		frame.getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Monografia oficial\\BARRA ofcial.png"));
		lblNewLabel_1.setBounds(3, 534, 492, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Monografia oficial\\BARRA ofcial.png"));
		lblNewLabel_2.setBounds(444, 534, 421, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Monografia oficial\\BARRA ofcial.png"));
		lblNewLabel_3.setBounds(3, 467, 412, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Monografia oficial\\BARRA ofcial.png"));
		lblNewLabel_4.setBounds(405, 467, 441, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel_5.setBounds(173, 0, 585, 214);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(461, 211, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\BARRA ofcial.png"));
		lblNewLabel_10.setBounds(3, 401, 492, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\BARRA ofcial.png"));
		lblNewLabel.setBounds(492, 401, 354, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_9.setBounds(479, 185, 367, 23);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_7.setBounds(-9, 0, 478, 33);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_12.setBounds(462, 0, 384, 33);
		frame.getContentPane().add(lblNewLabel_12);
		
		
		
		colocaDadosNaTela();
	}
	public void colocaDadosNaTela() {
			ResultSet dados=null;
		    String sql = "Select * from alunos WHERE usuario = ?";
		    PreparedStatement s;
			try {
				s = Conexao.conexao.prepareStatement(sql);
				s.setString(1, idAluno);
				dados = s.executeQuery();
				s.execute();
				s.close();
				
				if(dados.next()) {
					tfNome.setText(dados.getString("nome"));
					int idade = Integer.parseInt(dados.getString("idade"));
					SpinerSprend.setValue(idade);
					tfEmail.setText(dados.getString("email"));
					tfTelefone.setText(dados.getString("fone"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
