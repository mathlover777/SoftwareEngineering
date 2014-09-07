package code;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentPage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2148344471779534539L;
	/**
	 * Create the panel.
	 * 
	 * @param inputUserID
	 */
	public JButton btnLogout;
	private JLabel lblMess;
	private JLabel lblRent;
	private JLabel lblAmenity;
	private Bridge bridge;

	public StudentPage(final String inputUserID) {
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

		JSeparator separator = new JSeparator();
		separator.setBounds(458, 142, 440, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(185, 398, 261, 2);
		add(separator_1);

		JButton btnChangeStudentDetails = new JButton("Change Student Details");
		btnChangeStudentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeStudentDetail t = new ChangeStudentDetail(inputUserID);
				t.setVisible(true);
				t.setModal(true);
			}
		});
		btnChangeStudentDetails.setBounds(473, 173, 187, 48);
		add(btnChangeStudentDetails);

		JLabel lblLoginSuccessfulwelcome = new JLabel(
				"Login SuccessFul !!....WELCOME");
		lblLoginSuccessfulwelcome.setBounds(458, 92, 511, 48);
		add(lblLoginSuccessfulwelcome);

		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(670, 173, 178, 48);
		add(btnLogout);

		JLabel lblCurrentDues = new JLabel("Current Dues:-");
		lblCurrentDues.setBounds(473, 232, 187, 32);
		add(lblCurrentDues);

		JLabel lblNewLabel = new JLabel("Mess Bill:");
		lblNewLabel.setBounds(473, 275, 107, 26);
		add(lblNewLabel);

		lblMess = new JLabel("New label");
		lblMess.setBounds(670, 281, 178, 20);
		add(lblMess);

		JLabel lblRoomRent = new JLabel("Room Rent:");
		lblRoomRent.setBounds(473, 316, 187, 26);
		add(lblRoomRent);

		lblRent = new JLabel("New label");
		lblRent.setBounds(670, 322, 178, 20);
		add(lblRent);

		JLabel lblAmenityCharge = new JLabel("Amenity Charge:");
		lblAmenityCharge.setBounds(473, 353, 187, 26);
		add(lblAmenityCharge);

		lblAmenity = new JLabel("New label");
		lblAmenity.setBounds(670, 359, 178, 20);
		add(lblAmenity);

		String query = "SELECT  `roomrentdue` ,  `messchargedue` ,  `amenitychargedue` , `name` FROM  `studentdetail` WHERE  `id` LIKE  '"+inputUserID+"'";
		//String query = "SELECT  `roomrentdue` ,  `messchargedue` ,  `amenitychargedue` FROM  `studentdetail` WHERE  `id` LIKE  '11ME10059'";
		ResultSet rs = resultQuery(query);
		try {
			rs.beforeFirst();
			rs.next();
			lblAmenity.setText(rs.getString("amenitychargedue"));
			lblMess.setText(rs.getString("messchargedue"));
			lblRent.setText(rs.getString("roomrentdue"));
			lblLoginSuccessfulwelcome.setText("Welcome " + rs.getString("name"));
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
