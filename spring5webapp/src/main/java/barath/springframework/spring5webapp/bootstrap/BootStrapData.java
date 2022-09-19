package barath.springframework.spring5webapp.bootstrap;

import barath.springframework.spring5webapp.domain.Author;
import barath.springframework.spring5webapp.domain.Book;
import barath.springframework.spring5webapp.domain.Publisher;
import barath.springframework.spring5webapp.repositories.AuthorRepository;
import barath.springframework.spring5webapp.repositories.BookRepository;
import barath.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
private final AuthorRepository authorRepository;
private final BookRepository bookRepository;
private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,  PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Scholastic Publishing");
        publisher.setCity("Coimbatore");
        publisher.setState("Bk");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());


Author barath = new Author("Barath","Kumaar");
Book psm = new Book("Power Of Subconscious Mind","1234");
barath.getBooks().add(psm);
psm.getAuthors().add(barath);

authorRepository.save(barath);
bookRepository.save(psm);

Author uma = new Author("Uma" , "Kumar");
Book ps = new Book ("Ponniyin Selvan" , "1977");
uma.getBooks().add(ps);
ps.getAuthors().add(uma);

ps.setPublisher(publisher);
publisher.getBooks().add(ps);

authorRepository.save(uma);
bookRepository.save(ps);
publisherRepository.save(publisher);

System.out.println("Started in Bootstrap");
System.out.println("Number of Books : " + bookRepository.count());
        System.out.println("Publisher Number of Books : " + publisher.getBooks().size());
    }

}
