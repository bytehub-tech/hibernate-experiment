package in.co.bytehub.model;

import javax.persistence.*;
import java.util.StringJoiner;


@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@ManyToOne
	private Department department;

	public Employee() {
	}

	public Employee(Integer id, String name, Department department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public Employee setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	public Department getDepartment() {
		return department;
	}

	public Employee setDepartment(Department department) {
		this.department = department;
		return this;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("name='" + name + "'")
				.add("department=" + department)
				.toString();
	}
}
