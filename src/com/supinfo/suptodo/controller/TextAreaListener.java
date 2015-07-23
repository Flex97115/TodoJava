package com.supinfo.suptodo.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaListener implements MouseListener {
	private int i = 0;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if ( i == 0 ){
			Object myObject = e.getSource();
			if( myObject instanceof JTextArea) {
				try {
					JTextArea myTextArea = (JTextArea) myObject;
					myTextArea.setText("");
					} catch (Exception except) {
						// TODO Auto-generated catch block
						except.printStackTrace();	
					}
			} else if ( myObject instanceof JTextField ) {
					
				try {
					JTextField myTextField = (JTextField) myObject;
					myTextField.setText("");
				} catch (Exception except2) {
					// TODO Auto-generated catch block
					except2.printStackTrace();
				}
			}
			i++;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
