package accesDonnees.DO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "achats")
	private List<ProduitDO> listeprod = new ArrayList<ProduitDO>();
	@Column(name = "active")
	private boolean active;

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
	public AchatDO(final Date dateachat, final List<ProduitDO> listeprod) { 
		this.dateachat = dateachat;
		this.listeprod = listeprod;
		this.active = true;
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
	
	

	

}