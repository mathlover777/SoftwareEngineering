import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
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

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;


public class semReg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField cn;
	private JTextField cc;
	private JTextField cf;
	private JTextField en;
	private JTextField ec;
	private JTextField ef;
	private JTextField me;
	private JTextArea log;
	private JButton save;
	private JButton remove;
	private JButton add;
	private JComboBox eselect;
	private JComboBox cselect;
	private JButton ok;
	private JButton close;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	
	/*********************registration data**************************/
	private int ccount=0,ecount=0,mecount=0;
	private String[][] clist,elist;
	private String[][] etaken;
	private int cselected=0,eselected=0;
	private String[] box1,box2;
	private int taken=0,eidselected=0;
	private JButton reset;
	private boolean success=false;
	private String studentId="";
	private int[] selected;
	/****************************************************************/
	
	
	public semReg(String ID) {
		setResizable(false);
		setModal(true);
		setTitle("Register for Semester");
		setBounds(100, 100, 687, 516);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCoreCourses = new JLabel("Core Courses :");
			lblCoreCourses.setBounds(10, 26, 150, 14);
			contentPanel.add(lblCoreCourses);
		}
		{
			JLabel lblSelectCourseTo = new JLabel("Select Course To View Details :");
			lblSelectCourseTo.setBounds(10, 64, 186, 14);
			contentPanel.add(lblSelectCourseTo);
		}
		{
			cselect = new JComboBox();
			cselect.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
			cselect.setBounds(10, 89, 268, 20);
			contentPanel.add(cselect);
		}
		{
			JLabel lblNewLabel = new JLabel("Course Name :");
			lblNewLabel.setBounds(310, 64, 105, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblCredits = new JLabel("Credits :");
			lblCredits.setBounds(310, 92, 105, 14);
			contentPanel.add(lblCredits);
		}
		{
			JLabel lblFaculty = new JLabel("Faculty :");
			lblFaculty.setBounds(310, 117, 105, 14);
			contentPanel.add(lblFaculty);
		}
		{
			cn = new JTextField();
			cn.setBackground(Color.WHITE);
			cn.setEditable(false);
			cn.setBounds(473, 64, 196, 20);
			contentPanel.add(cn);
			cn.setColumns(10);
		}
		{
			cc = new JTextField();
			cc.setBackground(Color.WHITE);
			cc.setEditable(false);
			cc.setBounds(473, 89, 196, 20);
			contentPanel.add(cc);
			cc.setColumns(10);
		}
		{
			cf = new JTextField();
			cf.setBackground(Color.WHITE);
			cf.setEditable(false);
			cf.setBounds(473, 114, 196, 20);
			contentPanel.add(cf);
			cf.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 147, 659, 2);
			contentPanel.add(separator);
		}
		{
			JLabel label = new JLabel("Select Course To View Details :");
			label.setBounds(10, 187, 268, 14);
			contentPanel.add(label);
		}
		{
			eselect = new JComboBox();
			eselect.setBounds(10, 227, 268, 20);
			contentPanel.add(eselect);
		}
		{
			JLabel label = new JLabel("Course Name :");
			label.setBounds(310, 180, 105, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Credits :");
			label.setBounds(310, 207, 105, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Faculty :");
			label.setBounds(310, 230, 105, 14);
			contentPanel.add(label);
		}
		{
			en = new JTextField();
			en.setBackground(Color.WHITE);
			en.setEditable(false);
			en.setColumns(10);
			en.setBounds(473, 177, 196, 20);
			contentPanel.add(en);
		}
		{
			ec = new JTextField();
			ec.setBackground(Color.WHITE);
			ec.setEditable(false);
			ec.setColumns(10);
			ec.setBounds(473, 202, 196, 20);
			contentPanel.add(ec);
		}
		{
			ef = new JTextField();
			ef.setBackground(Color.WHITE);
			ef.setEditable(false);
			ef.setColumns(10);
			ef.setBounds(473, 227, 196, 20);
			contentPanel.add(ef);
		}
		{
			add = new JButton("Add");
			add.setBounds(501, 258, 68, 23);
			contentPanel.add(add);
		}
		{
			JLabel lblMaxofElectives = new JLabel("Max #of Electives  :");
			lblMaxofElectives.setBounds(10, 258, 150, 14);
			contentPanel.add(lblMaxofElectives);
		}
		{
			me = new JTextField();
			me.setBackground(Color.WHITE);
			me.setEditable(false);
			me.setBounds(12, 282, 86, 20);
			contentPanel.add(me);
			me.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 328, 659, 2);
			contentPanel.add(separator);
		}
		{
			save = new JButton("Save");
			save.setForeground(Color.BLACK);
			save.setBounds(501, 300, 68, 23);
			contentPanel.add(save);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 341, 659, 98);
			contentPanel.add(scrollPane);
			{
				log = new JTextArea();
				scrollPane.setViewportView(log);
				log.setLineWrap(true);
			}
		}
		{
			remove = new JButton("Remove");
			remove.setBounds(580, 258, 89, 23);
			contentPanel.add(remove);
		}
		{
			reset = new JButton("Reset All");
			reset.setBounds(580, 300, 89, 23);
			contentPanel.add(reset);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 659, 0);
		contentPanel.add(separator);
		
		JLabel lblSelectElectives = new JLabel("Select Electives :");
		lblSelectElectives.setBounds(10, 160, 150, 14);
		contentPanel.add(lblSelectElectives);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				ok = new JButton("Confirm Registration");
				ok.setEnabled(false);
				ok.setActionCommand("OK");
				buttonPane.add(ok);
				getRootPane().setDefaultButton(ok);
			}
			{
				close = new JButton("close");
				close.setActionCommand("Cancel");
				buttonPane.add(close);
			}
		}
		
		/************************Initialization********************************/
		try {
			getData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			disableall();
			log.append("\n\nSorry Cant connect with database or Semester is not Ready !!...try again later...:(");
		}
		resetAll();
		studentId=""+ID;
		/************************************************************************/
		
		cselect.addItemListener(
			new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					cselected=cselect.getSelectedIndex();
					if(cselected==0){
						cn.setText("");
						cc.setText("");
						cf.setText("");
					}
					else{
						cn.setText(clist[cselected-1][0]);
						cc.setText(clist[cselected-1][1]);
						cf.setText(clist[cselected-1][2]);
					}
				}
			}
		);
		
		
		/************need to write much**********************/
		eselect.addItemListener(
				new ItemListener(){

					@Override
					public void itemStateChanged(ItemEvent arg0) {
						// TODO Auto-generated method stub
						eselected=eselect.getSelectedIndex();
						if(eselected==0){
							en.setText("");
							ec.setText("");
							ef.setText("");
							add.setEnabled(false);
							remove.setEnabled(false);
						}
						else{
							if(selected[eselected-1]!=-1){
								add.setEnabled(false);
								remove.setEnabled(true);
							}
							else{
								add.setEnabled(true);
								remove.setEnabled(false);
							}
							en.setText(elist[eselected-1][0]);
							ec.setText(elist[eselected-1][1]);
							ef.setText(elist[eselected-1][2]);
						}
					}
				}
			);
		
		add.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(taken<mecount){
						taken++;
						//etaken[eidselected-1][0]=elist[eselected-1][0];
						//etaken[eidselected-1][1]=elist[eselected-1][1];
						//etaken[eidselected-1][2]=elist[eselected-1][2];
						selected[eselected-1]=1;
						log.append("\n"+elist[eselected-1][0]+" taken as Elective number = "+taken+"...");
						add.setEnabled(false);
						remove.setEnabled(true);
					}
					else{
						log.append("\nAll slots of electives filled !!!");
						printSelected();
					}
				}
			}
		);
		remove.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(taken>0){
						taken--;
						//selected[eselected]=-1;
						//etaken[eidselected-1][0]="";
						//etaken[eidselected-1][1]="";
						//etaken[eidselected-1][2]="";
						selected[eselected-1]=-1;
						remove.setEnabled(false);
						add.setEnabled(true);
						log.append("\n"+elist[eselected-1][0]+" removed from elective...");
					}
					else{
						log.append("\nNo elective to remove !!");
					}
				}
			}
		);
		save.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					log.append("\n Click on Confirm Registration to CONFIRM registration...otherwise click on Reset All to reset and try again..");
					ok.setEnabled(true);
				}
			}
		);
		reset.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					log.append("\n Fields has been resetted !!!");
					ok.setEnabled(false);
					add.setEnabled(false);
					remove.setEnabled(false);
					resetAll();
				}
				
			}
		);
		close.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			}
		);
		ok.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						if(savedata()){
							log.append("\n Registration successfull !!!");
							disableall();
							log.append("\n Click on close to exit...");
						}
						else{
							log.append("\n Cant complete request contact developer....");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		);
		
	}
	
	
	private void getData() throws IOException{
		FileInputStream fstream = new FileInputStream("clist.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  String strLine="";
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  strLine=br.readLine();
		  ccount=stringToInt(strLine);
		  strLine=br.readLine();
		  clist=new String[ccount][3];
		  int i=0;
		  for(i=0;i<=ccount-1;i++){
			  clist[i][0]=br.readLine();
			  clist[i][1]=br.readLine();
			  clist[i][2]=br.readLine();
		  }
		  br.close();
		  in.close();
		  fstream.close();
		  fstream = new FileInputStream("elist.txt");
		  // Get the object of DataInputStream
		  in = new DataInputStream(fstream);
		  strLine="";
		  br = new BufferedReader(new InputStreamReader(in));
		  ecount=stringToInt(br.readLine());
		  mecount=stringToInt(br.readLine());
		  //System.out.println("#total electives :"+ecount);
		  //System.out.println("#max electives :"+mecount);
		  me.setText(""+mecount);
		  elist=new String[ecount][3];
		  for(i=0;i<=ecount-1;i++){
			  elist[i][0]=br.readLine();
			  elist[i][1]=br.readLine();
			  elist[i][2]=br.readLine();
		  }
		  box1=new String[ccount+1];
		  box2=new String[ecount+1];
		  box1[0]="Select";
		  box2[0]="Select";
		  for(i=1;i<=ccount;i++){
			  box1[i]=""+i;
		  }
		  for(i=1;i<=ecount;i++){
			  box2[i]=""+i;
		  }
		  cselect.setModel(new DefaultComboBoxModel(box1));
		  eselect.setModel(new DefaultComboBoxModel(box2));
		  box1=new String[mecount+1];
		  box1[0]="slot";
		  for(i=1;i<=mecount;i++){
			  box1[i]=""+i;
		  }
		  selected=new int[ecount];
		  for(i=0;i<=ecount-1;i++){
			  selected[i]=-1;
		  }
	}

	public int stringToInt(String s){
		int n=0;
		for(int i=0;i<=s.length()-1;i++){
			n=n*10+(s.charAt(i))-48;
		}
		return n;
	}
	
	private void resetAll(){
		taken=0;
		eselect.setSelectedIndex(0);
		en.setText("");
		ec.setText("");
		ef.setText("");
		for(int i=0;i<=mecount-1;i++){
			etaken=new String[mecount][3];
			etaken[i][0]=null;
			etaken[i][1]=null;
			etaken[i][2]=null;
		}
		for(int i=0;i<=ecount-1;i++){
			selected[i]=-1;
		}
		return;
	}
	
	public void disableall(){
		save.setEnabled(false);
		remove.setEnabled(false);
		add.setEnabled(false);
		eselect.setEnabled(false);
		cselect.setEnabled(false);
		//eid.setEnabled(false);
		ok.setEnabled(false);
		return;
	}
	public boolean savedata() throws IOException{
		success=false;
		int i=0,j=0;
		for(i=0;i<=ecount-1;i++){
			if(selected[i]!=-1){
				etaken[j][0]=elist[i][0];
				etaken[j][1]=elist[i][1];
				etaken[j][2]=elist[i][2];
				j++;
			}
		}
		createEmptyFile(studentId+"_core.txt");
		createEmptyFile(studentId+"_elective.txt");
		for(i=0;i<=ccount-1;i++){
			addLine(clist[i][0]+"_list.txt",studentId);
			addLine(studentId+"_core.txt",clist[i][0]);
		}
		for(i=0;i<=j-1;i++){
			//if(etaken[i][0]!=null){
				addLine(etaken[i][0]+"_list.txt",studentId);
				addLine(studentId+"_elective.txt",etaken[i][0]);
			//}
		}
		success=true;
		createEmptyFile(studentId+"_registered.txt");
		addLine(studentId+"_registered.txt","Y");
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
	
	private void printSelected(){
		int i;
		for(i=0;i<=ecount-1;i++){
			if(selected[i]!=-1){
				log.append("\nElective 1 : "+elist[i][0]);
			}
		}
	}
}



