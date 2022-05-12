package Service;

import java.util.List;
import java.util.Optional;

import Entity.Book;

public interface IBookService {

	public List<Book> getBooks();

	public Optional<Book> findById(long id);

	public Book save(Book book);

	public void deleteById(long id);
	
	
}
