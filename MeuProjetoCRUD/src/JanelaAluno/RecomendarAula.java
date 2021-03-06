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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;

public class RecomendarAula extends Login {

	private JFrame frmRecomendeAula;
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
	private JLabel label_4;
	private JLabel label_5;
	private JLabel lblNewLabel_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecomendarAula window = new RecomendarAula();
					window.frmRecomendeAula.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RecomendarAula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRecomendeAula = new JFrame();
		frmRecomendeAula.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Imagem\\img\\students-cap.png"));
		frmRecomendeAula.setTitle("Recomende Aula");
		frmRecomendeAula.getContentPane().setBackground(Color.BLACK);
		frmRecomendeAula.setBounds(100, 100, 955, 629);
		frmRecomendeAula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecomendeAula.getContentPane().setLayout(null);
		frmRecomendeAula.setResizable(false);
		frmRecomendeAula.setLocationRelativeTo(null);
		
		try {
			DeAte = new MaskFormatter("##:##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnCriarAula = new JButton("SOLICITAR");
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
				
				String conteudo = tfConteudo.getText().toString();
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
				String local = tfLocal.getText().toString();
				/*int prof=0;
				String sql="SELECT * FROM alunos WHERE idaluno=?";
				try {
					PreparedStatement stmt = Banco.Conexao.conexao.prepareStatement(sql);
					stmt.setInt(1, id);
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
				*/
				String idSoli = id;
				
				if(chManha.isSelected()) {
					DeManha = tfDeManha.getText();
				}
				if(chManha.isSelected()) {
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
				String umaVez=null;
				if(rdbtnUmaVez.isSelected()) {
					SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
					umaVez = s.format(calendario.getDate());
				}
				String DeUmaVez = null;
				if(rdbtnUmaVez.isSelected()) {
					DeUmaVez= tfDeUmaVez.getText();
				}
				String AteUmaVez = null;
				if(rdbtnUmaVez.isSelected()) {
					AteUmaVez=tfAteUmaVez.getText();
				}
				
				if(InserirAulaSoli(idSoli, disciplina, conteudo, segunda, terca, quarta, quinta, sexta, sabado, domingo, manha, tarde, noite, local,DeManha
						, AteManha, DeTarde, AteTarde, DeNoite, AteNoite, umaVez, DeUmaVez, AteUmaVez)) {
					JOptionPane.showMessageDialog(null, "Nova aula solicitada com sucesso!");
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar nova aula!");
				}
				
				TerAula.main(null);
				frmRecomendeAula.dispose();
			}
		});
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TerAula.main(null);
				frmRecomendeAula.dispose();
			}
		});
		
		rdbtnUmaVez = new JRadioButton("Uma vez");
		rdbtnUmaVez.setForeground(Color.WHITE);
		rdbtnUmaVez.setBackground(Color.BLACK);
		rdbtnUmaVez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);	
				tfDeUmaVez.setEnabled(true);
				tfAteUmaVez.setEnabled(true);
			}
		});
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(-12, 515, 446, 27);
		frmRecomendeAula.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(397, 515, 469, 27);
		frmRecomendeAula.getContentPane().add(lblNewLabel_1);
		rdbtnUmaVez.setBounds(119, 180, 109, 23);
		frmRecomendeAula.getContentPane().add(rdbtnUmaVez);
		
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
		rdbtnPeridico.setBounds(8, 180, 109, 23);
		frmRecomendeAula.getContentPane().add(rdbtnPeridico);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBounds(1, 563, 156, 37);
		frmRecomendeAula.getContentPane().add(btnVoltar);
		btnCriarAula.setForeground(Color.BLACK);
		btnCriarAula.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnCriarAula.setBounds(792, 563, 156, 37);
		frmRecomendeAula.getContentPane().add(btnCriarAula);
		
		tfLocal = new JTextField();
		tfLocal.setForeground(Color.WHITE);
		tfLocal.setBackground(Color.BLACK);
		tfLocal.setColumns(10);
		tfLocal.setBounds(86, 466, 218, 20);
		frmRecomendeAula.getContentPane().add(tfLocal);
		
		JLabel lblLocal = new JLabel("LOCAL:");
		lblLocal.setForeground(Color.WHITE);
		lblLocal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblLocal.setBounds(10, 465, 61, 19);
		frmRecomendeAula.getContentPane().add(lblLocal);
		
		tfConteudo = new JTextField();
		tfConteudo.setForeground(Color.WHITE);
		tfConteudo.setBackground(Color.BLACK);
		tfConteudo.setBounds(119, 152, 515, 20);
		frmRecomendeAula.getContentPane().add(tfConteudo);
		tfConteudo.setColumns(10);
		
		JLabel lblContedo = new JLabel("CONTE\u00DADO:");
		lblContedo.setForeground(Color.WHITE);
		lblContedo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblContedo.setBounds(10, 154, 107, 19);
		frmRecomendeAula.getContentPane().add(lblContedo);
		
		cbMaterias = new JComboBox<String>();
		cbMaterias.setBounds(115, 121, 136, 20);
		frmRecomendeAula.getContentPane().add(cbMaterias);
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
		lblMatria.setBounds(10, 124, 89, 19);
		frmRecomendeAula.getContentPane().add(lblMatria);
		
		ButtonGroup gripo = new ButtonGroup();
		gripo.add(rdbtnPeridico);
		gripo.add(rdbtnUmaVez);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(0, 87, 469, 23);
		frmRecomendeAula.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(462, 87, 502, 23);
		frmRecomendeAula.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(860, 515, 89, 27);
		frmRecomendeAula.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\ggggggggg111.jpg"));
		lblNewLabel_5.setBounds(15, 11, 906, 77);
		frmRecomendeAula.getContentPane().add(lblNewLabel_5);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(2, 208, 929, 245);
		frmRecomendeAula.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblData = new JLabel("DATA:");
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(76, 11, 61, 19);
		panel.add(lblData);
		lblData.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		chSegunda = new JCheckBox("Segunda-feira");
		chSegunda.setForeground(Color.WHITE);
		chSegunda.setBackground(Color.BLACK);
		chSegunda.setBounds(6, 40, 124, 23);
		panel.add(chSegunda);
		
		chSabado = new JCheckBox("S\u00E1bado");
		chSabado.setForeground(Color.WHITE);
		chSabado.setBackground(Color.BLACK);
		chSabado.setBounds(137, 39, 97, 23);
		panel.add(chSabado);
		
		chTerca = new JCheckBox("Ter\u00E7a-feira");
		chTerca.setBackground(Color.BLACK);
		chTerca.setForeground(Color.WHITE);
		chTerca.setBounds(6, 66, 99, 23);
		panel.add(chTerca);
		
		chQuarta = new JCheckBox("Quarta-feira");
		chQuarta.setForeground(Color.WHITE);
		chQuarta.setBackground(Color.BLACK);
		chQuarta.setBounds(6, 92, 99, 23);
		panel.add(chQuarta);
		
		chDomingo = new JCheckBox("Domingo");
		chDomingo.setForeground(Color.WHITE);
		chDomingo.setBackground(Color.BLACK);
		chDomingo.setBounds(137, 67, 97, 23);
		panel.add(chDomingo);
		
		chQuinta = new JCheckBox("Quinta-feira");
		chQuinta.setForeground(Color.WHITE);
		chQuinta.setBackground(Color.BLACK);
		chQuinta.setBounds(6, 118, 99, 23);
		panel.add(chQuinta);
		
		chSexta = new JCheckBox("Sexta-feira");
		chSexta.setForeground(Color.WHITE);
		chSexta.setBackground(Color.BLACK);
		chSexta.setBounds(6, 144, 99, 23);
		panel.add(chSexta);
		
		lblTurno = new JLabel("TURNO:");
		lblTurno.setForeground(Color.WHITE);
		lblTurno.setBounds(356, 11, 74, 19);
		panel.add(lblTurno);
		lblTurno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		chNoite = new JCheckBox("Noite");
		chNoite.setForeground(Color.WHITE);
		chNoite.setBackground(Color.BLACK);
		chNoite.setBounds(695, 35, 97, 23);
		panel.add(chNoite);
		
		chManha = new JCheckBox("Manh\u00E3");
		chManha.setBackground(Color.BLACK);
		chManha.setForeground(Color.WHITE);
		chManha.setBounds(339, 36, 97, 23);
		panel.add(chManha);
		
		chTarde = new JCheckBox("Tarde");
		chTarde.setBackground(Color.BLACK);
		chTarde.setForeground(Color.WHITE);
		chTarde.setBounds(519, 35, 97, 23);
		panel.add(chTarde);
		
		tfDeManha = new JFormattedTextField(DeAte);
		tfDeManha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String  deumavez = tfDeManha.getText().toString();
				String hora[] = new String[2];
				hora = deumavez.split(":");
				int h = Integer.parseInt(hora[0]);
				int m = Integer.parseInt(hora[1]);
				if(h>23 || m>59) {
					JOptionPane.showMessageDialog(null, "Entre com um hor�rio v�lido");
					tfDeManha.requestFocus();
					tfDeManha.selectAll();
			}
			
				
			}
		});
		tfDeManha.setForeground(Color.WHITE);
		tfDeManha.setBackground(Color.BLACK);
		tfDeManha.setVisible(false);
		tfDeManha.setBounds(326, 66, 122, 20);
		panel.add(tfDeManha);
		tfDeManha.setColumns(10);
		
		JLabel lblDe = new JLabel("DE:");
		lblDe.setForeground(Color.WHITE);
		lblDe.setVisible(false);
		lblDe.setBounds(283, 66, 42, 19);
		panel.add(lblDe);
		lblDe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfAteManha = new JFormattedTextField(DeAte);
		tfAteManha.addFocusListener(new FocusAdapter() {
		
		
				public void focusLost(FocusEvent e) {
					String  deumavez = tfAteManha.getText().toString();
					String hora[] = new String[2];
					hora = deumavez.split(":");
					int h = Integer.parseInt(hora[0]);
					int m = Integer.parseInt(hora[1]);
					if(h>23 || m>59) {
						JOptionPane.showMessageDialog(null, "Entre com um hor�rio v�lido");
						tfAteManha.requestFocus();
						tfAteManha.selectAll();
				}
				
					
				
				
				
			}
		});
		tfAteManha.setForeground(Color.WHITE);
		tfAteManha.setBackground(Color.BLACK);
		tfAteManha.setVisible(false);
		tfAteManha.setBounds(326, 90, 122, 20);
		panel.add(tfAteManha);
		tfAteManha.setColumns(10);
		
		JLabel lblAt = new JLabel("AT\u00C9:");
		lblAt.setForeground(Color.WHITE);
		lblAt.setVisible(false);
		lblAt.setBounds(278, 92, 47, 19);
		panel.add(lblAt);
		lblAt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		label = new JLabel("DE:");
		label.setForeground(Color.WHITE);
		label.setVisible(false);
		label.setBounds(642, 67, 42, 19);
		panel.add(label);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfDeNoite = new JFormattedTextField(DeAte);
		tfDeNoite.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
					String  deumavez = tfDeNoite.getText().toString();
					String hora[] = new String[2];
					hora = deumavez.split(":");
					int h = Integer.parseInt(hora[0]);
					int m = Integer.parseInt(hora[1]);
					if(h>23 || m>59) {
						JOptionPane.showMessageDialog(null, "Entre com um hor�rio v�lido");
						tfDeNoite.requestFocus();
						tfDeNoite.selectAll();
					}
					
			}
		});
		tfDeNoite.setForeground(Color.WHITE);
		tfDeNoite.setBackground(Color.BLACK);
		tfDeNoite.setVisible(false);
		tfDeNoite.setBounds(683, 62, 126, 20);
		panel.add(tfDeNoite);
		tfDeNoite.setColumns(10);
		
		label_3 = new JLabel("AT\u00C9:");
		label_3.setForeground(Color.WHITE);
		label_3.setVisible(false);
		label_3.setBounds(639, 90, 42, 19);
		panel.add(label_3);
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfAteNoite = new JFormattedTextField(DeAte);
		tfAteNoite.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
					String  deumavez = tfAteNoite.getText().toString();
					String hora[] = new String[2];
					hora = deumavez.split(":");
					int h = Integer.parseInt(hora[0]);
					int m = Integer.parseInt(hora[1]);
					if(h>23 || m>59) {
						JOptionPane.showMessageDialog(null, "Entre com um hor�rio v�lido");
						tfAteNoite.requestFocus();
						tfAteNoite.selectAll();
					
					}
			}
		});
		tfAteNoite.setBackground(Color.BLACK);
		tfAteNoite.setForeground(Color.WHITE);
		tfAteNoite.setVisible(false);
		tfAteNoite.setBounds(683, 86, 126, 20);
		panel.add(tfAteNoite);
		tfAteNoite.setColumns(10);
		
		JLabel label_1 = new JLabel("DE:");
		label_1.setForeground(Color.WHITE);
		label_1.setVisible(false);
		label_1.setBounds(468, 67, 61, 19);
		panel.add(label_1);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfDeTarde = new JFormattedTextField(DeAte);
		tfDeTarde.addFocusListener(new FocusAdapter() {
			
				public void focusLost(FocusEvent e) {
					String  deumavez = tfDeTarde.getText().toString();
					String hora[] = new String[2];
					hora = deumavez.split(":");
					int h = Integer.parseInt(hora[0]);
					int m = Integer.parseInt(hora[1]);
					if(h>23 || m>59) {
						JOptionPane.showMessageDialog(null, "Entre com um hor�rio v�lido");
						tfDeTarde.requestFocus();
						tfDeTarde.selectAll();
				}
				
					
				
			}
		});
		tfDeTarde.setForeground(Color.WHITE);
		tfDeTarde.setBackground(Color.BLACK);
		tfDeTarde.setVisible(false);
		tfDeTarde.setBounds(504, 65, 126, 20);
		panel.add(tfDeTarde);
		tfDeTarde.setColumns(10);
		
		JLabel label_2 = new JLabel("AT\u00C9:");
		label_2.setForeground(Color.WHITE);
		label_2.setVisible(false);
		label_2.setBounds(458, 92, 53, 19);
		panel.add(label_2);
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfAteTarde = new JFormattedTextField(DeAte);
		tfAteTarde.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String  deumavez = tfAteTarde.getText().toString();
				String hora[] = new String[2];
				hora = deumavez.split(":");
				int h = Integer.parseInt(hora[0]);
				int m = Integer.parseInt(hora[1]);
				if(h>23 || m>59) {
					JOptionPane.showMessageDialog(null, "Entre com um hor�rio v�lido");
					tfAteTarde.requestFocus();
					tfAteTarde.selectAll();
				}
				}
		});
		tfAteTarde.setBackground(Color.BLACK);
		tfAteTarde.setForeground(Color.WHITE);
		tfAteTarde.setVisible(false);
		tfAteTarde.setBounds(504, 89, 125, 20);
		panel.add(tfAteTarde);
		tfAteTarde.setColumns(10);
		
		label_4 = new JLabel("TURNO:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_4.setBounds(531, 11, 74, 19);
		panel.add(label_4);
		
		label_5 = new JLabel("TURNO:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_5.setBounds(713, 13, 74, 19);
		panel.add(label_5);
		
		panel_1 = new JPanel();
		panel_1.setBounds(1, 207, 929, 197);
		frmRecomendeAula.getContentPane().add(panel_1);
		panel_1.setBackground(Color.BLACK);
		panel_1.setVisible(false);
		panel_1.setLayout(null);
		
		JLabel lblDe_1 = new JLabel("DE:");
		lblDe_1.setForeground(Color.WHITE);
		lblDe_1.setBounds(6, 20, 46, 20);
		panel_1.add(lblDe_1);
		lblDe_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfDeUmaVez = new JFormattedTextField(DeAte);
		tfDeUmaVez.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
					String  deumavez = tfDeUmaVez.getText().toString();
					String hora[] = new String[2];
					hora = deumavez.split(":");
					int h = Integer.parseInt(hora[0]);
					int m = Integer.parseInt(hora[1]);
					if(h>23 || m>59) {
						JOptionPane.showMessageDialog(null, "Entre com um hor�rio v�lido");
						tfDeUmaVez.requestFocus();
						tfDeUmaVez.selectAll();
					
					}
			}
		});
		tfDeUmaVez.setForeground(Color.WHITE);
		tfDeUmaVez.setBackground(Color.BLACK);
		tfDeUmaVez.setBounds(43, 23, 143, 20);
		panel_1.add(tfDeUmaVez);
		tfDeUmaVez.setColumns(10);
		
		JLabel lblAt_1 = new JLabel("AT\u00C9:");
		lblAt_1.setForeground(Color.WHITE);
		lblAt_1.setBounds(4, 52, 46, 20);
		panel_1.add(lblAt_1);
		lblAt_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		tfAteUmaVez = new JFormattedTextField(DeAte);
		tfAteUmaVez.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
					String  deumavez = tfAteUmaVez.getText().toString();
					String hora[] = new String[2];
					hora = deumavez.split(":");
					int h = Integer.parseInt(hora[0]);
					int m = Integer.parseInt(hora[1]);
					if(h>23 || m>59) {
						JOptionPane.showMessageDialog(null, "Entre com um hor�rio v�lido");
						tfAteUmaVez.requestFocus();
						tfAteUmaVez.selectAll();
					
					}
			}
		});
		tfAteUmaVez.setForeground(Color.WHITE);
		tfAteUmaVez.setBackground(Color.BLACK);
		tfAteUmaVez.setBounds(44, 53, 143, 20);
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
		calendario.setBounds(305, 10, 191, 153);
		panel_1.add(calendario);
		
		JLabel lblData_1 = new JLabel("DATA:");
		lblData_1.setForeground(Color.WHITE);
		lblData_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblData_1.setBounds(215, 20, 70, 20);
		panel_1.add(lblData_1);
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
	public boolean InserirAulaSoli(String idSoli,String m,String c,int s,int t,int q,int Qui,int sex,int sab,int dom, int manha,int tar,int noi,String local,
			String DeManha,String ateManha, String DeTarde,String AteTarde, String DeNoite, String AteNoite,String DiaUmaVez, String DeUmaVez, String AteUmaVez) {
		String sql="INSERT INTO solicitaraula (solicitante,materia,conteudo,segunda,terca,quarta,quinta,sexta,sabado,domingo,manha,tarde,noite,local,DeManha,AteManha,"
				+ "DeTarde,AteTarde,DeNoite,AteNoite,DiaUmaVez,DeUmaVez,AteUmaVez)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, idSoli);
			stmt.setString(2, m);
			stmt.setString(3, c);
			stmt.setInt(4, s);
			stmt.setInt(5, t);
			stmt.setInt(6, q);
			stmt.setInt(7, Qui);
			stmt.setInt(8, sex);
			stmt.setInt(9, sab);
			stmt.setInt(10, dom);
			stmt.setInt(11, manha);
			stmt.setInt(12, tar);
			stmt.setInt(13, noi);
			stmt.setString(14, local);
			stmt.setString(15, DeManha);
			stmt.setString(16, ateManha);
			stmt.setString(17, DeTarde);
			stmt.setString(18, AteTarde);
			stmt.setString(19, DeNoite);
			stmt.setString(20, AteNoite);
			stmt.setString(21, DiaUmaVez);
			stmt.setString(22, DeUmaVez);
			stmt.setString(23, AteUmaVez);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
