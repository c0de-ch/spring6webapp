package ch.c0de.skill.spring6webapp.repository;

import ch.c0de.skill.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
