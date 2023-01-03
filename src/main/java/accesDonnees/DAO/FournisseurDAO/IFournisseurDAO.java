package accesDonnees.DAO.FournisseurDAO;

import java.util.List;

import accesDonnees.DO.FournisseurDO;

public interface IFournisseurDAO {
	public FournisseurDO create(final String nom);
	public List<FournisseurDO> findAll();
	public FournisseurDO update(final String ancien_nom, final String nouveau_nom);
	public void delete(final int id);
}
