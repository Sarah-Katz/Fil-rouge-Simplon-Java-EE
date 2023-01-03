package DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ProduitDO;

@TestMethodOrder(OrderAnnotation.class)
class ProduitDAOtest {

	@Test
	@Order(1)
	public void testProduitDOcreate() {
		String nom = "jean";
		String desc = "description";
		String categorie = "categorie";
		int ref = 1;
		double prix = 2000;
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.create(nom,desc,categorie,ref,prix);
		
		assertEquals(nom,produit.getNom());
		assertEquals(desc,produit.getDescription());
		assertEquals(categorie,produit.getCategorie());
		assertEquals(ref,produit.getRef());
		assertEquals(prix,produit.getPrix());
	}
	
	@Test
	@Order(2)
	public void testProduitDOfindAll() {
		String nom = "jean";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		List<ProduitDO> list = produitdao.findAll();
		List<String> list3 = new ArrayList<String>();
		for (ProduitDO produitDO : list) {
			list3.add(produitDO.getNom());
		}
		List<String> list2 = new ArrayList<String>();
		list2.add(nom);
		
		assertEquals(list2,list3);
	}
	
	@Test
	@Order(3)
	public void testProduitDOfindByName() {
		String nom = "ea";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		List<ProduitDO> list = produitdao.findByName(nom);
		List<String> list3 = new ArrayList<String>();
		for (ProduitDO produitDO : list) {
			list3.add(produitDO.getNom());
		}
		String nomcomplet = "jean";
		List<String> list2 = new ArrayList<String>();
		list2.add(nomcomplet);
		
		assertEquals(list2,list3);
	}
	
	@Test
	@Order(4)
	public void testProduitDOupdateNom() {
		String ancien_nom = "jean";
		String nouveau_nom = "marc";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.updateNom(ancien_nom, nouveau_nom);
		
		assertEquals(nouveau_nom,produit.getNom());
	}
	
	@Test
	@Order(5)
	public void testProduitDOupdateDesc() {
		String ancien_desc = "description";
		String nouveau_desc = "desc2";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.updateDesc(ancien_desc, nouveau_desc);
		
		assertEquals(nouveau_desc,produit.getDescription());
	}
	
	@Test
	@Order(6)
	public void testProduitDOupdateCate() {
		String ancien_cate = "categorie";
		String nouveau_cate = "cate2";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.updatecate(ancien_cate, nouveau_cate);
		
		assertEquals(nouveau_cate,produit.getCategorie());
	}
	
	@Test
	@Order(7)
	public void testProduitDOupdateRef() {
		int ancien_ref = 1;
		int nouveau_ref = 2;
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.updateref(ancien_ref, nouveau_ref);
		
		assertEquals(nouveau_ref,produit.getRef());
	}
	
	@Test
	@Order(8)
	public void testProduitDOupdatePrix() {
		double ancien_prix = 2000;
		double nouveau_prix = 3000;
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.updateprix(ancien_prix, nouveau_prix);
		
		assertEquals(nouveau_prix,produit.getPrix());
	}
	
	@Test
	@Order(9)
	public void testProduitDOdelete() {
		int id = 1;
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		produitdao.delete(id);
	}

}
