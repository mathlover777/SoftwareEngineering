import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.JDialog;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;


public class start extends JFrame {

	private JPanel contentPane;
	private JButton purchase;
	private JButton register;
	private JButton manager;
	private JButton exit;
	private JButton developer;
	private JDialog t;
	private JTextArea log;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start frame = new start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public start() {
		
		
		
		UIManager.put("Label.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));
		 UIManager.put("Button.font", new FontUIResource(new Font("Dialog", Font.BOLD, 10)));
		 UIManager.put("TextField.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));
		 UIManager.put("RadioButton.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));
		
		setTitle("Automated SuperMarket Manager 0.1");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 414, 118);
		contentPane.add(scrollPane);
		
		log = new JTextArea();
		log.setEditable(false);
		log.setText("WELCOME TO SS Automated SuperMarket Manager 0.1\r\n");
		log.setLineWrap(true);
		scrollPane.setViewportView(log);
		
		purchase = new JButton("Purchase");
		purchase.setBounds(10, 140, 194, 38);
		contentPane.add(purchase);
		
		register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		register.setBounds(10, 186, 194, 38);
		contentPane.add(register);
		
		manager = new JButton("Manager");
		manager.setBounds(225, 140, 199, 38);
		contentPane.add(manager);
		
		exit = new JButton("EXIT");
		exit.setBounds(225, 188, 199, 36);
		contentPane.add(exit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 231, 412, 2);
		contentPane.add(separator);
		
		developer = new JButton("DeveLoper");
		developer.setBounds(10, 244, 133, 23);
		contentPane.add(developer);
		
		
		
		
		exit.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			}
		);
		
		manager.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t=new logIn();
						t.setVisible(true);
						if(((logIn)t).isSuccess()){
							t=new manager();
							t.setVisible(true);
						}else{
							log.append("\nAuthentication Failed...try again !!");
						}
					}
					
				}
			);
		
		purchase.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t=new purchase();
						t.setVisible(true);
					}
				}
			);
		
		register.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t=new register();
						t.setVisible(true);
					}
					
				}
			);
		developer.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t=new AboutMe();
						t.setVisible(true);
					}
					
				}
			);
	}
}
