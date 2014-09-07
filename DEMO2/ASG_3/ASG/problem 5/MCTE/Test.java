import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Test extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JButton ok;
	private JButton cancel;
	
	
	private String testname="";
	private boolean success=false;
	private JTextArea log;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Test dialog = new Test();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Test() {
		setTitle("Select Test");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSelectTest = new JLabel("Select Test :");
		lblSelectTest.setBounds(10, 11, 111, 24);
		contentPanel.add(lblSelectTest);
		
		name = new JTextField();
		name.setBounds(147, 13, 228, 20);
		contentPanel.add(name);
		name.setColumns(10);
		
		JLabel lblenterNameOf = new JLabel("(Enter Name of Test File)");
		lblenterNameOf.setBounds(147, 44, 228, 20);
		contentPanel.add(lblenterNameOf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 424, 141);
		contentPanel.add(scrollPane);
		
		log = new JTextArea();
		log.setEditable(false);
		scrollPane.setViewportView(log);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				ok = new JButton("OK");
				ok.setEnabled(false);
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
		name.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					testname=name.getText();
					name.setText("");
					//URL s=Start.class.getResource(testname);
					/*if(s==null){
						log.append("\nno such test file");
						success=false;
					}
					else{*/
					
						log.append("\nTest found !!! click on ok to begin your test !!");
						ok.setEnabled(true);
						success=true;
					//}
				}
				
			}
		);
		ok.addActionListener(
			new ActionListener(){
				

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
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
	public boolean isSuccess(){
		return success;
	}
	public String getTestName(){
		return testname;
	}
}
