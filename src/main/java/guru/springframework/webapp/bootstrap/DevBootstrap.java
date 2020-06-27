package guru.springframework.webapp.bootstrap;

import guru.springframework.webapp.model.Author;
import guru.springframework.webapp.model.Book;
import guru.springframework.webapp.model.Publisher;
import guru.springframework.webapp.repository.AuthorRepository;
import guru.springframework.webapp.repository.BookRepository;
import guru.springframework.webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author a = new Author("lopes", "pedro");
        Publisher p = new Publisher("kata");
        Book b = new Book("DDD", "2398203", p);
        a.getBooks().add(b);
        b.getAuthors().add(a);

        authorRepository.save(a);
        publisherRepository.save(p);
        bookRepository.save(b);
    }
}
