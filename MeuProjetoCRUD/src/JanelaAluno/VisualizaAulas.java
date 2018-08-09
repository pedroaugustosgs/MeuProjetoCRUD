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
import javax.swing.JFormattedTextField;
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

public class VisualizaAulas extends Login{

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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		idAula = args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizaAulas window = new VisualizaAulas();
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
	public VisualizaAulas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 958, 563);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		
		JLabel lblConfirmarAula = new JLabel("Confirmar Aula");
		lblConfirmarAula.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
		lblConfirmarAula.setBounds(232, 11, 196, 48);
		frame.getContentPane().add(lblConfirmarAula);
		
		Label label = new Label("Mat\u00E9ria:");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label.setForeground(Color.BLACK);
		label.setBounds(10, 69, 58, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Professor:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_1.setBounds(10, 97, 66, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Conte\u00FAdo:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(10, 125, 66, 22);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("Local:");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(10, 153, 49, 22);
		frame.getContentPane().add(label_3);
		
		Label label_4 = new Label("Vagas:");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		label_4.setBounds(10, 180, 49, 22);
		frame.getContentPane().add(label_4);
		
		lblmateria = new JLabel("");
		lblmateria.setBounds(82, 70, 140, 22);
		frame.getContentPane().add(lblmateria);
		
		lblprofessor = new JLabel("");
		lblprofessor.setBounds(92, 94, 130, 22);
		frame.getContentPane().add(lblprofessor);
		
		lblconteudo = new JLabel("");
		lblconteudo.setBounds(74, 125, 153, 22);
		frame.getContentPane().add(lblconteudo);
		
		lblvagas = new JLabel("");
		lblvagas.setBounds(65, 183, 153, 19);
		frame.getContentPane().add(lblvagas);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(panels);
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
				
				if(lblatetarde.isVisible()==false || lblatetarde.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de termino da aula");
					return;
				}
				String aTarde = lblatetarde.getText().toString();
				
				if(lbldemanha.isVisible()==false || lbldemanha.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de inicio da aula");
					return;
				}
				String dMAnha = lbldemanha.getText().toString();
				
				if(lblatemanha.isVisible()==false || lblatemanha.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de termino da aula");
					return;
				}
				String aManha = lblatemanha.getText().toString();
				
				if(lblDeNoite.isVisible()==false || lblDeNoite.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de inicio da aula");
					return;
				}
				String dNoite = lblDeNoite.getText().toString();
				
				if(lblatenoite.isVisible()==false || lblatenoite.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de termino da aula");
					return;
				}
				String aNoite = lblatenoite.getText().toString();
				
				if(lbldetarde.isVisible()==false || lbldetarde.getText().isEmpty() && panels==0) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de inicio da aula");
					return;
				}
				String dTarde = lbldetarde.getText().toString();
				
				if(lbldedata.getText().equals("  :  ") && panels==1) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de inicio da aula!");
					return;
				}
				String dData = lbldedata.getText().toString();
				
				if(lblatedata.getText().isEmpty() && panels==1) {
					JOptionPane.showMessageDialog(null, "Entre com o horario de termino da aula!");
					return;
				}
				
			
				String aData = lblatedata.getText().toString();
				
				String sql="UPDATE aulas SET DiaUmaVez=?, DeUmaVez =?, AteUmaVez=?, local=?, cedo=?, tarde=?, noite=?, DeManha=?, AteManha=?,"
						+ " DeTarde=?, AteTarde=?, DeNoite=?, AteNoite=?, segunda=?, terca=?, quarta=?, quinta=?, sexta=?, sabado=?, domingo=? "
						+ "WHERE idAula=?";
				
				try {
					PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
					stmt.setString(1, lbldata.getText().toString());
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
					
					PlaAluno.main(null);
					frame.dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(57, 493, 129, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNovoltar = new JButton("Voltar");
		btnNovoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlaAluno.main(null);
				frame.dispose();
			}
		});
		btnNovoltar.setBounds(778, 493, 123, 23);
		frame.getContentPane().add(btnNovoltar);
		
		tabela = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(242, 271, 502, 213);
		frame.getContentPane().add(scrollPane);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="DELETE FROM aulas WHERE idAula=?";
				
				int res = JOptionPane.showConfirmDialog(null, "Você deseja mesmo remover esta aula?");
				
				if(res==0) {
					try {
						PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
						stmt.setString(1, idAula);
						stmt.execute();
						stmt.close();
						JOptionPane.showMessageDialog(null, "Aula removida com sucesso!");
						frame.dispose();
						PlaAluno.main(null);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return;
			}
		});
		btnRemover.setBounds(432, 493, 89, 23);
		frame.getContentPane().add(btnRemover);
		
		lbllocal = new JTextField();
		lbllocal.setBounds(57, 153, 165, 20);
		frame.getContentPane().add(lbllocal);
		lbllocal.setColumns(10);
		
		try {
			DeAte = new MaskFormatter("##:##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		panel_1 = new JPanel();
		panel_1.setBounds(232, 70, 422, 190);
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
		lblAt_1.setBounds(10, 76, 56, 19);
		panel_1.add(lblAt_1);
		
		lbldedata = new JFormattedTextField(DeAte);
		lbldedata.setColumns(10);
		lbldedata.setBounds(64, 41, 72, 20);
		panel_1.add(lbldedata);
		
		lblatedata = new JFormattedTextField(DeAte);
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
		panel.setVisible(false);
		panel.setBounds(232, 70, 700, 190);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label_7 = new Label("Turno:");
		label_7.setBounds(8, 72, 51, 23);
		panel.add(label_7);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		
		chckbxManh = new JCheckBox("Manh\u00E3");
		chckbxManh.setSelected(true);
		chckbxManh.setEnabled(false);
		chckbxManh.setBounds(8, 101, 66, 23);
		panel.add(chckbxManh);
		
		chckbxTarde = new JCheckBox("Tarde");
		chckbxTarde.setEnabled(false);
		chckbxTarde.setBounds(8, 127, 58, 23);
		panel.add(chckbxTarde);
		
		chckbxNoite = new JCheckBox("Noite");
		chckbxNoite.setEnabled(false);
		chckbxNoite.setBounds(8, 153, 51, 23);
		panel.add(chckbxNoite);
		
		Label label_6 = new Label("Data:");
		label_6.setBounds(10, 10, 49, 24);
		panel.add(label_6);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		
		chSegunda = new JCheckBox("Segunda-Feira");
		chSegunda.setSelected(true);
		chSegunda.setEnabled(false);
		chSegunda.setBounds(7, 43, 104, 23);
		panel.add(chSegunda);
		
		chTerca = new JCheckBox("Ter\u00E7a-Feira");
		chTerca.setEnabled(false);
		chTerca.setBounds(129, 43, 86, 23);
		panel.add(chTerca);
		
		chQuartafeira = new JCheckBox("Quarta-Feira");
		chQuartafeira.setEnabled(false);
		chQuartafeira.setBounds(220, 43, 97, 23);
		panel.add(chQuartafeira);
		
		chQuintafeira = new JCheckBox("Quinta-Feira");
		chQuintafeira.setEnabled(false);
		chQuintafeira.setBounds(319, 43, 97, 23);
		panel.add(chQuintafeira);
		
		chSextafeira = new JCheckBox("Sexta-Feira");
		chSextafeira.setEnabled(false);
		chSextafeira.setBounds(418, 43, 97, 23);
		panel.add(chSextafeira);
		
		chSbado = new JCheckBox("S\u00E1bado");
		chSbado.setEnabled(false);
		chSbado.setBounds(512, 43, 72, 23);
		panel.add(chSbado);
		
		chDomingo = new JCheckBox("Domingo");
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
		
		lbldemanha = new JFormattedTextField(DeAte);
		lbldemanha.setVisible(false);
		lbldemanha.setBounds(107, 102, 72, 20);
		panel.add(lbldemanha);
		lbldemanha.setColumns(10);
		
		lbldetarde = new JFormattedTextField(DeAte);
		lbldetarde.setVisible(false);
		lbldetarde.setColumns(10);
		lbldetarde.setBounds(107, 128, 72, 20);
		panel.add(lbldetarde);
		
		lblDeNoite = new JFormattedTextField(DeAte);
		lblDeNoite.setVisible(false);
		lblDeNoite.setColumns(10);
		lblDeNoite.setBounds(94, 154, 72, 20);
		panel.add(lblDeNoite);
		
		lblatemanha = new JFormattedTextField(DeAte);
		lblatemanha.setVisible(false);
		lblatemanha.setColumns(10);
		lblatemanha.setBounds(221, 102, 72, 20);
		panel.add(lblatemanha);
		
		lblatetarde = new JFormattedTextField(DeAte);
		lblatetarde.setVisible(false);
		lblatetarde.setColumns(10);
		lblatetarde.setBounds(220, 128, 72, 20);
		panel.add(lblatetarde);
		
		lblatenoite = new JFormattedTextField(DeAte);
		lblatenoite.setVisible(false);
		lblatenoite.setColumns(10);
		lblatenoite.setBounds(221, 154, 72, 20);
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
