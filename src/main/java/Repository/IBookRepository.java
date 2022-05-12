package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long>  {

}
