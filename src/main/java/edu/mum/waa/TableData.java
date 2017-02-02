package edu.mum.waa;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("tableData")
@SessionScoped
public class TableData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Product> products;
	
	private Product product = new Product();

	@Inject
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		if (products == null) {
			products = productRepository.getProducts();
		}
		return products;
	}
	
	public String deleteProduct(Product p) {
		productRepository.removeProduct(p);
		return null;
	}
	
	public String saveProducts() {
		productRepository.updateProducts(products);
		return "index?faces-redirect=true";
	}
	
	public String editProduct(Product p) {
		productRepository.setEditProduct(p);
		return "index?faces-redirect=true";
	}
	
	public String addProduct() {
		productRepository.addProduct(product);
		product = new Product();
		return "index?faces-redirect=true";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
