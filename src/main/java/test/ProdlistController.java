package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/prod")
public class ProdlistController {

	private List<ProduitDO> products = new ArrayList<ProduitDO>();
	private final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();

	@GetMapping("/prodlist")
	public String getProducts(Model model) {
		products.removeAll(products);
		List<ProduitDO> listdb = PRODDAO.findAll();
		int lastRef = 0;
		for (ProduitDO p : listdb) {
			if (p.getRef() != lastRef) {
				products.add(p);
				lastRef = p.getRef();
			}
		}
		products.addAll(listdb);
		model.addAttribute("products", products);
		return "prodlist";
	}

	@PostMapping("/prodlist")
	public String addToCart(@ModelAttribute ProduitDO prod) {
		final ClientDO client = new ClientDAOimpl().findByMail("mail@mail.mail");
		final Date date = new Date(System.currentTimeMillis());
		CommandeDO commande = null;
		if (client.getPanier().getCommande() == null) {
			commande = new CommandeDAOimpl().create(date, products);
			client.getPanier().setCommande(commande);
		} else {
			commande = client.getPanier().getCommande();
		}
		commande.getListeprod().add(prod);
		return "redirect:prodlist";
	}
}