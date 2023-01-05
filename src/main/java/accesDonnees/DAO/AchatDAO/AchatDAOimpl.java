package accesDonnees.DAO.AchatDAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import accesDonnees.DO.AchatDO;
import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;

public class AchatDAOimpl implements IAchatDAO {

	public AchatDO create(final Date dateachat, final ProduitDO produit, final FournisseurDO fournisseur) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		AchatDO achat = new AchatDO(dateachat, produit, fournisseur);
		em.persist(achat);
		em.getTransaction().commit();
		return achat;
	}

	public List<AchatDO> findAll() {
		final EntityManager em = Util.JPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<AchatDO> list = em.createQuery("SELECT a FROM AchatDO a").getResultList();
		return list;
	}

	public List<AchatDO> findByRef(final int ref) {
		final EntityManager em = Util.JPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<AchatDO> list = em.createQuery("SELECT a FROM AchatDO a WHERE a.produit.ref = :ref")
				.setParameter("ref", ref).getResultList();
		return list;
	}

	public AchatDO updateDateachat(final int id, final Date dateachat) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final Query query = em.createQuery("SELECT a FROM AchatDO a WHERE a.id = :id");
		query.setParameter("id", id);
		final AchatDO achat = (AchatDO) query.getSingleResult();
		achat.setDateachat(dateachat);
		em.merge(achat);
		em.getTransaction().commit();
		return achat;
	}

	public AchatDO updateProduit(final int id, final ProduitDO produit) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final Query query = em.createQuery("SELECT a FROM AchatDO a WHERE a.id = :id");
		query.setParameter("id", id);
		final AchatDO achat = (AchatDO) query.getSingleResult();
		achat.setProduit(produit);
		em.merge(achat);
		em.getTransaction().commit();
		return achat;
	}

	public AchatDO updateFournisseur(final int id, final FournisseurDO fournisseur) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final Query query = em.createQuery("SELECT a FROM AchatDO a WHERE a.id = :id");
		query.setParameter("id", id);
		final AchatDO achat = (AchatDO) query.getSingleResult();
		achat.setFournisseur(fournisseur);
		em.merge(achat);
		em.getTransaction().commit();
		return achat;
	}

	public void delete(final int id) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final AchatDO produit = (AchatDO) em.createQuery("SELECT a FROM AchatDO a WHERE a.id = '" + id + "'")
				.getSingleResult();
		em.remove(produit);
		em.getTransaction().commit();
	}
}
