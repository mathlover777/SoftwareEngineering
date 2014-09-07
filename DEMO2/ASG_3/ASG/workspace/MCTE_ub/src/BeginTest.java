import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;



public class BeginTest extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea aans;
	private JTextArea bans;
	private JTextArea cans;
	private JTextArea dans;
	private JTextArea question;
	private JRadioButton a;
	private JRadioButton c;
	private JRadioButton d;
	private JRadioButton p;
	private ButtonGroup group;
	

	private String[] boxdata;
	
	/**********************Test Data***************************************/
	private int count;
	private String[] qq,aa,bb,cc,dd;
	private int[] score; 
	private char[] ans;
	private int selected=0;
	private char answer;
	private char submitted[];
	private int totalr=0;
	private int totalw=0;
	private String id="";
	private static String tname="test1.txt";
	private JRadioButton b;
	private JButton submit;
	private JTextField yn;
	private JButton finish;
	private boolean success=false;
	private JButton cancel;
	
	
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			BeginTest dialog = new BeginTest(tname,"12345");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public BeginTest(String testname,String roll) throws IOException {
		setResizable(false);
		setTitle("Test Started");
		setModal(true);
		setBounds(100, 100, 750, 555);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel q = new JLabel("Question No :");
			q.setBounds(10, 11, 95, 34);
			contentPanel.add(q);
		}
		
		final JComboBox box = new JComboBox();
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		box.setBounds(115, 18, 60, 20);
		contentPanel.add(box);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 43, 710, 98);
		contentPanel.add(scrollPane);
		{
			question = new JTextArea();
			question.setEditable(false);
			question.setLineWrap(true);
			scrollPane.setViewportView(question);
		}
		{
			JLabel lblAnswers = new JLabel("Answers :");
			lblAnswers.setBounds(10, 163, 102, 28);
			contentPanel.add(lblAnswers);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 191, 710, 164);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblA = new JLabel("A :");
				lblA.setBounds(10, 11, 46, 14);
				panel.add(lblA);
			}
			{
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(45, 11, 311, 63);
				panel.add(scrollPane_1);
				{
					aans = new JTextArea();
					aans.setLineWrap(true);
					aans.setEditable(false);
					scrollPane_1.setViewportView(aans);
				}
			}
			{
				JLabel lblB = new JLabel("B :");
				lblB.setBounds(10, 85, 46, 14);
				panel.add(lblB);
			}
			{
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(45, 85, 311, 68);
				panel.add(scrollPane_1);
				{
					bans = new JTextArea();
					bans.setBackground(Color.WHITE);
					bans.setLineWrap(true);
					bans.setEditable(false);
					scrollPane_1.setViewportView(bans);
				}
			}
			{
				JLabel lblC = new JLabel("C:");
				lblC.setBounds(366, 11, 46, 14);
				panel.add(lblC);
			}
			{
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(394, 11, 306, 63);
				panel.add(scrollPane_1);
				{
					cans = new JTextArea();
					cans.setLineWrap(true);
					cans.setEditable(false);
					scrollPane_1.setViewportView(cans);
				}
			}
			{
				JLabel lblD = new JLabel("D :");
				lblD.setBounds(366, 85, 46, 14);
				panel.add(lblD);
			}
			{
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(394, 84, 306, 69);
				panel.add(scrollPane_1);
				{
					dans = new JTextArea();
					dans.setLineWrap(true);
					dans.setEditable(false);
					scrollPane_1.setViewportView(dans);
				}
			}
		}
		{
			JLabel lblSubmit = new JLabel("Submit :");
			lblSubmit.setBounds(10, 383, 46, 14);
			contentPanel.add(lblSubmit);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 408, 710, 47);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			a = new JRadioButton("A");
			a.setMnemonic('a');
			a.setBounds(6, 19, 53, 23);
			panel.add(a);
			
			b = new JRadioButton("B");
			b.setMnemonic('b');
			b.setBounds(63, 19, 53, 23);
			panel.add(b);
			{
				c = new JRadioButton("C");
				c.setMnemonic('c');
				c.setBounds(118, 19, 53, 23);
				panel.add(c);
			}
			{
				d = new JRadioButton("D");
				d.setMnemonic('d');
				d.setBounds(173, 19, 53, 23);
				panel.add(d);
			}
			{
				p = new JRadioButton("Pass");
				p.setMnemonic('p');
				p.setBounds(228, 19, 78, 23);
				panel.add(p);
			}
			
			submit = new JButton("Submit");
			submit.setBounds(611, 19, 89, 23);
			panel.add(submit);
			
			JLabel lblNoteAnswers = new JLabel("Note : Answers can be resubmitted");
			lblNoteAnswers.setBounds(312, 23, 286, 30);
			panel.add(lblNoteAnswers);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 370, 710, 2);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 152, 710, 203);
		contentPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 464, 710, 2);
		contentPanel.add(separator_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				finish = new JButton("Finish");
				finish.setActionCommand("OK");
				buttonPane.add(finish);
				getRootPane().setDefaultButton(finish);
			}
			{
				cancel = new JButton("Cancel");
				cancel.setActionCommand("Cancel");
				buttonPane.add(cancel);
			}
		}
		{
			JLabel lblAttempted = new JLabel("Submitted : ");
			lblAttempted.setBounds(240, 21, 95, 14);
			contentPanel.add(lblAttempted);
		}
		{
			yn = new JTextField();
			yn.setBounds(327, 18, 86, 20);
			contentPanel.add(yn);
			yn.setColumns(10);
		}
		group=new ButtonGroup();
		group.add(a);
		group.add(b);
		group.add(c);
		group.add(d);
		group.add(p);
		/*****************Initialisation Test data****************************/
		//URL s=Start.class.getResource(testname);
		FileInputStream f;
		f=new FileInputStream(testname);
		DataInputStream in = new DataInputStream(f);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		id=""+roll;
		strLine=br.readLine();
		tname=""+testname;
		//System.out.println (strLine);
		/*************getting # of questions***********/
		count=0;
		for(int i=0;i<=strLine.length()-1;i++){
		  count=count*10+strLine.charAt(i)-48;
		}
		 
		  
		qq=new String[count];
		aa=new String[count];
		bb=new String[count];
		cc=new String[count];
		dd=new String[count];
		score=new int[count];
		ans=new char[count];
		submitted=new char[count];
		boxdata=new String[count];  
		for(int i=0;i<=count-1;i++){
			qq[i]=br.readLine();
			aa[i]=br.readLine();
			bb[i]=br.readLine();
			cc[i]=br.readLine();
			dd[i]=br.readLine();
			ans[i]=br.readLine().charAt(0);
			//System.out.printf("\nq=%s\na=%s\nb=%s\nc=%s\nd=%s\nans=%c",qq[i],aa[i],bb[i],cc[i],dd[i],ans[i]);
			boxdata[i]=""+(i+1);
			score[i]=0;//0 denotes pass(unattempted)....1=correct...-1==incorrect
			submitted[i]='P';//by default all answers are taken as Pass
		}
		box.setModel(new DefaultComboBoxModel(boxdata));	  
		
		
		/*******************Data Extracted from file*************************/
		
		
		/****************default question*****************************/
		question.setText(qq[0]);
		aans.setText(aa[0]);
		bans.setText(bb[0]);
		cans.setText(cc[0]);
		dans.setText(dd[0]);
		p.setSelected(true);
		
		yn.setText("Not Yet !!");
		
		/*************selecting question*********************/
		box.addItemListener(
			new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					selected=box.getSelectedIndex();
					question.setText(qq[selected]);
					aans.setText(aa[selected]);
					bans.setText(bb[selected]);
					cans.setText(cc[selected]);
					dans.setText(dd[selected]);
					switch(submitted[selected]){
					case 'A':{
						a.setSelected(true);
						yn.setText("A");
						break;
					}
					case 'B':{
						b.setSelected(true);
						yn.setText("B");
						break;
					}
					case 'C':{
						c.setSelected(true);
						yn.setText("C");
						break;
					}
					case 'D':{
						d.setSelected(true);
						yn.setText("D");
						break;
					}
					case 'P':{
						p.setSelected(true);
						yn.setText("Not Yet!!");
						break;
					}
					}
				}
			}
		);
		
		submit.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					answer=(char) (group.getSelection()).getMnemonic();
					//System.out.println(answer);
					submitted[selected]=answer;
					if(answer=='P'){
						yn.setText("Passed");
					}
					else{
						yn.setText(""+answer);
					}
				}
				
			}
		);
		
		finish.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					success=true;
					for(int i=0;i<=count-1;i++){
						if(submitted[i]=='P'){
							score[i]=0;
						}
						else{
							if(submitted[i]==ans[i]){
								score[i]=1;
							}
							else{
								score[i]=-1;
							}
						}
					}
					totalr=0;
					totalw=0;
					for(int i=0;i<=count-1;i++){
						if(score[i]==1) totalr++;
						if(score[i]==-1) totalw++;
					}
					try {
						saveresponse();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
	
	public void saveresponse() throws IOException{
		String onlyname="";
		int j=0;
		while(tname.charAt(j)!='.'){
			onlyname=onlyname+tname.charAt(j);
			j++;
		}
		String filename=onlyname+"_"+id+".txt";
		try{
			  // Create file 
			  FileWriter fstream = new FileWriter(filename);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(""+score[0]);
			  for(int i=1;i<=count-1;i++){
				  out.write("\r\n"+score[i]);
			  }
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  //System.err.println("Error: " + e.getMessage());
			  }
		filename=onlyname+"_log.txt";
		System.out.println("\nfilename="+filename);
		addLine(filename,id);
		addLine(filename,""+totalr);
		addLine(filename,""+totalw);
	}
	
	
	
	/*****************tested************************************/
	public void copyToFile(String file1,String file2) throws IOException{
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
	
	
	/*********************tested*************************/
	public void addLine(String file,String line) throws IOException{
		FileInputStream f1=new FileInputStream(file);
		FileWriter f2=new FileWriter("tempa.txt");
		BufferedWriter out = new BufferedWriter(f2);
		int i;
		i=f1.read();
		while(i!=-1){
			out.write((char)i);
			i=f1.read();
		}
		out.write("\r\n"+line);
		out.close();
		f1.close();
		copyToFile("tempa.txt",file);
	}
	
	
	/***************************Get methods**************************/
	public boolean isSuccess(){
		return success;
	}
	public int getCorrect(){
		return totalr;
	}
	public int getIncorrect(){
		return totalw;
	}
	public int getCount(){
		return count;
	}
}
