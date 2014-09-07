import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class AboutMe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton ok;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutMe dialog = new AboutMe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutMe() {
		setTitle("About Me");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 424, 217);
			contentPanel.add(scrollPane);
			
			JTextArea txtrDeveloppedBySourav = new JTextArea();
			txtrDeveloppedBySourav.setEditable(false);
			txtrDeveloppedBySourav.setText("Developped By\r\n\r\nSourav Sarkar\r\n11CS30037\r\n\r\nIIT Kharagpur");
			scrollPane.setViewportView(txtrDeveloppedBySourav);
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
		}
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
