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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class ModifyEmp extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4618855320312577545L;

	private JTextField phone;
	private JTextField email;
	private JTextField id;
	private JTextArea address;
	private JButton delete;
	private JButton exit;
	private JComboBox name;
	private JComboBox emptype;
	private JTextField hall;
	private String[][] data;
	private int dataCount=0;

	private Bridge bridge;

	/**
	 * Create the frame.
	 */
	public ModifyEmp() {
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
		getContentPane().setLayout(null);

		JLabel lblSelectType = new JLabel("Select Type :");
		lblSelectType.setBounds(10, 33, 113, 32);
		getContentPane().add(lblSelectType);

		JLabel lblSelectId = new JLabel("Select Name :");
		lblSelectId.setBounds(10, 100, 113, 22);
		getContentPane().add(lblSelectId);

		name = new JComboBox();
		name.setModel(new DefaultComboBoxModel(new String[] {"Select Name"}));
		name.setBounds(133, 98, 187, 32);
		getContentPane().add(name);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 155, 693, 2);
		getContentPane().add(separator);

		JLabel lblHall = new JLabel("Hall :");
		lblHall.setBounds(10, 191, 87, 22);
		getContentPane().add(lblHall);

		hall = new JTextField();
		hall.setBounds(133, 188, 187, 32);
		getContentPane().add(hall);
		hall.setColumns(10);

		JLabel lblPhNo = new JLabel("Ph No :");
		lblPhNo.setBounds(10, 250, 55, 16);
		getContentPane().add(lblPhNo);

		phone = new JTextField();
		phone.setBounds(133, 244, 187, 32);
		getContentPane().add(phone);
		phone.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 303, 55, 16);
		getContentPane().add(lblEmail);

		email = new JTextField();
		email.setBounds(133, 297, 187, 32);
		getContentPane().add(email);
		email.setColumns(10);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(10, 348, 55, 16);
		getContentPane().add(lblAddress);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(130, 339, 351, 110);
		getContentPane().add(scrollPane);

		address = new JTextArea();
		address.setLineWrap(true);
		scrollPane.setViewportView(address);

		delete = new JButton("Delete Record");
		delete.setBounds(423, 35, 168, 36);
		getContentPane().add(delete);

		exit = new JButton("Exit");
		exit.setBounds(423, 94, 168, 36);
		getContentPane().add(exit);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(346, 194, 55, 16);
		getContentPane().add(lblId);
		
		id = new JTextField();
		id.setBounds(423, 188, 227, 32);
		getContentPane().add(id);
		id.setColumns(10);
		
		emptype = new JComboBox();
		emptype.setModel(new DefaultComboBoxModel(new String[] {"Select Type", "Clerk", "Gardener", "Attendant", "MessManager"}));
		emptype.setBounds(135, 36, 187, 29);
		getContentPane().add(emptype);

		emptype.addItemListener(
				new ItemListener(){

					@Override
					public void itemStateChanged(ItemEvent arg0) {
						// TODO Auto-generated method stub
						showList();
						name.setSelectedIndex(0);
						deactivateButtons();
					}
				}
			);
		
		delete.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					deleteEmp();
					showList();
					name.setSelectedIndex(0);
					deactivateButtons();
				}
				
			}
		);
		
		exit.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			}
		);
		
		name.addItemListener(
			new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					int i=name.getSelectedIndex();
					if(i==0){
						deactivateButtons();
					}else{
						id.setText(data[i-1][2]);
						hall.setText(data[i-1][1]);
						phone.setText(data[i-1][3]);
						email.setText(data[i-1][5]);
						address.setText(data[i-1][4]);
						activateButtons();
					}
				}
				
			}
		);
		
		
	}
	
private boolean	showList(){
		
		System.out.println("we are here !!");
		String typetext=(String)(emptype.getSelectedItem());
		
		if(emptype.getSelectedIndex()==0){
			//deactivateButtons();
			name.setModel(new DefaultComboBoxModel(new String[]{"Select Name"}));
			return false;
		}
		
		/*******************SQL Query************************************/
		Connection con = null;	
		try {
				Class.forName("com.mysql.jdbc.Driver");  // Initialize the driver
				Class.forName("com.mysql.jdbc.Driver");  // initialise the driver
				String url ="jdbc:mysql://"+bridge.getHost()+":"+bridge.getPort()+"/hms";
				 System.out.println("connection Established");
			}catch(Exception e) {
			     System.out.println("Couldnt get connection");
			}
	    
		Statement st = null;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from `workerlist` where `type` LIKE '"+typetext+"'");
			rs.last();
			dataCount=rs.getRow();
			rs.beforeFirst();
			System.out.println("total results ="+dataCount);
			data=new String[dataCount][6];
			int i=0;
			while(rs.next()){
				data[i][0]=rs.getString("name");
				data[i][1]=rs.getString("hallcode");
				data[i][2]=rs.getString("id");
				data[i][3]=rs.getString("contact");
				data[i][4]=rs.getString("address");
				data[i][5]=rs.getString("email");
				i++;
			}
			String[] nameList=new String[dataCount+1];
			for(i=0;i<=dataCount-1;i++){
				nameList[i+1]=""+data[i][0];
			}
			nameList[0]="Select Name";
			name.setModel(new DefaultComboBoxModel((String[])nameList));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	private void deactivateButtons(){
		id.setText("");
		hall.setText("");
		email.setText("");
		address.setText("");
		phone.setText("");
		delete.setEnabled(false);
	}
	private void activateButtons(){
		delete.setEnabled(true);
	}
	
	private boolean deleteEmp(){
		int i=name.getSelectedIndex();
		if(i==0) return false;
		String id=data[i-1][2];
		if(!(data[i-1][1].equals("")||data[i-1][1].equals("not recruited"))){
			System.out.println("Sorry Worker is still Employed in "+data[i-1][1]);
			return false;
		}
		/*********************SQL Query****************************/
		Connection con = null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver
			String url ="jdbc:mysql://"+bridge.getHost()+":"+bridge.getPort()+"/hms";
				 con = DriverManager.getConnection(url, "sourav", "qwerty");
				 System.out.println("connection Established");
			}catch(Exception e) {
			     System.out.println("Couldnt get connection");
			}
	    
		Statement st = null;
		try {
			st = con.createStatement();
			st.executeUpdate("DELETE FROM `hms`.`workerlist` WHERE `workerlist`.`id`='"+id+"'");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
