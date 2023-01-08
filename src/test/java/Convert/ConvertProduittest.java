package Convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ProduitDO;
import metier.Convert.ConvertProduit;
import metier.DTO.ProduitDTO;

public class ConvertProduittest {

	@Test
	public void testprodtodto() {
		String nom = "jean";
		String desc = "description";
		String categorie = "categorie";
		int ref = 1;
		double prix = 2000;
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produitdo = produitdao.create(nom,desc,categorie,ref,prix,null);
		ConvertProduit convert = new ConvertProduit();
		ProduitDTO produitdto = convert.prodtodto(produitdo);
		assertEquals(produitdo.getNom(), produitdto.getNom());
		assertEquals(produitdo.getDescription(), produitdto.getDescription());
		assertEquals(produitdo.getCategorie(), produitdto.getCategorie());
		assertEquals(produitdo.getRef(), produitdto.getRef());
		assertEquals(produitdo.getPrix(), produitdto.getPrix());
	}

	@Test
	public void testprodtodo() {
		int id = 5;
		String nom = "jean";
		String desc = "description";
		String categorie = "categorie";
		int ref = 1;
		double prix = 2000;
		ProduitDTO produitdto = new ProduitDTO(id,nom,desc,categorie,ref,prix,null);
		ConvertProduit convert = new ConvertProduit();
		ProduitDO produitdo = convert.prodtodo(produitdto);
		assertEquals(produitdo.getNom(), produitdto.getNom());
		assertEquals(produitdo.getDescription(), produitdto.getDescription());
		assertEquals(produitdo.getCategorie(), produitdto.getCategorie());
		assertEquals(produitdo.getRef(), produitdto.getRef());
		assertEquals(produitdo.getPrix(), produitdto.getPrix());
	}
}
