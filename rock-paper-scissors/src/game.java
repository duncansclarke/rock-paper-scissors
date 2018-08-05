import java.util.Random;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game {
	
	private static String userMove;
	private static int userScore;
	private static String cpuMove;
	private static int cpuScore;
	private static String resultText;
	
	public static void main(String [] args) {
		//create GUI
		createWindow();
	}
	
	/**
	 * Generate a random number to determine the CPU's move
	 * @return String containing the CPU's move
	 */
	public static String generateCPUMove() {
		int r = (int)(Math.random() * 3);
		if(r==0) {
			return "rock";
		}
		else if(r==1) {
			return "paper";
		}
		else {
			return "scissors";
		}
	}
	
	/**
	 * Creates the GUI with buttons and labels
	 */
	public static void createWindow() {
		
		//JFrame instantiation
		JFrame frame = new JFrame("Rock Paper Scissors - By Duncan Clarke");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0, 1));
		
		//create "Select Move" label
		JPanel selectMove = new JPanel();
		selectMove.setLayout(new GridBagLayout());
		selectMove.add(new JLabel("Select Move"));
		frame.add(selectMove);
		
		//create buttons for user move selection
		JButton rBtn = new JButton("Rock");
		JButton pBtn = new JButton("Paper");
		JButton sBtn = new JButton("Scissors");
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(0, 3));
		buttons.add(rBtn);
		buttons.add(pBtn);
		buttons.add(sBtn);
		frame.add(buttons);
		
		//create label for round result
		JPanel result = new JPanel();
		result.setLayout(new GridBagLayout());
		JLabel resultLabel = new JLabel("");
		result.add(resultLabel);
		frame.add(result);
		
		//create labels for score display
		JPanel scores = new JPanel();
		scores.setLayout(new GridLayout(0,2));
		JLabel userScoreLabel = new JLabel("     Your Score: " + userScore);
		JLabel cpuScoreLabel = new JLabel("Opponent's Score: " + cpuScore);
		scores.add(userScoreLabel);
		scores.add(cpuScoreLabel);
		frame.add(scores);
		
		//update user move based on button press
		rBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userMove = "rock";
				playGame();
				//display game result
				resultLabel.setText(resultText);
				//update score counters
				userScoreLabel.setText("Your Score: " + userScore);
				cpuScoreLabel.setText("Opponent's Score: " + cpuScore);
			}
		});
		pBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userMove = "paper";
				playGame();
				//display game result
				resultLabel.setText(resultText);
				//update score counters
				userScoreLabel.setText("Your Score: " + userScore);
				cpuScoreLabel.setText("Opponent's Score: " + cpuScore);
			}
		});
		sBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userMove = "scissors";
				playGame();
				//display game result
				resultLabel.setText(resultText);
				//update score counters
				userScoreLabel.setText("Your Score: " + userScore);
				cpuScoreLabel.setText("Opponent's Score: " + cpuScore);
			}
		});
		
		//instantiate GUI
	    frame.pack();
	    frame.setSize(frame.getWidth()+50, frame.getHeight()+80);
	    frame.setVisible(true);
	}
	
	
	/**
	 * Generates the CPU's move and alters the scores and round result text accordingly
	 */
	public static void playGame() {
		
		//randomly generate CPU move
		cpuMove = generateCPUMove();
		
		if(cpuMove == "rock") {
			if(userMove == "rock") {
				resultText = "Draw!";
			}
			else if (userMove == "paper") {
				userScore++;
				resultText = "Paper covers rock. You win!";
			}
			else {
				cpuScore++;
				resultText = "Rock crushes scissors. You lose!";
			}
		}
		
		if(cpuMove == "paper") {
			if(userMove == "rock") {
				cpuScore++;
				resultText = "Paper covers rock. You lose!";
			}
			else if (userMove == "paper") {
				resultText = "Draw!";
			}
			else {
				userScore++;
				resultText = "Scissors cuts paper. You win!";
			}
		}
		
		if(cpuMove == "scissors") {
			if(userMove == "rock") {
				userScore++;
				resultText = "Rock crushes scissors. You win!";
			}
			else if (userMove == "paper") {
				cpuScore++;
				resultText = "Scissors cuts paper. You lose!";
			}
			else {
				resultText = "Draw!";
			}
		}
	}
	
	
}
