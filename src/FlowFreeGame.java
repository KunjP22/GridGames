//Name: Kunj Patel
//Date: January 15, 2021
//Purpose: Unit 6 Project - Grid Game - Flow Free

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;

public class FlowFreeGame extends JPanel implements ActionListener {
	Panel p_card;  //to hold all of the screens
	Panel card1, card2, level1, level2, level3, win, card6; //the two screens
	CardLayout cdLayout = new CardLayout ();

	
	//date
	Date now = new Date ();
	DateFormat df = DateFormat.getDateInstance ();
	String s = df.format (now);

	//progress bar to finish the game
	JProgressBar p;
	int i = 0;

	
	//final score
	int score = 0;

	
	//image for levels
	JLabel forest1;
	JLabel forest2;
	JLabel forest3;
	
	//button to finish entire game
	JButton done;

	//displays score at the end
	JLabel point;
	
	//instructions
	JLabel about;
	
	//to go back from the instructions page
	JButton back;
	
	//displays and counts moves
	JLabel move1;
	JLabel move2;
	JLabel move3;
	int count1 = 0;
	int count2 = 0;
	int count3 = 0;
	
	//keeps track of color
	int cur = 0;
	
	//keeps track of level
	int level = 1;
	
	//keeps track of which level to return to from instructions
	int page = 0;
	
	//checks if levels are complete
	boolean complete1 = false;
	boolean complete2 = false;
	boolean complete3 = false;

	//grid1
	int row1 = 5;
	int col1 = 5;
	JButton a[] = new JButton [row1 * col1];
	int a1[] [] = {{1, 0, 11, 3, 22},
			{0, 0, 0, 0, 0},
			{0, 55, 0, 0, 0},
			{33, 0, 44, 5, 0},
			{4, 0, 2, 0, 0}};

	
	//reset1
	int a2[] [] = {{1, 0, 11, 3, 22},
			{0, 0, 0, 0, 0},
			{0, 55, 0, 0, 0},
			{33, 0, 44, 5, 0},
			{4, 0, 2, 0, 0}};

	
	//answer1
	int ansa[] [] = {{1, 111, 11, 3, 22},
			{333, 333, 333, 333, 222},
			{333, 55, 555, 555, 222},
			{33, 444, 44, 5, 222},
			{4, 444, 2, 222, 222}};

	//grid2
	int row2 = 7;
	int col2 = 7;
	JButton b[] = new JButton [row2 * col2];
	int b1[] [] = {{1, 2, 3, 0, 55, 0, 0},
			{0, 0, 0, 0, 6, 0, 0},
			{0, 11, 0, 0, 0, 0, 0},
			{0, 0, 0, 44, 0, 0, 0},
			{22, 4, 0, 0, 0, 0, 0},
			{5, 33, 0, 0, 0, 66, 0},
			{0, 0, 0, 0, 0, 0, 0}};

	
	//reset2
	int b2[] [] = {{1, 2, 3, 0, 55, 0, 0},
			{0, 0, 0, 0, 6, 0, 0},
			{0, 11, 0, 0, 0, 0, 0},
			{0, 0, 0, 44, 0, 0, 0},
			{22, 4, 0, 0, 0, 0, 0},
			{5, 33, 0, 0, 0, 66, 0},
			{0, 0, 0, 0, 0, 0, 0}};

	
	//answer2
	int ansb[] [] = {{1, 2, 3, 333, 55, 555, 555},
			{111, 222, 222, 333, 6, 666, 555},
			{111, 11, 222, 333, 333, 666, 555},
			{222, 222, 222, 44, 333, 666, 555},
			{22, 4, 444, 444, 333, 666, 555},
			{5, 33, 333, 333, 333, 66, 555},
			{555, 555, 555, 555, 555, 555, 555}};

	//grid3
	int row3 = 9;
	int col3 = 9;
	JButton c[] = new JButton [row3 * col3];
	int c1[] [] = {{44, 0, 0, 0, 0, 0, 0, 0, 0},
			{6, 0, 0, 0, 0, 0, 0, 66, 0},
			{77, 0, 0, 0, 0, 0, 0, 2, 0},
			{0, 0, 3, 0, 0, 0, 0, 0, 0},
			{0, 0, 22, 44, 0, 5, 0, 0, 0},
			{0, 0, 0, 0, 0, 33, 0, 0, 0},
			{0, 0, 7, 0, 0, 0, 55, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 11, 0, 0, 0, 0, 0}};

