package controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.PanierDO;
import accesDonnees.DO.ProduitDO;

//TODO fix rafraichissement de la page fait remonter
@Controller
@RequestMapping("/prodlist")
public class ProdlistController {
	private final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private final PanierDAOimpl PANIERDAO = new PanierDAOimpl();
	private final CommandeDAOimpl COMMDAO = new CommandeDAOimpl();

	@GetMapping
	public String getProducts(Model model) {
	    Set<ProduitDO> products = new HashSet<>();
	    List<ProduitDO> listdb = PRODDAO.findAll();
	    Set<Integer> refs = new HashSet<>();
	    for (ProduitDO p : listdb) {
	        if (!p.isIncomm() && !refs.contains(p.getRef())) {
	            products.add(p);
	            refs.add(p.getRef());
	        }
	    }
	    model.addAttribute("products", products);
	    return "prodlist";
	}

	@PostMapping
	public String addToCart(@RequestParam int id) {
		final ProduitDO product = PRODDAO.findById(id);
		final ClientDO client = new ClientDAOimpl().findByMail("mail@mail.mail");
		final Date date = new Date(System.currentTimeMillis());
		List<ProduitDO> panierlist = new ArrayList<>();
		CommandeDO commande = null;
		if (client.getPanier().getCommande() == null) {
			commande = new CommandeDAOimpl().create(date, panierlist);
			PanierDO panier = client.getPanier();
			PANIERDAO.updateCommande(panier.getIdpanier(), commande);
		} else {
			commande = client.getPanier().getCommande();
		}
		PRODDAO.updateincomm(id, true);
		commande.getListeprod().add(product);
		COMMDAO.updateProduit(commande.getIdcomm(), commande.getListeprod());
		return "redirect:prodlist";
	}

}