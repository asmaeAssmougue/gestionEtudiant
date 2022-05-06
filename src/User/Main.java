package User;
import java.sql.Connection;
import Controleur.Based;
import DAO.Etudiant;

public class Main {

	public static void main(String[] args) {
		

		
		Based based = new Based();
		Connection objetConnection =based.connect();
		based.insertion(objetConnection);
	

		
		
		
		
		
	}

}