	//reset3
	int c2[] [] = {{44, 0, 0, 0, 0, 0, 0, 0, 0},
			{6, 0, 0, 0, 0, 0, 0, 66, 0},
			{77, 0, 0, 0, 0, 0, 0, 2, 0},
			{0, 0, 3, 0, 0, 0, 0, 0, 0},
			{0, 0, 22, 44, 0, 5, 0, 0, 0},
			{0, 0, 0, 0, 0, 33, 0, 0, 0},
			{0, 0, 7, 0, 0, 0, 55, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 11, 0, 0, 0, 0, 0}};

	
	//answer3
	int ansc[] [] = {{44, 444, 444, 444, 444, 444, 444, 444, 444},
			{6, 666, 666, 666, 666, 666, 666, 66, 444},
			{77, 222, 222, 222, 222, 222, 222, 2, 444},
			{777, 222, 3, 333, 333, 333, 333, 333, 444},
			{777, 222, 22, 44, 444, 5, 555, 333, 444},
			{777, 111, 111, 111, 444, 33, 555, 333, 444},
			{777, 111, 7, 111, 444, 333, 55, 333, 444},
			{777, 1, 777, 111, 444, 333, 333, 333, 444},
			{777, 777, 777, 11, 444, 444, 444, 444, 444}};

	public FlowFreeGame() {
		p_card = new Panel ();
		p_card.setLayout (cdLayout);
		start();
		instructions();
		sel_lvl();
		level1();
		level2();
		level3();
		win();
		setLayout (new BorderLayout ());
		add ("Center", p_card);
	}

	public void start() { 
		//opening screen
		card1 = new Panel ();
		card1.setBackground (new Color(129, 199, 132));
		
		//picture and buttons
		JLabel title = new JLabel(createImageIcon("bg.png"));
		JButton play = new JButton (createImageIcon("play.png"));
		play.setOpaque(true);
		play.setBorderPainted(false);
		play.setBackground(new Color(129, 199, 132));
		play.addActionListener (this);
		play.setActionCommand ("play");
		JButton close = new JButton (createImageIcon("close.png"));
		close.setOpaque(true);
		close.setBorderPainted(false);
		close.setBackground(new Color(129, 199, 132));
		close.addActionListener (this);
		close.setActionCommand("close");
		JButton about = new JButton (createImageIcon("about.png"));
		about.setOpaque(true);
		about.setBorderPainted(false);
		about.setBackground(new Color(129, 199, 132));
		about.addActionListener (this);
		about.setActionCommand("about");
		
		card1.add (title);
		card1.add (about);
		card1.add (play);
		card1.add (close);
		p_card.add ("1", card1);
	}

	public void instructions () { 
		//instructions
		card2 = new Panel ();
		card2.setBackground (new Color(179, 229, 252));
		
		//instructions
		about = new JLabel(createImageIcon("bg1.png"));
		
		//move around instructions
		JButton next = new JButton(createImageIcon("play.png"));
		next.setOpaque(true);
		next.setBorderPainted(false);
		next.setBackground(new Color(179, 229, 252));
		next.setActionCommand ("aboutnext");
		next.addActionListener (this);
		
		//move around instructions
		back = new JButton(createImageIcon("prew.png"));
		back.setOpaque(true);
		back.setBorderPainted(false);
		back.setBackground(new Color(179, 229, 252));
		back.setActionCommand ("prev");
		back.addActionListener (this);
		
		card2.add(about);
		card2.add(back);
		card2.add(next);
		p_card.add ("2", card2);
	}

