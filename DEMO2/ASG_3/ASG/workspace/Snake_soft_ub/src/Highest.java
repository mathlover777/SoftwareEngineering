import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;


public class Highest extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JComboBox select;
	private JTextArea scores;
	
	
	
	private int selected=0;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Highest() {
		setModal(true);
		setTitle("Highest Score");
		setBounds(100, 100, 497, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSelectSize = new JLabel("Select Size :");
			lblSelectSize.setBounds(12, 13, 113, 14);
			contentPanel.add(lblSelectSize);
		}
		{
			select = new JComboBox();
			select.setModel(new DefaultComboBoxModel(new String[] {"Select", "5", "6", "7", "8", "9", "10", "11", "12"}));
			select.setBounds(135, 10, 68, 20);
			contentPanel.add(select);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 40, 435, 263);
		contentPanel.add(scrollPane);
		{
			scores = new JTextArea();
			scores.setEditable(false);
			scrollPane.setViewportView(scores);
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
		
		
		
		
		select.addItemListener(
			new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					selected=select.getSelectedIndex()+5;
					if(selected>5){
						try {
							showScores(selected-1);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else{
						scores.append("Select Size to View Highest scores");
					}
				}
				
			}
		);
	}
	
	
	private void showScores(int i) throws IOException{
		scores.setText("");
		String filename="score"+i+".txt";
		FileInputStream fstream = new FileInputStream(filename);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		int count=1;
		while(strLine!=null){
			scores.append("\n"+count+"> name= "+strLine+"\nScore = ");
			strLine=br.readLine();
			scores.append(strLine);
			strLine=br.readLine();
			count++;
		}
		br.close();
		in.close();
		fstream.close();
	}
	
}
