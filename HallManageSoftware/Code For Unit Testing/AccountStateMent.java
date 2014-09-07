package code;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class AccountStateMent extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2731285068412345441L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox1;
	private JButton btnNewButton;
	private JButton btnExit;

	
	private Bridge bridge;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * 
	 */
	
	
	
	
	public AccountStateMent(final String hallCode) {
		
		/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		
		
		
		
		
		
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(297, 38, 131, 2);
			contentPanel.add(separator);
		}
		{
			btnNewButton = new JButton("Print Statement");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	
						GenerateAccountStatement.genStmt(hallCode, comboBox1
								.getSelectedItem().toString(),
								2013+"", "C:/comp/", "AcStmt"
										+ hallCode);
				
				}
			});
			btnNewButton.setBounds(34, 204, 131, 42);
			contentPanel.add(btnNewButton);
		}
		{
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnExit.setBounds(304, 204, 124, 42);
			contentPanel.add(btnExit);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(6, 172, 422, 2);
			contentPanel.add(separator);
		}

		JLabel lblSelectAccount = new JLabel("Select Account :");
		lblSelectAccount.setBounds(6, 107, 85, 25);
		contentPanel.add(lblSelectAccount);

		comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] { "salary",
				"misc", "room", "repair", "amenity", "mess" }));
		comboBox1.setBounds(103, 101, 182, 36);
		contentPanel.add(comboBox1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
