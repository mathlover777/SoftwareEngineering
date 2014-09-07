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
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class ViewGrant extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1446440794570705860L;
	private JTextField Submitted;
	private JTextField Csalary;
	private JTextField Gsalary;
	private JTextField Asalary;
	private JTextField Gcount;
	private JTextField Acount;
	private JTextField Mcharges;
	private JComboBox Hall;
	private JButton back;
	private JButton giveGrant;
	

	/**
	 * Create the frame.
	 */
	
	/****************Extra Data**************************************/
	
	private String hallCode[],status[];
	private int cSalary[],aSalary[],gSalary[],aCount[],gCount[],mCharge[];
	private int hallCount,sindex=0;
	private int salaryMoney,total;
	private JTextField Total;
	private Bridge bridge;
	public ViewGrant() {
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

		JLabel lblSelectHall = new JLabel("Select Hall :");
		lblSelectHall.setBounds(16, 23, 115, 29);
		getContentPane().add(lblSelectHall);

		Hall = new JComboBox();
		Hall.setModel(new DefaultComboBoxModel(new String[] {"Select Hall"}));
		Hall.setBounds(123, 23, 260, 28);
		getContentPane().add(Hall);

		JLabel lblGrantSubmitter = new JLabel("Grant Submitted :");
		lblGrantSubmitter.setBounds(16, 86, 115, 22);
		getContentPane().add(lblGrantSubmitter);

		Submitted = new JTextField();
		Submitted.setBounds(143, 83, 122, 28);
		getContentPane().add(Submitted);
		Submitted.setColumns(10);

		JLabel lblClerkSalary = new JLabel("Clerk Salary :");
		lblClerkSalary.setBounds(16, 160, 115, 22);
		getContentPane().add(lblClerkSalary);

		Csalary = new JTextField();
		Csalary.setBounds(143, 157, 122, 28);
		getContentPane().add(Csalary);
		Csalary.setColumns(10);

		JLabel lblpm = new JLabel("/PM");
		lblpm.setBounds(277, 163, 55, 16);
		getContentPane().add(lblpm);

		JLabel lblGardenerSalary = new JLabel("Gardener Salary :");
		lblGardenerSalary.setBounds(16, 210, 115, 22);
		getContentPane().add(lblGardenerSalary);

		Gsalary = new JTextField();
		Gsalary.setBounds(143, 207, 122, 28);
		getContentPane().add(Gsalary);
		Gsalary.setColumns(10);

		JLabel lblpm_1 = new JLabel("/PM");
		lblpm_1.setBounds(277, 213, 55, 16);
		getContentPane().add(lblpm_1);

		JLabel lblAttendentSalary = new JLabel("Attendent Salary :");
		lblAttendentSalary.setBounds(16, 256, 115, 22);
		getContentPane().add(lblAttendentSalary);

		Asalary = new JTextField();
		Asalary.setBounds(143, 253, 122, 28);
		getContentPane().add(Asalary);
		Asalary.setColumns(10);

		JLabel lblpm_2 = new JLabel("/PM");
		lblpm_2.setBounds(277, 259, 55, 16);
		getContentPane().add(lblpm_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(16, 131, 777, 2);
		getContentPane().add(separator_1);

		JLabel lblMaxGardenerCount = new JLabel("Max Gardener Count :");
		lblMaxGardenerCount.setBounds(319, 213, 133, 22);
		getContentPane().add(lblMaxGardenerCount);

		JLabel lblMaxAttendentCount = new JLabel("Max Attendent Count :");
		lblMaxAttendentCount.setBounds(319, 259, 133, 22);
		getContentPane().add(lblMaxAttendentCount);

		Gcount = new JTextField();
		Gcount.setBounds(478, 207, 122, 28);
		getContentPane().add(Gcount);
		Gcount.setColumns(10);

		Acount = new JTextField();
		Acount.setBounds(478, 253, 122, 28);
		getContentPane().add(Acount);
		Acount.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(16, 350, 777, 2);
		getContentPane().add(separator_2);

		JLabel lblNewLabel = new JLabel("Misc Charges :");
		lblNewLabel.setBounds(16, 305, 115, 22);
		getContentPane().add(lblNewLabel);

		Mcharges = new JTextField();
		Mcharges.setBounds(143, 299, 122, 28);
		getContentPane().add(Mcharges);
		Mcharges.setColumns(10);

		giveGrant = new JButton("Give Grant");
		giveGrant.setBounds(16, 364, 144, 51);
		getContentPane().add(giveGrant);

		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setBounds(649, 364, 144, 51);
		getContentPane().add(back);

		JSeparator separator = new JSeparator();
		separator.setBounds(395, 38, 398, 2);
		getContentPane().add(separator);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setBounds(319, 309, 115, 16);
		getContentPane().add(lblTotal);
		
		Total = new JTextField();
		Total.setBounds(395, 302, 205, 29);
		getContentPane().add(Total);
		Total.setColumns(10);
		
		/***************************NEW CODE***********************/
		try {
			getData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Hall.addItemListener(
			new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					showGrant();
				}
				
			}
		);
		
		giveGrant.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						sendGrant();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		);
		
		
		
	}
	
	
	private boolean showGrant(){
		
		
		sindex=Hall.getSelectedIndex();
		if(sindex==0){
			return false;
		}
		sindex--;
		Submitted.setText(status[sindex]);
		Csalary.setText(""+cSalary[sindex]);
		Gsalary.setText(""+gSalary[sindex]);
		Asalary.setText(""+aSalary[sindex]);
		Acount.setText(""+aCount[sindex]);
		Gcount.setText(""+gCount[sindex]);
		salaryMoney=12*(cSalary[sindex])+365*(gCount[sindex]*gSalary[sindex]+aCount[sindex]*aSalary[sindex]);
		System.out.println("Salary Money : "+salaryMoney);
		total=salaryMoney+mCharge[sindex];
		Mcharges.setText(""+mCharge[sindex]);
		Total.setText("RS "+total+"/-");
		sindex++;
		return true;
	}
	
	
	private boolean getData() throws SQLException{
		
		String query="SELECT * FROM `hms`.`granttable`";
		ResultSet rs=resultQuery(query);
		rs.last();
		hallCount=rs.getRow();
		if(hallCount==0){
			
			return false;
		}
		rs.beforeFirst();
		rs.next();
		cSalary=new int[hallCount];
		aSalary=new int[hallCount];
		gSalary=new int[hallCount];
		aCount=new int[hallCount];
		gCount=new int[hallCount];
		mCharge=new int[hallCount];
		hallCode=new String[hallCount+1];
		status=new String[hallCount];
		hallCode[0]="Select Hall";
		for(int i=0;i<=hallCount-1;i++){
			cSalary[i]=(int)(Integer.parseInt(rs.getString("csalary")));
			gSalary[i]=(int)(Integer.parseInt(rs.getString("gsalary")));
			aSalary[i]=(int)(Integer.parseInt(rs.getString("asalary")));
			aCount[i]=(int)(Integer.parseInt(rs.getString("acount")));
			gCount[i]=(int)(Integer.parseInt(rs.getString("gcount")));
			mCharge[i]=(int)(Integer.parseInt(rs.getString("mcharges")));
			status[i]=rs.getString("status");
			hallCode[i+1]=rs.getString("hallcode");
			rs.next();
		}
		Hall.setModel(new DefaultComboBoxModel(hallCode));
		return true;
	}
	
	
	private boolean sendGrant() throws SQLException{
		if(sindex==0){
			return false;
		}
		String query="";
		query="SELECT `salaryaccount`,`miscaccount` FROM `hms`.`hallaccount` WHERE `hms`.`hallaccount`.`hallcode` LIKE '"+hallCode[sindex]+"'";
		
		ResultSet rs=resultQuery(query);
		
		rs.last();
		if(rs.getRow()==0){
			System.out.println("Hall does not exist in account dataBase !!! Fatal Error...");
			return false;
		}
		rs.beforeFirst();
		rs.next();
		int salaryBal=(int)(Integer.parseInt(rs.getString("salaryaccount")));
		int miscBal=(int)(Integer.parseInt(rs.getString("miscaccount")));
		query="UPDATE `hms`.`hallaccount` SET `salaryaccount` = '"+(salaryMoney+salaryBal)+"', `miscaccount` = '"+(miscBal+mCharge[sindex-1])
		+"' WHERE `hallaccount`.`hallCode` LIKE '"+hallCode[sindex]+"'";
		System.out.println(query);
		updateQuery(query);
		
		
		Calendar cal;
		cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		query="INSERT INTO `hms`.`"+hallCode[sindex]+"_salaryaccount_log` (`year`,`date` ,`time` ,`statement` ,`startingbalance` ,`endingbalance` ,`type` ,`id`"+
		")VALUES ("+year+",CURDATE( ) , CURTIME( ) , ' Salary grant given by HMC ', '"+salaryBal+"', '"+(salaryMoney+salaryBal)+"', 'in', 'HMC')";
		
		updateQuery(query);
		
		query="INSERT INTO `hms`.`"+hallCode[sindex]+"_miscaccount_log` (`year`,`date` ,`time` ,`statement` ,`startingbalance` ,`endingbalance` ,`type` ,`id`"+
				")VALUES ("+year+",CURDATE( ) , CURTIME( ) , ' Salary grant given by HMC ', '"+miscBal+"', '"+(miscBal+mCharge[sindex-1])+"', 'in', 'HMC')";
				
				updateQuery(query);
		
		
		
		return false;
	}
	
	
	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
