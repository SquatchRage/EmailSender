
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.*;
import java.util.*;
import java.util.List;

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

public class Frame extends JFrame implements ActionListener, DocumentListener{
	
	// Data Members
	
	 Container cp;
	 JButton sendButton;
	 JTextField serverDomainField, smtpDomainField, usernameField, sentFromField, sentDateField, subjectField, passwordField;
	 JTextField smtpPortField;
	 JTextArea messageBodyArea;
	 JPanel fieldPanel, buttonPanel;
	 JLabel domainLabel, portLabel, usernameLabel, sentFromLabel, sentDateLabel, passwordLabel, messageAreaLabel, subjectLabel;
	 static String server,  port, user, sent, subject, pass, messageFromArea;
	 static  int portInt;
	 static String senderDomain= "smtp.gmail.com";
	 static String senderUsername = "SquatchRage@gmail.com";
	 static String senderPassword = "myPassword123!";
	 static String portNumber = "465";
	 String dateField = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
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
		sentDateField.setText(dateField);
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
		
		
		 serverDomainField.getDocument().addDocumentListener(this);
		 smtpPortField.getDocument().addDocumentListener(this);
		 usernameField.getDocument().addDocumentListener(this);
		 passwordField.getDocument().addDocumentListener(this);
		 sentFromField.getDocument().addDocumentListener(this);
		 sentDateField.getDocument().addDocumentListener(this);
		 subjectField.getDocument().addDocumentListener(this);

	}
	
	public void changedUpdate(DocumentEvent e){checkLength();fieldCheck();}
	public void removeUpdate(DocumentEvent e){checkLength();}
	public void insertUpdate(DocumentEvent e){checkLength();}
	
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
	// does some regex checking on the fields...Calling sendMail() from here so the user cannot click the button unless form is correct
	public void fieldCheck() {
		
	       if(!serverDomainField.getText().matches("(?i)(\\w+)\\.(\\w+)\\.(com|gov|us|edu)")){
	           JOptionPane.showMessageDialog(null, "Server field not in correct format!"); 

	    	   }
	    	 
	       else if(!usernameField.getText().matches("(?i)[A-Z0-9]+@[A-Z0-9]+\\.(com|gov|us|edu)")){
	           JOptionPane.showMessageDialog(null, "User field not in correct format!"); 
	        } else
			try {
				sendMail();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
    
	    }

//---------------------------------------------------------------------------------------
	  
	@Override
	public void actionPerformed(ActionEvent AE) {
		
		 server = serverDomainField.getText().trim();
		 System.out.println(server);
		 port = smtpPortField.getText().trim();
		 portInt = Integer.parseInt(port);
		 user = usernameField.getText().trim();
		 sent = sentFromField.getText().trim();
		 subject = subjectField.getText().trim();
		 pass = passwordField.getText().trim();
		 messageFromArea = messageBodyArea.getText().trim();
		 
		
		 if(AE.getActionCommand().equals("Send")){
			
			
				fieldCheck();
		
		 }
	}
	

	public void sendMail () throws IOException{
		
		//fr =  new FileWriter("badEmails.txt");
		
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
		
				
		//creating a new files for the file readin, and write operations. , adding them to a DefualtListModel
		InternetAddress[] address;
		File file = new File("emails.txt");
		File goodEmail = new File("goodEmail.txt");
		File badEmail = new File("badEmail.txt");
		String email;
		DefaultListModel<String> goodEmails,badEmails;
		goodEmails = new DefaultListModel<String>();
		badEmails = new DefaultListModel<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
	     
	     
		//if emails.txt exits, save them to string; as long as email is not empty, send messages.
		if(file.exists()){
		email = br.readLine();
		while(email != null){
		
			try{
			
				message = new MimeMessage(session);

				message.setFrom(new InternetAddress(senderUsername));
				address =InternetAddress.parse(email);
				address[0].validate();
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject (subject);
				message.setText(messageFromArea);
				message.setSentDate(new GregorianCalendar(2010,1,1).getTime());  
				Transport.send(message);
				goodEmails.addElement(email);
				email = br.readLine();
				
			
				
			} catch (MessagingException e) {
				badEmails.addElement(email);
				
				email = br.readLine();
			
		}
	}
		//writing outMail. 
		 PrintWriter outEmail = new PrintWriter(goodEmail);
			for(int i=0;i<goodEmails.size();i++)
			{
				outEmail.println(goodEmails.getElementAt(i));
				System.out.println("Out file is writing.");
			}
			outEmail.close();
			outEmail = new PrintWriter(badEmail);
			for(int i=0;i<badEmails.size();i++)
			{
				outEmail.println(badEmails.getElementAt(i));
				System.out.println("Not writing out");
			}
			outEmail.close();
		}
			System.out.println("Message sent" );
			
	}
	
	/*
	
	void saveBadEmail(String[] arr){
		
		   try{
		          FileWriter fr = new FileWriter("badEmails.txt");
		          BufferedWriter br = new BufferedWriter(fr);
		          PrintWriter out = new PrintWriter(br);
		          for(int i=0; i<arr.length; i++){
		              if(arr[i] != null)
		                   
		            out.write(arr[i].toString());
		                out.write("\n");       
		          }
		          out.close();
		           
		           
		      }
		       
		      catch(IOException e){
		       System.out.println(e);   
		      }
		
	}
	
	void saveGoodEmail(){
		
		   try{
		          FileWriter fr = new FileWriter("goodEmails.txt");
		          BufferedWriter br = new BufferedWriter(fr);
		          PrintWriter out = new PrintWriter(br);
		          for(int i=0; i<toAddress.length; i++){
		              if(toAddress[i] != null)
		                   
		            out.write(toAddress[i].toString());
		                out.write("\n");       
		          }
		          out.close();
		           
		           
		      }
		       
		      catch(IOException e){
		       System.out.println(e);   
		      }
		
	}
		*/

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
