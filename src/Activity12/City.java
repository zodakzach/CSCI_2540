package Activity12;

public class City extends KeyedItem<String> {
	private String country;
	
	public City(String city, String country) {
		super(city);
		this.country = country;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String toString() {
		return  getKey() + ", " + country;
	}
	
}
