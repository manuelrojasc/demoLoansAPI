package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.BookLoans;

@Repository
public interface ILoanRepository extends JpaRepository<BookLoans, Long>  {
 
}
