import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Font;


public class message extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea box;
	private JButton ok;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			message dialog = new message("This is \n Your Message !!!");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public message(String Message) {
		setResizable(false);
		setModal(true);
		setTitle("Message");
		setBounds(100, 100, 395, 254);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 369, 171);
		contentPanel.add(scrollPane);
		
		box = new JTextArea();
		box.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 30));
		box.setEditable(false);
		box.setLineWrap(true);
		scrollPane.setViewportView(box);
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
		}
		
		box.setText(Message);
		
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
