package controllers;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/achat")
public class AchatController {
	private final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private final PanierDAOimpl PANIERDAO = new PanierDAOimpl();
	private final CommandeDAOimpl COMMDAO = new CommandeDAOimpl();
	final ClientDO CLIENT = new ClientDAOimpl().findByMail("mail@mail.mail");

	@GetMapping
	public String confirmPanier() {
		if (CLIENT.getPanier().getCommande().getListeprod().size() > 0) {
			List<ProduitDO> produits = CLIENT.getPanier().getCommande().getListeprod();
			final CommandeDO commande = CLIENT.getPanier().getCommande();
			Iterator<ProduitDO> iterator = produits.iterator();
			while (iterator.hasNext()) {
				ProduitDO p = iterator.next();
				iterator.remove();
				PRODDAO.delete(p.getIdprod());
			}
			COMMDAO.updateActive(commande.getIdcomm(), false);
			final Date date = new Date(System.currentTimeMillis());
			COMMDAO.updateDate(commande.getIdcomm(), date);
			PANIERDAO.updateCommande(CLIENT.getPanier().getIdpanier(), null);
			return "/achat";
		} else {
			return "/panier";
		}
	}
}