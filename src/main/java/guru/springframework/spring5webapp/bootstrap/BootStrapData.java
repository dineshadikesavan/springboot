package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain driven design", "123456");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        Publisher publisher = new Publisher();
        publisher.setAddressLine("8200 Warbler Wy");
        publisher.setCity("Brentwood");
        publisher.setState("TN");
        publisher.setZipcode("37027");

        publisher.getBooks().add(book1);
        authorRepository.save(eric);
        bookRepository.save(book1);

        Author dinesh = new Author("Dinesh", "Adikesavan");
        Book book2 = new Book("WCS", "2345678");
        dinesh.getBooks().add(book2);
        book2.getAuthors().add(dinesh);
        publisher.getBooks().add(book2);
        authorRepository.save(dinesh);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Started in bootstrap");
        System.out.println("Started in bootstrap -- Books count ::: "+bookRepository.count());
        System.out.println("Started in bootstrap -- Authors count ::: "+authorRepository.count());
        System.out.println("Started in bootstrap -- Publishers count ::: "+publisherRepository.count());
    }
}
