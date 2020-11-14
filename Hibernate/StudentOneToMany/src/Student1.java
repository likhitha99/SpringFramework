import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT1")

public class Student1 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	
	private String firstName;
	private String lastName;
	private String course;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private College college;
	
public Student1() {}
	
	public Student1(int id, String fname,String lname,String course) {
		this.id=id;
		this.firstName=fname;
		this.lastName=lname;
		this.course=course;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName=first_name;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
		this.lastName=last_name;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course=course;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	
	
}
