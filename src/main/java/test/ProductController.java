package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import accesDonnees.DAO.ProduitDAO.ProduitDAOimpl;
import accesDonnees.DO.ProduitDO;

@Controller
@RequestMapping("/prod")
public class ProductController {

	private List<ProduitDO> products = new ArrayList();
	private final ProduitDAOimpl PRODDAO = new ProduitDAOimpl();

	@GetMapping
	public String showCreateForm(Model model) {
		model.addAttribute("product", new ProduitDO());
		return "prod";
	}

	@PostMapping
	public String createProduct(@ModelAttribute ProduitDO product) {
		ProduitDO prod = PRODDAO.create(product.getNom(), product.getDescription(), product.getCategorie(),
				product.getRef(), product.getPrix());
		products.add(prod);
		return "redirect:/prod";
	}

	@GetMapping("/prodlist")
	public String getProducts(Model model) {
		products.removeAll(products);
		List<ProduitDO> listdb = PRODDAO.findAll();
		int lastRef = 0;
		for (ProduitDO p : listdb) {
			if (p.getRef() != lastRef) {
				products.add(p);
				lastRef = p.getRef();
			}
		}
		model.addAttribute("products", products);
		return "prodlist";
	}
}