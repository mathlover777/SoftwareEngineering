package code;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class ChangeStudentDetail extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6847580372364045061L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfName;
	private JLabel lblRoll;
	private JTextArea tAaddress;
	private JLabel lblHall;
	private JTextField tfPhone;
	private String query;
	private JTextField tfEmail;
	private JButton btnExit;
	private JButton btnUpdateDetails;
	private JLabel lblRoomNo;
	private JLabel lblRoom;
	private JLabel lblPassword;
	private JPasswordField tfPassword;
	private JLabel lblConfirmPassword;
	private JPasswordField tfConfirm;
	private Bridge bridge;

	/**
	 * Create the dialog.
	 */
	
	public static void main(String[] args) {
		try {
			ChangeStudentDetail dialog = new ChangeStudentDetail("s1");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ChangeStudentDetail(String studentCode) {
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(100, 100, 450, 520);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1, 401);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 130, 23);
		getContentPane().add(lblName);

		JLabel lblRollNo = new JLabel("Roll No:");
		lblRollNo.setBounds(10, 45, 130, 23);
		getContentPane().add(lblRollNo);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 79, 130, 23);
		getContentPane().add(lblAddress);

		tfName = new JTextField();
		tfName.setBounds(174, 12, 212, 29);
		getContentPane().add(tfName);
		tfName.setColumns(10);

		lblRoll = new JLabel("");
		lblRoll.setBounds(174, 49, 212, 14);
		getContentPane().add(lblRoll);

		tAaddress = new JTextArea();
		tAaddress.setBounds(11, 111, 375, 77);
		getContentPane().add(tAaddress);

		JLabel lblNewLabel = new JLabel("Hall Code:");
		lblNewLabel.setBounds(10, 206, 130, 14);
		getContentPane().add(lblNewLabel);

		lblHall = new JLabel("");
		lblHall.setBounds(174, 206, 212, 14);
		getContentPane().add(lblHall);

		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setBounds(11, 262, 130, 23);
		getContentPane().add(lblPhoneNo);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(174, 254, 212, 29);
		getContentPane().add(tfPhone);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(11, 296, 130, 14);
		getContentPane().add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(174, 293, 212, 29);
		getContentPane().add(tfEmail);

		btnUpdateDetails = new JButton("Update Details");
		btnUpdateDetails.setBounds(11, 420, 165, 23);
		getContentPane().add(btnUpdateDetails);

		btnExit = new JButton("Exit");
		btnExit.setBounds(221, 420, 165, 23);
		getContentPane().add(btnExit);

		lblRoomNo = new JLabel("Room No:");
		lblRoomNo.setBounds(10, 231, 130, 14);
		getContentPane().add(lblRoomNo);

		lblRoom = new JLabel("");
		lblRoom.setBounds(174, 231, 212, 14);
		getContentPane().add(lblRoom);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(11, 345, 130, 14);
		getContentPane().add(lblPassword);

		tfPassword = new JPasswordField();
		tfPassword.setBounds(174, 338, 212, 29);
		getContentPane().add(tfPassword);

		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(11, 379, 165, 14);
		getContentPane().add(lblConfirmPassword);

		tfConfirm = new JPasswordField();
		tfConfirm.setBounds(174, 372, 212, 29);
		getContentPane().add(tfConfirm);

		query = "SELECT * FROM `hms`.`studentdetail` WHERE `id` LIKE '"
				+ studentCode + "'";
		ResultSet rs = resultQuery(query);
		try {
			if (rs.last()) {
				tfName.setText(rs.getString("name"));
				tfPhone.setText(rs.getString("phone"));
				lblRoll.setText(rs.getString("id"));
				tAaddress.setText(rs.getString("address"));
				lblHall.setText(rs.getString("hallcode"));
				tfEmail.setText(rs.getString("email"));
				lblRoom.setText(rs.getString("roomNo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnExit.addActionListener(this);
		btnUpdateDetails.addActionListener(this);
	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(btnExit)) {

			this.dispose();

		} else if (arg0.getSource().equals(btnUpdateDetails)) {
			
			/*if (tfPassword.getText() != null) {
				if (tfConfirm.getText().equals(tfPassword.getText())) {
					/*query = "UPDATE `hms`.`studentdetail` SET `name` = '"
							+ tfName.getText() + "', `address` = '"
							+ tAaddress.getText() + "', `password` = '"
							+ tfPassword.getText() + "', `phone` = '"
							+ tfPhone.getText() + "', `email` = '"
							+ tfEmail.getText()
							+ "' WHERE `studentdetail`.`id` = '"
							+ lblRoll.getText() + "'";*/
					
					/****************Unit Testing************************/
					
					query = "UPDATE `hms`.`studentdetail` SET `name` = '"
							+ "Student1" + "', `address` = '"
							+ "bengaluru" + "', `password` = '"
							+ "2222" + "', `phone` = '"
							+ "33535" + "', `email` = '"
							+ "fsffd@gmail.com"
							+ "' WHERE `studentdetail`.`id` = '"
							+ lblRoll.getText() + "'";
					
					/***************************************************/
			/*	}
			} else {
				query = "UPDATE `hms`.`studentdetail` SET `name` = '"
						+ tfName.getText() + "', `address` = '"
						+ tAaddress.getText() + "', `phone` = '"
						+ tfPhone.getText() + "', `email` = '"
						+ tfEmail.getText()
						+ "' WHERE `studentdetail`.`id` = '"
						+ lblRoll.getText() + "'";
			}*/
			updateQuery(query);
		}
	}
}
