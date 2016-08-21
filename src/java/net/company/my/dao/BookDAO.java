package net.company.my.dao;

import java.util.List;
import net.company.my.bean.Author;
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

    void updateBook(int id, String title, int authorId, int year, int qtyTotal,
            int qtyAvailable);
    
    boolean checkBookIfAvailable(int id);
}
