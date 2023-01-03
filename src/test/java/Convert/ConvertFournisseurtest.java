package Convert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DO.FournisseurDO;
import metier.Convert.ConvertFournisseur;
import metier.DTO.FournisseurDTO;

class ConvertFournisseurtest {

	@Test
	public void testfourtodto() {
		String nom = "jean";
		FournisseurDAOimpl fournisseurdao = new FournisseurDAOimpl();
		FournisseurDO fournisseurdo = fournisseurdao.create(nom);
		ConvertFournisseur convert = new ConvertFournisseur();
		FournisseurDTO fournisseurdto = convert.fourtodto(fournisseurdo);
		assertEquals(fournisseurdo.getNom(), fournisseurdto.getNom());
	}
	
	@Test
	public void testfourtodo() {
		int id = 5;
		String nom = "jean";
		FournisseurDTO fournisseurdto = new FournisseurDTO(id,nom);
		ConvertFournisseur convert = new ConvertFournisseur();
		FournisseurDO fournisseurdo = convert.fourtodo(fournisseurdto);
		assertEquals(fournisseurdo.getNom(), fournisseurdto.getNom());
	}

}
