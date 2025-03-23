package ch.c0de.skill.spring6webapp.services;

import ch.c0de.skill.spring6webapp.domain.Book;
import ch.c0de.skill.spring6webapp.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
