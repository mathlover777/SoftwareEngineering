package code;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;


public class GenericPay {
	private static String paymentType="";
	private static String id="";
	private static String statement="";
	private static String hallCode="";
	private static String account="";
	static int amount=0;
	private static Bridge bridge;
	/***********code for unit test**********************/
	public static void main(String args[]) throws NumberFormatException, SQLException{
		
		pay("in","VS","repair",10000,"paid by test","test");
	}
	/***************************************************/
	
	
	public GenericPay(){
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
	}
	
	
	public static boolean pay(String Paymenttype,String Hallcode,String Account,int Amount,String Statement,String Id) throws NumberFormatException, SQLException{
		paymentType=""+Paymenttype;
		hallCode=""+Hallcode;
		account=""+Account;
		amount=Amount;
		statement=""+Statement;
		id=""+Id;
		
		int prevBal,newBal;
		String query="";
		
		query="SELECT * FROM `hallaccount` WHERE `hallcode` LIKE '"+hallCode+"'";
		System.out.println(query);
		ResultSet rs=resultQuery(query);
		System.out.println(account+"account");
		
		rs.last();
		System.out.println(rs.getRow()+"");
		rs.beforeFirst();
		rs.next();
		System.out.println(rs.getString(account+"account"));
		prevBal=(int)(Integer.parseInt(rs.getString(""+account+"account")));
		newBal=prevBal;
		if(paymentType.equals("in")){
			newBal=prevBal+amount;
		}
		if(paymentType.equals("out")){
			if(amount>prevBal){
				System.out.println("Not Enough Money !!");
				return false;
			}
			newBal=prevBal-amount;
		}
		
		if(account.equals("room")){
			query="UPDATE `hms`.`hallaccount` SET `"+account+"rentaccount` = '"+newBal+"' WHERE `hallaccount`.`hallcode` LIKE '"+hallCode+"'";
			updateQuery(query);
			
			Calendar cal=Calendar.getInstance();
			int year=cal.get(Calendar.YEAR);
			
			query="INSERT INTO `hms`.`"+hallCode+"_"+account+"account_log` (`year` ,`date` ,`time` ,`statement` ,`startingbalance` ,`endingbalance` ,`type` ,"+
					"`id`)VALUES ('"+year+"', CURDATE( ) , CURTIME( ) , '"+statement+"', '"+prevBal+"', '"+newBal+"', '"+paymentType+"', '"+id+"')";
			
			updateQuery(query);
		}
		
		query="UPDATE `hms`.`hallaccount` SET `"+account+"account` = '"+newBal+"' WHERE `hallaccount`.`hallcode` LIKE '"+hallCode+"'";
		updateQuery(query);
		
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		
		query="INSERT INTO `hms`.`"+hallCode+"_"+account+"account_log` (`year` ,`date` ,`time` ,`statement` ,`startingbalance` ,`endingbalance` ,`type` ,"+
				"`id`)VALUES ('"+year+"', CURDATE( ) , CURTIME( ) , '"+statement+"', '"+prevBal+"', '"+newBal+"', '"+paymentType+"', '"+id+"')";
		
		updateQuery(query);
		
		return true;
	}
	
	
	private static ResultSet resultQuery(String query){
		Connection con = null;	
		try {
				Class.forName("com.mysql.jdbc.Driver");  // Initialize the driver
				String url ="jdbc:mysql://localhost:3306/hms";
				 con = DriverManager.getConnection(url, "sourav", "qwerty");
				 System.out.println("connection Established");
			}catch(Exception e) {
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
	
	private static int updateQuery(String query){
		Connection con = null;
		int success = 0;
		try {
				Class.forName("com.mysql.jdbc.Driver");  // Initialize the driver
				String url ="jdbc:mysql://localhost:3306/hms";
				 con = DriverManager.getConnection(url, "sourav", "qwerty");
				 System.out.println("connection Established");
			}catch(Exception e) {
			     System.out.println("Couldnt get connection");
			}
	    
		Statement st = null;
		try {
			st = con.createStatement();
			success=st.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
}
