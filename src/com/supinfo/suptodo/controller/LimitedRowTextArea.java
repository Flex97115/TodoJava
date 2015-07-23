package com.supinfo.suptodo.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;

public class LimitedRowTextArea extends JTextArea {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int maxRows = 0;
		private int maxChar = 0;
		private int i = 0;
	   public void setMaxRows(int maxRows) {
	      this.maxRows = maxRows;
	   }

	   public int getMaxRows() {
	      return maxRows; 
	   }
	   
		public int getMaxChar() {
			return maxChar;
		}

		public void setMaxChar(int maxChar) {
			this.maxChar = maxChar;
		}
	   
	   public void replaceSelection(String content) {
		   if( getLineWrap()){
			   if ( i < getMaxChar()){
				   i++;
				   System.out.println("LINE WRAP " +i);
			   }
		   }
	       if (getMaxRows() > 0 && 
	           getLineCount() > getMaxRows())  {
	           this.getToolkit().beep();
	           return;
	       }
	       if( i >= getMaxChar()){
	    	   this.getToolkit().beep();
	           return;
	       }
	       super.replaceSelection(content);
	   }
	   
	   public void addDeleteAction(){
		   this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					if (i != 0){
						--i;
						System.out.println(i);
					}
				}
				
			}
		});
	   }

}
