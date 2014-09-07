package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class ChangeWorkerDetails extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 928389025206243498L;
	private JTextField tfName;
	private JTextField tfPhone;
	private JTextField tfEmail;
	private JTextField tfAccount;
	private JButton button;
	private JTextArea taAddress;
	private JLabel lblID;
	private JLabel lblHall;
	private Bridge bridge;

	/**
	 * Create the dialog.
	 */
	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			ChangeWorkerDetails dialog = new ChangeWorkerDetails("g1");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*************************************************************/
	public ChangeWorkerDetails(final String id) {
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(100, 100, 518, 464);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Name:");
		label.setBounds(10, 11, 130, 23);
		getContentPane().add(label);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(174, 12, 212, 26);
		getContentPane().add(tfName);

		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 45, 130, 23);
		getContentPane().add(lblId);

		JLabel label_2 = new JLabel("Address:");
		label_2.setBounds(10, 79, 130, 23);
		getContentPane().add(label_2);

		lblID = new JLabel("");
		lblID.setBounds(174, 49, 212, 14);
		getContentPane().add(lblID);

		taAddress = new JTextArea();
		taAddress.setBounds(11, 111, 375, 77);
		getContentPane().add(taAddress);

		JLabel label_4 = new JLabel("Hall Code:");
		label_4.setBounds(10, 206, 130, 14);
		getContentPane().add(label_4);

		lblHall = new JLabel("");
		lblHall.setBounds(174, 206, 212, 14);
		getContentPane().add(lblHall);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(174, 257, 212, 33);
		getContentPane().add(tfPhone);

		JLabel label_8 = new JLabel("Phone No:");
		label_8.setBounds(11, 262, 130, 23);
		getContentPane().add(label_8);

		JLabel label_9 = new JLabel("Email:");
		label_9.setBounds(11, 296, 130, 14);
		getContentPane().add(label_9);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(174, 293, 212, 26);
		getContentPane().add(tfEmail);

		button = new JButton("Update Details");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String name = tfName.getText();
				String account = tfAccount.getText();
				String email = tfEmail.getText();
				String phone = tfPhone.getText();
				String address = taAddress.getText();*/
				
				
				/**********************Code For Unit Testing**************/
				String name = tfName.getText();
				String account = "4343434";
				String email = "newmail@gmail.com";
				String phone = "3433444";
				String address = taAddress.getText();
				/*****************************************************/
				
				String query = "UPDATE  `hms`.`workerlist` SET  `name` =  '"
						+ name + "',`contact` =  '" + phone + "',`email` =  '"
						+ email + "',`address` =  '" + address
						+ "',`account` =  '" + account
						+ "' WHERE  `workerlist`.`id` =  '" + id + "'";
				updateQuery(query);
				JOptionPane.showMessageDialog(null, "Successfully Updated!");
			}
		});
		button.setBounds(11, 346, 165, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(11, 378, 165, 23);
		getContentPane().add(button_1);

		JLabel lblAccount = new JLabel("Account:");
		lblAccount.setBounds(10, 231, 130, 23);
		getContentPane().add(lblAccount);

		tfAccount = new JTextField();
		tfAccount.setColumns(10);
		tfAccount.setBounds(174, 226, 212, 26);
		getContentPane().add(tfAccount);

		String query = "SELECT  `id` ,  `hallcode` ,  `name` ,  `contact` ,  `email` ,  `address` ,  `account` FROM  `hms`.`workerlist` WHERE  `id` LIKE  '"
				+ id + "'";
		ResultSet rs = resultQuery(query);
		try {
			rs.first();
			tfAccount.setText(rs.getString("account"));
			lblID.setText(rs.getString("id"));
			taAddress.setText("address");
			tfEmail.setText("email");
			tfName.setText("name");
			tfPhone.setText("contact");
			lblHall.setText("hallcode");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
