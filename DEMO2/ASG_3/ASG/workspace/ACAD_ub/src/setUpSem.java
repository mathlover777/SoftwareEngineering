import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;


public class setUpSem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ecount;
	private JTextField mecount;
	private JTextField name1;
	private JTextField c1;
	private JTextField f1;
	private JTextField name2;
	private JTextField c2;
	private JTextField f2;
	private JButton create;
	private JButton reset;
	private JComboBox cselect;
	private JTextArea log;
	private JButton save1;
	private JComboBox eselect;
	private JButton confirm;
	private JButton save2;
	private JButton cancel;

	/**
	 * Launch the application.
	 */
	

	
	
	public int c,e,me,i=0,j=0;
	public String[] box;
	private JTextField ccount;
	private String[][] clist,elist;
	private boolean success=false;

	/**
	 * Create the dialog.
	 */
	public setUpSem() {
		setResizable(false);
		setModal(true);
		setTitle("Set Up New Semester");
		setBounds(100, 100, 683, 525);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTotalNumberOf = new JLabel("Total Number of Electives :");
			lblTotalNumberOf.setBounds(10, 56, 178, 14);
			contentPanel.add(lblTotalNumberOf);
		}
		{
			ecount = new JTextField();
			ecount.setBounds(262, 53, 86, 20);
			contentPanel.add(ecount);
			ecount.setColumns(10);
		}
		{
			JLabel lblMaxElectivePer = new JLabel("Max Elective Per Student :");
			lblMaxElectivePer.setBounds(10, 92, 178, 14);
			contentPanel.add(lblMaxElectivePer);
		}
		{
			mecount = new JTextField();
			mecount.setBounds(262, 84, 86, 20);
			contentPanel.add(mecount);
			mecount.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 117, 458, 4);
			contentPanel.add(separator);
		}
		{
			create = new JButton("Create");
			create.setBounds(358, 13, 89, 23);
			contentPanel.add(create);
		}
		{
			reset = new JButton("Reset");
			reset.setBounds(358, 52, 89, 23);
			contentPanel.add(reset);
		}
		{
			JLabel lblCoreCourses = new JLabel("Core Courses :");
			lblCoreCourses.setBounds(10, 132, 99, 14);
			contentPanel.add(lblCoreCourses);
		}
		{
			JLabel lblSelectCourse = new JLabel("Select Course :");
			lblSelectCourse.setBounds(10, 157, 99, 14);
			contentPanel.add(lblSelectCourse);
		}
		{
			cselect = new JComboBox();
			//cselect.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
			cselect.setEnabled(false);
			cselect.setBounds(296, 154, 52, 20);
			contentPanel.add(cselect);
		}
		{
			JLabel lblCourseName = new JLabel("Course Name :");
			lblCourseName.setBounds(10, 195, 99, 14);
			contentPanel.add(lblCourseName);
		}
		{
			JLabel lblCredit = new JLabel("Credit :");
			lblCredit.setBounds(10, 222, 99, 14);
			contentPanel.add(lblCredit);
		}
		{
			JLabel lblFacultyName = new JLabel("Faculty Name :");
			lblFacultyName.setBounds(10, 256, 99, 14);
			contentPanel.add(lblFacultyName);
		}
		{
			name1 = new JTextField();
			name1.setEnabled(false);
			name1.setBounds(180, 187, 168, 23);
			contentPanel.add(name1);
			name1.setColumns(10);
		}
		{
			c1 = new JTextField();
			c1.setEnabled(false);
			c1.setBounds(180, 216, 168, 23);
			contentPanel.add(c1);
			c1.setColumns(10);
		}
		{
			f1 = new JTextField();
			f1.setEnabled(false);
			f1.setBounds(180, 252, 168, 23);
			contentPanel.add(f1);
			f1.setColumns(10);
		}
		{
			save1 = new JButton("Save");
			save1.setEnabled(false);
			save1.setBounds(358, 190, 89, 23);
			contentPanel.add(save1);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 282, 458, 4);
			contentPanel.add(separator);
		}
		{
			JLabel lblElectiveCourses = new JLabel("Elective Courses :");
			lblElectiveCourses.setBounds(10, 297, 131, 14);
			contentPanel.add(lblElectiveCourses);
		}
		{
			JLabel label = new JLabel("Select Course :");
			label.setBounds(10, 322, 99, 14);
			contentPanel.add(label);
		}
		{
			eselect = new JComboBox();
			eselect.setEnabled(false);
			eselect.setBounds(180, 319, 52, 20);
			contentPanel.add(eselect);
		}
		{
			JLabel label = new JLabel("Course Name :");
			label.setBounds(10, 356, 131, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Credit :");
			label.setBounds(10, 383, 99, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Faculty Name :");
			label.setBounds(10, 417, 99, 14);
			contentPanel.add(label);
		}
		{
			name2 = new JTextField();
			name2.setEnabled(false);
			name2.setColumns(10);
			name2.setBounds(180, 352, 168, 23);
			contentPanel.add(name2);
		}
		{
			c2 = new JTextField();
			c2.setEnabled(false);
			c2.setColumns(10);
			c2.setBounds(180, 381, 168, 25);
			contentPanel.add(c2);
		}
		{
			f2 = new JTextField();
			f2.setEnabled(false);
			f2.setColumns(10);
			f2.setBounds(180, 412, 168, 25);
			contentPanel.add(f2);
		}
		{
			save2 = new JButton("Save");
			save2.setEnabled(false);
			save2.setBounds(358, 355, 89, 23);
			contentPanel.add(save2);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 444, 655, 4);
			contentPanel.add(separator);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(500, 11, 165, 418);
			contentPanel.add(scrollPane);
			{
				log = new JTextArea();
				log.setLineWrap(true);
				scrollPane.setViewportView(log);
				log.setEditable(false);
			}
		}
		{
			JLabel lblTotalNumbrOf = new JLabel("Total Numbr of Core Subjects :");
			lblTotalNumbrOf.setBounds(10, 17, 221, 14);
			contentPanel.add(lblTotalNumbrOf);
		}
		{
			ccount = new JTextField();
			ccount.setBounds(262, 14, 86, 20);
			contentPanel.add(ccount);
			ccount.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				confirm = new JButton("Confirm");
				confirm.setActionCommand("OK");
				buttonPane.add(confirm);
				getRootPane().setDefaultButton(confirm);
			}
			{
				cancel = new JButton("Cancel");
				cancel.setActionCommand("Cancel");
				buttonPane.add(cancel);
			}
		}
		
		
		/**************************Event Code*******************************/
		
		
		
		
		create.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent ew) {
					// TODO Auto-generated method stub
					c=stringToInt(ccount.getText());
					e=stringToInt(ecount.getText());
					me=stringToInt(mecount.getText());
					clist=new String[c][3];
					elist=new String[e][3];
					enable();
					ccount.setEditable(false);
					ecount.setEditable(false);
					mecount.setEditable(false);
					box=new String[c];
					for(int k=0;k<=c-1;k++){
						for(int l=0;l<=2;l++){
							clist[k][l]="";
						}
						box[k]=""+(k+1);
					}
					cselect.setModel(new DefaultComboBoxModel(box));
					box=new String[e];
					for(int k=0;k<=e-1;k++){
						for(int l=0;l<=2;l++){
							elist[k][l]="";
						}
						box[k]=""+(k+1);
					}
					eselect.setModel(new DefaultComboBoxModel(box));
					
				}
				
			}
		);
		reset.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent ew) {
						// TODO Auto-generated method stub
						disable();
						ccount.setEditable(true);
						ecount.setEditable(true);
						mecount.setEditable(true);
					}
					
				}
			);
		save1.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						clist[i][0]=name1.getText();
						clist[i][1]=c1.getText();
						clist[i][2]=f1.getText();
						log.append("\nData of Core "+(i+1)+" received !!");
					}
					
				}
			);
		save2.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						elist[j][0]=name2.getText();
						elist[j][1]=c2.getText();
						elist[j][2]=f2.getText();
						log.append("\nData of Elective "+(j+1)+" received !!");
					}
					
				}
			);
		confirm.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						success=false;
						try {
							if(save()){
								
							}
							else{
								log.append("\nError in Input ...please check input data...");
							}
							dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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
		cselect.addItemListener(
			new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					name1.setText("");
					c1.setText("");
					f1.setText("");
					i=cselect.getSelectedIndex();
				}
				
			}
		);
		eselect.addItemListener(
				new ItemListener(){

					@Override
					public void itemStateChanged(ItemEvent arg0) {
						// TODO Auto-generated method stub
						name2.setText("");
						c2.setText("");
						f2.setText("");
						j=eselect.getSelectedIndex();
					}
					
				}
			);
	}
	
	public int stringToInt(String s){
		int n=0;
		for(int i=0;i<=s.length()-1;i++){
			n=n*10+(s.charAt(i))-48;
		}
		return n;
	}
	
	public void disable(){
		cselect.setEnabled(false);
		eselect.setEnabled(false);
		name1.setEnabled(false);
		name2.setEnabled(false);
		c1.setEnabled(false);
		c2.setEnabled(false);
		f1.setEnabled(false);
		f2.setEnabled(false);
		save1.setEnabled(false);
		save2.setEnabled(false);
		return;
	}
	public void enable(){
		cselect.setEnabled(true);
		eselect.setEnabled(true);
		name1.setEnabled(true);
		name2.setEnabled(true);
		c1.setEnabled(true);
		c2.setEnabled(true);
		f1.setEnabled(true);
		f2.setEnabled(true);
		save1.setEnabled(true);
		save2.setEnabled(true);
		return;
	}
	
	
	public boolean save() throws IOException{
		for(int k=0;k<=c-1;k++){
			if(!isTeacher(clist[k][2])){
				log.append("\n[ fatal error ... 1 or more faculty do not exist ...]");
				success=false;
				return false;
			}
		}
		//System
		//log.append("faculties found");
		for(int k=0;k<=e-1;k++){
			if(!isTeacher(elist[k][2])){
				success=false;
				return false;
			}
		}
		FileWriter fstream = new FileWriter("clist.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(""+c);
		out.write("\r\n0000");
		for(int k=0;k<=c-1;k++){
			out.write("\r\n"+clist[k][0]);
			out.write("\r\n"+clist[k][1]);
			out.write("\r\n"+clist[k][2]);
		}
		out.close();
		fstream.close();
		fstream = new FileWriter("elist.txt");
		out = new BufferedWriter(fstream);
		out.write(""+e);
		out.write("\r\n"+me);
		for(int k=0;k<=e-1;k++){
			out.write("\r\n"+elist[k][0]);
			out.write("\r\n"+elist[k][1]);
			out.write("\r\n"+elist[k][2]);
		}
		out.close();
		fstream.close();
		FileWriter f;
		BufferedWriter o;
		for(int k=0;k<=c-1;k++){
			createEmptyFile(clist[k][2]+"_courselist.txt");
		}
		for(int k=0;k<=e-1;k++){
			createEmptyFile(elist[k][2]+"_courselist.txt");
		}
		for(int k=0;k<=e-1;k++){
			f = new FileWriter(elist[k][0]+"_list.txt");
			addLine(elist[k][2]+"_courselist.txt",elist[k][0]);
			addLine(elist[k][2]+"_courselist.txt",elist[k][1]);
			createEmptyFile(elist[k][0]+"_complete.txt");
			addLine(elist[k][0]+"_complete.txt","N");
			o = new BufferedWriter(f);
			o.write(elist[k][1]);
			o.close();
			f.close();
		}
		for(int k=0;k<=c-1;k++){
			f = new FileWriter(clist[k][0]+"_list.txt");//list for students registered in that subjects
			addLine(clist[k][2]+"_courselist.txt",clist[k][0]);//list of subbjects for the corresponding faculty
			addLine(clist[k][2]+"_courselist.txt",clist[k][1]);
			createEmptyFile(clist[k][0]+"_gradelist.txt");
			createEmptyFile(clist[k][0]+"_complete.txt");
			addLine(clist[k][0]+"_complete.txt","N");
			o = new BufferedWriter(f);
			o.write(clist[k][1]);
			o.close();
			f.close();
		}
		createEmptyFile("CGPA.txt");
		addLine("CGPA.txt","N");
		unlockAllRegisterOption();
		success=true;
		return success;
	}
	
	
	private void unlockAllRegisterOption() throws IOException{
		FileInputStream fstream = new FileInputStream("studentlist.txt");
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		while(strLine!=null){
			createEmptyFile(strLine+"_registered.txt");
			addLine(strLine+"_registered.txt","N");
			strLine=br.readLine();
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		return;
	}
	
	
	
	
	public boolean isSuccess(){
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
	private boolean isTeacher(String ID) throws IOException{
		FileInputStream fstream = new FileInputStream("teacherlist.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  String strLine="";
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  strLine=br.readLine();
		  while(strLine!=null){
			  if(strLine.equals(ID)){
				  br.close();
				  in.close();
				  fstream.close();
				  return true;
			  }
			  strLine=br.readLine();
			  strLine=br.readLine();
		  }
		  br.close();
		  in.close();
		  fstream.close();
		return false;
	}
	public boolean createEmptyFile(String filename) throws IOException{
		FileWriter f2=new FileWriter(filename);
		BufferedWriter out = new BufferedWriter(f2);
		out.close();
		f2.close();
		return true;
	}

}
