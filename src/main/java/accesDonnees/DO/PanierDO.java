package accesDonnees.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Classe représentant un panier.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */
@Entity
@Table(name = "panier")
@Data
public class PanierDO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpanier")
	private int idpanier;
	@OneToOne
	private ClientDO client;
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
	public PanierDO(ClientDO client, CommandeDO commande) {
		this.client = client;
		this.commande = commande;
	}

}
