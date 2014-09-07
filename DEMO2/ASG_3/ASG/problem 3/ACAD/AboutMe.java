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
	private JButton okButton;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AboutMe() {
		setTitle("About Developer");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 13, 420, 211);
			contentPanel.add(scrollPane);
			{
				JTextArea txtrDevelopedBySourav = new JTextArea();
				txtrDevelopedBySourav.setText("SS Academic Course ManageMent\r\nver 1.0\r\n\r\nSourav Sarkar\r\n11CS30037\r\nIIT KHARAGPUR\r\n\r\nsouravmathlover@gmail.com\r\n");
				txtrDevelopedBySourav.setEditable(false);
				scrollPane.setViewportView(txtrDevelopedBySourav);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		okButton.addActionListener(
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