	public void sel_lvl() {
		//level select
		card6 = new Panel();
		card6.setBackground (new Color(129, 199, 132));
		
		//level size
		JLabel desc = new JLabel("| Level 1 : 5x5 | Level 2 : 7x7 | Level 3 : 9x9 |");
		desc.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		desc.setForeground(Color.WHITE);
		
		//level images
		forest1 = new JLabel(createImageIcon("forest1.jpeg"));
		forest2 = new JLabel(createImageIcon("forest2.png"));
		forest3 = new JLabel(createImageIcon("forest3.gif"));
		
		//title
		JLabel title = new JLabel(createImageIcon("select.png"));
		
		//level buttons
		JButton one = new JButton(createImageIcon("level1.png"));
		one.addActionListener(this);
		one.setActionCommand("level1");
		one.setOpaque(true);
		one.setBorderPainted(false);
		one.setBackground(new Color(129, 199, 132));
		JButton two = new JButton(createImageIcon("level2.png"));
		two.addActionListener(this);
		two.setActionCommand("level2");
		two.setOpaque(true);
		two.setBorderPainted(false);
		two.setBackground(new Color(129, 199, 132));
		JButton three = new JButton(createImageIcon("level3.png"));
		three.addActionListener(this);
		three.setActionCommand("level3");
		three.setOpaque(true);
		three.setBorderPainted(false);
		three.setBackground(new Color(129, 199, 132));
		
		//to move back from level select page
		JButton back = new JButton(createImageIcon("prew.png"));
		back.setOpaque(true);
		back.setBorderPainted(false);
		back.setBackground(new Color(129, 199, 132));
		back.setActionCommand ("home");
		back.addActionListener (this);
		
		//checks if all 3 levels are complete
		done = new JButton(createImageIcon("alldone1.png"));
		done.setOpaque(true);
		done.setBorderPainted(false);
		done.setBackground(new Color(129, 199, 132));
		done.setActionCommand ("no");
		done.addActionListener (this);
		
		//progress bar for game completion
		p = new JProgressBar (0, 0, 100);
		p.setValue (0);
		p.setStringPainted (true);
		
		
		card6.add(title);
		card6.add(desc);
		card6.add(forest1);
		card6.add(forest2);
		card6.add(forest3);
		card6.add(one);
		card6.add(two);
		card6.add(three);
		card6.add(back);
		card6.add (p);
		card6.add(done);
		p_card.add ("6", card6);
	}

	public void level1() {
		//level 1 is set up.
		level1 = new Panel ();
		level1.setBackground (new Color(129, 199, 132));
		
		//title game 1
		JLabel title = new JLabel ("The Jungle");
		title.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		title.setForeground(Color.BLACK);
		
		//reset game 1
		JButton reset = new JButton (createImageIcon("reset1.png"));
		reset.setBorderPainted(false);
		reset.setBackground(Color.white);
		reset.setActionCommand ("reset1");
		reset.addActionListener (this);
		
		//instructions
		JButton faq = new JButton (createImageIcon("faq1.png"));
		faq.setBorderPainted(false);
		faq.setBackground(Color.white);
		faq.setActionCommand ("faq1");
		faq.addActionListener (this);
		
		//checks if game is complete
		JButton check = new JButton (createImageIcon("ok1.png"));
		check.setBorderPainted(false);
		check.setBackground(Color.white);
		check.setActionCommand ("check1");
		check.addActionListener (this);
		
		//move counter game 1
		move1 = new JLabel("Moves: "+ count1);
		move1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		
		//exit
		JButton leave = new JButton(createImageIcon("dot.png"));
		leave.setBorderPainted(false);
		leave.setBackground(Color.white);
		leave.setActionCommand ("leave");
		leave.addActionListener (this);

		//Set up grid for level 1
		Panel p = new Panel (new GridLayout (row1, col1));
		int move = 0;
		for (int i = 0 ; i < row1 ; i++) {
			for (int j = 0 ; j < col1 ; j++) {
				a [move] = new JButton (createImageIcon ("j"+a1[i][j] + ".png"));
				a [move].setPreferredSize (new Dimension (90, 90));
				a [move].addActionListener (this);
				a [move].setActionCommand ("" + move);
				p.add (a [move]);
				move++;
			}
		}
		
		level1.add (title);
		level1.add (p);
		level1.add(reset);
		level1.add(check);
		level1.add(faq);
		level1.add(leave);
		level1.add(move1);
		p_card.add ("one", level1);
	}

