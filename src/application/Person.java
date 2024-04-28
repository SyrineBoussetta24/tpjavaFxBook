package application;

public class Person {
	private String prenom ;
	private String nom ;
	private String mail ;
	public Person(String prenom, String nom, String mail) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Person [prenom=" + prenom + ", nom=" + nom + ", mail=" + mail + "]";
	}
	public Person() {
		super();
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	

}
