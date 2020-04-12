package tech.donau;

import tech.donau.data.Book;
import tech.donau.data.repository.BookRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(Transactional.TxType.NEVER)
    public List<Book> hello() {
        return Book.listAll();
//        Book.update("name = 'Bob' where name = ?1", "Sara");

//        final Stream<Book> panacheEntityBaseStream = Book.streamAll();
//        final List<Book> sara = panacheEntityBaseStream.filter(it -> it.name.equals("Sara")).collect(Collectors.toList());
//
//        final PanacheQuery<Book> query = Book.find("author", "Sara");
//        query.page(Page.of(2, 50));
//        final List<Book> list = query.list();
//        query.nextPage();
//        query.pageCount();
//
//        Book.listAll(Sort.by("name").and("author"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Book saveBook(Book book) {
        book.persist();
        return book;
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Book updateBook(@PathParam("id") Integer id, Book book) {
        System.out.println("LOG2");
//        manager.merge(book);
        return book;
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public boolean deleteBook(@PathParam("id") Integer id) {
        bookRepository.delete("id", id);
        return true;
    }
}