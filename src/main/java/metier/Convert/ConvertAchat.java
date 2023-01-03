package metier.Convert;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DO.AchatDO;
import metier.DTO.AchatDTO;

public class ConvertAchat {

	public AchatDTO achattodto(AchatDO achatdo) {
		ConvertProduit convertprod = new ConvertProduit();
		ConvertFournisseur convertfour = new ConvertFournisseur();
		AchatDTO achatdto = new AchatDTO(achatdo.getIdachat(), achatdo.getDateachat(), achatdo.getQuantite(),
				achatdo.getPrix(), convertprod.prodtodto(achatdo.getProduit()),
				convertfour.fourtodto(achatdo.getFournisseur()));
		return achatdto;
	}

	public AchatDO achattodo(AchatDTO achatdto) {
		ConvertProduit convertprod = new ConvertProduit();
		ConvertFournisseur convertfour = new ConvertFournisseur();
		AchatDAOimpl achatdao = new AchatDAOimpl();
		AchatDO achatdo = achatdao.create(achatdto.getDateachat(), achatdto.getQuantite(), achatdto.getPrix(),
				convertprod.prodtodo(achatdto.getProduit()), convertfour.fourtodo(achatdto.getFournisseur()));
		;
		return achatdo;
	}

}
