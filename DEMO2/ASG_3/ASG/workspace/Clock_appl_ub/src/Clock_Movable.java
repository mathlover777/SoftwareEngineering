import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextField;


public class Clock_Movable extends JApplet {
	private JPanel contentPane;
	//private JDesktopPane[] pane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clock_Movable frame = new Clock_Movable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private clock[] c;
	private JPanel panel;
	private JDesktopPane pane;
	
	
	//private int s1,s2;
	
	private clock drag;
	
	public Clock_Movable() {
		//setResizable(false);
		
		
		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		//setTitle("Multi Clock Ver 0.1");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();//main outside Panel...
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(12, 13, 1006, 629);
		contentPane.add(panel);
		panel.setLayout(null);
		
		pane = new JDesktopPane();
		pane.setBackground(Color.WHITE);
		pane.setBounds(10, 11, 986, 607);
		panel.add(pane);
		c=new clock[6];
		c[0]=new clock();
		c[1]=new clock();
		c[2]=new clock();
		c[3]=new clock();
		c[4]=new clock();
		c[5]=new clock();
		
		
		c[0].setZoneName("KOLKATA");
		c[0].setOffset(0, 5, 30);
		c[0].setLabels();
		
		c[1].setZoneName("GMT");
		c[1].setOffset(0, 0, 0);
		c[1].setLabels();
		
		c[2].setZoneName("AMSTERDAM");
		c[2].setOffset(0, 1, 0);
		c[2].setLabels();
		
		c[3].setZoneName("HAWAI");
		c[3].setOffset(1, 10, 0);
		c[3].setLabels();
		
		c[4].setZoneName("BRISBANE");
		c[4].setOffset(0, 10, 0);
		c[4].setLabels();
		
		c[5].setZoneName("CALIFORNIA");
		c[5].setOffset(1, 8, 0);
		c[5].setLabels();
		
		pane.setLayout(new GridLayout(2, 3, 0, 0));
		for(int i=0;i<=5;i++){
			pane.add(c[i]);
		}
		c[0].addMouseListener(new MyMotionListener(0));
		c[0].addMouseMotionListener(new MyMotionListener(0));
		c[1].addMouseListener(new MyMotionListener(1));
		c[1].addMouseMotionListener(new MyMotionListener(1));
		c[2].addMouseListener(new MyMotionListener(2));
		c[2].addMouseMotionListener(new MyMotionListener(2));
		c[3].addMouseListener(new MyMotionListener(3));
		c[3].addMouseMotionListener(new MyMotionListener(3));
		c[4].addMouseListener(new MyMotionListener(4));
		c[4].addMouseMotionListener(new MyMotionListener(4));
		c[5].addMouseListener(new MyMotionListener(5));
		c[5].addMouseMotionListener(new MyMotionListener(5));
		
	}
	
	
	public class MyMotionListener implements MouseListener,MouseMotionListener{
	    private clock movingPanel;
	    private Point pt;
	    public MyMotionListener (int id) {
	        this.movingPanel =c[id];
	    }
	    @Override
	    public void mouseDragged(MouseEvent e) {
	        pt = SwingUtilities.convertPoint(movingPanel, e.getX(), e.getY(), movingPanel.getParent());
	        movingPanel.setBounds(pt.x, pt.y, movingPanel.getWidth(), movingPanel.getHeight());
	        //reDrawTable();
	    }
	     
	    @Override
	    public void mouseMoved(MouseEvent e) {
	    }
	    public void mouseClicked(MouseEvent e){

		}
		public void mousePressed(MouseEvent e){
		}
		public void mouseReleased(MouseEvent e){
		}
		public void mouseEntered(MouseEvent e){
		}
		public void mouseExited(MouseEvent e){
		}
		
	}
}