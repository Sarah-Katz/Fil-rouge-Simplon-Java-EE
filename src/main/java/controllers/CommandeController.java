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
import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/commande")
public class CommandeController {
	;
	private final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private final CommandeDAOimpl COMMDAO = new CommandeDAOimpl();
	private final AchatDAOimpl ACHATDAO = new AchatDAOimpl();
	private List<ProduitDO> products = new ArrayList<ProduitDO>();

	@GetMapping
	public String showCommande(Model model) {
		products.removeAll(products);
		AchatDO achat = null;
		List<AchatDO> achatlist = ACHATDAO.findAll();
		for (AchatDO a : achatlist) {
			if (a.isActive()) {
				achat = a;
			}
		}
		model.addAttribute("achat", achat);
		final List<ProduitDO> listprod = achat.getListeprod();
		for (ProduitDO p : listprod) {
			products.add(p);
		}
		model.addAttribute("products", products);
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
