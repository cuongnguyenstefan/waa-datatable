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
	
	private Product product = new Product();

	@Inject
	private ProductRepository pr;

	public List<Product> getProducts() {
		return pr.getProducts();
	}
	
	public String deleteProduct(Product p) {
		pr.removeProduct(p);
		return null;
	}
	
	public String editProductPage(Product p) {
		product = p;
		return "edit";
	}
	
	public String editProduct() {
		pr.editProduct(product);
		product = new Product();
		return "index";
	}
	
	public String addProduct() {
		pr.addProduct(product);
		product = new Product();
		return null;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	

}
