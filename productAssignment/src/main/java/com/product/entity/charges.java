package com.product.entity;

public class charges {
	private Long gst;
    private Long deliverycharges;
	public charges() {
		super();
		// TODO Auto-generated constructor stub
	}
	public charges(Long gst, Long deliverycharges) {
		super();
		this.gst = gst;
		this.deliverycharges = deliverycharges;
	}
	public Long getGst() {
		return gst;
	}
	public void setGst(Long gst) {
		this.gst = gst;
	}
	public Long getDeliverycharges() {
		return deliverycharges;
	}
	public void setDeliverycharges(Long deliverycharges) {
		this.deliverycharges = deliverycharges;
	}
	@Override
	public String toString() {
		return "charges [gst=" + gst + ", deliverycharges=" + deliverycharges + "]";
	}
	
    
    
}
