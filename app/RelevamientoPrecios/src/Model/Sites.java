
/**
 * La clase Sites representa un sitio con un identificador, un número y una
 * descripción.
 * 
 * Esta clase proporciona métodos para obtener y establecer los valores de sus
 * atributos,
 * así como métodos para construir objetos Sites de manera fluida.
 * 
 * Además, sobrescribe los métodos equals y toString para comparar objetos Sites
 * y
 * representar sus valores como una cadena, respectivamente.
 * 

 * 
 * Atributos:
 * 
 * id: Identificador único del sitio.
 * number: Número asociado al sitio.
 * descrption: Descripción del sitio.
 * 
 * 
 * Métodos:
 * 
 * getId(): Obtiene el identificador del sitio.
 * setId(int): Establece el identificador del sitio.
 * getNumber(): Obtiene el número del sitio.
 * setNumber(String): Establece el número del sitio.
 * getDescrption(): Obtiene la descripción del sitio.
 * setDescrption(String): Establece la descripción del sitio.
 * id(int): Método fluido para establecer el identificador del sitio.
 * number(String): Método fluido para establecer el número del sitio.
 * descrption(String): Método fluido para establecer la descripción del sitio.
 * equals(Object): Compara este objeto con otro para determinar si son iguales.
 * toString(): Representa los valores del objeto como una cadena.
 * 
 */

package Model;

import java.util.Objects;

public class Sites {

    private int id;
    private String number;
    private String descrption;

    public Sites(int id, String number, String descrption) {
        this.id = id;
        this.number = number;
        this.descrption = descrption;
    }

    public Sites() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescrption() {
        return this.descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Sites id(int id) {
        setId(id);
        return this;
    }

    public Sites number(String number) {
        setNumber(number);
        return this;
    }

    public Sites descrption(String descrption) {
        setDescrption(descrption);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sites)) {
            return false;
        }
        Sites sites = (Sites) o;
        return id == sites.id && Objects.equals(number, sites.number) && Objects.equals(descrption, sites.descrption);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", number='" + getNumber() + "'" +
                ", descrption='" + getDescrption() + "'" +
                "}";
    }

}
