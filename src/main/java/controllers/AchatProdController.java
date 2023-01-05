package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/achatprod")
public class AchatProdController {
	private final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private final PanierDAOimpl PANIERDAO = new PanierDAOimpl();
	private final CommandeDAOimpl COMMDAO = new CommandeDAOimpl();
	private final FournisseurDAOimpl FOURDAO = new FournisseurDAOimpl();
	private final AchatDAOimpl ACHATDAO = new AchatDAOimpl();
	List<ProduitDO> products = new ArrayList<ProduitDO>();
	List<ProduitDO> commande = new ArrayList<ProduitDO>();

	@GetMapping
	public String showProduits(@RequestParam("idfour") int idfour, Model model) {
		products.removeAll(products);
		FournisseurDO four = FOURDAO.findById(idfour);
		products.addAll(four.getProduits());
		model.addAttribute("products", products);
		return "achatprod";
	}

	@PostMapping
	public String addToCommande(@RequestParam int id, RedirectAttributes redirectAttributes) {
		final ProduitDO product = PRODDAO.findById(id);
		int idfour = product.getFournisseur().getIdfour();
		PRODDAO.updateincomm(id, true);
		commande.add(product);
		redirectAttributes.addAttribute("idfour", idfour);
		return "redirect:achatprod";
	}

	@PostMapping("/commande")
	public String showCommande(@RequestParam("commande") String commandeStr, Model model) {
	    List<String> commande = Arrays.asList(commandeStr.split(","));
	    model.addAttribute("commande", commande);
	    return "commande";
	}
}