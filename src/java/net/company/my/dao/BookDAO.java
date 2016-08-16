package net.company.my.dao;

import java.util.List;
import net.company.my.bean.Book;

/**
 *
 * @author Kostya
 */
public interface BookDAO {

    int addBook(Book book);

    List<Book> findAllBooks();

    Book findBookById(int id);

    void removeBookById(int id);

    void decrementBookById(int id);
    
    void incrementBookById(int id);
}
