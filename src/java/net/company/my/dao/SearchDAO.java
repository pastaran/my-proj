package net.company.my.dao;

import java.util.List;
import net.company.my.bean.Author;
import net.company.my.bean.Book;

/**
 *
 * @author Kostya
 */
public interface SearchDAO {

    List<Book> findBooksByTitle(String title);
}
