package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Choix {

	private JFrame frame2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choix window = new Choix();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Choix() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 698, 441);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(238, 33, 202, 51);
		frame2.getContentPane().add(lblNewLabel);
		
		JButton afficher = new JButton("Afficher");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Afficher.main(null);
			}
		});
		afficher.setForeground(Color.BLUE);
		afficher.setFont(new Font("Tahoma", Font.BOLD, 20));
		afficher.setBounds(256, 141, 173, 56);
		frame2.getContentPane().add(afficher);
		
		JButton inserer = new JButton("Inserer");
		inserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inserer.main(null);
			}
		});
		inserer.setForeground(Color.BLUE);
		inserer.setFont(new Font("Tahoma", Font.BOLD, 20));
		inserer.setBounds(256, 228, 173, 56);
		frame2.getContentPane().add(inserer);
		
		JButton modifier = new JButton("modifier");
		
		modifier.setForeground(Color.BLUE);
		modifier.setFont(new Font("Tahoma", Font.BOLD, 20));
		modifier.setBounds(256, 306, 173, 56);
		frame2.getContentPane().add(modifier);
		
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modifier.main(null);
			}
		});
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
