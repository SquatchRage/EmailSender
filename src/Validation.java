import java.io.IOException;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validation extends InputVerifier {

	public boolean verify( JComponent input) { 
        String                str; 

        int                    store; 
        boolean             	type; 
        JTextField            textField; 
         
        textField = (JTextField) input; 
        str = textField.getText().trim(); 
         
                 
        try 
        { 
 
        	store = Integer.parseInt(str); 
             
            if(store < 0 || store > 65535) 
            { 
                 
            	type = false; 
                 
            } 
 
            else  { 
                 
            	type = true; 
                  } 
             
        } 
             
        catch(NumberFormatException e)  { 
         	type = false; 
                    } 
             
         
        if(type == false){ 
     
            JOptionPane.showMessageDialog(null, "Integer values between 0-65535 only!"); 
         
        } 
         
         
        return type; 
         
    	}
	
	
	
    }
