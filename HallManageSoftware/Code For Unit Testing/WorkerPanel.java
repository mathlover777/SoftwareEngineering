package code;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class WorkerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3516403728387470739L;
	private JTextField tfTotalAttendance;
	private JTextField tfCurrentAttendance;
	private JTextField tfWorkerType;
	private JTextField tfName;
	public JButton btnLogout;
	private JButton btnBack;
	private JButton btnNext;
	private JComboBox comboBox;
	private JButton btnMarkPresent;
	private JButton btnSave;
	private JButton btnChangeProfileDetail;
	private ArrayList<String> type;
	private ArrayList<String> name;
	private ArrayList<String> present;
	private ArrayList<String> absent;
	private ArrayList<String> id;
	private ArrayList<String> email;
	private ArrayList<String> account;
	private ArrayList<String> password;
	private ArrayList<String> dailySalary;
	private ArrayList<String> address;
	private ArrayList<String> contact;
	private JButton btnMarkAbsent;
	private Bridge bridge;

	/**
	 * Create the panel.
	 * 
	 * @param inputUserID
	 * @param hallCode
	 */
	public WorkerPanel(String inputUserID, String hallCode) {
		
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
		type = new ArrayList<String>();
		name = new ArrayList<String>();
		present = new ArrayList<String>();
		absent = new ArrayList<String>();
		id = new ArrayList<String>();
		email = new ArrayList<String>();
		account = new ArrayList<String>();
		password = new ArrayList<String>();
		dailySalary = new ArrayList<String>();
		address = new ArrayList<String>();
		contact = new ArrayList<String>();

		JLabel lblSelectEmployee = new JLabel("Select Employee :");
		lblSelectEmployee.setBounds(147, 93, 113, 26);
		add(lblSelectEmployee);

		comboBox = new JComboBox();
		comboBox.setBounds(263, 87, 315, 38);
		add(comboBox);

		btnMarkPresent = new JButton("Mark Present");
		btnMarkPresent.setBounds(654, 154, 144, 44);
		add(btnMarkPresent);
		btnMarkPresent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = comboBox.getSelectedIndex();
				int p = Integer.parseInt(present.get(i)) + 1;
				String query = "UPDATE `hms`.`workerlist` SET `present` = '"
						+ p + "' WHERE `id` LIKE '" + id.get(i) + "'";
				updateQuery(query);
				tfCurrentAttendance.setText(p + "");
				present.set(i, "" + p);
				JOptionPane.showMessageDialog(null, "Attendance given!");
			}
		});

		JSeparator separator = new JSeparator();
		separator.setBounds(134, 317, 818, 2);
		add(separator);

		JLabel lblSetTotalAttendence = new JLabel(
				"Set Total Attendence (will overwrite the daily record ) :");
		lblSetTotalAttendence.setBounds(147, 276, 308, 30);
		add(lblSetTotalAttendence);

		tfTotalAttendance = new JTextField();
		tfTotalAttendance.setBounds(461, 265, 117, 41);
		add(tfTotalAttendance);
		tfTotalAttendance.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setBounds(654, 265, 142, 41);
		add(btnSave);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					int att = Integer.parseInt(tfTotalAttendance.getText());
					int i = comboBox.getSelectedIndex();
					String query = "UPDATE `hms`.`workerlist` SET `present` = '"
							+ att + "' WHERE `id` LIKE '" + id.get(i) + "'";
					updateQuery(query);
					tfCurrentAttendance.setText(att + "");
					present.set(i, att + "");
					JOptionPane.showMessageDialog(null, "Attendance Updated!");

				} catch (Exception e4) {
					JOptionPane
							.showMessageDialog(null, "Enter a valid number!");
				}
			}
		});

		btnBack = new JButton("Back");
		btnBack.setBounds(653, 87, 144, 44);
		add(btnBack);

		
		btnNext = new JButton("Next");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i = comboBox.getSelectedIndex();
					tfName.setText(name.get(i - 1));
					tfCurrentAttendance.setText(present.get(i - 1));
					tfWorkerType.setText(type.get(i - 1));
					comboBox.setSelectedIndex(i - 1);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Cannot move back further!");
				}
			}
		});
		btnNext.setBounds(808, 87, 144, 44);
		add(btnNext);

		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					int i = comboBox.getSelectedIndex();
					tfName.setText(name.get(i + 1));
					tfCurrentAttendance.setText(present.get(i + 1));
					tfWorkerType.setText(type.get(i + 1));
					comboBox.setSelectedIndex(i + 1);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "End of List!");
				}
			}
		});

		JLabel lblAttendenceUptoNow = new JLabel("Current Attendance:");
		lblAttendenceUptoNow.setBounds(147, 214, 143, 26);
		add(lblAttendenceUptoNow);

		tfCurrentAttendance = new JTextField();
		tfCurrentAttendance.setEditable(false);
		tfCurrentAttendance.setBounds(263, 213, 315, 28);
		add(tfCurrentAttendance);
		tfCurrentAttendance.setColumns(10);

		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(147, 154, 55, 16);
		add(lblType);

		tfWorkerType = new JTextField();
		tfWorkerType.setEditable(false);
		tfWorkerType.setBounds(263, 148, 315, 28);
		add(tfWorkerType);
		tfWorkerType.setColumns(10);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(147, 187, 55, 16);
		add(lblName);

		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setBounds(263, 181, 315, 30);
		add(tfName);
		tfName.setColumns(10);

		btnChangeProfileDetail = new JButton("Change Profile Detail ");
		btnChangeProfileDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeWorkerDetails t = new ChangeWorkerDetails(id.get(comboBox.getSelectedIndex()));
				t.setVisible(true);
				t.setModal(true);
			}
		});
		btnChangeProfileDetail.setBounds(263, 333, 199, 44);
		add(btnChangeProfileDetail);

		String query = "SELECT * FROM `hms`.`workerlist` WHERE `hallcode` LIKE '"
				+ hallCode + "' AND `type` IN ('gardener','attendant')";

		ResultSet rs = resultQuery(query);
		computeWorkerList(rs);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(808, 336, 139, 38);
		add(btnLogout);

		btnMarkAbsent = new JButton("Mark Absent");
		btnMarkAbsent.setBounds(808, 154, 144, 44);
		add(btnMarkAbsent);

		btnMarkAbsent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = comboBox.getSelectedIndex();
				int p = Integer.parseInt(absent.get(i)) + 1;
				String query = "UPDATE `hms`.`workerlist` SET `absent` = '" + p
						+ "' WHERE `id` LIKE '" + id.get(i) + "'";
				updateQuery(query);
				JOptionPane.showMessageDialog(null, "Absent marked!");
			}
		});

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int i = comboBox.getSelectedIndex();
				tfName.setText(name.get(i));
				tfCurrentAttendance.setText(present.get(i));
				tfWorkerType.setText(type.get(i));
			}
		});

	}

	private void computeWorkerList(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			rs.beforeFirst();
			rs.next();
			while (rs.getRow() != 0) {
				type.add(rs.getString("type"));
				name.add(rs.getString("name"));
				present.add(rs.getString("present"));
				absent.add(rs.getString("absent"));
				id.add(rs.getString("id"));
				email.add(rs.getString("email"));
				account.add(rs.getString("account"));
				password.add(rs.getString("password"));
				dailySalary.add(rs.getString("dailysalary"));
				address.add(rs.getString("address"));
				contact.add(rs.getString("contact"));
				rs.next();
			}
			comboBox.setModel(new DefaultComboBoxModel(id.toArray()));
			try{
				tfName.setText(name.get(0));
				tfCurrentAttendance.setText(present.get(0));
				tfWorkerType.setText(type.get(0));
			}
			catch(Exception e){
				e.printStackTrace();
				tfName.setText("NO WORKERS RECRUITED YET!");
			}
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