	public void level2() {
		//level 2 is set up.
		level2 = new Panel ();
		level2.setBackground (new Color(129, 199, 132));
		JLabel title = new JLabel ("The Jungle");
		
		//title game 2
		title.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		title.setForeground(Color.BLACK);
		
		//reset game 2
		JButton reset = new JButton (createImageIcon("reset1.png"));
		reset.setBorderPainted(false);
		reset.setBackground(Color.white);
		reset.setActionCommand ("reset2");
		reset.addActionListener (this);
		
		//instructions
		JButton faq = new JButton (createImageIcon("faq1.png"));
		faq.setBorderPainted(false);
		faq.setBackground(Color.white);
		faq.setActionCommand ("faq2");
		faq.addActionListener (this);
		
		//check game 2
		JButton check = new JButton (createImageIcon("ok1.png"));
		check.setBorderPainted(false);
		check.setBackground(Color.white);
		check.setActionCommand ("check2");
		check.addActionListener (this);
		
		//moves counter game 2
		move2 = new JLabel("Moves: "+ count2);
		move2.setFont(new Font("Times New Roman", Font.BOLD, 35));
		
		//exit
		JButton leave = new JButton(createImageIcon("dot.png"));
		leave.setBorderPainted(false);
		leave.setBackground(Color.white);
		leave.setActionCommand ("leave");
		leave.addActionListener (this);

		//Set up grid for level 2
		Panel p = new Panel (new GridLayout (row2, col2));
		int move = 0;
		for (int i = 0 ; i < row2 ; i++) {
			for (int j = 0 ; j < col2 ; j++) {
				b [move] = new JButton (createImageIcon ("p" + b1[i][j] + ".png"));
				//adds color to the images
				if(b1[i][j]==1 || b1[i][j]==11) {
					b[move].setOpaque(true);
					b[move].setBorderPainted(false);
					b[move].setBackground(Color.BLUE);
				}
				else if(b1[i][j]==2 || b1[i][j]==22) {
					b[move].setOpaque(true);
					b[move].setBorderPainted(false);
					b[move].setBackground(Color.GREEN);
				}
				else if(b1[i][j]==3 || b1[i][j]==33) {
					b[move].setOpaque(true);
					b[move].setBorderPainted(false);
					b[move].setBackground(Color.RED);
				}
				else if(b1[i][j]==4 || b1[i][j]==44) {
					b[move].setOpaque(true);
					b[move].setBorderPainted(false);
					b[move].setBackground(Color.YELLOW);
				}
				else if(b1[i][j]==5 || b1[i][j]==55) {
					b[move].setOpaque(true);
					b[move].setBorderPainted(false);
					b[move].setBackground(Color.CYAN);
				}
				else if(b1[i][j]==6 || b1[i][j]==66) {
					b[move].setOpaque(true);
					b[move].setBorderPainted(false);
					b[move].setBackground(Color.MAGENTA);
				}
				b [move].setPreferredSize (new Dimension (60, 60));
				b [move].addActionListener (this);
				b [move].setActionCommand ("" + move);
				p.add (b [move]);
				move++;
			}
		}
		
		level2.add (title);
		level2.add (p);
		level2.add(reset);
		level2.add(check);
		level2.add(faq);
		level2.add(leave);
		level2.add(move2);
		p_card.add ("two", level2);
	}

