package QO_App;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class UserInterface {

	private JFrame frame;
	private JLabel printLabel;
	private FetchPlayers data = new FetchPlayers(); 
	private JLabel maxLabel;
	private JLabel minLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnQualifyingOffer = new JButton("Fetch Qualifying Offer");
		btnQualifyingOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.getPlayers();
				printLabel.setText("Qualifying offer = $" + String.valueOf(data.getQO()));
				maxLabel.setText("Max Salary = $" + String.valueOf(data.getMax()));
				minLabel.setText("Min Salary = $" + String.valueOf(data.getMin()));
			}
		});
		btnQualifyingOffer.setBounds(16, 41, 201, 29);
		frame.getContentPane().add(btnQualifyingOffer);
		
		 printLabel = new JLabel("");
		printLabel.setBounds(6, 73, 292, 21);
		frame.getContentPane().add(printLabel);
		
		maxLabel = new JLabel("");
		maxLabel.setBounds(6, 109, 270, 21);
		frame.getContentPane().add(maxLabel);
		
		minLabel = new JLabel("");
		minLabel.setBounds(6, 152, 305, 21);
		frame.getContentPane().add(minLabel);
	}
}
