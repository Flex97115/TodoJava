package com.supinfo.suptodo.vue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import com.supinfo.suptodo.controller.LimitedRowTextArea;
import com.supinfo.suptodo.controller.TextAreaListener;
import com.supinfo.suptodo.controller.konamiCode;
import com.supinfo.suptodo.model.JdbcTodo;

public class ManagerVue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LimitedRowTextArea addTodoTextArea;
	private JButton addTodoBtn;
	 
	/**
	 * Create the frame.
	 */
	public ManagerVue() {
		setTitle("SUPTODO");
addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				LoginVue loginFrame = new LoginVue();
				loginFrame.setVisible(true);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		setBounds(100, 100, 450, 300);
		addKeyListener(new konamiCode());
		setResizable(false);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 336, 50 };
		gbl_contentPane.rowHeights = new int[]{0, 0, 114, 0, 0 , 10};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel pageTitle = new JLabel("Write new Todo");
		GridBagConstraints gbc_pageTitle = new GridBagConstraints();
		gbc_pageTitle.insets = new Insets(0, 0, 5, 5);
		gbc_pageTitle.gridx = 1;
		gbc_pageTitle.gridy = 0;
		contentPane.add(pageTitle, gbc_pageTitle);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		addTodoTextArea = new LimitedRowTextArea();
		addTodoTextArea.setMaxRows(4);
		addTodoTextArea.setMaxChar(200);
		addTodoTextArea.setLineWrap(true);
		addTodoTextArea.setTabSize(5);
		addTodoTextArea.setText("Enter new Todo ...");
		addTodoTextArea.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		addTodoTextArea.addMouseListener(new TextAreaListener());
		addTodoTextArea.addKeyListener(new konamiCode());
		GridBagConstraints gbc_addTodoTextArea = new GridBagConstraints();
		gbc_addTodoTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_addTodoTextArea.fill = GridBagConstraints.BOTH;
		gbc_addTodoTextArea.gridx = 1;
		gbc_addTodoTextArea.gridy = 2;
		contentPane.add(addTodoTextArea, gbc_addTodoTextArea);
		
		addTodoBtn = new JButton("Add Todo");
		addTodoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isDone = false;
				JdbcTodo jdbcTodo = new JdbcTodo();
				if (!addTodoTextArea.getText().isEmpty()){
					isDone = jdbcTodo.addTodo(addTodoTextArea.getText());
				}
				if (isDone){
					JOptionPane.showMessageDialog(null, "Todo sucessfully added");
					addTodoTextArea.setText("");
				}
			}
			
		});
		GridBagConstraints gbc_addTodoBtn = new GridBagConstraints();
		gbc_addTodoBtn.insets = new Insets(0, 0, 0, 5);
		gbc_addTodoBtn.gridx = 1;
		gbc_addTodoBtn.gridy = 4;
		contentPane.add(addTodoBtn, gbc_addTodoBtn);
	}

}
