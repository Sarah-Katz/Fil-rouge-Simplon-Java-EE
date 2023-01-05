package metier.DTO;

import java.sql.Date;

/**
 * Classe représentant un achat dans le système de gestion du stock.
 *
 * @author Sarah Katz et Thomas Baudrin
 *
 */

public class AchatDTO {
	
	private int idachat;
	private Date dateachat;
	private ProduitDTO produit;
	private FournisseurDTO fournisseur;

	AchatDTO() {
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

	public ProduitDTO getProduit() {
		return produit;
	}

	public void setProduit(ProduitDTO produit) {
		this.produit = produit;
	}

	public FournisseurDTO getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(FournisseurDTO fournisseur) {
		this.fournisseur = fournisseur;
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
	public AchatDTO(final int id, final Date dateachat, final ProduitDTO produit,
			final FournisseurDTO fournisseur) {
		this.idachat = id;
		this.dateachat = dateachat;
		this.produit = produit;
		this.fournisseur = fournisseur;
	}

}
