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
import javax.swing.JSeparator;
import javax.swing.JPasswordField;


public class addFac extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField n;
	private JPasswordField p;
	private JPasswordField cp;
	private JButton add;
	private JButton cancel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	
	private String name="",password="",cpassword="";
	private boolean success=false;
	//private JPasswordField cp;
	public addFac() {
		setModal(true);
		setResizable(false);
		setTitle("Add New Faculty");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblName = new JLabel("Name :");
			lblName.setBounds(10, 22, 132, 32);
			contentPanel.add(lblName);
		}
		{
			n = new JTextField();
			n.setBounds(152, 28, 282, 26);
			contentPanel.add(n);
			n.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 76, 424, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblPassword = new JLabel("Password :");
			lblPassword.setBounds(10, 102, 132, 32);
			contentPanel.add(lblPassword);
		}
		{
			JLabel lblConfirmPassword = new JLabel("Confirm Password :");
			lblConfirmPassword.setBounds(10, 145, 132, 32);
			contentPanel.add(lblConfirmPassword);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 201, 424, 2);
			contentPanel.add(separator);
		}
		{
			p = new JPasswordField();
			p.setBounds(152, 108, 282, 26);
			contentPanel.add(p);
		}
		
		cp = new JPasswordField();
		cp.setBounds(152, 151, 282, 26);
		contentPanel.add(cp);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				add = new JButton("Add");
				buttonPane.add(add);
			}
			{
				cancel = new JButton("Cancel");
				cancel.setActionCommand("Cancel");
				buttonPane.add(cancel);
			}
		}
		
		add.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						addFaculty();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				
			}
		);
		
		
		
	}
	private boolean addFaculty() throws IOException{
		
		name=n.getText();
		password=p.getText();
		cpassword=cp.getText();
		System.out.println("name="+name);
		System.out.println("pass="+password);
		System.out.println("cpass="+cpassword);
		
		success=false;
		FileInputStream fstream = new FileInputStream("teacherlist.txt");
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine = br.readLine();
		System.out.println("strLine="+strLine);
		if(strLine==null) System.out.println("volya");
		while(strLine!=null){
			System.out.println("strLine="+strLine);
			if(strLine.equals(name)){
				success=false;
				br.close();
				in.close();
				fstream.close();
				return success;
			}
			strLine = br.readLine();
			strLine = br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		if(password.equals(cpassword)){
			addLine("teacherlist.txt",name);
			addLine("teacherlist.txt",MD5(password));
			createEmptyFile(name+"_courselist.txt");
			success=true;
		}
		else{
			success=false;
		}
		return success;
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
	public boolean isSuccess(){
		return success;
	}
}
