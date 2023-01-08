package Convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.ProduitDO;
import metier.Convert.ConvertAchat;
import metier.DTO.AchatDTO;

class ConvertAchattest {

	@Test
	public void testachattodto() {
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.create("jean", "description", "categorie", 1, 3000,null);
		List<ProduitDO> produits = new ArrayList<>();
		produits.add(produit);
		final Date date = new Date(10);
		final AchatDAOimpl achatdao = new AchatDAOimpl();
		final AchatDO achatdo = achatdao.create(date, produits);
		ConvertAchat convert = new ConvertAchat();
		AchatDTO achatdto = convert.achattodto(achatdo);
		assertEquals(achatdo.getDateachat(), achatdto.getDateachat());
		assertEquals(achatdo.getListeprod(), achatdto.getListeprod());
	}

	@Test
	public void testachattodo() {
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit1 = produitdao.create("jean", "description", "categorie", 1, 3000,null);
		List<ProduitDO> produits = new ArrayList<>();
		produits.add(produit1);
		final Date date = new Date(10);
		final AchatDTO achatdto = new AchatDTO(5,date, produits);
		ConvertAchat convert = new ConvertAchat();
		AchatDO achatdo = convert.achattodo(achatdto);
		assertEquals(achatdo.getDateachat(), achatdto.getDateachat());
		assertEquals(achatdo.getListeprod(), achatdto.getListeprod());
	}

}
