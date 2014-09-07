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
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;


public class register extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField ad1;
	private JTextField ad2;
	private JTextField ad4;
	private JTextField ad3;
	private JTextField p;
	private JTextField d;
	private JTextArea log;
	private JButton register;
	private JButton exit;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public register() {
		setTitle("Fresh Register");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 670, 345);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 11, 126, 14);
		contentPanel.add(lblName);
		
		JLabel lblAddressLine = new JLabel("Address Line 1 :");
		lblAddressLine.setBounds(10, 75, 126, 14);
		contentPanel.add(lblAddressLine);
		
		JLabel lblAddressLine_1 = new JLabel("Address Line 2 :");
		lblAddressLine_1.setBounds(10, 111, 126, 14);
		contentPanel.add(lblAddressLine_1);
		
		JLabel lblAddressLine_2 = new JLabel("Address Line 3 :");
		lblAddressLine_2.setBounds(10, 151, 126, 14);
		contentPanel.add(lblAddressLine_2);
		
		JLabel lblAddressLine_3 = new JLabel("Address Line 4 :");
		lblAddressLine_3.setBounds(10, 187, 126, 14);
		contentPanel.add(lblAddressLine_3);
		
		name = new JTextField();
		name.setBounds(165, 8, 268, 27);
		contentPanel.add(name);
		name.setColumns(10);
		
		ad1 = new JTextField();
		ad1.setBounds(165, 69, 268, 27);
		contentPanel.add(ad1);
		ad1.setColumns(10);
		
		ad2 = new JTextField();
		ad2.setBounds(165, 105, 268, 27);
		contentPanel.add(ad2);
		ad2.setColumns(10);
		
		ad4 = new JTextField();
		ad4.setBounds(165, 181, 268, 27);
		contentPanel.add(ad4);
		ad4.setColumns(10);
		
		ad3 = new JTextField();
		ad3.setBounds(165, 143, 268, 27);
		contentPanel.add(ad3);
		ad3.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone No :");
		lblPhoneNo.setBounds(10, 236, 126, 14);
		contentPanel.add(lblPhoneNo);
		
		JLabel lblDrivingLicenseNumber = new JLabel("Driving License Number :");
		lblDrivingLicenseNumber.setBounds(10, 276, 145, 14);
		contentPanel.add(lblDrivingLicenseNumber);
		
		p = new JTextField();
		p.setBounds(165, 230, 268, 27);
		contentPanel.add(p);
		p.setColumns(10);
		
		d = new JTextField();
		d.setBounds(165, 270, 268, 27);
		contentPanel.add(d);
		d.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 223, 642, 2);
		contentPanel.add(separator);
		
		exit = new JButton("Exit");
		exit.setBounds(443, 272, 209, 34);
		contentPanel.add(exit);
		
		register = new JButton("Register");
		register.setBounds(443, 227, 209, 32);
		contentPanel.add(register);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 56, 428, 2);
		contentPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 308, 642, 11);
		contentPanel.add(separator_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(443, 11, 209, 201);
		contentPanel.add(scrollPane);
		
		log = new JTextArea();
		scrollPane.setViewportView(log);
		log.setLineWrap(true);
		log.setEditable(false);
		
		
		register.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						if(checkInput()){
							saveData();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						log.append("\nError in \nRegisrtration\nDataBase Might Be Corrupted...");
					}
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
	private boolean checkInput(){
		if((name.getText()==null)||(p.getText()==null)||(d.getText()==null)){
			log.append("\nOne or More Necessary Fields are Empty \nPlease Try Again...");
			return false;
		}else{
			return true;
		}
	}
	private void saveData() throws IOException{
		int ucn;
		ucn=generateUcn();
		createEmptyFile("details_"+ucn+".txt");
		addLine("details_"+ucn+".txt",name.getText());
		addLine("details_"+ucn+".txt",ad1.getText());
		addLine("details_"+ucn+".txt",ad2.getText());
		addLine("details_"+ucn+".txt",ad3.getText());
		addLine("details_"+ucn+".txt",ad4.getText());
		addLine("details_"+ucn+".txt",p.getText());
		addLine("details_"+ucn+".txt",d.getText());
		addLine("clist.txt",""+ucn);
		addLine("clist.txt",""+0);
		log.append("Registration Success Full !!!\nPlease Note Your UCN:\n"+ucn+"\n");
		register.setEnabled(false);
		return;
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
	private int generateUcn() throws IOException{
		FileInputStream fstream = new FileInputStream("lastucn.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		br.close();
		in.close();
		fstream.close();
		createEmptyFile("lastucn.txt");
		addLine("lastucn.txt",""+(stringToInt(strLine)+1));
		return (stringToInt(strLine)+1);
	}
}
