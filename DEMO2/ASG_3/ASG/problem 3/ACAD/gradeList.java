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
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class gradeList extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ID;
	private JTextField CGPA;
	private JTextField ACGPA;
	private JTextField GPA;
	private JTextField AGPA;
	private JTextArea clog;
	private JTextArea elog;

	/**
	 * Launch the application.
	 */
	


	/**
	 * Create the dialog.
	 */
	
	
	private String id="";
	
	
	int ccleared=0,ecleared=0,c=0,e=0;
	private JTextArea log;
	
	public gradeList(String roll){
		setTitle("Grade List:");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 590, 465);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(10, 14, 46, 14);
		contentPanel.add(lblId);
		
		ID = new JTextField();
		ID.setBackground(Color.WHITE);
		ID.setEditable(false);
		ID.setBounds(66, 11, 216, 20);
		contentPanel.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewCgpa = new JLabel("CGPA :");
		lblNewCgpa.setBounds(145, 66, 77, 14);
		contentPanel.add(lblNewCgpa);
		
		CGPA = new JTextField();
		CGPA.setBackground(Color.WHITE);
		CGPA.setEditable(false);
		CGPA.setBounds(213, 63, 69, 20);
		contentPanel.add(CGPA);
		CGPA.setColumns(10);
		
		JLabel lblNewAcgpa = new JLabel("ACGPA :");
		lblNewAcgpa.setBounds(145, 100, 58, 14);
		contentPanel.add(lblNewAcgpa);
		
		ACGPA = new JTextField();
		ACGPA.setBackground(Color.WHITE);
		ACGPA.setEditable(false);
		ACGPA.setBounds(213, 97, 69, 20);
		contentPanel.add(ACGPA);
		ACGPA.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 278, 2);
		contentPanel.add(separator);
		
		JLabel lblGpa = new JLabel("GPA :");
		lblGpa.setBounds(10, 69, 46, 14);
		contentPanel.add(lblGpa);
		
		JLabel lblAgpa = new JLabel("AGPA :");
		lblAgpa.setBounds(10, 100, 46, 14);
		contentPanel.add(lblAgpa);
		
		GPA = new JTextField();
		GPA.setBackground(Color.WHITE);
		GPA.setEditable(false);
		GPA.setBounds(66, 63, 69, 20);
		contentPanel.add(GPA);
		GPA.setColumns(10);
		
		AGPA = new JTextField();
		AGPA.setBackground(Color.WHITE);
		AGPA.setEditable(false);
		AGPA.setBounds(66, 97, 69, 20);
		contentPanel.add(AGPA);
		AGPA.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 129, 565, 2);
		contentPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 393, 565, 2);
		contentPanel.add(separator_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 142, 263, 236);
		contentPanel.add(scrollPane);
		
		JLabel lblCore = new JLabel("CORE");
		scrollPane.setColumnHeaderView(lblCore);
		
		clog = new JTextArea();
		scrollPane.setViewportView(clog);
		clog.setEditable(false);
		clog.setLineWrap(true);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(312, 142, 263, 236);
		contentPanel.add(scrollPane_1);
		
		JLabel lblElective = new JLabel("Elective");
		scrollPane_1.setColumnHeaderView(lblElective);
		
		elog = new JTextArea();
		elog.setEditable(false);
		scrollPane_1.setViewportView(elog);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(311, 14, 264, 106);
		contentPanel.add(scrollPane_2);
		
		JLabel Messages = new JLabel("      Messages :");
		scrollPane_2.setColumnHeaderView(Messages);
		
		log = new JTextArea();
		log.setEditable(false);
		scrollPane_2.setViewportView(log);
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
		
		
		exit.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			}
		);
		
		
		//System.out.println("GRADE LIST");
		id=""+roll;
		try {
			showGrade();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("returned in cons");
		return;
		
	}
	
	
	
	
	
	private int i=0;
	private JButton exit;
	
	
	
	public void showGrade() throws IOException{
		//System.out.println("i="+i);
		i++;
		FileInputStream fstream = new FileInputStream("CGPA.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		//System.out.println("visibility : "+strLine);
		br.close();
		in.close();
		fstream.close();
		if(strLine.equals("Y")){
			log.append("\nDEAN has generated the grade list :(");
			//System.out.println("\nDEAN has generated the grade list :(");
			showData();
			//System.out.println("Grade Data found !!");
			//.out.println("returning to cons !!");
		}else{
			log.append("\nGrade's are not Visible Yet !!!\n\nso have fun");
			//System.out.println("\nGrade's are not Visible Yet !!!\n\nso have fun");
		}
		return;
	}
	
	
	public void showData() {
		//System.out.println("\nshow is called !!\n");
		makeGradeList m = null;
			try {
				m=new makeGradeList(id);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		clog.append(m.getCgradeText());
		elog.append(m.getEgradeText());
		GPA.setText(doubleToString(""+m.getGpa()));
		AGPA.setText(doubleToString(""+m.getAgpa()));
		FileInputStream fstream = null;

			try {
				fstream = new FileInputStream("cgpa_list.txt");
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		try {
			strLine=br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(strLine!=null){
			//System.out.println("trapped !!!");
			if(strLine.equals(id)){
				try {
					//System.out.println("volya");
					CGPA.setText(doubleToString(br.readLine()));
					br.readLine();
					ACGPA.setText(doubleToString(br.readLine()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			else{
				try {
					br.readLine();
					br.readLine();
					br.readLine();
					br.readLine();
					strLine=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//System.out.println("trapped !!!");
		}
		try {
			br.close();
			in.close();
			fstream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("broken");
		//System.out.println("bsdsdroken");
		return;
	}
	
	private String doubleToString(String s){
		String r="";
		int flag=0,k=3;
		for(int i=0;i<=s.length()-1;i++){
			if(s.charAt(i)=='.'){
				flag=1;
			}
			r=r+s.charAt(i);
			if(flag==1){
				k--;
			}
			if(k==0){
				break;
			}
		}
		return r;
	}
}
