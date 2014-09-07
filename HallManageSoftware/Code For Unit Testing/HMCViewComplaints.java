package code;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class HMCViewComplaints extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2168542393391511793L;
	private JComboBox comboBox;
	private JLabel lblStudent;
	private JTextArea lblComplaint;
	ArrayList<String> id = new ArrayList<String>();
	ArrayList<String> no = new ArrayList<String>();
	ArrayList<String> complaint = new ArrayList<String>();
	ArrayList<String> wardenATR = new ArrayList<String>();
	ArrayList<String> HMCATR = new ArrayList<String>();
	private JTextArea taHMCATR;
	private JTextArea taWardenATR;
	private JButton btnUpdateHmcAtr;
	private JTextField tfRepairFund;
	private JButton btnGrantRepairFund;
	private Bridge bridge;

	/**
	 * Create the dialog.
	 */
	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			HMCViewComplaints dialog = new HMCViewComplaints();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/************************************************************/
	public HMCViewComplaints() {
		
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(50, 50, 775, 650);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Complaint No:");
		label.setBounds(10, 11, 133, 31);
		getContentPane().add(label);

		lblStudent = new JLabel("Student ID:");
		lblStudent.setBounds(10, 64, 305, 31);
		getContentPane().add(lblStudent);

		lblComplaint = new JTextArea();
		lblComplaint.setText("Complaint");
		lblComplaint.setEditable(false);
		lblComplaint.setBounds(10, 106, 624, 98);
		getContentPane().add(lblComplaint);

		JLabel label_2 = new JLabel("HMC ATR");
		label_2.setBounds(10, 215, 106, 24);
		getContentPane().add(label_2);

		taHMCATR = new JTextArea();
		taHMCATR.setBounds(10, 238, 624, 68);
		getContentPane().add(taHMCATR);

		JLabel label_4 = new JLabel("Warden ATR");
		label_4.setBounds(10, 317, 79, 14);
		getContentPane().add(label_4);

		taWardenATR = new JTextArea();
		taWardenATR.setEditable(false);
		taWardenATR.setBounds(10, 342, 624, 58);
		getContentPane().add(taWardenATR);

		btnUpdateHmcAtr = new JButton("Update HMC ATR");
		btnUpdateHmcAtr.setBounds(10, 411, 177, 44);
		getContentPane().add(btnUpdateHmcAtr);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(405, 491, 177, 44);
		getContentPane().add(btnExit);

		comboBox = new JComboBox();
		comboBox.setBounds(159, 11, 224, 31);
		getContentPane().add(comboBox);
		
		btnGrantRepairFund = new JButton("Grant Repair Fund");
		btnGrantRepairFund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int repairMoney = Integer.parseInt(tfRepairFund.getText());
					String query = "SELECT `hallcode` FROM `hms`.`studentdetail` WHERE `id` LIKE '"+id.get(comboBox.getSelectedIndex())+"'";
					ResultSet rs = resultQuery(query);
					rs.first();
					String hallCode = rs.getString("hallcode");
					GenericPay.pay("in", hallCode, "repair", repairMoney, "Payment granted for repair to " + hallCode, "HMC");
					
				}
				catch(Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Enter a valid amount!");
				}
			}
		});
		btnGrantRepairFund.setBounds(10, 511, 179, 44);
		getContentPane().add(btnGrantRepairFund);
		
		tfRepairFund = new JTextField();
		tfRepairFund.setBounds(10, 466, 177, 34);
		getContentPane().add(tfRepairFund);
		tfRepairFund.setColumns(10);

		String query = "SELECT * FROM  `complaints` WHERE  `isForwarded` =1 AND  `isResolved` =0";
		ResultSet rs = resultQuery(query);
		computeComplaintList(rs);

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				btnUpdateHmcAtr.setEnabled(true);
				int i = comboBox.getSelectedIndex();
				lblStudent.setText("Student ID:" + id.get(i));
				lblComplaint.setText(complaint.get(i));
				taHMCATR.setText(HMCATR.get(i));
				taWardenATR.setText(wardenATR.get(i));
			}

		});

		btnUpdateHmcAtr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (taHMCATR.getText() == null) {
					JOptionPane.showMessageDialog(null, "Enter an ATR first!");
				} else {
					int i = comboBox.getSelectedIndex();
					//btnUpdateHmcAtr.setEnabled(false);
					String query = "UPDATE  `hms`.`complaints` SET  `HMCATR` =  '"
							+ taHMCATR.getText()
							+ "' WHERE  `complaints`.`no` =" + no.get(i);
					updateQuery(query);
					JOptionPane.showMessageDialog(null, "ATR Updated");
					id.remove(i);
					complaint.remove(i);
					wardenATR.remove(i);
					HMCATR.remove(i);
					no.remove(i);
					comboBox.setModel(new DefaultComboBoxModel(no.toArray()));
					comboBox.setSelectedIndex(0);
					i = comboBox.getSelectedIndex();
					lblStudent.setText("Student ID:" + id.get(i));
					lblComplaint.setText(complaint.get(i));
					taHMCATR.setText(HMCATR.get(i));
					taWardenATR.setText(wardenATR.get(i));
				}
			}
		});

	}

	private void computeComplaintList(ResultSet rs) {
		try {
			rs.beforeFirst();
			rs.next();
			while (rs.getRow() != 0) {
				id.add(rs.getString("id"));
				complaint.add(rs.getString("complaint"));
				wardenATR.add(rs.getString("wardenATR"));
				HMCATR.add(rs.getString("HMCATR"));
				no.add(rs.getString("no"));
				rs.next();
			}
			comboBox.setModel(new DefaultComboBoxModel(no.toArray()));
			lblStudent.setText("Student ID:" + id.get(0));
			lblComplaint.setText(complaint.get(0));
			taHMCATR.setText(HMCATR.get(0));
			taWardenATR.setText(wardenATR.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			lblStudent.setText("No Complaints Forwarded!");
		}
	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
