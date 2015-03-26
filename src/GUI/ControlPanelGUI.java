package GUI;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import clueGame.ClueGame;

public class ControlPanelGUI extends JFrame{

	JTextField whoseTurn;
	JButton nextPlayer, accusation;
	public ControlPanelGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Control Panel");
		setSize(600, 250);
		setResizable(false);
		setBackground(Color.BLACK);
		createLayout();
	}
	public JPanel showThings(){
		JPanel panel = new JPanel();
		panel.add(createButtonsPanel());
		panel.add(createNamesPanel());
		panel.add(createOthersPanel());
		return panel;
	}
	public JPanel createLayout(){
		/*JPanel final = new JPanel();
		JPanel names = createNamesPanel();
		final.add(names, BorderLayout.WEST);
		JPanel buttons = createButtonsPanel();
		final.add(buttons, BorderLayout.EAST);
		JPanel die = createOthersPanel();
		final.add(die, BorderLayout.SOUTH);
		
		return final;*/
		return null;
		
	}
	//Ask's Whos turn
	private JPanel createNamesPanel(){
		JPanel panel = new JPanel();
		JLabel turn = new JLabel("Whose turn?");
		whoseTurn = new JTextField(10);
		panel.add(turn, BorderLayout.CENTER);
		panel.add(whoseTurn, BorderLayout.SOUTH);
		
		return panel;
	}
	//Buttons Next Player and make an Accusation
	private JPanel createButtonsPanel(){
		JPanel panel = new JPanel();
		nextPlayer = new JButton("Next Player");
		panel.add(nextPlayer, BorderLayout.WEST);
		accusation = new JButton("Make an accusation");
		//Button to Color Black and Text to White
		nextPlayer.setBackground(Color.GRAY);
		nextPlayer.setForeground(Color.WHITE);
		//This Gets rid of that on hover border
		nextPlayer.setBorderPainted(false);
		// Tried adjusting size seems like it likes the preferred size
		nextPlayer.setSize(200, 200);
		accusation.setBackground(Color.GRAY);
		accusation.setForeground(Color.WHITE);
		panel.add(accusation, BorderLayout.EAST);
		return panel;
	}
	
	private JPanel createOthersPanel(){
		JPanel panel = new JPanel();
		JLabel die = new JLabel("Die Roll");
		JTextField dieRoll = new JTextField(5);
		dieRoll.setEditable(false);
		panel.add(die, BorderLayout.WEST);
		panel.add(dieRoll, BorderLayout.WEST);
		JLabel guess = new JLabel("Guess");
		JTextField guessIn = new JTextField(5);
		guessIn.setEditable(false);
		panel.add(guess, BorderLayout.CENTER);
		panel.add(guessIn, BorderLayout.CENTER);
		JLabel guessResult = new JLabel("Guess Result");
		JTextField guessOut = new JTextField(5);
		guessOut.setEditable(false);
		panel.add(guessResult, BorderLayout.EAST);
		panel.add(guessOut, BorderLayout.EAST);
		return panel;
		
	}
	public static void main(String[] args) {
		ControlPanelGUI gui = new ControlPanelGUI();
		gui.setVisible(true);
		

	}
}
