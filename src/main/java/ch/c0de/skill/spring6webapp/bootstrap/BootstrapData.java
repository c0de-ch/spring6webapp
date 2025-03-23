package ch.c0de.skill.spring6webapp.bootstrap;

import ch.c0de.skill.spring6webapp.domain.Author;
import ch.c0de.skill.spring6webapp.domain.Book;
import ch.c0de.skill.spring6webapp.domain.Publisher;
import ch.c0de.skill.spring6webapp.repository.AuthorRepository;
import ch.c0de.skill.spring6webapp.repository.BookRepository;
import ch.c0de.skill.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Kim");
        author.setLastName("Jelmoni");
        Author savedAuthor = authorRepository.save(author);

        Author author2 = new Author();
        author2.setFirstName("Ling");
        author2.setLastName("Li");
        Author savedAuthor2 = authorRepository.save(author2);

        Book book = new Book();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setIsbn("978-0345391802");
        Book savedBook = bookRepository.save(book);

        Book book2 = new Book();
        book2.setTitle("The Hitchhiker's Guide to the Galaxy2");
        book2.setIsbn("978-034877902");
        Book savedBook2 = bookRepository.save(book2);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Tech Books");
        Publisher savedPublisher = publisherRepository.save(publisher);
        savedBook.setPublisher(publisher);
        savedBook2.setPublisher(publisher);
        bookRepository.save(savedBook);
        bookRepository.save(savedBook2);


        savedAuthor.getBooks().add(savedBook);
        savedAuthor2.getBooks().add(savedBook2);
        authorRepository.save(savedAuthor);
        authorRepository.save(savedAuthor2);

        savedBook.getAuthors().add(savedAuthor);
        savedBook2.getAuthors().add(savedAuthor2);
        bookRepository.save(savedBook);
        bookRepository.save(savedBook2);

        System.out.println("Bootstrap Data");
        System.out.println("=====================");
        System.out.println("Authors: " + authorRepository.count());
        System.out.println("Books: " + bookRepository.count());
        System.out.println("Publishers: " + publisherRepository.count());
        System.out.println("=====================");

    }
}
