import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {
	private JTextField txtGuess;	// text field for user's guess
	private JLabel lblOutput; 		// label for too high/low output
	private int theNumber; 			// the number to guess
	
	// method to check low\high guess
	public void checkGuess() {
		// get the user's guess
		String guessText = txtGuess.getText(); // get the text from the text field
		String message = "";
		
		// check the guess high/low
		int guess = Integer.parseInt(guessText);
		
		// too high
		if (guess > theNumber) {
			message = guess + " " + " was too high. Guess again!";
			lblOutput.setText(message);
		} else if (guess < theNumber) {
			message = guess + " " + " was too low. Guess again!";
			lblOutput.setText(message);
		} else { // guessed correctly
			message = guess + " " + " is correct. Well done! Let's play again!";
			lblOutput.setText(message);
			newGame();
		}
		// For improved UX
		txtGuess.requestFocus(); // gains focus
		txtGuess.selectAll();      // selects all the text in the field
	}
	
	public void newGame() {     // new random number [1-100]
		
		theNumber = (int) (Math.random() * 100 + 1);	
		
	}
	
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblPetkoTrenevsHilo = new JLabel("Petko Trenev's Hi-Lo Guessing Game");
		lblPetkoTrenevsHilo.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		lblPetkoTrenevsHilo.setBounds(0, 25, 434, 27);
		lblPetkoTrenevsHilo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPetkoTrenevsHilo);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 77, 414, 44);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100: ");
		lblGuessANumber.setBounds(55, 11, 211, 20);
		panel.add(lblGuessANumber);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBounds(264, 11, 62, 20);
		panel.add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(173, 161, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above an click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 209, 434, 27);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		
		App game = new App();
		game.newGame();
		game.setSize(new Dimension(430, 330));     // dimensions of the panel
		game.setVisible(true); 
		
	}
}
