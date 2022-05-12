package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.BookLoans;
import Repository.ILoanRepository;

@Service
public class LoanService implements ILoanService {
    @Autowired
    private ILoanRepository repository;

	@Override
	public List<BookLoans> getBookLoans() {
			return repository.findAll();
	}

	@Override
	public Optional<BookLoans> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public BookLoans save(BookLoans bookloans) {
		if(bookloans.getId()>0) {
			Optional<BookLoans> bookloansData = repository.findById(bookloans.getId());
			BookLoans _bookloans=bookloansData.get();
			_bookloans.setBook(bookloans.getBook());
			_bookloans.setLoanEndDate(bookloans.getLoanEndDate());
			_bookloans.setLoanStartDate(bookloans.getLoanStartDate());
			_bookloans.setSubject(bookloans.getSubject());
			_bookloans.setState(bookloans.getState());
			return repository.save(_bookloans);
		}else
			return repository.save(bookloans);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
