import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Stats extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField testname;
	private JTextField scount;
	private JTextField fm;
	private JTextArea log;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			Stats dialog = new Stats();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	
	/***********************************************/
	private String filename="";
	private String logname="";
	private JButton ok;
	
	
	
	
	/**
	 * Create the dialog.
	 */
	public Stats() {
		setTitle("Result ");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 601, 462);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEnterNameOf = new JLabel("Enter Name of Test :");
			lblEnterNameOf.setBounds(10, 11, 162, 30);
			contentPanel.add(lblEnterNameOf);
		}
		{
			testname = new JTextField();
			testname.setBounds(182, 16, 252, 20);
			contentPanel.add(testname);
			testname.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 39, 571, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblstudentsAppeared = new JLabel("#Students Appeared :");
			lblstudentsAppeared.setBounds(10, 54, 116, 30);
			contentPanel.add(lblstudentsAppeared);
		}
		{
			scount = new JTextField();
			scount.setBackground(Color.WHITE);
			scount.setEditable(false);
			scount.setBounds(136, 59, 86, 20);
			contentPanel.add(scount);
			scount.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 95, 571, 2);
			contentPanel.add(separator);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 136, 571, 254);
			contentPanel.add(scrollPane);
			{
				log = new JTextArea();
				log.setEditable(false);
				scrollPane.setViewportView(log);
			}
		}
		{
			JLabel lblData = new JLabel("Data :");
			lblData.setBounds(10, 111, 104, 14);
			contentPanel.add(lblData);
		}
		{
			JLabel lblFullMarks = new JLabel("Full Marks :");
			lblFullMarks.setBounds(251, 62, 91, 14);
			contentPanel.add(lblFullMarks);
		}
		{
			fm = new JTextField();
			fm.setBackground(Color.WHITE);
			fm.setEditable(false);
			fm.setBounds(348, 59, 86, 20);
			contentPanel.add(fm);
			fm.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				ok = new JButton("OK");
				ok.setActionCommand("OK");
				buttonPane.add(ok);
				getRootPane().setDefaultButton(ok);
			}
		}
		
		
		/*************************events*********************************/
		testname.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					filename=testname.getText();
					log.setText("");
					try {
						dispLogData();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		);
		
		ok.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						dispose();
					}
					
				}
			);
	}
	
	
	public void dispLogData() throws IOException{
		String onlyname="";
		String id="";
		String c="",i="";
		String logline="";
		int j=0,count=0,p=0;
		while(filename.charAt(j)!='.'){
			onlyname=onlyname+filename.charAt(j);
			j++;
		}
		String logname=onlyname+"_log.txt";
		
		
		
		/************************/
		 FileInputStream fstream = new FileInputStream(logname);
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  String strLine="";
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  strLine = br.readLine();
		  fm.setText(strLine);
		  while(true){
			  strLine=br.readLine();
			  if(strLine==null){
				  break;
			  }
			  count++;
			  id=""+strLine;
			  c=br.readLine();
			  i=br.readLine();
			  
			  p=stringToInt(fm.getText())-stringToInt(c)-stringToInt(i);
			  logline="\n"+count+". "+id+" Correct = "+c+" Wrong = "+i+" Passed = "+p;
			  log.append(logline);
		  }
		  scount.setText(""+count);
		  
	}
	
	public int stringToInt(String s){
		int n=0;
		for(int i=0;i<=s.length()-1;i++){
			n=n*10+(s.charAt(i))-48;
		}
		return n;
	}

}
