import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;


public class setsettings extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField oldzone;
	private JTextField newname;
	private int sign=0,ghour=0,gmin=0;
	private String zonename="";
	
	
	private boolean success=false;
	private JSpinner om;
	private JSpinner oh;
	private JSpinner sh;
	private JButton save;
	private JSpinner sm;
	private JButton cancel;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public setsettings(String name,int osign,int ohour,int omin) {
		setTitle("Configure");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 335, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblOldZone = new JLabel("Old Zone :");
			lblOldZone.setBounds(10, 11, 81, 14);
			contentPanel.add(lblOldZone);
		}
		{
			oldzone = new JTextField();
			oldzone.setBackground(Color.WHITE);
			oldzone.setEditable(false);
			oldzone.setBounds(10, 36, 122, 20);
			contentPanel.add(oldzone);
			oldzone.setColumns(10);
		}
		{
			JLabel lblOldOffset = new JLabel("Old Offset :");
			lblOldOffset.setBounds(10, 97, 81, 14);
			contentPanel.add(lblOldOffset);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 84, 304, 2);
			contentPanel.add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 182, 304, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewZone = new JLabel("New Zone :");
			lblNewZone.setBounds(175, 11, 81, 14);
			contentPanel.add(lblNewZone);
		}
		{
			newname = new JTextField();
			newname.setColumns(10);
			newname.setBounds(175, 36, 122, 20);
			contentPanel.add(newname);
		}
		{
			JLabel lblNewOffset = new JLabel("New Offset :");
			lblNewOffset.setBounds(175, 97, 81, 14);
			contentPanel.add(lblNewOffset);
		}
		{
			JLabel label = new JLabel("HR");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(175, 124, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("MIN");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(236, 124, 46, 14);
			contentPanel.add(label);
		}
		
		sh = new JSpinner();
		sh.setModel(new SpinnerNumberModel(0, -11, 13, 1));
		sh.setBounds(175, 149, 51, 20);
		contentPanel.add(sh);
		
		sm = new JSpinner();
		sm.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		sm.setBounds(236, 149, 51, 20);
		contentPanel.add(sm);
		{
			JLabel label = new JLabel("HR");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(10, 124, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("MIN");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(71, 124, 46, 14);
			contentPanel.add(label);
		}
		{
			oh = new JSpinner();
			oh.setBackground(Color.WHITE);
			oh.setEnabled(false);
			oh.setBounds(10, 149, 51, 20);
			contentPanel.add(oh);
		}
		{
			om = new JSpinner();
			om.setBackground(Color.WHITE);
			om.setEnabled(false);
			om.setBounds(71, 149, 51, 20);
			contentPanel.add(om);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancel = new JButton("Cancel");
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				{
					save = new JButton("Save");
					buttonPane.add(save);
				}
				cancel.setActionCommand("Cancel");
				buttonPane.add(cancel);
			}
		}
		
		newname.setText("GMT");
		
		oldzone.setText(name);
		if(osign==0){
			oh.setValue(ohour);
		}else{
			oh.setValue(-1*ohour);
		}
		om.setValue(omin);
		
		cancel.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					success=false;
					dispose();
				}
				
			}
		);
		save.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						success=true;
						zonename=newname.getText();
						ghour=(Integer) sh.getValue();
						gmin=(Integer)sm.getValue();
						dispose();
					}
					
				}
			);
		
	}
	
	public boolean isSuccess(){
		return success;
	}
	
	public String getZoneName(){
		return zonename;
	}
	public int getSign(){
		return sign;
	}
	public int getHour(){
		return ghour;
	}
	public int getMin(){
		return gmin;
	}
}
