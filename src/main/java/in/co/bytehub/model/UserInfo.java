package in.co.bytehub.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Vehcile> vehcile; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Name getName() {
		return name;
	}
	public List<Vehcile> getVehcile() {
		return vehcile;
	}
	public void setVehcile(List<Vehcile> vehcile) {
		this.vehcile = vehcile;
	}
	public void setId(Integer id) {
		this.id = id;
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
		return "UserInfo [id=" + id + ", name=" + name + ", address=" + address + ", cellPhone=" + cellPhone
				+ ", vehcile=" + vehcile + "]";
	}

		
	
}
