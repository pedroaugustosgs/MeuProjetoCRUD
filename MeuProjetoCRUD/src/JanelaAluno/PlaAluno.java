package JanelaAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


import CRUD.Aluno;
import CRUD.CRUDAlunos;
import Menu_principal.Principal2;

import javax.swing.JButton;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Banco.Conexao;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.Component;

public class PlaAluno {
	
	
	public JFrame frmMeuCrud;
	public static JButton btnteraula;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public static String anterior = "";
	private JLabel label;
	public JTable tabela;
	public JTable tabelaREC;
	public static String idaluno=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		if(EntraAluno.vtt==2) {
			
		}else {
			idaluno = args[0];
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaAluno window = new PlaAluno();
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
	public PlaAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeuCrud = new JFrame();
		frmMeuCrud.setTitle("MEU CRUD - Alunos Cadastrados");               
		frmMeuCrud.setBounds(100, 100, 1043, 550);
		frmMeuCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuCrud.getContentPane().setLayout(null);
		frmMeuCrud.setResizable(false);
		frmMeuCrud.setLocationRelativeTo(null);
		
		
		EntraAluno.vtt=2;
		JButton btnNovaAula = new JButton("Dar Aula");
		btnNovaAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NovaAula.main(null);
				frmMeuCrud.dispose();
			}
		});
		
		tabelaREC = new JTable(); 
		tabelaREC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int linha = tabelaREC.getSelectedRow();
				
				ResultSet dadd=null;
				dadd = dadosTabelaREC();
			
				try {
					dadd.absolute(linha+1);
					VisualizaAulaREC.main(new String[] {dadd.getString("idaula")});
				} catch (SQLException s) {
					// TODO Auto-generated catch block
					s.printStackTrace();
				}
				
			
				frmMeuCrud.dispose();
			}
			
		});
		
		JScrollPane scrollPaneREC = new JScrollPane(tabelaREC);
		scrollPaneREC.setBounds(649, 136, 321, 331);
		frmMeuCrud.getContentPane().add(scrollPaneREC);
		
		JLabel lblAulasQueVai_1 = new JLabel("AULAS QUE VAI RECEBER");
		lblAulasQueVai_1.setForeground(Color.WHITE);
		lblAulasQueVai_1.setBounds(747, 107, 137, 33);
		frmMeuCrud.getContentPane().add(lblAulasQueVai_1);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int linha = tabela.getSelectedRow();
				
				ResultSet dadd=null;
				dadd = dadosTabela();
				try {
					dadd.first();
					dadd.absolute(linha+1);
				} catch (SQLException s) {
					// TODO Auto-generated catch block
					s.printStackTrace();
				}
				
				try {
					VisualizaAulas.main(new String[] {dadd.getString("idaula"),idaluno});
				} catch (SQLException q) {
					// TODO Auto-generated catch block
					q.printStackTrace();
				}  //*****************************
				frmMeuCrud.dispose();
			}
			
		});
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 136, 321, 331);
		frmMeuCrud.getContentPane().add(scrollPane);
		
		JLabel lblAulasQueVai = new JLabel("AULAS QUE VAI DAR");
		lblAulasQueVai.setForeground(Color.WHITE);
		lblAulasQueVai.setBounds(76, 98, 137, 33);
		frmMeuCrud.getContentPane().add(lblAulasQueVai);
		btnNovaAula.setForeground(SystemColor.textHighlight);
		btnNovaAula.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 18));
		btnNovaAula.setBackground(Color.WHITE);
		btnNovaAula.setBounds(401, 478, 121, 33);
		frmMeuCrud.getContentPane().add(btnNovaAula);
		
		label = new JLabel("New label");
		label.setBounds(705, -174, 1027, 511);
		frmMeuCrud.getContentPane().add(label);
		
		JLabel lblGerenciaSuasAulas = DefaultComponentFactory.getInstance().createLabel("Gerencie suas aulas aqui");
		lblGerenciaSuasAulas.setFont(new Font("Harrington", Font.BOLD | Font.ITALIC, 23));
		lblGerenciaSuasAulas.setForeground(SystemColor.textHighlightText);
		lblGerenciaSuasAulas.setBounds(389, 61, 288, 33);
		frmMeuCrud.getContentPane().add(lblGerenciaSuasAulas);
		
		btnteraula = new JButton("Solicitar Aula");
		btnteraula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerAula.main(null);
				frmMeuCrud.dispose();
			}
		});
		btnteraula.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 18));
		btnteraula.setForeground(SystemColor.textHighlight);
		btnteraula.setBackground(SystemColor.textHighlightText);
		
		btnteraula.setBounds(201, 478, 176, 33);
		frmMeuCrud.getContentPane().add(btnteraula);
		
		JButton btnconfig = new JButton("Editar Perfil");
		btnconfig.setForeground(SystemColor.textHighlight);
		btnconfig.setBackground(SystemColor.textHighlightText);
		btnconfig.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnconfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Config.voltar=1;
				frmMeuCrud.dispose();
				Config.main(null);
			}
		});
		btnconfig.setBounds(10, 478, 168, 33);
		frmMeuCrud.getContentPane().add(btnconfig);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(775, 339, 252, 219);
		frmMeuCrud.getContentPane().add(lblNewLabel_1);
		
		JLabel lblSuaPlataforma = DefaultComponentFactory.getInstance().createLabel("Sua Plataforma");
		lblSuaPlataforma.setForeground(SystemColor.textHighlightText);
		lblSuaPlataforma.setFont(new Font("Harrington", Font.BOLD | Font.ITALIC, 23));
		lblSuaPlataforma.setBackground(SystemColor.textHighlightText);
		lblSuaPlataforma.setBounds(448, 23, 176, 43);
		frmMeuCrud.getContentPane().add(lblSuaPlataforma);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Você realmente deseja sair?",
						"Alerta",
						JOptionPane.YES_NO_OPTION);
				
				
				if (resposta == JOptionPane.YES_OPTION) {
				frmMeuCrud.setVisible(false);
				Principal2.main(null);

				}
				if (resposta == JOptionPane.NO_OPTION) {
					
				}
			}
		});
		btnSair.setForeground(SystemColor.textHighlight);
		btnSair.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnSair.setBackground(Color.WHITE);
		btnSair.setBounds(532, 478, 106, 32);
		frmMeuCrud.getContentPane().add(btnSair);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1057, 522);
		frmMeuCrud.getContentPane().add(lblNewLabel);
		
		criaTabela(dadosTabela());
		criaTabelaREC(dadosTabelaREC());

		
	}// fim do método inicialize
	
	//responsavel por definir os parametros da tabela
	public void criaTabela(ResultSet dados) {
		String[] colunas = {"Matéria","Conteúdo","Local","Vagas"};
		ArrayList<Object> linhas = new ArrayList<>();
		
		try {
			while (dados.next()) {
				linhas.add(new Object[] {
						Materia(dados.getString("materia")),
						dados.getString("conteudo"),
						dados.getString("local"),
						dados.getString("vagas"),
						} );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao preencher a tabela");
		}
		
		ModeloDaTabela2 modelo = new ModeloDaTabela2(colunas, linhas);
		tabela.setModel(modelo);
		
		
		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		
		tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
	}
	
		//responsavel por definir os parametros da tabela
		public void criaTabelaREC(ResultSet dados) {
			String[] colunas = {"Matéria","Conteúdo","Local","Vagas"};
			ArrayList<Object> linhas = new ArrayList<>();
			
			try {
				while (dados.next()) {
					linhas.add(new Object[] {
							Materia(dados.getString("materia")),
							dados.getString("conteudo"),
							dados.getString("local"),
							dados.getString("vagas"),
							} );
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro ao preencher a tabela");
			}
			
			ModeloDaTabela modelo = new ModeloDaTabela(colunas, linhas);
			tabelaREC.setModel(modelo);
			
			
			tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
			tabela.getColumnModel().getColumn(0).setResizable(false);
			tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
			tabela.getColumnModel().getColumn(2).setPreferredWidth(70);
			tabela.getColumnModel().getColumn(2).setResizable(false);
			tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
			tabela.getColumnModel().getColumn(3).setResizable(false);
			
			tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
			centralizado.setHorizontalAlignment(SwingConstants.CENTER);
			
			tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
			tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
			tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
			tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
		}
	
	
	
	
	public ResultSet dadosTabela() {
		ResultSet dados=null;
		
		String sql="SELECT * FROM aulas WHERE professor = ?";
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, idaluno);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dados;
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
	
	
	public ResultSet dadosTabelaREC() {
		ResultSet dados=null;
		
		String sql="SELECT * FROM aulas INNER JOIN alunosconfirmados ON alunosconfirmados.idConfirmar = aulas.idaula WHERE idAluno=?";
		
		try {
			PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, idaluno);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dados;
	}
}
