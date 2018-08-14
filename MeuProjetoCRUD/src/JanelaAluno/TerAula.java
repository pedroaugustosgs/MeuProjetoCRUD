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
import java.sql.Date;
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

public class TerAula extends Login{

	public JFrame frmMeuCrud;
	private JTextField tfProcurar;
	public static JButton btnProcurar;
	private JTable tabela; 
	public String Dias[];
	public ResultSet dadostabela=null;
	
	/**
	 * Launch the application.-
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TerAula window = new TerAula();
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
	public TerAula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmMeuCrud = new JFrame();
		frmMeuCrud.setIconImage(Toolkit.getDefaultToolkit().getImage(TerAula.class.getResource("/47 - Copia.png")));
		frmMeuCrud.setTitle("MEU CRUD - Alunos Cadastrados");
		frmMeuCrud.setBounds(100, 100, 1026, 346);
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
		tfProcurar.setForeground(Color.LIGHT_GRAY);
		tfProcurar.setText("Entre com a mat\u00E9ria a ser procurada");
		tfProcurar.setBounds(10, 14, 821, 26);
		frmMeuCrud.getContentPane().add(tfProcurar);
		tfProcurar.setColumns(10);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnProcurar.setForeground(SystemColor.textHighlight);
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
		btnProcurar.setBounds(841, 11, 157, 28);
		frmMeuCrud.getContentPane().add(btnProcurar);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {     /////////////////////******************
					
				int linha = tabela.getSelectedRow();
				
				try {
					dadostabela.absolute(linha+1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				try {
					ConfirmaAula.main(new String[] {dadostabela.getString("idaula")});
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  //*****************************
				frmMeuCrud.dispose();
			}
			
		});
	
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 50, 1000, 203);
		frmMeuCrud.getContentPane().add(scrollPane);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(SystemColor.textHighlight);
		btnVoltar.setBackground(SystemColor.textHighlightText);
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlaAluno.main(null);
				frmMeuCrud.dispose();
			}
		});
		btnVoltar.setBounds(10, 268, 122, 39);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		JButton btnRecomendarAula = new JButton("Recomendar Aula");
		btnRecomendarAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RecomendarAula.main(null);
				frmMeuCrud.dispose();
			}
		});
		btnRecomendarAula.setForeground(SystemColor.textHighlight);
		btnRecomendarAula.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRecomendarAula.setBackground(Color.WHITE);
		btnRecomendarAula.setBounds(747, 264, 189, 39);
		frmMeuCrud.getContentPane().add(btnRecomendarAula);
		
		dadostabela = new CRUDAulas().pegaAula();
		criaTabela(dadostabela);
	}// fim do método inicialize
	
	//responsavel por definir os parametros da tabela
	public void criaTabela(ResultSet dados) {
	String[] colunas = {"Matéria","Professor","Conteúdo","Local","Vagas"};
		ArrayList linhas = new ArrayList<>();
		
		try {
			while (dados.next()) {
				
				boolean continuar=false;
				java.util.Date data = new java.util.Date();
				java.util.Date hoje = new java.util.Date();
				
				try {
					data = dados.getDate("DiaUmaVez");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continuar=true;
					//e.printStackTrace();
				}
				
				//SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				
				if(data.before(hoje) && continuar==false) {
					continue;
				}
				
				linhas.add(new Object[] {
						//dados.getString("idAula"),
						Materia(dados.getString("materia")),
						NomeProf(Integer.parseInt(dados.getString("professor"))),
						dados.getString("conteudo"),
						//dados.getInt("segunda")==0?Boolean.FALSE:Boolean.TRUE,
						//dados.getInt("terca")==0?Boolean.FALSE:Boolean.TRUE,
						//dados.getInt("quarta")==0?Boolean.FALSE:Boolean.TRUE,
						//dados.getInt("quinta")==0?Boolean.FALSE:Boolean.TRUE,
						//dados.getInt("sexta")==0?Boolean.FALSE:Boolean.TRUE,
						//dados.getInt("sabado")==0?Boolean.FALSE:Boolean.TRUE,
						//dados.getInt("domingo")==0?Boolean.FALSE:Boolean.TRUE,
						//dados.getInt("cedo")==0?Boolean.FALSE:Boolean.TRUE,
						//dados.getInt("tarde")==0?Boolean.FALSE:Boolean.TRUE,
						//dados.getInt("noite")==0?Boolean.FALSE:Boolean.TRUE,
						dados.getString("local"),
						dados.getString("vagas")
						//dados.getString("DeManha"),
						//dados.getString("AteManha"),
						//dados.getString("DeTarde"),
						//dados.getString("AteTarde"),
						//dados.getString("DeNoite"),
						//dados.getString("AteNoite"),
						//dados.getString("DiaUmaVez"),
						//dados.getString("DeUmaVez"),
						//dados.getString("AteUmaVez"),
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
				+ "INNER JOIN aulas ON alunos.idaluno = aulas.professor Where professor = ?";
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
