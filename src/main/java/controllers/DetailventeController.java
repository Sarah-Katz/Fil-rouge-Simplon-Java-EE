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

import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/detailvente")
public class DetailventeController {

	private static List<ProduitDO> products = new ArrayList<>();
	private static final CommandeDAOimpl COMMDAO = new CommandeDAOimpl();

	@GetMapping
	public String getProduits(@RequestParam("id") int id, Model model) {
		CommandeDO comm = COMMDAO.findById(id);
		List<ProduitDO> prodlist = comm.getListeprod();
		products.removeAll(products);
		for (ProduitDO p : prodlist) {
			products.add(p);
		}
		model.addAttribute("achat", comm);
	    model.addAttribute("products", products);
	    return "detailvente";
	}

	@PostMapping
	public String showAchat(@RequestParam("id") int idcomm, RedirectAttributes redirectAttributes) {
	    redirectAttributes.addAttribute("id", idcomm);
	    return "redirect:/detailvente";
	}
}