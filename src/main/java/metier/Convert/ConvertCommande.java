package metier.Convert;

import accesDonnees.DAO.CommandeDAO.CommandeDAOimpl;
import accesDonnees.DO.CommandeDO;
import metier.DTO.CommandeDTO;

public class ConvertCommande {

	public CommandeDTO commandetodto(CommandeDO commandedo) {
		CommandeDTO commandedto = new CommandeDTO(commandedo.getIdcomm(), commandedo.getDate(),
				commandedo.getListeprod(), commandedo.getPrix());
		return commandedto;
	}

	public CommandeDO commandetodo(CommandeDTO commandedto) {
		CommandeDAOimpl commandedao = new CommandeDAOimpl();
		CommandeDO commandedo = commandedao.create(commandedto.getDate(), commandedto.getListeprod(),
				commandedto.getPrix());
		return commandedo;
	}

}
