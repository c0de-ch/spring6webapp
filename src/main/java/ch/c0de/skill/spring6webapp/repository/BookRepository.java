package ch.c0de.skill.spring6webapp.repository;

import ch.c0de.skill.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
