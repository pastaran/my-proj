package net.company.my.bean;

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
}
