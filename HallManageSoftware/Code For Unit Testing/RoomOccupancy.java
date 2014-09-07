package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RoomOccupancy extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField student1name;
	private JTextField student1id;
	private JTextField student2name;
	private JTextField student2id;
	private JTextField Roomno;
	private JTextField Roomtype;
	private JScrollPane scrollPane;
	private JButton exit;
	private JList list;

	/**
	 * Create the frame.
	 */

	/*********************** NEW DATA ************************/
	private String hallCode = "";
	private int roomCount;
	private int roomNo[];
	private String roomType[];
	private String student1Name[], student2Name[], student1Id[], student2Id[];
	private Bridge bridge;

	// private int roomSelect=0;
	/**************main for unit testing**************************/
	public static void main(String[] args) {
		try {
			RoomOccupancy dialog = new RoomOccupancy("ms");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/************************************************************/
	
	
	
	public RoomOccupancy(String hallcode) {
/********************Extra Code************************/
		
		try {
			bridge=new Bridge("logindata.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*******************************************************/
		setModal(true);
		setBounds(100, 100, 856, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		getContentPane().setLayout(null);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 6, 341, 460);
		getContentPane().add(scrollPane);

		JLabel lblSelectRoom = new JLabel("Select Room");
		scrollPane.setColumnHeaderView(lblSelectRoom);

		list = new JList();
		/*
		 * list.setModel(new AbstractListModel() { String[] values = new
		 * String[] {"1", "2", "3", "4", "5", "6"}; public int getSize() {
		 * return values.length; } public Object getElementAt(int index) {
		 * return values[index]; } });
		 */
		scrollPane.setViewportView(list);

		JLabel lblNewLabel = new JLabel("Student 1 :");
		lblNewLabel.setBounds(351, 127, 99, 26);
		getContentPane().add(lblNewLabel);

		student1name = new JTextField();
		student1name.setBounds(462, 119, 341, 43);
		getContentPane().add(student1name);
		student1name.setColumns(10);

		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(357, 178, 55, 16);
		getContentPane().add(lblId);

		student1id = new JTextField();
		student1id.setBounds(462, 173, 274, 37);
		getContentPane().add(student1id);
		student1id.setColumns(10);

		JLabel lblStudent = new JLabel("Student 2 :");
		lblStudent.setBounds(351, 240, 99, 26);
		getContentPane().add(lblStudent);

		student2name = new JTextField();
		student2name.setBounds(462, 239, 341, 37);
		getContentPane().add(student2name);
		student2name.setColumns(10);

		JLabel lblId_1 = new JLabel("ID :");
		lblId_1.setBounds(357, 298, 55, 16);
		getContentPane().add(lblId_1);

		student2id = new JTextField();
		student2id.setBounds(462, 287, 274, 37);
		getContentPane().add(student2id);
		student2id.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(346, 226, 511, 2);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(351, 346, 506, 2);
		getContentPane().add(separator_1);

		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		exit.setBounds(712, 392, 134, 60);
		getContentPane().add(exit);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(351, 107, 506, 2);
		getContentPane().add(separator_2);

		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setBounds(359, 13, 91, 26);
		getContentPane().add(lblRoomNo);

		Roomno = new JTextField();
		Roomno.setBounds(462, 8, 122, 37);
		getContentPane().add(Roomno);
		Roomno.setColumns(10);

		JLabel lblRoomType = new JLabel("Room Type :");
		lblRoomType.setBounds(359, 65, 91, 30);
		getContentPane().add(lblRoomType);

		Roomtype = new JTextField();
		Roomtype.setBounds(462, 57, 122, 37);
		getContentPane().add(Roomtype);
		Roomtype.setColumns(10);

		/***************************** new code *****************************************/

		hallCode = "" + hallcode;

		try {
			getStudentData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(list.getSelectedIndex());
				viewRoom(list.getSelectedIndex());
			}

		});
	}

	private void viewRoom(int roomno) {
		student1id.setText(student1Id[roomno]);
		student2id.setText(student2Id[roomno]);
		student1name.setText(student1Name[roomno]);
		student2name.setText(student2Name[roomno]);
		Roomno.setText("" + roomNo[roomno]);
		Roomtype.setText(roomType[roomno]);
		return;
	}

	private void getStudentData() throws SQLException {
		String query = "";
		query = "SELECT * FROM `hms`.`" + hallCode + "_studentlist`";
		ResultSet rs = resultQuery(query);
		rs.last();
		roomCount = rs.getRow();
		student1Name = new String[roomCount];
		student2Name = new String[roomCount];
		student1Id = new String[roomCount];
		student2Id = new String[roomCount];
		roomNo = new int[roomCount];
		roomType = new String[roomCount];
		rs.beforeFirst();
		rs.next();
		int i = 0;
		for (i = 0; i <= roomCount - 1; i++) {
			student1Name[i] = rs.getString("student1name");
			student2Name[i] = rs.getString("student2name");
			student1Id[i] = rs.getString("student1id");
			student2Id[i] = rs.getString("student2id");
			roomNo[i] = (int) (Integer.parseInt(rs.getString("roomno")));
			roomType[i] = rs.getString("type");
			rs.next();
		}
		list.setModel(new AbstractListModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			int[] values = roomNo;

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}

	private ResultSet resultQuery(String query) {
		Connection con = null;
		try {
			String url ="jdbc:mysql://"+bridge.getHost()+":"+bridge.getPort()+"/hms";
			System.out.println(url);
			System.out.println("user = "+bridge.getUser()+" pass = "+bridge.getPass());
			con = DriverManager.getConnection(url,bridge.getUser(), bridge.getPass());
			con = DriverManager.getConnection(url, "sourav", "qwerty");
			System.out.println("connection Established");
		} catch (Exception e) {
			System.out.println("jjjjCouldnt get connection");
		}

		Statement st = null;
		ResultSet rs = null;
		try {

			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	@SuppressWarnings("unused")
	private int updateQuery(String query) {
		Connection con = null;
		int success = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Initialize the driver
			String url ="jdbc:mysql://"+bridge.getHost()+":"+bridge.getPort()+"/hms";
			con = DriverManager.getConnection(url,bridge.getUser(), bridge.getPass());
			System.out.println("connection Established");
		} catch (Exception e) {
			System.out.println("Couldnt get connection");
		}

		Statement st = null;
		try {
			st = con.createStatement();
			success = st.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

}