	public void level3() {
		//level 3 is set up.
		level3 = new Panel ();
		level3.setBackground (new Color(129, 199, 132));
		
		//title game 3
		JLabel title = new JLabel ("The Jungle");
		title.setFont(new Font("Times New Roman", Font.ITALIC, 33));
		title.setForeground(Color.BLACK);
		
		//reset game 3
		JButton reset = new JButton (createImageIcon("reset1.png"));
		reset.setBorderPainted(false);
		reset.setBackground(Color.white);
		reset.setActionCommand ("reset3");
		reset.addActionListener (this);
		
		//instructions
		JButton faq = new JButton (createImageIcon("faq1.png"));
		faq.setBorderPainted(false);
		faq.setBackground(Color.white);
		faq.setActionCommand ("faq3");
		faq.addActionListener (this);
		
		//check game 3
		JButton check = new JButton (createImageIcon("ok1.png"));
		check.setBorderPainted(false);
		check.setBackground(Color.white);
		check.setActionCommand ("check3");
		check.addActionListener (this);
		
		//moves counter game 3
		move3 = new JLabel("Moves: "+ count3);
		move3.setFont(new Font("Times New Roman", Font.BOLD, 35));
		
		//exit
		JButton leave = new JButton(createImageIcon("dot.png"));
		leave.setBorderPainted(false);
		leave.setBackground(Color.white);
		leave.setActionCommand ("leave");
		leave.addActionListener (this);

		//Set up grid for level 3
		Panel p = new Panel (new GridLayout (row3, col3));
		int move = 0;
		for (int i = 0 ; i < row3 ; i++) {
			for (int j = 0 ; j < col3 ; j++) {
				c [move] = new JButton (createImageIcon ("t"+c1[i][j] + ".png"));
				//adds color to the images
				if(c1[i][j]==1 || c1[i][j]==11) {
					c[move].setOpaque(true);
					c[move].setBorderPainted(false);
					c[move].setBackground(Color.BLUE);
				}
				else if(c1[i][j]==2 || c1[i][j]==22) {
					c[move].setOpaque(true);
					c[move].setBorderPainted(false);
					c[move].setBackground(Color.GREEN);
				}
				else if(c1[i][j]==3 || c1[i][j]==33) {
					c[move].setOpaque(true);
					c[move].setBorderPainted(false);
					c[move].setBackground(Color.RED);
				}
				else if(c1[i][j]==4 || c1[i][j]==44) {
					c[move].setOpaque(true);
					c[move].setBorderPainted(false);
					c[move].setBackground(Color.YELLOW);
				}
				else if(c1[i][j]==5 || c1[i][j]==55) {
					c[move].setOpaque(true);
					c[move].setBorderPainted(false);
					c[move].setBackground(Color.CYAN);
				}
				else if(c1[i][j]==6 || c1[i][j]==66) {
					c[move].setOpaque(true);
					c[move].setBorderPainted(false);
					c[move].setBackground(Color.MAGENTA);
				}
				else if(c1[i][j]==7 || c1[i][j]==77) {
					c[move].setOpaque(true);
					c[move].setBorderPainted(false);
					c[move].setBackground(Color.PINK);
				}
				c [move].setPreferredSize (new Dimension (55, 55));
				c [move].addActionListener (this);
				c [move].setActionCommand ("" + move);
				p.add (c [move]);
				move++;
			}
		}
		
		level3.add (title);
		level3.add (p);
		level3.add(reset);
		level3.add(check);
		level3.add(faq);
		level3.add(leave);
		level3.add(move3);
		p_card.add ("three", level3);
	}

	public void win() { 
		//win screen
		win = new Panel ();
		win.setBackground(new Color(129, 199, 132));
		JLabel title = new JLabel (createImageIcon("win.png"));
		JLabel info = new JLabel(createImageIcon("bubble.png"));
		
		//total score
		point = new JLabel("Score: "+score);
		point.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		//displays date
		JLabel date = new JLabel ("You Have Completed The Entire Game On " + s);
		date.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		//close game
		JButton close = new JButton (createImageIcon("close.png"));
		close.setOpaque(true);
		close.setBorderPainted(false);
		close.setBackground(new Color(129, 199, 132));
		close.addActionListener (this);
		close.setActionCommand("close");
		
		//play again
		JButton reset = new JButton (createImageIcon("reset.png"));
		reset.setOpaque(true);
		reset.setBorderPainted(false);
		reset.setBackground(new Color(129, 199, 132));
		reset.addActionListener (this);
		reset.setActionCommand("resetall");
		
		win.add (title);
		win.add(point);
		win.add(info);
		win.add( date);
		win.add(reset);
		win.add (close);
		p_card.add ("win", win);
	}

	protected static ImageIcon createImageIcon (String path) {
		java.net.URL imgURL = FlowFreeGame.class.getResource (path);
		if (imgURL != null)
			return new ImageIcon (imgURL);
		else
			return null;
	}

