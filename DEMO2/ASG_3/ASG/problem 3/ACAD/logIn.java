import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class logIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField id;
	private JPasswordField pass;
	private JTextField as;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	/***************/
	public String username="",password="",hash="";
	private JButton login;
	private JButton cancel;
	private boolean success;
	
	
	public logIn(final int x) {
		setTitle("Log In");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 363, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblLogInAs = new JLabel("Log In As :");
			lblLogInAs.setBounds(10, 21, 88, 27);
			contentPanel.add(lblLogInAs);
		}
		
		JLabel lblLogInId = new JLabel("Log In ID :");
		lblLogInId.setBounds(10, 73, 88, 14);
		contentPanel.add(lblLogInId);
		
		id = new JTextField();
		id.setBounds(108, 69, 229, 20);
		contentPanel.add(id);
		id.setColumns(10);
		
		JLabel lblPassword = new JLabel("PassWord : ");
		lblPassword.setBounds(10, 98, 88, 14);
		contentPanel.add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(108, 95, 229, 20);
		contentPanel.add(pass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 337, 2);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 128, 337, 2);
		contentPanel.add(separator_1);
		
		as = new JTextField();
		as.setBackground(Color.WHITE);
		as.setEditable(false);
		as.setBounds(108, 24, 86, 20);
		contentPanel.add(as);
		as.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				login = new JButton("Log In");
				login.setActionCommand("OK");
				buttonPane.add(login);
				getRootPane().setDefaultButton(login);
			}
			{
				cancel = new JButton("Cancel");
				cancel.setActionCommand("Cancel");
				buttonPane.add(cancel);
			}
		}
		
		switch(x){
		case 0:{
			as.setText("DEAN");
			break;
		}
		case 1:{
			as.setText("Fac Ad");
			break;
		}
		case 2:{
			as.setText("Student");
			break;
		}
		case 3:{
			as.setText("Faculty");
			break;
		}
		}
		
		
		
		/*****************events******************/
		login.addActionListener(
			new ActionListener(){

				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					username=id.getText();
					password=pass.getText();
					hash=MD5(password);
					success=false;
					switch(x){
					case 0:{
						try {
							success=auth("dean_id.txt",username,hash);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					case 1:{
						try {
							success=auth("facad_id.txt",username,hash);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					case 2:{
						try {
							success=auth("studentlist.txt",username,hash);
							if(success){
								//System.out.println("matched !!");
							}
							else{
								//System.out.println("not matched !!");
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					case 3:{
						try {
							success=auth("teacherlist.txt",username,hash);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					}
					dispose();
				}
				
				
			}
		);
		cancel.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			}
		);
	}
	public boolean auth(String filename,String ID,String Pass) throws IOException{
		boolean result=false;
		FileInputStream fstream = new FileInputStream(filename);
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		while(strLine!=null){
			if(strLine.equals(ID)){
				strLine=br.readLine();
				if(strLine.equals(Pass)){
					result=true;
					break;
				}
			}
			strLine=br.readLine();
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		return result;
	}
	
	public static String MD5(String md5) {
		md5="salt"+md5;   
		try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	public boolean isSuccess(){
		return success;
	}
	public String getUsername(){
		return username;
	}
	public String getHash(){
		return hash;
	}
}
