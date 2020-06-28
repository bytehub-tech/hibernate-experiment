package in.co.bytehub.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehcile {

	@Id
	private String RegNo;
	@Enumerated(EnumType.STRING)
	private VehicleType type;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UserInfo user;
	
	
	
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public String getRegNo() {
		return RegNo;
	}

	public void setRegNo(String regNo) {
		RegNo = regNo;
	}
	
	
	
	
}
