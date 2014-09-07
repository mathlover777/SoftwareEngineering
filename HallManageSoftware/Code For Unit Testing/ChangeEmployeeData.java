package code;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChangeEmployeeData extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5232667146417649939L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the panel.
	 */
	public ChangeEmployeeData() {
		setLayout(null);
		setModal(true);
		setBounds(50,50,1000,600);
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(6, 26, 140, 27);
		add(lblName);

		textField = new JTextField();
		textField.setBounds(158, 25, 247, 33);
		add(textField);
		textField.setColumns(10);

		JLabel lblContactNo = new JLabel("Contact No :");
		lblContactNo.setBounds(6, 86, 140, 27);
		add(lblContactNo);

		textField_1 = new JTextField();
		textField_1.setBounds(158, 85, 247, 33);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(6, 140, 140, 27);
		add(lblEmail);

		textField_2 = new JTextField();
		textField_2.setBounds(158, 139, 247, 33);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblAccountNo = new JLabel("Account No :");
		lblAccountNo.setBounds(6, 190, 140, 27);
		add(lblAccountNo);

		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setBounds(158, 189, 247, 33);
		add(textField_3);
		textField_3.setColumns(10);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(6, 240, 140, 27);
		add(lblAddress);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(157, 234, 400, 231);
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		JLabel lblId = new JLabel("ID  :");
		lblId.setBounds(417, 31, 42, 22);
		add(lblId);

		textField_4 = new JTextField();
		textField_4.setBounds(569, 23, 220, 33);
		add(textField_4);
		textField_4.setColumns(10);

		JLabel lblOldPassword = new JLabel("Old Password :");
		lblOldPassword.setBounds(417, 91, 140, 22);
		add(lblOldPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(569, 85, 220, 33);
		add(passwordField);

		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setBounds(417, 145, 140, 22);
		add(lblNewPassword);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(569, 139, 220, 33);
		add(passwordField_1);

		JLabel lblConfirmnewPassword = new JLabel("Confirm-New Password :");
		lblConfirmnewPassword.setBounds(417, 195, 150, 27);
		add(lblConfirmnewPassword);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(569, 189, 220, 33);
		add(passwordField_2);

		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(569, 239, 220, 47);
		add(btnSaveChanges);

		JButton btnBackWithoutSaving = new JButton("Back Without Saving");
		btnBackWithoutSaving.setBounds(569, 298, 220, 47);
		add(btnBackWithoutSaving);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 68, 797, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(569, 234, 231, 2);
		add(separator_1);

	}

}
