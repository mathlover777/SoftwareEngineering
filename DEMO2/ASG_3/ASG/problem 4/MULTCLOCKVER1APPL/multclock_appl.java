import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;




public class multclock_appl extends JApplet {

	/**
	 * Create the applet.
	 */

	
	private JPanel contentPane;
	private JDesktopPane[] pane;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultClock frame = new MultClock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	private clock[] c;
	private JPanel panel;
	private int[] cid;
	
	private int id1,id2;
	
	public multclock_appl() {
		//(false);
		
		
		try {
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
		}
		
		
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
		
		pane=new JDesktopPane[6];
		
		
		
		pane[0] = new JDesktopPane();
		pane[0].setBounds(12, 13, 298, 295);
		panel.add(pane[0]);
		
		pane[1] = new JDesktopPane();
		pane[1].setBounds(357, 13, 298, 295);
		panel.add(pane[1]);
		
		pane[2] = new JDesktopPane();
		pane[2].setBounds(693, 13, 298, 295);
		panel.add(pane[2]);
		
		pane[3] = new JDesktopPane();
		pane[3].setBounds(12, 319, 298, 295);
		panel.add(pane[3]);
		
		pane[4] = new JDesktopPane();
		pane[4].setBounds(357, 321, 298, 295);
		panel.add(pane[4]);
		
		pane[5] = new JDesktopPane();
		pane[5].setBounds(693, 321, 298, 295);
		panel.add(pane[5]);
		
		
		
		pane[0].setLayout(new GridLayout(0,1,0,1));
		pane[1].setLayout(new GridLayout(0,1,0,1));
		pane[2].setLayout(new GridLayout(0,1,0,1));
		pane[3].setLayout(new GridLayout(0,1,0,1));
		pane[4].setLayout(new GridLayout(0,1,0,1));
		pane[5].setLayout(new GridLayout(0,1,0,1));

		
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
		
		pane[0].add(c[0]);
		pane[1].add(c[1]);
		pane[2].add(c[2]);
		pane[3].add(c[3]);
		pane[4].add(c[4]);
		pane[5].add(c[5]);
		
		cid=new int[6];
		for(int i=0;i<=5;i++){
			cid[i]=i;
		}
		
		Handlerclass handler=new Handlerclass();
		panel.addMouseListener(handler);
		panel.addMouseMotionListener(handler);
		
		
		
	}
	
	
	private class Handlerclass implements MouseListener,MouseMotionListener{
		public void mouseClicked(MouseEvent event){

		}
		public void mousePressed(MouseEvent event){			
			id1=getRegionId(event.getX(),event.getY());
		}
		public void mouseReleased(MouseEvent event){
			panel.setBackground(new Color(139, 0, 0));
			id2=getRegionId(event.getX(),event.getY());
			if(id1!=-1&&id2!=-1&&id1!=id2){
				//System.out.println("id1="+id1+" id2= "+id2 );
				pane[id1].remove(c[cid[id1]]);
				pane[id2].remove(c[cid[id2]]);
				int t;
				t=cid[id1];
				cid[id1]=cid[id2];
				cid[id2]=t;
				pane[id1].add(c[cid[id1]]);
				pane[id2].add(c[cid[id2]]);
			}
		}
		public void mouseEntered(MouseEvent event){
		}
		public void mouseExited(MouseEvent event){
		}
		public void mouseDragged(MouseEvent event){
			panel.setBackground(Color.RED);
		}
		public void mouseMoved(MouseEvent event){
		}
	}
	
	private int getRegionId(int x,int y){
		int cx,cy;
		cx=-1;
		cy=-1;
		
		if(x>60&&x<271) cx=0;
		if(x>411&&x<620) cx=1;
		if(x>730&&x<960) cx=2;
		
		if(y>55&&y<246) cy=0;
		if(y>360&&y<557) cy=1;
		
		if(cx==-1||cy==-1) return -1;
		return cy*3+cx;
	}

}
