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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe représentant une commande.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */
@Entity
@Table(name = "commande")
public class CommandeDO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcomm")
	private int idcomm;
	@Column(name = "datecomm")
	private Date date;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "commande")
	private List<ProduitDO> listeprod = new ArrayList<>();
	@Column(name = "active")
	private boolean active;

	CommandeDO() {
	}



	public int getIdcomm() {
		return idcomm;
	}



	public void setIdcomm(int idcomm) {
		this.idcomm = idcomm;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
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
	 * Constructeur permettant de créer une nouvelle commande.
	 *
	 * @param date      la date de la commande
	 * @param listeprod la liste des produits de la commande
	 * @param prix      le prix total de la commande
	 */
	public CommandeDO(Date date, List<ProduitDO> listeprod) {
		this.date = date;
		this.listeprod = listeprod;
		this.active = true;
	}

}
