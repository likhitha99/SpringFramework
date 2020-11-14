import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="College_one_to_many")
public class College {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	@Column(name = "id")
	private int id;
	
	private String collegeName;
	private String collegeAddress;
	
	
	@OneToMany(mappedBy = "College_one_to_many", cascade = CascadeType.ALL)
	private Student1 student;
	
public College() {}
	
	public College(int id, String collegeName,String collegeAddress) {
		this.id=id;
		this.collegeName=collegeName;
		this.collegeAddress=collegeAddress;
	}
	
	public College(int id,String collegeName,String collegeAddress, Student1 student) {
		this.id=id;
		this.collegeName=collegeName;
		this.collegeAddress=collegeAddress;
		this.student=student;
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	
	public String getCollegeAddress() {
		return collegeAddress;
	}
	
	public int getId() {
		return id;
	}
	
	public Student1 getStudent() {
		return student;
	}
	
	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}
	
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setStudent(Student1 student) {
		this.student = student;
	}
	
	
}
