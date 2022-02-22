package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.sql.Connection;

import Controleur.Based;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login {
	Based based=new Based();
	Connection objetConnection=based.connect();
	
	private JFrame frame;
	private JTextField login;
	private JPasswordField password;
	private String loginn,passwordd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(200, 28, 287, 100);
		frame.getContentPane().add(lblNewLabel);
		
		login = new JTextField();
		login.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		login.setBounds(235, 197, 252, 43);
		frame.getContentPane().add(login);
		login.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		password.setBounds(235, 281, 252, 35);
		frame.getContentPane().add(password);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(23, 197, 184, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(23, 281, 184, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel affichage = new JLabel("");
		affichage.setForeground(Color.RED);
		affichage.setHorizontalAlignment(SwingConstants.CENTER);
		affichage.setFont(new Font("Tahoma", Font.BOLD, 20));
		affichage.setBounds(136, 404, 442, 53);
		frame.getContentPane().add(affichage);
		
		JButton seConnecter = new JButton("Se connecter");
		
		seConnecter.setFont(new Font("Tahoma", Font.BOLD, 20));
		seConnecter.setBounds(266, 347, 184, 35);
		frame.getContentPane().add(seConnecter);
		
		seConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginn=login.getText();
				passwordd=password.getText();
				
				//System.out.println("Login ou mot de passe incorrect");
				/* Vérifier si l'utilisateur exite dans la table */
				
				try {
					String requetteVerification ="select * from authentification where login='"+loginn+"' and password='"+passwordd+"'";
					Statement statementVerification=objetConnection.createStatement();
					ResultSet resultatVerification=statementVerification.executeQuery(requetteVerification);
					if(!resultatVerification.next()) {
						affichage.setText("Login ou mot de passe incorrect");
					}
					else {
						try {
							Choix.main(null);
							frame.setVisible(false);
							
						}catch(Exception exception) {
							exception.printStackTrace();
						}
					}
						
					
				}catch(Exception exception) {
					exception.printStackTrace();
				}
				
				
			}
		});
	}
}
