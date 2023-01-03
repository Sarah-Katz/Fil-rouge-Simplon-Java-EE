package accesDonnees.DO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Classe représentant un fournisseur.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */
@Entity
@Table(name = "fournisseur")
@Data
public class FournisseurDO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idfour")
	private int idfour;
	@Column(name = "nomfour")
	private String nom;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produit")
	private CommandeDO commande;

	public FournisseurDO() {
	}

	/**
	 * Constructeur permettant de créer un nouveau fournisseur.
	 *
	 * @param nom le nom du fournisseur
	 */
	public FournisseurDO(final String nom) {
		this.nom = nom;
	}

	public int getIdfour() {
		return idfour;
	}

	public void setIdfour(int idfour) {
		this.idfour = idfour;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public CommandeDO getCommande() {
		return commande;
	}

	public void setCommande(CommandeDO commande) {
		this.commande = commande;
	}
	
	

}