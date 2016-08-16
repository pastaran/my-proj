package net.company.my.bean;

import java.io.Serializable;

/**
 *
 * @author Kostya
 */
public abstract class Entity implements Serializable {

    private int id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
