package models;

import java.util.UUID;

public class Product {
	String id;
	String barcode;
	String name;
	String manufacturer_id;
	String distributor_id;
	String image_url;
	
	public Product(String barcode, String name, String manufacturer_id, String distributor_id, String image_url)
	{
		this.id = UUID.randomUUID()+"";
		this.barcode = barcode;
		this.name = name;
		this.manufacturer_id = manufacturer_id;
		this.image_url = image_url;		
	}
}
