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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EditarRemover.class.getResource("/47 - Copia.png")));
		frame.setBounds(100, 100, 468, 328);
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
		SpinerSprend.setBounds(67, 59, 88, 20);
		frame.getContentPane().add(SpinerSprend);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNome.setBounds(10, 11, 64, 15);
		frame.getContentPane().add(lblNome);
		
		lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIdade.setBounds(10, 59, 64, 15);
		frame.getContentPane().add(lblIdade);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(10, 105, 64, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTelefone.setBounds(10, 166, 88, 15);
		frame.getContentPane().add(lblTelefone);
		
		/*ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbFeminino);
		grupo.add(rbMasculino);
		grupo.add(rbaluprof);
		*/
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(SystemColor.textHighlight);
		btnEditar.setBackground(SystemColor.control);
		btnEditar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
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
		btnEditar.setBounds(10, 251, 131, 33);
		frame.getContentPane().add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(SystemColor.control);
		btnRemover.setForeground(SystemColor.textHighlight);
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
		
		
		btnRemover.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRemover.setBounds(164, 251, 118, 33);
		frame.getContentPane().add(btnRemover);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.setForeground(SystemColor.textHighlight);
		btnCancelar.setBackground(SystemColor.control);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VerAlunos.main(null);
				frame.dispose();
			}
		});
		btnCancelar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancelar.setBounds(304, 251, 131, 33);
		frame.getContentPane().add(btnCancelar);
		
		tfNome = new JTextField();
		tfNome.setBounds(67, 11, 374, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(84, 105, 357, 20);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(93, 166, 168, 20);
		frame.getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EditarRemover.class.getResource("/Principal (2).png")));
		label.setBounds(0, 0, 462, 304);
		frame.getContentPane().add(label);
		
		
		
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
