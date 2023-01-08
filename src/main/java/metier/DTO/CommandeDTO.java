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
	private List<ProduitDO> listeprod = new ArrayList<>();

	CommandeDTO() {
	}

	/**
	 * Constructeur permettant de créer une nouvelle commande.
	 *
	 * @param date      la date de la commande
	 * @param listeprod la liste des produits de la commande
	 * @param prix      le prix total de la commande
	 */
	public CommandeDTO(int idcomm, Date date, List<ProduitDO> listeprod) {
		this.idcomm = idcomm;
		this.date = date;
		this.listeprod = listeprod;
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



}
