package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.PanierDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/panier")
public class PanierController {
	private static final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private static final CommandeDAOimpl COMMDAO = new CommandeDAOimpl();
	private static List<ProduitDO> products = new ArrayList<ProduitDO>();

	@GetMapping
	public String showPanier(Model model) {
		final ClientDO client = new ClientDAOimpl().findByMail("mail@mail.mail");
		PanierDO panier = null;
		List<ProduitDO> listprod = new ArrayList<ProduitDO>();
		try {
			panier = client.getPanier();
			model.addAttribute("panier", panier);
			listprod = panier.getCommande().getListeprod();
			products.clear();
			for (ProduitDO p : listprod) {
				products.add(p);
			}
		} catch (NullPointerException e) {
		} finally {
			model.addAttribute("products", products);
		}
		return "panier";
	}

	@PostMapping
	public String removeFromPanier(@RequestParam int id) {
		final ProduitDO product = PRODDAO.findById(id);
		final ClientDO client = new ClientDAOimpl().findByMail("mail@mail.mail");
		CommandeDO commande = client.getPanier().getCommande();
		PRODDAO.updateincomm(id, false);
		commande.getListeprod().remove(product);
		COMMDAO.updateProduit(commande.getIdcomm(), commande.getListeprod());
		return "redirect:panier";
	}
}
