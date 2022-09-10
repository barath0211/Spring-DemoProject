package barath.springframework.spring5webapp.bootstrap;

import barath.springframework.spring5webapp.domain.Author;
import barath.springframework.spring5webapp.domain.Book;
import barath.springframework.spring5webapp.repositories.AuthorRepository;
import barath.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
private final AuthorRepository authorRepository;
private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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

authorRepository.save(uma);
bookRepository.save(ps);


System.out.println("Started in Bootstrap");
System.out.println("Number of Books : " + bookRepository.count());

    }

}
