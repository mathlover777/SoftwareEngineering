package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5515555170738807996L;
	Login login;
	private Bridge bridge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					/*
					 * frame.setExtendedState(frame.getExtendedState() |
					 * JFrame.MAXIMIZED_BOTH);
					 */
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		// setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Hall Management Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 391);
		// getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		loginScreen();
	}

	private void loginScreen() {
		// TODO Auto-generated method stub
		login = new Login();
		setContentPane(login);
		invalidate();
		validate();
		login.getRootPane().setDefaultButton(login.btnGo);
		login.btnGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// System.out.println(1);
				if (Integer.parseInt(login.getSelectedIndex().toString()) != 5) {
					String inputPassword = login.getPasswordInput();
					String inputUserID = login.getUserID();
					passwordValidate(Integer.parseInt(login.getSelectedIndex()
							.toString()), inputUserID, inputPassword);
				} else {
					JOptionPane.showMessageDialog(null, "Select an option!");
				}
			}
		});

	}

	protected void passwordValidate(int selectedIndex, String inputUserID,
			String inputPassword) {
		// System.out.println(1);
		// check password validation
		//startWork(selectedIndex, inputUserID, "msh");
		if (selectedIndex == 0) {
			// HMC
			if(inputPassword.equals("HMC") && inputUserID.equals("HMC")){
				startWork(0, null, null);
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid userID or password!");
			}

		} else if (selectedIndex == 1) {
			// Warden
			String query = "SELECT  `hallcode` ,  `password` FROM  `hms`.`wardenlist` WHERE  `id` LIKE  '"
					+ inputUserID + "'";
			ResultSet rs = resultQuery(query);
			try {
				rs.first();
				if (rs.getString("password").equals(inputPassword)) {
					startWork(1, inputUserID, rs.getString("hallcode"));
				}
				else{
					JOptionPane.showMessageDialog(null,
							"Invalid User ID or password!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,
						"Invalid User ID or password!");
			}
		} else if (selectedIndex == 2) {
			// Student
			String query = "SELECT  `password` FROM  `hms`.`studentdetail` WHERE `id` LIKE '"
					+ inputUserID + "'";
			ResultSet rs = resultQuery(query);
			try {
				rs.first();
				if (rs.getString("password").equals(inputPassword)) {
					startWork(2, inputUserID, null);
				}
				else{
					JOptionPane.showMessageDialog(null,
							"Invalid User ID or password!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,
						"Invalid User ID or password!");
			}
		} else if (selectedIndex == 3) {
			// Clerk
			String query = "SELECT  `hallcode` ,  `password` FROM  `hms`.`workerlist` WHERE  `id` LIKE  '"
					+ inputUserID + "' AND `type` LIKE 'clerk'";
			ResultSet rs = resultQuery(query);
			try {
				rs.first();
				if (rs.getString("password").equals(inputPassword)) {
					startWork(3, inputUserID, rs.getString("hallcode"));
				}
				else{
					JOptionPane.showMessageDialog(null,
							"Invalid User ID or password!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,
						"Invalid User ID or password!");
			}
		} else if (selectedIndex == 4) {
			// Mess Manager
			String query = "SELECT  `hallcode` ,  `password` FROM  `hms`.`workerlist` WHERE  `id` LIKE  '"
					+ inputUserID + "' AND `type` LIKE 'MessManager'";
			ResultSet rs = resultQuery(query);
			try {
				rs.first();
				if (rs.getString("password").equals(inputPassword)) {
					startWork(4, inputUserID, rs.getString("hallcode"));
				}
				else{
					JOptionPane.showMessageDialog(null,
							"Invalid User ID or password!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,
						"Invalid User ID or password!");
			}
			
		}
	}

	private void startWork(int selectedIndex, String inputUserID,
			String hallCode) {
		// TODO Auto-generated method stub
		if (selectedIndex == 0) {
			// HMC
			HMCwin w = new HMCwin();
			setContentPane(w);
			w.btnLogout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					loginScreen();
				}

			});
			invalidate();
			validate();
		} else if (selectedIndex == 1) {
			// Warden
			WardenWin w = new WardenWin(inputUserID, hallCode);
			setContentPane(w);
			w.btnLogout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					loginScreen();
				}

			});
			invalidate();
			validate();
		} else if (selectedIndex == 2) {
			// Student
			StudentPage w = new StudentPage(inputUserID);
			setContentPane(w);
			w.btnLogout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					loginScreen();
				}

			});
			invalidate();
			validate();
		} else if (selectedIndex == 3) {
			// Clerk
			WorkerPanel w = new WorkerPanel(inputUserID, hallCode);
			setContentPane(w);
			w.btnLogout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					loginScreen();
				}

			});
			invalidate();
			validate();
		} else if (selectedIndex == 4) {
			// Mess Manager
			MessManagerWin w = new MessManagerWin(inputUserID, hallCode);
			setContentPane(w);
			w.btnLogout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					loginScreen();
				}

			});
			invalidate();
			validate();
		}
	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}

}
