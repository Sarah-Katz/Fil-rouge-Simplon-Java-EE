package controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/achatinterne")
public class AchatInterneController {
	AchatDO achat = null;
	private final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();
	private final AchatDAOimpl ACHATDAO = new AchatDAOimpl();

	@GetMapping
	public String confirmPanier() {
		List<AchatDO> achatlist = ACHATDAO.findAll();
		for (AchatDO a : achatlist) {
			if (a.isActive()) {
				achat = a;
			}
		}
		List<ProduitDO> produits = achat.getListeprod();		
		if (produits.size() > 0) {
			for (ProduitDO p : produits) {
			PRODDAO.create(p.getNom(), p.getDescription(), p.getCategorie(), p.getRef(), p.getPrix());				
			}
			ACHATDAO.updateactive(achat.getIdachat(), false);
			final Date date = new Date(System.currentTimeMillis());
			ACHATDAO.updateDateachat(achat.getIdachat(), date);
			return "/achatinterne";
		} else {
			return "/interne";
		}
	}
}