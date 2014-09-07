package code;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bridge {
	private String host="",port="",user="",pass="";
	
	
	
	
	Bridge(String loginfile) throws IOException{
		/**************** Code to get login data from file *****************************/
		FileInputStream fstream = new FileInputStream(loginfile);
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
	}
	
	public String getHost(){
		return host;
	}
	public String getPort(){
		return port;
	}
	public String getUser(){
		return user;
	}
	public String getPass(){
		return pass;
	}
	
	
	public ResultSet resultQuery(String query){
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Initialize the driver
			String url = "jdbc:mysql://" + host + ":" + port + "/hms";
			System.out.println(url);
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

	public int updateQuery(String query)  {
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
}
