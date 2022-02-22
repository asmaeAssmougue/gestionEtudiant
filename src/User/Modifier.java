package User;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;



import Controleur.Based;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Modifier {

	private JFrame frame;
	private JTextField idSaisie;
	Based based = new Based();
	Connection connection=based.connect();
	private JTextField nom;
	private JTextField prenom;
	private JTextField anneeScolaire;
	private JTextField filiere;
	private JTextField nouveauNom;
	private JTextField nouveauPrenom;
	private JTextField nouveauAnneeScolaire;
	private JTextField nouveauFiliere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modifier window = new Modifier();
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
	public Modifier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 897, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modifier Etudiant");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(42, 10, 437, 62);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Veuillez saisir ID d'Etudiant");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(23, 92, 319, 62);
		frame.getContentPane().add(lblNewLabel_1);
		
		idSaisie = new JTextField();
		idSaisie.setFont(new Font("Tahoma", Font.BOLD, 20));
		idSaisie.setHorizontalAlignment(SwingConstants.CENTER);
		idSaisie.setBounds(305, 97, 96, 49);
		frame.getContentPane().add(idSaisie);
		idSaisie.setColumns(10);
		
		JButton btnNewButton = new JButton("Chercher");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(231, 164, 129, 49);
		frame.getContentPane().add(btnNewButton);
		
		JLabel attention = new JLabel("");
		attention.setForeground(Color.RED);
		attention.setFont(new Font("Tahoma", Font.BOLD, 20));
		attention.setBounds(140, 243, 339, 44);
		frame.getContentPane().add(attention);
		
		JLabel label1 = new JLabel("Nom :  ");
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setBounds(10, 321, 102, 29);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Pr\u00E9nom :");
		label2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label2.setBounds(10, 365, 102, 29);
		frame.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Ann\u00E9e Scolaire :");
		label3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label3.setBounds(10, 415, 168, 29);
		frame.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("Fili\u00E8re :");
		label4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label4.setBounds(10, 455, 102, 29);
		frame.getContentPane().add(label4);
		
		nom = new JTextField();
		nom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		nom.setBounds(218, 325, 142, 29);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		prenom.setColumns(10);
		prenom.setBounds(218, 369, 142, 29);
		frame.getContentPane().add(prenom);
		
		anneeScolaire = new JTextField();
		anneeScolaire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		anneeScolaire.setColumns(10);
		anneeScolaire.setBounds(218, 413, 142, 29);
		frame.getContentPane().add(anneeScolaire);
		
		filiere = new JTextField();
		filiere.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		filiere.setColumns(10);
		filiere.setBounds(218, 455, 142, 29);
		frame.getContentPane().add(filiere);
		
		JLabel labelNom = new JLabel("Nom :");
		labelNom.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelNom.setBounds(432, 185, 102, 29);
		frame.getContentPane().add(labelNom);
		
		JLabel labelPrenom = new JLabel("Pr\u00E9nom :");
		labelPrenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelPrenom.setBounds(432, 243, 102, 29);
		frame.getContentPane().add(labelPrenom);
		
		JLabel labelAnneeScolaire = new JLabel("Ann\u00E9e Scolaire :");
		labelAnneeScolaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelAnneeScolaire.setBounds(432, 297, 193, 29);
		frame.getContentPane().add(labelAnneeScolaire);
		
		JLabel labelFiliere = new JLabel("Fili\u00E8re :");
		labelFiliere.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelFiliere.setBounds(443, 349, 159, 29);
		frame.getContentPane().add(labelFiliere);
		
		JLabel nouvelleInformation = new JLabel("Nouvelle Information");
		nouvelleInformation.setHorizontalAlignment(SwingConstants.CENTER);
		nouvelleInformation.setForeground(Color.RED);
		nouvelleInformation.setFont(new Font("Tahoma", Font.BOLD, 23));
		nouvelleInformation.setBounds(436, 97, 437, 62);
		frame.getContentPane().add(nouvelleInformation);
		
		nouveauNom = new JTextField();
		nouveauNom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		nouveauNom.setBounds(659, 185, 179, 28);
		frame.getContentPane().add(nouveauNom);
		nouveauNom.setColumns(10);
		
		nouveauPrenom = new JTextField();
		nouveauPrenom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		nouveauPrenom.setColumns(10);
		nouveauPrenom.setBounds(659, 243, 179, 28);
		frame.getContentPane().add(nouveauPrenom);
		
		nouveauAnneeScolaire = new JTextField();
		nouveauAnneeScolaire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		nouveauAnneeScolaire.setColumns(10);
		nouveauAnneeScolaire.setBounds(659, 302, 179, 28);
		frame.getContentPane().add(nouveauAnneeScolaire);
		
		nouveauFiliere = new JTextField();
		nouveauFiliere.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		nouveauFiliere.setColumns(10);
		nouveauFiliere.setBounds(659, 352, 179, 28);
		frame.getContentPane().add(nouveauFiliere);
		
		JButton bouttonModifier = new JButton("Modifier");
		bouttonModifier.setFont(new Font("Tahoma", Font.BOLD, 20));
		bouttonModifier.setBounds(693, 415, 129, 36);
		frame.getContentPane().add(bouttonModifier);
		
		JLabel attentionDeux = new JLabel("");
		attentionDeux.setForeground(Color.RED);
		attentionDeux.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		attentionDeux.setHorizontalAlignment(SwingConstants.CENTER);
		attentionDeux.setBounds(432, 482, 406, 47);
		frame.getContentPane().add(attentionDeux);
		
		JButton btnNewButton_1 = new JButton("Fermer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(659, 24, 163, 44);
		frame.getContentPane().add(btnNewButton_1);
		labelNom.setVisible(false);
		labelPrenom.setVisible(false);
		labelAnneeScolaire.setVisible(false);
		labelFiliere.setVisible(false);
		nouveauNom.setVisible(false);
		nouveauPrenom.setVisible(false);
		nouveauAnneeScolaire.setVisible(false);
		nouveauFiliere.setVisible(false);
		nouvelleInformation.setVisible(false);
		bouttonModifier.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		nom.setVisible(false);
		prenom.setVisible(false);
		anneeScolaire.setVisible(false);
		filiere.setVisible(false);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				id=Integer.parseInt(idSaisie.getText());
				try {
					String requette ="SELECT * FROM etudiant WHERE id="+id+"";
					Statement statement=connection.createStatement();
					ResultSet resultat=statement.executeQuery(requette);
					if(!resultat.next()) {
						nom.setText("");
						prenom.setText("");
						anneeScolaire.setText("");
						filiere.setText("");
						attention.setText("ID n'existe pas dans la table");
						labelNom.setVisible(false);
						labelPrenom.setVisible(false);
						labelAnneeScolaire.setVisible(false);
						labelFiliere.setVisible(false);
						nouveauNom.setVisible(false);
						nouveauPrenom.setVisible(false);
						nouveauAnneeScolaire.setVisible(false);
						nouveauFiliere.setVisible(false);
						nouvelleInformation.setVisible(false);
						bouttonModifier.setVisible(false);
					}
					else {
						attention.setText("");
						label1.setVisible(true);
						label2.setVisible(true);
						label3.setVisible(true);
						label4.setVisible(true);
						nom.setVisible(true);
						prenom.setVisible(true);
						anneeScolaire.setVisible(true);
						filiere.setVisible(true);
						nom.setText(resultat.getString("nom"));
						prenom.setText(resultat.getString("prenom"));
						anneeScolaire.setText(resultat.getString("anneeScolaire"));
						filiere.setText(resultat.getString("Filiere"));
						/* afficher les autres champs */
						labelNom.setVisible(true);
						labelPrenom.setVisible(true);
						labelAnneeScolaire.setVisible(true);
						labelFiliere.setVisible(true);
						nouveauNom.setVisible(true);
						nouveauPrenom.setVisible(true);
						nouveauAnneeScolaire.setVisible(true);
						nouveauFiliere.setVisible(true);
						nouvelleInformation.setVisible(true);
						bouttonModifier.setVisible(true);
						bouttonModifier.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String nouveauNomm,nouveauPrenomm,nouveauAnneeScolairee,nouveauFilieree;
								nouveauNomm=nouveauNom.getText();
								nouveauPrenomm=nouveauPrenom.getText();
								nouveauAnneeScolairee=nouveauAnneeScolaire.getText();
								nouveauFilieree=nouveauFiliere.getText();
								if(!nouveauNomm.isEmpty() &&  !nouveauPrenomm.isEmpty() && !nouveauAnneeScolairee.isEmpty() && !nouveauFilieree.isEmpty()) {
									attentionDeux.setText("");
									try {
										String requetteUpdate="UPDATE `etudiant` SET `nom`='"+nouveauNomm+"',`prenom`='"+nouveauPrenomm+"',`anneeScolaire`='"+nouveauAnneeScolairee+"',`Filiere`='"+nouveauFilieree+"' WHERE id="+id+"";
										Statement statementUpdate=connection.createStatement();
										int resultatUpdate=statementUpdate.executeUpdate(requetteUpdate);
										labelNom.setVisible(false);
										labelPrenom.setVisible(false);
										labelAnneeScolaire.setVisible(false);
										labelFiliere.setVisible(false);
										nouveauNom.setVisible(false);
										nouveauPrenom.setVisible(false);
										nouveauAnneeScolaire.setVisible(false);
										nouveauFiliere.setVisible(false);
										nouvelleInformation.setVisible(false);
										bouttonModifier.setVisible(false);
										label1.setVisible(false);
										label2.setVisible(false);
										label3.setVisible(false);
										label4.setVisible(false);
										nom.setVisible(false);
										prenom.setVisible(false);
										anneeScolaire.setVisible(false);
										filiere.setVisible(false);
										
										
									}catch(Exception exception) {
										exception.printStackTrace();
									}
								}
								else {
									attentionDeux.setText("Veuillez remplir tous les champs");
								}

							}
						});
						
						
						
						
					}
				}catch(Exception exception) {
					exception.printStackTrace();
				}
				
			}
		});
	}
}
