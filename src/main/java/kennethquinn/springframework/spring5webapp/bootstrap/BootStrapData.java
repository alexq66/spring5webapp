package kennethquinn.springframework.spring5webapp.bootstrap;

import kennethquinn.springframework.spring5webapp.domain.Author;
import kennethquinn.springframework.spring5webapp.domain.Book;
import kennethquinn.springframework.spring5webapp.domain.Publisher;
import kennethquinn.springframework.spring5webapp.repositories.AuthorRepository;
import kennethquinn.springframework.spring5webapp.repositories.BookRepository;
import kennethquinn.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Kenneth Quinn on 2/5/2024
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final Object publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123456798");
        rod.getBook().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher publisher = new Publisher("Austin Publishing", "123 Main St", "Austin", "Texas", "78681");
        ddd.setPublisher(publisher);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        publisher.getBooks().add(noEJB);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }

}
