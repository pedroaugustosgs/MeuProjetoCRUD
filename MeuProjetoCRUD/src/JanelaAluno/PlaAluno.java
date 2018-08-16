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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	public static String anterior = "";
	public JTable tabela;
	public JTable tabelaREC;
	public static String idaluno=null;
	
	public String ids[]= new String[100];
	int cont=0;
	private JScrollPane scrollPane;
	private JScrollPane scrollPaneREC;

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
		frmMeuCrud.getContentPane().setBackground(Color.BLACK);
		frmMeuCrud.setTitle("MEU CRUD - Alunos Cadastrados");               
		frmMeuCrud.setBounds(100, 100, 1090, 640);
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
		
		btnteraula = new JButton("Solicitar Aula");
		btnteraula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerAula.main(null);
				frmMeuCrud.dispose();
			}
		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Imagem\\img\\Bot\u00E3o png.png"));
		label.setBounds(416, 323, 213, 162);
		frmMeuCrud.getContentPane().add(label);
		btnteraula.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnteraula.setForeground(Color.BLACK);
		btnteraula.setBackground(SystemColor.textHighlightText);
		
		btnteraula.setBounds(433, 378, 176, 33);
		frmMeuCrud.getContentPane().add(btnteraula);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\Bot\u00E3o png.png"));
		lblNewLabel_5.setBounds(433, 146, 200, 201);
		frmMeuCrud.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(0, 82, 407, 43);
		frmMeuCrud.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(396, 82, 469, 43);
		frmMeuCrud.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(837, 81, 237, 44);
		frmMeuCrud.getContentPane().add(lblNewLabel_6);
		
		scrollPaneREC = new JScrollPane(tabelaREC);
		scrollPaneREC.setBounds(724, 167, 350, 331);
		frmMeuCrud.getContentPane().add(scrollPaneREC);
		
		JLabel lblAulasQueVai_1 = new JLabel("AULAS COMO ALUNO");
		lblAulasQueVai_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAulasQueVai_1.setForeground(Color.WHITE);
		lblAulasQueVai_1.setBounds(792, 123, 256, 33);
		frmMeuCrud.getContentPane().add(lblAulasQueVai_1);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int linha = tabela.getSelectedRow();
				
				/*ResultSet dadd=null;
				dadd = dadosTabela();
				try {
					//dadd.first();
					dadd.absolute(linha+1);
				} catch (SQLException s) {
					// TODO Auto-generated catch block
					s.printStackTrace();
				}*/
				
				
					System.out.println(ids[tabela.getSelectedRow()]);
					VisualizaAulas.main(new String[] {ids[tabela.getSelectedRow()],idaluno});
				
				frmMeuCrud.dispose();
			}
			
		});
		
		scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 167, 321, 331);
		frmMeuCrud.getContentPane().add(scrollPane);
		
		JLabel lblAulasQueVai = new JLabel("AULAS COMO PROFESSOR");
		lblAulasQueVai.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAulasQueVai.setForeground(Color.WHITE);
		lblAulasQueVai.setBounds(51, 123, 303, 33);
		frmMeuCrud.getContentPane().add(lblAulasQueVai);
		btnNovaAula.setForeground(Color.BLACK);
		btnNovaAula.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNovaAula.setBackground(Color.WHITE);
		btnNovaAula.setBounds(441, 220, 168, 33);
		frmMeuCrud.getContentPane().add(btnNovaAula);
		
		JButton btnconfig = new JButton("Editar Perfil");
		btnconfig.setForeground(Color.BLACK);
		btnconfig.setBackground(SystemColor.textHighlightText);
		btnconfig.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnconfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Config.voltar=1;
				frmMeuCrud.dispose();
				Config.main(null);
			}
		});
		btnconfig.setBounds(36, 569, 168, 33);
		frmMeuCrud.getContentPane().add(btnconfig);
		
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
		btnSair.setForeground(Color.BLACK);
		btnSair.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnSair.setBackground(Color.WHITE);
		btnSair.setBounds(942, 569, 106, 32);
		frmMeuCrud.getContentPane().add(btnSair);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(0, 509, 425, 33);
		frmMeuCrud.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(408, 509, 414, 33);
		frmMeuCrud.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(816, 509, 268, 33);
		frmMeuCrud.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Imagem\\img\\Money.png"));
		lblNewLabel_7.setBounds(317, 24, 475, 61);
		frmMeuCrud.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\1.png"));
		lblNewLabel_8.setBounds(330, 167, 394, 331);
		frmMeuCrud.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\1.png"));
		lblNewLabel_9.setBounds(-16, 123, 347, 45);
		frmMeuCrud.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\1.png"));
		lblNewLabel_10.setBounds(707, 123, 338, 45);
		frmMeuCrud.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("D:\\Bot\u00E3o png.png"));
		lblNewLabel_11.setBounds(517, 281, 46, 14);
		frmMeuCrud.getContentPane().add(lblNewLabel_11);
		
		criaTabela(dadosTabela());
		criaTabelaREC(dadosTabelaREC());

		
	}// fim do método inicialize
	
	//responsavel por definir os parametros da tabela
	public void criaTabela(ResultSet dados) {
		String[] colunas = {"Matéria","Conteúdo","Local","Vagas"};
		ArrayList<Object> linhas = new ArrayList<>();
		
		try {
			while (dados.next()) {
				
				boolean continuar=false;
				Date data = new Date();
				Date hoje = new Date();
				
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
				
				ids[cont++]=dados.getString("idaula");
				
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
					
					/*boolean continuar=false;
					Date data = new Date();
					Date hoje = new Date();
					
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
					}*/
					
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
