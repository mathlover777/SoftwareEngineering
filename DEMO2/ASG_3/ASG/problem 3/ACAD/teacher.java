import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class teacher extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton grade;
	private JButton exit;
	private JComboBox cselect;
	private JTextArea log;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	private String[] clist;
	private String name="";
	private int ccount=0;
	private String selected="";
	private JDialog t;
	
	public teacher(String ID) {
		//System.out.println("sfff");
		setResizable(false);
		setModal(true);
		setTitle("Faculty Page");
		setBounds(100, 100, 477, 362);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 77, 451, 213);
			contentPanel.add(scrollPane);
			{
				log = new JTextArea();
				log.setEditable(false);
				scrollPane.setViewportView(log);
				log.setLineWrap(true);
			}
		}
		{
			JLabel lblCoursesTaken = new JLabel("Courses Taken :");
			lblCoursesTaken.setBounds(10, 11, 112, 14);
			contentPanel.add(lblCoursesTaken);
		}
		{
			cselect = new JComboBox();
			
			//cselect.setSelectedIndex(0);
			cselect.setBounds(10, 36, 215, 20);
			contentPanel.add(cselect);
		}
		{
			grade = new JButton("Give Grades");
			grade.setBounds(113, 7, 112, 23);
			contentPanel.add(grade);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				exit = new JButton("Exit");
				buttonPane.add(exit);
			}
		}
		
		name=""+ID;
	try {
	getCourselist();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
	
	//System.out.println("sfff");
		
		
		grade.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//System.out.println("Selected="+selected);
					if(selected!=null){
						t=new Grade(selected);
						t.setVisible(true);
					}
					else{
						log.append("\n No Subject selected...");
					}
					log.append("\n Grade Given...");
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
		cselect.addItemListener(
			new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(cselect.getSelectedIndex()!=0){
						selected=""+clist[cselect.getSelectedIndex()-1];
					}
					else{
						selected=null;
					}
				}
				
			}
		);
	}
	public void getCourselist() throws IOException{
		FileInputStream fstream = new FileInputStream(name+"_courselist.txt");
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		ccount=0;
		while(strLine!=null){
			ccount++;
			strLine=br.readLine();
		}
		ccount=ccount/2;
		br.close();
		in.close();
		fstream.close();
		clist=new String[ccount];
		fstream = new FileInputStream(name+"_courselist.txt");
		in = new DataInputStream(fstream);
		strLine="";
		br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		int i=0;
		while(strLine!=null){
			clist[i]=""+strLine;
			strLine=br.readLine();
			strLine=br.readLine();
			i++;
		}
		br.close();
		in.close();
		fstream.close();
		String[] box;
		box=new String[ccount+1];
		box[0]="Select";
		for(i=1;i<=ccount;i++){
			box[i]=""+clist[i-1];
		}
		cselect.setModel(new DefaultComboBoxModel(box));
	}
}
