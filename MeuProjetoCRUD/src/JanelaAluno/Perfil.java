package JanelaAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.text.MaskFormatter;


import Banco.Conexao;
import CRUD.Aluno;
import CRUD.CRUDAlunos;
import CRUD.CRUDEmail;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Toolkit;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
public class Perfil extends Login {

	int ee;
	public JFrame frmMeuCrud;
	public String anterior = "";
	protected Object btnlocal;
	public static Aluno aluno;
	private MaskFormatter mascaraFone;
	public ResultSet dados = null;
	public static int voltar=0;
	//public static Aluno aluno;
	
	File file=null;
	FileInputStream fis=null;
	public String caminho=null;
	JFileChooser explorer = new JFileChooser();
	private JLabel lblFotoPerfil;
	private JLabel tftelefone;
	private JLabel tfIdade;
	private JLabel tfemail;
	private JLabel tfNome;
	
	public static String  idAluno=null;
	public static String  idAula=null;
	private JTextArea taMsg;

	/**
	 * Launch the application.
	 * @param idAula 
	 */
	public static void main(String[] args, String idAulas) {
		
		idAluno = args[0];
		idAula = idAulas;
		PlaAluno.voltaPerfil=1;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil window = new Perfil();
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
	public Perfil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeuCrud = new JFrame();
		frmMeuCrud.getContentPane().setBackground(Color.BLACK);
		frmMeuCrud.setIconImage(Toolkit.getDefaultToolkit().getImage(Perfil.class.getResource("/47 - Copia.png")));
		frmMeuCrud.setTitle("MEU CRUD - Alunos Cadastrados");
		frmMeuCrud.setBounds(100, 100, 787, 535);
		frmMeuCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuCrud.getContentPane().setLayout(null);
		frmMeuCrud.setResizable(false);
		frmMeuCrud.setLocationRelativeTo(null);
		
		JButton btnSalvar = new JButton("ENVIAR MENSAGEM");
		btnSalvar.setBackground(Color.LIGHT_GRAY);
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet aula=null;
				String sql ="SELECT * FROM aulas WHERE idAula=?";
				String msg=null;

				String mensagem=taMsg.getText().toString(); 
				if(mensagem.isEmpty() || mensagem.equals(" ")) {
					JOptionPane.showMessageDialog(null, "Entre com a mensagem a ser enviada!");
					return;
				}
				try {
					PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
					stmt.setString(1, idAula);
					aula = stmt.executeQuery();
					stmt.execute();
					stmt.close();
					
					aula.first();
					
					msg="O professor da sua aula de "+Materia(aula.getString("materia"))+" sobre "+aula.getString("conteudo")+" lhe enviou a "
							+ "seguinte mensagem: "+mensagem;
							
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String email = tfemail.getText().toString();
				
				CRUDEmail d = new CRUDEmail();
				d.EmailVisuAulas(email, msg);
				JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(-27, 101, 463, 35);
		frmMeuCrud.getContentPane().add(lblNewLabel_1);
		
		lblFotoPerfil = new JLabel("");
		lblFotoPerfil.setForeground(Color.WHITE);
		lblFotoPerfil.setBackground(Color.WHITE);
		lblFotoPerfil.setBounds(577, 146, 190, 189);
		frmMeuCrud.getContentPane().add(lblFotoPerfil);
		lblFotoPerfil.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
		
		try {
			mascaraFone = new MaskFormatter("## ####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTelefone.setBounds(18, 252, 86, 21);
		frmMeuCrud.getContentPane().add(lblTelefone);
		btnSalvar.setBounds(287, 467, 242, 39);
		frmMeuCrud.getContentPane().add(btnSalvar);
		
		JLabel lblSenha = new JLabel("Idade:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSenha.setBounds(18, 220, 60, 21);
		frmMeuCrud.getContentPane().add(lblSenha);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(18, 188, 74, 21);
		frmMeuCrud.getContentPane().add(lblEmail);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					VisualizaAulas.main(null);
					frmMeuCrud.dispose();
			}
		});
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(617, 467, 164, 39);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		JLabel lblNomeCtfnoompleto = DefaultComponentFactory.getInstance().createTitle("Nome:");
		lblNomeCtfnoompleto.setForeground(Color.WHITE);
		lblNomeCtfnoompleto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNomeCtfnoompleto.setBounds(18, 147, 70, 30);
		frmMeuCrud.getContentPane().add(lblNomeCtfnoompleto);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(623, 396, 46, 14);
		frmMeuCrud.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Chapeu azul.png"));
		lblNewLabel_3.setBounds(480, 42, 152, 58);
		frmMeuCrud.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_6.setBounds(1, 436, 389, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_8.setBounds(379, 436, 402, 26);
		frmMeuCrud.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel.setBounds(-12, -4, 453, 35);
		frmMeuCrud.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(433, -4, 389, 35);
		frmMeuCrud.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(428, 102, 394, 33);
		frmMeuCrud.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Imagem\\img\\A.png"));
		lblNewLabel_5.setBounds(123, 40, 406, 96);
		frmMeuCrud.getContentPane().add(lblNewLabel_5);
		
		tfNome = new JLabel("");
		tfNome.setForeground(Color.WHITE);
		tfNome.setBounds(84, 155, 221, 21);
		frmMeuCrud.getContentPane().add(tfNome);
		
		tfemail = new JLabel("");
		tfemail.setForeground(Color.WHITE);
		tfemail.setBounds(94, 191, 187, 20);
		frmMeuCrud.getContentPane().add(tfemail);
		
		tfIdade = new JLabel("");
		tfIdade.setForeground(Color.WHITE);
		tfIdade.setBounds(88, 222, 89, 23);
		frmMeuCrud.getContentPane().add(tfIdade);
		
		tftelefone = new JLabel("");
		tftelefone.setBackground(Color.BLACK);
		tftelefone.setForeground(Color.WHITE);
		tftelefone.setBounds(98, 254, 225, 22);
		frmMeuCrud.getContentPane().add(tftelefone);
		
		JLabel lblMensagem = new JLabel("Mensagem ou Motivo da Expuls\u00E3o:");
		lblMensagem.setForeground(Color.WHITE);
		lblMensagem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMensagem.setBounds(18, 284, 291, 21);
		frmMeuCrud.getContentPane().add(lblMensagem);
		
		taMsg = new JTextArea();
		taMsg.setBorder(new LineBorder(new Color(255, 255, 255)));
		taMsg.setForeground(Color.WHITE);
		taMsg.setBackground(Color.BLACK);
		taMsg.setLineWrap(true);
		taMsg.setBounds(18, 316, 501, 109);
		frmMeuCrud.getContentPane().add(taMsg);
		
		JButton btnExpulsar = new JButton("EXPULSAR");
		btnExpulsar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r = JOptionPane.showConfirmDialog(null, "Você deseja mesmo expulsar esse aluno de sua aula?");
				
				if(r==0) {
					String sql ="DELETE FROM alunosconfirmados WHERE idAluno=?";
					try {
						ResultSet dadoaula=null;
						String sql1="SELECT * FROM aulas WHERE idaula=?";  //pega dados da aula
						PreparedStatement stmt1 = Conexao.conexao.prepareStatement(sql1);
						stmt1.setString(1, idAula);
						dadoaula = stmt1.executeQuery();
						stmt1.execute();
						stmt1.close();
						
						ResultSet dadoalu = null;
						String sql2="SELECT * FROM alunos WHERE idAluno=?";
						PreparedStatement stmt2 = Conexao.conexao.prepareStatement(sql2);
						stmt2.setString(1, idAluno);   // pega dados do aluno
						dadoalu = stmt2.executeQuery();
						stmt2.execute();
						stmt2.close();
						
						
						PreparedStatement stmt = Conexao.conexao.prepareStatement(sql);
						stmt.setString(1, idAluno);
						stmt.execute();
						stmt.close();
						
						String motivo =taMsg.getText().toString();
						if(motivo==null || motivo.equals(" ")) {
							motivo = "Motivo não especificado!";
						}
						dadoaula.first();
						dadoalu.first();
						String msg= "Você foi expulso da aula de "+Materia(dadoaula.getString("materia")+" sobre "+dadoaula.getString("conteudo")+"!"
								+ "Motivos: "+motivo);
						
						CRUDEmail d = new CRUDEmail();
						d.EmailVisuAulas(dadoalu.getString("email"), msg);
						
						JOptionPane.showMessageDialog(null, "Aluno expulso com sucesso!");
						VisualizaAulas.main(null);
						frmMeuCrud.dispose();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnExpulsar.setForeground(Color.BLACK);
		btnExpulsar.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnExpulsar.setBackground(Color.LIGHT_GRAY);
		btnExpulsar.setBounds(11, 467, 166, 39);
		frmMeuCrud.getContentPane().add(btnExpulsar);
		//System.out.println(EntraAluno.volt);
		if(EntraAluno.volt==0) {
			PreencheTelaC();
		}else {
			PreencheTela();
		}
		
	}// fim do método inicialize
	
	public void PreencheTela() {
		String sql = "SELECT * FROM alunos WHERE idaluno=?";
		PreparedStatement stmt;
		try {
			stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, idAluno);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			if(dados.next()) {
				tfNome.setText(dados.getString("nome"));
				tfemail.setText(dados.getString("email"));
				tfIdade.setText(dados.getString("idade"));
				tftelefone.setText(dados.getString("fone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Blob blob=null;
		try {
			blob = dados.getBlob("foto");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedImage bi = null;
		InputStream is = null;
		if(blob!=null) {
			try {
				is = blob.getBinaryStream();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				bi = ImageIO.read(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 ImageIcon icone = new ImageIcon(bi);
			 icone.setImage(icone.getImage().getScaledInstance(168, 138, 100));
			 lblFotoPerfil.setIcon(icone);	
		}
	}
	public void PreencheTelaC() {
		String sql = "SELECT * FROM alunos WHERE idaluno=?";
		PreparedStatement stmt;
		try {
			stmt = Conexao.conexao.prepareStatement(sql);
			stmt.setString(1, Cadastrar_login.idC);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			if(dados.next()) {
				tfNome.setText(dados.getString("nome"));
				tfemail.setText(dados.getString("email"));
				tfIdade.setText(dados.getString("idade"));
				tftelefone.setText(dados.getString("fone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Blob blob=null;
		try {
			blob = dados.getBlob("foto");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedImage bi = null;
		InputStream is = null;
		if(blob!=null) {
			try {
				is = blob.getBinaryStream();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				bi = ImageIO.read(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 ImageIcon icone = new ImageIcon(bi);
			 icone.setImage(icone.getImage().getScaledInstance(168, 138, 100));
			 lblFotoPerfil.setIcon(icone);	
	}
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
