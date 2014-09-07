package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class HMCwin extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5876424751646120824L;
	private JTextArea messageBox;
	public JButton btnLogout;
	private JButton btnRemoveEmployee;
	private String s;
	private Bridge bridge;

	/**
	 * Create the panel.
	 */
	public HMCwin() {
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setBackground(Color.WHITE);
		
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(241, 84, 537, 447);
		add(scrollPane);

		JLabel lblLatestMessages = new JLabel("Latest Messages");
		scrollPane.setColumnHeaderView(lblLatestMessages);

		messageBox = new JTextArea();
		scrollPane.setViewportView(messageBox);
		messageBox.setLineWrap(true);

		JButton btnViewAllComplaints = new JButton("View All Complaints");
		btnViewAllComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HMCViewComplaints t = new HMCViewComplaints();
				t.setVisible(true);
				t.setModal(true);
				t.setResizable(true);
				t.setBounds(0, 0, 1000, 500);
			}
		});
		btnViewAllComplaints.setBounds(790, 370, 191, 39);
		add(btnViewAllComplaints);

		JButton btnAddHall = new JButton("Add Hall");
		btnAddHall.setBounds(790, 157, 191, 39);
		add(btnAddHall);
		btnAddHall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addHall t = new addHall();
				t.setVisible(true);
				t.setModal(true);
				t.setResizable(true);
				t.setBounds(0, 0, 1000, 500);
			}
		});

		JButton btnModifyHallDatabase = new JButton("Modify Hall DataBase");
		btnModifyHallDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyHall t = new ModifyHall();
				t.setVisible(true);
				t.setModal(true);
				t.setResizable(true);
				t.setBounds(0, 0, 1000, 500);
			}
		});
		btnModifyHallDatabase.setBounds(790, 193, 191, 39);
		add(btnModifyHallDatabase);

		JButton btnAddNewWarden = new JButton("Add Employee");
		btnAddNewWarden.setBounds(790, 300, 191, 39);
		add(btnAddNewWarden);
		btnAddNewWarden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddEmp t = new AddEmp();
				t.setVisible(true);
				t.setBounds(100, 100, 1000, 500);
				t.setModal(true);
			}
		});

		btnRemoveEmployee = new JButton("Remove Employee");
		btnRemoveEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyEmp t = new ModifyEmp();
				t.setVisible(true);
				t.setBounds(100, 100, 1000, 500);
				t.setModal(true);
			}
		});
		btnRemoveEmployee.setBounds(790, 334, 191, 39);
		add(btnRemoveEmployee);

		JButton btnViewAndGrant = new JButton("View and Grant Hall Fund");
		btnViewAndGrant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewGrant t = new ViewGrant();
				t.setVisible(true);
				t.setBounds(100, 100, 1000, 500);
				t.setModal(true);
			}
		});
		btnViewAndGrant.setBounds(790, 228, 191, 39);
		add(btnViewAndGrant);

		JButton btnAdmissionaccomodation = new JButton("Admission");
		btnAdmissionaccomodation.setBounds(790, 84, 191, 39);
		add(btnAdmissionaccomodation);
		btnAdmissionaccomodation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddStudent t = new AddStudent();
				t.setVisible(true);
				t.setModal(true);
				t.setBounds(200, 200, 1000, 500);
			}
		});

		JButton btnRetrievePassword = new JButton("Reset Password");
		btnRetrievePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RetrievePassword t = new RetrievePassword();
				t.setVisible(true);
				t.setModal(true);
				t.setBounds(200, 200, 1000, 500);
			}
		});
		btnRetrievePassword.setBounds(790, 451, 191, 39);
		add(btnRetrievePassword);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(790, 492, 191, 39);
		add(btnLogout);

		JButton btnRoomAllotment = new JButton("Room Allotment");
		btnRoomAllotment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Roomallot t = new Roomallot();
				t.setVisible(true);
				t.setModal(true);
				t.setBounds(200, 200, 1000, 500);
			}
		});
		btnRoomAllotment.setBounds(790, 121, 191, 39);
		add(btnRoomAllotment);

		JButton btnAddWarden = new JButton("Add Warden");
		btnAddWarden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWarden t = new AddWarden();
				t.setVisible(true);
				t.setModal(true);
				t.setBounds(200, 200, 1000, 500);
			}
		});
		btnAddWarden.setBounds(790, 264, 191, 39);
		add(btnAddWarden);

		String query = "SELECT `complaint` , `id`  FROM  `complaints` WHERE  `isForwarded` =1 AND  `isResolved` =0 ORDER BY `no` DESC LIMIT 5";
		ResultSet rs = resultQuery(query);
		computeComplaintList(rs);
	}

	private void computeComplaintList(ResultSet rs) {
		try {
			rs.beforeFirst();
			rs.next();
			int flag = 0;
			s = "\n\nRecent forwarded comlaints:\n________________________\n";
			while (rs.getRow() != 0) {
				flag = 1;
				s = s + "\nStudent ID: " + rs.getString("id") + "\n"
						+ "Details: " + rs.getString("complaint")
						+ "\n________________________\n";
				rs.next();
			}
			messageBox.setText(s);
			if (flag == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			messageBox.setText("No Complaints Forwarded!");
		}
	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
