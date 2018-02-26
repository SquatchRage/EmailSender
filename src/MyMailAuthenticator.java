

import javax.mail.PasswordAuthentication;

public class MyMailAuthenticator extends javax.mail.Authenticator{

	String authSenderUsername;
	String authSenderPassword;	
	
	public MyMailAuthenticator(String authSenderUsername, String authSenderPassword ){
		
		this.authSenderUsername = authSenderUsername;
		this.authSenderPassword = authSenderPassword;
	
		
	}
	
	protected PasswordAuthentication getPasswordAuthentication(){
		
		return new PasswordAuthentication(authSenderUsername, authSenderPassword);
		
	}
	
	
}
