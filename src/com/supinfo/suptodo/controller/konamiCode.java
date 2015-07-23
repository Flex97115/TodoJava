package com.supinfo.suptodo.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.supinfo.suptodo.vue.addUserVue;

public class konamiCode implements KeyListener {
	private int[] code = {38, 38, 40, 40, 37, 39, 37, 39, 66, 65};
	private int currentInput = 0;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if( e.getKeyCode()  == code[currentInput]){
			currentInput++;
				
			if (currentInput == code.length){
				System.out.println("KONAMI CODE !");
				currentInput = 0;
				addUserVue addUserFrame = new addUserVue();
				addUserFrame.setVisible(true);
				
			}
		} else {
			currentInput = 0;
		}
		
	}


}
