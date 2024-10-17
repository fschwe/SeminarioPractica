/**
 * La clase Brands representa una marca con un identificador, nombre y tipo.
 * 
 * Proporciona métodos para obtener y establecer estos atributos, así como
 * métodos para comparar instancias de Brands y generar una representación en
 * cadena de la instancia.
 * 
 * Constructores:
 * 
 *   Brands(int, String, String): Inicializa una nueva instancia de Brands con los valores especificados.
 *   Brands(): Constructor por defecto.
 * 
 * 
 * Métodos:
 * 
 *   getId(): Obtiene el identificador de la marca.
 *   setId(int): Establece el identificador de la marca.
 *   getName(): Obtiene el nombre de la marca.
 *   setName(String): Establece el nombre de la marca.
 *   getType(): Obtiene el tipo de la marca.
 *   setType(String): Establece el tipo de la marca.
 *   id(int): Método fluido para establecer el identificador de la marca.
 *   name(String): Método fluido para establecer el nombre de la marca.
 *   type(String): Método fluido para establecer el tipo de la marca.
 *   equals(Object): Compara esta instancia con otra para determinar si son iguales.
 *   toString(): Devuelve una representación en cadena de esta instancia.
 */
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
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", type='" + getType() + "'" +
                "}";
    }

}
