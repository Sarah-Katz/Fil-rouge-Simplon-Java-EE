package accesDonnees.DAO.FournisseurDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import accesDonnees.DO.FournisseurDO;

public class FournisseurDAOimpl implements IFournisseurDAO {

	@Override
	public FournisseurDO create(final String nom, final List<Integer> reflist) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		FournisseurDO Fournisseur = new FournisseurDO(nom, reflist);
		em.persist(Fournisseur);
		em.getTransaction().commit();
		return Fournisseur;
	}

	@Override
	public List<FournisseurDO> findAll() {
		EntityManager em = Util.JPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<FournisseurDO> list = em.createQuery("SELECT f FROM FournisseurDO f")
				.getResultList();
		return list;
	}

	public FournisseurDO findById(final int id) {
		EntityManager em = Util.JPA.getEntityManager();
		Query query = em.createQuery("SELECT f FROM FournisseurDO f where f.idfour = :id");
		query.setParameter("id", id);
		FournisseurDO prod = (FournisseurDO) query.getSingleResult();
		return prod;
	}

	@Override
	public FournisseurDO updateNom(final int id, final String nouveau_nom) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT f from FournisseurDO f where f.idfour =:id");
		query.setParameter("id", id);
		FournisseurDO fournisseur = (FournisseurDO) query.getSingleResult();
		fournisseur.setNom(nouveau_nom);
		em.merge(fournisseur);
		em.getTransaction().commit();
		return fournisseur;
	}

	@Override
	public FournisseurDO updateReflist(final int id, final List<Integer> reflist) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT f from FournisseurDO f where f.idfour =:id");
		query.setParameter("id", id);
		FournisseurDO fournisseur = (FournisseurDO) query.getSingleResult();
		fournisseur.setReflist(reflist);
		em.merge(fournisseur);
		em.getTransaction().commit();
		return fournisseur;
	}

	@Override
	public void delete(final int id) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		FournisseurDO fournisseur = (FournisseurDO) em
				.createQuery("SELECT f FROM FournisseurDO f WHERE f.id = '" + id + "'").getSingleResult();
		em.remove(fournisseur);
		em.getTransaction().commit();
	}

}
