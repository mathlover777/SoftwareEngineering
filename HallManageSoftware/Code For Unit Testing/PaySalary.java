package code;

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

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class PaySalary extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 526165155701094015L;
	private JPanel contentPane;
	private JTextField Topay;
	private JTextField Oname;
	private JTextField Oaccount;
	private JTextField Oamount;
	private JComboBox Name;
	private JRadioButton salaryoption;
	private JRadioButton otheroption;
	private JTextArea Ostatement;
	private JButton Pay;
	private JComboBox Otype;

	/**
	 * Create the frame.
	 */

	/************************ EXTRA DATA ***********************************/
	private int paymentType = 0, sindex = 0;
	private int amount = 0;
	private String account;
	private String id = "", statement = "", name = "", accountType = "",
			idList[], accountList[], type[], nameList[];
	private int wCount = 0, present[], salary[];
	private int toPay[];

	private String hallCode = "";// input data
	private Bridge bridge;

	public PaySalary(String hallcode) {
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		
		setModal(true);
		setBounds(100, 100, 823, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSelectPayment = new JLabel("Select Payment :");
		lblSelectPayment.setBounds(23, 32, 132, 29);
		contentPane.add(lblSelectPayment);

		salaryoption = new JRadioButton("Salary");
		salaryoption.setBounds(167, 37, 115, 18);
		contentPane.add(salaryoption);

		otheroption = new JRadioButton("Others");
		otheroption.setBounds(294, 37, 115, 18);
		contentPane.add(otheroption);

		JSeparator separator = new JSeparator();
		separator.setBounds(366, 53, 435, 8);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 83, 778, 2);
		contentPane.add(separator_1);

		JLabel lblSelectEmployee = new JLabel("Select Employee :");
		lblSelectEmployee.setBounds(23, 122, 132, 29);
		contentPane.add(lblSelectEmployee);

		Name = new JComboBox();
		Name.setModel(new DefaultComboBoxModel(
				new String[] { "Select Employee" }));
		Name.setBounds(167, 117, 194, 38);
		contentPane.add(Name);

		JLabel lblToPay = new JLabel("To Pay :");
		lblToPay.setBounds(23, 179, 121, 29);
		contentPane.add(lblToPay);

		Topay = new JTextField();
		Topay.setBounds(167, 174, 194, 38);
		contentPane.add(Topay);
		Topay.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(23, 235, 778, 8);
		contentPane.add(separator_2);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(26, 287, 67, 29);
		contentPane.add(lblName);

		Oname = new JTextField();
		Oname.setBounds(131, 282, 231, 38);
		contentPane.add(Oname);
		Oname.setColumns(10);

		JLabel lblAccount = new JLabel("Account :");
		lblAccount.setBounds(23, 348, 55, 16);
		contentPane.add(lblAccount);

		Oaccount = new JTextField();
		Oaccount.setBounds(131, 342, 231, 38);
		contentPane.add(Oaccount);
		Oaccount.setColumns(10);

		JLabel lblStatement = new JLabel("StateMent :");
		lblStatement.setBounds(686, 287, 115, 29);
		contentPane.add(lblStatement);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(395, 326, 406, 105);
		contentPane.add(scrollPane);

		Ostatement = new JTextArea();
		scrollPane.setViewportView(Ostatement);

		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setBounds(23, 399, 88, 32);
		contentPane.add(lblAmount);

		Oamount = new JTextField();
		Oamount.setBounds(131, 393, 231, 38);
		contentPane.add(Oamount);
		Oamount.setColumns(10);

		Otype = new JComboBox();
		Otype.setModel(new DefaultComboBoxModel(new String[] {"Select Account", "mess", "salary", "repair", "room", "misc", "amenity"}));
		Otype.setBounds(393, 282, 256, 38);
		contentPane.add(Otype);

		Pay = new JButton("PAY");
		Pay.setBounds(476, 122, 132, 51);
		contentPane.add(Pay);

		/***************** NEW CODE *************************************/
		hallCode = "" + hallcode;
		salaryoption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				otheroption.setSelected(false);
				paymentType = 0;
			}

		});

		otheroption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				salaryoption.setSelected(false);
				paymentType = 1;
			}

		});

		/****************************************************************/
		try {
			getData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Name.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				sindex = Name.getSelectedIndex();
				if (sindex != 0) {
					Topay.setText("" + toPay[sindex - 1]);
				}
			}

		});
		Pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					pay();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

	}

	private boolean pay() throws NumberFormatException, SQLException {
		if (paymentType == 0) {
			if (sindex == 0) {
				return false;
			}
			sindex--;
			if ((type[sindex].toLowerCase()).equals("messmanager")) {

				accountType = "mess";
			} else if ((type[sindex].toLowerCase()).equals("clerk")) {
				accountType = "salary";
			} else {
				accountType = "salary";
			}
			name = "" + nameList[sindex + 1];
			id = "" + idList[sindex];
			account = accountList[sindex];
			amount = toPay[sindex];
			statement = "Warden Pays Salary to " + name + "(" + account + ")";
		} else {
			// payment to some random person
			name = "" + Oname.getText();
			account = "" + Oaccount.getText();
			amount = (int) (Integer.parseInt(Oamount.getText()));
			statement = Ostatement.getText() + "(paid by Warden)";
			accountType = (String) Otype.getSelectedItem();
		}

		/****************** 1st query to hallaccount *******************************************/
		/*
		 * int prevBal,newBal; query="SELECT `"+accountType+
		 * "account` FROM `hms`.`hallaccount` WHERE `hallcode` LIKE '"
		 * +hallCode+"'"; System.out.println(query); ResultSet
		 * x=resultQuery(query); x.last(); System.out.println(x.getRow());
		 * prevBal=(int)(Integer.parseInt(x.getString(accountType+"account")));
		 * newBal=prevBal-amount;
		 * query="UPDATE `hms`.`hallaccount` SET `"+accountType
		 * +"account` = '"+newBal+"' WHERE `hallcode` LIKE '"+hallCode+"'";
		 * updateQuery(query);
		 * query="INSERT INTO `hms`.`"+hallCode+"_"+accountType+
		 * "account_log` (`year`,`date` ,`time` ,`statement` ,`startingbalance` ,`endingbalance` ,`type` ,`id`"
		 * +
		 * ")VALUES (YEAR( ),CURDATE( ) , CURTIME( ) , ' "+statement+"', '"+prevBal
		 * +"', '"+newBal+"', 'out', 'HMC')";
		 * 
		 * System.out.println(query); updateQuery(query);
		 */
		if (GenericPay.pay("out", hallCode, accountType, amount, statement,
				"WARDEN_" + hallCode)) {
			GenerateCheque.generate(name, id, "" + amount, name + "_cheque",
					"C:/comp/pdfdata/", account);
		}
		return true;
	}

	private void getData() throws SQLException {
		String query = "";
		query = "SELECT * FROM `hms`.`workerlist` WHERE `hallcode` LIKE '"
				+ hallCode + "'";
		ResultSet rs = resultQuery(query);
		rs.last();
		wCount = rs.getRow();
		System.out.println("wcount = " + wCount);
		if (wCount == 0) {
			return;
		}
		rs.beforeFirst();
		rs.next();
		idList = new String[wCount];
		accountList = new String[wCount];
		salary = new int[wCount];
		present = new int[wCount];
		nameList = new String[wCount + 1];
		idList = new String[wCount];
		type = new String[wCount];
		toPay = new int[wCount];
		for (int i = 0; i <= wCount - 1; i++) {
			idList[i] = rs.getString("id");
			accountList[i] = rs.getString("account");
			salary[i] = (int) (Integer.parseInt(rs.getString("dailysalary")));
			present[i] = (int) (Integer.parseInt(rs.getString("present")));
			nameList[i + 1] = rs.getString("name");
			idList[i] = rs.getString("id");
			type[i] = rs.getString("type");
			rs.next();
			if ((type[i].toLowerCase()).equals("messmanager")) {
				query = "SELECT `messaccount` FROM `hms`.`hallaccount` WHERE `hallcode` LIKE '"
						+ hallCode + "'";
				System.out.println(query);
				ResultSet x = resultQuery(query);
				x.last();
				System.out.println("" + x.getRow());
				x.beforeFirst();
				x.next();
				toPay[i] = (int) (Integer.parseInt(x.getString("messaccount")));
				continue;
			}
			if ((type[i].toLowerCase()).equals("clerk")) {
				toPay[i] = 100 * 31;
				continue;
			}
			toPay[i] = present[i] * 100;
		}
		nameList[0] = "Select Employee";
		Name.setModel(new DefaultComboBoxModel(nameList));

	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
