package Service;

import java.util.List;
import java.util.Optional;

import Entity.Subject;

public interface ISubjectService {

	public List<Subject> getSubjects();	
	
	public Optional<Subject> findById(long id);

	public Subject save(Subject bookloans);

	public void deleteById(long id);
}
