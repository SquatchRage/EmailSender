
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
import java.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Frame extends JFrame implements ActionListener{
	
	// Data Members
	
	 Container cp;
	 JButton sendButton;
	 JTextField serverDomainField, smtpDomainField, usernameField, sentFromField, sentDateField, subjectField, passwordField;
	 JTextField smtpPortField;
	 JTextArea messageBodyArea;
	 JPanel fieldPanel, buttonPanel;
	 JLabel domainLabel, portLabel, usernameLabel, sentFromLabel, sentDateLabel, passwordLabel, messageAreaLabel, subjectLabel;
	 static String server,  port, user, sent, date, subject, pass, messageFromArea;
	 static  int portInt;
	 static String senderDomain= "smtp.gmx.com";
	 static String senderUsername = "SquatchRage@gmx.com";
	 static String senderPassword = "myPassword123!";
	 static String portNumber = "465";
	 RightClick r = new RightClick();
	 Grid grid = new Grid();

	 
	
	public Frame(){
		
		sendButton = new JButton("Send");
		sendButton.addActionListener(this);
		sendButton.setActionCommand("Send");
		sendButton.setEnabled(false);
		
		serverDomainField = new JTextField(20);
		serverDomainField.setText(senderDomain);
		serverDomainField.requestFocus();
		
		smtpPortField = new JTextField(20);
		smtpPortField.setInputVerifier(new Validation());
		smtpPortField.setText(portNumber);
		
		usernameField = new JTextField(20);
		usernameField.setText(senderUsername);
		
		passwordField = new JPasswordField(20);
		passwordField.setText(senderPassword);
		
		sentFromField = new JTextField(20);
		sentDateField = new JTextField(20);
		subjectField = new JTextField(20);
		messageBodyArea = new JTextArea(100,100);
		JScrollPane scrollPane = new JScrollPane(messageBodyArea);  
		
		domainLabel = new JLabel("Domain: ");
		portLabel = new JLabel("Port: ");
		usernameLabel = new JLabel("Username: ");
		sentFromLabel = new JLabel("Sent From: ");
		sentDateLabel = new JLabel("Date: ");
		passwordLabel = new JLabel("Password: ");
		messageAreaLabel = new JLabel("Message: ");
		subjectLabel = new JLabel("Subject: ");
		
		// Adds Right Click Functionality to all Fields
		RightClick.rightClick(serverDomainField);
		RightClick.rightClick(smtpPortField);
		RightClick.rightClick(usernameField);
		RightClick.rightClick(sentFromField);
		RightClick.rightClick(sentDateField);
		RightClick.rightClick(subjectField);
		RightClick.rightClick(passwordField);
		RightClick.textArea(messageBodyArea);
	
		fieldPanel = new JPanel(new GridBagLayout());
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
		
		// GUI Placement
		grid.makingGrid(fieldPanel, serverDomainField, smtpPortField, usernameField, passwordField, sentFromField, sentDateField, subjectField, 
				domainLabel, portLabel, usernameLabel, passwordLabel, sentFromLabel, sentDateLabel,  subjectLabel);
		
			buttonPanel.add(sendButton);

		cp = getContentPane();
		cp.setSize(900, 900);
		
		cp.add(fieldPanel, BorderLayout.WEST);
		cp.add(scrollPane, BorderLayout.CENTER);
		cp.add(buttonPanel, BorderLayout.SOUTH);
		setUp();
		
//------------------------  Using Listener to disable send button untl all fields are filled.	
		
		
		 serverDomainField.getDocument().addDocumentListener(new DocumentListener(){
			  public void changedUpdate(DocumentEvent e){checkLength();}
			  public void removeUpdate(DocumentEvent e){checkLength();}
			  public void insertUpdate(DocumentEvent e){checkLength();}
			});
		 smtpPortField.getDocument().addDocumentListener(new DocumentListener(){
			  public void changedUpdate(DocumentEvent e){checkLength();}
			  public void removeUpdate(DocumentEvent e){checkLength();}
			  public void insertUpdate(DocumentEvent e){checkLength();}
			});
		 usernameField.getDocument().addDocumentListener(new DocumentListener(){
			  public void changedUpdate(DocumentEvent e){checkLength();}
			  public void removeUpdate(DocumentEvent e){checkLength();}
			  public void insertUpdate(DocumentEvent e){checkLength();}
			});
		 passwordField.getDocument().addDocumentListener(new DocumentListener(){
			  public void changedUpdate(DocumentEvent e){checkLength();}
			  public void removeUpdate(DocumentEvent e){checkLength();}
			  public void insertUpdate(DocumentEvent e){checkLength();}
			});
		 sentFromField.getDocument().addDocumentListener(new DocumentListener(){
			  public void changedUpdate(DocumentEvent e){checkLength();}
			  public void removeUpdate(DocumentEvent e){checkLength();}
			  public void insertUpdate(DocumentEvent e){checkLength();}
			});
		 sentDateField.getDocument().addDocumentListener(new DocumentListener(){
			  public void changedUpdate(DocumentEvent e){checkLength();}
			  public void removeUpdate(DocumentEvent e){checkLength();}
			  public void insertUpdate(DocumentEvent e){checkLength();}
			});
		 subjectField.getDocument().addDocumentListener(new DocumentListener(){
			  public void changedUpdate(DocumentEvent e){checkLength();}
			  public void removeUpdate(DocumentEvent e){checkLength();}
			  public void insertUpdate(DocumentEvent e){checkLength();}
			});

	}
	
	public void checkLength(){
		
		int count = 0;
		
		if(serverDomainField.getDocument().getLength() > 0){
				count++;		}
		if(smtpPortField.getDocument().getLength() > 0){
			count++;		}
		if(usernameField.getDocument().getLength() > 0){
			count++;		}
		if(passwordField.getDocument().getLength() > 0){
			count++;		}
		if(sentFromField.getDocument().getLength() > 0){
			count++;		}
		if(sentDateField.getDocument().getLength() > 0){
			count++;		}
		if(subjectField.getDocument().getLength() > 0){
			count++;		}
		
		if ( count == 7){
			
			sendButton.setEnabled(true);
		}
		
		else { sendButton.setEnabled(false); }
	}
	
//---------------------------------------------------------------------------------------
	  
	@Override
	public void actionPerformed(ActionEvent AE) {
		
		 server = serverDomainField.getText().trim();
		 port = smtpPortField.getText().trim();
		 portInt = Integer.parseInt(port);
		 user = usernameField.getText().trim();
		 sent = sentFromField.getText().trim();
		 date = sentDateField.getText().trim();
		 subject = subjectField.getText().trim();
		 pass = passwordField.getText().trim();
		 messageFromArea = messageBodyArea.getText().trim();
		 
		 if(AE.getActionCommand().equals("Send")){
			 try {
				sendMail();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//System.out.println(Arrays.toString(InputOutput.arr));

			 
		 }
			
	}
	
	public void sendMail () throws IOException{
		
		InputOutput.readIn();
		
		MyMailAuthenticator authenticator;
		Properties sessionProperties;
		Session session;
		Message message;
		
		authenticator = new MyMailAuthenticator(senderUsername, senderPassword);
		System.out.println("Got an authenticator" + authenticator);
		
		sessionProperties = new Properties();
		sessionProperties.put("mail.smtp.host", senderDomain);
		sessionProperties.put("mail.smtp.socketFactory.port", portInt);
		sessionProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		sessionProperties.put("mail.smtp.auth", "true");
		sessionProperties.put("mail.smtp.port", portInt);
		sessionProperties.put("mail.stmp.ssl.enable", "true");
		sessionProperties.put("mail.tranport.protocol", "smtps");
		
		session = Session.getDefaultInstance(sessionProperties, authenticator);
		session.setDebug(true);
		System.out.println("got a session");
		
		int temp = InputOutput.arr.length;
		
		try{
			
			message = new MimeMessage(session);

			message.setFrom(new InternetAddress(senderUsername));
			InternetAddress[] toAddress = new InternetAddress[temp];
			for(int i = 0; i < temp; i++){
				
				toAddress[i] = new InternetAddress( InputOutput.arr[i]);
			}
			
			for(int i = 0; i < toAddress.length; i++){
			message.addRecipient(Message.RecipientType.TO, toAddress[i]);} 
			message.setSubject (subject);
			message.setText(messageFromArea);
			message.setSentDate(new GregorianCalendar(201,1,1).getTime());  
		
			
			Transport.send(message);
			System.out.println("Message sent" );
		}
		catch (MessagingException e){
				throw new RuntimeException (e);
			} 
		
		}	
	
	
	
	

	
	 void setUp ()
	 {
	     Toolkit tk;
	     Dimension d;
	     
	     setDefaultCloseOperation (EXIT_ON_CLOSE);
	     
	     tk = Toolkit.getDefaultToolkit ();
	     d = tk.getScreenSize ();
	     
	     setSize (d.width/3, d.height/3);
	     setLocation (d.width/4, d.height/4);
	     setTitle ("Squatch Mail");
	     setVisible (true);
	 	}

}
