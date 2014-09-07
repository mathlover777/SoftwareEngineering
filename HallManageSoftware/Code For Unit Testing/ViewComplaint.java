package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

public class ViewComplaint extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3744145306211669807L;
	private JButton btnUpdateATR;
	private JButton btnNext;
	private JButton btnExit;
	private ResultSet complaints;
	private String query;
	private JTextArea txtrComplaint;
	private JLabel lblStudentNo;
	private JLabel lblComplaintNo;
	private JTextArea txtrHmcAtr;
	private JTextArea txtrWardenATR;
	private JButton btnForwardToHmc;
	private String hallCode;
	private static int i = -1;
	private ArrayList<String> id;
	private ArrayList<String> comp;
	private ArrayList<String> wardenATR;
	private ArrayList<String> HMCATR;
	private ArrayList<String> wardenFinal;
	private ArrayList<String> isForwarded;
	private ArrayList<String> cno;
	private JButton btnBack;
	private JLabel lblHmcFinalAtr;
	private JTextArea txtrFinalATR;
	private Bridge bridge;

	/**
	 * Create the dialog.
	 */
	public ViewComplaint(String hallCode) {
		
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/

		id = new ArrayList<String>();
		comp = new ArrayList<String>();
		wardenATR = new ArrayList<String>();
		wardenFinal = new ArrayList<String>();
		HMCATR = new ArrayList<String>();
		isForwarded = new ArrayList<String>();
		cno = new ArrayList<String>();
		setModal(true);
		setBounds(100, 100, 803, 643);
		getContentPane().setLayout(null);
		this.hallCode = hallCode;
		lblComplaintNo = new JLabel("Complaint No:");
		lblComplaintNo.setBounds(10, 32, 133, 31);
		getContentPane().add(lblComplaintNo);

		lblStudentNo = new JLabel("Student ID:");
		lblStudentNo.setBounds(10, 85, 305, 31);
		getContentPane().add(lblStudentNo);

		txtrComplaint = new JTextArea();
		txtrComplaint.setText("Complaint");
		txtrComplaint.setBounds(10, 127, 624, 98);
		txtrComplaint.setEditable(false);
		getContentPane().add(txtrComplaint);

		JLabel lblHMCATR = new JLabel("HMC ATR");
		lblHMCATR.setBounds(10, 236, 106, 24);
		getContentPane().add(lblHMCATR);

		txtrHmcAtr = new JTextArea();
		txtrHmcAtr.setEditable(false);
		txtrHmcAtr.setBounds(10, 259, 624, 68);
		getContentPane().add(txtrHmcAtr);

		JLabel lblWardenAtr = new JLabel("Warden ATR");
		lblWardenAtr.setBounds(10, 449, 79, 14);
		getContentPane().add(lblWardenAtr);

		txtrWardenATR = new JTextArea();
		txtrWardenATR.setBounds(10, 474, 624, 58);
		getContentPane().add(txtrWardenATR);

		btnUpdateATR = new JButton("Update Warden ATR");
		btnUpdateATR.setBounds(10, 539, 177, 23);
		getContentPane().add(btnUpdateATR);

		btnNext = new JButton("Next");
		btnNext.setBounds(197, 539, 88, 23);
		getContentPane().add(btnNext);

		btnExit = new JButton("Exit");
		btnExit.setBounds(395, 539, 177, 23);
		getContentPane().add(btnExit);

		btnForwardToHmc = new JButton("Forward to HMC");
		btnForwardToHmc.setBounds(10, 570, 177, 23);
		getContentPane().add(btnForwardToHmc);

		btnBack = new JButton("Back");
		btnBack.setEnabled(false);
		btnBack.setBounds(295, 539, 88, 23);
		getContentPane().add(btnBack);
		
		lblHmcFinalAtr = new JLabel("Warden Final ATR");
		lblHmcFinalAtr.setBounds(10, 338, 166, 24);
		getContentPane().add(lblHmcFinalAtr);
		
		txtrFinalATR = new JTextArea();
		txtrFinalATR.setEditable(false);
		txtrFinalATR.setBounds(10, 361, 624, 68);
		getContentPane().add(txtrFinalATR);
		btnBack.addActionListener(this);

		btnExit.addActionListener(this);
		btnNext.addActionListener(this);
		btnForwardToHmc.addActionListener(this);
		btnUpdateATR.addActionListener(this);
		i = -1;
		query = "SELECT * FROM `hms`.`complaints` WHERE `isResolved` = 0";
		System.out.println(query);
		complaints = resultQuery(query);
		try {
			if (!complaints.last()) {
				txtrComplaint.setText("NO COMPLAINTS!");
			}
			computeComplaintsList(complaints);
			i++;
			while (i < id.size()) {
				String studId = id.get(i);
				String tempQuery = "SELECT * FROM `hms`.`studentdetail` WHERE `id` LIKE '"
						+ studId + "' AND `hallcode` LIKE '" + hallCode + "'";
				System.out.println(tempQuery);
				ResultSet rs = resultQuery(tempQuery);

				if (rs.last()) {
					lblComplaintNo.setText("Complaint No: " + cno.get(i));
					lblStudentNo.setText("Student No: " + id.get(i));
					txtrHmcAtr.setText(HMCATR.get(i));
					txtrWardenATR.setText(wardenATR.get(i));
					txtrComplaint.setText(comp.get(i));
					txtrFinalATR.setText(wardenFinal.get(i));
					if(HMCATR.get(i).length() < 2){
						txtrFinalATR.setEnabled(false);
						txtrFinalATR.setEditable(false);
					}
					if (isForwarded.get(i).equals("1")) {
						btnForwardToHmc.setEnabled(false);
						btnForwardToHmc.setText("Forwarded");
					}
					break;
				}

			}
			System.out.println(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void computeComplaintsList(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			complaints.beforeFirst();
			complaints.next();
			while (complaints.getRow() != 0) {

				id.add(complaints.getString("id"));
				cno.add(complaints.getString("no"));
				System.out.println(id.get(id.size() - 1));
				comp.add(complaints.getString("complaint"));
				wardenATR.add(complaints.getString("wardenATR"));
				wardenFinal.add(complaints.getString("wardenFilanATR"));
				isForwarded.add(complaints.getString("isForwarded"));
				HMCATR.add(complaints.getString("HMCATR"));
				complaints.next();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnExit)) {

			this.dispose();

		} else if (e.getSource().equals(btnNext)) {
			int flag = 0;
			System.out.println("1");
			try {
				i++;
				while (i < id.size()) {
					btnBack.setEnabled(true);
					String studId = id.get(i);
					String tempQuery = "SELECT * FROM `hms`.`studentdetail` WHERE `id` LIKE '"
							+ studId
							+ "' AND `hallcode` LIKE '"
							+ hallCode
							+ "'";
					ResultSet rs = resultQuery(tempQuery);
					if (rs.last()) {
						flag = 1;
						System.out.println(id.get(i));
						lblComplaintNo.setText("Complaint No: " + cno.get(i));
						lblStudentNo.setText("Student No: " + id.get(i));
						txtrHmcAtr.setText(HMCATR.get(i));
						txtrWardenATR.setText(wardenATR.get(i));
						txtrComplaint.setText(comp.get(i));
						if (isForwarded.get(i).equals("1")) {
							btnForwardToHmc.setEnabled(false);
							btnForwardToHmc.setText("Forwarded");
						} else {
							btnForwardToHmc.setEnabled(true);
							btnForwardToHmc.setText("Forward to HMC");
						}
						if(HMCATR.get(i).length() < 2){
							txtrFinalATR.setEnabled(false);
							txtrFinalATR.setEditable(false);
						}
						else{
							txtrFinalATR.setEnabled(true);
							txtrFinalATR.setEditable(true);
						}
						break;
					}

				}
				if (flag == 0) {
					i--;
					JOptionPane.showMessageDialog(null, "No More Complaints!");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				// JOptionPane.showMessageDialog(null, "No More Complaints!");
			}

		} else if (e.getSource().equals(btnUpdateATR)) {
			if (txtrWardenATR.getText() != null) {
				String query = "UPDATE `hms`.`complaints` SET `wardenATR` = '"
						+ txtrWardenATR.getText()
						+ "' WHERE `complaints`.`no` = '" + cno.get(i) + "'";
				updateQuery(query);
				wardenATR.set(i, txtrWardenATR.getText());
			} else {
				JOptionPane.showMessageDialog(null, "Please enter your ATR!");
			}
		} else if (e.getSource().equals(btnForwardToHmc)) {
			String query = "UPDATE `hms`.`complaints` SET `isForwarded` = '1' WHERE `complaints`.`no` = '"
					+ cno.get(i) + "'";
			updateQuery(query);
			btnForwardToHmc.setEnabled(false);
			btnForwardToHmc.setText("Forwarded");
		} else if (e.getSource().equals(btnBack)) {
			int flag = 0;
			System.out.println(i);
			try {
				i--;
				while (i < id.size()) {
					if (i == 0)
						btnBack.setEnabled(false);
					String studId = id.get(i);
					String tempQuery = "SELECT * FROM `hms`.`studentdetail` WHERE `id` LIKE '"
							+ studId
							+ "' AND `hallcode` LIKE '"
							+ hallCode
							+ "'";
					ResultSet rs = resultQuery(tempQuery);
					if (rs.last()) {
						flag = 1;
						System.out.println(id.get(i));
						lblComplaintNo.setText("Complaint No: " + cno.get(i));
						lblStudentNo.setText("Student No: " + id.get(i));
						txtrHmcAtr.setText(HMCATR.get(i));
						txtrWardenATR.setText(wardenATR.get(i));
						txtrComplaint.setText(comp.get(i));
						if (isForwarded.get(i).equals("1")) {
							btnForwardToHmc.setEnabled(false);
							btnForwardToHmc.setText("Forwarded");
						} else {
							btnForwardToHmc.setEnabled(true);
							btnForwardToHmc.setText("Forward to HMC");
						}
						if(HMCATR.get(i).length() < 2){
							txtrFinalATR.setEnabled(false);
							txtrFinalATR.setEditable(false);
						}
						else{
							txtrFinalATR.setEnabled(true);
							txtrFinalATR.setEditable(true);
						}
						break;
					}

				}
				if (flag == 0) {
					// JOptionPane.showMessageDialog(null,
					// "No More Complaints!");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				// JOptionPane.showMessageDialog(null, "No More Complaints!");
			}
		}
	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
