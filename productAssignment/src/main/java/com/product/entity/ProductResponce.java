package com.product.entity;

public class ProductResponce {
 
	private Product product;
	private float discount;
    private charges charges;
    private float finalPrice;
	public ProductResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductResponce(Product product, float discount, com.product.entity.charges charges, float finalPrice) {
		super();
		this.product = product;
		this.discount = discount;
		this.charges = charges;
		this.finalPrice = finalPrice;
	}

	public charges getCharges() {
		return charges;
	}

	public void setCharges(charges charges) {
		this.charges = charges;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}
	@Override
	public String toString() {
		return "ProductResponce [product=" + product + ", discount=" + discount +  ", finalPrice=" + finalPrice + "]";
	}
    
    
        
}
