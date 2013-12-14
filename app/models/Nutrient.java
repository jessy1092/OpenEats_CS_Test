package models;

import java.util.UUID;

public class Nutrient {
	String id;
	String name;
	String unit;
	Float value;	
	
	public Nutrient(String name, String unit, Float value)
	{
		this.id = UUID.randomUUID()+"";
		this.name = name;
		this.unit = unit;
		this.value = value;
	}
}
