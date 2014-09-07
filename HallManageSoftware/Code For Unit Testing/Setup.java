package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Setup extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7085472343022029292L;
	private JTextField Host;
	private JPasswordField Pass;
	private JTextField User;
	private JButton deploy;
	private JButton exit;
	private JButton ok;

	/**
	 * Create the panel.
	 */

	private boolean success = false;
	private JTextField Port;

	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			Setup dialog = new Setup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/************************************************************/
	
	
	public Setup() {
		getContentPane().setLayout(null);
		setModal(true);
		setBounds(50, 50, 1000, 600);

		JLabel lblHost = new JLabel("Host :");
		lblHost.setBounds(27, 108, 110, 32);
		getContentPane().add(lblHost);

		Host = new JTextField();
		Host.setBounds(149, 105, 246, 38);
		getContentPane().add(Host);
		Host.setColumns(10);

		JLabel lblPassword = new JLabel("PassWord :");
		lblPassword.setBounds(27, 267, 110, 26);
		getContentPane().add(lblPassword);

		Pass = new JPasswordField();
		Pass.setBounds(149, 261, 246, 38);
		getContentPane().add(Pass);

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(27, 218, 110, 26);
		getContentPane().add(lblUserName);

		User = new JTextField();
		User.setBounds(149, 212, 246, 38);
		getContentPane().add(User);
		User.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 86, 816, 7);
		getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(27, 310, 374, 2);
		getContentPane().add(separator_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(421, 108, 410, 335);
		getContentPane().add(scrollPane);

		JTextArea txtrPleaseEnterYour = new JTextArea();
		txtrPleaseEnterYour
				.setText("Please Enter your Mysql details here\r\nYou must have a mysql server Running in the host \r\nwith which you are going to connect\r\n\r\nYour Computer must be connected with internet\r\nIf unable to connect , try disabling firewall and anti virus");
		txtrPleaseEnterYour.setForeground(Color.RED);
		txtrPleaseEnterYour.setLineWrap(true);
		scrollPane.setViewportView(txtrPleaseEnterYour);

		deploy = new JButton("Deploy");
		deploy.setBounds(153, 364, 120, 53);
		getContentPane().add(deploy);

		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit.setBounds(283, 364, 128, 53);
		getContentPane().add(exit);

		ok = new JButton("Save Login");
		ok.setBounds(9, 364, 128, 52);
		getContentPane().add(ok);

		JLabel lblPort = new JLabel("Port :");
		lblPort.setBounds(27, 157, 110, 32);
		getContentPane().add(lblPort);

		Port = new JTextField();
		Port.setBounds(149, 154, 246, 38);
		getContentPane().add(Port);
		Port.setColumns(10);

		/************************* New COde ****************************************/
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					saveLoginData();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		deploy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					setDatabase();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
	}

	@SuppressWarnings("deprecation")
	private void saveLoginData() throws IOException {
		createEmptyFile("logindata.txt");
		addLine("logindata.txt", Host.getText());
		addLine("logindata.txt", Port.getText());
		addLine("logindata.txt", User.getText());
		addLine("logindata.txt", Pass.getText());
	}

	private void setDatabase() throws IOException {
		String query=" 	CREATE TABLE `halldata` ( `no` int(11) NOT NULL AUTO_INCREMENT, `hallname` tinytext NOT NULL, `hallcode` varchar(10) NOT NULL,"+
	" `status` varchar(10) NOT NULL, `singlecount` int(11) NOT NULL, `doublecount` int(11) NOT NULL, `singlefilled` int(11) NOT NULL, `doublefilled` int(11) NOT NULL,"+
				" `singlerent` int(10) NOT NULL, `doublerent` int(10) NOT NULL, `amenitycharge` int(11) NOT NULL, `wardenid` tinytext NOT NULL,"+
	" `messmanagerid` tinytext NOT NULL, PRIMARY KEY (`no`)) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1";
		updateQuery(query);
		query="CREATE TABLE `hallaccount` ( `no` int(11) NOT NULL AUTO_INCREMENT, `hallname` tinytext NOT NULL, `hallcode` varchar(10) NOT NULL,"+
		" `salaryaccount` int(11) NOT NULL DEFAULT '0', `messaccount` int(11) NOT NULL, `amenityaccount` int(11) NOT NULL, `roomrentaccount` int(11) NOT NULL,"+
				" `miscaccount` int(11) NOT NULL, `repairaccount` int(11) NOT NULL, PRIMARY KEY (`no`)) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1";
		updateQuery(query);
		query=" CREATE TABLE `granttable` ( `no` int(11) NOT NULL AUTO_INCREMENT, `hallcode` tinytext NOT NULL, `status` varchar(40) NOT NULL,"+
		" `csalary` int(11) NOT NULL, `gsalary` int(11) NOT NULL, `asalary` int(11) NOT NULL, `mcharges` int(11) NOT NULL, `gcount` int(11) NOT NULL,"+
				" `acount` int(11) NOT NULL, PRIMARY KEY (`no`)) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1"	;
		updateQuery(query);
		query="CREATE TABLE `workerlist` ( `no` int(11) NOT NULL AUTO_INCREMENT, `id` varchar(20) NOT NULL, `type` tinytext NOT NULL, `hallcode` tinytext NOT NULL,"+
		" `name` tinytext NOT NULL, `contact` tinytext NOT NULL, `email` tinytext NOT NULL, `address` tinytext NOT NULL, `present` int(11) NOT NULL DEFAULT '0',"+
				" `absent` int(11) NOT NULL DEFAULT '0', `dailysalary` int(11) NOT NULL DEFAULT '0', `account` tinytext NOT NULL, `password` tinytext NOT NULL,"+
		" PRIMARY KEY (`no`), UNIQUE KEY `id` (`id`)) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1";
		updateQuery(query);
		query="CREATE TABLE `complaints` ( `no` int(11) NOT NULL AUTO_INCREMENT, `id` tinytext NOT NULL, `complaint` text NOT NULL, `wardenATR` text NOT NULL,"+
		" `isForwarded` tinyint(1) NOT NULL DEFAULT '0', `HMCATR` text NOT NULL, `wardenFilanATR` text NOT NULL, `isResolved` tinyint(1) NOT NULL DEFAULT '0',"+
				" PRIMARY KEY (`no`)) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1";
		updateQuery(query);
		query="CREATE TABLE `studentdetail` ( `no` int(11) NOT NULL AUTO_INCREMENT, `name` varchar(100) NOT NULL, `id` varchar(30) NOT NULL,"+
		" `address` text NOT NULL, `phone` varchar(20) NOT NULL, `email` tinytext NOT NULL, `photo` tinytext NOT NULL, `hallcode` tinytext NOT NULL,"+
				" `roomNo` tinytext NOT NULL, `roomtype` varchar(10) NOT NULL, `roomrentdue` int(11) NOT NULL, `messchargedue` int(11) NOT NULL, `amenitychargedue` int(11) NOT NULL,"+
		" `password` text NOT NULL, PRIMARY KEY (`no`), UNIQUE KEY `id` (`id`)) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1";
		updateQuery(query);
		query="CREATE TABLE `wardenlist` ( `no` int(11) NOT NULL AUTO_INCREMENT, `id` tinytext NOT NULL, `hallcode`" +
				" tinytext NOT NULL, `name` tinytext NOT NULL, `contact` tinytext NOT NULL, `email` tinytext NOT NULL," +
				" `address` tinytext NOT NULL, `password` tinytext NOT NULL, PRIMARY KEY (`no`)) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1";
		updateQuery(query);
		success=true;
		
	}

	public boolean isSetupSuccess() {
		return success;
	}

	@SuppressWarnings("unused")
	private ResultSet resultQuery(String query) throws IOException {
		String host = "", port = "", user = "", pass = "";

		/**************** Code to get login data from file *****************************/
		FileInputStream fstream = new FileInputStream("logindata.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		host = "" + br.readLine();
		port = "" + br.readLine();
		user = "" + br.readLine();
		pass = "" + br.readLine();
		br.close();
		in.close();
		fstream.close();
		/*************************************************************************/
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Initialize the driver
			String url = "jdbc:mysql://" + host + ":" + port + "/hms";
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("connection Established");
		} catch (Exception e) {
			System.out.println("Couldnt get connection");
		}

		Statement st = null;
		ResultSet rs = null;
		try {

			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	private int updateQuery(String query) throws IOException {
		String host = "", port = "", user = "", pass = "";

		/**************** Code to get login data from file *****************************/
		FileInputStream fstream = new FileInputStream("logindata.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		host = "" + br.readLine();
		port = "" + br.readLine();
		user = "" + br.readLine();
		pass = "" + br.readLine();
		br.close();
		in.close();
		fstream.close();
		/*************************************************************************/
		Connection con = null;
		int success = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Initialize the driver
			String url = "jdbc:mysql://"+host+":"+port+"/hms";
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("connection Established");
		} catch (Exception e) {
			System.out.println("Couldnt get connection");
		}

		Statement st = null;
		try {
			st = con.createStatement();
			success = st.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	public static void addLine(String file, String line) throws IOException {
		FileInputStream f1 = new FileInputStream(file);
		FileWriter f2 = new FileWriter("tempa.txt");
		BufferedWriter out = new BufferedWriter(f2);
		int i;
		i = f1.read();
		int c = 0;
		if (i == -1) {
			c = 1;
		}
		while (i != -1) {
			out.write((char) i);
			i = f1.read();
		}
		if (c == 0) {
			out.write("\r\n" + line);
		}
		if (c == 1) {
			out.write(line);
		}
		out.close();
		f1.close();
		copyToFile("tempa.txt", file);
	}

	public boolean createEmptyFile(String filename) throws IOException {
		FileWriter f2 = new FileWriter(filename);
		BufferedWriter out = new BufferedWriter(f2);
		out.close();
		f2.close();
		return true;
	}

	public static void copyToFile(String file1, String file2)
			throws IOException {
		FileInputStream f1 = new FileInputStream(file1);
		FileOutputStream f2 = new FileOutputStream(file2);
		int i;
		i = f1.read();
		while (i != -1) {
			f2.write(i);
			i = f1.read();
		}
		f1.close();
		f2.close();
	}
}
