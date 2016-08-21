package net.company.my.bean;

import java.util.Objects;

/**
 *
 * @author Kostya
 */
public class Author extends Entity {

    private String name;

    public Author() {
    }

    public Author(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + getId() + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Author author = (Author) o;

        return name.equals(author.name);
    }
}
