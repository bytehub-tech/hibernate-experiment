package in.co.bytehub.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private int courseId;
	private String name;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;
	
	
	
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + "]";
	}
	
	
}
