package guru.springframework.webapp.repository;

import guru.springframework.webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
