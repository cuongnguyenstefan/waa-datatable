package edu.mum.waa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class ProductRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private static List<Product> products = new ArrayList<Product>();

	static {
		Product p = new Product();
		p.setId("1");
		p.setName("iPhone");
		p.setDescription("Apple's");
		p.setEdit(false);
		Product iPad = new Product();
		iPad.setId("2");
		iPad.setName("iPad");
		iPad.setDescription("Apple's");
		iPad.setEdit(false);
		products.add(p);
		products.add(iPad);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product p) {
		products.add(p);
	}
	
	public void updateProducts(List<Product> p) {
		products = p;
		for (Product product : products) {
			product.setEdit(false);
		}
	}

	public void editProduct(Product product) {
		for (Product p : products) {
			if (p.equals(product)) {
				p.setDescription(product.getDescription());
				p.setName(product.getName());
				break;
			}
		}
	}

	public void removeProduct(Product p) {
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.equals(p)) {
				iterator.remove();
				break;
			}
		}
	}

	public void setEditProduct(Product product) {
		for (Product p : products) {
			if (p.equals(product)) {
				p.setEdit(true);
				break;
			}
		}
	}
}
