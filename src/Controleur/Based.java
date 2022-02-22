package Controleur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



import DAO.Etudiant;
import User.Afficher;

public class Based {


		public Connection connect() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//System.out.println("Driver Ok");
				String url ="jdbc:mysql://localhost:3306/Ecole";
				String user="root";
				String password="root";
				Connection con=DriverManager.getConnection(url,user,password);
				System.out.println(" *************************** connection avec succès ***************************");
				return con;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		/*************************************************************************************************************************/
		/*************************************************************************************************************************/
		/*************************************************************************************************************************/

		/* la fonction d'affichage */
		public Statement selection(Connection connection) {
			try {
				String requette ="select * from etudiant";
				Statement statement=connection.createStatement();
				ResultSet resultat=statement.executeQuery(requette);
				while(resultat.next()) {
					System.out.println("Id : "+resultat.getInt("id")+".\t Nom :  "+resultat.getString("nom")+" \t Prénom "+resultat.getString("prenom") +"\t Année Scolaire : "+resultat.getString("anneeScolaire")+ " \t Filière : "+resultat.getString("filiere"));
				}
				return statement;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		/*************************************************************************************************************************/
		/*************************************************************************************************************************/
		/*************************************************************************************************************************/

		/* fonction d'insertion des données. */
		public Statement insertion(Connection connection) {
			Etudiant etudiant = new Etudiant();
			int id;
			try {
				String requetteMaxId ="SELECT MAX(id) FROM `etudiant` WHERE 1";
				Statement statementMaxId=connection.createStatement();
				ResultSet resultatMaxId=statementMaxId.executeQuery(requetteMaxId);
				if(!resultatMaxId.next()) {
					etudiant.setId(1);
				}
				else {
					id=resultatMaxId.getInt("Max(id)");
					id +=1;
					etudiant.setId(id);
				}
				
				Statement statement=connection.createStatement();
				Scanner scanner=new Scanner(System.in);
				String nom,prenom,anneeScolaire,filiere;
				
				/* saisie des données */
				System.out.println("************************************ Etudiant "+etudiant.getId()+" : ************************************");
				System.out.print("Nom :");
				nom=scanner.nextLine();
				System.out.print("Prénom :");
				prenom=scanner.nextLine();
				System.out.print("Année :");
				anneeScolaire=scanner.nextLine();
				System.out.print("Filière :");
				filiere=scanner.nextLine();
				etudiant.setNom(nom);etudiant.setPrenom(prenom);etudiant.setAnneeScolaire(anneeScolaire);etudiant.setFiliere(filiere);
				String requette="INSERT INTO `etudiant` VALUES ("+etudiant.getId()+",'"+etudiant.getNom()+"','"+etudiant.getPrenom()+"','"+etudiant.getAnneeScolaire()+"','"+etudiant.getFiliere()+"')";
				int rs=statement.executeUpdate(requette);
				return statement;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		/*************************************************************************************************************************/
		/*************************************************************************************************************************/
		/*************************************************************************************************************************/
		
		public int modification(Connection connection) {
			try {
				Scanner scanner=new Scanner(System.in);
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				int id;
				String nom,prenom,anneeScolaire,filiere;
				System.out.print("Veuillez saisir l'id de l'étudiant a modifié : ");
				id=scanner.nextInt();
				String requette ="SELECT * FROM Etudiant WHERE id="+id+"";
				Statement statement=connection.createStatement();
				ResultSet resultat=statement.executeQuery(requette);
				if(!resultat.next()) {System.out.println("Ce Id n'existe pas dans la table"); return 0;}
				else {
					System.out.println("******************************************************************************");
					System.out.println("La Personne que vous voulez supprimer est :");
					System.out.println("Id : "+resultat.getInt("id")+".\t \t Nom :  "+resultat.getString("nom")+" \t \t Prénom : "+resultat.getString("prenom") +"\t \tAnnée Scolaire : "+resultat.getString("anneeScolaire")+ " \t \t Filière : "+resultat.getString("filiere"));
					System.out.print("Nom :");
					nom=input.readLine();
					System.out.print("Prénom :");
					prenom=input.readLine();
					System.out.print("Année :");
					anneeScolaire=input.readLine();
					System.out.print("Filière :");
					filiere=input.readLine();
					String requetteUpdate="UPDATE `etudiant` SET `nom`='"+nom+"',`prenom`='"+prenom+"',`anneeScolaire`='"+anneeScolaire+"',`Filiere`='"+filiere+"' WHERE id="+id+"";
					int resultatUpdate=statement.executeUpdate(requetteUpdate);
					return resultatUpdate;
				}
				/*
				System.out.println("Veuillez saisir le prenom de l'étudiant a modifié : ");
				prenom=scanner.nextLine();
				System.out.println("Veuillez saisir la filiere de l'étudiant a modifié : ");
				filiere=scanner.nextLine();
				Statement statement=connection.createStatement();
				String requette="UPDATE `etudiant` SET `nom`='"+nom+"',`prenom`='"+prenom+"',`filiere`='"+filiere+"' WHERE id="+id+"";
				int resultat=statement.executeUpdate(requette);*/
				//return 1;
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}
			
		}
		
		
		
	
}
