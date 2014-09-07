import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;


public class students extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton viewgrade;
	private JButton freg;
	private JButton semreg;
	private JTextArea log;
	private JButton exit;
	
	private JDialog d;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public students() {
		setTitle("Students");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 469, 298);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 92, 433, 124);
			contentPanel.add(scrollPane);
			{
				log = new JTextArea();
				log.setLineWrap(true);
				scrollPane.setViewportView(log);
			}
		}
		{
			freg = new JButton("Fresh Register");
			freg.setBounds(10, 11, 186, 37);
			contentPanel.add(freg);
		}
		{
			semreg = new JButton("Sem Register");
			semreg.setBounds(10, 58, 186, 23);
			contentPanel.add(semreg);
		}
		{
			viewgrade = new JButton("View Gradesheet");
			viewgrade.setBounds(235, 11, 208, 70);
			contentPanel.add(viewgrade);
		}
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
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			}
		);
		freg.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					d=new sReg();
					d.setVisible(true);
				}
				
			}
		);
		viewgrade.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					d=new logIn(2);
					d.setVisible(true);
					if(((logIn)d).isSuccess()){
						//System.out.println("logged in as "+((logIn)d).getUsername());
						log.append("\nLogin Success Full !!");
						d=new gradeList(((logIn)d).getUsername());
						
						d.setVisible(true);
						log.append("\nLog out SuccessFull !!");
					}
					else{
						log.append("\nlogginn error !!");
					}
				}
				
			}
		);
		semreg.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						d=new logIn(2);
						d.setVisible(true);
						if(((logIn)d).isSuccess()){
							try {
								if(!isAlreadyRegistered(((logIn)d).getUsername())){
									d=new semReg(((logIn)d).getUsername());
									d.setVisible(true);
								}
								else{
									log.append("\nStudent already registered for the current sem !!");
								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								//e1.printStackTrace();
								log.append("\nNo Semester is Set up yet...");
							}
						}
						else{
							log.append("\nLoggin Error !!");
						}
					}
					
				}
			);
		
	}
	private boolean isAlreadyRegistered(String username) throws IOException{
		FileInputStream fstream = new FileInputStream(username+"_registered.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  String strLine="";
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  strLine=br.readLine();
		  boolean result;
		  if(strLine.equals("Y")) result=true;
		  else result=false;
		  br.close();
		  in.close();
		  fstream.close();
		  return result;
	}

}
