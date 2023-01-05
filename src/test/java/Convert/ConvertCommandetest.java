package Convert;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;
import metier.Convert.ConvertCommande;
import metier.DTO.CommandeDTO;

class ConvertCommandetest {

	@Test
	public void testachattodto() {
		final ProduitDO produit1 = new ProduitDAOimpl().create("test", "testdesc", "testcat", 2323, 120,null);
		final ProduitDO produit2 = new ProduitDAOimpl().create("test2", "testdesc2", "testcat2", 23232, 1202,null);
		final Date date = new Date(10);
		final List<ProduitDO> listeprod = new ArrayList<ProduitDO>();
		listeprod.add(produit1);
		listeprod.add(produit2);
		final CommandeDAOimpl commandedao = new CommandeDAOimpl();
		final CommandeDO commandedo = commandedao.create(date, listeprod);
		final ConvertCommande convert = new ConvertCommande();
		CommandeDTO commandedto = convert.commandetodto(commandedo);
		assertEquals(commandedo.getDate(), commandedto.getDate());
		assertEquals(commandedo.getListeprod(), commandedto.getListeprod());
	}
	
	@Test
	public void testachattodo() {
		final ProduitDO produit1 = new ProduitDAOimpl().create("test", "testdesc", "testcat", 2323, 120,null);
		final ProduitDO produit2 = new ProduitDAOimpl().create("test2", "testdesc2", "testcat2", 23232, 1202,null);
		final Date date = new Date(10);
		final List<ProduitDO> listeprod = new ArrayList<ProduitDO>();
		listeprod.add(produit1);
		listeprod.add(produit2);
		final CommandeDTO commandedto = new CommandeDTO(1, date, listeprod);
		final ConvertCommande convert = new ConvertCommande();
		CommandeDO commandedo = convert.commandetodo(commandedto);
		assertEquals(commandedo.getDate(), commandedto.getDate());
		assertEquals(commandedo.getListeprod(), commandedto.getListeprod());
	}

}
