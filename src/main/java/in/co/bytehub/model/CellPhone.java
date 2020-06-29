package in.co.bytehub.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CellPhone {

	@Id
	private Long phoneNumber;
	private String model;
	
	@OneToOne(mappedBy = "cellPhone")
	private Student user;
	
	

	public Student getUser() {
		return user;
	}
	public void setUser(Student user) {
		this.user = user;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "CellPhone [phoneNumber=" + phoneNumber + ", model=" + model + "]";
	}

	
}

