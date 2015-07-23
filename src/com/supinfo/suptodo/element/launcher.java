package com.supinfo.suptodo.element;

import java.awt.EventQueue;

import com.supinfo.suptodo.vue.EmployeeVue;
import com.supinfo.suptodo.vue.ManagerVue;
import com.supinfo.suptodo.vue.LoginVue;

public class launcher {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ManagerVue managerFrame = new ManagerVue();
					managerFrame.setVisible(false);
					EmployeeVue employeeFrame = new EmployeeVue();
					employeeFrame.setVisible(false);
					LoginVue loginFrame = new LoginVue();
					loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void disconnect(){
		ManagerVue managerFrame = new ManagerVue();
		managerFrame.setVisible(false);
		EmployeeVue employeeFrame = new EmployeeVue();
		employeeFrame.setVisible(false);
		LoginVue loginFrame = new LoginVue();
		loginFrame.setVisible(true);
	}
}
