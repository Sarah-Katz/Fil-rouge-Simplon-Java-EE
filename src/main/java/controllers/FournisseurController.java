package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DO.FournisseurDO;

@Controller
@RequestMapping("/interne")
public class FournisseurController {
	private static final FournisseurDAOimpl FOURDAO = new FournisseurDAOimpl();
	private static final List<FournisseurDO> LISTEFOUR = FOURDAO.findAll();

	@GetMapping
	public String getFournisseurs(Model model) {
	    model.addAttribute("fournisseurs", LISTEFOUR);
	    return "interne";
	}

	@PostMapping
	public String achatProd(@RequestParam("id") int idfour, RedirectAttributes redirectAttributes) {
	    redirectAttributes.addAttribute("idfour", idfour);
	    return "redirect:/achatprod";
	}

}