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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inserer {

	private JFrame frame;
	private JTextField nom;
	private JTextField prenom;
	private JTextField annee;
	private JTextField filiere;
	Based based = new Based();
	Connection connection=based.connect();
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserer window = new Inserer();
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
	public Inserer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 869, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter Des Etudiants");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(188, 30, 405, 86);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(32, 149, 164, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pr\u00E9nom :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(32, 217, 164, 43);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ann\u00E9e Scolaire :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(32, 289, 164, 43);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fili\u00E8re :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(32, 358, 164, 43);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		nom = new JTextField();
		nom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		nom.setBounds(216, 153, 239, 34);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		prenom.setColumns(10);
		prenom.setBounds(216, 221, 239, 34);
		frame.getContentPane().add(prenom);
		
		annee = new JTextField();
		annee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		annee.setColumns(10);
		annee.setBounds(216, 293, 239, 34);
		frame.getContentPane().add(annee);
		
		filiere = new JTextField();
		filiere.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		filiere.setColumns(10);
		filiere.setBounds(216, 362, 239, 34);
		frame.getContentPane().add(filiere);
		
		btnNewButton = new JButton("Ajouter");
		
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(254, 424, 164, 43);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Fermer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(650, 60, 164, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel attention = new JLabel("");
		attention.setForeground(Color.RED);
		attention.setFont(new Font("Tahoma", Font.BOLD, 19));
		attention.setHorizontalAlignment(SwingConstants.CENTER);
		attention.setBounds(188, 477, 328, 49);
		frame.getContentPane().add(attention);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomm,prenomm,anneeScolairee,filieree;
					int id;
					nomm=nom.getText();
					prenomm=prenom.getText();
					anneeScolairee=annee.getText();
					filieree=filiere.getText();
					if(!nomm.isEmpty() && !prenomm.isEmpty() && !anneeScolairee.isEmpty() && !filieree.isEmpty()) {
						String requetteMaxId ="SELECT MAX(id) FROM `etudiant` WHERE 1";
						Statement statementMaxId=connection.createStatement();
						ResultSet resultatMaxId=statementMaxId.executeQuery(requetteMaxId);
						if(!resultatMaxId.next()) {
							id=1;
							String requette="INSERT INTO `etudiant` VALUES ("+id+",'"+nomm+"','"+prenomm+"','"+anneeScolairee+"','"+filieree+"')";
							Statement statement = connection.createStatement();
							int rs=statement.executeUpdate(requette);
							nom.setText("");prenom.setText("");annee.setText("");filiere.setText("");
						}
						else {
							id=resultatMaxId.getInt("Max(id)");
							id +=1;
							String requette="INSERT INTO `etudiant` VALUES ("+id+",'"+nomm+"','"+prenomm+"','"+anneeScolairee+"','"+filieree+"')";
							Statement statement = connection.createStatement();
							int rs=statement.executeUpdate(requette);
							nom.setText("");prenom.setText("");annee.setText("");filiere.setText("");
						}
					}else attention.setText("Veuillez Remplir tous les champs");
					
					
				}catch(Exception exception) {
					exception.printStackTrace();
				}
				
			}
		});
		
		
	}
}
