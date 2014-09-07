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
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class IndStat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField testname;
	private JTextField roll;
	private JTextField fm;
	private JTextArea log;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			IndStat dialog = new IndStat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	
	public String filename="",logname="",id="",slog="";
	private JButton ok;
	private JButton display;
	
	public IndStat() {
		setResizable(false);
		setModal(true);
		setTitle("See Student Performance");
		setBounds(100, 100, 522, 479);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEnterTestName = new JLabel("Enter Test Name :");
			lblEnterTestName.setBounds(10, 11, 104, 22);
			contentPanel.add(lblEnterTestName);
		}
		{
			testname = new JTextField();
			testname.setBounds(188, 11, 221, 22);
			contentPanel.add(testname);
			testname.setColumns(10);
		}
		{
			JLabel lblEnterStudentRoll = new JLabel("Enter Student Roll Number :");
			lblEnterStudentRoll.setBounds(10, 44, 152, 22);
			contentPanel.add(lblEnterStudentRoll);
		}
		{
			roll = new JTextField();
			roll.setBounds(188, 44, 221, 22);
			contentPanel.add(roll);
			roll.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 77, 496, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblFullMarks = new JLabel("Full Marks :");
			lblFullMarks.setBounds(10, 90, 104, 22);
			contentPanel.add(lblFullMarks);
		}
		{
			fm = new JTextField();
			fm.setBackground(Color.WHITE);
			fm.setEditable(false);
			fm.setBounds(104, 91, 86, 20);
			contentPanel.add(fm);
			fm.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 123, 496, 2);
			contentPanel.add(separator);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 136, 496, 271);
			contentPanel.add(scrollPane);
			{
				log = new JTextArea();
				log.setEditable(false);
				scrollPane.setViewportView(log);
			}
		}
		
		display = new JButton("Display");
		display.setBounds(419, 11, 89, 23);
		contentPanel.add(display);
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
		
		
		/*****************************events************************************/
		testname.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					filename=testname.getText();
					testname.setText("");
				}
				
			}
		);
		roll.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						id=roll.getText();
						roll.setText("");
					}
					
				}
			);
		display.addActionListener(
				new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						id=roll.getText();
						filename=testname.getText();
						try {
							showData();
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
	public void showData() throws IOException{
		
		log.setText("");
		String onlyname="";
		int found=0;
		int j=0;
		while(filename.charAt(j)!='.'){
			onlyname=onlyname+filename.charAt(j);
			j++;
		}
		logname=onlyname+"_log.txt";
		
		//System.out.println("\nlog name="+logname);
		
		FileInputStream f;
		f=new FileInputStream(logname);
		DataInputStream in = new DataInputStream(f);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		fm.setText(strLine);
		strLine=br.readLine();
		while(strLine!=null){
			if(strLine.equals(id)){
				found=1;
				break;
			}
			strLine=br.readLine();
			strLine=br.readLine();
			strLine=br.readLine();
		}
		br.close();
		f.close();
		if(found==0){
			log.setText("\n"+id+" has not taken the test called "+filename);
			return;
		}
		slog=onlyname+"_"+id+".txt";
		
		f=new FileInputStream(slog);
		in = new DataInputStream(f);
		br = new BufferedReader(new InputStreamReader(in));
		int correct=0,incorrect=0,p=0,n=1;
		strLine=br.readLine();
		while(strLine!=null){
			log.append("\nResponse for q. "+n+" : ");
			if(strLine.equals("1")){
				correct++;
				log.append("CORRECT !!");
			}
			if(strLine.equals("-1")){
				incorrect++;
				log.append("Incorrect !!");
			}
			if(strLine.equals("0")){
				p++;
				log.append("unattempted");
			}
			n++;
			strLine=br.readLine();
		}
		log.append("\n\nTotal correct : "+correct+" Incorrect : "+incorrect+" Unattempted : "+p);
		return;
		
	}
}
