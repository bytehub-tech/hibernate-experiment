package in.co.bytehub.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class UserInfo {

	@Id
	@GeneratedValue
	private Integer id;	
	private Name name;
	
	@ElementCollection
	private List<AddressInfo> address;

	@OneToOne(cascade = CascadeType.ALL)
	private CellPhone cellPhone;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public UserInfo(Name name) {
		super();
		this.name = name;
	}
	
	public UserInfo() {
		
	}
	public List<AddressInfo> getAddress() {
		return address;
	}
	public void setAddress(List<AddressInfo> address) {
		this.address = address;
	}

	

	public CellPhone getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(CellPhone cellPhone) {
		this.cellPhone = cellPhone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", cellPhones="+ "]";
	}	
		
	
}
