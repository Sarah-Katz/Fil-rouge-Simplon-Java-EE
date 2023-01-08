package metier.DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import accesDonnees.DO.ProduitDO;

/**
 * Classe représentant un achat dans le système de gestion du stock.
 *
 * @author Sarah Katz et Thomas Baudrin
 *
 */

public class AchatDTO {

	private int idachat;
	private Date dateachat;
	private List<ProduitDO> listeprod = new ArrayList<>();
	private boolean active;

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

	public List<ProduitDO> getListeprod() {
		return listeprod;
	}

	public void setListeprod(List<ProduitDO> listeprod) {
		this.listeprod = listeprod;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
	public AchatDTO(final int id, final Date dateachat, final List<ProduitDO> listeprod) {
		this.idachat = id;
		this.dateachat = dateachat;
		this.listeprod = listeprod;
		this.active = true;
	}

}
