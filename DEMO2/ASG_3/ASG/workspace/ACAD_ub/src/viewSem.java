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


public class viewSem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField cn;
	private JTextField cc;
	private JTextField cf;
	private JComboBox cselect;
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
	private int cselected,eselected;
	private String[] box1,box2;
	private JTextField en;
	private JTextField ec;
	private JTextField ef;
	private JComboBox eselect;
	private JTextField me;
	/****************************************************************/
	
	
	public viewSem() {
		setResizable(false);
		setModal(true);
		setTitle("Semester details");
		setBounds(100, 100, 521, 406);
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
			cselect.setBounds(10, 89, 150, 20);
			cselect.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
			contentPanel.add(cselect);
		}
		{
			JLabel lblNewLabel = new JLabel("Course Name :");
			lblNewLabel.setBounds(195, 64, 105, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblCredits = new JLabel("Credits :");
			lblCredits.setBounds(195, 89, 105, 14);
			contentPanel.add(lblCredits);
		}
		{
			JLabel lblFaculty = new JLabel("Faculty :");
			lblFaculty.setBounds(195, 114, 105, 14);
			contentPanel.add(lblFaculty);
		}
		{
			cn = new JTextField();
			cn.setBounds(310, 61, 168, 20);
			cn.setBackground(Color.WHITE);
			cn.setEditable(false);
			contentPanel.add(cn);
			cn.setColumns(10);
		}
		{
			cc = new JTextField();
			cc.setBounds(310, 86, 168, 20);
			cc.setBackground(Color.WHITE);
			cc.setEditable(false);
			contentPanel.add(cc);
			cc.setColumns(10);
		}
		{
			cf = new JTextField();
			cf.setBounds(310, 111, 168, 20);
			cf.setBackground(Color.WHITE);
			cf.setEditable(false);
			contentPanel.add(cf);
			cf.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 148, 494, 2);
			contentPanel.add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 49, 494, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblElectiveCourses = new JLabel("Elective Courses :");
			lblElectiveCourses.setBounds(10, 161, 150, 14);
			contentPanel.add(lblElectiveCourses);
		}
		{
			JLabel label = new JLabel("Select Course To View Details :");
			label.setBounds(10, 199, 186, 14);
			contentPanel.add(label);
		}
		{
			eselect = new JComboBox();
			eselect.setBounds(10, 224, 150, 20);
			contentPanel.add(eselect);
		}
		{
			JLabel label = new JLabel("Course Name :");
			label.setBounds(195, 199, 105, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Credits :");
			label.setBounds(195, 224, 105, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Faculty :");
			label.setBounds(195, 249, 105, 14);
			contentPanel.add(label);
		}
		{
			en = new JTextField();
			en.setEditable(false);
			en.setColumns(10);
			en.setBackground(Color.WHITE);
			en.setBounds(310, 196, 168, 20);
			contentPanel.add(en);
		}
		{
			ec = new JTextField();
			ec.setEditable(false);
			ec.setColumns(10);
			ec.setBackground(Color.WHITE);
			ec.setBounds(310, 221, 168, 20);
			contentPanel.add(ec);
		}
		{
			ef = new JTextField();
			ef.setEditable(false);
			ef.setColumns(10);
			ef.setBackground(Color.WHITE);
			ef.setBounds(310, 246, 168, 20);
			contentPanel.add(ef);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 332, 494, 2);
			contentPanel.add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 184, 494, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblMaximumElectivesTaken = new JLabel("Maximum Electives taken :");
			lblMaximumElectivesTaken.setBounds(10, 307, 186, 14);
			contentPanel.add(lblMaximumElectivesTaken);
		}
		{
			me = new JTextField();
			me.setBounds(195, 301, 86, 20);
			contentPanel.add(me);
			me.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		}
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
						}
						else{
							en.setText(elist[eselected-1][0]);
							ec.setText(elist[eselected-1][1]);
							ef.setText(elist[eselected-1][2]);
						}
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
		
	}
	
	
	private void getData() throws IOException{
		FileInputStream fstream = new FileInputStream("clist.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  String strLine="";
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  strLine=br.readLine();
		  if(strLine==null){
			  return;
		  }
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
	}
	public int stringToInt(String s){
		int n=0;
		for(int i=0;i<=s.length()-1;i++){
			n=n*10+(s.charAt(i))-48;
		}
		return n;
	}
}