	public void actionPerformed (ActionEvent e) { 
		//moves between the screens
		
		//instructions
		if (e.getActionCommand ().equals ("about")) {
			page = 0;
			cdLayout.show (p_card, "2");
		}
		//start game
		else if (e.getActionCommand ().equals ("play"))
			cdLayout.show (p_card, "6");
		//home screen
		else if (e.getActionCommand ().equals ("home"))
			cdLayout.show (p_card, "1");
		//moves inside instructions
		else if(e.getActionCommand ().equals ("aboutnext")) {
			about.setIcon(createImageIcon("bg2.png"));
			back.setActionCommand("prev1");
		}
		else if(e.getActionCommand ().equals ("prev1")) {
			about.setIcon(createImageIcon("bg1.png"));
			back.setActionCommand("prev");
		}
		//checks where the instructions page was accessed and sends you back to that page
		else if(e.getActionCommand ().equals ("prev")) {
			if(page == 0)
				cdLayout.show (p_card, "1");
			else if(page == 1)
				cdLayout.show (p_card, "one");
			else if(page == 2)
				cdLayout.show (p_card, "two");
			else if(page == 3)
				cdLayout.show (p_card, "three");
		}
		//if all levels are complete
		else if(e.getActionCommand ().equals ("complete")) {
			score = score-count1-count2-count3;
			point.setText("Score: "+score);
			cdLayout.show (p_card, "win");
		}
		//if all levels aren't complete
		else if(e.getActionCommand ().equals ("no"))
			JOptionPane.showMessageDialog (null, "Not Done.", "GAME", JOptionPane.INFORMATION_MESSAGE);
		//level 1
		else if(e.getActionCommand ().equals ("level1")) {
			level = 1;
			cur = 0;
			cdLayout.show (p_card, "one");
		}
		//reset game 1
		else if(e.getActionCommand ().equals ("reset1")) {
			reset1();
			cur = 0;
			count1=0;
			move1.setText("Moves: "+count1);

		}
		//instructions inside game 1
		else if(e.getActionCommand ().equals ("faq1")) {
			page = 1;
			cdLayout.show (p_card, "2");
			back.setActionCommand("backone");
		}
		//goes back to game 1 from instructions
		else if(e.getActionCommand ().equals ("backone"))
			cdLayout.show (p_card, "one");
		//level 2
		else if(e.getActionCommand ().equals ("level2")) {
			level = 2;
			cur = 0;
			cdLayout.show (p_card, "two");
		}
		//reset game 2
		else if(e.getActionCommand ().equals ("reset2")) {
			reset2();
			cur = 0;
			count2=0;
			move2.setText("Moves: "+count2);
		}
		//instructions inside game 2
		else if(e.getActionCommand ().equals ("faq2")) {
			page = 2;
			cdLayout.show (p_card, "2");
			back.setActionCommand("backtwo");
		}
		//goes back to game 2 from instructions
		else if(e.getActionCommand ().equals ("backtwo"))
			cdLayout.show (p_card, "two");
		//level 3
		else if(e.getActionCommand ().equals ("level3")) {
			level = 3;
			cur = 0;
			cdLayout.show (p_card, "three");
		}
		//reset game 3
		else if(e.getActionCommand ().equals ("reset3")) {
			reset3();
			cur = 0;
			count3=0;
			move3.setText("Moves: "+count3);
		}
		//instructions inside game 3
		else if(e.getActionCommand ().equals ("faq3")) {
			page = 3;
			cdLayout.show (p_card, "2");
			back.setActionCommand("backthree");
		}
		//goes back to game 3 from instructions
		else if(e.getActionCommand ().equals ("backthree"))
			cdLayout.show (p_card, "three");
		//exit from level page to level select page
		else if(e.getActionCommand ().equals ("leave"))
			cdLayout.show (p_card, "6");
		//checks if level 1 is complete
		else if (e.getActionCommand ().equals ("check1")) {
			if (check1()==true) {
				JOptionPane.showMessageDialog (null, createImageIcon("done1.png"), "GAME", JOptionPane.INFORMATION_MESSAGE);
				forest1.setIcon(createImageIcon("forestdone1.jpeg"));
				complete1 = true;
				//changes button image when all 3 levels are complete
				if(complete1==true&&complete2==true&&complete3==true) {
					done.setIcon(createImageIcon("alldone2.png"));
					done.setActionCommand ("complete");
				}
				//adds score
				cdLayout.show (p_card, "6");
				i+=33;
				p.setValue (i);
				score += 70;
			}
			else
				JOptionPane.showMessageDialog (null, createImageIcon("load.png"), "GAME", JOptionPane.INFORMATION_MESSAGE);
		}
		//checks if level 2 is complete
		else if (e.getActionCommand ().equals ("check2")) {
			if (check2()==true) {
				JOptionPane.showMessageDialog (null, createImageIcon("done1.png"), "GAME", JOptionPane.INFORMATION_MESSAGE);
				forest2.setIcon(createImageIcon("forestdone2.png"));
				complete2 = true;
				//changes button image when all 3 levels are complete
				if(complete1==true&&complete2==true&&complete3==true) {
					done.setIcon(createImageIcon("alldone2.png"));
					done.setActionCommand ("complete");
				}
				//adds score
				cdLayout.show (p_card, "6");
				i+=34;
				p.setValue (i);
				score += 143;
			}
			else
				JOptionPane.showMessageDialog (null, createImageIcon("load.png"), "GAME", JOptionPane.INFORMATION_MESSAGE);
		}
		//checks if level 3 is complete
		else if (e.getActionCommand ().equals ("check3")) {
			if (check3()==true) {
				JOptionPane.showMessageDialog (null, createImageIcon("done1.png"), "GAME", JOptionPane.INFORMATION_MESSAGE);
				forest3.setIcon(createImageIcon("forestdone3.gif"));
				complete3 = true;
				//changes button image when all 3 levels are complete
				if(complete1==true&&complete2==true&&complete3==true) {
					done.setIcon(createImageIcon("alldone2.png"));
					done.setActionCommand ("complete");
				}
				//adds score
				cdLayout.show (p_card, "6");
				i+=33.4;
				p.setValue (i);
				score += 224;
			}
			else
				JOptionPane.showMessageDialog (null, createImageIcon("load.png"), "GAME", JOptionPane.INFORMATION_MESSAGE);
		}
		//if player chooses to play again
		else if (e.getActionCommand ().equals ("resetall")) {
			score = 0;
			count1 = 0;
			move1.setText("Moves:"+count1);
			count2 = 0;
			move2.setText("Moves:"+count2);
			count3 = 0;
			move3.setText("Moves:"+count3);
			i = 0;
			p.setValue(i);
			cur = 0;
			level = 1;
			page = 0;
			forest1.setIcon(createImageIcon("forest1.jpeg"));
			forest2.setIcon(createImageIcon("forest2.png"));
			forest3.setIcon(createImageIcon("forest3.gif"));
			complete1 = false;
			complete2 = false;
			complete3 = false;
			resetall();
			done.setIcon(createImageIcon("alldone1.png"));
			done.setActionCommand ("no");
			cdLayout.show (p_card, "1");
		}
		//close game
		else if (e.getActionCommand ().equals ("close"))
			System.exit (0);
		//select pieces
		else {
			//level 1
			if(level == 1) {
				int n = Integer.parseInt (e.getActionCommand ());
				int x = n / col1;
				int y = n % col1;
				count1++;
				move1.setText("Moves: "+count1);
				if(a1[x][y]==1||a1[x][y]==11)
					cur = 111;
				else if(a1[x][y]==2||a1[x][y]==22)
					cur = 222;
				else if(a1[x][y]==3||a1[x][y]==33)
					cur = 333;
				else if(a1[x][y]==4||a1[x][y]==44)
					cur = 444;
				else if(a1[x][y]==5||a1[x][y]==55)
					cur = 555;
				else {
					a1[x][y] = cur;
				}
			}
			//level 2
			else if(level == 2) {
				int n = Integer.parseInt (e.getActionCommand ());
				int x = n / col2;
				int y = n % col2;
				count2++;
				move2.setText("Moves: "+count2);
				if(b1[x][y]==1||b1[x][y]==11)
					cur = 111;
				else if(b1[x][y]==2||b1[x][y]==22)
					cur = 222;
				else if(b1[x][y]==3||b1[x][y]==33)
					cur = 333;
				else if(b1[x][y]==4||b1[x][y]==44)
					cur = 444;
				else if(b1[x][y]==5||b1[x][y]==55)
					cur = 555;
				else if(b1[x][y]==6||b1[x][y]==66)
					cur = 666;
				else {
					b1[x][y] = cur;
				}
			}
			//level 3
			else if(level == 3) {
				int n = Integer.parseInt (e.getActionCommand ());
				int x = n / col3;
				int y = n % col3;
				count3++;
				move3.setText("Moves: "+count3);
				if(c1[x][y]==1||c1[x][y]==11)
					cur = 111;
				else if(c1[x][y]==2||c1[x][y]==22)
					cur = 222;
				else if(c1[x][y]==3||c1[x][y]==33)
					cur = 333;
				else if(c1[x][y]==4||c1[x][y]==44)
					cur = 444;
				else if(c1[x][y]==5||c1[x][y]==55)
					cur = 555;
				else if(c1[x][y]==6||c1[x][y]==66)
					cur = 666;
				else if(c1[x][y]==7||c1[x][y]==77)
					cur = 777;
				else {
					c1[x][y] = cur;
				}
			}
			redraw();
		}
	}

