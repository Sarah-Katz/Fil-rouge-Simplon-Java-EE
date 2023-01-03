package metier.Convert;

import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DO.ClientDO;
import metier.DTO.ClientDTO;

public class ConvertClient {

	public ClientDTO clienttodto(ClientDO clientdo) {
		ClientDTO clientdto = new ClientDTO(clientdo.getIdclient(), clientdo.getNom(), clientdo.getPrenom(),
				clientdo.getAdresse(), clientdo.getTel(), clientdo.getMail(),
				clientdo.getPanier());
		return clientdto;
	}

	public ClientDO clienttodo(ClientDTO clientdto) {
		ClientDAOimpl clientdao = new ClientDAOimpl();
		ClientDO clientdo = clientdao.create(clientdto.getNom(), clientdto.getPrenom(), clientdto.getAdresse(),
				clientdto.getTel(), clientdto.getMail(), clientdto.getPanier());
		return clientdo;
	}

}
