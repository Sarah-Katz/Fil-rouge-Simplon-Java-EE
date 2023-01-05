package accesDonnees.DO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe représentant un achat dans le système de gestion du stock.
 *
 * @author Sarah Katz et Thomas Baudrin
 *
 */
@Entity
@Table(name = "achat")
public class AchatDO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idachat")
	private int idachat;
	@Column(name = "dateachat")
	private Date dateachat;
	@OneToOne
	private ProduitDO produit;
	@OneToOne
	@JoinColumn(name = "idfour")
	private FournisseurDO fournisseur;

	AchatDO() {
	}

	/**
	 * Constructeur de la classe.
	 *
	 * @param dateachat   Date de l'achat.
	 * @param quantite    Quantité achetée.
	 * @param prix        Prix total de l'achat.
	 * @param produit     Produit acheté.
	 * @param fournisseur Fournisseur de l'achat.
	 */
	public AchatDO(final Date dateachat, final ProduitDO produit, final FournisseurDO fournisseur) {
		this.dateachat = dateachat;
		this.produit = produit;
		this.fournisseur = fournisseur;
	}
	
	public int getIdachat() {
		return idachat;
	}

	public void setIdachat(int idachat) {
		this.idachat = idachat;
	}

	public Date getDateachat() {
		return dateachat;
	}

	public void setDateachat(Date dateachat) {
		this.dateachat = dateachat;
	}

	public ProduitDO getProduit() {
		return produit;
	}

	public void setProduit(ProduitDO produit) {
		this.produit = produit;
	}

	public FournisseurDO getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(FournisseurDO fournisseur) {
		this.fournisseur = fournisseur;
	}

	

}