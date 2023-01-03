package accesDonnees.DAO.PanierDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.PanierDO;

public class PanierDAOimpl implements IPanierDAO {

	public PanierDO create(final CommandeDO commande) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final PanierDO panier = new PanierDO(commande);
		em.persist(panier);
		em.getTransaction().commit();
		return panier;
	}

	public List<PanierDO> findAll() {
		final EntityManager em = Util.JPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<PanierDO> list = em.createQuery("SELECT p FROM PanierDO p").getResultList();
		return list;
	}

	public List<PanierDO> findByCommande(final CommandeDO commande) {
		final EntityManager em = Util.JPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<PanierDO> list = em.createQuery("SELECT p FROM PanierDO p WHERE p.commande.id = :commid")
		.setParameter("commid", commande.getIdcomm()).getResultList();		
		return list;
		
	}

	public PanierDO updateCommande(final int id, final CommandeDO commande) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final Query query = em.createQuery("SELECT p FROM PanierDO p WHERE p.id = :id");
		query.setParameter("id", id);
		final PanierDO panier = (PanierDO) query.getSingleResult();
		panier.setCommande(commande);
		em.getTransaction().commit();
		return panier;
	}

	public void delete(final int id) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final PanierDO panier = (PanierDO) em.createQuery("SELECT p FROM PanierDO p WHERE p.id = :id")
				.setParameter("id", id).getSingleResult();
		em.remove(panier);
		em.getTransaction().commit();
	}

}
