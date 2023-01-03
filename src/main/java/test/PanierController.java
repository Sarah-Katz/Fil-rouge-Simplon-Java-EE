package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.PanierDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/panier")
public class PanierController {
	private ClientDO client = new ClientDAOimpl().create("Katz", "Sarah", "44 rue du test", 0606060606, "mail@mail.mail", null);
	private PanierDO panier = new PanierDAOimpl().create(null, client);
	private List<ProduitDO> products = new ArrayList();

	@GetMapping
	public String showPanier(Model model) {
		model.addAttribute("panier", panier);
		List<ProduitDO> listprod = panier.getCommande().getListeprod();
		for (ProduitDO p : listprod) {
			products.add(p);
		}
		return "panier";
	}
}
