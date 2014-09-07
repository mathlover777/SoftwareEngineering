import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class changePass extends JDialog {
	private JTextField id;
	private JPasswordField pass1;
	private JPasswordField pass2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	private boolean success=false;
	private String username="",password="",hash="",newpass="";
	private JButton save;
	private JButton cancel;
	private JComboBox loginas;
	private int mx=0;
	
	
	public changePass() {
		setTitle("Reset Password");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 358, 252);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 188, 337, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				save = new JButton("Change Password");
				save.setActionCommand("OK");
				buttonPane.add(save);
				getRootPane().setDefaultButton(save);
			}
			{
				cancel = new JButton("Cancel");
				cancel.setActionCommand("Cancel");
				buttonPane.add(cancel);
			}
		}
		{
			JLabel label = new JLabel("Log In ID :");
			label.setBounds(10, 29, 88, 14);
			getContentPane().add(label);
		}
		{
			id = new JTextField();
			id.setColumns(10);
			id.setBounds(118, 26, 229, 20);
			getContentPane().add(id);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 11, 337, 2);
			getContentPane().add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 84, 337, 2);
			getContentPane().add(separator);
		}
		{
			JLabel lblNewPassword = new JLabel("New Password :");
			lblNewPassword.setBounds(10, 117, 98, 14);
			getContentPane().add(lblNewPassword);
		}
		{
			pass1 = new JPasswordField();
			pass1.setBounds(118, 114, 229, 20);
			getContentPane().add(pass1);
		}
		{
			JLabel lblConfirm = new JLabel("Confirm :");
			lblConfirm.setBounds(10, 154, 98, 14);
			getContentPane().add(lblConfirm);
		}
		{
			pass2 = new JPasswordField();
			pass2.setBounds(118, 145, 229, 20);
			getContentPane().add(pass2);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 179, 337, 2);
			getContentPane().add(separator);
		}
		
		JLabel lblLoginAs = new JLabel("Login As :");
		lblLoginAs.setBounds(10, 59, 88, 14);
		getContentPane().add(lblLoginAs);
		
		loginas = new JComboBox();
		loginas.setModel(new DefaultComboBoxModel(new String[] {"DEAN", "FACAD", "STUDENT", "FACULTY"}));
		loginas.setBounds(118, 53, 229, 20);
		getContentPane().add(loginas);
		save.addActionListener(
			new ActionListener(){

				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					int x=loginas.getSelectedIndex();
					if(pass1.getText().equals(pass2.getText())){
						username=""+id.getText();
						newpass=""+pass1.getText();
						switch(x){
							case 0:{
								try {
									x=0;
									changePass("dean_id.txt",username,MD5(newpass));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
							case 1:{
								try {
									mx=0;
									changePass("facad_id.txt",username,MD5(newpass));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
							case 2:{
								try {
									mx=1;
									//System.out.println("fdfdf");
									changePass("studentlist.txt",username,MD5(newpass));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
							case 3:{
								try {
									mx=0;
									changePass("teacherlist.txt",username,MD5(newpass));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
						}
					}
					dispose();
				}				
			}
		);
		cancel.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						success=false;
						dispose();
					}
					
				}
			);
	}
	public boolean isSuccess(){
		return success;
	}
	public boolean changePass(String filename,String Id,String newpass) throws IOException{
		
		//System.out.println("fdxxxxxxxxxxxxfdf");
		String idmatch=null;
		success=false;
		FileInputStream fstream = new FileInputStream(filename);
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		createEmptyFile("tempy.txt");
		strLine=br.readLine();
		while(strLine!=null){
			addLine("tempy.txt",strLine);
			if(strLine.equals(Id)){
				idmatch=""+Id;
				addLine("tempy.txt",newpass);
				strLine=br.readLine();
			}else{
				strLine=br.readLine();
				addLine("tempy.txt",strLine);
			}
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		//System.out.println("\nidmatch = "+idmatch);
		if(idmatch==null){
			System.out.println("\nModifyingzfdf the detail file...");
			success=false;
			return success;
		}
		copyToFile("tempy.txt",filename);
		//System.out.println("x = "+x);
		if(mx==1){
			//System.out.println("\nModifying the detail file...");
			//need to modify the detail file in case of student !!!
			createEmptyFile("tempp.txt");
			fstream = new FileInputStream(idmatch+"_details.txt");
			in = new DataInputStream(fstream);
			strLine="";
			br = new BufferedReader(new InputStreamReader(in));
			strLine=br.readLine();
			addLine("tempp.txt",newpass);
			addLine("tempp.txt",br.readLine());
			addLine("tempp.txt",br.readLine());
			addLine("tempp.txt",br.readLine());
			addLine("tempp.txt",br.readLine());
			addLine("tempp.txt",br.readLine());
			addLine("tempp.txt",br.readLine());
			addLine("tempp.txt",br.readLine());
			addLine("tempp.txt",br.readLine());
			br.close();
			in.close();
			fstream.close();
			copyToFile("tempp.txt",idmatch+"_details.txt");
		}
		success=true;
		return true;
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
	
	
	public boolean createEmptyFile(String filename) throws IOException{
		FileWriter f2=new FileWriter(filename);
		BufferedWriter out = new BufferedWriter(f2);
		out.close();
		f2.close();
		return true;
	}
	public int stringToInt(String s){
		int n=0;
		for(int i=0;i<=s.length()-1;i++){
			n=n*10+(s.charAt(i))-48;
		}
		return n;
	}
	
	public static void copyToFile(String file1,String file2) throws IOException{
		FileInputStream f1=new FileInputStream(file1);
		FileOutputStream f2=new FileOutputStream(file2);
		int i;
		char c=0;
		i=f1.read();
		while(i!=-1){
			f2.write(i);
			i=f1.read();
		}
		f1.close();
		f2.close();
	}
	public static void addLine(String file,String line) throws IOException{
		FileInputStream f1=new FileInputStream(file);
		FileWriter f2=new FileWriter("tempa.txt");
		BufferedWriter out = new BufferedWriter(f2);
		int i;
		i=f1.read();
		int c=0;
		if(i==-1){
			c=1;
		}
		while(i!=-1){
			out.write((char)i);
			i=f1.read();
		}
		if(c==0){
			out.write("\r\n"+line);
		}
		if(c==1){
			out.write(line);
		}
		out.close();
		f1.close();
		copyToFile("tempa.txt",file);
	}
}
