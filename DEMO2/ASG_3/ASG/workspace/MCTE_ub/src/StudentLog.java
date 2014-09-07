import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class StudentLog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField id;
	private String roll="";
	private JButton ok;
	private JButton cancel;
	private boolean success=false;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			StudentLog dialog = new StudentLog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public StudentLog() {
		setTitle("Student Log In");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 240, 203);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 214, 111);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblEnterRollNumber = new JLabel("Enter Roll Number :");
				lblEnterRollNumber.setBounds(10, 11, 114, 34);
				panel.add(lblEnterRollNumber);
			}
			{
				id = new JTextField();
				id.setBounds(10, 56, 169, 20);
				panel.add(id);
				id.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				ok = new JButton("OK");
				ok.setActionCommand("OK");
				buttonPane.add(ok);
				getRootPane().setDefaultButton(ok);
			}
			{
				cancel = new JButton("Cancel");
				cancel.setActionCommand("Cancel");
				buttonPane.add(cancel);
			}
		}
		
		
		/********************events***************************************/
		id.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					roll=id.getText();
					char c;
					if(!roll.equals("")){
						success=true;
						id.setText("");
					}
					else{
						roll="Empty id !!";
					}
					for(int i=0;i<=roll.length()-1;i++){
						c=roll.charAt(i);
						if(c=='.'||c==','||c==';'||c==':'||c=='<'||c=='>'||c=='/'||c=='\\'){
								roll="Illegal Char in Roll Name !!...login failed";
								success=false;
								dispose();
						}
					}
					dispose();
				}
			}
		);
		ok.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					roll=id.getText();
					char c;
					if(!roll.equals("")){
						success=true;
						id.setText("");
					}
					else{
						roll="Empty id !!";
					}
					for(int i=0;i<=roll.length()-1;i++){
						c=roll.charAt(i);
						if(c=='.'||c==','||c==';'||c==':'||c=='<'||c=='>'||c=='/'||c=='\\'){
								roll="Illegal Char in Roll Name !!...login failed";
								success=false;
								dispose();
						}
					}
					dispose();
				}
				
			}
		);
		cancel.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			}
		);
	}
	public String getId(){
		//System.out.println("roll="+roll);
		return roll;
	}
	public boolean ifSuccess(){
		return success;
	}
	

}
