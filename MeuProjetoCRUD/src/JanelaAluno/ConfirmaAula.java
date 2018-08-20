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

public class ConfirmaAula extends Login{

	private JFrame frame;
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
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
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
	public ConfirmaAula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1055, 634);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setVisible(false);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\chapeu.png"));
		lblNewLabel_9.setBounds(915, 21, 124, 81);
		frame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(0, 53, 455, 34);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(435, 53, 470, 34);
		frame.getContentPane().add(lblNewLabel_6);
		panel.setBounds(269, 98, 770, 180);
		frame.getContentPane().add(panel);
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
		chckbxTarde.setBounds(482, 40, 58, 23);
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
		chckbxNoite.setBounds(687, 40, 74, 23);
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
		chTerca.setBounds(10, 66, 86, 23);
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
		lblNewLabel.setBounds(251, 64, 40, 23);
		panel.add(lblNewLabel);
		
		JLabel lblAt = new JLabel("AT\u00C9:");
		lblAt.setForeground(Color.WHITE);
		lblAt.setVisible(false);
		lblAt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblAt.setBounds(241, 89, 40, 23);
		panel.add(lblAt);
		
		JLabel label_8 = new JLabel("DE:");
		label_8.setForeground(Color.WHITE);
		label_8.setVisible(false);
		label_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_8.setBounds(442, 70, 40, 23);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("AT\u00C9:");
		label_9.setForeground(Color.WHITE);
		label_9.setVisible(false);
		label_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_9.setBounds(429, 93, 40, 23);
		panel.add(label_9);
		
		JLabel lbldenoite = new JLabel("DE:");
		lbldenoite.setForeground(Color.WHITE);
		lbldenoite.setVisible(false);
		lbldenoite.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lbldenoite.setBounds(648, 70, 40, 23);
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
		lblDeNoite.setBounds(687, 69, 66, 20);
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
		lblatenoite.setBounds(687, 92, 74, 23);
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
		lblNewLabel_2.setBounds(-34, 513, 488, 52);
		frame.getContentPane().add(lblNewLabel_2);
		
		Label label = new Label("Mat\u00E9ria:");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label.setForeground(Color.WHITE);
		label.setBounds(10, 113, 58, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Professor:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_1.setBounds(10, 141, 66, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Conte\u00FAdo:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(10, 169, 66, 22);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("Local:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(10, 197, 49, 22);
		frame.getContentPane().add(label_3);
		
		Label label_4 = new Label("Vagas:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_4.setBounds(10, 225, 49, 22);
		frame.getContentPane().add(label_4);
		
		lblmateria = new JLabel("");
		lblmateria.setForeground(Color.WHITE);
		lblmateria.setBounds(75, 113, 114, 22);
		frame.getContentPane().add(lblmateria);
		
		lblprofessor = new JLabel("");
		lblprofessor.setForeground(Color.WHITE);
		lblprofessor.setBounds(85, 141, 137, 22);
		frame.getContentPane().add(lblprofessor);
		
		lblconteudo = new JLabel("");
		lblconteudo.setForeground(Color.WHITE);
		lblconteudo.setBounds(82, 169, 146, 22);
		frame.getContentPane().add(lblconteudo);
		
		lbllocal = new JLabel("");
		lbllocal.setForeground(Color.WHITE);
		lbllocal.setBounds(72, 197, 153, 22);
		frame.getContentPane().add(lbllocal);
		
		lblvagas = new JLabel("");
		lblvagas.setForeground(Color.WHITE);
		lblvagas.setBounds(65, 228, 153, 19);
		frame.getContentPane().add(lblvagas);
		
		JButton btnNewButton = new JButton("CONFIRMAR");
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
					JOptionPane.showMessageDialog(null, "Nova Aula Confirmada com Sucesso!");
					
					PlaAluno.main(null);
					frame.dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao confirmar nova aula!");
				}
				
			}

			private void ResultSet(ResultSet dados) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(1, 556, 164, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNovoltar = new JButton("VOLTAR");
		btnNovoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnNovoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerAula.main(null);
				frame.dispose();
			}
		});
		btnNovoltar.setBounds(874, 556, 164, 39);
		frame.getContentPane().add(btnNovoltar);
		
		tabela = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(258, 310, 498, 213);
		frame.getContentPane().add(scrollPane);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(435, 513, 488, 52);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(915, 513, 129, 52);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_7.setBounds(871, 58, 168, 24);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\Confirmaraula.png"));
		lblNewLabel_8.setBounds(363, 11, 330, 52);
		frame.getContentPane().add(lblNewLabel_8);
		
		panel_1 = new JPanel();
		panel_1.setBounds(231, 113, 168, 109);
		frame.getContentPane().add(panel_1);
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
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_10.setBounds(10, 288, 307, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_11.setBounds(302, 288, 488, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_12.setBounds(749, 288, 280, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
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
				lblmateria.setText(dados.getString("materia"));
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
}
