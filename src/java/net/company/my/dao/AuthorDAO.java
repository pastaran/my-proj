package net.company.my.dao;

import java.util.List;
import net.company.my.bean.Author;

/**
 *
 * @author Kostya
 */
public interface AuthorDAO {

    int addAuthor(Author author);

    List<Author> findAllAuthors();

    Author findAuthorById(int id);

    Author findAuthorByName(String name);

    void updateAuthor(int id, String name);
    
    void removeAuthorById(int id);
}
