package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		for (ProduitDO p : prodlist) {
			if (reflist.contains(p.getRef()) && !products.contains(p)) {
				products.add(p);
			}
		}
		model.addAttribute("products", products);
		return "achatprod";
	}
	
	@PostMapping
	public String addToCommande(@RequestParam int id, @RequestParam int idfour) {
	    final ProduitDO product = PRODDAO.findById(id);
	    List<AchatDO> achatList = ACHATDAO.findAll();
	    AchatDO achat = null;
	    // check if there are any active AchatDO objects in the list
	    boolean hasActive = false;
	    for (AchatDO a : achatList) {
	        if (a.isActive()) {
	            hasActive = true;
	            break;
	        }
	    }
	    if (!hasActive) {
	        // no active AchatDO objects found, create a new one
	        List<ProduitDO> prodList = new ArrayList<ProduitDO>();
	        prodList.add(product);
	        achat = ACHATDAO.create(null, prodList);
	    } else {
	        // active AchatDO object found, add product to list
	        for (AchatDO a : achatList) {
	            if (a.isActive()) {
	                achat = a;
	                achat.getListeprod().add(product);
	                ACHATDAO.updateListeprod(achat.getIdachat(), achat.getListeprod());
	                break;
	            }
	        }
	    }	    
	    return "redirect:achatprod?idfour=" + idfour;
	}

}