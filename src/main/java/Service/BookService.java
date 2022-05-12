package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Book;
import Repository.IBookRepository;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository repository;
	@Override
	public List<Book> getBooks() {
		return repository.findAll();
	}
	@Override
	public Optional<Book> findById(long id) {
		return repository.findById(id);
	}
	@Override
	public Book save(Book book) {
		if(book.getId()>0) {
			Optional<Book> bookData = repository.findById(book.getId());
			Book _book=bookData.get();
			_book.setAutor(book.getAutor());
			_book.setDatePublished(book.getDatePublished());
			_book.setDescription(book.getDescription());
			_book.setTitle(book.getTitle());
			_book.setBookCategory(book.getBookCategory());
			return repository.save(_book);
		}else
			return repository.save(book);
	}
	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
		
	}

}
