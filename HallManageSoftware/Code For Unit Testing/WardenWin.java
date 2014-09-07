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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WardenWin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550123954297854990L;
	/**
	 * Create the panel.
	 * 
	 * @param inputUserID
	 */
	public JButton btnLogout;
	int singleRent, doubleRent, amenityCharge;
	private JTextArea lblWelcome;
	private JButton btnRequestGrant;
	private Bridge bridge;

	public WardenWin(String inputUserID, final String hallCode) {
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setLayout(null);
		setBackground(Color.WHITE);
		JButton btnViewAllComplaints = new JButton("View All Complaints");
		btnViewAllComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewComplaint t = new ViewComplaint(hallCode);
				t.setBounds(100, 100, 1000, 600);
				t.setVisible(true);
				t.setModal(true);
			}
		});
		btnViewAllComplaints.setBounds(633, 483, 161, 50);
		add(btnViewAllComplaints);

		JButton btnActivateMonthlyLink = new JButton("Activate Monthly Link");
		btnActivateMonthlyLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "SELECT  `id` ,  `roomtype` ,  `roomrentdue` ,  `messchargedue` ,  `amenitychargedue` FROM  `hms`.`studentdetail` WHERE  `hallcode` LIKE  '"
						+ hallCode + "'";
				ResultSet rs = resultQuery(query);
				try {
					rs.first();
					while (rs.getRow() != 0) {
						int amenityChargeDue = Integer.parseInt(rs
								.getString("amenitychargedue"));
						amenityChargeDue += amenityCharge;
						System.out.println(amenityChargeDue);
						String roomtype = rs.getString("roomtype");
						if (roomtype.equals("0")) {
							int roomRentDue = Integer.parseInt(rs
									.getString("roomrentdue"));
							roomRentDue += singleRent;
							query = "UPDATE  `hms`.`studentdetail` SET  `roomrentdue` =  '"
									+ roomRentDue
									+ "' , `amenitychargedue` = '"
									+ amenityChargeDue
									+ "' WHERE  `studentdetail`.`id` LIKE '"
									+ rs.getString("id") + "'";
						} else {
							int roomRentDue = Integer.parseInt(rs
									.getString("roomrentdue"));
							roomRentDue += doubleRent;
							query = "UPDATE  `hms`.`studentdetail` SET  `roomrentdue` =  '"
									+ roomRentDue
									+ "' , `amenitychargedue` = '"
									+ amenityChargeDue
									+ "' WHERE  `studentdetail`.`id` LIKE '"
									+ rs.getString("id") + "'";
						}
						updateQuery(query);
						rs.next();
					}
					JOptionPane.showMessageDialog(null,
							"New month has been started!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnActivateMonthlyLink.setBounds(806, 50, 222, 44);
		add(btnActivateMonthlyLink);

		JButton btnViewAccomodationList = new JButton(
				"View Room Occupancy List");
		btnViewAccomodationList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomOccupancy t = new RoomOccupancy(hallCode);
				t.setBounds(100, 100, 1000, 500);
				t.setVisible(true);
				t.setModal(true);
			}
		});
		btnViewAccomodationList.setBounds(806, 106, 222, 44);
		add(btnViewAccomodationList);

		JButton btnNewButton = new JButton("Print Account Statement");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountStateMent t = new AccountStateMent(hallCode);
				t.setBounds(100, 100, 1000, 500);
				t.setVisible(true);
				t.setModal(true);
			}
		});
		btnNewButton.setBounds(806, 162, 222, 44);
		add(btnNewButton);

		JButton btnFireWorker = new JButton("Fire Worker");
		btnFireWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FireWorker t = new FireWorker(hallCode);
				t.setBounds(0, 0, 1000, 650);
				t.setVisible(true);
				t.setModal(true);
			}
		});
		btnFireWorker.setBounds(806, 218, 222, 44);
		add(btnFireWorker);

		JButton btnRecruitWorker = new JButton("Recruit Worker");
		btnRecruitWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecruitWorker t = new RecruitWorker(hallCode);
				t.setBounds(100, 100, 1000, 650);
				t.setVisible(true);
				t.setModal(true);
			}
		});
		btnRecruitWorker.setBounds(806, 264, 222, 44);
		add(btnRecruitWorker);

		JButton btnEnterAmenityCharge = new JButton("Enter Amenity Charge");
		btnEnterAmenityCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterAmenityCharge t = new EnterAmenityCharge(hallCode);
				t.setBounds(100, 100, 1000, 500);
				t.setVisible(true);
				t.setModal(true);
			}
		});
		btnEnterAmenityCharge.setBounds(806, 319, 222, 44);
		add(btnEnterAmenityCharge);

		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogout.setBounds(806, 486, 222, 44);
		add(btnLogout);

		JButton btnPaySalary = new JButton("Pay Salary");
		btnPaySalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaySalary t = new PaySalary(hallCode);
				t.setBounds(100, 100, 1000, 600);
				t.setVisible(true);
				t.setModal(true);
			}
		});
		btnPaySalary.setBounds(806, 374, 222, 44);
		add(btnPaySalary);

		JButton btnPayStudent = new JButton("Student Payment");
		btnPayStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentPaymentWin t = new StudentPaymentWin(hallCode);
				t.setVisible(true);
				t.setModal(true);
			}
		});
		btnPayStudent.setBounds(804, 428, 222, 44);
		add(btnPayStudent);

		lblWelcome = new JTextArea("New label");
		lblWelcome.setBounds(439, 97, 248, 285);
		lblWelcome.setBorder(null);
		add(lblWelcome);
		lblWelcome.setText("_____________________\n\n     WARDEN AREA \n\n     Hall Code: " + hallCode + "\n\n_____________________");

		btnRequestGrant = new JButton("Request Grant");
		btnRequestGrant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RequestGrant t = new RequestGrant(hallCode);
				t.setVisible(true);
			}
		});
		btnRequestGrant.setBounds(633, 428, 161, 50);
		add(btnRequestGrant);

		String query = "SELECT  `singlerent` ,  `doublerent` ,  `amenitycharge` FROM  `halldata` WHERE  `hallcode` LIKE  '"
				+ hallCode + "'";
		ResultSet rs = resultQuery(query);
		try {
			rs.first();
			singleRent = Integer.parseInt(rs.getString("singlerent"));
			doubleRent = Integer.parseInt(rs.getString("doublerent"));
			amenityCharge = Integer.parseInt(rs.getString("amenitycharge"));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
