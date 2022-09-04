package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.ProdCategary;
import com.product.entity.Product;
import com.product.entity.ProductResponce;
import com.product.entity.charges;
import com.product.repo.CatRepo;
import com.product.repo.ProductRepo;

@Service
public class ProdServiceImpl implements ProdService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	CatRepo catRepo;

	@Override
	public ProdCategary savecat(ProdCategary prodCategary) {
		return catRepo.save(prodCategary);
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getProducts() {

		return productRepo.findAll();
	}

	@Override
	public Optional<Product> getProductById(int productId) {
		return productRepo.findById(productId);
	}

	@Override
	public Optional<ProdCategary> get(String cat) {

		return catRepo.findById(cat);
	}

	@Override
	public ProductResponce getProduct(int pid) {
		Optional<Product> Product = productRepo.findById(pid);
		String category = Product.get().getCategory();
		Optional<ProdCategary> product_category = catRepo.getListCatName(category);

		// product price
		Long basePrice = Product.get().getBasePrice();

		// calculate discount
		Long dis = product_category.get().getDis();
		Long s = 100 - dis;
		Long totaldiscount = basePrice - (s * basePrice) / 100;

		// calculate Gst
		Long gst = product_category.get().getGst();
		Long totalGst = (basePrice * (gst / 100));
		// calculate delivery charge
		Long deliveryCharge = product_category.get().getDeliverycharge();

		// calculating final price
		Long finalprice = basePrice - totaldiscount + deliveryCharge + totalGst;

		charges c = new charges();
		c.setGst(totalGst);
		c.setDeliverycharges(deliveryCharge);
		ProductResponce resp = new ProductResponce();

		resp.setProduct(Product.get());
		resp.setDiscount(totaldiscount);
		resp.setCharges(c);
		resp.setFinalPrice(finalprice);
		return resp;
	}

	@Override
	public Product updateProduct(Product product, Integer pid) {
		Optional<Product> prod = productRepo.findById(pid);
		if (prod.isPresent()) {
			return productRepo.save(product);
		} else {
			return null;
		}
	}

	@Override
	public String deleteProduct(Integer pid) {
		Optional<Product> prod = productRepo.findById(pid);
		if (prod.isPresent()) {
			Product deleteprod = prod.get();
			productRepo.delete(deleteprod);
			return "succesfully delete";
		}
		return "please enter correct productid";
	}

	@Override
	public List<ProdCategary> getProductCategaryList() {

		return catRepo.findAll();
	}

}
