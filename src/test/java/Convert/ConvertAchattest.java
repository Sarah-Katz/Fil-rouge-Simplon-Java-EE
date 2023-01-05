package Convert;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;
import metier.Convert.ConvertAchat;
import metier.DTO.AchatDTO;
import metier.DTO.FournisseurDTO;
import metier.DTO.ProduitDTO;

class ConvertAchattest {

	@Test
	public void testachattodto() {
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit = produitdao.create("jean", "description", "categorie", 1, 3000);
		List<ProduitDO> produits = new ArrayList<ProduitDO>();
		produits.add(produit);
		final FournisseurDO fournisseur = new FournisseurDAOimpl().create("test", produits);
		final Date date = new Date(10);
		final AchatDAOimpl achatdao = new AchatDAOimpl();
		final AchatDO achatdo = achatdao.create(date, produit, fournisseur);
		ConvertAchat convert = new ConvertAchat();
		AchatDTO achatdto = convert.achattodto(achatdo);
		assertEquals(achatdo.getDateachat(), achatdto.getDateachat());
		assertEquals(achatdo.getProduit().getNom(), achatdto.getProduit().getNom());
		assertEquals(achatdo.getFournisseur().getNom(), achatdto.getFournisseur().getNom());
	}
	
	@Test
	public void testachattodo() {
		final ProduitDTO produit = new ProduitDTO(5,"test", "testdesc", "testcat", 2323, 120);
		ProduitDAOimpl produitdao = new ProduitDAOimpl();
		ProduitDO produit1 = produitdao.create("jean", "description", "categorie", 1, 3000);
		List<ProduitDO> produits = new ArrayList<ProduitDO>();
		produits.add(produit1);
		final FournisseurDTO fournisseur = new FournisseurDTO(5,"test",produits);
		final Date date = new Date(10);
		final AchatDTO achatdto = new AchatDTO(5,date, produit, fournisseur);
		ConvertAchat convert = new ConvertAchat();
		AchatDO achatdo = convert.achattodo(achatdto);
		assertEquals(achatdo.getDateachat(), achatdto.getDateachat());
		assertEquals(achatdo.getProduit().getNom(), achatdto.getProduit().getNom());
		assertEquals(achatdo.getFournisseur().getNom(), achatdto.getFournisseur().getNom());
	}

}
