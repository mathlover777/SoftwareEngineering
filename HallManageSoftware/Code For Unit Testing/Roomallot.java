package code;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;


public class Roomallot extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 268709377966410258L;


	
	private JTextField id;
	private JTextField Name;
	private JTextField Contact;
	private JTextField oldhall;
	private JTextField oldroom;
	private JTextField Email;
	private JTextField Hall;
	private JTextField Roomno;
	private JButton searchstudent;
	private JTextArea Address;
	private JRadioButton no;
	private JRadioButton yes;
	private JComboBox hallname;
	private JRadioButton single;
	private JRadioButton Double;
	private JButton searchroom;
	private JButton confirm;
	private JButton exit;

	
	/**************************EXTRA data*****************************************************/
	
	private String name="",email="",address="",contact="",oldHall="",oldRoom="",studentId="";
	private String roomPref="";
	private String newHall="",newRoom="",newHallCode="";
	
	private String hallName[],hallCode[];
	private int singleCount[],doubleCount[],singleFilled[],doubleFilled[],singleRoomRent[],doubleRoomRent[],amenity[];
	private int hallCount,flag,roomRent,amenityCharge,hallNo;



	private Bridge bridge;
	
	
	/**
	 * Create the frame.
	 */
	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			Roomallot dialog = new Roomallot();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/************************************************************/
	
	
	public Roomallot() {
		
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(100, 100, 1000, 500);
		
		
		getContentPane().setLayout(null);
		
		
		JLabel lblFresh = new JLabel("Fresh Admission :");
		lblFresh.setBounds(10, 11, 119, 30);
		getContentPane().add(lblFresh);
		
		

		yes = new JRadioButton("Yes");
		yes.setBounds(135, 15, 55, 23);
		getContentPane().add(yes);

		no = new JRadioButton("No");
		no.setBounds(205, 15, 55, 23);
		getContentPane().add(no);

		JLabel lblEnterId = new JLabel("Enter ID :");
		lblEnterId.setBounds(10, 60, 119, 30);
		getContentPane().add(lblEnterId);

		id = new JTextField();
		id.setBounds(139, 57, 180, 37);
		getContentPane().add(id);
		id.setColumns(10);

		searchstudent = new JButton("Search");
		searchstudent.setBounds(352, 56, 119, 30);
		getContentPane().add(searchstudent);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 109, 792, 2);
		getContentPane().add(separator);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 133, 119, 30);
		getContentPane().add(lblName);

		Name = new JTextField();
		Name.setBounds(138, 134, 243, 30);
		getContentPane().add(Name);
		Name.setColumns(10);

		JLabel lblRoomPreference = new JLabel("Room Preference :");
		lblRoomPreference.setBounds(391, 222, 124, 30);
		getContentPane().add(lblRoomPreference);

		single = new JRadioButton("Single");
		single.setBounds(521, 228, 79, 18);
		getContentPane().add(single);

		Double = new JRadioButton("Double");
		Double.setBounds(627, 228, 79, 18);
		getContentPane().add(Double);

		JLabel lblContactNo = new JLabel("Contact No :");
		lblContactNo.setBounds(10, 188, 119, 30);
		getContentPane().add(lblContactNo);

		Contact = new JTextField();
		Contact.setBounds(138, 185, 243, 30);
		getContentPane().add(Contact);
		Contact.setColumns(10);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(10, 278, 119, 30);
		getContentPane().add(lblAddress);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(135, 285, 432, 139);
		getContentPane().add(scrollPane);

		Address = new JTextArea();
		Address.setLineWrap(true);
		scrollPane.setViewportView(Address);

		JLabel lblOldHallL = new JLabel("Old Hall :");
		lblOldHallL.setBounds(391, 140, 55, 16);
		getContentPane().add(lblOldHallL);

		oldhall = new JTextField();
		oldhall.setBounds(456, 133, 79, 30);
		getContentPane().add(oldhall);
		oldhall.setColumns(10);

		JLabel lblOldRoomNo = new JLabel("Old Room No :");
		lblOldRoomNo.setBounds(558, 133, 93, 30);
		getContentPane().add(lblOldRoomNo);

		oldroom = new JTextField();
		oldroom.setBounds(678, 134, 108, 29);
		getContentPane().add(oldroom);
		oldroom.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 229, 55, 16);
		getContentPane().add(lblEmail);

		Email = new JTextField();
		Email.setBounds(139, 226, 242, 29);
		getContentPane().add(Email);
		Email.setColumns(10);

		searchroom = new JButton("Search");
		searchroom.setBounds(712, 223, 90, 29);
		getContentPane().add(searchroom);

		JLabel lblHall = new JLabel("Hall :");
		lblHall.setBounds(577, 292, 55, 16);
		getContentPane().add(lblHall);

		Hall = new JTextField();
		Hall.setColumns(10);
		Hall.setBounds(577, 321, 107, 30);
		getContentPane().add(Hall);

		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setBounds(693, 287, 93, 30);
		getContentPane().add(lblRoomNo);

		Roomno = new JTextField();
		Roomno.setColumns(10);
		Roomno.setBounds(694, 322, 108, 30);
		getContentPane().add(Roomno);

		JLabel lblHallPreference = new JLabel("Hall Preference :");
		lblHallPreference.setBounds(391, 188, 124, 23);
		getContentPane().add(lblHallPreference);

		hallname = new JComboBox();
		hallname.setBounds(529, 185, 273, 30);
		getContentPane().add(hallname);

		confirm = new JButton("Confirm");
		confirm.setForeground(Color.RED);
		confirm.setBounds(577, 378, 107, 46);
		getContentPane().add(confirm);

		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit.setBounds(693, 378, 109, 46);
		getContentPane().add(exit, BorderLayout.NORTH);
		
		
		/****************************New CODE****************************************/
		hallname.setModel(new DefaultComboBoxModel(new String[] {"Select Hall"}));
		
		//id.setEditable(false);
		//searchstudent.setEnabled(false);
		
		
		yes.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					no.setSelected(false);
					id.setEditable(false);
					searchstudent.setEnabled(false);
				}
				
			}
		);
		no.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						yes.setSelected(false);
						id.setEditable(true);
						searchstudent.setEnabled(true);
					}
					
				}
			);
		searchstudent.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							searchStudent(id.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							getHallList();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
			);
		searchroom.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							searchRoom();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
			);
		confirm.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						allotRoom();
					}
					
				}
			);
		exit.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				}
			);
		
		single.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Double.setSelected(false);
					roomPref="single";
				}
				
			}
		);
		Double.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						single.setSelected(false);
						roomPref="double";
					}
					
				}
			);
	}
	
	
	private boolean searchStudent(String id) throws SQLException{
		
		String query="";
		studentId=""+id;
		query="SELECT *	FROM `studentdetail` WHERE `id` LIKE '"+id+"'";
		
		ResultSet rs=resultQuery(query);
		rs.last();
		if(rs.getRow()==0){
			System.out.println("No such student exits in database !!");
		}
		
		rs.beforeFirst();
		rs.next();
		
		name=rs.getString("name");
		email=rs.getString("email");
		address=rs.getString("address");
		oldHall=rs.getString("hallcode");
		oldRoom=rs.getString("roomno");
		contact=rs.getString("phone");
		int roomDue,messDue,amenityDue = 0;
		roomDue=(int)(Integer.parseInt(rs.getString("roomrentdue")));
		messDue=(int)(Integer.parseInt(rs.getString("messchargedue")));
		roomDue=(int)(Integer.parseInt(rs.getString("amenitychargedue")));
		int totaldue=roomDue+messDue+amenityDue;
		if(totaldue!=0){
			System.out.println("Student's due is not cleared... Rs "+totaldue+"/- remaining...");
		}else{
		}
		Name.setText(name);
		Contact.setText(contact);
		Email.setText(email);
		Address.setText(address);
		oldhall.setText(oldHall);
		oldroom.setText(oldRoom);
		return true;
	}
	
	
	private boolean getHallList() throws SQLException{
		String query="";
		query = "SELECT * FROM `hms`.`halldata`";
		ResultSet rs=resultQuery(query);
		rs.last();
		hallCount=rs.getRow();
		rs.beforeFirst();
		rs.next();
		hallCode=new String[hallCount];
		hallName=new String[hallCount+1];
		singleRoomRent=new int[hallCount];
		doubleRoomRent=new int[hallCount];
		singleCount=new int[hallCount];
		doubleCount=new int[hallCount];
		singleFilled=new int[hallCount];
		doubleFilled=new int[hallCount];
		amenity=new int[hallCount];
		hallName[0]="Select Hall";
		int i;
		for(i=1;i<=hallCount;i++){
			hallCode[i-1]=rs.getString("hallcode");
			hallName[i]=rs.getString("hallname");
			singleRoomRent[i-1]=(int)(Integer.parseInt(rs.getString("singlerent")));
			singleCount[i-1]=(int)(Integer.parseInt(rs.getString("singlecount")));
			doubleRoomRent[i-1]=(int)(Integer.parseInt(rs.getString("doublerent")));
			doubleCount[i-1]=(int)(Integer.parseInt(rs.getString("doublecount")));
			singleFilled[i-1]=(int)(Integer.parseInt(rs.getString("singlefilled")));
			doubleFilled[i-1]=(int)(Integer.parseInt(rs.getString("doublefilled")));
			amenity[i-1]=(int)(Integer.parseInt(rs.getString("amenitycharge")));
			rs.next();
		}
		hallname.setModel(new DefaultComboBoxModel(hallName));
		return true;
	}
	
	
	private boolean searchRoom() throws SQLException{
		
		int i=hallname.getSelectedIndex();
		String query="";
		ResultSet rs;
		if(i==0) return false;
		if(roomPref.equals("single")){
			if(singleCount[i-1]>singleFilled[i-1]){
				//single room empty found !!
				query="SELECT roomno FROM `hms`.`"+hallCode[i-1]+"_studentlist` WHERE `student1id` LIKE 'empty' AND `type` LIKE 'single' LIMIT 0,1";
				rs=resultQuery(query);
				rs.last();
				if(rs.getRow()!=0){
					rs.beforeFirst();
					rs.next();
					newHall=hallName[i];
					newHallCode=hallCode[i-1];
					newRoom=rs.getString("roomno");
					Hall.setText(newHall);
					Roomno.setText(newRoom);
					flag=0;
					hallNo=i-1;
					return true;
				}
			}
		}
		//now looking for double room for the same hall 
		if(2*doubleCount[i-1]>doubleFilled[i-1]){
			//double room empty found !!
			query="SELECT roomno FROM `hms`.`"+hallCode[i-1]+"_studentlist` WHERE `type` LIKE 'double' AND `student1id` LIKE 'empty' LIMIT 0,1";
			rs=resultQuery(query);
			rs.last();
			System.out.println("we are here !!");
			if(rs.getRow()!=0){
				System.out.println("we are here !!");
				rs.beforeFirst();
				rs.next();
				newHall=hallName[i];
				newHallCode=hallCode[i-1];
				newRoom=rs.getString("roomno");
				Hall.setText(newHall);
				Roomno.setText(newRoom);
				flag=1;
				hallNo=i-1;
				return true;
			}
			query="SELECT roomno FROM `hms`.`"+hallCode[i-1]+"_studentlist` WHERE `type` LIKE 'double' AND `student2id` LIKE 'empty' LIMIT 0,1";
			rs=resultQuery(query);
			rs.last();
			if(rs.getRow()!=0){
				rs.beforeFirst();
				rs.next();
				newHall=hallName[i];
				newHallCode=hallCode[i-1];
				newRoom=rs.getString("roomno");
				Hall.setText(newHall);
				Roomno.setText(newRoom);
				flag=2;
				hallNo=i-1;
				return true;
			}
		}
		/****************No Single Room in the preferred hall********************/
		/*************looking for Single rooms in other halls *************************/
		int xflag=0;
		int j;
		for(j=0;j<=hallCount-1;j++){
			if(singleCount[j]>singleFilled[j]){
				xflag=1;
				break;
			}
		}
		if(xflag==1){
			//finally got a single room for sure !!
			newHall=hallName[j+1];
			newHallCode=hallCode[j];
			query="SELECT roomno FROM `hms`.`"+newHallCode+"_studentlist` WHERE `type` LIKE 'single' AND `student1id` LIKE 'empty' LIMIT 0,1";
			rs=resultQuery(query);
			rs.last();
			if(rs.getRow()!=0){
				rs.beforeFirst();
				rs.next();
				newRoom=rs.getString("roomno");
				Hall.setText(newHall);
				Roomno.setText(newRoom);
				flag=0;
				hallNo=j;
				return true;
			}
		}
		/****************SINGLE ROOM NOT AVAILABLE IN ANY HALL !!**************/
		xflag=0;
		for(j=0;j<=hallCount-1;j++){
			if(2*doubleCount[j]>doubleFilled[j]){
				xflag=1;
				break;
			}
		}
		/*********************Found a double room in hall_J*********************/
		if(xflag==1){
			newHall=hallName[j+1];
			newHallCode=hallCode[j];
			query="SELECT roomno FROM `hms`.`"+newHallCode+"_studentlist` WHERE `type` LIKE 'double' AND `student1id` LIKE 'empty' LIMIT 0,1";
			rs=resultQuery(query);
			rs.last();
			if(rs.getRow()!=0){
				rs.beforeFirst();
				rs.next();
				newRoom=rs.getString("roomno");
				Hall.setText(newHall);
				Roomno.setText(newRoom);
				flag=1;
				hallNo=j;
				return true;
			}
			query="SELECT roomno FROM `hms`.`"+newHallCode+"_studentlist` WHERE `type` LIKE 'double' AND `student2id` LIKE 'empty' LIMIT 0,1";
			rs=resultQuery(query);
			rs.last();
			if(rs.getRow()!=0){
				rs.beforeFirst();
				rs.next();
				newRoom=rs.getString("roomno");
				Hall.setText(newHall);
				Roomno.setText(newRoom);
				flag=2;
				hallNo=j;
				return true;
			}
		}
		/***************ALL the Halls are full !!!**************************/
		return true;
	}
	
	
	private boolean allotRoom(){
		String query="";
		if(flag==0||flag==1){
			query="UPDATE `hms`.`"+newHallCode+"_studentlist` SET `student1id` = '"+studentId+"',`student1name` = '"+name+"' WHERE"+
			"`"+newHallCode+"_studentlist`.`roomno` = "+newRoom;
		}
		if(flag==2){
			query="UPDATE `hms`.`"+newHallCode+"_studentlist` SET `student2id` = '"+studentId+"',`student2name` = '"+name+"' WHERE"+
			"`"+newHallCode+"_studentlist`.`roomno` = "+newRoom;
		}
		/*****student added to hall's student list***********/
		updateQuery(query);
		amenityCharge=amenity[hallNo];
		if(flag==0){
			roomRent=singleRoomRent[hallNo];
		}
		if(flag==1||flag==2){
			roomRent=doubleRoomRent[hallNo];
		}
		query="UPDATE `hms`.`studentdetail` SET `hallcode` = '"+newHallCode+"',`roomNo` = '"+newRoom+"',`roomtype` = '"+flag+"',`roomrentdue` = '"+
		roomRent+"',"+"`messchargedue` = '0',`amenitychargedue` = '"+amenityCharge+"' WHERE `studentdetail`.`id` LIKE '"+studentId+"'";
		
		System.out.println(query);
		
		updateQuery(query);
		
		return true;
	}
	
	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
