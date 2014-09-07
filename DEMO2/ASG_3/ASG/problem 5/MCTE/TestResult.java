import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TestResult extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idbox;
	private JTextField testbox;
	private JTextField fm;
	private JTextField c;
	private JTextField u;
	private JTextField i;
	private JButton ok;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			TestResult dialog = new TestResult();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public TestResult(String testname,String id,int count,int correct,int un,int in) {
		setResizable(false);
		setModal(true);
		setTitle("Test Result");
		setBounds(100, 100, 326, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(10, 11, 46, 14);
		contentPanel.add(lblId);
		
		idbox = new JTextField();
		idbox.setBackground(Color.WHITE);
		idbox.setEnabled(false);
		idbox.setBounds(128, 8, 151, 20);
		contentPanel.add(idbox);
		idbox.setColumns(10);
		
		JLabel lblTestname = new JLabel("TestName :");
		lblTestname.setBounds(10, 42, 87, 14);
		contentPanel.add(lblTestname);
		
		testbox = new JTextField();
		testbox.setBackground(Color.WHITE);
		testbox.setEnabled(false);
		testbox.setBounds(128, 39, 151, 20);
		contentPanel.add(testbox);
		testbox.setColumns(10);
		
		JLabel lblFullMarks = new JLabel("Full Marks :");
		lblFullMarks.setBounds(10, 100, 87, 14);
		contentPanel.add(lblFullMarks);
		
		fm = new JTextField();
		fm.setBackground(Color.WHITE);
		fm.setEnabled(false);
		fm.setBounds(193, 97, 86, 20);
		contentPanel.add(fm);
		fm.setColumns(10);
		
		JLabel lblCorrectResponses = new JLabel("Correct Responses :");
		lblCorrectResponses.setBounds(10, 142, 143, 14);
		contentPanel.add(lblCorrectResponses);
		
		c = new JTextField();
		c.setBackground(Color.WHITE);
		c.setEnabled(false);
		c.setBounds(193, 139, 86, 20);
		contentPanel.add(c);
		c.setColumns(10);
		
		JLabel lblUnattempted = new JLabel("Unattempted :");
		lblUnattempted.setBounds(10, 190, 97, 14);
		contentPanel.add(lblUnattempted);
		
		u = new JTextField();
		u.setBackground(Color.WHITE);
		u.setEnabled(false);
		u.setBounds(193, 187, 86, 20);
		contentPanel.add(u);
		u.setColumns(10);
		
		JLabel lblIncorrect = new JLabel("Incorrect :");
		lblIncorrect.setBounds(10, 236, 87, 14);
		contentPanel.add(lblIncorrect);
		
		i = new JTextField();
		i.setBackground(Color.WHITE);
		i.setEnabled(false);
		i.setBounds(193, 233, 86, 20);
		contentPanel.add(i);
		i.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 290, 2);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 262, 290, 2);
		contentPanel.add(separator_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				ok = new JButton("OK");
				ok.setForeground(Color.BLACK);
				ok.setActionCommand("OK");
				buttonPane.add(ok);
				getRootPane().setDefaultButton(ok);
			}
		}
		
		
		
		/**************************/
		idbox.setText(id);
		testbox.setText(testname);
		fm.setText(""+count);
		c.setText(""+correct);
		u.setText(""+un);
		i.setText(""+in);
		
		ok.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			}
		);
		
		
	}
}
