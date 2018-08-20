package JanelaAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import CRUD.CRUDAulas;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JCalendar;

import Banco.Conexao;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Color;

public class NovaAula extends Login {

	private JFrame frame;
	private JTextField tfConteudo;
	private JTextField tfLocal;
	private JComboBox<String> cbMaterias;
	private JCheckBox chSegunda;
	private JCheckBox chTerca;
	private JCheckBox chQuarta;
	private JCheckBox chQuinta;
	private JCheckBox chSexta;
	private JCheckBox chSabado;
	private JCheckBox chDomingo;
	private JCheckBox chManha;
	private JCheckBox chTarde;
	private JCheckBox chNoite;
	ResultSet dados;
	private JTextField tfVagas;
	private JTextField tfDeManha;
	private JTextField tfAteManha;
	private JTextField tfDeTarde;
	private JTextField tfAteTarde;
	private JTextField tfDeNoite;
	private JTextField tfAteNoite;
	private JLabel label;
	private JLabel label_3;
	private JTextField tfDeUmaVez;
	private JTextField tfAteUmaVez;
	private JLabel lblData;
	private JLabel lblTurno;
	private JPanel panel;
	private JPanel panel_1;
	private MaskFormatter DeAte;
	String DeManha;
	String AteManha;
	String DeTarde;
	String AteTarde;
	String DeNoite;
	String AteNoite;
	private JRadioButton rdbtnUmaVez;
	private JRadioButton rdbtnPeridico;
	private JCalendar calendario;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_5;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel lblNewLabel_7;
	private JLabel label_6;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel label_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaAula window = new NovaAula();
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
	public NovaAula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 955, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		try {
			DeAte = new MaskFormatter("##:##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnCriarAula = new JButton("Criar Aula");
		btnCriarAula.setBackground(Color.LIGHT_GRAY);
		btnCriarAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String disciplina=null;
				
				if(cbMaterias.getSelectedItem().equals("Matem�tica")) {
					disciplina= "MAT";
				}
				if(cbMaterias.getSelectedItem().equals("Biologia")) {
					disciplina= "BIO";
				}
				if(cbMaterias.getSelectedItem().equals("F�sica")) {
					disciplina="FIS";
				}
				if(cbMaterias.getSelectedItem().equals("Portugu�s")) {
					disciplina= "PORT";
				}
				if(cbMaterias.getSelectedItem().equals("Qu�mica")) {
					disciplina= "QUI";
				}
				if(cbMaterias.getSelectedItem().equals("Hist�ria")) {
					disciplina= "HIS";
				}
				if(cbMaterias.getSelectedItem().equals("Geografia")) {
					disciplina= "GEO";
				}
				if(cbMaterias.getSelectedItem().equals("Reda��o")) {
					disciplina= "RED";
				}
				if(cbMaterias.getSelectedItem().equals("Literatura")) {
					disciplina= "LIT";
				}
				if(cbMaterias.getSelectedItem().equals("Ingl�s")) {
					disciplina= "ING";
				}
				if(cbMaterias.getSelectedItem().equals("Sociologia")) {
					disciplina= "SOCIO";
				}
				if(cbMaterias.getSelectedItem().equals("Espanhol")) {
					disciplina= "ESP";
				}
				if(cbMaterias.getSelectedItem().equals("Filosofia")) {
					disciplina= "FILOS";
				}
				
				if(!(chSegunda.isSelected() || chTerca.isSelected() || chQuarta.isSelected() || chQuinta.isSelected() || chSexta.isSelected()
						|| chSabado.isSelected() || chDomingo.isSelected()) && rdbtnPeridico.isSelected()) {
					JOptionPane.showMessageDialog(null, "Marque algum dia da semana para dar a aula!");
					return;
				}
				
				if(!(chManha.isSelected() || chTarde.isSelected() || chNoite.isSelected()) && rdbtnPeridico.isSelected()) {
					JOptionPane.showMessageDialog(null, "Marque um per�odo do dia para dar a aula!");
					return;
				}
				
				String conteudo;
				if(!tfConteudo.getText().toString().isEmpty()) {
					conteudo = tfConteudo.getText().toString();
				}else {
					JOptionPane.showMessageDialog(null, "Insira um conte�do!");
					return;
				}
				
				int segunda=0,terca=0,quarta=0,quinta=0,sexta=0,sabado=0,domingo=0,manha=0,tarde=0,noite=0;
				if(chSegunda.isSelected()) {
					segunda=1;
				}
				if(chTerca.isSelected()) {
					terca=1;
				}
				if(chQuarta.isSelected()) {
					quarta=1;
				}
				if(chQuinta.isSelected()) {
					quinta=1;
				}
				if(chSexta.isSelected()) {
					sexta=1;
				}
				if(chSabado.isSelected()) {
					sabado=1;
				}
				if(chDomingo.isSelected()) {
					domingo=1;
				}
				if(chManha.isSelected()) {
					manha=1;
				}
				if(chTarde.isSelected()) {
					tarde=1;
				}
				if(chNoite.isSelected()) {
					noite=1;
				}
				String local = null;
				if(!tfLocal.getText().toString().isEmpty()) {
					local = tfLocal.getText().toString();
				}else {
					JOptionPane.showMessageDialog(null, "Insira um local v�lido!");
					return;
				}
				
				int prof=0;
				String sql="SELECT * FROM alunos WHERE idaluno=?";
				try {
					PreparedStatement stmt = Banco.Conexao.conexao.prepareStatement(sql);
					stmt.setString(1, PlaAluno.idaluno);
					dados = stmt.executeQuery();
					stmt.execute();
					stmt.close();
					if(dados.next()) {
						prof = Integer.parseInt(dados.getString("idaluno"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int vagas;
				if(!tfVagas.getText().isEmpty()) {
					vagas = Integer.parseInt(tfVagas.getText());
				}else {
					JOptionPane.showMessageDialog(null, "Insira um total de vagas");
					return;
				}
				
				CRUDAulas novaAula = new CRUDAulas();
				if(chManha.isSelected()) {
					DeManha = tfDeManha.getText();
					AteManha = tfAteManha.getText();
				}
				if(chTarde.isSelected()) {
					DeTarde = tfDeTarde.getText();
				}
				if(chTarde.isSelected()) {
					AteTarde = tfAteTarde.getText();
				}
				if(chNoite.isSelected()) {
					DeNoite = tfDeNoite.getText();
				}
				if(chNoite.isSelected()) {
					AteNoite = tfAteNoite.getText();
				} 
				int peri;
				if(rdbtnPeridico.isSelected()) {
					peri=1;
			
				}else {
					peri=0;
				}
				//SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				//String umaVez = s.format(calendario.getDate());
				Date data = null;
				if(rdbtnUmaVez.isSelected()) {
					data = calendario.getDate();
				}
				System.out.println(data);
				if(novaAula.novaAula(disciplina, conteudo, segunda, terca, quarta, quinta, sexta, sabado, domingo, manha, tarde, noite, local, prof,vagas,DeManha,AteManha,
						DeTarde,AteTarde,DeNoite,AteNoite,data,tfDeUmaVez.getText(),tfAteUmaVez.getText(),peri)) {
					JOptionPane.showMessageDialog(null, "Nova aula cadastrada com sucesso!");
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar nova aula!");
				}
				chSegunda.setSelected(false);
				chTarde.setSelected(false);
				chTerca.setSelected(false);
				chQuarta.setSelected(false);
				chQuinta.setSelected(false);
				chSexta.setSelected(false);
				chSabado.setSelected(false);
				chDomingo.setSelected(false);
				chManha.setSelected(false);
				chNoite.setSelected(false);
				tfConteudo.setText(null);
				tfLocal.setText(null);
				tfVagas.setText(null);
				tfDeUmaVez.setText(null);
				tfAteUmaVez.setText(null);
			}
		
			
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaAluno.main(null);
				frame.dispose();
			}
		});
		
		JButton btnRecomendaesDeAulas = new JButton("Recomenda\u00E7\u00F5es De Aulas");
		btnRecomendaesDeAulas.setBackground(Color.LIGHT_GRAY);
		btnRecomendaesDeAulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AulasSolicitadas.main(null);
				frame.dispose();
				
			}
		});
		
		rdbtnUmaVez = new JRadioButton("Uma vez");
		rdbtnUmaVez.setBackground(Color.BLACK);
		rdbtnUmaVez.setForeground(Color.WHITE);
		rdbtnUmaVez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);	
				tfDeUmaVez.setEnabled(true);
				tfAteUmaVez.setEnabled(true);
			}
		});
		
		label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		label_7.setBounds(464, 166, 485, 6);
		frame.getContentPane().add(label_7);
		
		panel_1 = new JPanel();
		panel_1.setBounds(5, 166, 929, 197);
		frame.getContentPane().add(panel_1);
		panel_1.setBackground(Color.BLACK);
		panel_1.setVisible(false);
		panel_1.setLayout(null);
		
		JLabel lblDe_1 = new JLabel("DE:");
		lblDe_1.setForeground(Color.WHITE);
		lblDe_1.setBounds(4, 13, 46, 20);
		panel_1.add(lblDe_1);
		lblDe_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		tfDeUmaVez = new JFormattedTextField(DeAte);
		tfDeUmaVez.setBounds(48, 14, 125, 20);
		panel_1.add(tfDeUmaVez);
		tfDeUmaVez.setColumns(10);
		
		JLabel lblAt_1 = new JLabel("AT\u00C9:");
		lblAt_1.setForeground(Color.WHITE);
		lblAt_1.setBounds(4, 44, 46, 20);
		panel_1.add(lblAt_1);
		lblAt_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		tfAteUmaVez = new JFormattedTextField(DeAte);
		tfAteUmaVez.setBounds(48, 47, 124, 20);
		panel_1.add(tfAteUmaVez);
		tfAteUmaVez.setColumns(10);
		
		calendario = new JCalendar();
		calendario.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				Date hoje = new Date();
				
				Date entrada = new Date();
				entrada = calendario.getDate();
				
				if(entrada.after(hoje) || entrada.getDate() == hoje.getDate()) {
					
				}else {
					JOptionPane.showMessageDialog(null, "A data escolhida deve ser superior ou igual a data de hoje!","Data Inv�lida",JOptionPane.ERROR_MESSAGE);
					calendario.setDate(hoje);
				}
			}
		});
		calendario.setBounds(278, 10, 191, 153);
		panel_1.add(calendario);
		
		JLabel lblData_1 = new JLabel("DATA:");
		lblData_1.setForeground(Color.WHITE);
		lblData_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblData_1.setBounds(200, 11, 70, 20);
		panel_1.add(lblData_1);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(-12, 0, 492, 6);
		panel_1.add(lblNewLabel_9);
		lblNewLabel_9.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		rdbtnUmaVez.setBounds(167, 116, 109, 23);
		frame.getContentPane().add(rdbtnUmaVez);
		
		rdbtnPeridico = new JRadioButton("Peri\u00F3dico");
		rdbtnPeridico.setBackground(Color.BLACK);
		rdbtnPeridico.setForeground(Color.WHITE);
		rdbtnPeridico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				tfDeUmaVez.setEnabled(false);
				tfAteUmaVez.setEnabled(false);
			}
		});
		rdbtnPeridico.setSelected(true);
		rdbtnPeridico.setBounds(34, 116, 109, 23);
		frame.getContentPane().add(rdbtnPeridico);
		btnRecomendaesDeAulas.setForeground(Color.BLACK);
		btnRecomendaesDeAulas.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnRecomendaesDeAulas.setBounds(320, 513, 348, 37);
		frame.getContentPane().add(btnRecomendaesDeAulas);
		
		tfVagas = new JTextField();
		
		tfVagas.setColumns(10);
		tfVagas.setBounds(80, 428, 86, 20);
		frame.getContentPane().add(tfVagas);
		
		JLabel lblVagas = new JLabel("VAGAS:");
		lblVagas.setForeground(Color.WHITE);
		lblVagas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblVagas.setBounds(10, 427, 61, 19);
		frame.getContentPane().add(lblVagas);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBounds(10, 513, 156, 37);
		frame.getContentPane().add(btnVoltar);
		btnCriarAula.setForeground(Color.BLACK);
		btnCriarAula.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnCriarAula.setBounds(793, 513, 156, 37);
		frame.getContentPane().add(btnCriarAula);
		
		tfLocal = new JTextField();
		tfLocal.setColumns(10);
		tfLocal.setBounds(81, 397, 306, 20);
		frame.getContentPane().add(tfLocal);
		
		JLabel lblLocal = new JLabel("LOCAL:");
		lblLocal.setForeground(Color.WHITE);
		lblLocal.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblLocal.setBounds(10, 396, 61, 19);
		frame.getContentPane().add(lblLocal);
		
		tfConteudo = new JTextField();
		tfConteudo.setBounds(456, 89, 257, 20);
		frame.getContentPane().add(tfConteudo);
		tfConteudo.setColumns(10);
		
		JLabel lblContedo = new JLabel("CONTE\u00DADO:");
		lblContedo.setForeground(Color.WHITE);
		lblContedo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblContedo.setBounds(339, 88, 107, 19);
		frame.getContentPane().add(lblContedo);
		
		cbMaterias = new JComboBox<String>();
		cbMaterias.setBounds(117, 89, 136, 20);
		frame.getContentPane().add(cbMaterias);
		cbMaterias.addItem("Biologia");
		cbMaterias.addItem("Matem�tica");  
		cbMaterias.addItem("F�sica");
		cbMaterias.addItem("Portugu�s");
		cbMaterias.addItem("Qu�mica");
		cbMaterias.addItem("Hist�ria");
		cbMaterias.addItem("Geografia");
		cbMaterias.addItem("Reda��o");
		cbMaterias.addItem("Literatura");
		cbMaterias.addItem("Ingl�s");
		cbMaterias.addItem("Sociologia");
		cbMaterias.addItem("Espanhol");
		cbMaterias.addItem("Filosofia");  
		
		JLabel lblMatria = new JLabel("MAT\u00C9RIA:");
		lblMatria.setForeground(Color.WHITE);
		lblMatria.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMatria.setBounds(10, 91, 89, 19);
		frame.getContentPane().add(lblMatria);
		
		ButtonGroup gripo = new ButtonGroup();
		gripo.add(rdbtnPeridico);
		gripo.add(rdbtnUmaVez);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(0, 474, 481, 28);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(470, 474, 320, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(782, 474, 167, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(0, 50, 481, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(470, 50, 479, 28);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(782, 50, 181, 28);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Money.png"));
		lblNewLabel_5.setBounds(243, 0, 510, 61);
		frame.getContentPane().add(lblNewLabel_5);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(1, 171, 929, 197);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_7.setBounds(4, 183, 492, 14);
		panel.add(lblNewLabel_7);
		
		lblData = new JLabel("DATA:");
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(65, 10, 61, 19);
		panel.add(lblData);
		lblData.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		chSegunda = new JCheckBox("Segunda-feira");
		chSegunda.setBackground(Color.BLACK);
		chSegunda.setForeground(Color.WHITE);
		chSegunda.setBounds(4, 46, 117, 23);
		panel.add(chSegunda);
		
		chSabado = new JCheckBox("S\u00E1bado");
		chSabado.setForeground(Color.WHITE);
		chSabado.setBackground(Color.BLACK);
		chSabado.setBounds(117, 47, 88, 23);
		panel.add(chSabado);
		
		chTerca = new JCheckBox("Ter\u00E7a-feira");
		chTerca.setForeground(Color.WHITE);
		chTerca.setBackground(Color.BLACK);
		chTerca.setBounds(4, 66, 97, 23);
		panel.add(chTerca);
		
		chQuarta = new JCheckBox("Quarta-feira");
		chQuarta.setBackground(Color.BLACK);
		chQuarta.setForeground(Color.WHITE);
		chQuarta.setBounds(4, 86, 97, 23);
		panel.add(chQuarta);
		
		chDomingo = new JCheckBox("Domingo");
		chDomingo.setBackground(Color.BLACK);
		chDomingo.setForeground(Color.WHITE);
		chDomingo.setBounds(117, 68, 78, 23);
		panel.add(chDomingo);
		
		chQuinta = new JCheckBox("Quinta-feira");
		chQuinta.setForeground(Color.WHITE);
		chQuinta.setBackground(Color.BLACK);
		chQuinta.setBounds(4, 106, 97, 23);
		panel.add(chQuinta);
		
		chSexta = new JCheckBox("Sexta-feira");
		chSexta.setBackground(Color.BLACK);
		chSexta.setForeground(Color.WHITE);
		chSexta.setBounds(4, 126, 97, 23);
		panel.add(chSexta);
		
		lblTurno = new JLabel("TURNO:");
		lblTurno.setForeground(Color.WHITE);
		lblTurno.setBounds(277, 8, 74, 19);
		panel.add(lblTurno);
		lblTurno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		chNoite = new JCheckBox("Noite");
		chNoite.setForeground(Color.WHITE);
		chNoite.setBackground(Color.BLACK);
		chNoite.setBounds(653, 27, 97, 23);
		panel.add(chNoite);
		
		chManha = new JCheckBox("Manh\u00E3");
		chManha.setForeground(Color.WHITE);
		chManha.setBackground(Color.BLACK);
		chManha.setBounds(266, 30, 97, 23);
		panel.add(chManha);
		
		chTarde = new JCheckBox("Tarde");
		chTarde.setBackground(Color.BLACK);
		chTarde.setForeground(Color.WHITE);
		chTarde.setBounds(463, 28, 97, 23);
		panel.add(chTarde);
		
		tfDeManha = new JFormattedTextField(DeAte);
		tfDeManha.setVisible(false);
		tfDeManha.setBounds(248, 53, 122, 20);
		panel.add(tfDeManha);
		tfDeManha.setColumns(10);
		
		JLabel lblDe = new JLabel("DE:");
		lblDe.setForeground(Color.WHITE);
		lblDe.setVisible(false);
		lblDe.setBounds(209, 53, 61, 19);
		panel.add(lblDe);
		lblDe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfAteManha = new JFormattedTextField(DeAte);
		tfAteManha.setVisible(false);
		tfAteManha.setBounds(247, 77, 122, 20);
		panel.add(tfAteManha);
		tfAteManha.setColumns(10);
		
		JLabel lblAt = new JLabel("AT\u00C9:");
		lblAt.setForeground(Color.WHITE);
		lblAt.setVisible(false);
		lblAt.setBounds(201, 75, 61, 19);
		panel.add(lblAt);
		lblAt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		label = new JLabel("DE:");
		label.setForeground(Color.WHITE);
		label.setVisible(false);
		label.setBounds(582, 52, 42, 19);
		panel.add(label);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfDeNoite = new JFormattedTextField(DeAte);
		tfDeNoite.setVisible(false);
		tfDeNoite.setBounds(624, 51, 126, 20);
		panel.add(tfDeNoite);
		tfDeNoite.setColumns(10);
		
		label_3 = new JLabel("AT\u00C9:");
		label_3.setForeground(Color.WHITE);
		label_3.setVisible(false);
		label_3.setBounds(575, 76, 42, 19);
		panel.add(label_3);
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfAteNoite = new JFormattedTextField(DeAte);
		tfAteNoite.setVisible(false);
		tfAteNoite.setBounds(624, 77, 126, 20);
		panel.add(tfAteNoite);
		tfAteNoite.setColumns(10);
		
		JLabel label_1 = new JLabel("DE:");
		label_1.setForeground(Color.WHITE);
		label_1.setVisible(false);
		label_1.setBounds(400, 52, 61, 19);
		panel.add(label_1);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfDeTarde = new JFormattedTextField(DeAte);
		tfDeTarde.setVisible(false);
		tfDeTarde.setBounds(438, 52, 126, 20);
		panel.add(tfDeTarde);
		tfDeTarde.setColumns(10);
		
		JLabel label_2 = new JLabel("AT\u00C9:");
		label_2.setForeground(Color.WHITE);
		label_2.setVisible(false);
		label_2.setBounds(390, 78, 53, 19);
		panel.add(label_2);
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfAteTarde = new JFormattedTextField(DeAte);
		tfAteTarde.setVisible(false);
		tfAteTarde.setBounds(439, 76, 125, 20);
		panel.add(tfAteTarde);
		tfAteTarde.setColumns(10);
		
		label_4 = new JLabel("TURNO:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_4.setBounds(470, 8, 74, 19);
		panel.add(label_4);
		
		label_5 = new JLabel("TURNO:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_5.setBounds(659, 7, 74, 19);
		panel.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		label_6.setBounds(484, 183, 467, 14);
		panel.add(label_6);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\BARRA ofcial.png"));
		lblNewLabel_8.setBounds(919, 354, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		chTarde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chTarde.isSelected()) {
					label_1.setVisible(true);
					label_2.setVisible(true);
					tfDeTarde.setVisible(true);
					tfAteTarde.setVisible(true);
				}else {
					label_1.setVisible(false);
					label_2.setVisible(false);
					tfDeTarde.setVisible(false);
					tfAteTarde.setVisible(false);
				}
			}
		});
		chManha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chManha.isSelected()) {
					lblDe.setVisible(true);
					lblAt.setVisible(true);
					tfDeManha.setVisible(true);
					tfAteManha.setVisible(true);
				}else {
					lblDe.setVisible(false);
					lblAt.setVisible(false);
					tfDeManha.setVisible(false);
					tfAteManha.setVisible(false);
				}
			}
		});
		chNoite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chNoite.isSelected()) {
					label.setVisible(true);
					label_3.setVisible(true);
					tfDeNoite.setVisible(true);
					tfAteNoite.setVisible(true);
				}else {
					label.setVisible(false);
					label_3.setVisible(false);
					tfDeNoite.setVisible(false);
					tfAteNoite.setVisible(false);
				}
			}
		});
	}
}

