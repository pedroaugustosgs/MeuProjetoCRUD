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
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_9;
	
	public String ids[]= new String[100];
	int cont=0;
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
		frmMeuCrud.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Imagem\\img\\students-cap.png"));
		frmMeuCrud.setTitle("Aulas solicitadas");
		frmMeuCrud.setBounds(100, 100, 1041, 640);
		frmMeuCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuCrud.getContentPane().setLayout(null);
		frmMeuCrud.setResizable(false);
		frmMeuCrud.setLocationRelativeTo(null);
		
		
		tfProcurar = new JTextField();
		tfProcurar.setBackground(Color.BLACK);
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
					tfProcurar.setForeground(Color.WHITE);
					tfProcurar.setText(null);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(tfProcurar.getText().isEmpty()) {
					tfProcurar.setForeground(Color.WHITE);
					tfProcurar.setText("Entre com a mat�ria a ser procurada");
				}
					
			}
		});
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(-9, 494, 491, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_8.setBounds(478, 494, 233, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_8);
		tfProcurar.setForeground(Color.WHITE);
		tfProcurar.setText("Entre com a mat\u00E9ria a ser procurada");
		tfProcurar.setBounds(268, 188, 467, 26);
		frmMeuCrud.getContentPane().add(tfProcurar);
		tfProcurar.setColumns(10);
		
		btnProcurar = new JButton("PROCURAR");
		btnProcurar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnProcurar.setForeground(Color.BLACK);
		btnProcurar.setBackground(Color.LIGHT_GRAY);
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
		btnProcurar.setBounds(755, 181, 164, 39);
		frmMeuCrud.getContentPane().add(btnProcurar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlaAluno.main(null);
				frmMeuCrud.dispose();
			}
		});
		btnVoltar.setBounds(1, 572, 164, 39);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(701, 494, 264, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(0, 109, 448, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_5.setBounds(440, 109, 491, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(925, 109, 124, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(547, 506, 46, 14);
		frmMeuCrud.getContentPane().add(lblNewLabel_7);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {     /////////////////////******************
				SolicitaAula.main(new String[] {ids[tabela.getSelectedRow()]});  //*****************************
				frmMeuCrud.dispose();
			}
			
		});
		
			JScrollPane scrollPane = new JScrollPane(tabela);
			scrollPane.setBounds(268, 261, 499, 222);
			frmMeuCrud.getContentPane().add(scrollPane);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(422, 188, 46, 14);
			frmMeuCrud.getContentPane().add(lblNewLabel);
			
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
			lblNewLabel_3.setBounds(961, 494, 74, 26);
			frmMeuCrud.getContentPane().add(lblNewLabel_3);
			
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setIcon(new ImageIcon("D:\\Imagem\\img\\aulassss.jpg"));
			lblNewLabel_9.setBounds(204, 40, 683, 69);
			frmMeuCrud.getContentPane().add(lblNewLabel_9);
		
		criaTabela(pegaAulaSolicitada());
	}// fim do m�todo inicialize
	
	//responsavel por definir os parametros da tabela
	public void criaTabela(ResultSet dados) {
	String[] colunas = {"MAT�RIA","SOLICITANTE","CONTE�DO","LOCAL"};
		ArrayList linhas = new ArrayList<>();
		
		try {
			while (dados.next()) {
				
				ids[cont++]=dados.getString("idSaula");

				linhas.add(new Object[] {
						//dados.getString("idSAula"),
						Materia(dados.getString("materia")),
						NomeProf(Integer.parseInt(dados.getString("Solicitante"))),
						dados.getString("conteudo"),
						dados.getString("local"),
						/*dados.getInt("segunda")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("terca")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("quarta")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("quinta")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("sexta")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("sabado")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("domingo")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("manha")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("tarde")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getInt("noite")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getString("DeManha"),
						dados.getString("AteManha"),
						dados.getString("DeTarde"),
						dados.getString("AteTarde"),
						dados.getString("DeNoite"),
						dados.getString("AteNoite"),
						dados.getString("DiaUmaVez"),
						dados.getString("DeUmaVez"),
						dados.getString("AteUmaVez"),*/
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
