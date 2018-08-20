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
		frame.setBounds(100, 100, 784, 494);
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
		lblNewLabel_6.setBounds(0, 146, 492, 23);
		frame.getContentPane().add(lblNewLabel_6);
		SpinerSprend.setBounds(99, 314, 88, 20);
		frame.getContentPane().add(SpinerSprend);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNome.setBounds(15, 238, 64, 15);
		frame.getContentPane().add(lblNome);
		
		lblIdade = new JLabel("Idade:");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblIdade.setBounds(15, 315, 64, 15);
		frame.getContentPane().add(lblIdade);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(15, 280, 88, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTelefone.setBounds(13, 351, 88, 15);
		frame.getContentPane().add(lblTelefone);
		
		/*ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbFeminino);
		grupo.add(rbMasculino);
		grupo.add(rbaluprof);
		*/
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(Color.LIGHT_GRAY);
		btnEditar.setFont(new Font("DialogInput", Font.BOLD, 20));
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
		btnEditar.setBounds(324, 426, 131, 33);
		frame.getContentPane().add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(Color.LIGHT_GRAY);
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
		
		
		btnRemover.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnRemover.setBounds(21, 425, 118, 33);
		frame.getContentPane().add(btnRemover);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VerAlunos.main(null);
				frame.dispose();
			}
		});
		btnCancelar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnCancelar.setBounds(625, 426, 131, 33);
		frame.getContentPane().add(btnCancelar);
		
		tfNome = new JTextField();
		tfNome.setBounds(97, 238, 290, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(97, 276, 291, 20);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(99, 348, 168, 20);
		frame.getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_1.setBounds(-8, 468, 492, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_2.setBounds(446, 468, 421, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_3.setBounds(-8, 388, 412, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_4.setBounds(395, 388, 451, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel_5.setBounds(191, -20, 451, 214);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(461, 211, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\BARRA ofcial.png"));
		lblNewLabel.setBounds(482, 314, 364, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_9.setBounds(479, 146, 367, 23);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_7.setBounds(-9, 0, 478, 33);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_12.setBounds(462, 0, 384, 33);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_11.setBounds(-8, 583, 477, 33);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_13.setBounds(459, 583, 421, 33);
		frame.getContentPane().add(lblNewLabel_13);
		
		
		
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
