package User;
import java.sql.Connection;
import Controleur.Based;
import DAO.Etudiant;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Etudiant etudiant = new Etudiant("Retro","Aymen","2021","Génie informatique");
		//etudiant.afficher();
		Based based = new Based();
		Connection objetConnection =based.connect();
		based.insertion(objetConnection);
		//based.selection(objetConnection);
		//based.insertion(objetConnection);
		//based.insertion(objetConnection);
		//based.insertion(objetConnection);
		//based.modification(objetConnection);

		
		
		
		
		
	}

}
