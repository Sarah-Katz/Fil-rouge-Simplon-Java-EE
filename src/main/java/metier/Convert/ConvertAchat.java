package metier.Convert;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DO.AchatDO;
import metier.DTO.AchatDTO;

public class ConvertAchat {

	public AchatDTO achattodto(AchatDO achatdo) {
		AchatDTO achatdto = new AchatDTO(achatdo.getIdachat(), achatdo.getDateachat(),
				achatdo.getListeprod());
		return achatdto;
	}

	public AchatDO achattodo(AchatDTO achatdto) {
		AchatDAOimpl achatdao = new AchatDAOimpl();
		AchatDO achatdo = achatdao.create(achatdto.getDateachat(), achatdto.getListeprod());
		;
		return achatdo;
	}

}
