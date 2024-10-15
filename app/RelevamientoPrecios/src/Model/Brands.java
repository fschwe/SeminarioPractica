package Model;

import java.util.Objects;

public class Brands {

    private int id;
    private String name;
    private String type;

    public Brands(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Brands() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Brands id(int id) {
        setId(id);
        return this;
    }

    public Brands name(String name) {
        setName(name);
        return this;
    }

    public Brands type(String type) {
        setType(type);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Brands)) {
            return false;
        }
        Brands brands = (Brands) o;
        return id == brands.id && Objects.equals(name, brands.name) && Objects.equals(type, brands.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", type='" + getType() + "'" +
                "}";
    }

}
