package CRUD;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CRUDEmail {
	public void EmailVisuAulas(String prof,String materia,String conteudo,String emails) {
		
		String de = "projetojavasenai@gmail.com";
		boolean ssl = true;
		String SMTP ="smtp.gmail.com";
		String porta = "465";
		String usuario = "projetojavasenai@gmail.com";
		String senha = "senai123";
		
		String msg="Sua aula com o professor "+prof+" de "+materia+" sobre "+conteudo+" sofreu uma alteração! "
				+ "Acesse o Approfe para mais informações!";
		
	try {
		SimpleEmail email = new SimpleEmail();
		email.setFrom(de);
		email.setSSLOnConnect(ssl);
		email.setHostName(SMTP);
		email.setSmtpPort(Integer.parseInt(porta));
		email.setAuthentication(usuario, senha);
		
		email.addTo(emails);
		email.setSubject("Aula Alterada");
		email.setMsg(msg);
		email.send();
	} catch (EmailException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
