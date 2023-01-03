package DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;

@TestMethodOrder(OrderAnnotation.class)
class CommandeDAOtest {

	@Test
	@Order(1)
	public void testCommandeDOcreate() {
		Date date = new Date(10);
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.create("jean", "description", "categorie", 1, 3000);
		List<ProduitDO> listprod = new ArrayList<ProduitDO>();
		listprod.add(produit);
		double prix = 2000;
		CommandeDAOimpl commandedao = new CommandeDAOimpl();
		CommandeDO commande = commandedao.create(date, listprod, prix);
		
		assertEquals(date,commande.getDate());
		assertEquals(listprod,commande.getListeprod());
		assertEquals(prix,commande.getPrix());
	}
	
	@Test
	@Order(2)
	public void testCommandeDOfindAll() {
		Date date = new Date(10);
		CommandeDAOimpl commandedao = new CommandeDAOimpl();
		List<CommandeDO> list = commandedao.findAll();
		List<Date> list3 = new ArrayList<Date>();
		for (CommandeDO commandeDO : list) {
			list3.add(commandeDO.getDate());
		}
		List<Date> list2 = new ArrayList<Date>();
		list2.add(date);
		
		assertEquals(list2,list3);
	}
	
	@Test
	@Order(3)
	public void testCommandeDOupdateNom() {
		Date ancien_date = new Date(10);
		Date nouveau_date = new Date(20);
		CommandeDAOimpl commandedao = new CommandeDAOimpl();
		CommandeDO commande = commandedao.updateDate(ancien_date, nouveau_date);
		
		assertEquals(nouveau_date,commande.getDate());
	}
	
	@Test
	@Order(4)
	public void testProduitDOupdateListeprod() {
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.create("jean", "description", "categorie", 1, 3000);
		List<ProduitDO> ancien_produit = new ArrayList<ProduitDO>();
		ancien_produit.add(produit);
		ProduitDO produit2 = produitdao.create("jean2", "description2", "categorie2", 1, 3000);
		List<ProduitDO> nouveau_produit = new ArrayList<ProduitDO>();
		ancien_produit.add(produit2);
		CommandeDAOimpl commandedao = new CommandeDAOimpl();
		CommandeDO commande = commandedao.updateProduit(ancien_produit, nouveau_produit);
		
		assertEquals(nouveau_produit,commande.getListeprod());
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