package Util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import accesDonnees.DAO.AchatDAO.AchatDAOimpl;
import accesDonnees.DAO.ClientDAO.ClientDAOimpl;
import accesDonnees.DAO.FournisseurDAO.FournisseurDAOimpl;
import accesDonnees.DAO.PanierDAO.PanierDAOimpl;
import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.AchatDO;
import accesDonnees.DO.ClientDO;
import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.PanierDO;
import accesDonnees.DO.ProduitDO;

public class Test {
	final static ClientDAOimpl CLIENTDAO = new ClientDAOimpl();
	final static PanierDAOimpl PANIERDAO = new PanierDAOimpl();
	final static ProduitDAOimpl PRODUITDAO = new ProduitDAOimpl();	
	final static FournisseurDAOimpl FOURDAO = new FournisseurDAOimpl();
	final static AchatDAOimpl ACHATDAO = new AchatDAOimpl();
	
	public static void main(String[] args) {
//		dropTables();
		addClientToDb();
		addProductsToDb();
		addFournisseurToDb();
		addAchatToDb();
	}
	
	public static ClientDO addClientToDb() {
		PanierDO panier = PANIERDAO.create(null);
		ClientDO client = CLIENTDAO.create("Katz", "Sarah", "44 rue du test", 0606060606, "mail@mail.mail", panier);
		return client;
	}
	
	public static ProduitDO createprod(String nom, String desc, String cat, int ref, double prix) {
		ProduitDO prod = PRODUITDAO.create(nom, desc, cat, ref, prix);
		return prod;		
	}
	
	public static void addProductsToDb() {
		createprod("Pâtes fraîches aux œufs", "Des pâtes fraîches maison au blé dur et aux œufs, idéales pour toutes vos recettes de pâtes", "Pâtes", 1, 4.99);
		createprod("Riz basmati", "Un riz parfumé aux grains longs et fins, idéal pour accompagner vos plats indiens ou asiatiques", "Riz et grains", 2, 1.99);
		createprod("Sauce tomate bio", "Une sauce tomate bio, faite avec des tomates fraîches et mûries au soleil", "Sauces et condiments", 3, 3.49);
		createprod("Poulet bio", "Un poulet bio élevé en liberté et nourri avec des grains de qualité supérieure", "Viande", 4, 12.99);
		createprod("Fromage de chèvre frais", "Un fromage de chèvre frais aux arômes légers et crémeux, idéal pour les salades ou les toasts", "Fromage", 5, 6.99);
		createprod("Thé vert matcha", "Un thé vert matcha de haute qualité, idéal pour les boissons chaudes ou froides", "Thé et café", 6, 8.99);
		createprod("Miel de fleurs sauvages", "Un miel de fleurs sauvages aux notes florales et légèrement acidulées, idéal pour les tartines ou les boissons chaudes", "Miel et confitures", 7, 7.99);
		createprod("Noix de cajou", "Des noix de cajou croustillantes et savoureuses, idéales en collation ou en garniture de plats", "Fruits à coque", 8, 5.99);
		createprod("Granola aux flocons d'avoine", "Un granola aux flocons d'avoine et aux noix, idéal pour les petits déjeuners ou les collations saines", "Céréales et granolas", 9, 4.99);
		createprod("Jus d'orange pressé", "Un jus d'orange pressé frais et naturel, idéal pour un petit déjeuner énergisant", "Jus de fruits", 10, 3.49);
		createprod("Thé glacé aux fruits de la passion", "Un thé glacé aux fruits de la passion et aux herbes fraîches, idéal pour les journées chaudes", "Thé et café", 11, 2.99);
		createprod("Smoothie aux baies et aux amandes", "Un smoothie aux baies et aux amandes, idéal pour une collation saine et rafraîchissante", "Smoothies et jus", 12, 5.99);
		createprod("Bière artisanale aux agrumes", "Une bière artisanale aux agrumes et aux herbes fraîches, idéale pour les soirées d'été", "Bières", 13, 6.99);
		createprod("Café moulu bio", "Un café moulu bio aux arômes intenses et aux notes de chocolat, idéal pour les amateurs de café fort", "Café et expresso", 14, 8.99);
		createprod("Thé vert au jasmin", "Un thé vert au jasmin aux arômes délicats et floral, idéal pour les après-midis relaxants", "Thé et café", 15, 7.99);
		createprod("Limonade maison aux fruits rouges", "Une limonade maison aux fruits rouges et aux herbes fraîches, idéale pour les journées chaudes", "Limonades et sodas", 16, 4.99);
		createprod("Eau minérale pétillante", "Une eau minérale pétillante légèrement gazeuse, idéale pour se rafraîchir tout au long de la journée", "Eaux", 17, 2.49);
		createprod("Steak haché de boeuf", "Un steak haché de boeuf savoureux et juteux, idéal pour les burgers ou les tacos", "Viande", 18, 7.99);
		createprod("Poitrine de porc fumée", "Une poitrine de porc fumée aux arômes de fumée et de miel, idéale pour les sandwiches ou les plats en sauce", "Viande", 19, 9.99);
		createprod("Saucisses de poulet aux herbes", "Des saucisses de poulet aux herbes fraîches et aux épices, idéales pour les grillades ou les plats en sauce", "Viande", 20, 5.99);
		createprod("Filet mignon de porc", "Un filet mignon de porc tendre et juteux, idéal pour les repas de fête ou les plats en sauce", "Viande", 21, 13.99);
		createprod("Aiguillettes de poulet", "Des aiguillettes de poulet tendres et juteuses, idéales pour les salades ou les plats en sauce", "Viande", 22, 7.99);
	}
	
	public static void addFournisseurToDb() {
		FournisseurDO four = FOURDAO.create("Centrale d'achat", null);
		List<ProduitDO> prodlist = PRODUITDAO.findAll();
		List<Integer> reflist = new ArrayList<Integer>();
		for (ProduitDO p : prodlist) {
			reflist.add(p.getRef());
		}
		FOURDAO.updateReflist(four.getIdfour(), reflist);
	}
	
	public static void addAchatToDb() {
		AchatDO achat = ACHATDAO.create(null, null);
	}
	
	public static void dropTables() {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
	    String query = "DROP TABLE achat, client, commande, fournisseur, panier, produit CASCADE";
	    em.createNativeQuery(query).executeUpdate();
	    em.getTransaction().commit();
	}

}
