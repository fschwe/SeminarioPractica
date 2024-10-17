/**
 * La clase Surveys representa una encuesta con información sobre competidores, usuarios y la fecha de creación.
 * 
 * Esta clase proporciona varios constructores para crear instancias de encuestas con diferentes niveles de detalle,
 * así como métodos para acceder y modificar sus propiedades.
 * 
 * Propiedades:
 * 
 *   id: Identificador único de la encuesta.
 *   competitors_id: Identificador del competidor asociado a la encuesta.
 *   users_id: Identificador del usuario que creó la encuesta.
 *   created_at: Fecha y hora de creación de la encuesta.
 * 
 * 
 * Métodos:
 * 
 *   getId(): Devuelve el identificador de la encuesta.
 *   setId(int id): Establece el identificador de la encuesta.
 *   getCompetitors_id(): Devuelve el identificador del competidor asociado a la encuesta.
 *   setCompetitors_id(int competitors_id): Establece el identificador del competidor asociado a la encuesta.
 *   getUsers_id(): Devuelve el identificador del usuario que creó la encuesta.
 *   setUsers_id(int users_id): Establece el identificador del usuario que creó la encuesta.
 *   getCreated_at(): Devuelve la fecha y hora de creación de la encuesta.
 *   setCreated_at(String created_at): Establece la fecha y hora de creación de la encuesta.
 *   id(int id): Método de conveniencia para establecer el identificador de la encuesta y devolver la instancia actual.
 *   competitors_id(int competitors_id): Método de conveniencia para establecer el identificador del competidor y devolver la instancia actual.
 *   users_id(int users_id): Método de conveniencia para establecer el identificador del usuario y devolver la instancia actual.
 *   equals(Object o): Compara esta encuesta con otro objeto para determinar si son iguales.
 *   toString(): Devuelve una representación en cadena de esta encuesta.
 * 
 * 
 * Constructores:
 * 
 *   Surveys(int id, int competitors_id, int users_id, String created_at): Crea una nueva encuesta con los valores especificados.
 *   Surveys(int competitors_id, int users_id): Crea una nueva encuesta con los valores especificados y establece la fecha de creación a la fecha y hora actual.
 *   Surveys(): Constructor por defecto.
 * 
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Surveys {

    private int id;
    private int competitors_id;
    private int users_id;
    private String created_at;

    public Surveys(int id, int competitors_id, int users_id, String created_at) {
        this.id = id;
        this.competitors_id = competitors_id;
        this.users_id = users_id;
        this.created_at = created_at;
    }

    public Surveys(int competitors_id, int users_id) {
        this.competitors_id = competitors_id;
        this.users_id = users_id;
        this.created_at = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public Surveys() {
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompetitors_id() {
        return this.competitors_id;
    }

    public void setCompetitors_id(int competitors_id) {
        this.competitors_id = competitors_id;
    }

    public int getUsers_id() {
        return this.users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public Surveys id(int id) {
        setId(id);
        return this;
    }

    public Surveys competitors_id(int competitors_id) {
        setCompetitors_id(competitors_id);
        return this;
    }

    public Surveys users_id(int users_id) {
        setUsers_id(users_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Surveys)) {
            return false;
        }
        Surveys surveys = (Surveys) o;
        return id == surveys.id && competitors_id == surveys.competitors_id && users_id == surveys.users_id;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", competitors_id='" + getCompetitors_id() + "'" +
                ", users_id='" + getUsers_id() + "'" +
                "}";
    }

}
