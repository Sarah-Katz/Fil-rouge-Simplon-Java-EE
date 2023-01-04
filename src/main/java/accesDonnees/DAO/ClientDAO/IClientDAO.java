package accesDonnees.DAO.ClientDAO;

import java.util.List;

import accesDonnees.DO.ClientDO;
import accesDonnees.DO.PanierDO;

public interface IClientDAO {
	public ClientDO create(final String nom, final String prenom, final String adresse, final int tel,
			final String mail, final PanierDO panier);
	
	public List<ClientDO> findAll();
	
	public ClientDO findByMail(final String mail);
	
	public ClientDO updateNom(final int id, final String nom);
	
	public ClientDO updatePrenom(final int id, final String prenom);
	
	public ClientDO updateAdresse(final int id, final String adresse);
	
	public ClientDO updateTel(final int id, final int tel);
	
	public ClientDO updateMail(final int id, final String mail);
	
	public ClientDO updatePanier(final int id, final PanierDO panier);
	
	public void delete(final int id);
}
