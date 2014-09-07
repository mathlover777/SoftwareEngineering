package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.sql.ResultSet;

public class addHall extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5939426828501697387L;

	private JTextField hallname;
	private JTextField singlecount;
	private JTextField doublecount;
	private JTextField singlerent;
	private JTextField doublerent;
	private JTextField hallcode;
	private JRadioButton old;
	private JRadioButton New;
	private JButton save;
	private JButton exit;
	private JComboBox messManager;
	private JComboBox warden;

	/**************************** HALL DATA ************************/
	private String status = "";
	private String hallName = "", hallCode = "";
	int singleRoomCount, doubleRoomCount, singleRoomRent, doubleRoomRent;
	private String wardenId = "", messManagerId = "";
	private String wardenIdList[], wardenNameList[], messManagerIdList[],
			messManagerNameList[];
	private int wardenCount, messManagerCount;

	private Bridge bridge;

	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		try {
			addHall dialog = new addHall();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public addHall() {
/********************Extra Code************************/
		
		try {
			bridge = new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(50,50,1000,600);
		setBackground(Color.GRAY);
		getContentPane().setLayout(null);

		JLabel lblEnterHallName = new JLabel("Enter Hall Name :");
		lblEnterHallName.setBounds(10, 21, 167, 30);
		getContentPane().add(lblEnterHallName);

		hallname = new JTextField();
		hallname.setBounds(204, 26, 242, 25);
		getContentPane().add(hallname);
		hallname.setColumns(10);

		JLabel lblEnterOf = new JLabel("Enter # of Single Rooms :");
		lblEnterOf.setBounds(10, 131, 167, 30);
		getContentPane().add(lblEnterOf);

		JLabel lblEnterOf_1 = new JLabel("Enter # of Double Rooms :");
		lblEnterOf_1.setBounds(390, 131, 167, 30);
		getContentPane().add(lblEnterOf_1);

		JLabel lblSingleRoomRent = new JLabel("Single Room Rent :");
		lblSingleRoomRent.setBounds(10, 172, 167, 30);
		getContentPane().add(lblSingleRoomRent);

		JLabel lblDoubleRoomRent = new JLabel("Double Room Rent :");
		lblDoubleRoomRent.setBounds(390, 172, 167, 30);
		getContentPane().add(lblDoubleRoomRent);

		JLabel lblHallStatus = new JLabel("Hall Status :");
		lblHallStatus.setBounds(10, 60, 167, 30);
		getContentPane().add(lblHallStatus);

		JLabel lblAssignWarden = new JLabel("Assign Warden :");
		lblAssignWarden.setBounds(10, 243, 176, 30);
		getContentPane().add(lblAssignWarden);

		JLabel lblAssignMessManager = new JLabel("Assign Mess Manager :");
		lblAssignMessManager.setBounds(10, 285, 176, 35);
		getContentPane().add(lblAssignMessManager);

		singlecount = new JTextField();
		singlecount.setBounds(204, 136, 86, 25);
		getContentPane().add(singlecount);
		singlecount.setColumns(10);

		doublecount = new JTextField();
		doublecount.setBounds(567, 136, 86, 25);
		getContentPane().add(doublecount);
		doublecount.setColumns(10);

		singlerent = new JTextField();
		singlerent.setBounds(204, 177, 86, 25);
		getContentPane().add(singlerent);
		singlerent.setColumns(10);

		doublerent = new JTextField();
		doublerent.setBounds(567, 177, 86, 25);
		getContentPane().add(doublerent);
		doublerent.setColumns(10);

		old = new JRadioButton("Old");
		old.setBackground(Color.GRAY);
		old.setBounds(204, 64, 86, 23);
		getContentPane().add(old);

		New = new JRadioButton("New");
		New.setBackground(Color.GRAY);
		New.setBounds(292, 64, 77, 23);
		getContentPane().add(New);

		warden = new JComboBox();
		warden.setModel(new DefaultComboBoxModel(
				new String[] { "Select Warden" }));
		warden.setBounds(204, 246, 242, 25);
		getContentPane().add(warden);

		messManager = new JComboBox();
		messManager.setModel(new DefaultComboBoxModel(
				new String[] { "Select MessManager" }));
		messManager.setBounds(204, 290, 242, 25);
		getContentPane().add(messManager);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 115, 727, 2);
		getContentPane().add(separator);

		JLabel lblpm = new JLabel("/PM");
		lblpm.setBounds(300, 139, 46, 14);
		getContentPane().add(lblpm);

		JLabel lblpm_1 = new JLabel("/PM");
		lblpm_1.setBounds(300, 180, 46, 14);
		getContentPane().add(lblpm_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 230, 727, 2);
		getContentPane().add(separator_1);

		JLabel lblHallCode = new JLabel("Hall Code :");
		lblHallCode.setBounds(456, 29, 94, 25);
		getContentPane().add(lblHallCode);

		hallcode = new JTextField();
		hallcode.setBounds(559, 23, 94, 25);
		getContentPane().add(hallcode);
		hallcode.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 333, 727, 2);
		getContentPane().add(separator_2);

		save = new JButton("Save Hall Detail");
		save.setBounds(10, 367, 136, 23);
		getContentPane().add(save);

		exit = new JButton("Exit");
		exit.setBounds(333, 367, 167, 25);
		getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		/*********************** New Codes ************************************/

		status = "new";
		New.setSelected(true);
		old.setSelected(false);

		try {
			fetchInformation();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		old.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				status = "old";
				New.setSelected(false);
			}

		});
		New.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				status = "new";
				old.setSelected(false);
			}

		});
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (addData()) {
						setupHallDataBase(hallCode);
					}
					resetAll();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}

		});
	}

	private boolean resetAll() throws SQLException {

		hallname.setText("");
		hallcode.setText("");
		New.setSelected(true);
		old.setSelected(false);
		status = "new";
		singlecount.setText("");
		doublecount.setText("");
		singlerent.setText("");
		doublerent.setText("");

		fetchInformation();
		warden.setSelectedIndex(0);
		messManager.setSelectedIndex(0);

		return true;
	}

	private boolean addData() throws SQLException {

		/*hallCode = "" + hallcode.getText();
		hallName = "" + hallname.getText();
		singleRoomCount = (int) (Integer.parseInt(singlecount.getText()));
		doubleRoomCount = (int) (Integer.parseInt(doublecount.getText()));
		singleRoomRent = (int) (Integer.parseInt(singlerent.getText()));
		doubleRoomRent = (int) (Integer.parseInt(doublerent.getText()));
		*/
		
		/**************Code For Unit Testing*****************************/
		hallCode = "VS";
		hallName = "VidyaSagar Hall of Residence";
		singleRoomCount = 10;
		doubleRoomCount = 5;
		singleRoomRent = 100;
		doubleRoomRent = 75;
		wardenId = "mess2";
		messManagerId = "w1";
		/******************************************************************/
		
		
		/*
		if (warden.getSelectedIndex() == 0
				|| messManager.getSelectedIndex() == 0) {
			return false;
		}*/

		String query = "";

		query = "SELECT * FROM `hms`.`halldata` WHERE `hallname` LIKE '"
				+ hallName + "' OR `hallcode` LIKE '" + hallcode + "'";
		ResultSet rs = resultQuery(query);
		/*if (rs.getRow() != 0) {
			return false;
		}*/

		/************** Hall Can be added to Data Base ********************/

		/*wardenId = "" + wardenIdList[warden.getSelectedIndex() - 1];
		messManagerId = ""
				+ messManagerIdList[messManager.getSelectedIndex() - 1];*/

		query = "INSERT INTO `hms`.`halldata` (`no`,`hallname`,`hallcode`,`status`,`singlecount`,`doublecount`,`singlefilled`,`doublefilled`,`singlerent`,`doublerent`,"
				+ "`amenitycharge`,`wardenid`,`messmanagerid`)VALUES(NULL,'"
				+ hallName
				+ "','"
				+ hallCode
				+ "','"
				+ status
				+ "','"
				+ singleRoomCount
				+ "','"
				+ doubleRoomCount
				+ "','"
				+ 0
				+ "','"
				+ 0
				+ "','"
				+ singleRoomRent
				+ "','"
				+ doubleRoomRent
				+ "','"
				+ 0 + "','" + wardenId + "','" + messManagerId + "')";
		
		System.out.println("query = " + query);

		updateQuery(query);

		/******************* updating warden and worker database ************/

		/*
		 * UPDATE `hms`.`wardenlist` SET `hall` = 'ms' WHERE `wardenlist`.`no`
		 * =4;
		 */

		query = "UPDATE `hms`.`wardenlist` SET `hallcode` = '" + hallCode
				+ "' WHERE `wardenlist`.`id` LIKE '" + wardenId + "'";

		System.out.println("query = " + query);

		updateQuery(query);

		query = "UPDATE `hms`.`workerlist` SET `hallcode` = '" + hallCode
				+ "' WHERE `workerlist`.`id` LIKE '" + messManagerId + "'";

		System.out.println("query = " + query);

		updateQuery(query);

		query = "INSERT INTO `hms`.`hallaccount` (`no` ,`hallname` ,`hallcode` ,`messaccount` ,`amenityaccount` ,`roomrentaccount` ,"
				+ "`miscaccount` ,`repairaccount`)VALUES (NULL , '"
				+ hallName
				+ "', '" + hallCode + "', '0', '0', '0', '0', '0')";

		updateQuery(query);

		/******************* Setting up hallAccount logs ****************************/
		query = "CREATE TABLE `"
				+ hallCode
				+ "_roomaccount_log` (`year` varchar(5) NOT NULL, `date` varchar(10) NOT NULL, `time` varchar(10) NOT NULL,"
				+ "`statement` tinytext NOT NULL, `startingbalance` int(11) NOT NULL, `endingbalance` int(11) NOT NULL,"
				+ "`type` varchar(10) NOT NULL, `id` varchar(20) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1";
		updateQuery(query);
		query = "CREATE TABLE `"
				+ hallCode
				+ "_repairaccount_log` ( `year` varchar(5) NOT NULL,`date` varchar(10) NOT NULL, `time` varchar(10) NOT NULL,"
				+ "`statement` tinytext NOT NULL, `startingbalance` int(11) NOT NULL, `endingbalance` int(11) NOT NULL,"
				+ "`type` varchar(10) NOT NULL, `id` varchar(20) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1";
		updateQuery(query);
		query = "CREATE TABLE `"
				+ hallCode
				+ "_amenityaccount_log` ( `year` varchar(5) NOT NULL,`date` varchar(10) NOT NULL, `time` varchar(10) NOT NULL,"
				+ "`statement` tinytext NOT NULL, `startingbalance` int(11) NOT NULL, `endingbalance` int(11) NOT NULL,"
				+ "`type` varchar(10) NOT NULL, `id` varchar(20) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1";
		updateQuery(query);
		query = "CREATE TABLE `"
				+ hallCode
				+ "_salaryaccount_log` (`year` varchar(5) NOT NULL, `date` varchar(10) NOT NULL, `time` varchar(10) NOT NULL,"
				+ "`statement` tinytext NOT NULL, `startingbalance` int(11) NOT NULL, `endingbalance` int(11) NOT NULL,"
				+ "`type` varchar(10) NOT NULL, `id` varchar(20) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1";
		updateQuery(query);
		query = "CREATE TABLE `"
				+ hallCode
				+ "_miscaccount_log` (`year` varchar(5) NOT NULL, `date` varchar(10) NOT NULL, `time` varchar(10) NOT NULL,"
				+ "`statement` tinytext NOT NULL, `startingbalance` int(11) NOT NULL, `endingbalance` int(11) NOT NULL,"
				+ "`type` varchar(10) NOT NULL, `id` varchar(20) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1";
		updateQuery(query);
		query = "CREATE TABLE `"
				+ hallCode
				+ "_messaccount_log` ( `year` varchar(5) NOT NULL,`date` varchar(10) NOT NULL, `time` varchar(10) NOT NULL,"
				+ "`statement` tinytext NOT NULL, `startingbalance` int(11) NOT NULL, `endingbalance` int(11) NOT NULL,"
				+ "`type` varchar(10) NOT NULL, `id` varchar(20) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1";
		updateQuery(query);
		return true;
	}

	private boolean fetchInformation() throws SQLException {

		/**************** Fetching Warden List *************************/
		String query = "";
		ResultSet rs = null;

		query = "SELECT `name`,`id` FROM `hms`.`wardenlist` WHERE `hallcode` LIKE 'not assigned'";
		rs = resultQuery(query);

		rs.last();
		wardenCount = rs.getRow();
		rs.beforeFirst();
		rs.next();

		wardenIdList = new String[wardenCount];
		wardenNameList = new String[wardenCount + 1];
		// System.out.println("warden Count = "+wardenCount
		// +"row = "+rs.getRow());
		wardenNameList[0] = "Select Warden";
		for (int i = 1; i <= wardenCount; i++) {
			// System.out.println("Name = "+rs.getString("name"));
			wardenNameList[i] = "" + rs.getString("name");
			wardenIdList[i - 1] = "" + rs.getString("id");
			rs.next();
		}

		warden.setModel(new DefaultComboBoxModel(wardenNameList));

		query = "SELECT `name`,`id` FROM `hms`.`workerlist` WHERE `type` LIKE 'messManager' AND `hallcode` IN ('not assigned','not recruited')";
		rs = resultQuery(query);

		rs.last();
		messManagerCount = rs.getRow();
		rs.beforeFirst();
		rs.next();
		System.out.println("MessManagerCount = " + messManagerCount);
		messManagerIdList = new String[messManagerCount];
		messManagerNameList = new String[messManagerCount + 1];
		messManagerNameList[0] = "Select Mess Manager";
		for (int i = 1; i <= messManagerCount; i++) {
			messManagerNameList[i] = "" + rs.getString("name");
			messManagerIdList[i - 1] = "" + rs.getString("id");
			rs.next();
		}
		messManager.setModel(new DefaultComboBoxModel(messManagerNameList));

		return true;
	}

	private boolean setupHallDataBase(String code) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Initialize the driver
			String url = "jdbc:mysql://localhost:3306/hms";
			con = DriverManager.getConnection(url, "sourav", "qwerty");
			System.out.println("connection Established");
		} catch (Exception e) {
			System.out.println("Couldnt get connection");
		}

		Statement st = null;
		String query = "";
		try {
			st = con.createStatement();

			query = "CREATE TABLE `hms`.`"
					+ code
					+ "_studentlist` ( `roomno` int(11) NOT NULL AUTO_INCREMENT , `type` tinytext NOT NULL,`student1id` tinytext NOT NULL,"
					+ "`student1name` tinytext NOT NULL,`student2id` tinytext NOT NULL,`student2name` tinytext NOT NULL, UNIQUE KEY `roomno` (`roomno`)"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";
			st = con.createStatement();
			st.executeUpdate(query);

			query = "INSERT INTO `hms`.`"
					+ code
					+ "_studentlist` (`roomno` ,`type` ,`student1id` ,`student1name` ,`student2id` ,`student2name`)VALUES"
					+ " (NULL, 'single', 'empty', 'empty', 'empty', 'empty')";
			st = con.createStatement();
			for (int i = 0; i <= singleRoomCount - 1; i++) {
				st.executeUpdate(query);
			}
			query = "INSERT INTO `hms`.`"
					+ code
					+ "_studentlist` (`roomno` ,`type` ,`student1id` ,`student1name` ,`student2id` ,`student2name`)VALUES"
					+ " (NULL, 'double', 'empty', 'empty', 'empty', 'empty')";
			st = con.createStatement();
			for (int i = 0; i <= doubleRoomCount - 1; i++) {
				st.executeUpdate(query);
			}

			/************** setting up the grant table for the hall **************************/
			query = "INSERT INTO `hms`.`granttable` (`no`,`hallcode` ,`status` ,`csalary` ,`gsalary` ,`asalary` ,"
					+ "`mcharges` ,`gcount` ,`acount`)VALUES (NULL,'"
					+ code
					+ "', 'not submitted', '0', '0', '0', '0', '0', '0');";
			st = con.createStatement();
			st.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * initially was return false
		 */
		return true;
	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}

}
