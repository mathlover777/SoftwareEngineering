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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;


public class Grade extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField coursename;
	private JTextField studentcount;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	private String filename="",course="";
	private String[] students;
	private char[] grade;
	private int scount=0;
	private int selected=0;
		
	
	
	private JButton givegrade;
	private JButton save;
	private JButton exit;
	private JButton next;
	private JButton prev;
	private JTextArea log;
	private JComboBox sselect;
	private JComboBox g;
	public Grade(String cname) {
		setTitle("Grade Page");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 604, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 411, 576, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblCourse = new JLabel("Course :");
			lblCourse.setBounds(10, 25, 80, 24);
			contentPanel.add(lblCourse);
		}
		{
			coursename = new JTextField();
			coursename.setEditable(false);
			coursename.setBounds(100, 27, 211, 22);
			contentPanel.add(coursename);
			coursename.setColumns(10);
		}
		{
			JLabel lblStudents = new JLabel("Students :");
			lblStudents.setBounds(10, 73, 80, 14);
			contentPanel.add(lblStudents);
		}
		{
			studentcount = new JTextField();
			studentcount.setEditable(false);
			studentcount.setBounds(100, 70, 211, 24);
			contentPanel.add(studentcount);
			studentcount.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 112, 576, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblStudent = new JLabel("Student :");
			lblStudent.setBounds(10, 128, 80, 14);
			contentPanel.add(lblStudent);
		}
		{
			sselect = new JComboBox();
			
			sselect.setBounds(100, 125, 211, 22);
			contentPanel.add(sselect);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 167, 576, 2);
			contentPanel.add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 222, 576, 2);
			contentPanel.add(separator);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 235, 576, 178);
			contentPanel.add(scrollPane);
			{
				log = new JTextArea();
				scrollPane.setViewportView(log);
			}
		}
		{
			givegrade = new JButton("Give Grade");
			givegrade.setBounds(477, 181, 109, 32);
			contentPanel.add(givegrade);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(20, 428, 566, 2);
			contentPanel.add(separator);
		}
		{
			prev = new JButton("<< Prev");
			prev.setBounds(321, 124, 125, 32);
			contentPanel.add(prev);
		}
		{
			next = new JButton("Next >>");
			next.setBounds(461, 124, 125, 32);
			contentPanel.add(next);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				save = new JButton("Save And Exit");
				buttonPane.add(save);
			}
			{
				exit = new JButton("Exit Without ");
				exit.setActionCommand("Cancel");
				buttonPane.add(exit);
			}
		}
		
		
		/*********************Data code******************/
		course=""+cname;
		filename=cname+"_list.txt";
		try {
			getData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//log.append("Cant find student list...");
		}
		studentcount.setText(""+scount);
		coursename.setText(cname);
		/****************Data Code**********************************/
		
		
		
		JLabel lblGradeStatus = new JLabel("Grade Status :");
		lblGradeStatus.setBounds(222, 196, 89, 14);
		contentPanel.add(lblGradeStatus);
		
		g = new JComboBox();
		g.setModel(new DefaultComboBoxModel(new String[] {"Not Given", "EX", "A", "B", "C", "D", "P", "F"}));
		g.setBounds(321, 190, 125, 20);
		contentPanel.add(g);
		
		sselect.addItemListener(
				new ItemListener(){

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						selected=sselect.getSelectedIndex();
						if(selected==0){
							givegrade.setEnabled(false);
							prev.setEnabled(false);
							next.setEnabled(true);
						}
						else{
							givegrade.setEnabled(true);
							prev.setEnabled(true);
							next.setEnabled(true);
							if(selected==scount){
								next.setEnabled(false);
							}
							showGrade();
						}
					}
					
				}
			);
			
			givegrade.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(selected==0){
							log.append("\nNo student selected..please select some student !!");
						}
						else{
							setGrade();
						}
					}
					
				}
			);
			
			next.addActionListener(
					new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							selected++;
							sselect.setSelectedIndex(selected);
							if(selected==scount){
								next.setEnabled(false);
							}
						}
						
					}
				);
			
			prev.addActionListener(
					new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							if(selected!=0){
								selected--;
								sselect.setSelectedIndex(selected);
								if(selected==0){
									prev.setEnabled(false);
									g.setSelectedIndex(0);
								}
							}
						}
						
					}
				);
			
			save.addActionListener(
					new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							try {
								saveData();
								isGivenToAll();
								log.append("\nGrade list saved...click on exit to exit");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
				);
			exit.addActionListener(
					new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							dispose();
						}
						
					}
				);
			
		
		
	}
	
	
	public void getData() throws IOException{
		FileInputStream fstream = new FileInputStream(filename);
		//System.out.println("Working ");
		DataInputStream in = new DataInputStream(fstream);
		String strLine=null;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		strLine=br.readLine();
		scount=0;
		while(strLine!=null){
			strLine=br.readLine();
			scount++;
		}
		br.close();
		in.close();
		fstream.close();
		students=new String[scount];
		grade=new char[scount];
		fstream = new FileInputStream(filename);
		in = new DataInputStream(fstream);
		strLine=null;
		br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		strLine=br.readLine();
		int i=0;
		while(strLine!=null){
			students[i]=""+strLine;
			//grade[i]='N';
			strLine=br.readLine();
			i++;
		}
		br.close();
		in.close();
		fstream.close();
		String[] box=new String[scount+1];
		box[0]="Select";
		//System.out.println("\nbox[0]="+box[0]);
		for(i=1;i<=scount;i++){
			box[i]=""+students[i-1];
		}
		//System.out.println("Working ");
		sselect.setModel(new DefaultComboBoxModel(box));
		try{
			prevGrades();
		}catch(IOException e){
			log.append("\nGarde is not alloted ...");
		}
		return;
	}
	
	private void saveData() throws IOException{
		FileWriter f2=new FileWriter(course+"_gradelist.txt");
		BufferedWriter out = new BufferedWriter(f2);
		out.write(students[0]);
		out.write("\r\n"+grade[0]);
		for(int i=1;i<=scount-1;i++){
			out.write("\r\n"+students[i]);
			out.write("\r\n"+grade[i]);
		}
		out.close();
		f2.close();
	}
	
	private void showGrade(){
		switch(grade[selected-1]){
		case 'E':{
			g.setSelectedIndex(1);
			break;
		}case 'A':{
			g.setSelectedIndex(2);
			break;
		}case 'B':{
			g.setSelectedIndex(3);
			break;
		}case 'C':{
			g.setSelectedIndex(4);
			break;
		}case 'D':{
			g.setSelectedIndex(5);
			break;
		}case 'P':{
			g.setSelectedIndex(6);
			break;
		}case 'F':{
			g.setSelectedIndex(7);
			break;
		}case 'N':{
			g.setSelectedIndex(0);
			break;
		}
		}
	}
	
	public void prevGrades() throws IOException{
		FileInputStream fstream = new FileInputStream(course+"_gradelist.txt");
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		int i;
		for(i=0;i<=scount-1;i++){
			grade[i]='N';
		}
		if(strLine==null){
			br.close();
			in.close();
			fstream.close();
			return;
		}
		i=0;
		while(strLine!=null){
			strLine=br.readLine();
			grade[i]=strLine.charAt(0);
			strLine=br.readLine();
			i++;
		}
		br.close();
		in.close();
		fstream.close();
		return;
	}
	
	public void setGrade(){
		switch(g.getSelectedIndex()){
		case 0:{
			log.append("\nPlease Specify a grade !!");
			break;
		}case 1:{
			grade[selected-1]='E';
			log.append("\nEX given to "+students[selected-1]);
			break;
		}case 2:{
			grade[selected-1]='A';
			log.append("\nA given to "+students[selected-1]);
			break;
		}case 3:{
			grade[selected-1]='B';
			log.append("\nB given to "+students[selected-1]);
			break;
		}case 4:{
			grade[selected-1]='C';
			log.append("\nC given to "+students[selected-1]);
			break;
		}case 5:{
			grade[selected-1]='D';
			log.append("\nD given to "+students[selected-1]);
			break;
		}case 6:{
			grade[selected-1]='P';
			log.append("\nP given to "+students[selected-1]);
			break;
		}case 7:{
			grade[selected-1]='F';
			log.append("\nF given to "+students[selected-1]);
			break;
		}
		}
		return;
	}
	private void isGivenToAll() throws IOException{
		int flag=0;
		for(int i=0;i<=scount-1;i++){
			if(grade[i]=='N'){
				flag=1;
				log.append("\nSome students dont have grades !!");
				break;
			}
		}
		FileWriter f2=new FileWriter(course+"_complete.txt");
		BufferedWriter out = new BufferedWriter(f2);
		if(flag==1){
			out.write("N");
		}
		else{
			out.write("Y");
		}
		out.close();
		f2.close();
	}
}
