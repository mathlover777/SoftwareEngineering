package code;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnterAmenityCharge extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2134082709085464332L;
	private JTextField Old;
	private JTextField New;
	private JButton save;
	private JButton exit;


	/**
	 * Create the dialog.
	 */
	
	
	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			EnterAmenityCharge dialog = new EnterAmenityCharge("vs");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/************************************************************/
	
	
	/***************EXTRA data***************************************/
	private String hallCode="";
	private Bridge bridge;
	
	
	public EnterAmenityCharge(String hallcode) {
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(100, 100, 350, 242);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 257, 334, 10);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
		}
		
		JLabel lblOldMonthlyAmenity = new JLabel("Old Monthly Amenity Charge :");
		lblOldMonthlyAmenity.setBounds(6, 19, 168, 33);
		getContentPane().add(lblOldMonthlyAmenity);
		
		Old = new JTextField();
		Old.setBounds(206, 21, 122, 28);
		getContentPane().add(Old);
		Old.setColumns(10);
		
		JLabel lblNewMonthlyAmenity = new JLabel("New Monthly Amenity Charge :");
		lblNewMonthlyAmenity.setBounds(6, 64, 168, 33);
		getContentPane().add(lblNewMonthlyAmenity);
		
		New = new JTextField();
		New.setColumns(10);
		New.setBounds(206, 66, 122, 28);
		getContentPane().add(New);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 109, 322, 2);
		getContentPane().add(separator);
		
		save = new JButton("Save");
		save.setBounds(6, 124, 112, 43);
		getContentPane().add(save);
		
		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		exit.setBounds(216, 123, 112, 43);
		getContentPane().add(exit);
		
		/**************************************************************************************/
		hallCode=""+hallcode;
		try {
			getData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		exit.addActionListener(
			new ActionListener(){
			

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
				}
			}
		);
		
		save.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					saveData();
				}
				
			}
		);
	}
	private void getData() throws SQLException{
		String query="";
		query = "SELECT * FROM `hms`.`halldata` WHERE `hallcode` LIKE '"+hallCode+"'";
		System.out.println(query);
		ResultSet rs=resultQuery(query);
		rs.last();
		rs.beforeFirst();
		rs.next();
		Old.setText(rs.getString("amenitycharge"));
		return;
	}
	private void saveData(){
		
		//int charge=(int)(Integer.parseInt(New.getText()));
		//String query="UPDATE `hms`.`halldata` SET `amenitycharge` = '"+charge+"' WHERE `hallcode` LIKE '"+hallCode+"'";
		
		/****************Unit test code****************************/
		String query="UPDATE `hms`.`halldata` SET `amenitycharge` = '"+700+"' WHERE `hallcode` LIKE '"+hallCode+"'";
		
		
		/***********************************************************/
		
		System.out.println(query);
		updateQuery(query);
		return;
	}
	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
