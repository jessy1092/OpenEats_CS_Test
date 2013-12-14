package models;
import java.util.ArrayList;
import java.util.UUID;

public class Nutrition {
	
	String id;
	String product_id;
	ArrayList<Nutrient> nutrients;
	
	public Nutrition(String product_id, ArrayList<Nutrient> nutrients)
	{
		this.id = UUID.randomUUID()+"";
		this.product_id = product_id;
		this.nutrients = nutrients;
	}
}
