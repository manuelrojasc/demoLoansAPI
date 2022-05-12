package Entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "SubjectRol")
public class SubjectRol {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	public SubjectRol() {

	}

	public SubjectRol(String name, String description) {
		this.name = name;
		this.description = description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", nombre=" + name + ", descripcion=" + description + "]";
	}

}
