package accesDonnees.DAO.ProduitDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;

public class ProduitDAOimpl implements IProduitDAO {

	public ProduitDO create(final String nom, final String desc, final String categorie, final int ref,
			final double prix, final FournisseurDO fournisseur) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		ProduitDO produit = new ProduitDO(nom, desc, categorie, ref, prix,fournisseur);
		em.persist(produit);
		em.getTransaction().commit();
		return produit;
	}

	public List<ProduitDO> findAll() {
		EntityManager em = Util.JPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<ProduitDO> list = (List<ProduitDO>) em.createQuery("SELECT p FROM ProduitDO p ORDER BY p.ref")
				.getResultList();
		return list;
	}

	public ProduitDO findById(final int id) {
		EntityManager em = Util.JPA.getEntityManager();
		Query query = em.createQuery("SELECT p FROM ProduitDO p where p.idprod = :id");
		query.setParameter("id", id);
		ProduitDO prod = (ProduitDO) query.getSingleResult();
		return prod;
	}

	public List<ProduitDO> findByRef(final int ref) {
		EntityManager em = Util.JPA.getEntityManager();
		Query query = em.createQuery("SELECT p FROM ProduitDO p where p.ref = :ref");
		query.setParameter("ref", ref);
		@SuppressWarnings("unchecked")
		List<ProduitDO> list = query.getResultList();
		return list;
	}

	public List<ProduitDO> findByName(final String nom) {
		EntityManager em = Util.JPA.getEntityManager();
		Query query = em.createQuery("SELECT p FROM ProduitDO p where p.nom LIKE :nom");
		query.setParameter("nom", "%" + nom + "%");
		@SuppressWarnings("unchecked")
		List<ProduitDO> list = query.getResultList();
		return list;
	}

	public void delete(final int id) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		ProduitDO produit = (ProduitDO) em.createQuery("SELECT p FROM ProduitDO p WHERE p.id = '" + id + "'")
				.getSingleResult();
		em.remove(produit);
		em.getTransaction().commit();
	}

	public ProduitDO updateNom(final int id, final String nouveau_nom) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.idprod =:id");
		query.setParameter("id", id);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setNom(nouveau_nom);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}

	public ProduitDO updateDesc(final int id, final String nouveau_desc) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.idprod =:id");
		query.setParameter("id", id);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setDescription(nouveau_desc);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}

	public ProduitDO updatecate(final int id, final String nouveau_cate) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.idprod =:id");
		query.setParameter("id", id);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setCategorie(nouveau_cate);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}

	public ProduitDO updateref(final int id, final int nouveau_ref) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.idprod =:id");
		query.setParameter("id", id);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setRef(nouveau_ref);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}

	public ProduitDO updateprix(final int id, final double nouveau_prix) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.idprod =:id");
		query.setParameter("id", id);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setPrix(nouveau_prix);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}
	
	public ProduitDO updateincomm(final int id, final boolean incomm) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.idprod =:id");
		query.setParameter("id", id);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setIncomm(incomm);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}
	
	public ProduitDO updatefour(final int id, final FournisseurDO fournisseur) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.idprod =:id");
		query.setParameter("id", id);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setFournisseur(fournisseur);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}

}
