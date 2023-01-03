package metier.DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import accesDonnees.DO.ProduitDO;


/**
 * Classe représentant une commande.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */

public class CommandeDTO {
	
	private int idcomm;
	private Date date;
	private double prix;
	private List<ProduitDO> listeprod = new ArrayList<ProduitDO>();

	CommandeDTO() {
	}

	/**
	 * Constructeur permettant de créer une nouvelle commande.
	 *
	 * @param date      la date de la commande
	 * @param listeprod la liste des produits de la commande
	 * @param prix      le prix total de la commande
	 */
	public CommandeDTO(int idcomm, Date date, List<ProduitDO> listeprod, double prix) {
		this.idcomm = idcomm;
		this.date = date;
		this.listeprod = listeprod;
		this.prix = prix;
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
	
	

}
