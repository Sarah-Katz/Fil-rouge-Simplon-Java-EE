package Convert;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

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
		final ProduitDO produit = new ProduitDAOimpl().create("test", "testdesc", "testcat", 2323, 120);
		final FournisseurDO fournisseur = new FournisseurDAOimpl().create("test");
		final Date date = new Date(10);
		final AchatDAOimpl achatdao = new AchatDAOimpl();
		final AchatDO achatdo = achatdao.create(date, 0, 0, produit, fournisseur);
		ConvertAchat convert = new ConvertAchat();
		AchatDTO achatdto = convert.achattodto(achatdo);
		assertEquals(achatdo.getDateachat(), achatdto.getDateachat());
		assertEquals(achatdo.getQuantite(), achatdto.getQuantite());
		assertEquals(achatdo.getPrix(), achatdto.getPrix());
		assertEquals(achatdo.getProduit().getNom(), achatdto.getProduit().getNom());
		assertEquals(achatdo.getFournisseur().getNom(), achatdto.getFournisseur().getNom());
	}
	
	@Test
	public void testachattodo() {
		final ProduitDTO produit = new ProduitDTO(5,"test", "testdesc", "testcat", 2323, 120);
		final FournisseurDTO fournisseur = new FournisseurDTO(5,"test");
		final Date date = new Date(10);
		final AchatDTO achatdto = new AchatDTO(5,date, 0, 0, produit, fournisseur);
		ConvertAchat convert = new ConvertAchat();
		AchatDO achatdo = convert.achattodo(achatdto);
		assertEquals(achatdo.getDateachat(), achatdto.getDateachat());
		assertEquals(achatdo.getQuantite(), achatdto.getQuantite());
		assertEquals(achatdo.getPrix(), achatdto.getPrix());
		assertEquals(achatdo.getProduit().getNom(), achatdto.getProduit().getNom());
		assertEquals(achatdo.getFournisseur().getNom(), achatdto.getFournisseur().getNom());
	}

}
