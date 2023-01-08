package DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

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
		ProduitDO produit = produitdao.create(nom,desc,categorie,ref,prix,null);

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
		List<String> list3 = new ArrayList<>();
		for (ProduitDO produitDO : list) {
			list3.add(produitDO.getNom());
		}
		List<String> list2 = new ArrayList<>();
		list2.add(nom);

		assertEquals(list2,list3);
	}

	@Test
	@Order(3)
	public void testProduitDOfindByName() {
		String nom = "ea";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		List<ProduitDO> list = produitdao.findByName(nom);
		List<String> list3 = new ArrayList<>();
		for (ProduitDO produitDO : list) {
			list3.add(produitDO.getNom());
		}
		String nomcomplet = "jean";
		List<String> list2 = new ArrayList<>();
		list2.add(nomcomplet);

		assertEquals(list2,list3);
	}

	@Test
	@Order(4)
	public void testProduitDOupdateNom() {
		String nouveau_nom = "marc";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.updateNom(1, nouveau_nom);

		assertEquals(nouveau_nom,produit.getNom());
	}

	@Test
	@Order(5)
	public void testProduitDOupdateDesc() {
		String nouveau_desc = "desc2";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.updateDesc(1, nouveau_desc);

		assertEquals(nouveau_desc,produit.getDescription());
	}

	@Test
	@Order(6)
	public void testProduitDOupdateCate() {
		String nouveau_cate = "cate2";
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.updatecate(1, nouveau_cate);

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
		double nouveau_prix = 3000;
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.updateprix(1, nouveau_prix);

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
