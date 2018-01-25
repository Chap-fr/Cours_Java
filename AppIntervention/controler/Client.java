package controler;

public class Client {
	
	private int idClient;
	private String nom, adresse, typeClient;
	
	public Client() {
		this.idClient=0;
		this.nom="";
		this.adresse ="";
		this.typeClient ="";
	
	}
	
	public Client (int idClient, String nom, String adresse, String typeClient) {
		this.idClient= idClient;
		this.nom=nom;
		this.adresse =adresse;
		this.typeClient =typeClient;
	}
	public Client (String nom, String adresse, String typeClient) {
		this.idClient=0;
		this.nom=nom;
		this.adresse =adresse;
		this.typeClient =typeClient;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

}
