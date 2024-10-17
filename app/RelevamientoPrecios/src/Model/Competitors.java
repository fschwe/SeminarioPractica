/**
 * La clase Competitors representa un competidor con atributos como id, sites_id, brands_id, nombre, dirección, latitud y longitud.
 * 
 * Proporciona constructores para crear instancias de Competitors, así como métodos getter y setter para acceder y modificar sus atributos.
 * También incluye métodos para establecer los atributos de manera encadenada, y métodos sobrescritos equals, hashCode y toString.
 * 
 * Métodos:
 * 
 *   getId() - Obtiene el id del competidor.
 *   setId(int) - Establece el id del competidor.
 *   getSites_id() - Obtiene el id del sitio.
 *   setSites_id(int) - Establece el id del sitio.
 *   getBrands_id() - Obtiene el id de la marca.
 *   setBrands_id(int) - Establece el id de la marca.
 *   getName() - Obtiene el nombre del competidor.
 *   setName(String) - Establece el nombre del competidor.
 *   getAddress() - Obtiene la dirección del competidor.
 *   setAddress(String) - Establece la dirección del competidor.
 *   getLatitude() - Obtiene la latitud del competidor.
 *   setLatitude(String) - Establece la latitud del competidor.
 *   getLongitude() - Obtiene la longitud del competidor.
 *   setLongitude(String) - Establece la longitud del competidor.
 *   equals(Object) - Compara este competidor con otro objeto.
 *   toString() - Devuelve una representación en cadena de este competidor.
 * 
 * 
 * Constructores:
 * 
 *   Competitors(int, int, int, String, String, String, String) - Constructor con parámetros para inicializar todos los atributos.
 *   Competitors() - Constructor por defecto.
 * 
 * 
 * Métodos encadenados:
 * 
 *   id(int) - Establece el id del competidor y devuelve la instancia actual.
 *   sites_id(int) - Establece el id del sitio y devuelve la instancia actual.
 *   brands_id(int) - Establece el id de la marca y devuelve la instancia actual.
 *   name(String) - Establece el nombre del competidor y devuelve la instancia actual.
 *   address(String) - Establece la dirección del competidor y devuelve la instancia actual.
 *   latitude(String) - Establece la latitud del competidor y devuelve la instancia actual.
 *   longitude(String) - Establece la longitud del competidor y devuelve la instancia actual.
 * 
 */
package Model;

import java.util.Objects;

public class Competitors {

    private int id;
    private int sites_id;
    private int brands_id;
    private String name;
    private String address;
    private String latitude;
    private String longitude;

    public Competitors(int id, int sites_id, int brands_id, String name, String address, String latitude,
            String longitude) {
        this.id = id;
        this.sites_id = sites_id;
        this.brands_id = brands_id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Competitors() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSites_id() {
        return this.sites_id;
    }

    public void setSites_id(int sites_id) {
        this.sites_id = sites_id;
    }

    public int getBrands_id() {
        return this.brands_id;
    }

    public void setBrands_id(int brands_id) {
        this.brands_id = brands_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Competitors id(int id) {
        setId(id);
        return this;
    }

    public Competitors sites_id(int sites_id) {
        setSites_id(sites_id);
        return this;
    }

    public Competitors brands_id(int brands_id) {
        setBrands_id(brands_id);
        return this;
    }

    public Competitors name(String name) {
        setName(name);
        return this;
    }

    public Competitors address(String address) {
        setAddress(address);
        return this;
    }

    public Competitors latitude(String latitude) {
        setLatitude(latitude);
        return this;
    }

    public Competitors longitude(String longitude) {
        setLongitude(longitude);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Competitors)) {
            return false;
        }
        Competitors competitors = (Competitors) o;
        return id == competitors.id && sites_id == competitors.sites_id && brands_id == competitors.brands_id
                && Objects.equals(name, competitors.name) && Objects.equals(address, competitors.address)
                && Objects.equals(latitude, competitors.latitude) && Objects.equals(longitude, competitors.longitude);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", sites_id='" + getSites_id() + "'" +
                ", brands_id='" + getBrands_id() + "'" +
                ", name='" + getName() + "'" +
                ", address='" + getAddress() + "'" +
                ", latitude='" + getLatitude() + "'" +
                ", longitude='" + getLongitude() + "'" +
                "}";
    }

}
