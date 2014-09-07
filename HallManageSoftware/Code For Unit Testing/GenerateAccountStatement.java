package code;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateAccountStatement {
	

	private static String FILE = "c:/temp/FirstPdf.pdf";
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL);
	@SuppressWarnings("unused")
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.RED);
	@SuppressWarnings("unused")
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.BOLD);
	@SuppressWarnings("unused")
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);

	/******************* EXTRA DATA *****************************/
	private static String hallCode = "";
	private static String accountType = "";
	private static int year = 0, rCount = 0;
	private static String path = "";
	private static String filename = "";
	private static String statement[];
	private static String beforeBal[];
	private static String afterBal[];
	private static String date[];
	private static String time[];
	private static String type[];
	private static String id[];
	private static Bridge bridge;
	
	
	

	
	
	
	public static void main(String args[]){//changed to main for unit testing
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/**************unit testing code*******************/
		
		
		genStmt("ms", "salary", "2013", "D:\\","statement");
		/*************************************************/
		
		
		/*******************************************************/
	}
	public static void genStmt(String hallCode, String accountType, String year, String path, String filename){
		GenerateAccountStatement.hallCode = hallCode;
		GenerateAccountStatement.accountType = accountType;
		GenerateAccountStatement.year = Integer.parseInt(year);
		GenerateAccountStatement.path = path;
		GenerateAccountStatement.filename = filename;
		
		accountType = accountType + "account";
		if (GenerateAccountStatement.filename.equals("")) {
			GenerateAccountStatement.filename = "" + year + "_" + "hallCode_statement";
		}
		GenerateAccountStatement.filename = GenerateAccountStatement.filename + ".pdf";
		try {
			getData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Document document = new Document();
			FILE = GenerateAccountStatement.path + GenerateAccountStatement.filename;
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			writeStatement(document);
			// addContent(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void getData() throws SQLException {
		String query = "";

		query = "SELECT * FROM `hms`.`" + hallCode + "_" + accountType+"account"
				+ "_log` WHERE `year` = " + year + "";
		System.out.println(query);
		ResultSet rs = resultQuery(query);
		rs.last();
		rCount = rs.getRow();
		if (rCount == 0) {
			System.out.println("No data in the given year ");
			return;
		}
		System.out.println("Total Transactions : " + rCount);
		rs.beforeFirst();
		rs.next();
		statement = new String[rCount];
		date = new String[rCount];
		time = new String[rCount];
		beforeBal = new String[rCount];
		afterBal = new String[rCount];
		type = new String[rCount];
		id = new String[rCount];
		for (int i = 0; i <= rCount - 1; i++) {
			statement[i] = "" + rs.getString("statement");
			date[i] = "" + rs.getString("date");
			time[i] = "" + rs.getString("time");
			beforeBal[i] = "" + rs.getString("startingbalance");
			afterBal[i] = "" + rs.getString("endingbalance");
			type[i] = "" + rs.getString("type");
			id[i] = "" + rs.getString("id");
			rs.next();
		}
	}

	private static void writeLine(Document document, String line)
			throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		// Lets write a big header
		preface.add(new Paragraph(line, catFont));
		// addEmptyLine(preface, 1);
		document.add(preface);
		// Start a new page
	}

	private static void writeStatement(Document document)
			throws DocumentException {
		int j = 0, k = 0;
		/*
		 * for(i=0;i<=pagenum-1;i++){ for(j=0;j<=rp-1;j++){ writeLine(document,
		 * "----------------------------------------------------------------");
		 * writeLine(document,"Date : "+date[k]+" Time : "+time[k]);
		 * writeLine(document,"Statement : "+statement[k]);
		 * writeLine(document,"StartBal : "
		 * +beforeBal[k]+" EndBal : "+afterBal[k]);
		 * writeLine(document,"Type : "+type[k]+"  ID : "+id[k]);
		 * writeLine(document
		 * ,"----------------------------------------------------------------");
		 * k++; } document.newPage(); }
		 */
		writeLine(document, "Total Transactions in YEAR = " + year + ": "
				+ rCount);
		for (j = 0; j <= rCount - 1; j++) {
			writeLine(document,
					"----------------------------------------------------------------");
			writeLine(document, "Date : " + date[k] + " Time : " + time[k]);
			writeLine(document, "Statement : " + statement[k]);
			writeLine(document, "StartBal : " + beforeBal[k] + " EndBal : "
					+ afterBal[k]);
			writeLine(document, "Type : " + type[k] + "  ID : " + id[k]);
			writeLine(document,
					"----------------------------------------------------------------");
			k++;
		}

	}

	@SuppressWarnings("unused")
	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
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
	
	private int updateQuery(String query){
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
