package controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.PanierDO;
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

//	@PostMapping
//	public String addToCommande(@RequestParam int id, RedirectAttributes redirectAttributes, Model model) {
//		final ProduitDO product = PRODDAO.findById(id);
//		int idfour = product.getFournisseur().getIdfour();
//		commande.add(product);
//		model.addAllAttributes(commande);
//		redirectAttributes.addAttribute("idfour", idfour);
//		redirectAttributes.addAttribute(commande);
//		return "achatprod";
//	}

	@PostMapping
	public String addToCommande(@RequestParam int id) {
		final ProduitDO product = PRODDAO.findById(id);
		final int idfour = product.getFournisseur().getIdfour();
		AchatDO achat = null;
		List<AchatDO> achatlist = null;
		try {
			achatlist = ACHATDAO.findAll();
		} catch (NoResultException e) {
			achat = ACHATDAO.create(null, null);
		} finally {
			for (AchatDO a : achatlist) {
				if (a.isActive()) {
					achat = a;
				} else {
					achat = ACHATDAO.create(null, null);
				}
			}
			if (achat.getListeprod() == null) {
				List<ProduitDO> prodlist = new ArrayList<ProduitDO>();
				prodlist.add(product);
				ACHATDAO.updateListeprod(achat.getIdachat(), prodlist);
			} else {
				achat.getListeprod().add(product);
				ACHATDAO.updateListeprod(achat.getIdachat(), achat.getListeprod());
			}
		}
		return "redirect:achatprod?idfour="+idfour;
	}

	@PostMapping("/commande")
	public String showCommande(@RequestParam("commande") String commandeStr, Model model) {
		List<String> commande = Arrays.asList(commandeStr.split(","));
		model.addAttribute("commande", commande);
		return "commande";
	}
}