package Model;

import java.util.Objects;

public class Articles {
    private int id;
    private String name;
    private String sku;

    public Articles(int id, String name, String sku) {
        this.id = id;
        this.name = name;
        this.sku = sku;
    }

    public Articles() {
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

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Articles id(int id) {
        setId(id);
        return this;
    }

    public Articles name(String name) {
        setName(name);
        return this;
    }

    public Articles sku(String sku) {
        setSku(sku);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Articles)) {
            return false;
        }
        Articles articles = (Articles) o;
        return id == articles.id && Objects.equals(name, articles.name) && Objects.equals(sku, articles.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sku);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", sku='" + getSku() + "'" +
                "}";
    }

}
