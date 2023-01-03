package DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.PanierDO;

@TestMethodOrder(OrderAnnotation.class)
public class PanierDAOtest {
	final PanierDAOimpl PANIERDAOIMPL = new PanierDAOimpl();

	@Test
	@Order(1)
	public void testPanierDOcreate() {
		final CommandeDO commande = new CommandeDAOimpl().create(null, null, 0);
		final ClientDO client = new ClientDAOimpl().create("nom", "prenom", "adresse", 06, "mail", null);
		final PanierDO panier = PANIERDAOIMPL.create(commande, client);
		assertEquals(commande, panier.getCommande());
	}

	@Test
	@Order(2)
	public void testPanierDOfindall() {		
		final List<PanierDO> list = PANIERDAOIMPL.findAll();
		final CommandeDO commande = list.get(0).getCommande();
		
		final List<CommandeDO> list3 = new ArrayList<CommandeDO>();
		for (PanierDO p : list) {
			list3.add(p.getCommande());
		}
		final List<CommandeDO> list2 = new ArrayList<CommandeDO>();
		list2.add(commande);
		assertEquals(list2, list3);
	}

	@Test
	@Order(3)
	public void testPanierDOupdateCommande() {
		final List<PanierDO> liste = PANIERDAOIMPL.findAll();
		final CommandeDO commande = liste.get(0).getCommande();
		final List<PanierDO> panierliste = PANIERDAOIMPL.findByCommande(commande);
		final PanierDO panier = panierliste.get(0);
		final int id = panier.getIdpanier();
		PANIERDAOIMPL.updateCommande(id, commande);
		assertEquals(commande, panier.getCommande());
	}

	@Test
	@Order(4)
	public void testPanierDOupdateClient() {
		final List<PanierDO> liste = PANIERDAOIMPL.findAll();
		final CommandeDO commande = liste.get(0).getCommande();
		final ClientDO client = liste.get(0).getClient();
		final List<PanierDO> panierliste = PANIERDAOIMPL.findByCommande(commande);
		final PanierDO panier = panierliste.get(0);
		final int id = panier.getIdpanier();
		PANIERDAOIMPL.updateClient(id, client);
		assertEquals(client, panier.getClient());
	}

	@Test
	@Order(5)
	public void testAchatDOdelete() {
		final List<PanierDO> liste = PANIERDAOIMPL.findAll();
		final CommandeDO commande = liste.get(0).getCommande();
		final List<PanierDO> panierliste = PANIERDAOIMPL.findByCommande(commande);
		final PanierDO panier = panierliste.get(0);
		final int idclient = panier.getClient().getIdclient();
		final int idcomm = panier.getCommande().getIdcomm();
		final int idpanier = panier.getIdpanier();
		ClientDAOimpl clientdao = new ClientDAOimpl();
		PANIERDAOIMPL.delete(idpanier);
		clientdao.delete(idclient);
		CommandeDAOimpl commandedao = new CommandeDAOimpl();
		commandedao.delete(idcomm);
	}

}
