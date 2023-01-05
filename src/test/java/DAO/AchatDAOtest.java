package DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.ProduitDO;

@TestMethodOrder(OrderAnnotation.class)
public class AchatDAOtest {

	@Test
	@Order(1)
	public void testAchatDOcreate() {
		final ProduitDO produit = new ProduitDAOimpl().create("test", "testdesc", "testcat", 2323, 120);
		final Date date = new Date(10);
		final AchatDAOimpl achatdao = new AchatDAOimpl();
		final AchatDO achat = achatdao.create(date, produit, null);
		assertEquals(date, achat.getDateachat());
	}

	@Test
	@Order(2)
	public void testAchatDOfindall() {
		final Date date = new Date(10);
		final AchatDAOimpl achatdao = new AchatDAOimpl();
		final List<AchatDO> list = achatdao.findAll();
		final List<Date> list3 = new ArrayList<Date>();
		for (AchatDO a : list) {
			list3.add(a.getDateachat());
		}
		final List<Date> list2 = new ArrayList<Date>();
		list2.add(date);
		assertEquals(list2, list3);
	}

	@Test
	@Order(3)
	public void testAchatDOfindByRef() {
		final int ref = 2323;
		final AchatDAOimpl achatdao = new AchatDAOimpl();
		final List<AchatDO> list = achatdao.findByRef(ref);
		final List<Integer> list3 = new ArrayList<Integer>();
		for (AchatDO a : list) {
			list3.add(a.getProduit().getRef());
		}
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(ref);
		assertEquals(list2, list3);
	}

	@Test
	@Order(4)
	public void testAchatDOupdate() {
		final AchatDAOimpl achatdao = new AchatDAOimpl();
		final List<AchatDO> achatliste = achatdao.findByRef(2323);
		final AchatDO achat = achatliste.get(0);
		final int id = achat.getIdachat();
		final Date date = new Date(10);
		achatdao.updateDateachat(id, date);
		assertEquals(date, achat.getDateachat());
	}

	@Test
	@Order(5)
	public void testAchatDOdelete() {
		final AchatDAOimpl achatdao = new AchatDAOimpl();
		final List<AchatDO> achat = achatdao.findByRef(2323);		
		final int idachat = achat.get(0).getIdachat();
		final int idprod = achat.get(0).getProduit().getIdprod();
		achatdao.delete(idachat);
		ProduitDAOimpl produitDAOimpl = new ProduitDAOimpl();
		produitDAOimpl.delete(idprod);
	}

}
