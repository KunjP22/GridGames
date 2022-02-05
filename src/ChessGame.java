//Name: Kunj Patel
//Date: January 16, 2021
//Purpose: Unit 6 Project - Grid Game - Chess

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;

public class ChessGame extends JPanel implements ActionListener {

	Panel p_card;  //to hold all of the screens
	Panel card1, card2, card3, card4, card5; //the two screens
	CardLayout cdLayout = new CardLayout ();

	//doesn't repeat winning message
	int once;

	//gets user names
	int ask = 1;
	String one;
	String two;
	JLabel player1;
	JLabel player2;

	//menu in the corner of the screen
	JMenuBar menuBar = new JMenuBar ();
	JMenu menu;
	JMenuItem menuItem;

	//pawn promotion
	JComboBox promote;
	String promotename;

	//pieces information
	JComboBox pieces; 
	String piecename;

	//shows who can go
	JLabel turnpic;
	char turn = 'b';
	int last = -1;

	//keeps track of king's movement(white)
	int KingWX = 0;
	int KingWY = 0;

	//keeps track of king's movement(black)
	int KingBX = 0;
	int KingBY = 0;

	//checks if pawn piece is at correct position
	int PromoteY = 0;

	//chess game
	int row = 8;
	int col = 8;
	JButton a[] = new JButton [row * col];
	char piece[] [] = {{'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}, {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
			{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
			{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
			{'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}, {'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}};

	char select[] [] = {{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}};

	char colour[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}, {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
			{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
			{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
			{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}};

	char bg[] [] = {{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
			{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
			{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
			{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'}};

	//reset game
	char piece1[] [] = {{'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}, {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
			{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
			{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
			{'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}, {'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}};

	char select1[] [] = {{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
			{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}};

	char colour1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}, {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
			{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
			{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
			{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}};

	char bg1[] [] = {{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
			{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
			{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
			{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'}};


	public ChessGame () {
		p_card = new Panel ();
		p_card.setLayout (cdLayout);
		start ();
		screen2 ();
		screen3 ();
		screen4 ();
		screen5 ();
		setLayout (new BorderLayout ());
		Menu();
		add ("Center", p_card);
	}

	public void start () { 
		//start screen
		card1 = new Panel ();
		card1.setBackground (new Color (255, 255, 255));
		
		//title
		JLabel title = new JLabel (createImageIcon("chess.png"));
		//play
		JButton next = new JButton (createImageIcon("chessplay.png"));
		next.setOpaque(true);
		next.setBorderPainted(false);
		next.setBackground(Color.BLACK);
		next.setActionCommand ("play");
		next.addActionListener (this);
		//close
		JButton close = new JButton (createImageIcon("chessclose.png"));
		close.setOpaque(true);
		close.setBorderPainted(false);
		close.setBackground(Color.BLACK);
		close.setActionCommand ("close");
		close.addActionListener (this);
		//instructions
		JButton setting = new JButton (createImageIcon("chesssettings.png"));
		setting.setOpaque(true);
		setting.setBorderPainted(false);
		setting.setBackground(Color.BLACK);
		setting.setActionCommand ("about");
		setting.addActionListener (this);
		
		card1.add (title);
		card1.add (setting);
		card1.add (next);
		card1.add (close);
		card1.setBackground(Color.black);
		p_card.add ("1", card1);
	}


	public void screen2 () { 
		//instructions
		card2 = new Panel ();
		card2.setBackground (new Color (255, 255, 255));
		//image for instructions
		JLabel title = new JLabel (createImageIcon("chessabout.png"));
		//back to home page
		JButton next = new JButton (createImageIcon("chessback.png"));
		next.setOpaque(true);
		next.setBorderPainted(false);
		next.setBackground(Color.BLACK);
		next.setActionCommand ("back");
		next.addActionListener (this);
		
		card2.add (title);
		card2.add (next);
		card2.setBackground(Color.black);
		p_card.add ("2", card2);
	}


	public void screen3 () { 
		//game screen
		card3 = new Panel ();
		card3.setBackground (Color.BLACK);

		//turn
		turnpic = new JLabel(createImageIcon("pbbu.jpg"));
		turnpic.setPreferredSize(new Dimension(65, 65));
		
		//title
		JLabel title = new JLabel ("                   Halloween Chess                   ");
		title.setFont(new Font("Times New Roman", Font.ITALIC, 35));
		title.setForeground(Color.ORANGE);
		
		//player 1 name
		player1 = new JLabel ("Player 1: " + one);
		player1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		player1.setForeground(Color.ORANGE);
		
		//player 2 name
		player2 = new JLabel ("Player 2: " + two);
		player2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		player2.setForeground(Color.ORANGE);
		
		//turn
		JLabel turn = new JLabel ("              Turn :");
		turn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		turn.setForeground(Color.ORANGE);
		
		//reset board
		JButton reset = new JButton (createImageIcon("chessreset.png"));
		reset.setPreferredSize(new Dimension(50, 50));
		reset.setOpaque(true);
		reset.setBorderPainted(false);
		reset.setBackground(Color.BLACK);
		reset.setActionCommand ("reset");
		reset.addActionListener (this);
		
		//banners on the side
		JLabel banner = new JLabel(createImageIcon("banner.png"));
		JLabel banner1 = new JLabel(createImageIcon("banner.png"));
		
		//surrender
		JButton sur = new JButton("Surrender");
		sur.setOpaque(true);
		sur.setBorderPainted(false);
		sur.setForeground(Color.BLACK);
		sur.setBackground(Color.ORANGE);
		sur.addActionListener(this);
		sur.setActionCommand("surrender");

		//board
		Panel p = new Panel (new GridLayout (row, col));
		int move = 0;
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < col ; j++) { 
				a [move] = new JButton(createImageIcon (piece [i] [j] + "" + colour [i] [j] + "" + bg [i] [j] + "" + select [i] [j] + ".jpg"));
				a [move].setPreferredSize (new Dimension (60, 60));
				a [move].addActionListener (this);
				a [move].setActionCommand ("" + move);
				p.add (a [move]);
				move++;
			}
		}
		
		card3.add (title);
		card3.add(player1);
		card3.add(banner);
		card3.add (p);
		card3.add(banner1);
		card3.add(player2);
		card3.add (turn);
		card3.add (turnpic);
		card3.add(sur);
		card3.add (reset);
		p_card.add ("3", card3);
	}


	public void screen4 () { 
		//win(player 1)
		card4 = new Panel ();
		card4.setBackground (Color.BLACK);
		
		//shows who won
		JLabel title = new JLabel (createImageIcon("winscreen.jpeg"));
		
		//play again
		JButton again = new JButton (createImageIcon("chessreset1.png"));
		again.setOpaque(true);
		again.setBorderPainted(false);
		again.setBackground(Color.BLACK);
		again.setActionCommand ("reset1");
		again.addActionListener (this);
		
		//close game
		JButton close = new JButton (createImageIcon("chessclose.png"));
		close.setOpaque(true);
		close.setBorderPainted(false);
		close.setBackground(Color.BLACK);
		close.setActionCommand ("close");
		close.addActionListener (this);
		
		card4.add (title);
		card4.add (again);
		card4.add (close);
		p_card.add ("4", card4);
	}


	public void screen5 () { 
		//win(player 2)
		card5 = new Panel ();
		card5.setBackground (Color.BLACK);
		
		//shows who won
		JLabel title = new JLabel (createImageIcon("winscreen1.png"));
		
		//play again
		JButton again = new JButton (createImageIcon("chessreset1.png"));
		again.setOpaque(true);
		again.setBorderPainted(false);
		again.setBackground(Color.BLACK);
		again.setActionCommand ("reset1");
		again.addActionListener (this);
		
		//close game
		JButton close = new JButton (createImageIcon("chessclose.png"));
		close.setOpaque(true);
		close.setBorderPainted(false);
		close.setBackground(Color.BLACK);
		close.setActionCommand ("close");
		close.addActionListener (this);
		
		card5.add (title);
		card5.add (again);
		card5.add (close);
		p_card.add ("5", card5);
	}


	public void actionPerformed (ActionEvent e) {
		//moves between the screens
		
		//starts game
		if (e.getActionCommand ().equals ("play")) {
			//asks for player names
			if(ask == 1) {
				one = JOptionPane.showInputDialog ("Player 1's Name: ");
				two = JOptionPane.showInputDialog ("Player 2's Name: ");
				player1.setText("P1: " + one+"                                                                                                                                              ");
				player2.setText("                                                                                                                                              "+"P2: " + two);
				ask++;
			}
			cdLayout.show (p_card, "3");
		}
		
		//home screen
		else if (e.getActionCommand ().equals ("home"))
			cdLayout.show (p_card, "1");
		//game screen
		else if (e.getActionCommand ().equals ("game")) {
			cdLayout.show (p_card, "3");
			//if player names have not been acquired already, ask for their names
			if(ask == 1) {
				one = JOptionPane.showInputDialog ("Player 1's Name: ");
				two = JOptionPane.showInputDialog ("Player 2's Name: ");
				player1.setText("Player 1: " + one+"                                                                                                                                              ");
				player2.setText("                                                                                                                                              "+"Player 2: " + two);
				ask++;
			}
		}
		//instructions page
		else if (e.getActionCommand ().equals ("about"))
			cdLayout.show (p_card, "2");
		//pieces information
		else if (e.getActionCommand ().equals ("help")) 
			Help();
		//displays information about piece selected
		else if (e.getActionCommand ().equals ("movement")) {
			JComboBox cb = (JComboBox) e.getSource ();
			piecename = (String) cb.getSelectedItem ();
			if(piecename=="King")
				King();
			else if(piecename=="Queen")
				Queen();
			else if(piecename=="Rook")
				Rook();
			else if(piecename=="Bishop")
				Bishop();
			else if(piecename=="Knight")
				Knight();
			else if(piecename=="Pawn")
				Pawn();
		}
		//takes you back to home screen from instructions
		else if (e.getActionCommand ().equals ("back"))
			cdLayout.show (p_card, "1");
		//close game
		else if (e.getActionCommand ().equals ("close"))
			System.exit (0);
		//surrender
		else if (e.getActionCommand ().equals ("surrender")) {
			//who surrendered
			String [] possibleValues = {one, two};
			String selectedValue = (String) JOptionPane.showInputDialog (null, "Who gave up.", "GAME", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues [0]);
			if(selectedValue == one)
				cdLayout.show (p_card, "5");
			else if(selectedValue == two)
				cdLayout.show (p_card, "4");
		}
		//pawn promotion
		else if(e.getActionCommand ().equals ("promote")) {
			JComboBox cb = (JComboBox) e.getSource ();
			promotename = (String) cb.getSelectedItem ();
			//black pawn
			if(turn == 'b')
				if(promotename=="Queen")
					piece[0][PromoteY]='q';
				else if(promotename=="Rook")
					piece[0][PromoteY]='r';
				else if(promotename=="Knight")
					piece[0][PromoteY]='n';
				else if(promotename=="Bishop")
					piece[0][PromoteY]='b';
			//white pawn
			if(turn == 'w')
				if(promotename=="Queen")
					piece[7][PromoteY]='q';
				else if(promotename=="Rook")
					piece[7][PromoteY]='r';
				else if(promotename=="Knight")
					piece[7][PromoteY]='n';
				else if(promotename=="Bishop")
					piece[7][PromoteY]='b';
		}
		//reset board
		else if (e.getActionCommand ().equals ("reset")) {
			reset();
			turnpic.setIcon(createImageIcon("pbbu.jpg"));
			turn = 'b';
		}
		//play again
		else if (e.getActionCommand ().equals ("reset1")) {
			reset();
			turnpic.setIcon(createImageIcon("pbbu.jpg"));
			turn = 'b';
			cdLayout.show (p_card, "1");
			ask = 1;
		}
		//placing pieces
		else {
			//code to handle the game
			int n = Integer.parseInt (e.getActionCommand ());
			int x = n / col;
			int y = n % col;
			
			//king position
			for (int i = 0 ; i < row ; i++) {
				for (int j = 0 ; j < col ; j++) { 
					if(piece[i][j]=='k' && colour[i][j]=='w') {
						KingWX = i;
						KingWY = j;
					}
				}
			}
			for (int i = 0 ; i < row ; i++) {
				for (int j = 0 ; j < col ; j++) { 
					if(piece[i][j]=='k' && colour[i][j]=='b') {
						KingBX = i;
						KingBY = j;
					}
				}
			}
			//displays turn
			if(turn != colour[x][y] && last == -1)
				JOptionPane.showMessageDialog (null, "It's not your turn", "Turns", JOptionPane.INFORMATION_MESSAGE);
			//which piece was selected
			else if(last == -1 && turn == colour[x][y]) {
				pawnPromotion(x, y);
				if(piece[x][y] == 'p') 
					selectPawn(x, y);
				if(piece[x][y] == 'n')
					selectKnight(x, y);
				if(piece[x][y] == 'k')
					selectKing(x, y);
				if(piece[x][y] == 'r')
					selectRook(x, y);
				if(piece[x][y] == 'b')
					selectBishop(x, y);
				if(piece[x][y] == 'q')
					selectQueen(x, y);
				last = n;
				once = 1;
				//checks if any king has been checkmated
				for (int i = 0 ; i < row ; i++)
					for (int j = 0 ; j < col ; j++) {
						if(select[i][j]=='s'&&select[i][j]==select[KingWX][KingWY]) {
							while(once == 1) {
								JOptionPane.showMessageDialog (null, "Checkmate - Black Wins", "Game", JOptionPane.ERROR_MESSAGE);
								once = 2;
							}
							cdLayout.show (p_card, "4");
						}
						if(select[i][j]=='s'&&select[i][j]==select[KingBX][KingBY]) {
							while(once == 1) {
								JOptionPane.showMessageDialog (null, "Checkmate - White Wins", "Game", JOptionPane.ERROR_MESSAGE);
								once = 2;

							}
							cdLayout.show (p_card, "5");
						}
					}
			}
			//moves the piece selected
			else {
				int lastx = last / col;
				int lasty = last % col;
				//move
				if(select[x][y] == 's') {
					piece[x][y] = piece[lastx][lasty];
					piece[lastx][lasty] = 'x';
					colour[x][y] = colour [lastx][lasty];
					colour [lastx][lasty] = 'x';
					if(turn=='b') {
						turnpic.setIcon(createImageIcon("pwwu.jpg"));
						turn = 'w';
					}
					else {
						turnpic.setIcon(createImageIcon("pbbu.jpg"));
						turn = 'b';
					}
				}
				for(int i = 0 ; i < row ; i++) {
					for(int j = 0 ; j < col ; j++) {
						select[i][j] = 'u';
					}
				}
				last = -1;
			}
		}
		redraw();
	}

	//updates the board
	public void redraw () {
		int move = 0;
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < col ; j++) {
				a [move].setIcon (createImageIcon (piece [i] [j] + "" + colour [i] [j] + "" + bg [i] [j] + "" + select [i] [j] + ".jpg"));
				move++;
			}
		}
	}

	//pawn info
	public void Pawn() {
		JOptionPane.showMessageDialog (null, createImageIcon("pb.png"), "Pawn", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog (null, "------INSTRUCTIONS-----------------------------------------------------------------------------------"
				+ "\n"
				+ "- Pawn are unusual because they move and capture in different ways: they move forward, move forward,\n"
				+ "but capture diagonally.\n\n"
				+ "- Pawns can only move forward one square at a time, except for their very first move where they can\n"
				+ "move forward two squares.\n\n"
				+ "- Pawns can only capture one square diagonally in front of them. They can never move or capture backwards.\n\n"
				+ "- If there is another piece directly in front of a pawn he cannot move past or capture that piece.", "Pawn Movement", JOptionPane.INFORMATION_MESSAGE);
	}

	//knight info
	public void Knight() {
		JOptionPane.showMessageDialog (null, createImageIcon("nb.png"), "Knight", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog (null, "------INSTRUCTIONS-----------------------------------------------------------------------------------"
				+ "\n"
				+ "- Knights move in a very different way from the other pieces – going two squares in one direction, and\n"
				+ "then one more move at a 90 degree angle, just like the shape of an “L”.\n\n"
				+ "- Knights are also the only pieces that can move over other pieces.", "Knight Movement", JOptionPane.INFORMATION_MESSAGE);
	}
	//bishop info
	public void Bishop() {
		JOptionPane.showMessageDialog (null, createImageIcon("bb.png"), "Bishop", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog (null, "------INSTRUCTIONS-----------------------------------------------------------------------------------"
				+ "\n"
				+ "- The bishop may move as far as it wants, but only diagonally. Each bishop starts on one color\n"
				+ "(light or dark) and must always stay on that color.\n\n"
				+ "- Bishops work well together because they cover up each other's weaknesses.", "Bishop Movement", JOptionPane.INFORMATION_MESSAGE);
	}

	//rook info
	public void Rook() {
		JOptionPane.showMessageDialog (null, createImageIcon("rb.png"), "Rook", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog (null, "------INSTRUCTIONS-----------------------------------------------------------------------------------"
				+ "\n"
				+ "- The rook may move as far as it wants, but only forward, backward, and to the sides.\n\n"
				+ "- The rooks are particularly powerful pieces when they are protecting each other and working together!", "Rook Movement", JOptionPane.INFORMATION_MESSAGE);
	}

	//queen info
	public void Queen() {
		JOptionPane.showMessageDialog (null, createImageIcon("qb.png"), "Queen", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog (null, "------INSTRUCTIONS-----------------------------------------------------------------------------------"
				+ "\n"
				+ "- The queen is the most powerful piece. She can move in any one straight direction - forward, backward,\n"
				+ "sideways, or diagonally - as far as possible as long as she does not move through any of her own pieces.\n\n"
				+ "- And, like with all pieces, if the queen captures an opponent's piece her move is over. Notice how\n"
				+ "the white queen captures the black queen and then the black king is forced to move.", "Queen Movement", JOptionPane.INFORMATION_MESSAGE);
	}

	//king info
	public void King() {
		JOptionPane.showMessageDialog (null, createImageIcon("kb.png"), "King", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog (null, "------INSTRUCTIONS-----------------------------------------------------------------------------------"
				+ "\n"
				+ "- The king is the most important piece, but is one of the weakest. The king can only move one square\n"
				+ "in any direction - up, down, to the sides, and diagonally.\n\n"
				+ "- The king may never move himself into check (where he could be captured). When the king is attacked\n"
				+ "by another piece this is called \"check\".", "King Movement", JOptionPane.INFORMATION_MESSAGE);
	}

	//displays info on which piece was selected
	public void Help() {
		String [] piecesname = {"Pawn", "Knight", "Bishop", "Rook", "Queen", "King"};;
		JComboBox pieces = new JComboBox (piecesname);
		pieces.setSelectedIndex (1);
		pieces.setActionCommand ("movement");
		pieces.addActionListener (this);
		JOptionPane.showMessageDialog (null, pieces, "Movement Information", JOptionPane.QUESTION_MESSAGE);
	}

	//pawn promotion method
	public void pawnPromotion(int x, int y) {
		if(piece[x][y] == 'p') {
			if(turn == 'b' && x == 0) {
				PromoteY = y;
				String [] promotename = {"Queen", "Bishop", "Knight", "Rook"};
				JComboBox promote = new JComboBox (promotename);
				promote.setSelectedIndex (1);
				promote.setActionCommand ("promote");
				promote.addActionListener (this);
				JOptionPane.showMessageDialog (null, promote, "Pawn Promotion", JOptionPane.QUESTION_MESSAGE);
			}
			if(turn == 'w' && x == 7) {
				PromoteY = y;
				String [] promotename = {"Queen", "Bishop", "Knight", "Rook"};
				JComboBox promote = new JComboBox (promotename);
				promote.setSelectedIndex (1);
				promote.setActionCommand ("promote");
				promote.addActionListener (this);
				JOptionPane.showMessageDialog (null, promote, "Pawn Promotion", JOptionPane.QUESTION_MESSAGE);
			}
		}
	}
	
	//pawn movement
	public void selectPawn(int x, int y) {
		if(colour[x][y] == 'b' && x == 6) {
			select[x-1][y] = 's';
			select[x-2][y] = 's';
		}
		else if(colour[x][y] == 'w' && x == 1) {
			select[x+1][y] = 's';
			select[x+2][y] = 's';
		}
		else if(colour[x][y] == 'b' && piece[x-1][y] == 'x') {
			select[x-1][y] = 's';
		}
		else if(colour[x][y] == 'w' && piece[x+1][y] == 'x') {
			select[x+1][y] = 's';
		}
		if(x-1 >= 0 && y+1 < col && colour[x][y] == 'b' && colour[x-1][y+1] == 'w') {
			select[x-1][y+1] = 's';
		}
		if(x-1 >= 0 && y-1 >= 0 && colour[x][y] == 'b' && colour[x-1][y-1] == 'w') {
			select[x-1][y-1] = 's';
		}
		if(x+1 < row && y+1 < col && colour[x][y] == 'w' && colour[x+1][y+1] == 'b') {
			select[x+1][y+1] = 's';
		}
		if(x+1 < row && y-1 >= 0 && colour[x][y] == 'w' && colour[x+1][y-1] == 'b') {
			select[x+1][y-1] = 's';
		}
	}

	//king movement
	public void selectKing(int x, int y) {
		if(x-1>=0 && y+1< col && colour[x-1][y+1]!=turn) {
			select[x-1][y+1] = 's';
		}
		if(x+1<row && y+1< col && colour[x+1][y+1]!=turn) {
			select[x+1][y+1] = 's';
		}
		if(x-1>=0 && y-1>=0 && colour[x-1][y-1]!=turn) {
			select[x-1][y-1] = 's';
		}
		if(x+1<row && y-1>=0 && colour[x+1][y-1]!=turn) {
			select[x+1][y-1] = 's';
		}
		if(y-1>=0 && colour[x][y-1]!=turn) {
			select[x][y-1] = 's';
		}
		if(y+1<col && colour[x][y+1]!=turn) {
			select[x][y+1] = 's';
		}
		if(x-1>=0 && colour[x-1][y]!=turn) {
			select[x-1][y] = 's';
		}
		if(x+1<row && colour[x+1][y]!=turn) {
			select[x+1][y] = 's';
		}
	}

	//knight movement
	public void selectKnight(int x, int y) {
		if(x-1>=0 && y-2 >= 0 && colour[x-1][y-2]!=turn) {
			select[x-1][y-2] = 's';
		}
		if(x-2>=0 && y-1 >= 0 && colour[x-2][y-1]!=turn) {
			select[x-2][y-1] = 's';
		}
		if(x-1>=0 && y+2 < col && colour[x-1][y+2]!=turn) {
			select[x-1][y+2] = 's';
		}
		if(x-2>=0 && y+1 < col && colour[x-2][y+1]!=turn) {
			select[x-2][y+1] = 's';
		}
		if(x+1<row && y-2 >= 0 && colour[x+1][y-2]!=turn) {
			select[x+1][y-2] = 's';
		}
		if(x+2<row && y-1 >= 0 && colour[x+2][y-1]!=turn) {
			select[x+2][y-1] = 's';
		}
		if(x+1<row && y+2 < col && colour[x+1][y+2]!=turn) {
			select[x+1][y+2] = 's';
		}
		if(x+2<row && y+1 < col && colour[x+2][y+1]!=turn) {
			select[x+2][y+1] = 's';
		}

	}

	//rook movement
	public void selectRook(int x, int y) {
		//UP
		int cx1 = x-1;
		//while we haven't fallen off the end, and it is still blank
		while(cx1 >= 0 && colour[cx1][y] == 'x') {
			select[cx1][y] = 's';
			cx1--;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx1 >= 0 && colour[cx1][y] != turn && colour[cx1][y] != 'x') {
			select[cx1][y] = 's';
		}

		//Down
		cx1 = x+1;
		//while we haven't fallen off the end, and it is still blank
		while(cx1 < row && colour[cx1][y] == 'x') {
			select[cx1][y] = 's';
			cx1++;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx1 < row && colour[cx1][y] != turn && colour[cx1][y] != 'x') {
			select[cx1][y] = 's';
		}

		//Left
		int cy1 = y-1;
		//while we haven't fallen off the end, and it is still blank
		while(cy1 >= 0 && colour[x][cy1] == 'x') {
			select[x][cy1] = 's';
			cy1--;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cy1 >= 0 && colour[x][cy1] != turn && colour[x][cy1] != 'x') {
			select[x][cy1] = 's';
		}

		//Right
		cy1 = y+1;
		//while we haven't fallen off the end, and it is still blank
		while(cy1 < col && colour[x][cy1] == 'x') {
			select[x][cy1] = 's';
			cy1++;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cy1 < col && colour[x][cy1] != turn && colour[x][cy1] != 'x') {
			select[x][cy1] = 's';
		}
	}

	//bishop movement
	public void selectBishop(int x, int y) {
		//UP-RIGHT
		int cx1 = x-1;
		int cy1 = y+1;
		//while we haven't fallen off the end, and it is still blank
		while(cx1 >= 0 && cy1 < col && colour[cx1][cy1] == 'x') {
			select[cx1][cy1] = 's';
			cx1--;
			cy1++;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx1 >= 0 && cy1 < col && colour[cx1][cy1] != turn && colour[cx1][cy1] != 'x') {
			select[cx1][cy1] = 's';
		}

		//UP-LEFT
		cx1 = x-1;
		cy1 = y-1;
		//while we haven't fallen off the end, and it is still blank
		while(cx1 >= 0 && cy1 >=0 && colour[cx1][cy1] == 'x') {
			select[cx1][cy1] = 's';
			cx1--;
			cy1--;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx1 >= 0 && cy1 >=0 && colour[cx1][cy1] != turn && colour[cx1][cy1] != 'x') {
			select[cx1][cy1] = 's';
		}

		//DOWN-RIGHT
		cx1 = x+1;
		cy1 = y+1;
		//while we haven't fallen off the end, and it is still blank
		while(cx1 < row && cy1 < col && colour[cx1][cy1] == 'x') {
			select[cx1][cy1] = 's';
			cx1++;
			cy1++;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx1 < row && cy1 < col && colour[cx1][cy1] != turn && colour[cx1][cy1] != 'x') {
			select[cx1][cy1] = 's';
		}

		//DOWN-LEFT
		cx1 = x+1;
		cy1 = y-1;
		//while we haven't fallen off the end, and it is still blank
		while(cx1 < row && cy1 >= 0 && colour[cx1][cy1] == 'x') {
			select[cx1][cy1] = 's';
			cx1++;
			cy1--;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx1 < row && cy1 >=0 && colour[cx1][cy1] != turn && colour[cx1][cy1] != 'x') {
			select[cx1][cy1] = 's';
		}
	}

	
	//queen movement
	public void selectQueen(int x, int y) {
		//UP
		int cx1 = x-1;
		//while we haven't fallen off the end, and it is still blank
		while(cx1 >= 0 && colour[cx1][y] == 'x') {
			select[cx1][y] = 's';
			cx1--;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx1 >= 0 && colour[cx1][y] != turn && colour[cx1][y] != 'x') {
			select[cx1][y] = 's';
		}

		//Down
		cx1 = x+1;
		//while we haven't fallen off the end, and it is still blank
		while(cx1 < row && colour[cx1][y] == 'x') {
			select[cx1][y] = 's';
			cx1++;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx1 < row && colour[cx1][y] != turn && colour[cx1][y] != 'x') {
			select[cx1][y] = 's';
		}

		//Left
		int cy1 = y-1;
		//while we haven't fallen off the end, and it is still blank
		while(cy1 >= 0 && colour[x][cy1] == 'x') {
			select[x][cy1] = 's';
			cy1--;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cy1 >= 0 && colour[x][cy1] != turn && colour[x][cy1] != 'x') {
			select[x][cy1] = 's';
		}

		//Right
		cy1 = y+1;
		//while we haven't fallen off the end, and it is still blank
		while(cy1 < col && colour[x][cy1] == 'x') {
			select[x][cy1] = 's';
			cy1++;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cy1 < col && colour[x][cy1] != turn && colour[x][cy1] != 'x') {
			select[x][cy1] = 's';
		}

		//UP-RIGHT
		int cx2 = x-1;
		int cy2 = y+1;
		//while we haven't fallen off the end, and it is still blank
		while(cx2 >= 0 && cy2 < col && colour[cx2][cy2] == 'x') {
			select[cx2][cy2] = 's';
			cx2--;
			cy2++;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx2 >= 0 && cy2 < col && colour[cx2][cy2] != turn && colour[cx2][cy2] != 'x') {
			select[cx2][cy2] = 's';
		}

		//UP-LEFT
		cx2 = x-1;
		cy2 = y-1;
		//while we haven't fallen off the end, and it is still blank
		while(cx2 >= 0 && cy2 >=0 && colour[cx2][cy2] == 'x') {
			select[cx2][cy2] = 's';
			cx2--;
			cy2--;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx2 >= 0 && cy2 >=0 && colour[cx2][cy2] != turn && colour[cx2][cy2] != 'x') {
			select[cx2][cy2] = 's';
		}

		//DOWN-RIGHT
		cx2 = x+1;
		cy2 = y+1;
		//while we haven't fallen off the end, and it is still blank
		while(cx2 < row && cy2 < col && colour[cx2][cy2] == 'x') {
			select[cx2][cy2] = 's';
			cx2++;
			cy2++;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx2 < row && cy2 < col && colour[cx2][cy2] != turn && colour[cx2][cy2] != 'x') {
			select[cx2][cy2] = 's';
		}

		//DOWN-LEFT
		cx2 = x+1;
		cy2 = y-1;
		//while we haven't fallen off the end, and it is still blank
		while(cx2 < row && cy2 >= 0 && colour[cx2][cy2] == 'x') {
			select[cx2][cy2] = 's';
			cx2++;
			cy2--;
		}
		//kill condition:
		//if on the board, it isn't us, and it isn't blank
		if(cx2 < row && cy2 >=0 && colour[cx2][cy2] != turn && colour[cx2][cy2] != 'x') {
			select[cx2][cy2] = 's';
		}
	}

	
	//menu located top left
	public void Menu () {
		JMenuBar menuBar = new JMenuBar ();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu ("File");
		menuBar.add (menu);

		menuItem = new JMenuItem ("Close");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("close");
		menu.add (menuItem);

		menuItem = new JMenuItem ("Home");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("home");
		menu.add (menuItem);

		menuItem = new JMenuItem ("Game");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("game");
		menu.add (menuItem);

		menuItem = new JMenuItem ("Rules");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("about");
		menu.add (menuItem);

		menuItem = new JMenuItem ("Help");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("help");
		menu.add (menuItem);
		add ("North", menuBar);
	}

	//reset board
	public void reset () {
		for (int i = 0 ; i < row ; i++)
			for (int j = 0 ; j < col ; j++) {
				piece [i] [j] = piece1 [i] [j];
				select [i] [j] = select1 [i] [j];
				colour [i] [j] = colour1 [i] [j];
				bg [i] [j] = bg1 [i] [j];
			}
		redraw ();
	}

	protected static ImageIcon createImageIcon (String path) {
		java.net.URL imgURL = ChessGame.class.getResource (path);
		if (imgURL != null)
			return new ImageIcon (imgURL);
		else
			return null;
	}

	public static void main (String[] args) {
		JFrame.setDefaultLookAndFeelDecorated (true);
		//Create and set up the window.
		JFrame frame = new JFrame ("ChessGame");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		//Create and set up the content pane.
		JComponent newContentPane = new ChessGame ();
		newContentPane.setOpaque (true);
		frame.setContentPane (newContentPane);
		frame.setSize (900, 730);
		frame.setVisible (true);
	}
}