package CRUD;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CRUDEmail {
	public void EmailVisuAulas() {
		
		String de = "projetojavasenai@gmail.com";
		boolean ssl = true;
		String SMTP ="smtp.gmail.com";
		String porta = "465";
		String usuario = "projetojavasenai@gmail.com";
		String senha = "senai123";

	try {
		SimpleEmail email = new SimpleEmail();
		email.setFrom(de);
		email.setSSLOnConnect(ssl);
		email.setHostName(SMTP);
		email.setSmtpPort(Integer.parseInt(porta));
		email.setAuthentication(usuario, senha);
		
		email.addTo("pedrovilelasgs@gmail.com");
		email.setSubject("Aula Alterada");
		email.setMsg("Sua aula foi alterada, entre no programa para mais informacoes");
		email.send();
	} catch (EmailException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		
		
		CRUDEmail s = new CRUDEmail();
		s.EmailVisuAulas();
		
		
	}
}
