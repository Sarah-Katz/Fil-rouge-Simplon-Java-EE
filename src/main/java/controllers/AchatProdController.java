package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/achatprod")
public class AchatProdController {
	private final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private final FournisseurDAOimpl FOURDAO = new FournisseurDAOimpl();
	private final AchatDAOimpl ACHATDAO = new AchatDAOimpl();
	List<ProduitDO> products = new ArrayList<ProduitDO>();
	List<ProduitDO> commande = new ArrayList<ProduitDO>();

	@GetMapping
	public String showProduits(@RequestParam("idfour") int idfour, Model model) {
		products.removeAll(products);
		FournisseurDO four = FOURDAO.findById(idfour);
		List<Integer> reflist = four.getReflist();
		List<ProduitDO> prodlist = PRODDAO.findAll();
		for (Integer r : reflist) {
			for (ProduitDO p : prodlist) {
				if (r == p.getRef()) {
					products.add(p);
				}
			}
		}
		model.addAttribute("products", products);
		return "achatprod";
	}

	@PostMapping
	public String addToCommande(@RequestParam int id, @RequestParam int idfour) {
		final ProduitDO product = PRODDAO.findById(id);
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
}