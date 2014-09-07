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


public class Help extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Help() {
		setResizable(false);
		setTitle("Help");
		setModal(true);
		setBounds(100, 100, 582, 463);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 13, 552, 374);
			contentPanel.add(scrollPane);
			{
				JTextArea txtrThisIsA = new JTextArea();
				txtrThisIsA.setText("This is a normal Snakes and ladder games so Standard Rules apply\r\n\r\nnote:\r\nto add snake from 34 to 14\r\nenter \"34,14\" press enter\r\n\r\ncant add snake from lower cell to higher cell \r\nand opposite for ladders");
				txtrThisIsA.setLineWrap(true);
				txtrThisIsA.setEditable(false);
				scrollPane.setViewportView(txtrThisIsA);
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
