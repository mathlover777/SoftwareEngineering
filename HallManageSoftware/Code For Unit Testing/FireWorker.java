package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class FireWorker extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private JPanel contentPane;
	private JTextField Id;
	private JTextField Contact;
	private JTextField Email;
	private JComboBox type;
	private JComboBox selectworkerlist;
	private JButton recruit;
	/******************* EXTRA DATA *****************************/
	private String id[], name[], email[], address[], contact[];
	private int key[];
	private JButton search;
	private int workerCount = 0, sindex = 0;
	private JTextArea Address;
	private int present[];
	private Bridge bridge;

	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			FireWorker dialog = new FireWorker("VS");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/************************************************************/

	/*********************************************************/

	/**
	 * Create the frame.
	 */
	public FireWorker(String hallcode) {
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(50,50,1000,600);
		getContentPane().setLayout(null);

		JLabel lblSelectWorker = new JLabel("Select Worker :");
		lblSelectWorker.setBounds(20, 84, 109, 36);
		getContentPane().add(lblSelectWorker);

		JLabel lblSelectType = new JLabel("Select Type :");
		lblSelectType.setBounds(20, 22, 109, 36);
		getContentPane().add(lblSelectType);

		type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] { "Select Worker",
				"Clerk", "Gardener", "Attendant" }));
		type.setBounds(156, 27, 221, 36);
		getContentPane().add(type);

		selectworkerlist = new JComboBox();
		selectworkerlist.setBounds(156, 84, 221, 36);
		getContentPane().add(selectworkerlist);

		JSeparator separator = new JSeparator();
		separator.setBounds(389, 103, 428, 2);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 134, 796, 2);
		getContentPane().add(separator_1);

		JLabel lblName = new JLabel("Id :");
		lblName.setBounds(20, 162, 109, 36);
		getContentPane().add(lblName);

		Id = new JTextField();
		Id.setBounds(156, 166, 324, 32);
		getContentPane().add(Id);
		Id.setColumns(10);

		JLabel lblContactNo = new JLabel("Contact No :");
		lblContactNo.setBounds(20, 231, 130, 36);
		getContentPane().add(lblContactNo);

		Contact = new JTextField();
		Contact.setBounds(156, 231, 324, 36);
		getContentPane().add(Contact);
		Contact.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(20, 293, 109, 32);
		getContentPane().add(lblEmail);

		Email = new JTextField();
		Email.setBounds(156, 295, 324, 36);
		getContentPane().add(Email);
		Email.setColumns(10);

		JLabel lblPermanentAddress = new JLabel("Permanent Address :");
		lblPermanentAddress.setBounds(20, 351, 130, 32);
		getContentPane().add(lblPermanentAddress);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(156, 356, 485, 109);
		getContentPane().add(scrollPane);

		Address = new JTextArea();
		Address.setLineWrap(true);
		scrollPane.setViewportView(Address);

		recruit = new JButton("Fire Worker");
		recruit.setForeground(Color.RED);
		recruit.setBounds(562, 159, 221, 43);
		getContentPane().add(recruit);

		search = new JButton("Search");
		search.setBounds(390, 26, 109, 36);
		getContentPane().add(search);

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					searchWorker();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		recruit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fireWorker();
			}

		});
		selectworkerlist.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				showWorker();
			}

		});
	}

	private void searchWorker() throws SQLException {

		if (type.getSelectedIndex() == 0) {
			System.out.println("index = 0");
			return;
		}
		String workerType = (String) (type.getSelectedItem());
		ResultSet rs;
		String query = "SELECT * FROM `workerlist` WHERE `type` LIKE '"
				+ workerType + "' AND `hallcode` NOT LIKE 'not recruited'";
		rs = resultQuery(query);
		rs.last();
		workerCount = rs.getRow();
		rs.beforeFirst();
		rs.next();
		System.out.println(workerCount);
		if (workerCount == 0) {
			System.out.println("no worker available !!");
			selectworkerlist.setModel(new DefaultComboBoxModel(
					new String[] { "No Worker Available" }));
			return;
		}
		name = new String[workerCount + 1];
		email = new String[workerCount];
		contact = new String[workerCount];
		address = new String[workerCount];
		id = new String[workerCount];
		key = new int[workerCount];
		present = new int[workerCount];

		name[0] = "Select Worker";
		int i;
		for (i = 0; i <= workerCount - 1; i++) {
			name[i + 1] = rs.getString("name");
			email[i] = rs.getString("email");
			contact[i] = rs.getString("contact");
			address[i] = rs.getString("address");
			id[i] = rs.getString("id");
			key[i] = (int) (Integer.parseInt(rs.getString("no")));
			present[i] = (int) (Integer.parseInt(rs.getString("present")));
			rs.next();
		}

		selectworkerlist.setModel(new DefaultComboBoxModel(name));

	}

	private void showWorker() {
		sindex = selectworkerlist.getSelectedIndex();
		if (sindex == 0) {
			Id.setText("");
			Email.setText("");
			Address.setText("");
			Contact.setText("");
			return;
		}
		sindex--;
		Id.setText(id[sindex]);
		Email.setText(email[sindex]);
		Address.setText(address[sindex]);
		Contact.setText(contact[sindex]);
		sindex++;
		return;
	}

	private boolean fireWorker() {

		/*if (sindex == 0) {
			return false;
		}
*/
		String query = "";
	/*	if (present[sindex - 1] != 0) {
			System.out
					.println("Cant Fire worker ... please pay remaining dues !! ");
			return false;
		}
# removed for unit testing
		query = "UPDATE `hms`.`workerlist` SET `hallcode` = '"
				+ "not recruited" + "' WHERE `workerlist`.`no` ="
				+ key[sindex - 1];
*/
		/*****************Unit testing Code**********************/
		query = "UPDATE `hms`.`workerlist` SET `hallcode` = '"
				+ "not recruited" + "' WHERE `workerlist`.`no` ="
				+ 7;
		
		
		/********************************************************/
		
		
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
