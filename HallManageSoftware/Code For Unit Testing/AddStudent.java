package code;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import com.itextpdf.awt.geom.misc.RenderingHints;


public class AddStudent extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 338395080513029631L;
	private JPanel contentPane;
	private JTextField Name;
	private JTextField source;
	private JTextField Contact;
	private JTextField Email;
	private JPasswordField Pass;
	private JPasswordField Cpass;
	private JTextField Id;
	private JButton changeimage;
	private JButton exit;
	private JTextArea Address;

	
	
	final JFileChooser fc = new JFileChooser();
	private ImageIcon ii;
	
	
	
	
	/*************Extra Data*****************************/
	private String imagePath="",id="";
	private String pass="",cPass="",email="",address="",contact="",name="";
	private boolean imageChanged=false;
	private Bridge bridge;
	/**
	 * Create the frame.
	 */
	
	public static void main(String[] args) {
		try {
			AddStudent dialog = new AddStudent();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public AddStudent() {
		
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(100, 100, 864, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Name :");
		label.setBounds(6, 22, 106, 23);
		contentPane.add(label);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(124, 19, 302, 33);
		contentPane.add(Name);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 156, 822, 2);
		contentPane.add(separator);
		
		final JLabel pic = new JLabel("");
		pic.setBounds(6, 170, 253, 234);
		contentPane.add(pic);
		
		source = new JTextField();
		source.setColumns(10);
		source.setBounds(6, 416, 237, 28);
		contentPane.add(source);
		
		JLabel label_4 = new JLabel("Contact No :");
		label_4.setBounds(271, 170, 97, 16);
		contentPane.add(label_4);
		
		Contact = new JTextField();
		Contact.setColumns(10);
		Contact.setBounds(421, 162, 272, 33);
		contentPane.add(Contact);
		
		JLabel label_5 = new JLabel("Email :");
		label_5.setBounds(271, 202, 55, 16);
		contentPane.add(label_5);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(421, 194, 272, 33);
		contentPane.add(Email);
		
		JLabel label_6 = new JLabel("Permanent Address :");
		label_6.setBounds(271, 230, 181, 23);
		contentPane.add(label_6);
		
		JScrollPane bbb = new JScrollPane();
		bbb.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		bbb.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		bbb.setBounds(271, 265, 546, 136);
		contentPane.add(bbb);
		
		Address = new JTextArea();
		bbb.setViewportView(Address);
		
		exit = new JButton("Exit Without Saving");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		exit.setBounds(641, 416, 187, 34);
		contentPane.add(exit);
		
		JButton save = new JButton("Save");
		save.setBounds(445, 416, 172, 34);
		contentPane.add(save);
		
		JLabel label_8 = new JLabel("New password :");
		label_8.setBounds(445, 64, 130, 23);
		contentPane.add(label_8);
		
		Pass = new JPasswordField();
		Pass.setBounds(587, 59, 241, 33);
		contentPane.add(Pass);
		
		JLabel label_9 = new JLabel("        Confirm New password :");
		label_9.setBounds(371, 96, 204, 33);
		contentPane.add(label_9);
		
		Cpass = new JPasswordField();
		Cpass.setBounds(587, 98, 241, 33);
		contentPane.add(Cpass);
		
		JLabel lblId = new JLabel("Id :");
		lblId.setBounds(6, 88, 106, 23);
		contentPane.add(lblId);
		
		Id = new JTextField();
		Id.setBounds(124, 85, 263, 33);
		contentPane.add(Id);
		Id.setColumns(10);
		
		changeimage = new JButton("Change Image");
		changeimage.setBounds(271, 416, 130, 28);
		contentPane.add(changeimage);
		
		/****************NEW CODE****************************************************/
		changeimage.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int returnVal = fc.showOpenDialog(AddStudent.this);

			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			        	imageChanged=true;
			            File file = fc.getSelectedFile();
			            imagePath=""+file.getAbsolutePath();
			            //This is where a real application would open the file.
			            System.out.println("Opening: " + file.getAbsolutePath()+ ".");
			            //Image ii2=new Image(file.getAbsolutePath());
			            Image ii2=Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
			          // ii=new ImageIcon(createResizedCopy(ii2,200,200,false));
			           ii=new ImageIcon(ii2.getScaledInstance(200, 200, 1));
			           pic.setIcon(ii);
			           repaint();
			           revalidate();
			           source.setText(file.getAbsolutePath());
			        } else {
			        	System.out.println("Open command cancelled by user.");
			        }
				}
				
			}
		);
		
		
		save.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(getData()){
						try {
							saveData();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		);
		
		
	}
	
	BufferedImage createResizedCopy(Image originalImage, 
    		int scaledWidth, int scaledHeight, 
    		boolean preserveAlpha)
    {
    	System.out.println("resizing...");
    	int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
    	BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
    	Graphics2D g = scaledBI.createGraphics();
    	if (preserveAlpha) {
    		g.setComposite(AlphaComposite.Src);
    	}
    	g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
    	g.dispose();
    	return scaledBI;
    }
	@SuppressWarnings("deprecation")
	private boolean getData(){
		/*
		id=Id.getText();
		name=Name.getText();
		pass=Pass.getText();
		cPass=Cpass.getText();
		email=Email.getText();
		address=Address.getText();
		contact=Contact.getText();
		*/
		
		/**************Unit Testing*****************************/
		id="11xy30033";
		name="M Sarkar";
		pass="1111";
		cPass="1111";
		email="mss@gmail.com";
		address="kolkata,usa";
		contact="3433434";
		
		
		/*****************************************************/
		
		if(!pass.equals(cPass)){
			return false;
		}
		if(id.equals("")||name.equals("")||pass.equals("")){
			return false;
		}
		if(address.equals("")){
			address="not available";
		}
		if(email.equals("")){
			email="not available";
		}
		if(contact.equals("")){
			contact="not available";
		}
		return true;
	}
	
	private boolean saveData() throws SQLException{
		
		/******************CODE to UPLOAD THE IMAGE*************************/
		if(imageChanged){
			EchoClient2 sender = new EchoClient2();
			sender.uploadFile(id,imagePath);
		}
		
		/***********************SQL part*************************************/
		
		String imagePathServer="";//may be given in needed
		
		String query="";
		
		query="SELECT * FROM `studentdetail` WHERE `id` LIKE '"+id+"'";
		ResultSet rs=resultQuery(query);
		rs.last();
		if(rs.getRow()!=0){
			return false;
		}
		
		
		query="INSERT INTO `hms`.`studentdetail` (`no` ,`name` ,`id` ,`address` ,`phone` ,`email` ,`photo` ,`hallcode` ,`roomNo` ,`roomtype` ,`roomrentdue` ,"+
		"`messchargedue` ,`amenitychargedue` ,`password`)VALUES (NULL , '"+name+"', '"+id+"', '"+address+"', '"+contact+"', '"+email+"', '"+imagePathServer+
		"','not alotted','not alotted'"+",'3','0','0','0','"+pass+"')";
		
		System.out.println(query);
		
		updateQuery(query);
		
		return true;
	}
	
	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}
	

}
