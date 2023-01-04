package test;

import java.sql.Date;
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
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.PanierDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/prodlist")
public class ProdlistController {

	private List<ProduitDO> products = new ArrayList<ProduitDO>();
	private final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private final PanierDAOimpl PANIERDAO = new PanierDAOimpl();
	private final CommandeDAOimpl COMMDAO = new CommandeDAOimpl();

	@GetMapping
	public String getProducts(Model model) {
		final List<CommandeDO> commlist = COMMDAO.findAll();
		products.removeAll(products);
		List<ProduitDO> listdb = PRODDAO.findAll();
		int lastRef = 0;
		for (CommandeDO c : commlist) {
			List<ProduitDO> commprodlist = c.getListeprod();
			for (ProduitDO pl : commprodlist) {
				for (ProduitDO p : listdb) {
					if (p.getRef() != lastRef && p.getIdprod() != pl.getIdprod()) {
						products.add(p);
						lastRef = p.getRef();
					}
				}
			}
		}
		products.addAll(listdb);
		model.addAttribute("products", products);
		return "prodlist";
	}

	@PostMapping
	public String addToCart(@RequestParam int ref) {
		List<ProduitDO> productlist = PRODDAO.findByRef(ref);
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
		if (productlist.size() > 0) {
			commande.getListeprod().add(productlist.get(0));
			COMMDAO.updateProduit(commande.getIdcomm(), commande.getListeprod());
		}
		return "redirect:prodlist";
	}

}