package Model;

import java.util.Objects;

/**
 * La clase Articles representa un artículo con un identificador único, nombre y
 * SKU.
 * Proporciona métodos para obtener y establecer estos valores, así como métodos
 * para comparar artículos y generar una representación en cadena del artículo.
 * 
 * 
 * Constructores:
 * 
 * Articles(int, String, String): Crea un artículo con un ID,
 * nombre y SKU.
 * Articles(String, String): Crea un artículo con un nombre y SKU,
 * sin ID.
 * 
 * 
 * 
 * Métodos:
 * 
 * getId(): Obtiene el ID del artículo.
 * setId(int): Establece el ID del artículo.
 * getName(): Obtiene el nombre del artículo.
 * setName(String): Establece el nombre del artículo.
 * getSku(): Obtiene el SKU del artículo.
 * setSku(String): Establece el SKU del artículo.
 * id(int): Establece el ID del artículo y devuelve la instancia
 * actual.
 * name(String): Establece el nombre del artículo y devuelve la
 * instancia actual.
 * sku(String): Establece el SKU del artículo y devuelve la
 * instancia actual.
 * equals(Object): Compara este artículo con otro objeto para
 * determinar si son iguales.
 * toString(): Devuelve una representación en cadena de este
 * artículo.
 * 
 */

public class Articles {
    private int id;
    private String name;
    private String sku;

    public Articles(int id, String name, String sku) {
        this.id = id;
        this.name = name;
        this.sku = sku;
    }

    public Articles(String name, String sku) {

        this.name = name;
        this.sku = sku;
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
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", sku='" + getSku() + "'" +
                "}";
    }

}
