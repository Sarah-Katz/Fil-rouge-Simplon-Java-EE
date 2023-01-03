package metier.DTO;

import accesDonnees.DO.PanierDO;

public class ClientDTO {
	
	private int idclient;
	private String nom;
	private String prenom;
	private String adresse;
	private int tel;
	private String mail;
	private PanierDO panier;

	ClientDTO() {
	}
	
	

	public int getIdclient() {
		return idclient;
	}



	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public int getTel() {
		return tel;
	}



	public void setTel(int tel) {
		this.tel = tel;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public PanierDO getPanier() {
		return panier;
	}



	public void setPanier(PanierDO panier) {
		this.panier = panier;
	}



	/**
	 * Constructeur permettant de créer un nouveau client.
	 *
	 * @param nom     le nom du client
	 * @param prenom  le prénom du client
	 * @param adresse l'adresse du client
	 * @param tel     le numéro de téléphone du client
	 * @param mail    l'adresse mail du client
	 * @param panier  le panier du client
	 */
	public ClientDTO(final int idclient, final String nom, final String prenom, final String adresse, final int tel, final String mail,
			final PanierDO panier) {
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
		this.panier = panier;
	}

}
