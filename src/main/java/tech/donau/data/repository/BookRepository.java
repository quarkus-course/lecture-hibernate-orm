package tech.donau.data.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import tech.donau.data.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BookRepository implements PanacheRepositoryBase<Book, Integer> {

    public List<Book> findAllBooks() {
        return findAll().list();
    }

    public List<Book> findBooksByName(String name) {
        return find("name", name).list();
    }

}
