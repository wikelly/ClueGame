package GUI;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import clueGame.ClueGame;

public class ControlPanelGUI extends JFrame{

	JTextField whoseTurn;
	JButton nextPlayer, accusation;
	public ControlPanelGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Control Panel");
		setPreferredSize(new Dimension(100, 600));
		setResizable(false);
		setBackground(Color.BLACK);
		createLayout();
	}
	public JPanel showThings(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Control Panel"));
		panel.setPreferredSize(new Dimension(220, 350));
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
		panel.setLayout(new GridLayout(2,1));
		JLabel turn = new JLabel("Whose turn?");
		whoseTurn = new JTextField(8);
		panel.setBorder(new EtchedBorder());
		panel.add(turn);
		panel.add(whoseTurn);
		panel.setPreferredSize(new Dimension(200, 100));
		return panel;
	}
	//Buttons Next Player and make an Accusation
	private JPanel createButtonsPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBorder(new EtchedBorder());
		nextPlayer = new JButton("Next Player");
		nextPlayer.setBorder(new EtchedBorder());
		panel.add(nextPlayer);
		accusation = new JButton("Make an accusation");
		accusation.setBorder(new EtchedBorder());
		//Button to Color Black and Text to White
		nextPlayer.setBackground(Color.GRAY);
		nextPlayer.setForeground(Color.WHITE);
		//This Gets rid of that on hover border
		nextPlayer.setBorderPainted(false);
		// Tried adjusting size seems like it likes the preferred size
		nextPlayer.setPreferredSize(new Dimension(200,50));
		accusation.setBackground(Color.GRAY);
		accusation.setForeground(Color.WHITE);
		accusation.setPreferredSize(new Dimension(200,50));
		panel.add(accusation);
		return panel;
	}
	
	private JPanel createOthersPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		panel.setBorder(new EtchedBorder());
		panel.setPreferredSize(new Dimension(200,100));
		JLabel die = new JLabel("Die Roll");
		JTextField dieRoll = new JTextField(5);
		dieRoll.setEditable(false);
		panel.add(die);
		panel.add(dieRoll);
		JLabel guess = new JLabel("Guess");
		JTextField guessIn = new JTextField(5);
		guessIn.setEditable(false);
		panel.add(guess);
		panel.add(guessIn);
		JLabel guessResult = new JLabel("Guess Result");
		JTextField guessOut = new JTextField(5);
		guessOut.setEditable(false);
		panel.add(guessResult);
		panel.add(guessOut);
		return panel;
		
	}
	public static void main(String[] args) {
		ControlPanelGUI gui = new ControlPanelGUI();
		gui.setVisible(true);
		

	}
}
