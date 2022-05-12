package Entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "BookLoans")
public class BookLoans {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "loanstartdate")
	private Date loanStartDate;

	@Column(name = "loanenddate", nullable=true)
	private Date loanEndDate;
	
	@OneToMany
	@JoinColumn(name="subject_id")
	Subject subject;
	
	@OneToMany
	@JoinColumn(name="book_id")
	Book book;
	
	@OneToOne
	@JoinColumn(name="state_id")
	State state;
	
	public BookLoans() {
		
	}
	
	public BookLoans( Date loanStartDate, Date loanEndDate, Subject subject, Book book,State state) {
		this.loanStartDate = loanStartDate;
		this.loanEndDate = loanEndDate;
		this.subject = subject;
		this.book = book;
		this.state=state;
	}

	public long getId() {
		return id;
	}

	public Date getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public Date getLoanEndDate() {
		return loanEndDate;
	}

	public void setLoanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "BookLoans [id=" + id + ", loanStartDate=" + loanStartDate + ", loanEndDate=" + loanEndDate
				+ ", subject=" + subject + ", book=" + book + "]";
	}
	
}
