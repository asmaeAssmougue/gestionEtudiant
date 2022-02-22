package DAO;


public class Etudiant {

	static int compteur=0;
	private int id;
	private String nom,prenom,anneeScolaire,filiere;
	public Etudiant(String nom, String prenom, String anneeScolaire, String filiere) {
		super();
		this.id = ++compteur;
		this.nom = nom;
		this.prenom = prenom;
		this.anneeScolaire = anneeScolaire;
		this.filiere = filiere;
	}
	public Etudiant() {
		super();
		this.id = ++compteur;
		this.nom = "";
		this.prenom = "";
		this.anneeScolaire = "";
		this.filiere = "";
	}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAnneeScolaire() {
		return anneeScolaire;
	}
	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", anneeScolaire=" + anneeScolaire
				+ ", filiere=" + filiere + "]";
	}
	
	public void afficher() {System.out.println(this.toString());}
	
	
	
	
	
}
