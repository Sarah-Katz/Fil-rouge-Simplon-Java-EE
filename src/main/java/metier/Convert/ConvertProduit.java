package metier.Convert;

import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ProduitDO;
import metier.DTO.ProduitDTO;

public class ConvertProduit {

	public ProduitDTO prodtodto(ProduitDO produitdo) {
		ProduitDTO produitdto = new ProduitDTO(produitdo.getIdprod(), produitdo.getNom(), produitdo.getDescription(),
				produitdo.getCategorie(), produitdo.getRef(), produitdo.getPrix(),produitdo.getFournisseur());
		return produitdto;
	}

	public ProduitDO prodtodo(ProduitDTO produitdto) {
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produitdo = produitdao.create(produitdto.getNom(), produitdto.getDescription(),
				produitdto.getCategorie(), produitdto.getRef(), produitdto.getPrix(), produitdto.getFournisseur());

		return produitdo;
	}

}
