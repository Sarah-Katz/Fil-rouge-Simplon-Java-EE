package Convert;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.PanierDO;
import accesDonnees.DO.ProduitDO;
import metier.Convert.ConvertPanier;
import metier.DTO.CommandeDTO;
import metier.DTO.PanierDTO;

class ConvertPaniertest {

	@Test
	public void testpaniertodto() {
		final ProduitDO produit1 = new ProduitDAOimpl().create("test", "testdesc", "testcat", 2323, 120);
		final ProduitDO produit2 = new ProduitDAOimpl().create("test2", "testdesc2", "testcat2", 23232, 1202);
		final Date date = new Date(10);
		final List<ProduitDO> listeprod = new ArrayList<ProduitDO>();
		listeprod.add(produit1);
		listeprod.add(produit2);
		final CommandeDAOimpl commandedao = new CommandeDAOimpl();
		final CommandeDO commandedo = commandedao.create(date, listeprod, 10);
		final PanierDAOimpl panierdao = new PanierDAOimpl();
		final PanierDO panierdo = panierdao.create(commandedo);
		final ConvertPanier convert = new ConvertPanier();
		PanierDTO panierdto = convert.paniertodto(panierdo);
		assertEquals(panierdo.getCommande().getDate(), panierdto.getCommande().getDate());
	}
	
	@Test
	public void testpaniertodo() {
		final ProduitDO produit1 = new ProduitDAOimpl().create("test", "testdesc", "testcat", 2323, 120);
		final ProduitDO produit2 = new ProduitDAOimpl().create("test2", "testdesc2", "testcat2", 23232, 1202);
		final Date date = new Date(10);
		final List<ProduitDO> listeprod = new ArrayList<ProduitDO>();
		listeprod.add(produit1);
		listeprod.add(produit2);
		final CommandeDTO commandedto = new CommandeDTO(1, date, listeprod, 10);
		final PanierDTO panierdto = new PanierDTO(1, commandedto);
		final ConvertPanier convert = new ConvertPanier();
		PanierDO panierdo = convert.paniertodo(panierdto);
		assertEquals(panierdo.getCommande().getDate(), panierdto.getCommande().getDate());
	}

}
