package Instituição;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import com.toedter.calendar.JCalendar;

import Banco.Conexao;
import CRUD.CRUDAlunos;
import CRUD.CRUDEmail;
import JanelaAluno.Login;
import JanelaAluno.ModeloDaTabela;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AlteraAulas extends Login{

	private JFrame frame;
	private static String idAula;
	private JLabel lblmateria;
	private JLabel lblprofessor;
	private JLabel lblconteudo;
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
	private JPanel panel_1;
	private JLabel lbldata;
	private JPanel panel;
	private int panels=1;
	private JTable tabela; 
	private JTextField lbllocal;
	private JTextField lbldemanha;
	private JTextField lbldetarde;
	private JTextField lblDeNoite;
	private JTextField lblatemanha;
	private JTextField lblatetarde;
	private JTextField lblatenoite;
	private JTextField lbldedata;
	private JTextField lblatedata;
	private JCalendar calendario;
	private MaskFormatter DeAte;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		idAula = args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlteraAulas window = new AlteraAulas();
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
	public AlteraAulas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1026, 639);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		
		Label label = new Label("Mat\u00E9ria:");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label.setForeground(Color.WHITE);
		label.setBounds(10, 131, 58, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Professor:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_1.setBounds(10, 159, 66, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Conte\u00FAdo:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(10, 187, 66, 22);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("Local:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(10, 215, 49, 22);
		frame.getContentPane().add(label_3);
		
		Label label_4 = new Label("Vagas:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_4.setBounds(10, 247, 49, 22);
		frame.getContentPane().add(label_4);
		
		lblmateria = new JLabel("");
		lblmateria.setForeground(Color.WHITE);
		lblmateria.setBounds(74, 131, 140, 22);
		frame.getContentPane().add(lblmateria);
		
		lblprofessor = new JLabel("");
		lblprofessor.setForeground(Color.WHITE);
		lblprofessor.setBounds(82, 159, 130, 22);
		frame.getContentPane().add(lblprofessor);
		
		lblconteudo = new JLabel("");
		lblconteudo.setForeground(Color.WHITE);
		lblconteudo.setBounds(82, 187, 140, 22);
		frame.getContentPane().add(lblconteudo);
		
		lblvagas = new JLabel("");
		lblvagas.setForeground(Color.WHITE);
		lblvagas.setBounds(61, 250, 161, 19);
		frame.getContentPane().add(lblvagas);
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(!(chSegunda.isSelected() || chTerca.isSelected() || chQuartafeira.isSelected() || chQuintafeira.isSelected() || chSextafeira.isSelected()
						|| chSbado.isSelected() || chDomingo.isSelected()) && panels==0) {
					JOptionPane.showMessageDialog(null, "Marque algum dia da semana para dar a aula!");
					return;
				}
				
				int seg=0;
				if(chSegunda.isSelected()) {
					seg=1;
				}
				int ter=0;
				if(chTerca.isSelected()) {
					ter=1;
				}
				int qua=0;
				if(chQuartafeira.isSelected()) {
					qua=1;
				}
				int qui=0;
				if(chQuintafeira.isSelected()) {
					qui=1;
				}
				int sex=0;
				if(chSextafeira.isSelected()) {
					sex=1;
				}
				int sab=0;
				if(chSbado.isSelected()) {
					sab=1;
				}
				int dom=0;
				if(chDomingo.isSelected()) {
					dom=1;
				}
				
				if(!(chckbxManh.isSelected() || chckbxTarde.isSelected() || chckbxNoite.isSelected()) && panels==0) {
					JOptionPane.showMessageDialog(null, "Marque um período do dia para dar a aula!");
					return;
				}
				int man=0;
				if(chckbxManh.isSelected()) {
					man=1;
				}
				int tar=0;
				if(chckbxTarde.isSelected()) {
					tar=1;
				}
				int noi=0;
				if(chckbxNoite.isSelected()) {
					noi=1;
				}
				
				if(lbllocal.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Entre com o local da aula!");
					return;
				}
				String loc = lbllocal.getText().toString();
				
				/*if(lblatetarde.isVisible()==false || lblatetarde.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de termino da aula");
					return;
				}*/
				String aTarde = lblatetarde.getText().toString();
				
			/*	if(lbldemanha.isVisible()==false || lbldemanha.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de inicio da aula");
					return;
				}*/
				String dMAnha = lbldemanha.getText().toString();
				
				/*if(lblatemanha.isVisible()==false || lblatemanha.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de termino da aula");
					return;
				}*/
				String aManha = lblatemanha.getText().toString();
				
				/*if(lblDeNoite.isVisible()==false || lblDeNoite.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de inicio da aula");
					return;
				}*/
				String dNoite = lblDeNoite.getText().toString();
				
				/*if(lblatenoite.isVisible()==false || lblatenoite.getText().isEmpty() && panels==0) {
				/	JOptionPane.showMessageDialog(null, "Entre com o horario de termino da aula");
					return;
				}*/
				String aNoite = lblatenoite.getText().toString();
				
				/*if(lbldetarde.isVisible()==false || lbldetarde.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de inicio da aula");
					return;
				}*/
				String dTarde = lbldetarde.getText().toString();
				
				/*if(lbldedata.getText().equals("  :  ") && panels==1) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de inicio da aula!");
					return;
				}*/
				String dData = lbldedata.getText().toString();
				
				/*if(lblatedata.getText().equals("  :  ") && panels==1) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de termino da aula!");
					return;
				}*/
				
				Date data = calendario.getDate();
				SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
				String dataS = s.format(data);
				
				String aData = lblatedata.getText().toString();
				
				String sql="UPDATE aulas SET DiaUmaVez=?, DeUmaVez =?, AteUmaVez=?, local=?, cedo=?, tarde=?, noite=?, DeManha=?, AteManha=?,"
						+ " DeTarde=?, AteTarde=?, DeNoite=?, AteNoite=?, segunda=?, terca=?, quarta=?, quinta=?, sexta=?, sabado=?, domingo=? "
						+ "WHERE idAula=?";
				
				try {
					PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
					stmt.setString(1, dataS);
					stmt.setString(2, dData);
					stmt.setString(3, aData);
					stmt.setString(4, loc);
					stmt.setInt(5, man);
					stmt.setInt(6, tar);
					stmt.setInt(7, noi);
					stmt.setString(8, dMAnha);
					stmt.setString(9, aManha);
					stmt.setString(10, dTarde);
					stmt.setString(11, aTarde);
					stmt.setString(12, dNoite);
					stmt.setString(13, aNoite);
					stmt.setInt(14, seg);
					stmt.setInt(15, ter);
					stmt.setInt(16, qua);
					stmt.setInt(17, qui);
					stmt.setInt(18, sex);
					stmt.setInt(19, sab);
					stmt.setInt(20, dom);
					stmt.setString(21, idAula);
					stmt.execute();
					stmt.close();
					
					
					JOptionPane.showMessageDialog(null, "Aula atualizada com sucesso!");
					
					//*****************************   FAZER O ENVIAR EMAIL E COLOCAR AQUI *******************//
				 
					ResultSet dados=null;
					String sql1="SELECT * FROM aulas WHERE idaula=?";  //pega dados da aula
					PreparedStatement stmt1 = Conexao.conexao.prepareStatement(sql1);
					stmt1.setString(1, idAula);
					dados = stmt1.executeQuery();
					stmt1.execute();
					stmt1.close();
					
					ResultSet dado = null;
					String sql2="SELECT * FROM alunos INNER JOIN alunosconfirmados ON Alunos.idAluno = alunosconfirmados.idaluno WHERE idconfirmar=?";
					PreparedStatement stmt2 = Conexao.conexao.prepareStatement(sql2);
					stmt2.setString(1, idAula);   // pega dados do aluno
					dado = stmt2.executeQuery();
					stmt2.execute();
					stmt2.close();
					
					dados.first();
					
					
					String msg="Sua aula com o professor "+NomeProf(idAula)+" de "+Materia(dados.getString("materia"))+" sobre "+dados.getString("conteudo")
							+ " sofreu uma alteração pela sua intituição! "
							+ "Acesse o Approfe para mais informações!";
					
					if(dado !=null) {
						CRUDEmail enviar = new CRUDEmail();
						while(dado.next()) {
							enviar.EmailVisuAulas(dado.getString("email"),msg);
						}
					}
					
					
					VerAulas.main(null);
					frame.dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(2, 561, 164, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNovoltar = new JButton("VOLTAR");
		btnNovoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnNovoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerAulas.main(null);
				frame.dispose();
			}
		});
		btnNovoltar.setBounds(845, 561, 164, 39);
		frame.getContentPane().add(btnNovoltar);
		
		tabela = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(189, 315, 502, 213);
		frame.getContentPane().add(scrollPane);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="DELETE FROM aulas WHERE idAula=?";
				
				
				String motivo = JOptionPane.showInputDialog("Insira o motivo da remoção da aula!");
				
					try {
						PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
						stmt.setString(1, idAula);
						stmt.execute();
						stmt.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					ResultSet dados3=null;
					ResultSet dados2=null;
					ResultSet dados =null;
					
					String sql3="SELECT * FROM alunos INNER JOIN alunosconfirmados ON Alunos.idAluno = alunosconfirmados.idaluno WHERE idconfirmar=?";
					String sql1 ="SELECT * FROM alunos INNNER J0IN aulas ON alunos.idaluno = aulas.professor WHERE idaula=?";
					try {
						PreparedStatement stmt3 = Conexao.conexao.prepareStatement(sql3);
						stmt3.setString(1, idAula);
						dados3 = stmt3.executeQuery();
						stmt3.execute();
						stmt3.close();
						
						
						PreparedStatement stmt = Conexao.conexao.prepareStatement(sql1);
						stmt.setString(1, idAula);
						dados = stmt.executeQuery();
						stmt.execute();
						stmt.close();
						
						
						String sql2 = "SELECT * FROM aulas WHERE idAula=?";
						PreparedStatement s = Conexao.conexao.prepareStatement(sql2);
						s.setString(1, idAula);
						dados2 = s.executeQuery();
						s.execute();
						s.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String msgprof=null;
					String msgalu=null;
					try {
						 msgprof= "Sua aula de "+Materia(dados2.getString("materia"))+" sobre "+dados2.getString("conteudo")+" foi removida "
						 		+ "por sua escola! "
								+ "Motivos:"+motivo;
						 CRUDEmail d= new CRUDEmail();
							d.EmailVisuAulas(dados.getString("email"), msgprof);
							
							
						msgalu	= "Sua aula de "+Materia(dados2.getString("materia"))+" sobre "+dados2.getString("conteudo")+" com o "
								+ "professor "+NomeProf(idAula)+" foi removida "
						 		+ "pela escola dele! "
								+ "Motivos:"+motivo;
						
						while(dados3.next()) {
							d.EmailVisuAulas(dados3.getString("email"), msgalu);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					JOptionPane.showMessageDialog(null, "Aula removida com sucesso!");
					frame.dispose();
					VerAulas.main(null);
				
				return;
			}
		});
		btnRemover.setBounds(425, 561, 164, 39);
		frame.getContentPane().add(btnRemover);
		
		lbllocal = new JTextField();
		lbllocal.setBackground(Color.BLACK);
		lbllocal.setForeground(Color.WHITE);
		lbllocal.setBounds(65, 215, 165, 20);
		frame.getContentPane().add(lbllocal);
		lbllocal.setColumns(10);
		
		try {
			DeAte = new MaskFormatter("##:##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Lupa.png"));
		lblNewLabel_5.setBounds(859, 360, 233, 168);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(0, 527, 486, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(480, 531, 486, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(936, 530, 78, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(0, 82, 320, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_7.setBounds(302, 82, 495, 24);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_8.setBounds(784, 82, 229, 25);
		frame.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(566, 45, 46, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\Imagem\\img\\alt.jpg"));
		lblNewLabel_10.setBounds(259, 11, 509, 71);
		frame.getContentPane().add(lblNewLabel_10);
		
		panel_1 = new JPanel();
		panel_1.setBounds(240, 119, 422, 192);
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
		lblAt_1.setBounds(10, 76, 56, 19);
		panel_1.add(lblAt_1);
		
		lbldedata = new JFormattedTextField(DeAte);
		lbldedata.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String  deumavez = lbldedata.getText().toString();
				String hora[] = new String[2];
				hora = deumavez.split(":");
				int h = Integer.parseInt(hora[0]);
				int m = Integer.parseInt(hora[1]);
				if(h>23 || m>59) {
					JOptionPane.showMessageDialog(null, "Entre com um horário válido");
					lbldedata.requestFocus();
					lbldedata.selectAll();
					
				}
			}
		});
		lbldedata.setBackground(Color.BLACK);
		lbldedata.setForeground(Color.WHITE);
		lbldedata.setColumns(10);
		lbldedata.setBounds(64, 41, 72, 20);
		panel_1.add(lbldedata);
		
		lblatedata = new JFormattedTextField(DeAte);
		lblatedata.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String  deumavez = lblatedata.getText().toString();
				String hora[] = new String[2];
				hora = deumavez.split(":");
				int h = Integer.parseInt(hora[0]);
				int m = Integer.parseInt(hora[1]);
				if(h>23 || m>59) {
					JOptionPane.showMessageDialog(null, "Entre com um horário válido");
					lblatedata.requestFocus();
					lblatedata.selectAll();
					
				}
			}
		});
		lblatedata.setBackground(Color.BLACK);
		lblatedata.setForeground(Color.WHITE);
		lblatedata.setColumns(10);
		lblatedata.setBounds(64, 77, 72, 20);
		panel_1.add(lblatedata);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(calendario.isVisible()) {
					calendario.setVisible(false);
				}else {
					calendario.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(174, 11, 42, 23);
		panel_1.add(btnNewButton_1);
		
		calendario = new JCalendar();
		calendario.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				Date hoje = new Date();
				
				Date entrada = new Date();
				entrada = calendario.getDate();
				
				if(entrada.after(hoje) || entrada.getDate() == hoje.getDate()) {
					SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
					String umaVez = s.format(calendario.getDate());
					lbldata.setText(umaVez);
				}else {
					JOptionPane.showMessageDialog(null, "A data escolhida deve ser superior ou igual a data de hoje!","Data Inválida",JOptionPane.ERROR_MESSAGE);
					calendario.setDate(hoje);
				}
			}
		});
		calendario.setVisible(false);
		calendario.setBounds(226, 11, 191, 153);
		panel_1.add(calendario);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setVisible(false);
		panel.setBounds(232, 113, 700, 189);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label_7 = new Label("Turno:");
		label_7.setBounds(277, 10, 66, 23);
		panel.add(label_7);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		chckbxManh = new JCheckBox("Manh\u00E3");
		chckbxManh.setBackground(Color.BLACK);
		chckbxManh.setForeground(Color.WHITE);
		chckbxManh.setEnabled(false);
		chckbxManh.setBounds(277, 43, 66, 23);
		panel.add(chckbxManh);
		
		chckbxTarde = new JCheckBox("Tarde");
		chckbxTarde.setBackground(Color.BLACK);
		chckbxTarde.setForeground(Color.WHITE);
		chckbxTarde.setEnabled(false);
		chckbxTarde.setBounds(277, 69, 58, 23);
		panel.add(chckbxTarde);
		
		chckbxNoite = new JCheckBox("Noite");
		chckbxNoite.setBackground(Color.BLACK);
		chckbxNoite.setForeground(Color.WHITE);
		chckbxNoite.setEnabled(false);
		chckbxNoite.setBounds(277, 95, 51, 23);
		panel.add(chckbxNoite);
		
		Label label_6 = new Label("Data:");
		label_6.setBounds(10, 10, 49, 24);
		panel.add(label_6);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		chSegunda = new JCheckBox("Segunda-Feira");
		chSegunda.setBackground(Color.BLACK);
		chSegunda.setForeground(Color.WHITE);
		chSegunda.setEnabled(false);
		chSegunda.setBounds(7, 43, 119, 23);
		panel.add(chSegunda);
		
		chTerca = new JCheckBox("Ter\u00E7a-Feira");
		chTerca.setBackground(Color.BLACK);
		chTerca.setForeground(Color.WHITE);
		chTerca.setEnabled(false);
		chTerca.setBounds(7, 72, 86, 23);
		panel.add(chTerca);
		
		chQuartafeira = new JCheckBox("Quarta-Feira");
		chQuartafeira.setBackground(Color.BLACK);
		chQuartafeira.setForeground(Color.WHITE);
		chQuartafeira.setEnabled(false);
		chQuartafeira.setBounds(8, 101, 97, 23);
		panel.add(chQuartafeira);
		
		chQuintafeira = new JCheckBox("Quinta-Feira");
		chQuintafeira.setBackground(Color.BLACK);
		chQuintafeira.setForeground(Color.WHITE);
		chQuintafeira.setEnabled(false);
		chQuintafeira.setBounds(10, 127, 97, 23);
		panel.add(chQuintafeira);
		
		chSextafeira = new JCheckBox("Sexta-Feira");
		chSextafeira.setBackground(Color.BLACK);
		chSextafeira.setForeground(Color.WHITE);
		chSextafeira.setEnabled(false);
		chSextafeira.setBounds(10, 153, 97, 23);
		panel.add(chSextafeira);
		
		chSbado = new JCheckBox("S\u00E1bado");
		chSbado.setBackground(Color.BLACK);
		chSbado.setForeground(Color.WHITE);
		chSbado.setEnabled(false);
		chSbado.setBounds(128, 43, 86, 23);
		panel.add(chSbado);
		
		chDomingo = new JCheckBox("Domingo");
		chDomingo.setForeground(Color.WHITE);
		chDomingo.setBackground(Color.BLACK);
		chDomingo.setEnabled(false);
		chDomingo.setBounds(128, 72, 97, 23);
		panel.add(chDomingo);
		
		JLabel lblNewLabel = new JLabel("DE:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setVisible(false);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(354, 43, 40, 23);
		panel.add(lblNewLabel);
		
		JLabel lblAt = new JLabel("AT\u00C9:");
		lblAt.setForeground(Color.WHITE);
		lblAt.setVisible(false);
		lblAt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblAt.setBounds(484, 43, 40, 23);
		panel.add(lblAt);
		
		JLabel label_8 = new JLabel("DE:");
		label_8.setForeground(Color.WHITE);
		label_8.setVisible(false);
		label_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_8.setBounds(354, 69, 40, 23);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("AT\u00C9:");
		label_9.setForeground(Color.WHITE);
		label_9.setVisible(false);
		label_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_9.setBounds(484, 69, 40, 23);
		panel.add(label_9);
		
		JLabel lbldenoite = new JLabel("DE:");
		lbldenoite.setForeground(Color.WHITE);
		lbldenoite.setVisible(false);
		lbldenoite.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lbldenoite.setBounds(354, 95, 40, 23);
		panel.add(lbldenoite);
		
		JLabel label_11 = new JLabel("AT\u00C9:");
		label_11.setForeground(Color.WHITE);
		label_11.setVisible(false);
		label_11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_11.setBounds(484, 95, 40, 23);
		panel.add(label_11);
		
		lbldemanha = new JFormattedTextField(DeAte);
		lbldemanha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String  deumavez = lbldemanha.getText().toString();
				String hora[] = new String[2];
				hora = deumavez.split(":");
				int h = Integer.parseInt(hora[0]);
				int m = Integer.parseInt(hora[1]);
				if(h>23 || m>59) {
					JOptionPane.showMessageDialog(null, "Entre com um horário válido");
					lbldemanha.requestFocus();
					lbldemanha.selectAll();
					
				}
			}
		});
		lbldemanha.setForeground(Color.WHITE);
		lbldemanha.setBackground(Color.BLACK);
		lbldemanha.setVisible(false);
		lbldemanha.setBounds(393, 44, 72, 20);
		panel.add(lbldemanha);
		lbldemanha.setColumns(10);
		
		lbldetarde = new JFormattedTextField(DeAte);
		lbldetarde.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String  deumavez = lbldetarde.getText().toString();
				String hora[] = new String[2];
				hora = deumavez.split(":");
				int h = Integer.parseInt(hora[0]);
				int m = Integer.parseInt(hora[1]);
				if(h>23 || m>59) {
					JOptionPane.showMessageDialog(null, "Entre com um horário válido");
					lbldetarde.requestFocus();
					lbldetarde.selectAll();
					
				}
			}
		});
		lbldetarde.setBackground(Color.BLACK);
		lbldetarde.setForeground(Color.WHITE);
		lbldetarde.setVisible(false);
		lbldetarde.setColumns(10);
		lbldetarde.setBounds(393, 70, 72, 20);
		panel.add(lbldetarde);
		
		lblDeNoite = new JFormattedTextField(DeAte);
		lblDeNoite.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String  deumavez = lblDeNoite.getText().toString();
				String hora[] = new String[2];
				hora = deumavez.split(":");
				int h = Integer.parseInt(hora[0]);
				int m = Integer.parseInt(hora[1]);
				if(h>23 || m>59) {
					JOptionPane.showMessageDialog(null, "Entre com um horário válido");
					lblDeNoite.requestFocus();
					lblDeNoite.selectAll();
					
				}
			}
		});
		lblDeNoite.setBackground(Color.BLACK);
		lblDeNoite.setForeground(Color.WHITE);
		lblDeNoite.setVisible(false);
		lblDeNoite.setColumns(10);
		lblDeNoite.setBounds(393, 96, 72, 20);
		panel.add(lblDeNoite);
		
		lblatemanha = new JFormattedTextField(DeAte);
		lblatemanha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String  deumavez = lblatemanha.getText().toString();
				String hora[] = new String[2];
				hora = deumavez.split(":");
				int h = Integer.parseInt(hora[0]);
				int m = Integer.parseInt(hora[1]);
				if(h>23 || m>59) {
					JOptionPane.showMessageDialog(null, "Entre com um horário válido");
					lblatemanha.requestFocus();
					lblatemanha.selectAll();
					
				}
			}
		});
		lblatemanha.setForeground(Color.WHITE);
		lblatemanha.setBackground(Color.BLACK);
		lblatemanha.setVisible(false);
		lblatemanha.setColumns(10);
		lblatemanha.setBounds(523, 44, 72, 20);
		panel.add(lblatemanha);
		
		lblatetarde = new JFormattedTextField(DeAte);
		lblatetarde.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String  deumavez = lblatetarde.getText().toString();
				String hora[] = new String[2];
				hora = deumavez.split(":");
				int h = Integer.parseInt(hora[0]);
				int m = Integer.parseInt(hora[1]);
				if(h>23 || m>59) {
					JOptionPane.showMessageDialog(null, "Entre com um horário válido");
					lblatetarde.requestFocus();
					lblatetarde.selectAll();
					
				}
			}
		});
		lblatetarde.setBackground(Color.BLACK);
		lblatetarde.setForeground(Color.WHITE);
		lblatetarde.setVisible(false);
		lblatetarde.setColumns(10);
		lblatetarde.setBounds(523, 70, 72, 20);
		panel.add(lblatetarde);
		
		lblatenoite = new JFormattedTextField(DeAte);
		lblatenoite.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String  deumavez = lblatenoite.getText().toString();
				String hora[] = new String[2];
				hora = deumavez.split(":");
				int h = Integer.parseInt(hora[0]);
				int m = Integer.parseInt(hora[1]);
				if(h>23 || m>59) {
					JOptionPane.showMessageDialog(null, "Entre com um horário válido");
					lblatenoite.requestFocus();
					lblatenoite.selectAll();
					
				}
			}
		});
		lblatenoite.setForeground(Color.WHITE);
		lblatenoite.setBackground(Color.BLACK);
		lblatenoite.setVisible(false);
		lblatenoite.setColumns(10);
		lblatenoite.setBounds(523, 96, 72, 20);
		panel.add(lblatenoite);
		
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
							dados.getString("escola"),
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
				}else {
					chSegunda.setSelected(false);
				}
				if(dados.getString("terca").equals("1")) {
					chTerca.setSelected(true);
					panels = 0;
					chTerca.setEnabled(true);
				}else {
					chTerca.setSelected(false);
				}
				if(dados.getString("quarta").equals("1")) {
					chQuartafeira.setSelected(true);
					panels=0;
					chQuartafeira.setEnabled(true);
				}else {
					chQuartafeira.setSelected(false);
				}
				if(dados.getString("quinta").equals("1")) {
					chQuintafeira.setSelected(true);
					panels=0;
					chQuintafeira.setEnabled(true);
				}else {
					chQuintafeira.setSelected(false);
				}
				if(dados.getString("sexta").equals("1")) {
					chSextafeira.setSelected(true);
					panels=0;
					chSextafeira.setEnabled(true);
				}else {
					chSextafeira.setSelected(false);
				}
				if(dados.getString("sabado").equals("1")) {
					chSbado.setSelected(true);
					panels=0;
					chSbado.setEnabled(true);
				}else {
					chSbado.setSelected(false);
				}
				if(dados.getString("domingo").equals("1")) {
					chDomingo.setSelected(true);
					panels=0;
					chDomingo.setEnabled(true);
				}else {
					chDomingo.setSelected(false);
				}
				if(dados.getString("cedo").equals("1")) {
					chckbxManh.setSelected(true);
					chckbxManh.setEnabled(true);
				}else {
					chckbxManh.setSelected(false);
				}
				if(dados.getString("tarde").equals("1")) {
					chckbxTarde.setSelected(true);
					chckbxTarde.setEnabled(true);
				}else {
					chckbxTarde.setSelected(false);
				}
				if(dados.getString("noite").equals("1")) {
					chckbxNoite.setSelected(true);
					chckbxNoite.setEnabled(true);
				}else {
					chckbxNoite.setSelected(false);
				}
				lbldemanha.setText(dados.getString("deManha"));
				lblatemanha.setText(dados.getString("ateManha"));
				lbldetarde.setText(dados.getString("deTarde"));
				lblatetarde.setText(dados.getString("ateTarde"));
				lblDeNoite.setText(dados.getString("deNoite"));
				lblatenoite.setText(dados.getString("ateNoite"));
				
				if(Integer.parseInt(dados.getString("periodico"))==0) {
						try {
							lbldata.setText(dados.getString("DiaUmaVez"));
							Date data = new Date();
							String dataS= dados.getString("DiaUmaVez");
							SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
							try {
								data = s.parse(dataS);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								
							calendario.setDate(data);
						} catch (Exception e1) {
							lbldata.setText("0000-00-00");
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
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