	//updates the board(all levels)
	public void redraw () {
		if(level == 1) {
			int move = 0;
			for (int i = 0 ; i < row1 ; i++) {
				for (int j = 0 ; j < col1 ; j++) {
					a [move].setIcon (createImageIcon ("j"+a1[i] [j] + ".png"));
					move++;
				}
			}
		}
		else if(level == 2) {
			int move = 0;
			for (int i = 0 ; i < row2 ; i++) {
				for (int j = 0 ; j < col2 ; j++) {
					b [move].setIcon (createImageIcon ("p"+b1[i] [j] + ".png"));
					move++;
				}
			}
		}
		else if(level == 3) {
			int move = 0;
			for (int i = 0 ; i < row3 ; i++) {
				for (int j = 0 ; j < col3 ; j++) {
					c [move].setIcon (createImageIcon ("t"+c1[i][j] + ".png"));
					move++;
				}
			}
		}
	}

	//if player chooses play again
	public void resetall() { 
		for (int i = 0 ; i < row1 ; i++)
			for (int j = 0 ; j < col1 ; j++) 
				a1 [i] [j] = a2 [i] [j];
		for (int i = 0 ; i < row2 ; i++)
			for (int j = 0 ; j < col2 ; j++)
				b1 [i] [j] = b2 [i] [j];
		for (int i = 0 ; i < row3 ; i++)
			for (int j = 0 ; j < col3 ; j++)
				c1 [i] [j] = c2 [i] [j];
		redrawall ();
	}

