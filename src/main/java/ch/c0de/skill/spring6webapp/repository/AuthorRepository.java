package ch.c0de.skill.spring6webapp.repository;

import ch.c0de.skill.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
