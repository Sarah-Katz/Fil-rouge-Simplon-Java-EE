package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.PanierDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/panier")
public class PanierController {
	
	private List<ProduitDO> products = new ArrayList<ProduitDO>();

	@GetMapping
	public String showPanier(Model model) {
		products.removeAll(products);
		final ClientDO client = new ClientDAOimpl().findByMail("mail@mail.mail");
		final PanierDO panier = client.getPanier(); 
		model.addAttribute("panier", panier);
		final List<ProduitDO> listprod = panier.getCommande().getListeprod();
		for (ProduitDO p : listprod) {
			products.add(p);
		}
		model.addAttribute("products", products);
		return "panier";
	}
}
