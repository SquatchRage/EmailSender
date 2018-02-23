import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Grid {
	


	public void makingGrid(JPanel fieldPanel, JTextField one,JTextField two,JTextField three,JTextField four,JTextField five,JTextField six,JTextField seven,
			JLabel L1,JLabel L2,JLabel L3,JLabel L4,JLabel L5,JLabel L6,JLabel L7){
	
	
	GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(4, 4, 4, 4);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		fieldPanel.add(L1, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		fieldPanel.add(one, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		fieldPanel.add(L2, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		fieldPanel.add(two, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		fieldPanel.add(L3, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1;
		fieldPanel.add(three, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		fieldPanel.add(L4, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1;
		fieldPanel.add(four, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1;
		fieldPanel.add(L5, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1;
		fieldPanel.add(five, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 1;
		fieldPanel.add(L6, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.weightx = 1;
		fieldPanel.add(six, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.weightx = 1;
		fieldPanel.add(L7, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.weightx = 1;
		fieldPanel.add(seven, gbc);

	}
}