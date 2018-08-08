package JanelaAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


import Banco.Conexao;
import CRUD.Aluno;
import CRUD.CRUDAlunos;
import CRUD.CRUDAulas;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AulasSolicitadas extends Login{

	public JFrame frmMeuCrud;
	private JTextField tfProcurar;
	public static JButton btnProcurar;
	private JTable tabela; 
	public String Dias[];
	private JLabel label;
	private JLabel lblNewLabel;
	
	
	/**
	 * Launch the application.-
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AulasSolicitadas window = new AulasSolicitadas();
					window.frmMeuCrud.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AulasSolicitadas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmMeuCrud = new JFrame();
		frmMeuCrud.getContentPane().setBackground(Color.BLACK);
		frmMeuCrud.setIconImage(Toolkit.getDefaultToolkit().getImage(AulasSolicitadas.class.getResource("/47 - Copia.png")));
		frmMeuCrud.setTitle("MEU CRUD - Alunos Cadastrados");
		frmMeuCrud.setBounds(100, 100, 1041, 640);
		frmMeuCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuCrud.getContentPane().setLayout(null);
		frmMeuCrud.setResizable(false);
		frmMeuCrud.setLocationRelativeTo(null);
		
		
		tfProcurar = new JTextField();
		tfProcurar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {  //se apertou enter
					btnProcurar.doClick(); //da o clique
				}
			}
		});
		tfProcurar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(tfProcurar.getText().toString().equalsIgnoreCase("Entre com a mat�ria a ser procurada")) {
					tfProcurar.setForeground(Color.BLACK);
					tfProcurar.setText(null);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(tfProcurar.getText().isEmpty()) {
					tfProcurar.setForeground(Color.LIGHT_GRAY);
					tfProcurar.setText("Entre com a mat�ria a ser procurada");
				}
					
			}
		});
		tfProcurar.setForeground(Color.LIGHT_GRAY);
		tfProcurar.setText("Entre com a mat\u00E9ria a ser procurada");
		tfProcurar.setBounds(10, 121, 821, 26);
		frmMeuCrud.getContentPane().add(tfProcurar);
		tfProcurar.setColumns(10);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		btnProcurar.setForeground(Color.BLACK);
		btnProcurar.setBackground(SystemColor.textHighlightText);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfProcurar.getText().equals("Entre com a mat�ria a ser procurada")) {
					criaTabela(new CRUDAulas().pegaAula());
				}else {
					ResultSet dadosLike;
					String sql="SELECT * FROM aulas WHERE materia LIKE ? ORDER BY conteudo";
					try {
						PreparedStatement s = Conexao.conexao.prepareStatement(sql);
						s.setString(1, "%"+tfProcurar.getText()+"%");
						dadosLike = s.executeQuery();
						s.execute();
						s.close();
						
						criaTabela(dadosLike);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnProcurar.setBounds(844, 115, 166, 29);
		frmMeuCrud.getContentPane().add(btnProcurar);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {     /////////////////////******************
				ConfirmaAula.main(new String[] {String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0))});  //*****************************
				frmMeuCrud.dispose();
			}
			
		});
	
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 172, 1000, 222);
		frmMeuCrud.getContentPane().add(scrollPane);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(SystemColor.textHighlightText);
		btnVoltar.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlaAluno.main(null);
				frmMeuCrud.dispose();
			}
		});
		btnVoltar.setBounds(0, 573, 157, 39);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Imagem\\img\\Lupa.png"));
		label.setBounds(899, 470, 136, 142);
		frmMeuCrud.getContentPane().add(label);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\agendaaula.png"));
		lblNewLabel.setBounds(229, 26, 469, 62);
		frmMeuCrud.getContentPane().add(lblNewLabel);
		
		criaTabela(pegaAulaSolicitada());
	}// fim do m�todo inicialize
	
	//responsavel por definir os parametros da tabela
	public void criaTabela(ResultSet dados) {
	String[] colunas = {"ID","Solicitante","Professor","Conte�do","Segunda","Ter�a","Quarta","Quinta","Sexta","S�bado","Domingo","Manh�","Tarde","Noite","Local","De Manh�",
			"At� Manh�","De Tarde","At� tarde","De Noite","At� Noite","Dia Uma Vez","De Uma Vez","At� Uma Vez"};
		ArrayList linhas = new ArrayList<>();
		
		try {
			while (dados.next()) {
				linhas.add(new Object[] {
						dados.getString("idSAula"),
						NomeProf(Integer.parseInt(dados.getString("Solicitante"))),
						Materia(dados.getString("materia")),
						dados.getString("conteudo"),
						dados.getInt("segunda")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("terca")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("quarta")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("quinta")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("sexta")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("sabado")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("domingo")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("manha")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("tarde")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("noite")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getString("local"),
						dados.getString("DeManha"),
						dados.getString("AteManha"),
						dados.getString("DeTarde"),
						dados.getString("AteTarde"),
						dados.getString("DeNoite"),
						dados.getString("AteNoite"),
						dados.getString("DiaUmaVez"),
						dados.getString("DeUmaVez"),
						dados.getString("AteUmaVez"),
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
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(4).setResizable(false);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(5).setResizable(false);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(6).setResizable(false);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(7).setResizable(false);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(8).setResizable(false);
		tabela.getColumnModel().getColumn(9).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(9).setResizable(false);
		tabela.getColumnModel().getColumn(10).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(10).setResizable(false);
		tabela.getColumnModel().getColumn(11).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(11).setResizable(false);
		tabela.getColumnModel().getColumn(12).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(12).setResizable(false);
		tabela.getColumnModel().getColumn(13).setPreferredWidth(100);
		
		
		//*****************************************************************************   tabela nova = discpplina , vagas , inscritos na tabela aulas, professor e aluno inscrito
		
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		
		tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(14).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(15).setCellRenderer(centralizado);


		

	}//*********************************
	public String NomeProf(int id) {
		String nomeProf=null;
		ResultSet dadosProf=null;
		//String sql = "SELECT * FROM dependentes WHERE idSocio = ?";
		String sql = "SELECT * FROM alunos "
				+ "INNER JOIN SolicitarAula ON alunos.idaluno = SolicitarAula.Solicitante Where Solicitante = ?";
		try {
			PreparedStatement s = Banco.Conexao.conexao.prepareStatement(sql);
			s.setInt(1, id); //
			dadosProf = s.executeQuery();
			s.execute();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(dadosProf.next()) {
				nomeProf = dadosProf.getString("nome");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomeProf;
	}
	
	public ResultSet pegaAulaSolicitada() {
		ResultSet aulaSoli=null;
		String sql="SELECT * FROM solicitaraula";
		 try {
			PreparedStatement stmt = Banco.Conexao.conexao.prepareStatement(sql);
			aulaSoli = stmt.executeQuery();
			stmt.execute();
			stmt.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aulaSoli;
	}
	public String Materia(String m){
		String materia=null;
		
		if(m.equals("RED")) {
			materia="REDA��O";
		}
		if(m.equals("MAT")) {
			materia="MATEM�TICA";
		}
		if(m.equals("QUI")) {
			materia="QU�MICA";
		}
		if(m.equals("FIS")) {
			materia="F�SICA";
		}
		if(m.equals("BIO")) {
			materia="BIOLOGIA";
		}
		if(m.equals("HIS")) {
			materia="HIST�RIA";
		}
		if(m.equals("GEO")) {
			materia="GEOGRAFIA";
		}
		if(m.equals("PORT")) {
			materia="PORTUGU�S";
		}
		if(m.equals("FILOS")) {
			materia="FILOSOFIA";
		}
		if(m.equals("ING")) {
			materia="INGL�S";
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
