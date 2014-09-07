import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;


public class award extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea tlog;
	private JTextArea blog;
	private JTextArea log;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public award() {
		setResizable(false);
		setTitle("Award List");
		setModal(true);
		setBounds(100, 100, 757, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(10, 11, 262, 347);
			contentPanel.add(scrollPane);
			{
				JLabel lblHighestBuyers = new JLabel("Highest Buyers :");
				scrollPane.setColumnHeaderView(lblHighestBuyers);
			}
			{
				tlog = new JTextArea();
				tlog.setEditable(false);
				tlog.setLineWrap(true);
				scrollPane.setViewportView(tlog);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(282, 11, 262, 347);
			contentPanel.add(scrollPane);
			{
				JLabel lblBuyersWithPurchase = new JLabel("Buyers With Purchase  >= 10000 :");
				scrollPane.setColumnHeaderView(lblBuyersWithPurchase);
			}
			{
				blog = new JTextArea();
				scrollPane.setViewportView(blog);
				blog.setLineWrap(true);
				blog.setEditable(false);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(554, 11, 177, 348);
			contentPanel.add(scrollPane);
			{
				log = new JTextArea();
				scrollPane.setViewportView(log);
			}
			{
				JLabel lblInfo = new JLabel("Info :");
				scrollPane.setColumnHeaderView(lblInfo);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		try {
			displayLists();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void displayLists() throws IOException{
		FileInputStream fstream = new FileInputStream("top10.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		String ucn="",name="";
		
		FileInputStream f;
		// Get the object of DataInputStream
		DataInputStream i; 
		BufferedReader b; 
		int j=0;
		while(strLine!=null){
			ucn=""+strLine;
			strLine=br.readLine();
			f= new FileInputStream("details_"+ucn+".txt");
			i= new DataInputStream(f);
			b= new BufferedReader(new InputStreamReader(i));
			name=b.readLine();
			b.close();
			i.close();
			f.close();
			tlog.append("\n"+(j+1)+": UCN = "+ucn+" :");
			tlog.append("\nName = "+name);
			tlog.append("\npurchase = "+strLine+"\n");
			strLine=br.readLine();
			j++;
		}
		br.close();
		in.close();
		fstream.close();
		
		
		fstream= new FileInputStream("baselist.txt");
		in= new DataInputStream(fstream);
		br= new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		j=0;
		while(strLine!=null){
			ucn=""+strLine;
			strLine=br.readLine();
			f= new FileInputStream("details_"+ucn+".txt");
			i= new DataInputStream(f);
			b= new BufferedReader(new InputStreamReader(i));
			name=b.readLine();
			b.close();
			i.close();
			f.close();
			blog.append("\n"+(j+1)+": UCN= "+ucn+" :");
			blog.append("\nName = "+name);
			blog.append("\npurchase = "+strLine+"\n");
			strLine=br.readLine();
			j++;
		}
	}
	
	public int stringToInt(String s){
		int n=0;
		for(int i=0;i<=s.length()-1;i++){
			n=n*10+(s.charAt(i))-48;
		}
		return n;
	}

}
