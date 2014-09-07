package code;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RetrievePassword extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2339342053283917542L;
	private final JPanel contentPanel = new JPanel();
	private JTextField Id;
	private JTextField Pass;
	private JTextField Cpass;
	private JButton save;
	private JButton exit;
	private JComboBox Type;
	private Bridge bridge;
	
	
	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			RetrievePassword dialog = new RetrievePassword();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/************************************************************/
	
	

	/**
	 * Create the dialog.
	 */
	public RetrievePassword() {
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(100, 100, 549, 352);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEnterId = new JLabel("Enter ID :");
			lblEnterId.setBounds(46, 82, 90, 25);
			contentPanel.add(lblEnterId);
		}
		{
			Id = new JTextField();
			Id.setBounds(210, 80, 211, 40);
			contentPanel.add(Id);
			Id.setColumns(10);
		}
		{
			JLabel lblNewPassword = new JLabel("New Password :");
			lblNewPassword.setBounds(46, 158, 138, 25);
			contentPanel.add(lblNewPassword);
		}
		{
			JLabel lblConfirmNewPassword = new JLabel("Confirm New Password :");
			lblConfirmNewPassword.setBounds(46, 207, 153, 25);
			contentPanel.add(lblConfirmNewPassword);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(104, 94, 90, 2);
			contentPanel.add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(46, 132, 379, 2);
			contentPanel.add(separator);
		}
		{
			Pass = new JTextField();
			Pass.setBounds(210, 156, 211, 37);
			contentPanel.add(Pass);
			Pass.setColumns(10);
		}
		{
			Cpass = new JTextField();
			Cpass.setBounds(210, 205, 211, 36);
			contentPanel.add(Cpass);
			Cpass.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(46, 253, 379, 2);
			contentPanel.add(separator);
		}
		{
			save = new JButton("Save New Password");
			save.setBounds(6, 267, 153, 41);
			contentPanel.add(save);
		}
		{
			exit = new JButton("Exit Without Saving");
			exit.setBounds(352, 267, 154, 41);
			contentPanel.add(exit);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 66, 468, 4);
		contentPanel.add(separator);
		
		JLabel lblEnterChoice = new JLabel("Enter  Choice :");
		lblEnterChoice.setBounds(53, 22, 146, 25);
		contentPanel.add(lblEnterChoice);
		
		Type = new JComboBox();
		Type.setModel(new DefaultComboBoxModel(new String[] {"Enter Type", "Student", "Worker", "Warden"}));
		Type.setBounds(210, 14, 211, 40);
		contentPanel.add(Type);
		
		
		/****************NEW CODE******************************************/
		save.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					savePass();
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
	}
	
	
	private void savePass(){
		String pass=Pass.getText();
		String cPass=Cpass.getText();
		String id=Id.getText();
		System.out.println(Type.getSelectedIndex()+"pass = "+pass+" cPass = "+cPass);
		if(!cPass.equals(pass)){
			return;
		}
		String table="";
		System.out.println(Type.getSelectedIndex()+"");
		switch(Type.getSelectedIndex()){
		case 1:{
			//student
			table="studentdetail";
			break;
		}case 2:{
			//worker
			table = "workerlist";
			break;
		}case 3:{
			//warden
			table="wardenlist";
			break;
		}default :{
			return;
		}
		}
		String query="UPDATE `hms`.`"+table+"` SET `password` = '"+pass+"' WHERE `id` LIKE '"+id+"'";
		System.out.println(query);
		updateQuery(query);
	}
	
	
	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
}
