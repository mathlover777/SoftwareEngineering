package code;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class StudentPaymentWin extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3250360171992476601L;
	private JLabel lblName;
	private JComboBox comboBox;
	private JLabel lblMess;
	private JLabel lblAmenity;
	private JButton btnClearDues;
	ArrayList<String> id = new ArrayList<String>();
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> roomRent = new ArrayList<String>();
	ArrayList<String> messCharge = new ArrayList<String>();
	ArrayList<String> amenityCharge = new ArrayList<String>();
	int messAccount, rentAccount, amenityAccount;
	private JLabel lblRent;
	private String hallCode;
	private JButton btnExit;
	private Bridge bridge;

	/**
	 * Create the dialog.
	 */
	
	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			StudentPaymentWin dialog = new StudentPaymentWin("VS");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/************************************************************/
	
	
	
	public StudentPaymentWin(final String hallCode) {
		
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setBounds(100, 100, 750, 408);
		setModal(true);
		getContentPane().setLayout(null);
		this.hallCode = hallCode;
		comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 334, 31);
		getContentPane().add(comboBox);

		lblName = new JLabel("Name");
		lblName.setBounds(10, 67, 334, 24);
		getContentPane().add(lblName);

		JLabel lblCurrentDues = new JLabel("Current Dues");
		lblCurrentDues.setBounds(391, 11, 261, 31);
		getContentPane().add(lblCurrentDues);

		JLabel label_1 = new JLabel("Mess Bill:");
		label_1.setBounds(391, 53, 107, 26);
		getContentPane().add(label_1);

		lblMess = new JLabel((String) null);
		lblMess.setBounds(588, 59, 178, 20);
		getContentPane().add(lblMess);

		JLabel label_3 = new JLabel("Room Rent:");
		label_3.setBounds(391, 94, 187, 26);
		getContentPane().add(label_3);

		lblRent = new JLabel((String) null);
		lblRent.setBounds(588, 100, 178, 20);
		getContentPane().add(lblRent);

		lblAmenity = new JLabel((String) null);
		lblAmenity.setBounds(588, 137, 178, 20);
		getContentPane().add(lblAmenity);

		JLabel label_6 = new JLabel("Amenity Charge:");
		label_6.setBounds(391, 131, 187, 26);
		getContentPane().add(label_6);

		btnClearDues = new JButton("Clear Dues");
		btnClearDues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE  `hms`.`studentdetail` SET  `roomrentdue` =  '0', `messchargedue` =  '0' , `amenitychargedue` =  '0' WHERE  `studentdetail`.`id` LIKE '"
						+ id.get(comboBox.getSelectedIndex()) + "'";
				updateQuery(query);
				int i = comboBox.getSelectedIndex();
				GenerateReceipt.generate(name.get(i), id.get(i),
						amenityCharge.get(i), messCharge.get(i),
						roomRent.get(i), id.get(i) + "_receipt", "C:\\comp\\pdfdata\\");
				updateHallAccounts(id.get(i), amenityCharge.get(i),
						messCharge.get(i), roomRent.get(i));
				messCharge.set(i, "0");
				amenityCharge.set(i, "0");
				roomRent.set(i, "0");
				lblAmenity.setText("0");
				lblMess.setText("0");
				lblRent.setText("0");
			}
		});
		btnClearDues.setBounds(391, 217, 124, 23);
		getContentPane().add(btnClearDues);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE  `hms`.`hallaccount` SET  `messaccount` =  '"
						+ messAccount
						+ "',`amenityaccount` =  '"
						+ amenityAccount
						+ "',`roomrentaccount` =  '"
						+ rentAccount
						+ "' WHERE  `hallaccount`.`hallcode` LIKE '"
						+ hallCode + "'";
				updateQuery(query);
				dispose();
			}
		});
		btnExit.setBounds(391, 262, 124, 23);
		getContentPane().add(btnExit);

		String query = "SELECT  `name` ,  `id` ,  `roomrentdue` ,  `messchargedue` ,  `amenitychargedue` FROM  `studentdetail` WHERE  `hallcode` LIKE  '"
				+ hallCode + "'";
		ResultSet rs = resultQuery(query);
		computeStudentList(rs);

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int i = comboBox.getSelectedIndex();
				lblName.setText(name.get(i));
				lblMess.setText(messCharge.get(i));
				lblAmenity.setText(amenityCharge.get(i));
				lblRent.setText(roomRent.get(i));
			}
		});

		query = "SELECT `messaccount` , `roomrentaccount` , `amenityaccount` FROM `hms`.`hallaccount` WHERE `hallcode` LIKE '"
				+ hallCode + "'";
		rs = resultQuery(query);
		try {
			rs.first();
			messAccount = Integer.parseInt(rs.getString("messaccount"));
			rentAccount = Integer.parseInt(rs.getString("roomrentaccount"));
			amenityAccount = Integer.parseInt(rs.getString("amenityaccount"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void computeStudentList(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			rs.beforeFirst();
			rs.next();
			while (rs.getRow() != 0) {
				id.add(rs.getString("id"));
				name.add(rs.getString("name"));
				messCharge.add(rs.getString("messchargedue"));
				amenityCharge.add(rs.getString("amenitychargedue"));
				roomRent.add(rs.getString("roomrentdue"));
				rs.next();
			}
			comboBox.setModel(new DefaultComboBoxModel(id.toArray()));
			lblName.setText(name.get(0));
			lblMess.setText(messCharge.get(0));
			lblAmenity.setText(amenityCharge.get(0));
			lblRent.setText(roomRent.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			lblName.setText("No student added to your hall yet!");
			//e.printStackTrace();
		}
	}

	private void updateHallAccounts(String id, String amenity,
			String messCharge, String roomRent) {
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		
		String query = "INSERT INTO `hms`.`"
				+ hallCode
				+ "_messaccount_log` (`year`, `date`, `time`, `statement`, `startingbalance`, `endingbalance`, `type`, `id`) VALUES ('"+year+"', CURDATE(), CURTIME(), 'student payment', '"
				+ messAccount + "', '"
				+ (Integer.parseInt(messCharge) + messAccount) + "', 'in', '"
				+ id + "')";
		updateQuery(query);

		query = "INSERT INTO `hms`.`"
				+ hallCode
				+ "_amenityaccount_log` (`year`, `date`, `time`, `statement`, `startingbalance`, `endingbalance`, `type`, `id`) VALUES ('"+year+"', CURDATE(), CURTIME(), 'student payment', '"
				+ amenityAccount + "', '"
				+ (amenityAccount + Integer.parseInt(amenity)) + "', 'in', '"
				+ id + "')";
		updateQuery(query);

		query = "INSERT INTO `hms`.`"
				+ hallCode
				+ "_roomaccount_log` (`year`, `date`, `time`, `statement`, `startingbalance`, `endingbalance`, `type`, `id`) VALUES ('"+year+"', CURDATE(), CURTIME(), 'student payment', '"
				+ rentAccount + "', '"
				+ (rentAccount + Integer.parseInt(roomRent)) + "', 'in', '"
				+ id + "')";
		updateQuery(query);

		messAccount += Integer.parseInt(messCharge);
		amenityAccount += Integer.parseInt(amenity);
		rentAccount += Integer.parseInt(roomRent);

	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
