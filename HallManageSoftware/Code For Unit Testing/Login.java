package code;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4057353290764168271L;
	private JPasswordField passwordInput;
	private JComboBox comboBox;
	public JButton btnGo;
	private JTextField userID;
	private static String loginID = null;
	public static final String COPYRIGHT = "\u00a9";
	public static final String REGISTERED = "\u00ae";
	public static final String EURO = "\u20ac";

	/**
	 * Create the panel.
	 */

	public Login() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JLabel lblLoginAs = new JLabel("Login As:");
		lblLoginAs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoginAs.setBounds(277, 83, 117, 80);
		add(lblLoginAs);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "HMC",
				"Warden", "Student", "Clerk", "Mess Manager", "<Select>" }));
		comboBox.setSelectedIndex(5);
		comboBox.setBounds(406, 105, 185, 43);
		add(comboBox);

		passwordInput = new JPasswordField();
		passwordInput.setBounds(405, 311, 186, 43);
		add(passwordInput);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(687, 23, 90, 474);
		add(separator_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class
				.getResource("/resources/IIT KGP.jpg")));
		lblNewLabel.setBounds(804, 145, 304, 209);
		add(lblNewLabel);

		btnGo = new JButton("GO");
		btnGo.setBounds(406, 390, 185, 43);
		add(btnGo);

		JLabel lblId = new JLabel("User ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(277, 192, 117, 69);
		add(lblId);

		userID = new JTextField();
		userID.setBounds(406, 204, 185, 48);
		add(userID);
		userID.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(277, 297, 117, 69);
		add(lblPassword);
		
		JLabel lblA = new JLabel("New label");
		lblA.setBounds(587, 592, 271, 28);
		add(lblA);
		lblA.setText(" HallControl \u00A9 2013 | \u00ae HuhaSoft Technologies");
		
		JLabel lblcscs = new JLabel("11CS10060 | 11CS30037");
		lblcscs.setBounds(629, 615, 271, 28);
		add(lblcscs);
		
		JButton btnRunSetup = new JButton("Run Setup");
		btnRunSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Setup t = new Setup();
				t.setVisible(true);
			}
		});
		btnRunSetup.setBounds(804, 390, 262, 43);
		add(btnRunSetup);
	}

	public static String getLoginID() {
		return loginID;
	}

	public static void setLoginID(String loginID) {
		Login.loginID = loginID;
	}

	@SuppressWarnings("deprecation")
	public String getPasswordInput() {
		// TODO Auto-generated method stub
		return passwordInput.getText().toString();
	}

	public String getUserID() {
		// TODO Auto-generated method stub
		return userID.getText().toString();
	}

	public Object getSelectedIndex() {
		// TODO Auto-generated method stub
		return comboBox.getSelectedIndex();
	}
}
