package accesDonnees.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe représentant un client.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */
@Entity
@Table(name = "client")
public class ClientDO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idclient")
	private int idclient;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "telephone")
	private int tel;
	@Column(name = "mail")
	private String mail;
	@OneToOne
	private PanierDO panier;

	ClientDO() {
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
	public ClientDO(final String nom, final String prenom, final String adresse, final int tel, final String mail,
			final PanierDO panier) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
		this.panier = panier;
	}

}
