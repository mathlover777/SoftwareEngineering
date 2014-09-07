import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class logIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField id;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			logIn dialog = new logIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	/***************/
	public String username="",password="";
	private JButton login;
	private JButton cancel;
	private boolean success;
	
	
	public logIn() {
		setResizable(false);
		setTitle("Log In");
		setModal(true);
		setBounds(100, 100, 352, 151);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLogInId = new JLabel("Log In ID :");
		lblLogInId.setBounds(10, 13, 88, 14);
		contentPanel.add(lblLogInId);
		
		id = new JTextField();
		id.setEditable(false);
		id.setText("MANAGER");
		id.setBounds(108, 10, 229, 20);
		contentPanel.add(id);
		id.setColumns(10);
		
		JLabel lblPassword = new JLabel("PassWord : ");
		lblPassword.setBounds(10, 53, 88, 14);
		contentPanel.add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(108, 51, 229, 20);
		contentPanel.add(pass);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 80, 337, 2);
		contentPanel.add(separator_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				login = new JButton("Log In");
				login.setActionCommand("OK");
				buttonPane.add(login);
				getRootPane().setDefaultButton(login);
			}
			{
				cancel = new JButton("Cancel");
				cancel.setActionCommand("Cancel");
				buttonPane.add(cancel);
			}
		}
		

		
		
		
		/*****************events******************/
		login.addActionListener(
			new ActionListener(){

				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					username=id.getText();
					password=pass.getText();
					success=false;
					FileInputStream fstream = null;
					try {
						fstream = new FileInputStream("managerpass.txt");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// Get the object of DataInputStream
					DataInputStream in = new DataInputStream(fstream);
					String strLine="";
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					try {
						strLine=br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(strLine.equals(password)){
						success=true;
					}
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fstream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dispose();
				}
				
				
			}
		);
		cancel.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			}
		);
	}
	public boolean isSuccess(){
		return success;
	}
}
