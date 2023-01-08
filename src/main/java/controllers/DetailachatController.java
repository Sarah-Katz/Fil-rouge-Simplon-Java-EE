package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/detailachat")
public class DetailachatController {
 
	private List<ProduitDO> products = new ArrayList<ProduitDO>();
	private final AchatDAOimpl ACHATDAO = new AchatDAOimpl();

	@GetMapping
	public String getProduits(@RequestParam("id") int id, Model model) {
		AchatDO achat = ACHATDAO.findById(id);
		List<ProduitDO> prodlist = achat.getListeprod();
		products.removeAll(products);
		for (ProduitDO p : prodlist) {
			products.add(p);
		}
		model.addAttribute("achat", achat);
	    model.addAttribute("products", products);
	    return "detailachat";
	}
	
	@PostMapping
	public String showAchat(@RequestParam("id") int idachat, RedirectAttributes redirectAttributes) {
	    redirectAttributes.addAttribute("id", idachat);
	    return "redirect:/detailachat";
	}
}