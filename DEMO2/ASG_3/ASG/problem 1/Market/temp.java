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
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;


public class temp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton reset;
	private JButton compare;
	private JButton view;
	private JButton exit;
	private JTextArea log;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	
	private String[] list;
	private String[] top;
	private int[] id,selltop,selllist;
	private int ccount=0,totalsale=0;
	
	private JDialog t;
	private JButton add;
	
	
	
	public temp() {
		setTitle("Manager");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(10, 11, 424, 132);
			contentPanel.add(scrollPane);
			
			log = new JTextArea();
			log.setEditable(false);
			scrollPane.setViewportView(log);
		}
		
		compare = new JButton("Compare");
		compare.setBounds(10, 154, 149, 35);
		contentPanel.add(compare);
		
		reset = new JButton("Reset & Generarte Prize List");
		reset.setBounds(169, 154, 265, 35);
		contentPanel.add(reset);
		
		view = new JButton("View Prize list");
		view.setBounds(10, 191, 149, 37);
		contentPanel.add(view);
		
		add = new JButton("Add Customer Data from File");
		add.setBounds(169, 191, 265, 37);
		contentPanel.add(add);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				exit = new JButton("Exit");
				exit.setActionCommand("Cancel");
				buttonPane.add(exit);
			}
		}
		
		
		reset.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						update();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		);
		
		compare.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						t=new Compare();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t.setVisible(true);
				}
				
			}
		);
		
		view.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					t=new award();
					t.setVisible(true);
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
	
	
	public void update() throws IOException{
		int topcount=0;
		FileInputStream fstream = new FileInputStream("clist.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		ccount=0;
		while(strLine!=null){
			ccount++;
			strLine=br.readLine();
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		
		list=new String[ccount];
		id=new int[ccount];
		selllist=new int[ccount];
		
		
		fstream = new FileInputStream("clist.txt");
		// Get the object of DataInputStream
		in = new DataInputStream(fstream);
		strLine="";
		br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		int i=0;
		while(strLine!=null){
			list[i]=""+strLine;
			strLine=br.readLine();
			selllist[i]=stringToInt(strLine);
			strLine=br.readLine();
			i++;
		}
		br.close();
		in.close();
		fstream.close();
		for(i=0;i<=ccount-1;i++){
			id[i]=i;
		}
		
		createEmptyFile("baselist.txt");
		totalsale=0;
		for(i=0;i<=ccount-1;i++){
			totalsale=totalsale+selllist[i];
			if(selllist[i]>10000){
				addLine("baselist.txt",list[i]);
				addLine("baselist.txt",""+selllist[i]);
			}
		}
		if(ccount>10){
			topcount=10;
		}else{
			topcount=ccount;
		}
		bubbleSort();
		createEmptyFile("top10.txt");
		for(i=0;i<=topcount-1;i++){
			addLine("top10.txt",list[id[i]]);
			addLine("top10.txt",""+selllist[id[i]]);
		}
		
		fstream = new FileInputStream("yearsale.txt");
		// Get the object of DataInputStream
		in = new DataInputStream(fstream);
		strLine="";
		br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		br.close();
		in.close();
		fstream.close();
		
		createEmptyFile("lastyearsale.txt");
		addLine("lastyearsale.txt",strLine);
		createEmptyFile("yearsale.txt");
		addLine("yearsale.txt",""+totalsale);
		
		
		
		
		createEmptyFile("clist.txt");
		for(i=0;i<=ccount-1;i++){
			addLine("clist.txt",list[i]);
			addLine("clist.txt",""+0);
		}
		
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
	
	public void bubbleSort(){
		int i=0,j=0,t;
		for(i=0;i<=ccount-1;i++){
			for(j=0;j<ccount-i-1;j++){
				if(selllist[id[j]]<selllist[id[j+1]]){
					t=id[j];
					id[j]=id[j+1];
					id[j+1]=t;
				}
			}
		}
		return;
	}
}
