/**
 * La clase Prices representa un precio asociado a un artículo y una encuesta.
 * 
 * Esta clase contiene los siguientes atributos:
 * 
 *   id: Identificador único del precio.
 *   articles_id: Identificador del artículo asociado.
 *   surveys_id: Identificador de la encuesta asociada.
 *   price: Valor del precio.
 * 
 * 
 * La clase proporciona constructores para inicializar los atributos, así como
 * métodos getter y setter para acceder y modificar los valores de los atributos.
 * También incluye métodos para establecer los valores de los atributos de manera
 * encadenada, y métodos sobrescritos de equals y toString.
 * 
 */
package Model;

public class Prices {
    private int id;
    private int articles_id;
    private int surveys_id;
    private double price;

    public Prices(int id, int articles_id, int surveys_id, double price) {
        this.id = id;
        this.articles_id = articles_id;
        this.surveys_id = surveys_id;
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

    public int getSurveys_id() {
        return this.surveys_id;
    }

    public void setSurveys_id(int surveys_id) {
        this.surveys_id = surveys_id;
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

    public Prices surveys_id(int surveys_id) {
        setSurveys_id(surveys_id);
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
        return id == prices.id && articles_id == prices.articles_id && surveys_id == prices.surveys_id
                && price == prices.price;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", articles_id='" + getArticles_id() + "'" +
                ", user_id='" + getSurveys_id() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

}
