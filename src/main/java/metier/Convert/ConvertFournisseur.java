package metier.Convert;

import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DO.FournisseurDO;
import metier.DTO.FournisseurDTO;

public class ConvertFournisseur {

	public FournisseurDTO fourtodto(FournisseurDO fournisseurdo) {
		FournisseurDTO fournisseurdto = new FournisseurDTO(fournisseurdo.getIdfour(), fournisseurdo.getNom());
		return fournisseurdto;
	}

	public FournisseurDO fourtodo(FournisseurDTO fournisseurdto) {
		FournisseurDAOimpl fournisseurdao = new FournisseurDAOimpl();
		FournisseurDO fournisseurdo = fournisseurdao.create(fournisseurdto.getNom());
		;
		return fournisseurdo;
	}

}
