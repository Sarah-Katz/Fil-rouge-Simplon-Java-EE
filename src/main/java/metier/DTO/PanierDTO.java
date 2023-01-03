package metier.DTO;

import accesDonnees.DO.ClientDO;

public class PanierDTO {
	private int idpanier;
	private ClientDO client;
	private CommandeDTO commande;

	PanierDTO() {
	}

	/**
	 * Constructeur permettant de créer un nouveau panier.
	 *
	 * @param client   le client associé au panier
	 * @param commande la commande associée au panier
	 */
	public PanierDTO(int idpanier, ClientDO client, CommandeDTO commande) {
		this.idpanier = idpanier;
		this.client = client;
		this.commande = commande;
	}

	public int getIdpanier() {
		return idpanier;
	}

	public void setIdpanier(int idpanier) {
		this.idpanier = idpanier;
	}

	public ClientDO getClient() {
		return client;
	}

	public void setClient(ClientDO client) {
		this.client = client;
	}

	public CommandeDTO getCommande() {
		return commande;
	}

	public void setCommande(CommandeDTO commande) {
		this.commande = commande;
	}
	
	

}