	//if player chooses play again
	public void redrawall () {
		int move1 = 0;
		for (int i = 0 ; i < row1 ; i++) {
			for (int j = 0 ; j < col1 ; j++) {
				a [move1].setIcon (createImageIcon ("j"+a1[i] [j] + ".png"));
				move1++;
			}
		}
		int move2 = 0;
		for (int i = 0 ; i < row2 ; i++) {
			for (int j = 0 ; j < col2 ; j++) {
				b [move2].setIcon (createImageIcon ("p"+b1[i] [j] + ".png"));
				move2++;
			}
		}
		int move3 = 0;
		for (int i = 0 ; i < row3 ; i++) {
			for (int j = 0 ; j < col3 ; j++) {
				c [move3].setIcon (createImageIcon ("t"+c1[i][j] + ".png"));
				move3++;
			}
		}
	}

	//button methods for level 1
	public void reset1() { 
		for (int i = 0 ; i < row1 ; i++)
			for (int j = 0 ; j < col1 ; j++)
				a1 [i] [j] = a2 [i] [j];
		redraw ();
	}

	public boolean check1() {
		for (int i = 0 ; i < row1 ; i++)
			for (int j = 0 ; j < col1 ; j++)
				if (a1 [i] [j] != ansa [i] [j])
					return false;
		return true;
	}

	//button methods for level 2
	public void reset2() { 
		for (int i = 0 ; i < row2 ; i++)
			for (int j = 0 ; j < col2 ; j++)
				b1 [i] [j] = b2 [i] [j];
		redraw ();
	}

	public boolean check2() {
		for (int i = 0 ; i < row2 ; i++)
			for (int j = 0 ; j < col2 ; j++)
				if (b1 [i] [j] != ansb [i] [j])
					return false;
		return true;
	}

	//button methods for level 3
	public void reset3() { 
		for (int i = 0 ; i < row3 ; i++)
			for (int j = 0 ; j < col3 ; j++)
				c1 [i] [j] = c2 [i] [j];
		redraw ();
	}

	public boolean check3() {
		for (int i = 0 ; i < row3 ; i++)
			for (int j = 0 ; j < col3 ; j++)
				if (c1 [i] [j] != ansc [i] [j])
					return false;
		return true;
	}

	public static void main (String[] args) {
		JFrame.setDefaultLookAndFeelDecorated (true);
		//Create and set up the window.
		JFrame frame = new JFrame ("FlowFreeGame");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		//Create and set up the content pane.
		JComponent newContentPane = new FlowFreeGame();
		newContentPane.setOpaque (true);
		frame.setContentPane (newContentPane);
		frame.setSize (500, 700);
		frame.setVisible (true);
	}
}