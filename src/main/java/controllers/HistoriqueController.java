package controllers;

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
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/historique")
public class HistoriqueController {
	private final CommandeDAOimpl COMMDAO = new CommandeDAOimpl();
	private final AchatDAOimpl ACHATDAO = new AchatDAOimpl();

	@GetMapping
	public String getData(Model model) {
		List<CommandeDO> achats = COMMDAO.findAll();
		List<AchatDO> ventes = ACHATDAO.findAll();
	    model.addAttribute("achats", achats);
	    model.addAttribute("ventes", ventes);
	    return "historique";
	}

	@PostMapping("/detailachat")
	public String achatProd(@RequestParam("id") int idachat, RedirectAttributes redirectAttributes) {
	    redirectAttributes.addAttribute("id", idachat);
	    return "redirect:/detailachat";
	}
}