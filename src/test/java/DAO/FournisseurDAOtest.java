package DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;

@TestMethodOrder(OrderAnnotation.class)
public class FournisseurDAOtest {

	@Test
	@Order(1)
	public void testFournisseurDOcreate() {
		String nom = "jean";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.create("jean", "description", "categorie", 1, 3000);
		List<ProduitDO> produits = new ArrayList<ProduitDO>();
		produits.add(produit);
		FournisseurDAOimpl fournisseurdao = new FournisseurDAOimpl();
		FournisseurDO fournisseur = fournisseurdao.create(nom, produits);
		
		assertEquals(nom,fournisseur.getNom());
	}
	
	@Test
	@Order(2)
	public void testFournisseurDOfindall() {
		String nom = "jean";
		FournisseurDAOimpl fournisseurdao = new FournisseurDAOimpl();
		List<FournisseurDO> list = fournisseurdao.findAll();
		List<String> list3 = new ArrayList<String>();
		for (FournisseurDO fournisseurDO : list) {
			list3.add(fournisseurDO.getNom());
		}
		List<String> list2 = new ArrayList<String>();
		list2.add(nom);
		
		assertEquals(list2,list3);
	}
	
	@Test
	@Order(3)
	public void testFournisseurDOupdate() {
		String ancien_nom = "jean";
		String nouveau_nom = "marc";
		FournisseurDAOimpl fournisseurdao = new FournisseurDAOimpl();
		FournisseurDO fournisseur = fournisseurdao.update(ancien_nom,nouveau_nom);
		assertEquals(nouveau_nom,fournisseur.getNom());
	}
	
	@Test
	@Order(4)
	public void testFournisseurDOdelete() {
		int id = 1;
		FournisseurDAOimpl fournisseurdao = new FournisseurDAOimpl();
		fournisseurdao.delete(id);
	}
	

}

