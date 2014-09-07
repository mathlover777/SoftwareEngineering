package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class AddEmp extends JDialog {
	
	private static final long serialVersionUID = -4665833514649110787L;
	private JTextField name;
	private JTextField phone;
	private JTextField email;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	private JComboBox box;
	private JButton save;
	private JButton exit;
	private JTextArea address;
	private JTextField id;
	private JTextField account;
	private Bridge bridge;

	/**
	 * Create the frame.
	 */
	
	public static void main(String[] args) {
		try {
			AddEmp dialog = new AddEmp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public AddEmp() {
		
		/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		
		
		setModal(true);
		setBounds(50,50,1000,600);
		getContentPane().setLayout(null);

		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(28, 28, 107, 35);
		getContentPane().add(lblType);

		box = new JComboBox();
		box.setModel(new DefaultComboBoxModel(new String[] {"Clerk", "Gardener", "Attendant", "MessManager"}));
		box.setBounds(146, 28, 193, 34);
		getContentPane().add(box);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 83, 749, 2);
		getContentPane().add(separator);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 107, 125, 24);
		getContentPane().add(lblName);

		name = new JTextField();
		name.setBounds(146, 102, 193, 35);
		getContentPane().add(name);
		name.setColumns(10);

		JLabel lblPhNo = new JLabel("Ph No:");
		lblPhNo.setBounds(10, 159, 125, 24);
		getContentPane().add(lblPhNo);

		phone = new JTextField();
		phone.setBounds(146, 154, 193, 35);
		getContentPane().add(phone);
		phone.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 214, 55, 16);
		getContentPane().add(lblEmail);

		email = new JTextField();
		email.setBounds(143, 203, 196, 35);
		getContentPane().add(email);
		email.setColumns(10);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(10, 258, 125, 24);
		getContentPane().add(lblAddress);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(146, 258, 384, 145);
		getContentPane().add(scrollPane);

		address = new JTextArea();
		scrollPane.setViewportView(address);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(351, 159, 108, 24);
		getContentPane().add(lblPassword);

		password = new JPasswordField();
		password.setBounds(522, 155, 227, 32);
		getContentPane().add(password);

		JLabel lblConfirmpassword = new JLabel("Confirm-Password :");
		lblConfirmpassword.setBounds(351, 212, 135, 20);
		getContentPane().add(lblConfirmpassword);

		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(522, 195, 227, 35);
		getContentPane().add(confirmPassword);

		save = new JButton("Save");
		save.setBounds(403, 22, 167, 46);
		getContentPane().add(save);

		exit = new JButton("Exit");
		exit.setBounds(592, 22, 167, 46);
		getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(349, 244, 399, 2);
		getContentPane().add(separator_1);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(353, 111, 55, 16);
		getContentPane().add(lblId);
		
		id = new JTextField();
		id.setBounds(522, 105, 227, 32);
		getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblAccountNo = new JLabel("Account No :");
		lblAccountNo.setBounds(542, 262, 154, 24);
		getContentPane().add(lblAccountNo);
		
		account = new JTextField();
		account.setBounds(542, 298, 218, 35);
		getContentPane().add(account);
		account.setColumns(10);
		
		
		/****************ActionListener Code*********************/
		save.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					addEmployee();
				}
				
			}
		);
	}
	@SuppressWarnings("deprecation")
	private boolean addEmployee(){
		
		String passtext=password.getText();
		String confirmpasstext=confirmPassword.getText();
		/*
		String passtext="1234";
		String confirmpasstext="1234";
		*/
		if(passtext.equals(null)){
			//throw exception			
		}
		if(!passtext.equals(confirmpasstext)){
			//throw
		}
		
		
		
		/*
		String nametext=name.getText();
		String phonetext=phone.getText();
		String emailtext=email.getText();
		String addresstext=address.getText();
		String idtext=id.getText();
		String accounttext=account.getText();
		String boxtext=(String) box.getSelectedItem();//to check !!
		String hallcode="not recruited";
		*/
		
		/*********************Values given for unit testing*********************************/
		String nametext="anirban";
		String phonetext="67509869";
		String emailtext="ac@gmail.com";
		String addresstext="kolkata westbengal";
		String idtext="1111";
		String accounttext="A100001";
		String boxtext="gardener";
		String hallcode="not recruited";
		/***********************************************************************************/
		
		
		if(nametext==null){
			//throw exception
		}
		if(phonetext.equals("")){
			phonetext="not available";
		}
		if(emailtext.equals("")){
			emailtext="not available";
		}
		if(addresstext.equals("")){
			addresstext="not available";
		}
		if(idtext.equals("")){
			//throw exception
		}
		if(accounttext.equals("")){
			//throw exception
		}
		
		/***************Check For Existing ID********************/
		if(checkID(idtext)){
			System.out.println("id already exists !!! ");
			return false;
		}
		
		
		/************The SQl QUERY STARTING****************/
		Connection con = null;	
		try{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver
			String url ="jdbc:mysql://"+bridge.getHost()+":"+bridge.getPort()+"/hms";
			con = DriverManager.getConnection(url,bridge.getUser(), bridge.getPass());
			System.out.println("connection Established");
		}catch(Exception e) {
			System.out.println("Couldnt get connection");
			//throw
		}
		String query="INSERT INTO `"+"hms"+"`.`workerlist` (`no` ,`id` ,`type` ,`hallcode` ,`name` ,`contact` ,`email` ,`address` ,`dailysalary`,`account` ,`password`)"+
				"VALUES (NULL , '"+idtext+"','"+boxtext+"','"+hallcode+"','"+nametext+"','"+phonetext+"','"+emailtext+"','"+addresstext+"','"+"100','"+accounttext+"','"+
				passtext+"');";
		
		System.out.println("query="+query);
		
		
		Statement st = null;
		try {
			st = con.createStatement();
			st.executeUpdate(query);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	private boolean checkID(String idtext){
		
		/************The SQl QUERY STARTING****************/
		Connection con = null;	
		try{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver
			String url ="jdbc:mysql://"+bridge.getHost()+":"+bridge.getPort()+"/hms";
			con = DriverManager.getConnection(url,bridge.getUser(), bridge.getPass());
			System.out.println("connection Established");
		}catch(Exception e) {
			System.out.println("Couldnt get connection");
			//throw
		}
		String query="SELECT * FROM `hms`.`workerlist` WHERE `id`='"+idtext+"'";
		
		System.out.println("query="+query);
		
		
		Statement st = null;
		ResultSet rs=null;
		//int success;
		try {
			st = con.createStatement();
			rs=st.executeQuery(query);
			rs.last();
			if(rs.getRow()==0){
				System.out.println("Result List is empty !!");
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
