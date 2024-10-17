package Model;

/**
 * La clase BrandHasArticle representa la relación entre una marca y un
 * artículo.
 * Contiene identificadores para la relación, la marca y el artículo.
 * 
 * Esta clase proporciona métodos para obtener y establecer los valores de los
 * identificadores, así como métodos para comparar instancias y generar una
 * representación en cadena de la instancia.
 * 
 * Constructores:
 * 
 * BrandHasArticle(int, int, int): Inicializa una nueva instancia con los
 * valores especificados.
 * BrandHasArticle(): Inicializa una nueva instancia con valores por defecto.
 * 
 * 
 * Métodos:
 * 
 * getId(): Obtiene el identificador de la relación.
 * setId(int): Establece el identificador de la relación.
 * getBrands_id(): Obtiene el identificador de la marca.
 * setBrands_id(int): Establece el identificador de la marca.
 * getArticles_id(): Obtiene el identificador del artículo.
 * setArticles_id(int): Establece el identificador del artículo.
 * id(int): Establece el identificador de la relación y devuelve la instancia
 * actual.
 * brands_id(int): Establece el identificador de la marca y devuelve la
 * instancia actual.
 * articles_id(int): Establece el identificador del artículo y devuelve la
 * instancia actual.
 * equals(Object): Compara esta instancia con otra para determinar si son
 * iguales.
 * toString(): Devuelve una representación en cadena de esta instancia.
 * 
 *
 * 
 */
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
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", brands_id='" + getBrands_id() + "'" +
                ", articles_id='" + getArticles_id() + "'" +
                "}";
    }

}
