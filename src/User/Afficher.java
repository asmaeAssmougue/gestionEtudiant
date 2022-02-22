package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.SwingConstants;

import Controleur.Based;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Afficher {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Afficher window = new Afficher();
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
	public Afficher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Afficher Les Etudiants");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(199, 25, 311, 83);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 123, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nom");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(114, 123, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Prenom");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(256, 123, 89, 13);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ann\u00E9e");
		lblNewLabel_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(433, 123, 89, 13);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Fili\u00E8re");
		lblNewLabel_2_3.setForeground(Color.BLUE);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(593, 123, 105, 13);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JTextArea id = new JTextArea();
		id.setFont(new Font("Monospaced", Font.BOLD, 17));
		id.setBounds(29, 158, 32, 353);
		frame.getContentPane().add(id);
		
		JTextArea nom = new JTextArea();
		nom.setFont(new Font("Monospaced", Font.BOLD, 17));
		nom.setBounds(87, 158, 121, 353);
		frame.getContentPane().add(nom);
		
		JTextArea prenom = new JTextArea();
		prenom.setFont(new Font("Monospaced", Font.BOLD, 17));
		prenom.setBounds(234, 162, 158, 353);
		frame.getContentPane().add(prenom);
		
		JTextArea annee = new JTextArea();
		annee.setFont(new Font("Monospaced", Font.BOLD, 18));
		annee.setBounds(417, 162, 105, 353);
		frame.getContentPane().add(annee);
		
		JTextArea filiere = new JTextArea();
		filiere.setFont(new Font("Monospaced", Font.BOLD, 18));
		filiere.setBounds(532, 162, 245, 353);
		frame.getContentPane().add(filiere);
		
		JButton btnNewButton = new JButton("Fermer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(593, 52, 129, 39);
		frame.getContentPane().add(btnNewButton);
		
		Based based = new Based();
		Connection connection=based.connect();
		try {
			String requette ="select * from etudiant";
			Statement statement=connection.createStatement();
			ResultSet resultat=statement.executeQuery(requette);
			while(resultat.next()) {
				
				id.append(String.valueOf(resultat.getInt("id"))+" \n");
				nom.append(resultat.getString("nom")+" \n");
				prenom.append(resultat.getString("prenom")+" \n");
				annee.append(resultat.getString("anneeScolaire")+" \n");
				filiere.append(resultat.getString("filiere")+" \n");
				//System.out.println("Id : "+resultat.getInt("id")+".\t Nom :  "+resultat.getString("nom")+" \t Prénom "+resultat.getString("prenom") +"\t Année Scolaire : "+resultat.getString("anneeScolaire")+ " \t Filière : "+resultat.getString("filiere"));
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		//based.selection(connection,)
		
		
		
	}
}
