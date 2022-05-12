package Service;

import java.util.List;
import java.util.Optional;

import Entity.Book;
import Entity.BookLoans;

public interface ILoanService {

	public List<BookLoans> getBookLoans();
	
	public Optional<BookLoans> findById(long id);

	public BookLoans save(BookLoans bookloans);

	public void deleteById(long id);
}
