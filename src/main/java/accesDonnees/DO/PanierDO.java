package accesDonnees.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Classe représentant un panier.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */
@Entity
@Table(name = "panier")
public class PanierDO extends ClientDO{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpanier")
	private int idpanier;
	@OneToOne
	private CommandeDO commande;

	PanierDO() {
	}

	/**
	 * Constructeur permettant de créer un nouveau panier.
	 *
	 * @param client   le client associé au panier
	 * @param commande la commande associée au panier
	 */
	public PanierDO(final CommandeDO commande) {
		this.commande = commande;
	}

	/**
	 * @return the idpanier
	 */
	public int getIdpanier() {
		return idpanier;
	}

	/**
	 * @param idpanier the idpanier to set
	 */
	public void setIdpanier(int idpanier) {
		this.idpanier = idpanier;
	}

	/**
	 * @return the commande
	 */
	public CommandeDO getCommande() {
		return commande;
	}

	/**
	 * @param commande the commande to set
	 */
	public void setCommande(CommandeDO commande) {
		this.commande = commande;
	}

}
