package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/commande")
public class CommandeController {
	;
	private final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private final CommandeDAOimpl COMMDAO = new CommandeDAOimpl();
	private List<ProduitDO> products = new ArrayList<ProduitDO>();

//	@GetMapping
//	public String showPanier(Model model) {
//		products.removeAll(products);
//		final ClientDO client = new ClientDAOimpl().findByMail("mail@mail.mail");
//		final PanierDO panier = client.getPanier();
//		model.addAttribute("panier", panier);
//		final List<ProduitDO> listprod = panier.getCommande().getListeprod();
//		for (ProduitDO p : listprod) {
//			products.add(p);
//		}
//		model.addAttribute("products", products);
//		return "panier";
//	}

	


}
