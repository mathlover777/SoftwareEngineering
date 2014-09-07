import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.SystemColor;


public class Dean extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton setup;
	private JButton view;
	private JTextArea log;
	private JButton retrieve;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	
	private JDialog t;
	private JButton addfaculty;
	private JButton cgpa;
	private JButton exit;
	
	
	
	
	
	
	public Dean() {
		setResizable(false);
		setModal(true);
		setTitle("Deans Page");
		setBounds(100, 100, 485, 402);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 96, 466, 265);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			contentPanel.add(scrollPane);
			{
				log = new JTextArea();
				scrollPane.setViewportView(log);
				log.setEditable(false);
			}
			log.setText("\nWelcome !!!...[logged in as DEAN's]");
		}
		{
			setup = new JButton("Set Up New Sem");
			setup.setBounds(10, 21, 154, 23);
			setup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			contentPanel.add(setup);
		}
		{
			view = new JButton("View Details");
			view.setBounds(10, 62, 154, 23);
			contentPanel.add(view);
		}
		{
			retrieve = new JButton("Retrieve Password");
			retrieve.setBounds(315, 21, 161, 23);
			contentPanel.add(retrieve);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		{
			addfaculty = new JButton("Add Faculty");
			addfaculty.setBounds(174, 62, 133, 23);
			contentPanel.add(addfaculty);
		}
		{
			cgpa = new JButton("Generate CGPA");
			cgpa.setBounds(174, 21, 133, 23);
			contentPanel.add(cgpa);
		}
		{
			exit = new JButton("Exit");
			exit.setBounds(315, 62, 161, 23);
			contentPanel.add(exit);
		}
		setup.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					t=new setUpSem();
					t.setVisible(true);
					if(((setUpSem)t).isSuccess()){
						log.append("\n\nNew Semester Successfully Set Uo !!!");
					}
					else{
						log.append("\n\nError while setting up new Semester !! :( ");
					}
				}
				
			}
		);
		
		retrieve.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					t=new changePass();
					t.setVisible(true);
					if(((changePass)t).isSuccess()){
						log.append("\nPassword Successfully changed..");
					}
					else{
						log.append("\n Unable to change password !!");
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
		cgpa.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							if(isAllGradeGiven()){
								makeCgpa();
								createEmptyFile("CGPA.txt");
								addLine("CGPA.txt","Y");
							}
							else{
								log.append("\nSome Faculties have not submitted complete grade list !!");
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
			);
		view.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t=new viewSem();
						t.setVisible(true);
					}
					
				}
			);
		addfaculty.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t=new addFac();
						t.setVisible(true);
						if(((addFac)t).isSuccess()){
							log.append("\nNew Faculty added !!! ");
						}
						else{
							log.append("\nFaculty already exists in database...or contact developer !!");
						}
					}
				}
			);
	}
	
	
	
	private boolean isAllGradeGiven() throws IOException{
		FileInputStream fstream = new FileInputStream("clist.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		FileInputStream f;
		// Get the object of DataInputStream
		DataInputStream i;
		String s="";
		BufferedReader b;
		int flag=0;
		strLine=br.readLine();
		strLine=br.readLine();
		strLine=br.readLine();
		while(strLine!=null){
			//System.out.println("filename="+strLine+"_complete.txt");
			f = new FileInputStream(strLine+"_complete.txt");
			// Get the object of DataInputStream
			i = new DataInputStream(f);
			s="";
			b = new BufferedReader(new InputStreamReader(i));
			s=b.readLine();
			//System.out.println("s="+s);
			if(!s.equals("Y")){
				flag=1;
			}
			b.close();
			i.close();
			f.close();
			strLine=br.readLine();
			strLine=br.readLine();
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		if(flag==1){
			return false;
		}
		fstream = new FileInputStream("elist.txt");
		in = new DataInputStream(fstream);
		strLine="";
		br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		strLine=br.readLine();
		strLine=br.readLine();
		while(strLine!=null){
			//System.out.println("filename="+strLine+"_complete.txt");
			f = new FileInputStream(strLine+"_complete.txt");
			// Get the object of DataInputStream
			i = new DataInputStream(f);
			s="";
			b = new BufferedReader(new InputStreamReader(i));
			s=b.readLine();
			//System.out.println("s="+s);
			if(!s.equals("Y")){
				flag=1;
			}
			b.close();
			i.close();
			f.close();
			strLine=br.readLine();
			strLine=br.readLine();
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		if(flag==1){
			return false;
		}
		return true;
	}
	
	

	
	private void makeCgpa() throws IOException{
		double ocgpa,oacgpa,cgpa,acgpa;
		makeGradeList m;
		int ccleared,ecleared;
		int newc,newe,cpoint,epoint;
		FileInputStream fstream = new FileInputStream("cgpa_list.txt");
		createEmptyFile("tempcgpa.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		while(strLine!=null){
			//System.out.println("LINE="+strLine);
			m=new makeGradeList(strLine);
			//System.out.println("returned LINE="+strLine);
			ocgpa=stringToDouble(br.readLine());
			ccleared=stringToInt(br.readLine());
			oacgpa=stringToDouble(br.readLine());
			ecleared=stringToInt(br.readLine());
			newc=m.getNewC();
			newe=m.getNewE();
			cpoint=m.getCpoint();
			epoint=m.getEpoint();
			//System.out.println("Student ID="+strLine);
			//System.out.println("new credits cleared="+newc);
			//System.out.println("new additionals cleared="+newe);
			//System.out.println("cponts="+cpoint);
			//System.out.println("eponts="+epoint);
			if((newc+ccleared)!=0){
				cgpa=(((double)ocgpa)*(double)ccleared+(double)cpoint)/((double)newc+(double)ccleared);
			}
			else{
				cgpa=0.0;
			}
			if((newe+ecleared)!=0){
				acgpa=(((double)oacgpa)*(double)ecleared+(double)epoint)/((double)newe+(double)ecleared);
			}
			else{
				acgpa=0.0;
			}
			ccleared=ccleared+newc;
			ecleared=ecleared+newe;
			addLine("tempcgpa.txt",strLine);
			addLine("tempcgpa.txt",""+cgpa);
			addLine("tempcgpa.txt",""+ccleared);
			addLine("tempcgpa.txt",""+acgpa);
			addLine("tempcgpa.txt",""+ecleared);
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		copyToFile("tempcgpa.txt","cgpa_list.txt");
		return;
	}
	
	
	
	private double stringToDouble(String line){
		Float f;
		double d;
		f=new Float(line);
		d= f.doubleValue();
		return d;
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
