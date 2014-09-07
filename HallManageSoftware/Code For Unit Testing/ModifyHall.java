package code;

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
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class ModifyHall extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1657551829010527258L;
	private JTextField Addsingle;
	private JTextField Adddouble;
	private JTextField Singlerent;
	private JTextField Doublerent;
	private JComboBox Hall;
	private JRadioButton Old;
	private JRadioButton New;
	private JButton delete;
	private JComboBox Warden;
	private JComboBox Messmanager;
	private JButton deletehall;
	private JButton save;
	private JButton exit;
	private JTextField Room;

	/**
	 * Create the frame.
	 */
	
	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			ModifyHall dialog = new ModifyHall();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/************************************************************/

	/*********************** EXTRA DATA ***************************************/
	private String hallName[], hallCode[];
	private int singleCount[], doubleCount[], singleFilled[], doubleFilled[],
			singleRoomRent[], doubleRoomRent[], amenity[];
	private int sindex;
	private String[] hallStatus;
	private int hallCount;
	@SuppressWarnings("unused")
	private String wardenId = "", messManagerId = "";
	private String wardenIdList[], wardenNameList[], messManagerIdList[],
			messManagerNameList[];
	private int wardenCount, messManagerCount, windex = 0, mindex = 0;

	private int singleRent, doubleRent, singleAdd, doubleAdd;
	private Bridge bridge;

	public ModifyHall() {
/********************Extra Code************************/
		
		try {
			bridge = new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(50,50,1000,600);

		getContentPane().setLayout(null);
		JLabel lblSelectHall = new JLabel("Select Hall");
		lblSelectHall.setBounds(10, 11, 137, 29);
		getContentPane().add(lblSelectHall);

		Hall = new JComboBox();
		Hall.setModel(new DefaultComboBoxModel(new String[] { "Select Hall" }));
		Hall.setBounds(171, 11, 302, 35);
		getContentPane().add(Hall);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 51, 757, 6);
		getContentPane().add(separator);

		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(10, 121, 46, 14);
		getContentPane().add(lblStatus);

		Old = new JRadioButton("Old");
		Old.setBounds(171, 128, 109, 23);
		getContentPane().add(Old);

		New = new JRadioButton("New");
		New.setBounds(300, 128, 109, 23);
		getContentPane().add(New);

		JLabel lblAddRooms = new JLabel("Add Single Rooms :");
		lblAddRooms.setBounds(10, 183, 137, 29);
		getContentPane().add(lblAddRooms);

		Addsingle = new JTextField();
		Addsingle.setBounds(171, 187, 86, 35);
		getContentPane().add(Addsingle);
		Addsingle.setColumns(10);

		JLabel lblAddDoubleRooms = new JLabel("Add Double Rooms :");
		lblAddDoubleRooms.setBounds(10, 232, 137, 25);
		getContentPane().add(lblAddDoubleRooms);

		Adddouble = new JTextField();
		Adddouble.setBounds(171, 234, 86, 36);
		getContentPane().add(Adddouble);
		Adddouble.setColumns(10);

		JLabel lblSingleRoomRent = new JLabel("Single Room Rent :");
		lblSingleRoomRent.setBounds(296, 190, 113, 22);
		getContentPane().add(lblSingleRoomRent);

		Singlerent = new JTextField();
		Singlerent.setBounds(467, 187, 113, 35);
		getContentPane().add(Singlerent);
		Singlerent.setColumns(10);

		JLabel lblDoubleRoomRent = new JLabel("Double Room Rent :");
		lblDoubleRoomRent.setBounds(296, 237, 126, 20);
		getContentPane().add(lblDoubleRoomRent);

		Doublerent = new JTextField();
		Doublerent.setBounds(467, 234, 113, 36);
		getContentPane().add(Doublerent);
		Doublerent.setColumns(10);

		JLabel lblpm = new JLabel("/pm");
		lblpm.setBounds(590, 190, 46, 14);
		getContentPane().add(lblpm);

		JLabel lblpm_1 = new JLabel("/pm");
		lblpm_1.setBounds(590, 237, 46, 14);
		getContentPane().add(lblpm_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 162, 757, 7);
		getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 276, 757, 2);
		getContentPane().add(separator_2);

		JLabel lblWarden = new JLabel("Warden :");
		lblWarden.setBounds(10, 318, 126, 29);
		getContentPane().add(lblWarden);

		Warden = new JComboBox();
		Warden.setModel(new DefaultComboBoxModel(
				new String[] { "SELECT NEW WARDEN" }));
		Warden.setBounds(171, 318, 286, 29);
		getContentPane().add(Warden);

		JLabel lblMessManager = new JLabel("Mess Manager :");
		lblMessManager.setBounds(10, 358, 137, 22);
		getContentPane().add(lblMessManager);

		Messmanager = new JComboBox();
		Messmanager.setModel(new DefaultComboBoxModel(
				new String[] { "SELECT NEW MESS MANAGER" }));
		Messmanager.setBounds(171, 359, 286, 29);
		getContentPane().add(Messmanager);

		save = new JButton("Save");
		save.setBounds(579, 329, 97, 45);
		getContentPane().add(save);

		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		exit.setBounds(686, 330, 97, 43);
		getContentPane().add(exit);

		deletehall = new JButton("Delete Hall");
		deletehall.setBounds(467, 329, 102, 45);
		getContentPane().add(deletehall);

		JLabel lblRoom = new JLabel("Room:");
		lblRoom.setBounds(633, 196, 43, 16);
		getContentPane().add(lblRoom);

		delete = new JButton("Delete");
		delete.setBounds(633, 230, 134, 40);
		getContentPane().add(delete);

		Room = new JTextField();
		Room.setBounds(687, 187, 109, 35);
		getContentPane().add(Room);
		Room.setColumns(10);

		/*************************************************************************************/
		try {
			getHallList();
			fetchInformation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Hall.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				sindex = Hall.getSelectedIndex();
				if (sindex != 0) {
					if (hallStatus[sindex - 1].equals("old")) {
						Old.setSelected(true);
						New.setSelected(false);
					} else {
						New.setSelected(true);
						Old.setSelected(false);
					}
				}
			}

		});
		Old.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				New.setSelected(false);
			}

		});

		New.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Old.setSelected(false);
			}

		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getChanges();
				saveChanges();
			}

		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					deleteRoom();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		deletehall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteHall();
			}

		});

	}

	private void getChanges() {
		try {
			singleAdd = (int) (Integer.parseInt((Addsingle.getText())));
		} catch (Exception e) {
			singleAdd = 0;
		}
		try {
			doubleAdd = (int) (Integer.parseInt((Adddouble.getText())));

		} catch (Exception e) {
			doubleAdd = 0;
		}
		try {
			singleRent = (int) (Integer.parseInt((Singlerent.getText())));
		} catch (Exception e) {
			singleRent = 0;
		}
		try {
			doubleRent = (int) (Integer.parseInt((Doublerent.getText())));
		} catch (Exception e) {
			doubleRent = 0;
		}
		if (Old.isSelected()) {
		}
		if (New.isSelected()) {
		}
	}

	private void saveChanges() {
		sindex = Hall.getSelectedIndex();
		if (sindex == 0) {
			return;
		}
		String query = "";
		sindex--;
		if (singleRent == 0) {
			singleRent = singleRoomRent[sindex];
		}
		if (doubleRent == 0) {
			doubleRent = doubleRoomRent[sindex];
		}
		query = "UPDATE `hms`.`halldata` SET `singlecount` = '"
				+ (singleAdd + singleCount[sindex]) + "',`doublecount` = '"
				+ (doubleCount[sindex] + doubleAdd) + "',"
				+ " `singlerent` = '" + singleRent + "',`doublerent` = '"
				+ doubleRent + "' WHERE `hallcode` LIKE '" + hallCode[sindex]
				+ "'";
		updateQuery(query);

		for (int i = 0; i <= singleAdd - 1; i++) {
			query = "INSERT INTO `hms`.`"
					+ hallCode[sindex]
					+ "_studentlist` (`roomno` ,`type` ,`student1id` ,`student1name` ,`student2id` ,`student2name`)VALUES"
					+ " (NULL, 'single', 'empty', 'empty', 'empty', 'empty')";
			updateQuery(query);
		}
		for (int i = 0; i <= singleAdd - 1; i++) {
			query = "INSERT INTO `hms`.`"
					+ hallCode[sindex]
					+ "_studentlist` (`roomno` ,`type` ,`student1id` ,`student1name` ,`student2id` ,`student2name`)VALUES"
					+ " (NULL, 'double', 'empty', 'empty', 'empty', 'empty')";
			updateQuery(query);
		}
		mindex = Messmanager.getSelectedIndex();
		windex = Warden.getSelectedIndex();
		if (mindex != 0) {
			query = "UPDATE `hms`.`workerlist` SET `hallcode` = 'not recruited' WHERE `hallcode` LIKE '"
					+ hallCode[sindex] + "' AND `type` LIKE 'MessManager'";
			updateQuery(query);
			query = "UPDATE `hms`.`workerlist` SET `hallcode` = '"
					+ hallCode[sindex] + "' WHERE `id` LIKE '"
					+ messManagerIdList[mindex - 1] + "'";
			updateQuery(query);
		}
		if (windex != 0) {
			query = "UPDATE `hms`.`wardenlist` SET `hallcode` = 'not assigned' WHERE `hallcode` LIKE '"
					+ hallCode[sindex] + "'";
			updateQuery(query);
			query = "UPDATE `hms`.`wardenlist` SET `hallcode` = '"
					+ hallCode[sindex] + "' WHERE `id` LIKE '"
					+ wardenIdList[windex - 1] + "'";
			updateQuery(query);
		}
		sindex++;
	}

	private ResultSet resultQuery(String query) {
		return bridge.resultQuery(query);
	}

	private int updateQuery(String query) {
		return bridge.updateQuery(query);
	}

	private void deleteRoom() throws SQLException {
		int roomno = (int) (Integer.parseInt((Room.getText())));
		sindex = Hall.getSelectedIndex();
		if (sindex == 0) {
			return;
		}
		sindex--;
		String query = "";
		query = "SELECT `student1id`,`student2id` FROM `hms`.`"
				+ hallCode[sindex] + "_studentlist WHERE `roomno` = " + roomno;
		ResultSet rs = resultQuery(query);
		rs.last();
		rs.beforeFirst();
		rs.next();
		String student1id = rs.getString("student1id");
		String student2id = rs.getString("student2id");
		query = "UPDATE `hms`.`llr_studentlist` SET `type` = 'removed' WHERE `"
				+ hallCode[sindex] + "_studentlist`.`roomno` =" + roomno;
		updateQuery(query);
		if (!student1id.equals("empty")) {
			throwStudent(student1id);
		}
		if (!student2id.equals("empty")) {
			throwStudent(student2id);
		}
		sindex++;
	}

	private void throwStudent(String studentId) {
		String query = "UPDATE `hms`.`studentdetail` SET `hallcode` = 'not alloted',`roomNo` = 'not alloted' WHERE `id` LIKE '"
				+ studentId + "'";
		updateQuery(query);
	}

	private void deleteHall() {
		sindex = Hall.getSelectedIndex();
		if (sindex == 0) {
			return;
		}
		sindex--;
		String query = "DELETE FROM `hallaccount` WHERE `hallcode` LIKE '"
				+ hallCode[sindex] + "'";
		updateQuery(query);
		query = "DELETE FROM `halldata` WHERE `hallcode` LIKE '"
				+ hallCode[sindex] + "'";
		updateQuery(query);
		query = "DELETE FROM `granttable` WHERE `hallcode` LIKE '"
				+ hallCode[sindex] + "'";
		updateQuery(query);
		query = "UPDATE `hms`.`workerlist` SET `hallcode` = 'not recruited' WHERE `hallcode` LIKE '"
				+ hallCode[sindex] + "'";
		updateQuery(query);
		query = "UPDATE `hms`.`wardenlist` SET `hallcode` = 'not assigned' WHERE `hallcode` LIKE '"
				+ hallCode[sindex] + "'";
		updateQuery(query);
		query = "DELETE FROM `halldata` WHERE `hallcode` LIKE '"
				+ hallCode[sindex] + "'";
		updateQuery(query);
		query = "UPDATE `hms`.`studentdetail` SET `hallcode` = 'not alloted' , `roomNo` = 'not alloted' WHERE `hallcode` LIKE '"
				+ hallCode[sindex] + "'";
		updateQuery(query);
		query = "DROP TABLE `" + hallCode[sindex] + "_studentlist`";
		updateQuery(query);
		query = "DROP TABLE `" + hallCode[sindex] + "_salaryaccount_log`";
		updateQuery(query);
		query = "DROP TABLE `" + hallCode[sindex] + "_roomaccount_log`";
		updateQuery(query);
		query = "DROP TABLE `" + hallCode[sindex] + "_repairaccount_log`";
		updateQuery(query);
		query = "DROP TABLE `" + hallCode[sindex] + "_miscaccount_log`";
		updateQuery(query);
		query = "DROP TABLE `" + hallCode[sindex] + "_messaccount_log`";
		updateQuery(query);
		query = "DROP TABLE `" + hallCode[sindex] + "_amenityaccount_log`";
		updateQuery(query);

	}

	private boolean getHallList() throws SQLException {
		String query = "";
		query = "SELECT * FROM `hms`.`halldata`";
		ResultSet rs = resultQuery(query);
		rs.last();
		hallCount = rs.getRow();
		rs.beforeFirst();
		rs.next();
		hallCode = new String[hallCount];
		hallName = new String[hallCount + 1];
		singleRoomRent = new int[hallCount];
		doubleRoomRent = new int[hallCount];
		singleCount = new int[hallCount];
		doubleCount = new int[hallCount];
		singleFilled = new int[hallCount];
		doubleFilled = new int[hallCount];
		amenity = new int[hallCount];
		hallStatus = new String[hallCount];
		hallName[0] = "Select Hall";
		int i;
		for (i = 1; i <= hallCount; i++) {
			hallCode[i - 1] = rs.getString("hallcode");
			hallName[i] = rs.getString("hallname");
			singleRoomRent[i - 1] = (int) (Integer.parseInt(rs
					.getString("singlerent")));
			singleCount[i - 1] = (int) (Integer.parseInt(rs
					.getString("singlecount")));
			doubleRoomRent[i - 1] = (int) (Integer.parseInt(rs
					.getString("doublerent")));
			doubleCount[i - 1] = (int) (Integer.parseInt(rs
					.getString("doublecount")));
			singleFilled[i - 1] = (int) (Integer.parseInt(rs
					.getString("singlefilled")));
			doubleFilled[i - 1] = (int) (Integer.parseInt(rs
					.getString("doublefilled")));
			amenity[i - 1] = (int) (Integer.parseInt(rs
					.getString("amenitycharge")));
			hallStatus[i - 1] = rs.getString("status");
			rs.next();
		}
		Hall.setModel(new DefaultComboBoxModel(hallName));
		return true;
	}

	private boolean fetchInformation() throws SQLException {

		/**************** Fetching Warden List *************************/
		String query = "";
		ResultSet rs = null;

		query = "SELECT `name`,`id` FROM `hms`.`wardenlist` WHERE `hallcode` LIKE 'not assigned'";
		rs = resultQuery(query);

		rs.last();
		wardenCount = rs.getRow();
		rs.beforeFirst();
		rs.next();

		wardenIdList = new String[wardenCount];
		wardenNameList = new String[wardenCount + 1];
		// System.out.println("warden Count = "+wardenCount
		// +"row = "+rs.getRow());
		wardenNameList[0] = "Select Warden";
		for (int i = 1; i <= wardenCount; i++) {
			// System.out.println("Name = "+rs.getString("name"));
			wardenNameList[i] = "" + rs.getString("name");
			wardenIdList[i - 1] = "" + rs.getString("id");
			rs.next();
		}

		Warden.setModel(new DefaultComboBoxModel(wardenNameList));

		query = "SELECT `name`,`id` FROM `hms`.`workerlist` WHERE `type` LIKE 'messManager' AND `hallcode` IN ('not assigned','not recruited')";
		rs = resultQuery(query);

		rs.last();
		messManagerCount = rs.getRow();
		rs.beforeFirst();
		rs.next();
		System.out.println("MessManagerCount = " + messManagerCount);
		messManagerIdList = new String[messManagerCount];
		messManagerNameList = new String[messManagerCount + 1];
		messManagerNameList[0] = "Select Mess Manager";
		for (int i = 1; i <= messManagerCount; i++) {
			messManagerNameList[i] = "" + rs.getString("name");
			messManagerIdList[i - 1] = "" + rs.getString("id");
			rs.next();
		}
		Messmanager.setModel(new DefaultComboBoxModel(messManagerNameList));

		return true;
	}

}
