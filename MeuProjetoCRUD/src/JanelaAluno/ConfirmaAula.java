package JanelaAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import com.toedter.calendar.JCalendar;

import Banco.Conexao;
import CRUD.CRUDAlunos;
import CRUD.CRUDEmail;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Toolkit;

public class ConfirmaAula extends Login{

	private JFrame frmConfirmeSuaAula;
	private static String idAula;
	private JLabel lblmateria;
	private JLabel lblprofessor;
	private JLabel lblconteudo;
	private JLabel lbllocal;
	private JLabel lblvagas;
	private JCheckBox chSegunda;
	private JCheckBox chTerca;
	private JCheckBox chQuartafeira;
	private JCheckBox chQuintafeira;
	private JCheckBox chSextafeira;
	private JCheckBox chSbado;
	private JCheckBox chDomingo;
	private JCheckBox chckbxManh;
	private JCheckBox chckbxNoite;
	private JCheckBox chckbxTarde;
	private JLabel lbldemanha;
	private JLabel lbldetarde;
	private JLabel lblDeNoite;
	private JLabel lblatemanha;
	private JLabel lblatetarde;
	private JLabel lblatenoite;
	private JPanel panel_1;
	private JLabel lbldata;
	private JLabel lblatedata;
	private JLabel lbldedata;
	private JPanel panel;
	private int panels=1;
	private JTable tabela; 
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		idAula = args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmaAula window = new ConfirmaAula();
					window.frmConfirmeSuaAula.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConfirmaAula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConfirmeSuaAula = new JFrame();
		frmConfirmeSuaAula.setTitle("Confirme sua aula");
		frmConfirmeSuaAula.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Imagem\\img\\students-cap.png"));
		frmConfirmeSuaAula.getContentPane().setBackground(Color.BLACK);
		frmConfirmeSuaAula.setBounds(100, 100, 1062, 652);
		frmConfirmeSuaAula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConfirmeSuaAula.getContentPane().setLayout(null);
		frmConfirmeSuaAula.setLocationRelativeTo(null);
		frmConfirmeSuaAula.setResizable(true);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setVisible(false);
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_12.setBounds(759, 304, 280, 14);
		frmConfirmeSuaAula.getContentPane().add(lblNewLabel_12);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_11.setBounds(303, 304, 488, 14);
		frmConfirmeSuaAula.getContentPane().add(lblNewLabel_11);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_10.setBounds(10, 304, 307, 14);
		frmConfirmeSuaAula.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(1, 88, 455, 34);
		frmConfirmeSuaAula.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(435, 88, 470, 34);
		frmConfirmeSuaAula.getContentPane().add(lblNewLabel_6);
		panel.setBounds(274, 133, 770, 173);
		frmConfirmeSuaAula.getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label_7 = new Label("Turno:");
		label_7.setBounds(296, 11, 66, 23);
		panel.add(label_7);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		chckbxManh = new JCheckBox("Manh\u00E3");
		chckbxManh.setBackground(Color.BLACK);
		chckbxManh.setForeground(Color.WHITE);
		chckbxManh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxManh.setSelected(true);
			}
		});
		chckbxManh.setEnabled(false);
		chckbxManh.setBounds(296, 40, 66, 23);
		panel.add(chckbxManh);
		
		chckbxTarde = new JCheckBox("Tarde");
		chckbxTarde.setBackground(Color.BLACK);
		chckbxTarde.setForeground(Color.WHITE);
		chckbxTarde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxTarde.setSelected(true);
			}
		});
		chckbxTarde.setEnabled(false);
		chckbxTarde.setBounds(482, 38, 58, 23);
		panel.add(chckbxTarde);
		
		chckbxNoite = new JCheckBox("Noite");
		chckbxNoite.setBackground(Color.BLACK);
		chckbxNoite.setForeground(Color.WHITE);
		chckbxNoite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxNoite.setSelected(true);
			}
		});
		chckbxNoite.setEnabled(false);
		chckbxNoite.setBounds(670, 40, 74, 23);
		panel.add(chckbxNoite);
		
		Label label_6 = new Label("Data:");
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(10, 10, 49, 24);
		panel.add(label_6);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		chSegunda = new JCheckBox("Segunda-Feira");
		chSegunda.setBackground(Color.BLACK);
		chSegunda.setForeground(Color.WHITE);
		chSegunda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chSegunda.setSelected(true);
			}
		});
		chSegunda.setEnabled(false);
		chSegunda.setBounds(10, 40, 126, 23);
		panel.add(chSegunda);
		
		chTerca = new JCheckBox("Ter\u00E7a-Feira");
		chTerca.setBackground(Color.BLACK);
		chTerca.setForeground(Color.WHITE);
		chTerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chTerca.setSelected(true);
			}
		});
		chTerca.setEnabled(false);
		chTerca.setBounds(10, 66, 111, 23);
		panel.add(chTerca);
		
		chQuartafeira = new JCheckBox("Quarta-Feira");
		chQuartafeira.setBackground(Color.BLACK);
		chQuartafeira.setForeground(Color.WHITE);
		chQuartafeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chQuartafeira.setSelected(true);
			}
		});
		chQuartafeira.setEnabled(false);
		chQuartafeira.setBounds(10, 92, 97, 23);
		panel.add(chQuartafeira);
		
		chQuintafeira = new JCheckBox("Quinta-Feira");
		chQuintafeira.setBackground(Color.BLACK);
		chQuintafeira.setForeground(Color.WHITE);
		chQuintafeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chQuintafeira.setSelected(true);
			}
		});
		chQuintafeira.setEnabled(false);
		chQuintafeira.setBounds(10, 118, 97, 23);
		panel.add(chQuintafeira);
		
		chSextafeira = new JCheckBox("Sexta-Feira");
		chSextafeira.setBackground(Color.BLACK);
		chSextafeira.setForeground(Color.WHITE);
		chSextafeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chSextafeira.setSelected(true);
			}
		});
		chSextafeira.setEnabled(false);
		chSextafeira.setBounds(10, 144, 97, 23);
		panel.add(chSextafeira);
		
		chSbado = new JCheckBox("S\u00E1bado");
		chSbado.setBackground(Color.BLACK);
		chSbado.setForeground(Color.WHITE);
		chSbado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chSbado.setSelected(true);
			}
		});
		chSbado.setEnabled(false);
		chSbado.setBounds(138, 40, 72, 23);
		panel.add(chSbado);
		
		chDomingo = new JCheckBox("Domingo");
		chDomingo.setBackground(Color.BLACK);
		chDomingo.setForeground(Color.WHITE);
		chDomingo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chDomingo.setSelected(true);
			}
		});
		chDomingo.setEnabled(false);
		chDomingo.setBounds(138, 72, 97, 23);
		panel.add(chDomingo);
		
		JLabel lblNewLabel = new JLabel("DE:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setVisible(false);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(248, 65, 40, 23);
		panel.add(lblNewLabel);
		
		JLabel lblAt = new JLabel("AT\u00C9:");
		lblAt.setForeground(Color.WHITE);
		lblAt.setVisible(false);
		lblAt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblAt.setBounds(241, 91, 40, 23);
		panel.add(lblAt);
		
		JLabel label_8 = new JLabel("DE:");
		label_8.setForeground(Color.WHITE);
		label_8.setVisible(false);
		label_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_8.setBounds(442, 64, 40, 23);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("AT\u00C9:");
		label_9.setForeground(Color.WHITE);
		label_9.setVisible(false);
		label_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_9.setBounds(433, 89, 40, 23);
		panel.add(label_9);
		
		JLabel lbldenoite = new JLabel("DE:");
		lbldenoite.setForeground(Color.WHITE);
		lbldenoite.setVisible(false);
		lbldenoite.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lbldenoite.setBounds(648, 63, 40, 23);
		panel.add(lbldenoite);
		
		JLabel label_11 = new JLabel("AT\u00C9:");
		label_11.setForeground(Color.WHITE);
		label_11.setVisible(false);
		label_11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_11.setBounds(637, 92, 40, 23);
		panel.add(label_11);
		
		lbldemanha = new JLabel("");
		lbldemanha.setBackground(Color.BLACK);
		lbldemanha.setForeground(Color.WHITE);
		lbldemanha.setVisible(false);
		lbldemanha.setBounds(296, 66, 66, 23);
		panel.add(lbldemanha);
		
		lbldetarde = new JLabel("");
		lbldetarde.setBackground(Color.BLACK);
		lbldetarde.setForeground(Color.WHITE);
		lbldetarde.setVisible(false);
		lbldetarde.setBounds(482, 70, 66, 20);
		panel.add(lbldetarde);
		
		lblDeNoite = new JLabel("");
		lblDeNoite.setForeground(Color.WHITE);
		lblDeNoite.setVisible(false);
		lblDeNoite.setBounds(687, 64, 66, 20);
		panel.add(lblDeNoite);
		
		lblatemanha = new JLabel("");
		lblatemanha.setBackground(Color.BLACK);
		lblatemanha.setForeground(Color.WHITE);
		lblatemanha.setVisible(false);
		lblatemanha.setBounds(296, 92, 72, 21);
		panel.add(lblatemanha);
		
		lblatetarde = new JLabel("");
		lblatetarde.setBackground(Color.BLACK);
		lblatetarde.setForeground(Color.WHITE);
		lblatetarde.setVisible(false);
		lblatetarde.setBounds(484, 90, 73, 21);
		panel.add(lblatetarde);
		
		lblatenoite = new JLabel("");
		lblatenoite.setForeground(Color.WHITE);
		lblatenoite.setVisible(false);
		lblatenoite.setBounds(687, 91, 74, 23);
		panel.add(lblatenoite);
		
		Label label_5 = new Label("Turno:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_5.setBounds(474, 11, 66, 23);
		panel.add(label_5);
		
		Label label_10 = new Label("Turno:");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_10.setBounds(677, 11, 66, 23);
		panel.add(label_10);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(-36, 527, 488, 52);
		frmConfirmeSuaAula.getContentPane().add(lblNewLabel_2);
		
		Label label = new Label("Mat\u00E9ria:");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label.setForeground(Color.WHITE);
		label.setBounds(18, 125, 58, 22);
		frmConfirmeSuaAula.getContentPane().add(label);
		
		Label label_1 = new Label("Professor:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_1.setBounds(15, 153, 66, 22);
		frmConfirmeSuaAula.getContentPane().add(label_1);
		
		Label label_2 = new Label("Conte\u00FAdo:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(13, 181, 66, 22);
		frmConfirmeSuaAula.getContentPane().add(label_2);
		
		Label label_3 = new Label("Local:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(14, 210, 49, 22);
		frmConfirmeSuaAula.getContentPane().add(label_3);
		
		Label label_4 = new Label("Vagas:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_4.setBounds(12, 238, 49, 22);
		frmConfirmeSuaAula.getContentPane().add(label_4);
		
		lblmateria = new JLabel("");
		lblmateria.setForeground(Color.WHITE);
		lblmateria.setBounds(75, 125, 146, 22);
		frmConfirmeSuaAula.getContentPane().add(lblmateria);
		
		lblprofessor = new JLabel("");
		lblprofessor.setForeground(Color.WHITE);
		lblprofessor.setBounds(85, 152, 137, 22);
		frmConfirmeSuaAula.getContentPane().add(lblprofessor);
		
		lblconteudo = new JLabel("");
		lblconteudo.setForeground(Color.WHITE);
		lblconteudo.setBounds(82, 180, 146, 22);
		frmConfirmeSuaAula.getContentPane().add(lblconteudo);
		
		lbllocal = new JLabel("");
		lbllocal.setForeground(Color.WHITE);
		lbllocal.setBounds(68, 210, 153, 22);
		frmConfirmeSuaAula.getContentPane().add(lbllocal);
		
		lblvagas = new JLabel("");
		lblvagas.setForeground(Color.WHITE);
		lblvagas.setBounds(65, 239, 153, 19);
		frmConfirmeSuaAula.getContentPane().add(lblvagas);
		
		JButton btnNewButton = new JButton("CONFIRMAR");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int vaga= 0;
				ResultSet dado=null;
				String sql1 = "SELECT * FROM aulas WHERE idAula =?";
				try {
					PreparedStatement stmt1 = Conexao.conexao.prepareStatement(sql1);
					stmt1.setString(1, idAula);
					dado = stmt1.executeQuery();
					stmt1.execute();
					stmt1.close();
					
					if(dado.next()) {
						vaga = Integer.parseInt(dado.getString("vagas"))-1;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				boolean res = false;
				String sql ="INSERT INTO alunosconfirmados (idAluno ,idConfirmar) VALUES (?,?)";
				try {
					PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
					stmt.setString(1, PlaAluno.idaluno);
					stmt.setString(2, idAula);					
					stmt.execute();					
					stmt.close();
					res = true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
				}
				if(res) {
					String sql2 = "UPDATE aulas SET vagas =? WHERE idAula =?";
					try {
						PreparedStatement stmt2 = Conexao.conexao.prepareStatement(sql2);
						stmt2.setInt(1, vaga);
						stmt2.setString(2, idAula);
						stmt2.execute();
						stmt2.close();
						System.out.println(vaga);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao confirmar nova aula!");
				}
				ResultSet prof=null;
				ResultSet alu=null;
				ResultSet aula=null;
				
				String sqk="SELECT * FROM alunos INNER JOIN Aulas ON Alunos.idaluno=aulas.professor where idaula = ?";
				String sqkj = "SELECT * FROM alunos WHERE idaluno= ? ";
				String sq = "SELECT * FROM aulas WHERE idaula=?";
				try {
					PreparedStatement stm = Conexao.conexao.prepareStatement(sqk);
					stm.setString(1, idAula);
					prof = stm.executeQuery();
					stm.execute();
					stm.close();
					
					
					PreparedStatement slot = Conexao.conexao.prepareStatement(sqkj);
					slot.setString(1, PlaAluno.idaluno);
					alu = slot.executeQuery();
					slot.execute();
					slot.close();
					
					PreparedStatement jda = Conexao.conexao.prepareStatement(sq);
					jda.setString(1, idAula);
					aula = jda.executeQuery();
					jda.execute();
					jda.close();
					prof.first();
					alu.first();
					aula.first();
					String msg = "O(a) aluno(a) "+alu.getString("nome")+" foi cadastrado(a) em sua aula de "+Materia(aula.getString("materia"))+" sobre "
							+ ""+aula.getString("conteudo");
					
					CRUDEmail a = new CRUDEmail();
					a.EmailVisuAulas(prof.getString("email"), msg);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Nova Aula Confirmada com Sucesso!");
				
				PlaAluno.main(null);       
				frmConfirmeSuaAula.dispose();
			}
		});
		btnNewButton.setBounds(1, 575, 164, 39);
		frmConfirmeSuaAula.getContentPane().add(btnNewButton);
		
		JButton btnNovoltar = new JButton("VOLTAR");
		btnNovoltar.setForeground(Color.BLACK);
		btnNovoltar.setBackground(Color.LIGHT_GRAY);
		btnNovoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnNovoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerAula.main(null);
				frmConfirmeSuaAula.dispose();
			}
		});
		btnNovoltar.setBounds(880, 575, 164, 39);
		frmConfirmeSuaAula.getContentPane().add(btnNovoltar);
		
		tabela = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(257, 324, 498, 213);
		frmConfirmeSuaAula.getContentPane().add(scrollPane);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(435, 527, 488, 52);
		frmConfirmeSuaAula.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(915, 527, 129, 52);
		frmConfirmeSuaAula.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_7.setBounds(876, 93, 168, 24);
		frmConfirmeSuaAula.getContentPane().add(lblNewLabel_7);
		
		panel_1 = new JPanel();
		panel_1.setBounds(232, 138, 168, 109);
		frmConfirmeSuaAula.getContentPane().add(panel_1);
		panel_1.setBackground(Color.BLACK);
		panel_1.setVisible(false);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(10, 11, 56, 19);
		panel_1.add(lblNewLabel_1);
		
		lbldata = new JLabel("");
		lbldata.setForeground(Color.WHITE);
		lbldata.setBounds(78, 11, 86, 19);
		panel_1.add(lbldata);
		
		JLabel lblDe = new JLabel("DE:");
		lblDe.setForeground(Color.WHITE);
		lblDe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDe.setBounds(10, 39, 56, 19);
		panel_1.add(lblDe);
		
		JLabel lblAt_1 = new JLabel("AT\u00C9:");
		lblAt_1.setForeground(Color.WHITE);
		lblAt_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblAt_1.setBounds(10, 60, 56, 19);
		panel_1.add(lblAt_1);
		
		lbldedata = new JLabel("");
		lbldedata.setForeground(Color.WHITE);
		lbldedata.setBounds(64, 36, 80, 19);
		panel_1.add(lbldedata);
		
		lblatedata = new JLabel("");
		lblatedata.setForeground(Color.WHITE);
		lblatedata.setBounds(64, 59, 86, 19);
		panel_1.add(lblatedata);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\Imagem\\img\\info1111.jpg"));
		lblNewLabel_9.setBounds(117, 3, 893, 94);
		frmConfirmeSuaAula.getContentPane().add(lblNewLabel_9);
		
		preencherTela();
		
		if(panels==0) {
			panel.setVisible(true);
		}else {
			panel_1.setVisible(true);
		}
		
		if(chckbxManh.isSelected()) {
			lblNewLabel.setVisible(true);
			lblAt.setVisible(true);
			lbldemanha.setVisible(true);
			lblatemanha.setVisible(true);
		}
		
		if(chckbxTarde.isSelected()) {
			label_8.setVisible(true);
			label_9.setVisible(true);
			lbldetarde.setVisible(true);
			lblatetarde.setVisible(true);
		}
		
		if(chckbxNoite.isSelected()) {
			lblDeNoite.setVisible(true);
			label_11.setVisible(true);
			lbldenoite.setVisible(true);
			lblatenoite.setVisible(true);
		}
		
		criaTabela(dadosAlunos());
	}
	
	public void criaTabela(ResultSet dados) {
		String[] colunas = {"Nome","Idade","E-Mail","Escola"};
			ArrayList linhas = new ArrayList<>();
			try {
				while (dados.next()) {	
					/*ResultSet alunos = null;
					String sql6="SELECT * FROM alunos WHERE idaluno=?";
					PreparedStatement stmt6 = Conexao.conexao.prepareStatement(sql6);
					stmt6.setString(1, dados.getString("idaluno"));
					alunos = stmt6.executeQuery();
					stmt6.execute();
					stmt6.close();
					alunos.first();
					
					ResultSet escola = null;
					String sql7="SELECT * FROM instituição WHERE id=?";
					PreparedStatement stmt7 = Conexao.conexao.prepareStatement(sql7);
					stmt7.setString(1, alunos.getString("escola"));
					escola = stmt7.executeQuery();
					stmt7.execute();
					stmt7.close();
					escola.first();*/
					
					linhas.add(new Object[] {
							dados.getString("nome"),
							dados.getString("idade"),
							dados.getString("email"),
							//alunos.getString("escola"),
							dados.getString("nome"),
							//preencherComboInstitu(dados),
							});
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro ao preencher a tabela");
			}
			ModeloDaTabela modelo = new ModeloDaTabela(colunas, linhas);
			tabela.setModel(modelo);
			
			
			tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
			tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
			tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
			tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
			tabela.getColumnModel().getColumn(3).setResizable(false);
			
			
			//*****************************************************************************   tabela nova = discpplina , vagas , inscritos na tabela aulas, professor e aluno inscrito
			
			tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
			
			DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
			centralizado.setHorizontalAlignment(SwingConstants.CENTER);
			
			tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
			tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
			tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);


			

		}//*********************************
	
	public String preencherComboInstitu(ResultSet d) {
		String nome=null;
		ResultSet dados=null;
		String sql="SELECT * FROM instituição Where id=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, d.getString("escola"));
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			nome = dados.getString("nome");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nome;
	}
	
	public void preencherTela() {
		String sql ="SELECT * FROM aulas WHERE idaula=?";
		ResultSet dados=null;
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, idAula);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(dados.next()) {
				lblmateria.setText(Materia(dados.getString("materia")));
				lblconteudo.setText(dados.getString("conteudo"));
				lblprofessor.setText(NomeProf(idAula));
				lblvagas.setText(dados.getString("vagas"));
				lbllocal.setText(dados.getString("local"));
				if(dados.getString("segunda").equals("1")) {
					chSegunda.setSelected(true);
					panels = 0;
					chSegunda.setEnabled(true);
				}
				if(dados.getString("terca").equals("1")) {
					chTerca.setSelected(true);
					panels = 0;
					chTerca.setEnabled(true);
				}
				if(dados.getString("quarta").equals("1")) {
					chQuartafeira.setSelected(true);
					panels=0;
					chQuartafeira.setEnabled(true);
				}
				if(dados.getString("quinta").equals("1")) {
					chQuintafeira.setSelected(true);
					panels=0;
					chQuintafeira.setEnabled(true);
				}
				if(dados.getString("sexta").equals("1")) {
					chSextafeira.setSelected(true);
					panels=0;
					chSextafeira.setEnabled(true);
				}
				if(dados.getString("sabado").equals("1")) {
					chSbado.setSelected(true);
					panels=0;
					chSbado.setEnabled(true);
				}
				if(dados.getString("domingo").equals("1")) {
					chDomingo.setSelected(true);
					panels=0;
					chDomingo.setEnabled(true);
				}
				if(dados.getString("cedo").equals("1")) {
					chckbxManh.setSelected(true);
					chckbxManh.setEnabled(true);
				}
				if(dados.getString("tarde").equals("1")) {
					chckbxTarde.setSelected(true);
					chckbxTarde.setEnabled(true);
				}
				if(dados.getString("noite").equals("1")) {
					chckbxNoite.setSelected(true);
					chckbxNoite.setEnabled(true);
				}
				lbldemanha.setText(dados.getString("deManha"));
				lblatemanha.setText(dados.getString("ateManha"));
				lbldetarde.setText(dados.getString("deTarde"));
				lblatetarde.setText(dados.getString("ateTarde"));
				lblDeNoite.setText(dados.getString("deNoite"));
				lblatenoite.setText(dados.getString("ateNoite"));

				if(panels==1) {
					
					lbldata.setText(dados.getString("DiaUmaVez"));
					lbldedata.setText(dados.getString("DeUmaVez"));
					lblatedata.setText(dados.getString("AteUmaVez"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String NomeProf(String idAula2) {
		String nomeProf=null;
		ResultSet dadosAula=null;

		String idprof=null;
		ResultSet ddNome;
		String sql ="Select * From aulas Where idaula=?";
		try {
			PreparedStatement s = Conexao.conexao.prepareStatement(sql);
			s.setString(1, idAula2);
			dadosAula = s.executeQuery();
			s.execute();
			s.close();
			if(dadosAula.next()) {
				idprof = dadosAula.getString("professor");
			} 
			String sql2="Select * From alunos Where idAluno=?";
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql2);
			stmt.setString(1, idprof);
			ddNome = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			if(ddNome.next()) {
				nomeProf = ddNome.getString("nome");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomeProf;
	}
	public ResultSet dadosAlunos() {
		ResultSet aula=null;
		ResultSet alunos=null;
		String sql="SELECT * FROM alunos INNER JOIN alunosconfirmados ON alunos.idaluno = alunosconfirmados.idAluno WHERE idConfirmar=?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, idAula);
			alunos = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			/*while(aula.next()) {
				String sql6="SELECT * FROM alunos WHERE idaluno=?";
				PreparedStatement stmt6 = Conexao.conexao.prepareStatement(sql6);
				stmt6.setString(1, aula.getString("idaluno"));
				alunos = stmt6.executeQuery();
				stmt6.execute();
				stmt6.close();
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alunos;
	}
	public String Materia(String m){
		String materia=null;
		
		if(m.equals("RED")) {
			materia="REDAÇÃO";
		}
		if(m.equals("MAT")) {
			materia="MATEMÁTICA";
		}
		if(m.equals("QUI")) {
			materia="QUÍMICA";
		}
		if(m.equals("FIS")) {
			materia="FÍSICA";
		}
		if(m.equals("BIO")) {
			materia="BIOLOGIA";
		}
		if(m.equals("HIS")) {
			materia="HISTÓRIA";
		}
		if(m.equals("GEO")) {
			materia="GEOGRAFIA";
		}
		if(m.equals("PORT")) {
			materia="PORTUGUÊS";
		}
		if(m.equals("FILOS")) {
			materia="FILOSOFIA";
		}
		if(m.equals("ING")) {
			materia="INGLÊS";
		}
		if(m.equals("ESP")) {
			materia="ESPANHOL";
		}
		if(m.equals("LIT")) {
			materia="LITERATURA";
		}
		if(m.equals("SOCIO")) {
			materia="SOCIOLOGIA";
		}
		return materia;
	}
}
