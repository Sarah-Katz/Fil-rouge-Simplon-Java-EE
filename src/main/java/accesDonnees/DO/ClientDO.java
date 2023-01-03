package accesDonnees.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Classe représentant un client.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "client")
@Data
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
	@OneToOne(mappedBy = "commande")
	private PanierDO panier;

	ClientDO() {
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
