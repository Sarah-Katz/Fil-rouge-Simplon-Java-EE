package metier.Convert;

import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DO.PanierDO;
import metier.DTO.PanierDTO;

public class ConvertPanier {

	public PanierDTO paniertodto(PanierDO panierdo) {
		ConvertCommande convertcomm = new ConvertCommande();
		PanierDTO panierdto = new PanierDTO(panierdo.getIdpanier(), panierdo.getClient(),
				convertcomm.commandetodto(panierdo.getCommande()));
		return panierdto;
	}
	
	public PanierDO paniertodo(PanierDTO panierdto) {
		ConvertCommande convertcomm = new ConvertCommande();
		PanierDAOimpl panierdao = new PanierDAOimpl();
		PanierDO panierdo = panierdao.create(convertcomm.commandetodo(panierdto.getCommande()),
				panierdto.getClient());
		return panierdo;
	}

}
