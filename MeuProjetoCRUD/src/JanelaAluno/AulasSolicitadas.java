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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_10;
	
	
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
				if(tfProcurar.getText().toString().equalsIgnoreCase("Entre com a matéria a ser procurada")) {
					tfProcurar.setForeground(Color.BLACK);
					tfProcurar.setText(null);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(tfProcurar.getText().isEmpty()) {
					tfProcurar.setForeground(Color.LIGHT_GRAY);
					tfProcurar.setText("Entre com a matéria a ser procurada");
				}
					
			}
		});
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\Imagem\\pesquisa.png"));
		lblNewLabel_9.setBounds(789, 452, 246, 178);
		frmMeuCrud.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(-9, 494, 491, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_8.setBounds(478, 494, 233, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_8);
		tfProcurar.setForeground(Color.LIGHT_GRAY);
		tfProcurar.setText("Entre com a mat\u00E9ria a ser procurada");
		tfProcurar.setBounds(10, 176, 821, 26);
		frmMeuCrud.getContentPane().add(tfProcurar);
		tfProcurar.setColumns(10);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		btnProcurar.setForeground(Color.BLACK);
		btnProcurar.setBackground(SystemColor.textHighlightText);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfProcurar.getText().equals("Entre com a matéria a ser procurada")) {
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
		btnProcurar.setBounds(841, 170, 166, 29);
		frmMeuCrud.getContentPane().add(btnProcurar);
		
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
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(701, 494, 264, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(961, 494, 74, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(0, 120, 448, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(444, 120, 491, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(927, 120, 124, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(547, 506, 46, 14);
		frmMeuCrud.getContentPane().add(lblNewLabel_7);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {     /////////////////////******************
				ConfirmaAula.main(new String[] {String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0))});  //*****************************
				frmMeuCrud.dispose();
			}
			
		});
		
			JScrollPane scrollPane = new JScrollPane(tabela);
			scrollPane.setBounds(10, 235, 1000, 222);
			frmMeuCrud.getContentPane().add(scrollPane);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(478, 50, 46, 14);
			frmMeuCrud.getContentPane().add(lblNewLabel);
			
			lblNewLabel_10 = new JLabel("");
			lblNewLabel_10.setIcon(new ImageIcon("D:\\Money.png"));
			lblNewLabel_10.setBounds(283, 25, 520, 84);
			frmMeuCrud.getContentPane().add(lblNewLabel_10);
		
		criaTabela(pegaAulaSolicitada());
	}// fim do método inicialize
	
	//responsavel por definir os parametros da tabela
	public void criaTabela(ResultSet dados) {
	String[] colunas = {"ID","Solicitante","Professor","Conteúdo","Segunda","Terça","Quarta","Quinta","Sexta","Sábado","Domingo","Manhã","Tarde","Noite","Local","De Manhã",
			"Até Manhã","De Tarde","Até tarde","De Noite","Até Noite","Dia Uma Vez","De Uma Vez","Até Uma Vez"};
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
