package accesDonnees.DAO.FournisseurDAO;

import java.util.List;

import accesDonnees.DO.FournisseurDO;

public interface IFournisseurDAO {
	public FournisseurDO create(final String nom, final List<Integer> reflist);
	public List<FournisseurDO> findAll();
	public FournisseurDO updateNom(final int id, final String nouveau_nom);
	public FournisseurDO updateReflist(final int id, final List<Integer> reflist);
	public void delete(final int id);
}
