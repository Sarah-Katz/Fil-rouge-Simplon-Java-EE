package Convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;
import metier.Convert.ConvertFournisseur;
import metier.DTO.FournisseurDTO;

class ConvertFournisseurtest {

	@Test
	public void testfourtodto() {
		String nom = "jean";
		FournisseurDAOimpl fournisseurdao = new FournisseurDAOimpl();
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.create("jean", "description", "categorie", 1, 3000,null);
		List<ProduitDO> produits = new ArrayList<>();
		produits.add(produit);
		FournisseurDO fournisseurdo = fournisseurdao.create(nom, produits);
		ConvertFournisseur convert = new ConvertFournisseur();
		FournisseurDTO fournisseurdto = convert.fourtodto(fournisseurdo);
		assertEquals(fournisseurdo.getNom(), fournisseurdto.getNom());
	}

	@Test
	public void testfourtodo() {
		int id = 5;
		String nom = "jean";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.create("jean", "description", "categorie", 1, 3000,null);
		List<ProduitDO> produits = new ArrayList<>();
		produits.add(produit);
		FournisseurDTO fournisseurdto = new FournisseurDTO(id,nom, produits);
		ConvertFournisseur convert = new ConvertFournisseur();
		FournisseurDO fournisseurdo = convert.fourtodo(fournisseurdto);
		assertEquals(fournisseurdo.getNom(), fournisseurdto.getNom());
	}

}
