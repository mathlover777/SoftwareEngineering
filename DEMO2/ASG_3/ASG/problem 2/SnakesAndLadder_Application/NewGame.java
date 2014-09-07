import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.FontUIResource;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;


public class NewGame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField sCommand;
	private JTextField lCommand;
	private JTextField name1;
	private JButton xx;
	private JButton cancelButton;
	private JTextField name2;
	private JTextField name3;
	private ButtonGroup group;
	private JRadioButton Default;
	private JRadioButton Complete;
	private JRadioButton SizeOnly;
	
	
	private boolean beginnew;
	
	
	/****************config variables**********************/
	private int csize;
	private int cplayercount;
	private int clcount;
	private int cscount;
	private int[] cladder;
	private int[] csnake;
	private int[] ccheck;
	private String[] cplayers;
	private JComboBox size;
	private JSpinner spinner_s;
	private JSpinner spinner_l;
	private JTextArea log;
	private int sin;
	private int lin;
	private boolean playdefault;
	private boolean onlysize,total;
	private JButton create;
	private JButton reset;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			NewGame dialog = new NewGame(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewGame() {
		setModal(true);
		//setAlwaysOnTop(true);
		setTitle("New Game");
		setResizable(false);
		setBounds(100, 100, 599, 651);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 225, 560, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblSelectSize = new JLabel("Select Size :");
			lblSelectSize.setBounds(10, 234, 79, 14);
			contentPanel.add(lblSelectSize);
		}
		
		size = new JComboBox();
		size.setModel(new DefaultComboBoxModel(new String[] {"5", "6", "7", "8", "9", "10", "11", "12"}));
		size.setSelectedIndex(3);
		size.setBounds(96, 233, 52, 17);
		contentPanel.add(size);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 259, 560, 2);
		contentPanel.add(separator);
		
		JLabel lblSelectNumberOf = new JLabel("Select Number of Snakes  :");
		lblSelectNumberOf.setBounds(10, 272, 183, 14);
		contentPanel.add(lblSelectNumberOf);
		
		spinner_s = new JSpinner();
		spinner_s.setModel(new SpinnerNumberModel(4, 0, 10, 1));
		spinner_s.setBounds(254, 269, 52, 20);
		contentPanel.add(spinner_s);
		
		JLabel lblSelectNumberOf_1 = new JLabel("Select Number of Ladders :");
		lblSelectNumberOf_1.setBounds(10, 303, 183, 14);
		contentPanel.add(lblSelectNumberOf_1);
		
		spinner_l = new JSpinner();
		spinner_l.setModel(new SpinnerNumberModel(4, 0, 10, 1));
		spinner_l.setBounds(254, 300, 52, 20);
		contentPanel.add(spinner_l);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 331, 560, 2);
		contentPanel.add(separator_1);
		
		JLabel lblEnterCommandFor = new JLabel("Enter Command For Snakes :");
		lblEnterCommandFor.setBounds(10, 432, 198, 14);
		contentPanel.add(lblEnterCommandFor);
		
		sCommand = new JTextField();
		sCommand.setBounds(10, 457, 230, 20);
		contentPanel.add(sCommand);
		sCommand.setColumns(10);
		
		JLabel lblEnterCommandFor_1 = new JLabel("Enter Command for Ladders :");
		lblEnterCommandFor_1.setBounds(14, 498, 230, 14);
		contentPanel.add(lblEnterCommandFor_1);
		
		lCommand = new JTextField();
		lCommand.setBounds(10, 523, 230, 20);
		contentPanel.add(lCommand);
		lCommand.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(254, 432, 316, 108);
		contentPanel.add(scrollPane);
		
		log = new JTextArea();
		log.setLineWrap(true);
		scrollPane.setViewportView(log);
		
		Default = new JRadioButton("Play With Default Settings");
		Default.setBounds(10, 176, 171, 23);
		contentPanel.add(Default);
		
		SizeOnly = new JRadioButton("Only Configure Size and Number of snakes and ladders");
		SizeOnly.setBounds(197, 176, 373, 23);
		contentPanel.add(SizeOnly);
		
		Complete = new JRadioButton("Customize Completely");
		Complete.setBounds(10, 202, 198, 23);
		contentPanel.add(Complete);
		
		JLabel lblEnterNumberOf = new JLabel("Enter Number Of Players :");
		lblEnterNumberOf.setBounds(10, 11, 198, 23);
		contentPanel.add(lblEnterNumberOf);
		
		final JComboBox playercount = new JComboBox();
		playercount.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		playercount.setSelectedIndex(1);
		playercount.setBounds(298, 11, 52, 22);
		contentPanel.add(playercount);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 167, 560, 2);
		contentPanel.add(separator_2);
		
		JLabel lblNameOfPlayer = new JLabel("Name Of Player 1:");
		lblNameOfPlayer.setBounds(10, 48, 110, 14);
		contentPanel.add(lblNameOfPlayer);
		
		JLabel lblNameOfPlayer_1 = new JLabel("Name Of Player 2:");
		lblNameOfPlayer_1.setBounds(10, 95, 110, 14);
		contentPanel.add(lblNameOfPlayer_1);
		
		JLabel lblNameOfPlayer_2 = new JLabel("Name Of Player 3:");
		lblNameOfPlayer_2.setBounds(10, 140, 110, 14);
		contentPanel.add(lblNameOfPlayer_2);
		
		name1 = new JTextField();
		name1.setBounds(174, 45, 220, 23);
		contentPanel.add(name1);
		name1.setColumns(10);
		
		name2 = new JTextField();
		name2.setBounds(174, 92, 220, 23);
		contentPanel.add(name2);
		name2.setColumns(10);
		
		name3 = new JTextField();
		name3.setBounds(174, 135, 220, 23);
		contentPanel.add(name3);
		name3.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			xx = new JButton("Play");
			buttonPane.add(xx);
			xx.addActionListener(
				new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						int xflag=0;
						cplayers[1]=cplayers[2]=cplayers[0]=null;
						 cplayers[0]=name1.getText();
						 cplayers[1]=name2.getText();
						 cplayers[2]=name3.getText();
						 
						 //cplayers[0]=null;
						 
						 
						 //System.out.println("player_1="+cplayers[0]);
						 
						 
						 if(cplayercount==3){
							 if(cplayers[0].equals("")||cplayers[1].equals("")||cplayers[2].equals("")) xflag=1;
						 }
						 
						 if(cplayercount==2){
							 //System.out.println("sdasasasdsd");
							 if(cplayers[0].equals("")||cplayers[1].equals("")){
								 //System.out.println("sdasasasdsd");
								 xflag=1;
							 }
						 }
						 
						 if(cplayercount==1){
							 if(cplayers[0].equals("")) xflag=1;
						 }
						 
						 
						 //System.out.println("xflag="+xflag);
						 
						 if(xflag==1){
							 JDialog m=new message("Please Enter \nPlayer Names \n To Play !!");
							 m.setVisible(true);
						 }else{
						 
							// TODO Auto-generated method stub
							//System.out.println("Completely,..");
							if((sin==cscount)&&(lin==clcount)){
								JDialog m=new message("Board \nCompletely Configured !!");
								 m.setVisible(true);
								beginnew=true;
								//System.out.println("Completely Configured,..");
								dispose();
							}
							if(playdefault){
								//System.out.println("Default game");
								JDialog m=new message("Starting Default Game !!");
								 m.setVisible(true);
								setDefault();
								beginnew=true;
								//System.out.println("Default game");
								dispose();
							}
							if(onlysize){
								
								JDialog m=new message("Positions of Snakes\n Will be Configured\n Automatically!!");
								 m.setVisible(true);
								//System.out.println("only size is set..");
								setOnlySize();
								beginnew=true;
								//System.out.println("only size is set..");
								dispose();
							}
							if(total){
								JDialog m=new message("Positions Were not\nCompletely Configured !!\nStarting Default game");
								m.setVisible(true);
								setDefault();
								beginnew=true;
								dispose();
							}
						}
					}
					
				}
			);
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(
					new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							beginnew=false;
							dispose();
						}
						
					}
				);
			}
		}
		
		
		name1.setText(null);
		name2.setText(null);
		name3.setText(null);
		
		group=new ButtonGroup();
		group.add(Default);
		group.add(SizeOnly);
		group.add(Complete);
		Default.setSelected(true);
		name1.setEditable(true);
		name2.setEditable(true);
		name3.setEditable(false);
		
		/*********************Creating the config objects************************/
		
		initialise();
		
		
		
		/***********************number of players**************/
		playercount.addItemListener(
			new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					int i=playercount.getSelectedIndex();
					if(i==0){
						name1.setEditable(true);
						name2.setEditable(false);
						name3.setEditable(false);
						cplayercount=1;
					}
					if(i==1){
						name1.setEditable(true);
						name2.setEditable(true);
						name3.setEditable(false);
						cplayercount=2;
					}
					if(i==2){
						name1.setEditable(true);
						name2.setEditable(true);
						name3.setEditable(true);
						cplayercount=3;
					}
				}
				
			}
		);
		name2.setText("");
		name3.setText("");
		/*name1.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub
					cplayers[0]=event.getActionCommand();
					name1.setText("");
					log.setText(log.getText()+"\nPlayer 1="+cplayers[0]);
				} 
				
			}
		);
		name2.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent event) {
						// TODO Auto-generated method stub
						cplayers[1]=event.getActionCommand();
						name2.setText("");
						log.setText(log.getText()+"\nPlayer 2="+cplayers[1]);
					}
					
				}
			);
		name3.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent event) {
						// TODO Auto-generated method stub
						cplayers[2]=event.getActionCommand();
						name3.setText("");
						log.setText(log.getText()+"\nPlayer 3="+cplayers[2]);
					}
					
				}
			);*/
		/**************disabling the rest*************/
		size.setEnabled(false);
		spinner_s.setEnabled(false);
		spinner_l.setEnabled(false);
		sCommand.setEditable(false);
		lCommand.setEditable(false);
		log.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 346, 560, 69);
		contentPanel.add(scrollPane_1);
		
		JTextArea txtrEnterCommandsLike = new JTextArea();
		scrollPane_1.setViewportView(txtrEnterCommandsLike);
		txtrEnterCommandsLike.setLineWrap(true);
		txtrEnterCommandsLike.setEditable(false);
		txtrEnterCommandsLike.setText("Enter Commands like 32,16---means takes from 32 to 16\r\nnote:Snake Can only take from High to Low and for Ladder vice versa\r\nat one box only one thing can be placed..i.e. one snakes tail and another ladders head\r\ncant be placed in the same box !!! and same for other combinations\r\n\r\nhave fun");
		
		JButton resetall = new JButton("Reset All");
		resetall.setBounds(481, 551, 89, 23);
		contentPanel.add(resetall);
		
		create = new JButton("Create Board");
		create.setEnabled(false);
		create.setBounds(316, 268, 117, 49);
		contentPanel.add(create);
		
		reset = new JButton("Reset");
		reset.setEnabled(false);
		reset.setBounds(443, 268, 117, 49);
		contentPanel.add(reset);
		/***********************Getting the type of the game...radio buttons.....*/
		Default.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						playdefault=true;
						onlysize=false;
						total=false;
						resetTable();
						size.setEnabled(false);
						spinner_s.setEnabled(false);
						spinner_l.setEnabled(false);
						sCommand.setEditable(false);
						lCommand.setEditable(false);
						log.setEditable(false);
						spinner_s.setValue(4);
						spinner_l.setValue(4);
						create.setEnabled(false);
					}
					
				}
		);
		SizeOnly.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						resetTable();
						playdefault=false;
						onlysize=true;
						total=false;
						size.setEnabled(true);
						spinner_s.setEnabled(true);
						spinner_l.setEnabled(true);
						sCommand.setEditable(false);
						lCommand.setEditable(false);
						log.setEditable(false);
						spinner_s.setValue(4);
						spinner_l.setValue(4);
						create.setEnabled(false);
					}
					
				}
		);
		Complete.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						resetTable();
						playdefault=false;
						onlysize=false;
						total=true;
						size.setEnabled(true);
						spinner_s.setEnabled(true);
						spinner_l.setEnabled(true);
						sCommand.setEditable(false);
						lCommand.setEditable(false);
						log.setEditable(false);
						spinner_s.setValue(4);
						spinner_l.setValue(4);
						create.setEnabled(true);
						reset.setEnabled(false);
					}
					
				}
		);
		/**************************getting the size*********************/
		size.addItemListener(
			new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					csize=size.getSelectedIndex()+5;
					//System.out.println("Csize="+csize);
				}
				
			}
		);
		
		
		/*******************get Spinner data**************************/
		spinner_s.addChangeListener(
			new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent arg0) {
					// TODO Auto-generated method stub
					cscount=(Integer)spinner_s.getValue();
				}
				
			}
		);
		spinner_l.addChangeListener(
				new ChangeListener(){

					@Override
					public void stateChanged(ChangeEvent arg0) {
						// TODO Auto-generated method stub
						clcount=(Integer)spinner_l.getValue();
					}
					
				}
			);
		
		/**********************Snake-ladder position generator*********************/
		sCommand.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//System.out.println(e.getActionCommand());
					StringToCommand(e.getActionCommand(),0);
					//if(sin==)
					sCommand.setText("");
					if(sin==cscount){
						sCommand.setEditable(false);
					}
				}
				
			}
		);
		lCommand.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						StringToCommand(e.getActionCommand(),1);
						lCommand.setText("");
						if(lin==clcount){
							lCommand.setEditable(false);
						}
					}
					
				}
			);
		
		
		/*****************************************************************************/
		create.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					create.setEnabled(false);
					spinner_s.setEnabled(false);
					spinner_l.setEnabled(false);
					size.setEnabled(false);
					reset.setEnabled(true);
					sCommand.setEnabled(true);
					lCommand.setEnabled(true);
					sCommand.setEditable(true);
					lCommand.setEditable(true);
				}
				
			}
		);
		reset.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					resetTable();
					csize=8;
					size.setSelectedIndex(3);
					spinner_s.setEnabled(true);
					spinner_l.setEnabled(true);
					size.setEnabled(true);
					create.setEnabled(true);
					reset.setEnabled(false);
					sCommand.setEnabled(false);
					lCommand.setEditable(false);
				}
				
			}
		);
		resetall.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						playdefault=true;
						onlysize=false;
						total=false;
						resetTable();
						initialise();
						size.setEnabled(false);
						spinner_s.setEnabled(false);
						spinner_l.setEnabled(false);
						sCommand.setEditable(false);
						lCommand.setEditable(false);
						log.setEditable(false);
						spinner_s.setValue(4);
						spinner_l.setValue(4);
						size.setSelectedIndex(3);
						Default.setSelected(true);
						SizeOnly.setSelected(false);
						Complete.setSelected(false);
						create.setEnabled(false);
						reset.setEnabled(false);
					}
					
				}
			);
		
		
		
		
		
	}
	
	/*
	private int csize;
	private int cplayercount;
	private int clcount;
	private int cscount;
	private int[] cladder;
	private int[] csnake;
	private int[] ccheck;
	private String[] cplayers;*/
	
	public void StringToCommand(String com,int s){
		//System.out.println(com);
		String logText="";
		char c;
		int head,tail,x,flag,y,i;
		head=-1;
		tail=-1;
		x=0;
		flag=0;
		for(i=0;i<=com.length()-1;i++){
			c=com.charAt(i);
			if(c==','){
				if(x==0){
					x++;
				}
				else{
					flag=1;
					break;
				}
				if(head==-1){
					flag=1;;
					break;
				}
			}
			else{
				y=(int)c;
				if((y>=48)||(y<=57)){
					if(x==0){
						head=0;
					}
					if(x==1){
						tail=0;
					}
				}
				else{
					flag=1;
					break;
				}
			}
		}
		if(x==0) flag=1;
		if(tail==-1) flag=1;
		if(flag==1){
			logText="Syntax error.Try Again...";
			log.setText(log.getText()+"\n"+logText);
			//System.out.println(logText);
			return;
		}
		head=0;
		tail=0;
		i=0;
		while(true){
			c=com.charAt(i);
			if(c==',') break;
			y=(int)c;
			head=head*10+y-48;
			i++;
		}
		i++;
		c=com.charAt(0);
		y=(int)c;
		while(i<com.length()){
			c=com.charAt(i);
			y=(int)c;
			tail=tail*10+y-48;
			i++;
		}
		//System.out.println("Head="+head+" tail="+tail);
		if(s==0){
			flag=addSnake(head,tail);
			if(flag==1){
				log.setText(log.getText()+"\n"+"Snake added from "+head+" to "+tail);
			}
		}
		if(s==1){
			flag=addLadder(head,tail);
			if(flag==1){
				log.setText(log.getText()+"\n"+"Ladder added from "+head+" to "+tail);
			}
		}
		if(flag==0){
			log.setText(log.getText()+"\n"+"Not Allowed..");
		}
	}
	public void initialise(){
		playdefault=true;
		onlysize=false;
		total=false;
		cplayercount=2;
		csize=8;
		clcount=4;
		cscount=4;
		csnake=new int[144];
		cladder=new int[144];
		ccheck=new int[144];
		cplayers=new String[3];
		cplayers[0]="Player 1";
		cplayers[1]="Player 2";
		cplayers[2]="Player 3";
		for(int i=0;i<=133;i++){
			cladder[i]=csnake[i]=-1;
			ccheck[i]=0;
		}
		lin=0;
		sin=0;
	}
	
	public int addSnake(int head,int tail){
		if(head==csize*csize-1){
			return 0;
		}
		if(sin==cscount){
			return 0;
		}
		if((head>csize*csize-1)||(tail>csize*csize-1)){
			return 0;
		}
		if((ccheck[head]==0)&&(ccheck[tail]==0)&&(head>tail)){
			csnake[head]=tail;
			sin++;
			ccheck[head]=1;
			ccheck[tail]=1;
			return 1;
		}
		else{
			return 0;
		}
	}
	public int addLadder(int head,int tail){
		if(head==0){
			return 0;
		}
		if(tail==csize*csize-1){
			return 0;
		}
		if(lin==clcount){
			return 0;
		}
		if((head>csize*csize-1)||(tail>csize*csize-1)){
			return 0;
		}
		if((ccheck[head]==0)&&(ccheck[tail]==0)&&(head<tail)){
			cladder[head]=tail;
			lin++;
			ccheck[head]=1;
			ccheck[tail]=1;
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public void setDefault(){
		csize=8;
		int s,l,check,head,tail,choose;
		s=l=0;
		Random r=new Random();
		while((s<cscount)&&(l<cscount)){
			head=r.nextInt(64);
			tail=r.nextInt(64);
			choose=r.nextInt(2);
			if(choose==0){
				check=addSnake(head, tail);
				if(check==1){
					s++;
					continue;
				}
			}else{
				check=addLadder(head, tail);
				if(check==1){
					l++;
					continue;
				}
			}
		}
		while(s<cscount){
			head=r.nextInt(64);
			tail=r.nextInt(64);
			check=addSnake(head, tail);
			if(check==1){
				s++;
				continue;
			}
		}
		while(l<clcount){
			head=r.nextInt(64);
			tail=r.nextInt(64);
			check=addLadder(head, tail);
			if(check==1){
				l++;
				continue;
			}
		}
	}
	public void setOnlySize(){
		//System.out.println("Size="+csize+"ladder="+clcount+"snake="+cscount);
		//csize=8;
		int s,l,check,head,tail,choose;
		//snum=8;
		//lnum=8;
		s=l=0;
		Random r=new Random();
		while((s<cscount)&&(l<cscount)){
			head=r.nextInt(csize*csize);
			tail=r.nextInt(csize*csize);
			choose=r.nextInt(2);
			if(choose==0){
				check=addSnake(head, tail);
				if(check==1){
					s++;
					continue;
				}
			}else{
				check=addLadder(head, tail);
				if(check==1){
					l++;
					continue;
				}
			}
		}
		while(s<cscount){
			head=r.nextInt(csize*csize);
			tail=r.nextInt(csize*csize);
			check=addSnake(head, tail);
			if(check==1){
				s++;
				continue;
			}
		}
		while(l<clcount){
			head=r.nextInt(csize*csize);
			tail=r.nextInt(csize*csize);
			check=addLadder(head, tail);
			if(check==1){
				l++;
				continue;
			}
		}
	}
	
	public void resetTable(){
		for(int i=0;i<=143;i++){
			cladder[i]=csnake[i]=-1;
			ccheck[i]=0;
		}
		sin=lin=0;
		return;
	}
	/**************************Get Methods****************************************/
	public int getplayercount(){
		return cplayercount;
	}
	public boolean getbeginnew(){
		return beginnew;
	}
	public int getsize(){
		//System.out.println("csize="+csize);
		return csize;
	}
	public int getscount(){
		return cscount;
	}
	public int getlcount(){
		return clcount;
	}
	public void getboarddata(int[] sdata,int[] ldata,int[] cdata){
		for(int i=0;i<=143;i++){
			sdata[i]=csnake[i];
			ldata[i]=cladder[i];
			cdata[i]=ccheck[i];
		}
		return;
	}
	public void getplayernames(String[] players){
		//System.out.println("player 1="+cplayers[0]);
		//System.out.println("player 2="+cplayers[1]);
		//System.out.println("player 3="+cplayers[2]);
		players[0]=""+cplayers[0];
		players[1]=""+cplayers[1];
		players[2]=""+cplayers[2];
		return;
	}
}
