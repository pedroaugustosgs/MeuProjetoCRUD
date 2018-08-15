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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class VisualizaAulaREC extends Login{

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

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		idAula = args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizaAulaREC window = new VisualizaAulaREC();
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
	public VisualizaAulaREC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 972, 658);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		
		panel = new JPanel();
		panel.setVisible(false);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(0, 88, 482, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(467, 88, 489, 22);
		frame.getContentPane().add(lblNewLabel_6);
		panel.setBounds(212, 121, 700, 190);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label_7 = new Label("Turno:");
		label_7.setBounds(8, 72, 51, 23);
		panel.add(label_7);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		
		chckbxManh = new JCheckBox("Manh\u00E3");
		chckbxManh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxManh.setSelected(true);
			}
		});
		chckbxManh.setEnabled(false);
		chckbxManh.setBounds(8, 101, 66, 23);
		panel.add(chckbxManh);
		
		chckbxTarde = new JCheckBox("Tarde");
		chckbxTarde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxTarde.setSelected(true);
			}
		});
		chckbxTarde.setEnabled(false);
		chckbxTarde.setBounds(8, 127, 58, 23);
		panel.add(chckbxTarde);
		
		chckbxNoite = new JCheckBox("Noite");
		chckbxNoite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxNoite.setSelected(true);
			}
		});
		chckbxNoite.setEnabled(false);
		chckbxNoite.setBounds(8, 153, 51, 23);
		panel.add(chckbxNoite);
		
		Label label_6 = new Label("Data:");
		label_6.setBounds(10, 10, 49, 24);
		panel.add(label_6);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		
		chSegunda = new JCheckBox("Segunda-Feira");
		chSegunda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chSegunda.setSelected(true);
			}
		});
		chSegunda.setEnabled(false);
		chSegunda.setBounds(7, 43, 104, 23);
		panel.add(chSegunda);
		
		chTerca = new JCheckBox("Ter\u00E7a-Feira");
		chTerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chTerca.setSelected(true);
			}
		});
		chTerca.setEnabled(false);
		chTerca.setBounds(129, 43, 86, 23);
		panel.add(chTerca);
		
		chQuartafeira = new JCheckBox("Quarta-Feira");
		chQuartafeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chQuartafeira.setSelected(true);
			}
		});
		chQuartafeira.setEnabled(false);
		chQuartafeira.setBounds(220, 43, 97, 23);
		panel.add(chQuartafeira);
		
		chQuintafeira = new JCheckBox("Quinta-Feira");
		chQuintafeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chQuintafeira.setSelected(true);
			}
		});
		chQuintafeira.setEnabled(false);
		chQuintafeira.setBounds(319, 43, 97, 23);
		panel.add(chQuintafeira);
		
		chSextafeira = new JCheckBox("Sexta-Feira");
		chSextafeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chSextafeira.setSelected(true);
			}
		});
		chSextafeira.setEnabled(false);
		chSextafeira.setBounds(418, 43, 97, 23);
		panel.add(chSextafeira);
		
		chSbado = new JCheckBox("S\u00E1bado");
		chSbado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chSbado.setSelected(true);
			}
		});
		chSbado.setEnabled(false);
		chSbado.setBounds(512, 43, 72, 23);
		panel.add(chSbado);
		
		chDomingo = new JCheckBox("Domingo");
		chDomingo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chDomingo.setSelected(true);
			}
		});
		chDomingo.setEnabled(false);
		chDomingo.setBounds(597, 43, 97, 23);
		panel.add(chDomingo);
		
		JLabel lblNewLabel = new JLabel("DE:");
		lblNewLabel.setVisible(false);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(80, 101, 40, 23);
		panel.add(lblNewLabel);
		
		JLabel lblAt = new JLabel("AT\u00C9:");
		lblAt.setVisible(false);
		lblAt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblAt.setBounds(186, 101, 40, 23);
		panel.add(lblAt);
		
		JLabel label_8 = new JLabel("DE:");
		label_8.setVisible(false);
		label_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_8.setBounds(72, 127, 40, 23);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("AT\u00C9:");
		label_9.setVisible(false);
		label_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_9.setBounds(186, 127, 40, 23);
		panel.add(label_9);
		
		JLabel lbldenoite = new JLabel("DE:");
		lbldenoite.setVisible(false);
		lbldenoite.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lbldenoite.setBounds(71, 153, 40, 23);
		panel.add(lbldenoite);
		
		JLabel label_11 = new JLabel("AT\u00C9:");
		label_11.setVisible(false);
		label_11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_11.setBounds(186, 153, 40, 23);
		panel.add(label_11);
		
		lbldemanha = new JLabel("");
		lbldemanha.setVisible(false);
		lbldemanha.setBounds(107, 101, 66, 23);
		panel.add(lbldemanha);
		
		lbldetarde = new JLabel("");
		lbldetarde.setVisible(false);
		lbldetarde.setBounds(117, 127, 66, 20);
		panel.add(lbldetarde);
		
		lblDeNoite = new JLabel("");
		lblDeNoite.setVisible(false);
		lblDeNoite.setBounds(107, 153, 66, 20);
		panel.add(lblDeNoite);
		
		lblatemanha = new JLabel("");
		lblatemanha.setVisible(false);
		lblatemanha.setBounds(233, 101, 72, 21);
		panel.add(lblatemanha);
		
		lblatetarde = new JLabel("");
		lblatetarde.setVisible(false);
		lblatetarde.setBounds(220, 127, 73, 21);
		panel.add(lblatetarde);
		
		lblatenoite = new JLabel("");
		lblatenoite.setVisible(false);
		lblatenoite.setBounds(231, 153, 74, 23);
		panel.add(lblatenoite);
		
		panel_1 = new JPanel();
		panel_1.setBounds(212, 124, 196, 109);
		frame.getContentPane().add(panel_1);
		panel_1.setVisible(false);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(10, 11, 56, 19);
		panel_1.add(lblNewLabel_1);
		
		lbldata = new JLabel("");
		lbldata.setBounds(78, 11, 86, 19);
		panel_1.add(lbldata);
		
		JLabel lblDe = new JLabel("DE:");
		lblDe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDe.setBounds(10, 39, 56, 19);
		panel_1.add(lblDe);
		
		JLabel lblAt_1 = new JLabel("AT\u00C9:");
		lblAt_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblAt_1.setBounds(10, 60, 56, 19);
		panel_1.add(lblAt_1);
		
		lbldedata = new JLabel("");
		lbldedata.setBounds(64, 36, 80, 19);
		panel_1.add(lbldedata);
		
		lblatedata = new JLabel("");
		lblatedata.setBounds(64, 59, 86, 19);
		panel_1.add(lblatedata);
		
		Label label = new Label("Mat\u00E9ria:");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label.setForeground(Color.WHITE);
		label.setBounds(10, 115, 58, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Professor:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_1.setBounds(10, 143, 66, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Conte\u00FAdo:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(10, 171, 66, 22);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("Local:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(10, 199, 49, 22);
		frame.getContentPane().add(label_3);
		
		Label label_4 = new Label("Vagas:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_4.setBounds(10, 227, 49, 22);
		frame.getContentPane().add(label_4);
		
		lblmateria = new JLabel("");
		lblmateria.setBounds(82, 70, 160, 22);
		frame.getContentPane().add(lblmateria);
		
		lblprofessor = new JLabel("");
		lblprofessor.setBounds(92, 94, 153, 22);
		frame.getContentPane().add(lblprofessor);
		
		lblconteudo = new JLabel("");
		lblconteudo.setBounds(92, 125, 168, 22);
		frame.getContentPane().add(lblconteudo);
		
		lbllocal = new JLabel("");
		lbllocal.setBounds(65, 153, 193, 22);
		frame.getContentPane().add(lbllocal);
		
		lblvagas = new JLabel("");
		lblvagas.setBounds(65, 183, 153, 19);
		frame.getContentPane().add(lblvagas);
		
		JButton btnNewButton = new JButton("Sair Da Aula");
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = JOptionPane.showConfirmDialog(null, "Você deseja mesmo sair desta aula?");
				if(r==0) {
					String sql="DELETE FROM alunosconfirmados WHERE idaluno=? and idConfirmar=?";
					try {
						PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
						stmt.setString(1, PlaAluno.idaluno);
						stmt.setString(2, idAula);
						stmt.execute();
						stmt.close();
						
						JOptionPane.showMessageDialog(null, "Você saiu desta aula!");
						PlaAluno.main(null);
						frame.dispose();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		});
		btnNewButton.setBounds(0, 576, 153, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNovoltar = new JButton("Voltar");
		btnNovoltar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNovoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerAula.main(null);
				frame.dispose();
			}
		});
		btnNovoltar.setBounds(796, 576, 160, 44);
		frame.getContentPane().add(btnNovoltar);
		
		tabela = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 322, 902, 213);
		frame.getContentPane().add(scrollPane);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(-13, 535, 489, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(467, 535, 306, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(762, 535, 194, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\VisualizarAula.png"));
		lblNewLabel_7.setBounds(310, 23, 461, 87);
		frame.getContentPane().add(lblNewLabel_7);
		
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

				lbldata.setText(dados.getString("DiaUmaVez"));
				lbldedata.setText(dados.getString("DeUmaVez"));
				lblatedata.setText(dados.getString("AteUmaVez"));
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
