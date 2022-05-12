package Entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;
	
	@Column(name = "autor")
	private String autor;

	@Column(name = "datepublished")
	private Date datePublished;
	
	@OneToOne
	@JoinColumn(name = "book_category_id")
	private BookCategory bookCategory;

	public Book() {

	}

	public Book(String title, String description,String autor, Date datePublished) {
		this.title = title;
		this.description = description;
		this.datePublished = datePublished;
		this.autor=autor;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", titulo=" + title + ", descripcion=" + description + ", autor="+autor+", fecha de publicacion=" + datePublished + "]";
	}

}
