package metier.DTO;

public class PanierDTO {
	private int idpanier;
	private CommandeDTO commande;

	PanierDTO() {
	}

	/**
	 * Constructeur permettant de créer un nouveau panier.
	 *
	 * @param client   le client associé au panier
	 * @param commande la commande associée au panier
	 */
	public PanierDTO(int idpanier, CommandeDTO commande) {
		this.idpanier = idpanier;
		this.commande = commande;
	}

	public int getIdpanier() {
		return idpanier;
	}

	public void setIdpanier(int idpanier) {
		this.idpanier = idpanier;
	}

	public CommandeDTO getCommande() {
		return commande;
	}

	public void setCommande(CommandeDTO commande) {
		this.commande = commande;
	}



}
