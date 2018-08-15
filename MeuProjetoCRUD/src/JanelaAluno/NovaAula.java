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
				
				if(cbMaterias.getSelectedItem().equals("Matemática")) {
					disciplina= "MAT";
				}
				if(cbMaterias.getSelectedItem().equals("Biologia")) {
					disciplina= "BIO";
				}
				if(cbMaterias.getSelectedItem().equals("Física")) {
					disciplina="FIS";
				}
				if(cbMaterias.getSelectedItem().equals("Português")) {
					disciplina= "PORT";
				}
				if(cbMaterias.getSelectedItem().equals("Química")) {
					disciplina= "QUI";
				}
				if(cbMaterias.getSelectedItem().equals("História")) {
					disciplina= "HIS";
				}
				if(cbMaterias.getSelectedItem().equals("Geografia")) {
					disciplina= "GEO";
				}
				if(cbMaterias.getSelectedItem().equals("Redação")) {
					disciplina= "RED";
				}
				if(cbMaterias.getSelectedItem().equals("Literatura")) {
					disciplina= "LIT";
				}
				if(cbMaterias.getSelectedItem().equals("Inglês")) {
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
					JOptionPane.showMessageDialog(null, "Marque um período do dia para dar a aula!");
					return;
				}
				
				String conteudo;
				if(!tfConteudo.getText().toString().isEmpty()) {
					conteudo = tfConteudo.getText().toString();
				}else {
					JOptionPane.showMessageDialog(null, "Insira um conteúdo!");
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
					JOptionPane.showMessageDialog(null, "Insira um local válido!");
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
				//SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				//String umaVez = s.format(calendario.getDate());
				Date data=null;
				if(rdbtnUmaVez.isSelected()) {
					data = calendario.getDate();
				}
				
				if(novaAula.novaAula(disciplina, conteudo, segunda, terca, quarta, quinta, sexta, sabado, domingo, manha, tarde, noite, local, prof,vagas,DeManha,AteManha,
						DeTarde,AteTarde,DeNoite,AteNoite,data,tfDeUmaVez.getText(),tfAteUmaVez.getText())) {
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
		
		panel_1 = new JPanel();
		panel_1.setVisible(false);
		panel_1.setBounds(10, 180, 929, 197);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDe_1 = new JLabel("DE:");
		lblDe_1.setForeground(Color.WHITE);
		lblDe_1.setBounds(10, 119, 46, 20);
		panel_1.add(lblDe_1);
		lblDe_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		tfDeUmaVez = new JFormattedTextField(DeAte);
		tfDeUmaVez.setBounds(45, 119, 143, 20);
		panel_1.add(tfDeUmaVez);
		tfDeUmaVez.setColumns(10);
		
		JLabel lblAt_1 = new JLabel("AT\u00C9:");
		lblAt_1.setForeground(Color.WHITE);
		lblAt_1.setBounds(10, 143, 46, 20);
		panel_1.add(lblAt_1);
		lblAt_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		tfAteUmaVez = new JFormattedTextField(DeAte);
		tfAteUmaVez.setBounds(60, 145, 143, 20);
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
					JOptionPane.showMessageDialog(null, "A data escolhida deve ser superior ou igual a data de hoje!","Data Inválida",JOptionPane.ERROR_MESSAGE);
					calendario.setDate(hoje);
				}
			}
		});
		calendario.setBounds(237, 12, 191, 153);
		panel_1.add(calendario);
		
		JLabel lblData_1 = new JLabel("DATA:");
		lblData_1.setForeground(Color.WHITE);
		lblData_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblData_1.setBounds(157, 11, 70, 20);
		panel_1.add(lblData_1);
		rdbtnUmaVez.setBounds(186, 147, 109, 23);
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
		rdbtnPeridico.setBounds(37, 147, 109, 23);
		frame.getContentPane().add(rdbtnPeridico);
		btnRecomendaesDeAulas.setForeground(Color.BLACK);
		btnRecomendaesDeAulas.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnRecomendaesDeAulas.setBounds(352, 513, 254, 37);
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
		btnVoltar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnVoltar.setBounds(0, 513, 156, 37);
		frame.getContentPane().add(btnVoltar);
		btnCriarAula.setForeground(Color.BLACK);
		btnCriarAula.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnCriarAula.setBounds(793, 513, 156, 37);
		frame.getContentPane().add(btnCriarAula);
		
		tfLocal = new JTextField();
		tfLocal.setColumns(10);
		tfLocal.setBounds(81, 397, 553, 20);
		frame.getContentPane().add(tfLocal);
		
		JLabel lblLocal = new JLabel("LOCAL:");
		lblLocal.setForeground(Color.WHITE);
		lblLocal.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblLocal.setBounds(10, 396, 61, 19);
		frame.getContentPane().add(lblLocal);
		
		tfConteudo = new JTextField();
		tfConteudo.setBounds(119, 120, 515, 20);
		frame.getContentPane().add(tfConteudo);
		tfConteudo.setColumns(10);
		
		JLabel lblContedo = new JLabel("CONTE\u00DADO:");
		lblContedo.setForeground(Color.WHITE);
		lblContedo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblContedo.setBounds(10, 121, 107, 19);
		frame.getContentPane().add(lblContedo);
		
		cbMaterias = new JComboBox<String>();
		cbMaterias.setBounds(117, 89, 136, 20);
		frame.getContentPane().add(cbMaterias);
		cbMaterias.addItem("Biologia");
		cbMaterias.addItem("Matemática");  
		cbMaterias.addItem("Física");
		cbMaterias.addItem("Português");
		cbMaterias.addItem("Química");
		cbMaterias.addItem("História");
		cbMaterias.addItem("Geografia");
		cbMaterias.addItem("Redação");
		cbMaterias.addItem("Literatura");
		cbMaterias.addItem("Inglês");
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
		
		panel = new JPanel();
		panel.setBounds(10, 189, 929, 197);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblData = new JLabel("DATA:");
		lblData.setBounds(10, 11, 61, 19);
		panel.add(lblData);
		lblData.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		chSegunda = new JCheckBox("Segunda-feira");
		chSegunda.setBounds(73, 11, 138, 23);
		panel.add(chSegunda);
		
		chSabado = new JCheckBox("S\u00E1bado");
		chSabado.setBounds(685, 11, 97, 23);
		panel.add(chSabado);
		
		chTerca = new JCheckBox("Ter\u00E7a-feira");
		chTerca.setBounds(213, 11, 97, 23);
		panel.add(chTerca);
		
		chQuarta = new JCheckBox("Quarta-feira");
		chQuarta.setBounds(312, 11, 97, 23);
		panel.add(chQuarta);
		
		chDomingo = new JCheckBox("Domingo");
		chDomingo.setBounds(812, 11, 97, 23);
		panel.add(chDomingo);
		
		chQuinta = new JCheckBox("Quinta-feira");
		chQuinta.setBounds(438, 11, 97, 23);
		panel.add(chQuinta);
		
		chSexta = new JCheckBox("Sexta-feira");
		chSexta.setBounds(564, 11, 97, 23);
		panel.add(chSexta);
		
		lblTurno = new JLabel("TURNO:");
		lblTurno.setBounds(10, 55, 74, 19);
		panel.add(lblTurno);
		lblTurno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		chNoite = new JCheckBox("Noite");
		chNoite.setBounds(478, 55, 97, 23);
		panel.add(chNoite);
		
		chManha = new JCheckBox("Manh\u00E3");
		chManha.setBounds(108, 55, 97, 23);
		panel.add(chManha);
		
		chTarde = new JCheckBox("Tarde");
		chTarde.setBounds(282, 55, 97, 23);
		panel.add(chTarde);
		
		tfDeManha = new JFormattedTextField(DeAte);
		tfDeManha.setVisible(false);
		tfDeManha.setBounds(95, 85, 122, 20);
		panel.add(tfDeManha);
		tfDeManha.setColumns(10);
		
		JLabel lblDe = new JLabel("DE:");
		lblDe.setVisible(false);
		lblDe.setBounds(56, 85, 61, 19);
		panel.add(lblDe);
		lblDe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfAteManha = new JFormattedTextField(DeAte);
		tfAteManha.setVisible(false);
		tfAteManha.setBounds(95, 116, 122, 20);
		panel.add(tfAteManha);
		tfAteManha.setColumns(10);
		
		JLabel lblAt = new JLabel("AT\u00C9:");
		lblAt.setVisible(false);
		lblAt.setBounds(45, 116, 61, 19);
		panel.add(lblAt);
		lblAt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		label = new JLabel("DE:");
		label.setVisible(false);
		label.setBounds(438, 84, 42, 19);
		panel.add(label);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfDeNoite = new JFormattedTextField(DeAte);
		tfDeNoite.setVisible(false);
		tfDeNoite.setBounds(475, 85, 126, 20);
		panel.add(tfDeNoite);
		tfDeNoite.setColumns(10);
		
		label_3 = new JLabel("AT\u00C9:");
		label_3.setVisible(false);
		label_3.setBounds(436, 115, 42, 19);
		panel.add(label_3);
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfAteNoite = new JFormattedTextField(DeAte);
		tfAteNoite.setVisible(false);
		tfAteNoite.setBounds(478, 116, 126, 20);
		panel.add(tfAteNoite);
		tfAteNoite.setColumns(10);
		
		JLabel label_1 = new JLabel("DE:");
		label_1.setVisible(false);
		label_1.setBounds(237, 85, 61, 19);
		panel.add(label_1);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfDeTarde = new JFormattedTextField(DeAte);
		tfDeTarde.setVisible(false);
		tfDeTarde.setBounds(282, 85, 126, 20);
		panel.add(tfDeTarde);
		tfDeTarde.setColumns(10);
		
		JLabel label_2 = new JLabel("AT\u00C9:");
		label_2.setVisible(false);
		label_2.setBounds(237, 115, 53, 19);
		panel.add(label_2);
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfAteTarde = new JFormattedTextField(DeAte);
		tfAteTarde.setVisible(false);
		tfAteTarde.setBounds(284, 114, 125, 20);
		panel.add(tfAteTarde);
		tfAteTarde.setColumns(10);
		
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
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Crimson (2).png"));
		lblNewLabel_5.setBounds(343, 0, 338, 55);
		frame.getContentPane().add(lblNewLabel_5);
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

