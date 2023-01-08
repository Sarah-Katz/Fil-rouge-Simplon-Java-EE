package DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.PanierDO;

@TestMethodOrder(OrderAnnotation.class)
public class ClientDAOtest {
	final ClientDAOimpl CLIENTDAOIMPL = new ClientDAOimpl();

	@Test
	@Order(1)
	public void testClientDOcreate() {
		final PanierDO panier = new PanierDAOimpl().create(null);
		final ClientDO client = CLIENTDAOIMPL.create("nom", "prenom", "adresse", 06, "mail", panier);
		assertEquals(panier, client.getPanier());
	}

	@Test
	@Order(2)
	public void testClientDOfindall() {
		final List<ClientDO> list = CLIENTDAOIMPL.findAll();
		final String adresse = list.get(0).getAdresse();

		final List<String> list3 = new ArrayList<>();
		for (ClientDO c : list) {
			list3.add(c.getAdresse());
		}
		final List<String> list2 = new ArrayList<>();
		list2.add(adresse);
		assertEquals(list2, list3);
	}

	@Test
	@Order(3)
	public void testClientDOupdateNom() {
		final List<ClientDO> liste = CLIENTDAOIMPL.findAll();
		final ClientDO client = liste.get(0);
		final int id = client.getIdclient();
		CLIENTDAOIMPL.updateNom(id, "nomtest");
		assertEquals("nomtest", client.getNom());
	}

	@Test
	@Order(4)
	public void testClientDOupdatePrenom() {
		final List<ClientDO> liste = CLIENTDAOIMPL.findAll();
		final ClientDO client = liste.get(0);
		final int id = client.getIdclient();
		CLIENTDAOIMPL.updatePrenom(id, "prenomtest");
		assertEquals("prenomtest", client.getPrenom());
	}

	@Test
	@Order(5)
	public void testClientDOdelete() {
		final List<ClientDO> liste = CLIENTDAOIMPL.findAll();
		final ClientDO client = liste.get(0);
		final PanierDO panier = client.getPanier();
		PanierDAOimpl panierdao = new PanierDAOimpl();
		panierdao.delete(panier.getIdpanier());
		CLIENTDAOIMPL.delete(client.getIdclient());
	}

}
