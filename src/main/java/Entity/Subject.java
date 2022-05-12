package Entity;

import javax.persistence.*;

@Entity
@Table(name = "Subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "address")
	private String address;
	
	@OneToOne
	@JoinColumn(name = "subject_rol_id")
	private SubjectRol subjectRol;

	public Subject() {

	}

	public Subject(String name, String lastName, String address,SubjectRol subjectRol) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.subjectRol=subjectRol;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public SubjectRol getSubjectRol() {
		return subjectRol;
	}

	public void setSubjectRol(SubjectRol subjectRol) {
		this.subjectRol = subjectRol;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address
				+ ", subjectRol=" + subjectRol + "]";
	}

}
