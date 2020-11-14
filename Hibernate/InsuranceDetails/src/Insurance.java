import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Insurance")
public class Insurance {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	@Column(name = "id")
	private int id;
	
	@Column(name = "policy_number")
	private int policyNumber;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "tenure")
	private int tenure;
	
	@Column(name = "amount")
	private int amount;
	
	public Insurance() {}
	
	public Insurance(int id, int policyNumber, String name, int tenure,int amount) {
		this.id=id;
		this.policyNumber=policyNumber;
		this.name=name;
		this.tenure=tenure;
		this.amount=amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public int getPolicyNumber() {
		return policyNumber;
	}
	
	public int getTenure() {
		return tenure;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

}
