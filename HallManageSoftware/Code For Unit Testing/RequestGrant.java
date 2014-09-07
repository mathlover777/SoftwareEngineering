package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.IOException;


public class RequestGrant extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4173992408218314720L;
	private JTextField Csalary;
	private JTextField Gsalary;
	private JTextField Asalary;
	private JTextField Gcount;
	private JTextField Acount;
	private JTextField Mcharges;
	private JButton back;
	private JButton requestGrant;
	/**
	 * Create the frame.
	 */
	
	
	/******Input DATA***************************************/
	private String hallCode="";
	private int cSalary=0,aSalary=0,gSalary=0,aCount=0,gCount=0,mCharge=0;
	private Bridge bridge;
	
	
	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			RequestGrant dialog = new RequestGrant("VS");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/************************************************************/
	
	
	
	
	
	public RequestGrant(String hallcode) {
		/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		getContentPane().setLayout(null);
		setModal(true);
		setBounds(50,50,1000,650);

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

		requestGrant = new JButton("Request Grant");
		requestGrant.setBounds(16, 364, 144, 51);
		getContentPane().add(requestGrant);

		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setBounds(649, 364, 144, 51);
		getContentPane().add(back);
		
		JLabel lblNewLabel_1 = new JLabel("NEW GRANT REQUEST");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(143, 38, 179, 56);
		getContentPane().add(lblNewLabel_1);
	
		
		
		/**************************New Code******************************************/
		
		hallCode=""+hallcode;
		requestGrant.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(getData()){
						saveData();
					}
				}
				
			}
		);
	
	}
	
	private boolean getData(){
		/*************Removed for unit testing*******************
		cSalary=(int)(Integer.parseInt((Csalary.getText())));
		aSalary=(int)(Integer.parseInt((Asalary.getText())));
		gSalary=(int)(Integer.parseInt((Gsalary.getText())));
		aCount=(int)(Integer.parseInt((Acount.getText())));
		gCount=(int)(Integer.parseInt((Gcount.getText())));
		mCharge=(int)(Integer.parseInt((Mcharges.getText())));
		if(cSalary<0||aSalary<0||gSalary<0||aCount<0||gCount<0){
			return false;
		}*/
		
		cSalary=100;
		aSalary=200;
		gSalary=75;
		aCount=2;
		gCount=3;
		mCharge=10000;
		
		return true;
		
		
	}
	
	private boolean saveData(){
		
		String query="";
		query="UPDATE `hms`.`granttable` SET `csalary` = '"+cSalary+"',`gsalary` = '"+gSalary+"',`asalary` = '"+aSalary+"', `status` = 'submitted',"+
				"`mcharges` = '"+mCharge+"',`gcount` = '"+gCount+"',`acount` = '"+aCount+"' WHERE `granttable`.`hallcode` LIKE '"+hallCode+"'";
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
