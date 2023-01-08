package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/clear")
public class ClearPanierController {
	private static final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private static final CommandeDAOimpl COMMDAO = new CommandeDAOimpl();
	private static List<ProduitDO> products = new ArrayList<ProduitDO>();

	@PostMapping
	public String clearPanier(Model model) {
		final ClientDO client = new ClientDAOimpl().findByMail("mail@mail.mail");
		final CommandeDO commande = client.getPanier().getCommande();
		List<ProduitDO> listprod = client.getPanier().getCommande().getListeprod();
		Iterator<ProduitDO> iterator = listprod.iterator();
		while (iterator.hasNext()) {
			ProduitDO p = iterator.next();
			PRODDAO.updateincomm(p.getIdprod(), false);
			iterator.remove();
		}
		COMMDAO.updateProduit(commande.getIdcomm(), listprod);
		model.addAttribute("products", products);
		return "panier";
	}
}
