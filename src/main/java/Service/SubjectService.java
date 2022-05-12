package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Subject;
import Repository.ISubjectRepository;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private ISubjectRepository repository;

	@Override
	public List<Subject> getSubjects() {
		return repository.findAll();
	}

	@Override
	public Optional<Subject> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public Subject save(Subject subject) {
		if(subject.getId()>0) {
			Optional<Subject> subjectData = repository.findById(subject.getId());
			Subject _subject=subjectData.get();
			_subject.setAddress(subject.getAddress());
			_subject.setLastName(subject.getAddress());
			_subject.setName(subject.getName());
			_subject.setSubjectRol(subject.getSubjectRol());
			return repository.save(_subject);
		}else
			return repository.save(subject);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
