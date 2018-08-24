package splash;

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Banco.Conexao;
import Menu_principal.Principal2;

import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Toolkit;

public class Splash implements Runnable{

	private JFrame frmSplash;
	
	Thread tarefa;
	private JProgressBar barra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash window = new Splash();
					window.frmSplash.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create trhe application.
	 */
	public Splash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSplash = new JFrame();
		frmSplash.setResizable(false);
		frmSplash.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Imagem\\img\\students-cap.png"));
		frmSplash.getContentPane().setBackground(Color.BLACK);
		frmSplash.setBounds(100, 100, 584, 342);
		frmSplash.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sempre no centro do desktop
		frmSplash.setLocationRelativeTo(null);
		frmSplash.setTitle("SPLASH");
		frmSplash.getContentPane().setLayout(null);
		
		barra = new JProgressBar();			
		barra.setBounds(10, 272, 558, 14);
		frmSplash.getContentPane().add(barra);
		barra.setBackground(Color.WHITE);
        barra.setForeground(Color.GRAY); 
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(0, 219, 492, 32);
		frmSplash.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(472, 219, 106, 32);
		frmSplash.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(0, 46, 368, 24);
		frmSplash.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(333, 46, 245, 24);
		frmSplash.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel.setBounds(103, 81, 389, 129);
		frmSplash.getContentPane().add(lblNewLabel);
		
		
		tarefa = new Thread(Splash.this);
		tarefa.start(); // vai para run multitarefa
		
		
		
	}
	
	public void run() {
		barra.setValue(0);
		barra.setMaximum(2999);
		for(int x=0;x<3000;x++) {
			barra.setValue(x);
			//definir uma pause 
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//2segundos de pausa
			//apos os 2 segundos abre a janela principal
		}
		Principal2.main(null);
		frmSplash.dispose();
	}
	
}
