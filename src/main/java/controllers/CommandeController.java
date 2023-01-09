package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/commande")
public class CommandeController {
	private static final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private static final AchatDAOimpl ACHATDAO = new AchatDAOimpl();
	private static List<ProduitDO> products = new ArrayList<>();

	@GetMapping
	public String showCommande(Model model) {
		products.removeAll(products);
		AchatDO achat = null;
		List<AchatDO> achatlist = ACHATDAO.findAll();
		boolean hasAchat = false;
		double total = 0;
		for (AchatDO a : achatlist) {
			if (a.isActive()) {
				achat = a;
				hasAchat = true;
			}
		}
		if (!hasAchat) {
			ACHATDAO.create(null, products);
		}
		model.addAttribute("achat", achat);
		final List<ProduitDO> listprod = achat.getListeprod();
		for (ProduitDO p : listprod) {
			products.add(p);
			total += p.getPrix();
		}
		model.addAttribute("products", products);
		model.addAttribute("total", total);
		return "commande";
	}

	@PostMapping
	public String removeFromCommande(@RequestParam int id) {
		final ProduitDO product = PRODDAO.findById(id);
		AchatDO achat = null;
		List<AchatDO> achatlist = ACHATDAO.findAll();
		for (AchatDO a : achatlist) {
			if (a.isActive()) {
				achat = a;
			}
		}
		final List<ProduitDO> listprod = achat.getListeprod();
		listprod.remove(product);
		ACHATDAO.updateListeprod(achat.getIdachat(), listprod);
		return "redirect:commande";
	}
}
