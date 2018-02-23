import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.undo.UndoManager;

public class RightClick {

	public static void rightClick(JTextField txtField) 
	 {
	     JPopupMenu popup = new JPopupMenu();
	     UndoManager undoManager = new UndoManager();
	     txtField.getDocument().addUndoableEditListener(undoManager);

	     Action undoAction = new AbstractAction("Undo") {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	             if (undoManager.canUndo()) {
	                 undoManager.undo();
	             }
	             else {
	                 JOptionPane.showMessageDialog(null,
	                         "Undoable: " + undoManager.canUndo() ,
	                         "Undo Status", 
	                         JOptionPane.INFORMATION_MESSAGE);
	             }
	         }
	     };

	    Action copyAction = new AbstractAction("Copy") {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	             txtField.copy();
	         }
	     };

	     Action cutAction = new AbstractAction("Cut") {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	             txtField.cut();
	         }
	     };

	     Action pasteAction = new AbstractAction("Paste") {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	             txtField.paste();
	         }
	     };

	     Action selectAllAction = new AbstractAction("Select All") {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	             txtField.selectAll();
	         }
	     };

	     popup.add (undoAction);
	     popup.addSeparator();
	     popup.add (cutAction);
	     popup.add (copyAction);
	     popup.add (pasteAction);
	     popup.addSeparator();
	     popup.add (selectAllAction);

	    txtField.setComponentPopupMenu(popup);
	 }
	
	public static void textArea(JTextArea txtArea) 
	 {
	     JPopupMenu popup = new JPopupMenu();
	     UndoManager undoManager = new UndoManager();
	     txtArea.getDocument().addUndoableEditListener(undoManager);

	     Action undoAction = new AbstractAction("Undo") {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	             if (undoManager.canUndo()) {
	                 undoManager.undo();
	             }
	             else {
	                 JOptionPane.showMessageDialog(null,
	                         "Undoable: " + undoManager.canUndo() ,
	                         "Undo Status", 
	                         JOptionPane.INFORMATION_MESSAGE);
	             }
	         }
	     };

	    Action copyAction = new AbstractAction("Copy") {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	        	 txtArea.copy();
	         }
	     };

	     Action cutAction = new AbstractAction("Cut") {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	        	 txtArea.cut();
	         }
	     };

	     Action pasteAction = new AbstractAction("Paste") {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	        	 txtArea.paste();
	         }
	     };

	     Action selectAllAction = new AbstractAction("Select All") {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	        	 txtArea.selectAll();
	         }
	     };

	     popup.add (undoAction);
	     popup.addSeparator();
	     popup.add (cutAction);
	     popup.add (copyAction);
	     popup.add (pasteAction);
	     popup.addSeparator();
	     popup.add (selectAllAction);

	     txtArea.setComponentPopupMenu(popup);
	 }

}
