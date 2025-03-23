package ch.c0de.skill.spring6webapp.services;

import ch.c0de.skill.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
