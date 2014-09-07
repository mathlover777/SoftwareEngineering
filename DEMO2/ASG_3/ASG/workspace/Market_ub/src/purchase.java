import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;


public class purchase extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ucn;
	private JTextField amount;
	private JTextArea log;
	private JButton add;
	private JButton exit;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	
	private boolean success=false;
	
	
	public purchase() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 340, 301);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEnterYourUcn = new JLabel("Enter Your UCN :");
			lblEnterYourUcn.setBounds(10, 11, 123, 22);
			contentPanel.add(lblEnterYourUcn);
		}
		{
			ucn = new JTextField();
			ucn.setBounds(143, 12, 173, 22);
			contentPanel.add(ucn);
			ucn.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 52, 317, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblEnterAmount = new JLabel("Enter Amount :");
			lblEnterAmount.setBounds(10, 65, 123, 14);
			contentPanel.add(lblEnterAmount);
		}
		{
			amount = new JTextField();
			amount.setBounds(143, 62, 173, 22);
			contentPanel.add(amount);
			amount.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 95, 317, 2);
			contentPanel.add(separator);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(10, 108, 317, 102);
			contentPanel.add(scrollPane);
			{
				log = new JTextArea();
				log.setEditable(false);
				scrollPane.setViewportView(log);
			}
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 227, 314, 2);
			contentPanel.add(separator);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				add = new JButton("Add Amount");
				buttonPane.add(add);
			}
			{
				exit = new JButton("Exit");
				exit.setActionCommand("Cancel");
				buttonPane.add(exit);
			}
		}
		
		add.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						if(addAmount()){
							log.append("Transaction is Successfull !!\nClick on exit to exit");
						}else{
							log.append("Error in Transaction !!");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						log.append("\nSorry Cant connect to DataBase");
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
	
	private boolean addAmount() throws IOException{
		success=false;
		createEmptyFile("tempx.txt");
		FileInputStream fstream = new FileInputStream("clist.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String u=ucn.getText();
		int m=stringToInt(amount.getText());
		if(m<0){
			log.append("\nAmount Cant be Negative...try again !!!");
			br.close();
			in.close();
			fstream.close();
			success=false;
			return false;
		}
		System.out.println("\nUCN="+u);
		strLine=br.readLine();
		while(strLine!=null){
			addLine("tempx.txt",strLine);
			System.out.println("\n"+strLine);
			if(strLine.equals(u)){
				System.out.println("customer found !!");
				strLine=br.readLine();
				addLine("tempx.txt",""+(m+stringToInt(strLine)));
			}
			else{
				strLine=br.readLine();
				addLine("tempx.txt",strLine);
			}
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		copyToFile("tempx.txt","clist.txt");
		success=true;
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
	

}
