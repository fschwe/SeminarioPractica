package Model;

import java.util.Objects;

public class Prices {
    private int id;
    private int articles_id;
    private int competitors_id;
    private double price;

    public Prices(int id, int articles_id, int competitors_id, double price) {
        this.id = id;
        this.articles_id = articles_id;
        this.competitors_id = competitors_id;
        this.price = price;

    }

    public Prices() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticles_id() {
        return this.articles_id;
    }

    public void setArticles_id(int articles_id) {
        this.articles_id = articles_id;
    }

    public int getCompetitors_id() {
        return this.competitors_id;
    }

    public void setCompetitors_id(int competitors_id) {
        this.competitors_id = competitors_id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Prices id(int id) {
        setId(id);
        return this;
    }

    public Prices articles_id(int articles_id) {
        setArticles_id(articles_id);
        return this;
    }

    public Prices competitors_id(int competitors_id) {
        setCompetitors_id(competitors_id);
        return this;
    }

    public Prices price(double price) {
        setPrice(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Prices)) {
            return false;
        }
        Prices prices = (Prices) o;
        return id == prices.id && articles_id == prices.articles_id && competitors_id == prices.competitors_id
                && price == prices.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articles_id, competitors_id, price);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", articles_id='" + getArticles_id() + "'" +
                ", competitors_id='" + getCompetitors_id() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

}
