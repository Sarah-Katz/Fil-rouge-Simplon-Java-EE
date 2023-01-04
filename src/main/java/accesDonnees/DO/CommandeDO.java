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
	@Column(name = "prixcomm")
	private double prix;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "commande")
	private List<ProduitDO> listeprod = new ArrayList<ProduitDO>();

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



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public List<ProduitDO> getListeprod() {
		return listeprod;
	}



	public void setListeprod(List<ProduitDO> listeprod) {
		this.listeprod = listeprod;
	}



	/**
	 * Constructeur permettant de créer une nouvelle commande.
	 *
	 * @param date      la date de la commande
	 * @param listeprod la liste des produits de la commande
	 * @param prix      le prix total de la commande
	 */
	public CommandeDO(Date date, List<ProduitDO> listeprod, double prix) {
		this.date = date;
		this.listeprod = listeprod;
		this.prix = prix;
	}

}
