package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Entity.Book;
import Entity.BookLoans;
import Service.ILoanService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/loan")
public class LoanController {

	@Autowired
	ILoanService service;

	@GetMapping("/getLoans")
	public ResponseEntity<List<BookLoans>> getAllLoans(@RequestParam(required = false) String title) {
		try {
			return new ResponseEntity<>(service.getBookLoans(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookLoans> getBookLoansById(@PathVariable("id") long id) {
		Optional<BookLoans> response = service.findById(id);
		 try {
			if (response.isPresent()) {
				return new ResponseEntity<>(response.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping("/saveBookLoans")
	public ResponseEntity<BookLoans> createBook(@RequestBody BookLoans bookloans) {
		try {
			BookLoans _bookloans = service.save(bookloans); 
					
			return new ResponseEntity<>(_bookloans, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteBookLoansById(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookLoans> updateBook(@PathVariable("id") long id, @RequestBody BookLoans bookloans) {
			try {
				return new ResponseEntity<>(service.save(bookloans), HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

}
