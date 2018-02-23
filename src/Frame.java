import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener{
	
	// Data Members
	
	 Container cp;
	 JButton sendButton;
	 JTextField serverDomainField;
	 JTextField smtpPortField;
	 JTextField usernameField;
	 JTextField sentFromField;
	 JTextField sentDateField;
	 JTextField subjectField;
	 JPasswordField passwordField;
	 JTextArea messageBodyArea;
	 JPanel fieldPanel;
	 JPanel buttonPanel;
	 JPanel textAreaPanel;
	 JLabel domainLabel;
	 JLabel portLabel;
	 JLabel usernameLabel;
	 JLabel sentFromLabel;
	 JLabel setnDateLabel;
	 JLabel passwordLabel;
	 JLabel messageAreaLabel;
	 static String senderDomain= "smtp.gmx.com";
	 static String senderUsername = "larue@gmx.us";
	 static String senderPassword = "larue321";
	 static String portNUmber = "465";

	
	public Frame(){
		
		sendButton = new JButton("Send");
		sendButton.addActionListener(this);
		sendButton.setActionCommand("Send");
		
		serverDomainField = new JTextField(20);
		smtpPortField = new JTextField(20);
		smtpPortField.setInputVerifier(new Validation());
		usernameField = new JTextField(20);
		passwordField = new JPasswordField(20);
		sentFromField = new JTextField(20);
		sentDateField = new JTextField(20);
		subjectField = new JTextField(20);
		messageBodyArea = new JTextArea();
		
		fieldPanel = new JPanel(new GridBagLayout());
		textAreaPanel = new JPanel(new FlowLayout());
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
		
		GridBagConstraints gbc = new GridBagConstraints();
		 
			gbc.insets = new Insets(4, 4, 4, 4);

			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1;
			fieldPanel.add(domainLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.weightx = 1;
			fieldPanel.add(serverDomainField, gbc);

			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.weightx = 1;
			fieldPanel.add(portLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.weightx = 1;
			fieldPanel.add(smtpPortField, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			fieldPanel.add(usernameLabel, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.weightx = 1;
			fieldPanel.add(usernameField, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.gridwidth = 1;
			fieldPanel.add(passwordLabel, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 3;
			gbc.weightx = 1;
			fieldPanel.add(passwordField, gbc);
			// changes positions from here down, not in alignment
			gbc.gridx = 2;
			gbc.gridy = 3;
			gbc.weightx = 1;
			fieldPanel.add(sentFromLabel, gbc);
			
			gbc.gridx = 3;
			gbc.gridy = 3;
			gbc.weightx = 1;
			fieldPanel.add(sentFromField, gbc);

			buttonPanel.add(saveButton);
			buttonPanel.add(cancelButton);
			
		 cp = getContentPane();
		 cp.add(fieldPanel, BorderLayout.WEST);
		 cp.add(buttonPanel, BorderLayout.SOUTH);
		 
	
				
		cp = getContentPane();
		cp.setSize(900, 900);
		
		cp.add(fieldPanel, BorderLayout.NORTH);
		cp.add(textAreaPanel, BorderLayout.CENTER);
		cp.add(buttonPanel, BorderLayout.SOUTH);
		setUp();
		
		 addWindowListener( new WindowAdapter() {
	    	    public void windowOpened( WindowEvent e ){
	    	       // urlField.requestFocus();
	    	    }
	    	}); 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	 void setUp ()
	 {
	     Toolkit tk;
	     Dimension d;
	     
	     setDefaultCloseOperation (EXIT_ON_CLOSE);
	     
	     tk = Toolkit.getDefaultToolkit ();
	     d = tk.getScreenSize ();
	     
	     setSize (d.width/2, d.height/2);
	     setLocation (d.width/4, d.height/4);
	     setTitle ("Image Finder");
	     setVisible (true);
	 	}

}
