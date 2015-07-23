package com.supinfo.suptodo.vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import com.supinfo.suptodo.controller.LimitedRowTextArea;
import com.supinfo.suptodo.controller.TextAreaListener;
import com.supinfo.suptodo.element.Todo;
import com.supinfo.suptodo.model.JdbcTodo;

public class EmployeeVue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LimitedRowTextArea txtWriteAComment;
	/**
	 * Create the frame.
	 */
	public EmployeeVue() {
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
		setBounds(100, 100, 415, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{99, 117, 161, -26, 56, -26, 0};
		gbl_contentPane.rowHeights = new int[]{42, 39, 0, 103, 101, 57, 17, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setMaximumSize(contentPane.getSize());
		tabbedPane.setName("My tabbedPane");
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 5;
		gbc_tabbedPane.gridwidth = 5;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		
		
		listAllTodo(tabbedPane);
		
	}
	
	private void listAllTodo( JTabbedPane tabbedPane ){
		ArrayList<Todo> myArray = (new JdbcTodo()).getAllTodo();
		if (!myArray.isEmpty()){
			for( int i = 0 ; i <= myArray.size()-1 ; i++ ){
				if(myArray.get(i).isDone() == false)
				
				addNewTab( tabbedPane, myArray.get(i).getId() , myArray.get(i).getDescription() , myArray.get(i).getComment());
			}
		}
	}
	
	private void addNewTab( JTabbedPane tabbedPane , int id , String description , String comment){
		
		
		JPanel panel = new JPanel();
		panel.setName(String.valueOf(id));
		panel.setSize(getSize());
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 135, 135, 78, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 57, 67, 24, 60, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		tabbedPane.addTab("Ticket #"+id, null, panel, null);
		JLabel lblTicket = new JLabel("Title: Ticket #"+id);
		GridBagConstraints gbc_lblTicket = new GridBagConstraints();
		gbc_lblTicket.anchor = GridBagConstraints.WEST;
		gbc_lblTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblTicket.gridx = 1;
		gbc_lblTicket.gridy = 0;
		panel.add(lblTicket, gbc_lblTicket);
		
		JLabel lblDescription = new JLabel("Description :");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.WEST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 2;
		panel.add(lblDescription, gbc_lblDescription);
		
		JTextArea ticketContent = new JTextArea(description);
		ticketContent.setEditable(false);
		ticketContent.setSize(new Dimension(getSize().width-50,getSize().height));
		ticketContent.setLineWrap(true);
		ticketContent.setWrapStyleWord(true);
		ticketContent.setBackground(null);
		GridBagConstraints gbc_ticketContent = new GridBagConstraints();
		gbc_ticketContent.anchor = GridBagConstraints.NORTHWEST;
		gbc_ticketContent.gridheight = 2;
		gbc_ticketContent.gridwidth = 3;
		gbc_ticketContent.insets = new Insets(0, 0, 5, 5);
		gbc_ticketContent.gridx = 1;
		gbc_ticketContent.gridy = 3;
		panel.add(ticketContent, gbc_ticketContent);
		
		JCheckBox chckbxMarkAsDone = new JCheckBox("Mark as done");
		chckbxMarkAsDone.setName(String.valueOf(id));
		GridBagConstraints gbc_chckbxMarkAsDone = new GridBagConstraints();
		gbc_chckbxMarkAsDone.anchor = GridBagConstraints.WEST;
		gbc_chckbxMarkAsDone.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMarkAsDone.gridx = 1;
		gbc_chckbxMarkAsDone.gridy = 5;
		panel.add(chckbxMarkAsDone, gbc_chckbxMarkAsDone);
		gbc_lblDescription.anchor = GridBagConstraints.BOTH;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 0);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 6;
		
		if(comment == null || comment.isEmpty()){
			txtWriteAComment = new LimitedRowTextArea();
			txtWriteAComment.setMaxRows(3);
			txtWriteAComment.setRows(2);
			txtWriteAComment.setName(String.valueOf(id));
			txtWriteAComment.setText("Write a comment...");
			txtWriteAComment.addMouseListener(new TextAreaListener());
			txtWriteAComment.setLineWrap(true);
			txtWriteAComment.setSize(new Dimension(getWidth()-50,getHeight()));
			txtWriteAComment.setMaximumSize(getSize());
			txtWriteAComment.setWrapStyleWord(true);
			txtWriteAComment.addDeleteAction();
			txtWriteAComment.setMaxChar(150);
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			txtWriteAComment.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			GridBagConstraints gbc_txtWriteAComment = new GridBagConstraints();
			gbc_txtWriteAComment.gridwidth = 3;
			gbc_txtWriteAComment.insets = new Insets(0, 0, 5, 5);
			gbc_txtWriteAComment.fill = GridBagConstraints.NORTHWEST;
			gbc_txtWriteAComment.gridx = 1;
			gbc_txtWriteAComment.gridy = 6;
			panel.add(txtWriteAComment, gbc_txtWriteAComment);
			txtWriteAComment.setColumns(10);
		} else {
			JTextArea txtComment = new JTextArea("Comment: \n"+comment);
			txtComment.setSize(new Dimension(getWidth()-50 ,getHeight()));
			txtComment.setLineWrap(true);
			txtComment.setEditable(false);
			txtComment.setBackground(null);
			GridBagConstraints gbc_txtComment = new GridBagConstraints();
			gbc_txtComment.gridwidth = 3;
			gbc_txtComment.anchor = GridBagConstraints.NORTHWEST;
			gbc_txtComment.insets = new Insets(0, 0, 5, 5);
			gbc_txtComment.gridx = 1;
			gbc_txtComment.gridy = 6;
			panel.add(txtComment, gbc_txtComment);	
		}
		
		JButton saveTicketBtn = new JButton("Save");
		saveTicketBtn.setName(String.valueOf(id));
		saveTicketBtn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object myObject = e.getSource();
				JButton myButton = (JButton) myObject;
					
				int btnId =  Integer.parseInt(myButton.getName());
				JTextArea myTextArea = null;
				JCheckBox myCheckBox = null;
				JPanel myPanel = null;
				
				Component[] tabCompTabbed = tabbedPane.getComponents();
				if(tabCompTabbed != null){
					for ( Component compPanel : tabCompTabbed ){
						if(compPanel.getName() != null){
							if(compPanel.getName().equals(myButton.getName())){
								if (compPanel instanceof JPanel){
									myPanel = (JPanel) compPanel;
									Component[] components = myPanel.getComponents();
									for( Component comp : components){
										if ( comp.getName() != null){
											
											if(comp.getName().equals(myButton.getName())) {
												if (comp instanceof JTextArea) {
													myTextArea = (JTextArea) comp;
												} else if ( comp instanceof JCheckBox){
													myCheckBox = (JCheckBox) comp;
												}
											}
										}
									}
								}
							}
						}
					}
						
				}
				boolean isUpdate = false;
				int numIsDone = 0;
				String comment = null;
				
				if ( myCheckBox != null ){
					if (myCheckBox.isSelected()){
						numIsDone = 1;
					}
				}
				if ( myTextArea != null){
					if (!myTextArea.getText().isEmpty() && !myTextArea.getText().equals("Write a comment...")){
						comment = myTextArea.getText();
					}
				}
				isUpdate = (new JdbcTodo()).updateTodo(btnId, numIsDone, comment);
				if(isUpdate){
					System.out.println("IS UPDATE");
					tabbedPane.removeAll();
					listAllTodo(tabbedPane);
				}
				
			}
		});
		GridBagConstraints gbc_saveTicketBtn = new GridBagConstraints();
		gbc_saveTicketBtn.fill = GridBagConstraints.BOTH;
		gbc_saveTicketBtn.gridwidth = 3;
		gbc_saveTicketBtn.insets = new Insets(0, 0, 0, 5);
		gbc_saveTicketBtn.gridx = 1;
		gbc_saveTicketBtn.gridy = 7;
		panel.add(saveTicketBtn, gbc_saveTicketBtn);
	}
}
