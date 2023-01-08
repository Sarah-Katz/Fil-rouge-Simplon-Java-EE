package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DO.FournisseurDO;

@Controller
@RequestMapping("/ajoutfour")
public class AjoutfourController {
	private static final FournisseurDAOimpl FOURDAO = new FournisseurDAOimpl();

	@GetMapping
	public String afficherFormulaire(Model model) {
	    model.addAttribute("fournisseur", new FournisseurDO());
	    return "ajoutfour";
	  }
	
	@PostMapping
	public String addFournisseur(@ModelAttribute FournisseurDO fournisseur) {
		List<Integer> reflist = new ArrayList<Integer>();
		FOURDAO.create(fournisseur.getNom(), reflist);
		return "/interne";
	}
}
