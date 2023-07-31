package sda.bellerobe.entity;

import java.util.List;

public class OrderInput {
	
	private String fullName;
	private String fullAddress;
	private String contactNumber;
	private String alternateContactNumber;
	private List<OrderDressQuantity> orderDressQuantityList;
	
	

	public OrderInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFullName() {
		return fullName;
	}
	
	

	public List<OrderDressQuantity> getOrderDressQuantityList() {
		return orderDressQuantityList;
	}

	public void setOrderDressQuantityList(List<OrderDressQuantity> orderDressQuantityList) {
		this.orderDressQuantityList = orderDressQuantityList;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}

	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}
	
	
	
	
	

}
