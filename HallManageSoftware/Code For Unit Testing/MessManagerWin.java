package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MessManagerWin extends JPanel implements ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5649610183484910821L;
	private JTextField tfName;
	private JTextField tfMessDue;
	private JTextField tfMessCharge;
	public JButton btnLogout;
	private ArrayList<String> id;
	private ArrayList<String> name;
	private ArrayList<String> messCharge;
	private JComboBox cbStudentList;
	private JButton btnSaveDetail;
	private Bridge bridge;

	/**
	 * Create the panel.
	 * 
	 * @param inputUserID
	 */
	
	
	public MessManagerWin(String inputUserID, String hallCode) {
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
		id = new ArrayList<String>();
		name = new ArrayList<String>();
		messCharge = new ArrayList<String>();
		JLabel lblWelcomeLogin = new JLabel(
				"Welcome ... Login Successful as Mess Manager");
		lblWelcomeLogin.setBounds(151, 61, 817, 42);
		add(lblWelcomeLogin);

		JSeparator separator = new JSeparator();
		separator.setBounds(151, 108, 817, 2);
		add(separator);

		JLabel lblSelectStudent = new JLabel("Select Student :");
		lblSelectStudent.setBounds(151, 121, 134, 50);
		add(lblSelectStudent);

		JLabel lblDetails = new JLabel("Details :");
		lblDetails.setBounds(438, 125, 68, 16);
		add(lblDetails);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(439, 157, 67, 28);
		add(lblName);

		tfName = new JTextField();
		tfName.setBounds(518, 154, 415, 35);
		add(tfName);
		tfName.setColumns(10);

		JLabel lblMesschargeSetFor = new JLabel("Mess Charge Due:");
		lblMesschargeSetFor.setBounds(439, 220, 214, 28);
		add(lblMesschargeSetFor);

		tfMessDue = new JTextField();
		tfMessDue.setBounds(678, 217, 122, 35);
		add(tfMessDue);
		tfMessDue.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(439, 272, 529, 2);
		add(separator_1);

		JLabel lblEnterMessCharge = new JLabel("Enter Mess Charge  :");
		lblEnterMessCharge.setBounds(439, 305, 133, 28);
		add(lblEnterMessCharge);

		tfMessCharge = new JTextField();
		tfMessCharge.setBounds(678, 305, 122, 35);
		add(tfMessCharge);
		tfMessCharge.setColumns(10);

		btnSaveDetail = new JButton("Save Detail");
		btnSaveDetail.setBounds(439, 358, 133, 42);
		add(btnSaveDetail);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(678, 358, 126, 42);
		add(btnLogout);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(439, 434, 529, 2);
		add(separator_2);

		cbStudentList = new JComboBox();
		cbStudentList.setBounds(239, 134, 154, 35);
		cbStudentList.addItemListener(this);
		add(cbStudentList);

		String query = "SELECT * FROM `hms`.`studentdetail` WHERE `hallcode` LIKE '"
				+ hallCode + "'";
		ResultSet rs = resultQuery(query);
		computeStudents(rs);
		tfName.setText(name.get(0));
		tfMessDue.setText(messCharge.get(0));
		tfMessDue.setEditable(false);
		btnSaveDetail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i = cbStudentList.getSelectedIndex();
				int messChargeDue = 0;
				try {
					messChargeDue = Integer.parseInt(tfMessCharge.getText()
							.toString()) + Integer.parseInt(messCharge.get(i));
					String query = "UPDATE `hms`.`studentdetail` SET `messchargedue` = '"
							+ messChargeDue
							+ "' WHERE `id` = '"
							+ id.get(i)
							+ "'";
					updateQuery(query);
					tfMessDue.setText("" + messChargeDue);
					messCharge.set(i, "" + messChargeDue);
					JOptionPane.showMessageDialog(null, "Updated!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid input!");
				}
			}
		});
	}

	private void computeStudents(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			rs.beforeFirst();
			rs.next();
			while (rs.getRow() != 0) {
				id.add(rs.getString("id"));
				name.add(rs.getString("name"));
				messCharge.add(rs.getString("messchargedue"));
				rs.next();
			}
			cbStudentList.setModel(new DefaultComboBoxModel(id.toArray()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		int i = cbStudentList.getSelectedIndex();
		tfName.setText(name.get(i));
		tfMessDue.setText(messCharge.get(i));
	}
}
