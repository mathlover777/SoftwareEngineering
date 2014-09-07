import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import java.net.URL;




public class Snake extends JFrame {

	private JPanel contentPane;
	private JToggleButton turn0;
	private JToggleButton turn1;
	private JToggleButton turn2;
	private JDesktopPane Pane;
	private JLabel diceimage;
	private JButton roll;
	private JTextArea gamelog;
	private JMenuBar menuBar;
	private JMenu mnPlay;
	private JMenu mnStats;
	private JMenu mnAbout;
	private JMenuItem btnNewGame;
	private JMenuItem btnRestartGame;
	private JMenuItem mntmExit;
	private JMenuItem mntmHighestScore;
	private JMenuItem mntmHelp;
	private JMenuItem mntmAboutMe;
	private JLabel[] rooms;
	private JDialog ng,extra;
	private JLabel Back;
	//java -Dswing.plaf.metal.controlFont=Dialog-50 Snake;
	
	/************************Game data*******************/
	private int size;
	private int playercount;
	private int lcount;
	private int scount;
	private int[] ladder;
	private int[] snake;
	private int[] check;
	private String[] players;
	private int osize;
	private int[] score;
	/***************************************************/
	
	
	/*************gameplay variables********************/
	private int chance;
	private int pos[];
	/**************************************************/
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Snake frame = new Snake();
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
	public Snake() {
		
		
		 UIManager.put("Label.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));
		 UIManager.put("Button.font", new FontUIResource(new Font("Dialog", Font.BOLD, 10)));
		 UIManager.put("TextField.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));
		 UIManager.put("RadioButton.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));
		
		
		
		setResizable(false);
		setTitle("Snakes And Ladder 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 626);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPlay = new JMenu("Play");
		menuBar.add(mnPlay);
		
		btnNewGame = new JMenuItem("New Game");
		mnPlay.add(btnNewGame);
		
		btnRestartGame = new JMenuItem("Restart Game");
		mnPlay.add(btnRestartGame);
		
		mntmExit = new JMenuItem("Exit");
		mnPlay.add(mntmExit);
		
		mnStats = new JMenu("Stats");
		menuBar.add(mnStats);
		
		mntmHighestScore = new JMenuItem("Highest Score");
		mnStats.add(mntmHighestScore);
		
		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		mntmHelp = new JMenuItem("Help");
		mnAbout.add(mntmHelp);
		
		mntmAboutMe = new JMenuItem("About Me");
		mnAbout.add(mntmAboutMe);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		
		
		
		
		Pane = new JDesktopPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, Pane, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, Pane, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Pane, 520, SpringLayout.NORTH, contentPane);
		contentPane.add(Pane);
		
		
		
		
		
		
		diceimage = new JLabel("");
		diceimage.setIcon(new ImageIcon(Snake.class.getResource("dice.png")));
		sl_contentPane.putConstraint(SpringLayout.NORTH, diceimage, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, diceimage, 26, SpringLayout.EAST, Pane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, diceimage, 126, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, diceimage, -29, SpringLayout.EAST, contentPane);
		diceimage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(diceimage);
		
		roll = new JButton("Roll");
		sl_contentPane.putConstraint(SpringLayout.NORTH, roll, 37, SpringLayout.SOUTH, diceimage);
		sl_contentPane.putConstraint(SpringLayout.WEST, roll, 0, SpringLayout.WEST, diceimage);
		sl_contentPane.putConstraint(SpringLayout.EAST, roll, -29, SpringLayout.EAST, contentPane);
		contentPane.add(roll);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 210, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 688, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -5, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, Pane, -6, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, roll, -11, SpringLayout.NORTH, scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		JLabel lblGameLog = new JLabel("Game Log");
		lblGameLog.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblGameLog);
		
		gamelog = new JTextArea();
		scrollPane.setViewportView(gamelog);
		gamelog.setLineWrap(true);
		gamelog.setEditable(false);
		gamelog.setText("Click on play->new game to start a new game ,,,");
		
		turn0 = new JToggleButton("Player 1's Turn");
		sl_contentPane.putConstraint(SpringLayout.NORTH, turn0, 6, SpringLayout.SOUTH, Pane);
		sl_contentPane.putConstraint(SpringLayout.WEST, turn0, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, turn0, 0, SpringLayout.SOUTH, contentPane);
		turn0.setForeground(Color.LIGHT_GRAY);
		turn0.setEnabled(false);
		contentPane.add(turn0);
		
		turn1 = new JToggleButton("Player 2's Turn");
		sl_contentPane.putConstraint(SpringLayout.EAST, turn0, -6, SpringLayout.WEST, turn1);
		sl_contentPane.putConstraint(SpringLayout.WEST, turn1, 233, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, turn1, 6, SpringLayout.SOUTH, Pane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, turn1, 0, SpringLayout.SOUTH, contentPane);
		turn1.setForeground(Color.LIGHT_GRAY);
		turn1.setEnabled(false);
		contentPane.add(turn1);
		
		turn2 = new JToggleButton("Player 3's Turn");
		sl_contentPane.putConstraint(SpringLayout.EAST, turn1, -6, SpringLayout.WEST, turn2);
		sl_contentPane.putConstraint(SpringLayout.WEST, turn2, 458, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, turn2, 6, SpringLayout.SOUTH, Pane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, turn2, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, turn2, 0, SpringLayout.EAST, Pane);
		turn2.setForeground(Color.LIGHT_GRAY);
		turn2.setEnabled(false);
		contentPane.add(turn2);
		
		
		/**********************initialisation code************************/
		ladder=new int[144];
		snake=new int[144];
		check=new int[144];
		rooms=new JLabel[144];
		players=new String[3];
		pos=new int[3];
		for(int i=0;i<=143;i++){
			rooms[i]=new JLabel();
			rooms[i].setOpaque(true);
			rooms[i].setText(""+i);
			rooms[i].setBorder(new BevelBorder(BevelBorder.LOWERED,null,null,null,null));
			rooms[i].setBackground(Color.RED);
			rooms[i].setForeground(Color.YELLOW);
			//Pane.add(rooms[i]);
		}
		osize=0;
		chance=0;
		roll.setEnabled(false);
		score=new int[3];
		btnRestartGame.setEnabled(false);
		/*************************************************************/
		
		
		/*****************Action Listeners*************************/
		
		/**************MenuBar Code*************************/
		btnNewGame.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ng=new NewGame();
					ng.setVisible(true);
					if(((NewGame) ng).getbeginnew()==true){
						/********
						private int size;
						private int playercount;
						private int lcount;
						private int scount;
						private int[] ladder;
						private int[] snake;
						private int[] check;
						private String[] players;
						*/////////
						/**************getting the new game data*****************/
						size=((NewGame)ng).getsize();
						playercount=((NewGame)ng).getplayercount();
						lcount=((NewGame)ng).getlcount();
						scount=((NewGame)ng).getscount();
						((NewGame)ng).getboarddata(snake, ladder, check);
						((NewGame)ng).getplayernames(players);
						/*************printing the tabledata***************/
						for(int i=0;i<=size*size-1;i++){
							//System.out.printf("\ns[%d]=%d l[%d]=%d c[%d]=%d",i,snake[i],i,ladder[i],i,check[i]);
						}
						StartNewGame();
					}
				}
				
			}
		);
		btnRestartGame.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Restart();
				}
				
			}
		);
		mntmExit.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			}
		);
		mntmHighestScore.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						extra=new Highest();
						extra.setVisible(true);
					}
					
				}
			);
		mntmHelp.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						extra=new Help();
						extra.setVisible(true);
					}
					
				}
			);
		mntmAboutMe.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						extra=new AboutMe();
						extra.setVisible(true);
					}
					
				}
			);
		/****************misc codes*****************/
		//diceimage.setIcon(new ImageIcon("ladderhead.png"));
		
		
		/***************************Game events*******************************/
		roll.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int jump;
					Random r=new Random();
					jump=r.nextInt(6)+1;
					switch(jump){
					case 1:{
						diceimage.setIcon(new ImageIcon(Snake.class.getResource("dice1.png")));
						break;
					}
					case 2:{
						diceimage.setIcon(new ImageIcon(Snake.class.getResource("dice2.png")));
						break;
					}
					case 3:{
						diceimage.setIcon(new ImageIcon(Snake.class.getResource("dice3.png")));
						break;
					}
					case 4:{
						diceimage.setIcon(new ImageIcon(Snake.class.getResource("dice4.png")));
						break;
					}
					case 5:{
						diceimage.setIcon(new ImageIcon(Snake.class.getResource("dice5.png")));
						break;
					}
					case 6:{
						diceimage.setIcon(new ImageIcon(Snake.class.getResource("dice6.png")));
						break;
					}
					}
					score[chance]++;
					if(pos[chance]+jump>=size*size){
						gamelog.setText(gamelog.getText()+"\nOverflow!!");
					}
					else{
						rooms[pos[chance]].setBackground(Color.RED);
						if(pos[chance]==0){
							rooms[pos[chance]].setBackground(Color.GRAY);
						}
						pos[chance]=pos[chance]+jump;
						gamelog.setText(gamelog.getText()+"\n"+players[chance]+" moved to "+pos[chance]);
					
						if((size*size-1-pos[chance])<=6&&(size*size-1-pos[chance])>0){
							JDialog m=new message("Come On "+players[chance]+"\nOnly "+(size*size-1-pos[chance])
									+" positions to GO !!");
							 m.setVisible(true);
						}
					}
					if(snake[pos[chance]]!=-1){
						pos[chance]=snake[pos[chance]];
						gamelog.setText(gamelog.getText()+"\n"+players[chance]+" caught by snake Sending to "+pos[chance]);
						
						JDialog m=new message(players[chance]+" Caught By Snake :P");
						 m.setVisible(true);
					
					}
					if(ladder[pos[chance]]!=-1){
						pos[chance]=ladder[pos[chance]];
						gamelog.setText(gamelog.getText()+"\n"+players[chance]+" got a ladder Sending to "+pos[chance]);
					
						JDialog m=new message(players[chance]+" Got A Ladder !!");
						 m.setVisible(true);
					
					
					}
					/**************drawing players**********************/
					drawplayers();
					/**********************/
					if(pos[chance]==size*size-1){
						diceimage.setIcon(new ImageIcon(Snake.class.getResource("dice.png")));
						gamelog.setText(gamelog.getText()+"\n"+players[chance]+" WON !!");
						turn0.setSelected(false);
						turn0.setForeground(Color.LIGHT_GRAY);
						turn1.setSelected(false);
						turn1.setForeground(Color.LIGHT_GRAY);
						turn2.setSelected(false);
						turn2.setForeground(Color.LIGHT_GRAY);
						roll.setEnabled(false);
						//System.out.println("winner="+players[chance]+" score="+score[chance]);
						JDialog m=new message(players[chance]+" Won The Game !!"+"\nscore = "+score[chance]);
						 m.setVisible(true);
						try {
							highestScoreUpdate(players[chance],score[chance]);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
					}
					else{
						chance++;
						chance=chance%playercount;
						turn0.setForeground(Color.LIGHT_GRAY);
						turn0.setSelected(false);
						turn1.setForeground(Color.LIGHT_GRAY);
						turn1.setSelected(false);
						turn2.setForeground(Color.LIGHT_GRAY);
						turn2.setSelected(false);

						switch(chance){
							case 0:{
								turn0.setForeground(Color.red);
								turn0.setSelected(true);
								
								break;
							}
							case 1:{
								turn1.setForeground(Color.red);
								turn1.setSelected(true);
								
								break;
							}
							case 2:{
								turn2.setForeground(Color.red);
								turn2.setSelected(true);
								
								break;
							}
						}
					}
				}
			}
		);
		
		
		Back=new JLabel();
		Back.setIcon(new ImageIcon(Snake.class.getResource("back.png")));
		Pane.setLayout(new GridLayout(1, 1, 0,0 ));
		Pane.add(Back);
	}
	
	
	public void StartNewGame(){
		Pane.remove(Back);
		diceimage.setIcon(new ImageIcon(Snake.class.getResource("dice.png")));
		gamelog.setText("Beginning New Game...!!");
		score[0]=score[1]=score[2]=0;
		chance=0;
		roll.setEnabled(true);
		turn0.setForeground(Color.RED);
		turn0.setSelected(true);
		turn1.setForeground(Color.LIGHT_GRAY);
		turn1.setSelected(false);
		turn2.setForeground(Color.LIGHT_GRAY);
		turn2.setSelected(false);
		btnRestartGame.setEnabled(true);
		if(playercount==1){
			turn0.setText(players[0]+"'s Turn");
		}
		if(playercount==2){
			turn0.setText(players[0]+"'s Turn");
			turn1.setText(players[1]+"'s Turn");
		}
		if(playercount==3){
			turn0.setText(players[0]+"'s Turn");
			turn1.setText(players[1]+"'s Turn");
			turn2.setText(players[2]+"'s Turn");
		}
		pos[0]=pos[1]=pos[2]=0;
		if(osize!=0){
			for(int i=0;i<=osize*osize-1;i++){
				//clearing the old board if it is there
				Pane.remove(rooms[osize*osize-i-1]);
				rooms[i].setIcon(null);
			}
			rooms[osize*osize-1].setText(""+(osize*osize-1));
			rooms[osize*osize-1].setForeground(Color.YELLOW);
			rooms[osize*osize-1].setBackground(Color.RED);
		}
		//adding the snake images and the ladder images
		for(int i=0;i<=size*size-1;i++){
			rooms[i].setBackground(Color.RED);
			if(snake[i]!=-1){
				rooms[i].setIcon(new ImageIcon(Snake.class.getResource("snakehead.png")));
				rooms[snake[i]].setIcon(new ImageIcon(Snake.class.getResource("snaketail.png")));
			}
			if(ladder[i]!=-1){
				rooms[i].setIcon(new ImageIcon(Snake.class.getResource("ladderhead.png")));
				rooms[ladder[i]].setIcon(new ImageIcon(Snake.class.getResource("laddertail.png")));
			}
		}
		rooms[0].setBackground(Color.GRAY);
		rooms[0].setText("Start");
		rooms[size*size-1].setBackground(Color.ORANGE);
		rooms[size*size-1].setForeground(Color.black);
		rooms[size*size-1].setText("FINISH");
		osize=size;
		Pane.setLayout(new GridLayout(size, size, 0,0 ));
		for(int i=0;i<=size*size-1;i++){
			Pane.add(rooms[size*size-i-1]);
		}
		Pane.revalidate();
		Pane.repaint();
	}
	public void Restart(){
		StartNewGame();
	}
	public void drawplayers(){
		if(playercount==3){
			rooms[pos[0]].setBackground(Color.CYAN);
			rooms[pos[1]].setBackground(Color.BLUE);
			rooms[pos[2]].setBackground(Color.GREEN);
		}
		if(playercount==2){
			rooms[pos[0]].setBackground(Color.CYAN);
			rooms[pos[1]].setBackground(Color.BLUE);
		}
		if(playercount==1){
			rooms[pos[0]].setBackground(Color.CYAN);
		}
	}
	
	
	public void highestScoreUpdate(String name,int t) throws IOException{
		
		//System.out.println("in highest Winner="+name+" score="+t);
		
		int flag=0,past=0,newplayer=0;
		JDialog p;
		createEmptyFile("temp.txt");
		FileInputStream fstream = new FileInputStream("score"+size+".txt");
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		
		while(strLine!=null){
			addLine("temp.txt",strLine);
			if(strLine.equals(name)){
				newplayer=1;
				strLine=br.readLine();
				if(t<stringToInt(strLine)){
					past=stringToInt(strLine);
					flag=1;
					addLine("temp.txt",""+t);
				}else{
					addLine("temp.txt",strLine);
				}
			}
			else{
				addLine("temp.txt",br.readLine());
			}
			strLine=br.readLine();
		}
		if(flag==1){
			p=new message(name+" broke \nhis/her previous \nHighest Score !!" +
					"\nNew Personal Best="+t+"\n[old best = "+past);
			p.setVisible(true);
		}
		br.close();
		in.close();
		fstream.close();
		if(newplayer==0){
			p=new message(name+"'s First Win !!! \nScore = "+t);
			p.setVisible(true);
			addLine("score"+size+".txt",name);
			addLine("score"+size+".txt",""+t);
		}else{
			copyToFile("temp.txt","score"+size+".txt");
		}
		
	}
	
	
	public static void copyToFile(String file1,String file2) throws IOException{
		FileInputStream f1=new FileInputStream(file1);
		FileOutputStream f2=new FileOutputStream(file2);
		int i;
		char c=0;
		i=f1.read();
		while(i!=-1){
			f2.write(i);
			i=f1.read();
		}
		f1.close();
		f2.close();
	}
	
	
	public static void addLine(String file,String line) throws IOException{
		FileInputStream f1=new FileInputStream(file);
		FileWriter f2=new FileWriter("tempa.txt");
		BufferedWriter out = new BufferedWriter(f2);
		int i;
		i=f1.read();
		int c=0;
		if(i==-1){
			c=1;
		}
		while(i!=-1){
			out.write((char)i);
			i=f1.read();
		}
		if(c==0){
			out.write("\r\n"+line);
		}
		if(c==1){
			out.write(line);
		}
		out.close();
		f1.close();
		copyToFile("tempa.txt",file);
	}
	
	public boolean createEmptyFile(String filename) throws IOException{
		FileWriter f2=new FileWriter(filename);
		BufferedWriter out = new BufferedWriter(f2);
		out.close();
		f2.close();
		return true;
	}
	public int stringToInt(String s){
		int n=0;
		for(int i=0;i<=s.length()-1;i++){
			n=n*10+(s.charAt(i))-48;
		}
		return n;
	}
}
