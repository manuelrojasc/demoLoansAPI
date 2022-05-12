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
import Entity.Subject;
import Service.ISubjectService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/subject")
public class SubjectController {

	@Autowired
	ISubjectService service;

	@GetMapping("/tutorials")
	public ResponseEntity<List<Subject>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			return new ResponseEntity<>(service.getSubjects(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Subject> getBookById(@PathVariable("id") long id) {
		Optional<Subject> response = service.findById(id);
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
	
	@PostMapping("/saveBook")
	public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
		try {
			Subject _subject = service.save(subject); 
					
			return new ResponseEntity<>(_subject, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteSubject(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Subject> updateBook(@PathVariable("id") long id, @RequestBody Subject subject) {
			try {
				return new ResponseEntity<>(service.save(subject), HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

}
