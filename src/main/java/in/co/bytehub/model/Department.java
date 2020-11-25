package in.co.bytehub.model;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Integer deptId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employeeList;
    @OneToOne(cascade = CascadeType.ALL)
    private Employee head;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Department setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
        return this;
    }

    public Department() {
    }

    public Integer getDeptId() {
        return deptId;
    }

    public Department setDeptId(Integer deptId) {
        this.deptId = deptId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public Employee getHead() {
        return head;
    }

    public Department setHead(Employee head) {
        this.head = head;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Department.class.getSimpleName() + "[", "]")
                .add("deptId='" + deptId + "'")
                .add("employeeList='" + employeeList + "'")
                .add("name='" + name + "'")
                .add("head=" + head)
                .toString();
    }
}
