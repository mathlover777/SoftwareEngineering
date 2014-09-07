import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;


public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	/**********************/
	private JDialog d;
	private String username="";
	private String hash="";
	private JScrollPane scrollPane;
	private JTextArea log;
	private JButton dean;
	private JButton about;
	private JButton facad;
	private JButton faculty;
	private JButton students;

	/**
	 * Create the frame.
	 */
	public Start() {
		setResizable(false);
		UIManager.put("Label.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));
		 UIManager.put("Button.font", new FontUIResource(new Font("Dialog", Font.BOLD, 10)));
		 UIManager.put("TextField.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));
		 UIManager.put("RadioButton.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));
		setTitle("Automated Course Manager 0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 507, 92);
		contentPane.add(scrollPane);
		
		log = new JTextArea();
		log.setLineWrap(true);
		log.setEditable(false);
		log.setText("WelCome To SS Automated Course Management System\r\n\r\nVer 0.1\r\n");
		scrollPane.setViewportView(log);
		
		dean = new JButton("Dean");
		dean.setBounds(131, 127, 89, 23);
		contentPane.add(dean);
		
		facad = new JButton("Fac Ad");
		facad.setBounds(230, 127, 89, 23);
		contentPane.add(facad);
		
		faculty = new JButton("Faculty");
		faculty.setBounds(329, 127, 89, 23);
		contentPane.add(faculty);
		
		students = new JButton("Students");
		students.setBounds(428, 127, 89, 23);
		contentPane.add(students);
		
		about = new JButton("Developer");
		about.setBounds(10, 189, 151, 23);
		contentPane.add(about);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 164, 507, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 113, 507, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 225, 507, 2);
		contentPane.add(separator_2);
		
		dean.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					d=new logIn(0);
					d.setVisible(true);
					if(((logIn)d).isSuccess()){
						d=new Dean();
						d.setVisible(true);
					}
				}
				
			}
		);
		facad.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						d=new logIn(1);
						d.setVisible(true);
						if(((logIn)d).isSuccess()){
							d=new Fac();
							d.setVisible(true);
						}
					}
					
				}
			);
		faculty.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						d=new logIn(3);
						d.setVisible(true);
						if(((logIn)d).isSuccess()){
							log.append("\nLogged in !!");
							username=((logIn)d).getUsername();
							d=new teacher(username);
							d.setVisible(true);
						}
						else{
							log.append("\nLogin was unsuccessful !!");
						}
					}
					
				}
			);
		students.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						//d=new logIn(2);
						//d.setVisible(true);
						//if(((logIn)d).isSuccess()){
							//username=((logIn)d).getUsername();
							d=new students();
							d.setVisible(true);
						//}
					}
					
				}
			);
		about.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						d=new AboutMe();
						d.setVisible(true);
					}
					
				}
			);
	}
}
