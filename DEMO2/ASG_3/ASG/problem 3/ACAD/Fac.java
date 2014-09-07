import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.Color;
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

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;


/*********
 * need to update code to get cgpa 
 * now to get it from cgpa_list.txt instead of indv. files
 * @author Sourav
 *
 */


public class Fac extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField cgpa;
	private JTextField me;
	private JTextField te;
	private JTextArea log;
	private JButton find;
	private JButton refine;
	private JButton save;
	private JButton exit;
	private ButtonGroup group;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	
	/**************Student Data*************************/
	private int scount=0,mecount=0,etotal=0;
	private double base=0.0;
	private String[][] etaken;
	private String[] weaklist;
	private int[][] mod;
	private int[] ecount;
	private JComboBox eselect;
	private JComboBox sselect;
	private int sindex=0,eindex=0;
	private JTextField name;
	private JButton give;
	private JButton take;
	
	
	public Fac() {
		setModal(true);
		setResizable(false);
		setTitle("Semester Tailoring");
		setBounds(100, 100, 542, 402);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Student ID");
			lblNewLabel.setBounds(10, 63, 107, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblBaseCgpa = new JLabel("Base CGPA :");
			lblBaseCgpa.setBounds(10, 19, 76, 14);
			contentPanel.add(lblBaseCgpa);
		}
		{
			cgpa = new JTextField();
			cgpa.setBounds(96, 16, 86, 20);
			contentPanel.add(cgpa);
			cgpa.setColumns(10);
		}
		{
			find = new JButton("Find");
			find.setBounds(192, 15, 148, 23);
			contentPanel.add(find);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 50, 508, 2);
			contentPanel.add(separator);
		}
		{
			sselect = new JComboBox();
			//sselect.setSelectedIndex(0);
			
			sselect.setBounds(96, 60, 183, 20);
			contentPanel.add(sselect);
		}
		{
			JLabel lblMaxOf = new JLabel("Max # of Electives :");
			lblMaxOf.setBounds(10, 105, 148, 14);
			contentPanel.add(lblMaxOf);
		}
		{
			me = new JTextField();
			me.setBackground(Color.WHITE);
			me.setEditable(false);
			me.setBounds(192, 102, 86, 20);
			contentPanel.add(me);
			me.setColumns(10);
		}
		{
			JLabel lblElectivesTaken = new JLabel("Electives Taken :");
			lblElectivesTaken.setBounds(10, 139, 107, 14);
			contentPanel.add(lblElectivesTaken);
		}
		{
			te = new JTextField();
			te.setBackground(Color.WHITE);
			te.setEditable(false);
			te.setBounds(192, 133, 86, 20);
			contentPanel.add(te);
			te.setColumns(10);
		}
		{
			JLabel lblSelectElective = new JLabel("Select Elective Slot :");
			lblSelectElective.setBounds(10, 167, 172, 14);
			contentPanel.add(lblSelectElective);
		}
		{
			eselect = new JComboBox();
			//eselect.setSelectedIndex(0);
			eselect.setBounds(10, 192, 183, 20);
			contentPanel.add(eselect);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(289, 63, 229, 166);
		contentPanel.add(scrollPane);
		
		log = new JTextArea();
		log.setLineWrap(true);
		scrollPane.setViewportView(log);
		log.setEditable(false);
		{
			refine = new JButton("Refine");
			refine.setBounds(370, 15, 148, 23);
			contentPanel.add(refine);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 328, 508, 2);
			contentPanel.add(separator);
		}
		
		JLabel lblDetail = new JLabel("Detail :");
		lblDetail.setBounds(10, 223, 46, 14);
		contentPanel.add(lblDetail);
		
		name = new JTextField();
		name.setBounds(10, 248, 183, 20);
		contentPanel.add(name);
		name.setColumns(10);
		
		take = new JButton("Remove");
		take.setBounds(214, 280, 136, 23);
		contentPanel.add(take);
		
		give = new JButton("Leave To Student");
		give.setBounds(214, 248, 136, 21);
		contentPanel.add(give);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				save = new JButton("Save");
				buttonPane.add(save);
			}
			{
				exit = new JButton("Exit");
				exit.setActionCommand("Cancel");
				buttonPane.add(exit);
			}
		}
		give.setEnabled(false);
		take.setEnabled(false);
		
		find.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					find.setEnabled(false);
					cgpa.setEditable(false);
					sselect.setEnabled(true);
					eselect.setEnabled(false);
					give.setEnabled(false);
					take.setEnabled(false);
					base=stringToDouble(cgpa.getText());
					try {
						findStudents();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		);
		refine.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						give.setEnabled(false);
						take.setEnabled(false);
						sselect.setEnabled(false);
						eselect.setEnabled(false);
						find.setEnabled(true);
						cgpa.setEditable(true);
						te.setText("");
						me.setText("");
					}
					
				}
			);
		save.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							saveData();
							log.append("\nDatabase successfully modified !!! ");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
							log.append("Sorry cant complete request update database !!!..database may be corrupted..");
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
		sselect.addItemListener(
			new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					if(sselect.getSelectedIndex()==0){
						te.setText("");
						eselect.setEnabled(false);
					}
					else{
						sindex=sselect.getSelectedIndex()-1;
						te.setText(""+ecount[sindex]);
						eselect.setEnabled(true);
					}
					if(eselect.getSelectedIndex()==0){
						give.setEnabled(false);
						take.setEnabled(false);
					}
					else{
						eindex=eselect.getSelectedIndex()-1;
						if(etaken[sindex][eindex]!=null){
							name.setText(etaken[sindex][eindex]);
							////System.out.println("mod["+sindex+"]["+eindex+"]="+mod[sindex][eindex]);
							if(mod[sindex][eindex]==0){
								take.setEnabled(false);
								give.setEnabled(true);
							}
							else{
								take.setEnabled(true);
								give.setEnabled(false);
							}
						}else{
							name.setText("Empty");
							take.setEnabled(false);
							give.setEnabled(false);
						}
					}
				}
				
			}
		);
		eselect.addItemListener(
				new ItemListener(){

					@Override
					public void itemStateChanged(ItemEvent arg0) {
						// TODO Auto-generated method stub
						if(eselect.getSelectedIndex()==0){
							give.setEnabled(false);
							take.setEnabled(false);
						}
						else{
							eindex=eselect.getSelectedIndex()-1;
							if(etaken[sindex][eindex]!=null){
								name.setText(etaken[sindex][eindex]);
								////System.out.println("mod["+sindex+"]["+eindex+"]="+mod[sindex][eindex]);
								if(mod[sindex][eindex]==0){
									take.setEnabled(false);
									give.setEnabled(true);
								}
								else{
									take.setEnabled(true);
									give.setEnabled(false);
								}
							}else{
								name.setText("Empty");
								take.setEnabled(false);
								give.setEnabled(false);
							}
						}
					}
					
				}
			);
		
		give.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					mod[sindex][eindex]=1;
					////System.out.println("mod["+sindex+"]["+eindex+"]="+mod[sindex][eindex]);
					give.setEnabled(false);
					take.setEnabled(true);
				}
				
			}
		);
		take.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						mod[sindex][eindex]=0;
						////System.out.println("mod["+sindex+"]["+eindex+"]="+mod[sindex][eindex]);
						give.setEnabled(true);
						take.setEnabled(false);
					}
					
				}
			);
	}
	
	private void findStudents() throws IOException{
		FileInputStream fstream = new FileInputStream("cgpa_list.txt");
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		createEmptyFile("weak.txt");
		FileInputStream f;
		DataInputStream i;
		BufferedReader b;
		String Line="";
		
		double cg; 
		String id=null;
		id=br.readLine();
		////System.out.println("BASE="+base);
		scount=0;
		while(id!=null){
			strLine=br.readLine();
			cg=stringToDouble(strLine);
			//System.out.println("ID="+id);
			//System.out.println("CGPA="+cg);
			if(cg<base){
				addLine("weak.txt",id);
				scount++;
				//System.out.println("Adding "+id+" to weak list...");
			}
			strLine=br.readLine();
			strLine=br.readLine();
			strLine=br.readLine();
			id=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		fstream = new FileInputStream("elist.txt");
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		etotal=stringToInt(br.readLine());
		strLine=br.readLine();
		mecount=stringToInt(strLine);
		br.close();
		in.close();
		fstream.close();
		etaken=new String[scount][mecount];
		int l=0,j=0;
		for(l=0;l<=scount-1;l++){
			for(j=0;j<=mecount-1;j++){
				etaken[l][j]=null;
			}
		}
		mod=new int[scount][mecount];
		ecount=new int[scount];
		for(l=0;l<=scount-1;l++){
			for(j=0;j<=mecount-1;j++){
				mod[l][j]=1;
			}
			ecount[l]=0;
		}
		weaklist=new String[scount];
		fstream = new FileInputStream("weak.txt");
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		l=0;
		while(strLine!=null){
			weaklist[l]=""+strLine;
			//System.out.println("got "+strLine+" from weak list ...");
			f=new FileInputStream(strLine+"_elective.txt");
			i=new DataInputStream(f);
			b=new BufferedReader(new InputStreamReader(i));
			Line=b.readLine();
			j=0;
			while(Line!=null){
				etaken[l][j]=Line;
				//mod[l][j]=1;
				Line=b.readLine();
				j++;
				ecount[l]++;
			}
			b.close();
			i.close();
			f.close();
			l++;
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		String[] box;
		box=new String[scount+1];
		box[0]="Select";
		for(j=1;j<=scount;j++){
			box[j]=""+weaklist[j-1];
		}
		sselect.setModel(new DefaultComboBoxModel(box));
		box=new String[mecount+1];
		box[0]="Select";
		for(j=1;j<=mecount;j++){
			box[j]=""+j;
		}
		eselect.setModel(new DefaultComboBoxModel(box));
		return;
	}
	
	public boolean createEmptyFile(String filename) throws IOException{
		FileWriter f2=new FileWriter(filename);
		BufferedWriter out = new BufferedWriter(f2);
		out.close();
		f2.close();
		return true;
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
	public int stringToInt(String s){
		int n=0;
		for(int i=0;i<=s.length()-1;i++){
			n=n*10+(s.charAt(i))-48;
		}
		return n;
	}
	
	private void saveData() throws IOException{
		int i=0,j=0;
		for(i=0;i<=scount-1;i++){
			createEmptyFile(weaklist[i]+"_elective.txt");
			for(j=0;j<=mecount-1;j++){
				if((mod[i][j]==1)&&(etaken[i][j]!=null)){
					addLine(weaklist[i]+"_elective.txt",etaken[i][j]);
				}
				if((mod[i][j]==0)&&(etaken[i][j]!=null)){
					removeStudent(etaken[i][j],weaklist[i]);
				}
			}
		}
		return;
	}
	
	private void removeStudent(String coursename,String StudentID) throws IOException{
		FileInputStream fstream = new FileInputStream(coursename+"_list.txt");
		createEmptyFile("tempx.txt");
		DataInputStream in = new DataInputStream(fstream);
		String strLine=null;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();//first line of course list contains the credit of the course
		addLine("tempx.txt",strLine);
		strLine=br.readLine();
		while(strLine!=null){
			if(!strLine.equals(StudentID)){
				addLine("tempx.txt",strLine);
			}
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		copyToFile("tempx.txt",coursename+"_list.txt");
	}
	private double stringToDouble(String line){
		Float f;
		double d;
		f=new Float(line);
		d= f.doubleValue();
		return d;
	}
}
