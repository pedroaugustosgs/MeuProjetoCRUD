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

public class Splash implements Runnable{

	private JFrame frame;
	
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
	public Splash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 584, 342);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//desabilita o botao de maximizar e minimizar
		frame.setResizable(false);
		//sempre no centro do desktop
		frame.setLocationRelativeTo(null);
		frame.setTitle("Meu projeto CRUD");
		frame.getContentPane().setLayout(null);
		
		barra = new JProgressBar();			
		barra.setBounds(10, 272, 558, 14);
		frame.getContentPane().add(barra);
		barra.setBackground(Color.WHITE);
        barra.setForeground(Color.GRAY); 
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_1.setBounds(0, 219, 492, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_2.setBounds(472, 219, 106, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_3.setBounds(0, 46, 368, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Imagem\\img\\Coluna grega.jpg"));
		lblNewLabel_4.setBounds(333, 46, 245, 24);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Imagem\\img\\A (1).png"));
		lblNewLabel.setBounds(41, 81, 492, 129);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(103, 194, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		tarefa = new Thread(Splash.this);
		tarefa.start(); // vai para run multitarefa
		
		
		
	}
	
	public void run() {
		barra.setValue(0);
		barra.setMaximum(3000);
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
		frame.dispose();
	}
	
}
