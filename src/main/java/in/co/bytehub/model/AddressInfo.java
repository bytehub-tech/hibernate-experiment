package in.co.bytehub.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class AddressInfo {
	
	
	private int zip;
	private String state;
	private String country;
	private String city;
	@Enumerated(EnumType.STRING)
	private AddressType type;
	
	
	
	public AddressType getType() {
		return type;
	}
	public void setType(AddressType type) {
		this.type = type;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
