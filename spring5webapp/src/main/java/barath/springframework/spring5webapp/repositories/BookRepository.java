package barath.springframework.spring5webapp.repositories;

import barath.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
//    String count();
}
