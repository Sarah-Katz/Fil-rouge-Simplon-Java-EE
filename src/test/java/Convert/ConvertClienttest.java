package Convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.PanierDO;
import accesDonnees.DO.ProduitDO;
import metier.Convert.ConvertClient;
import metier.DTO.ClientDTO;

public class ConvertClienttest {
	
	@Test
	public void testclienttodto() {
		final ProduitDO produit1 = new ProduitDAOimpl().create("test", "testdesc", "testcat", 2323, 120,null);
		final ProduitDO produit2 = new ProduitDAOimpl().create("test2", "testdesc2", "testcat2", 23232, 1202,null);
		final Date date = new Date(10);
		final List<ProduitDO> listeprod = new ArrayList<ProduitDO>();
		listeprod.add(produit1);
		listeprod.add(produit2);
		final CommandeDAOimpl commandedao = new CommandeDAOimpl();
		final CommandeDO commandedo = commandedao.create(date, listeprod);
		final ClientDAOimpl clientdao = new ClientDAOimpl();
		final ClientDO clientdo = clientdao.create("test", "test", "test", 102, "TEST", null);
		final PanierDAOimpl panierdao = new PanierDAOimpl();
		final PanierDO panierdo = panierdao.create(commandedo);
		clientdo.setPanier(panierdo);
		final ConvertClient convert = new ConvertClient();
		ClientDTO clientdto = convert.clienttodto(clientdo);
		assertEquals(clientdo.getNom(), clientdto.getNom());
		assertEquals(clientdo.getPrenom(), clientdto.getPrenom());
		assertEquals(clientdo.getAdresse(), clientdto.getAdresse());
		assertEquals(clientdo.getTel(), clientdto.getTel());
		assertEquals(clientdo.getMail(), clientdto.getMail());
	}
	
	@Test
	public void testclienttodo() {
		final ProduitDO produit1 = new ProduitDAOimpl().create("test", "testdesc", "testcat", 2323, 120,null);
		final ProduitDO produit2 = new ProduitDAOimpl().create("test2", "testdesc2", "testcat2", 23232, 1202,null);
		final Date date = new Date(10);
		final List<ProduitDO> listeprod = new ArrayList<ProduitDO>();
		listeprod.add(produit1);
		listeprod.add(produit2);
		final CommandeDAOimpl commandedao = new CommandeDAOimpl();
		final CommandeDO commandedo = commandedao.create(date, listeprod);
		final ClientDTO clientdto = new ClientDTO(1, "test", "test", "test", 102, "TEST", null);
		final PanierDAOimpl panierdao = new PanierDAOimpl();
		final ConvertClient convert = new ConvertClient();
		final PanierDO panierdo = panierdao.create(commandedo);
		clientdto.setPanier(panierdo);
		ClientDO clientdo = convert.clienttodo(clientdto);
		assertEquals(clientdo.getNom(), clientdto.getNom());
		assertEquals(clientdo.getPrenom(), clientdto.getPrenom());
		assertEquals(clientdo.getAdresse(), clientdto.getAdresse());
		assertEquals(clientdo.getTel(), clientdto.getTel());
		assertEquals(clientdo.getMail(), clientdto.getMail());
	}
}
