package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.Subject;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long>  {

}
