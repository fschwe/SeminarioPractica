package Model;

import java.util.Objects;

public class BrandHasArticle {

    private int id;
    private int brands_id;
    private int articles_id;

    public BrandHasArticle(int id, int brands_id, int articles_id) {
        this.id = id;
        this.brands_id = brands_id;
        this.articles_id = articles_id;
    }

    public BrandHasArticle() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrands_id() {
        return this.brands_id;
    }

    public void setBrands_id(int brands_id) {
        this.brands_id = brands_id;
    }

    public int getArticles_id() {
        return this.articles_id;
    }

    public void setArticles_id(int articles_id) {
        this.articles_id = articles_id;
    }

    public BrandHasArticle id(int id) {
        setId(id);
        return this;
    }

    public BrandHasArticle brands_id(int brands_id) {
        setBrands_id(brands_id);
        return this;
    }

    public BrandHasArticle articles_id(int articles_id) {
        setArticles_id(articles_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BrandHasArticle)) {
            return false;
        }
        BrandHasArticle brandHasArticle = (BrandHasArticle) o;
        return id == brandHasArticle.id && brands_id == brandHasArticle.brands_id
                && articles_id == brandHasArticle.articles_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brands_id, articles_id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", brands_id='" + getBrands_id() + "'" +
                ", articles_id='" + getArticles_id() + "'" +
                "}";
    }

}
