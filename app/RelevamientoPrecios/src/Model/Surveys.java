package Model;

import java.util.Objects;

public class Surveys {

    private int id;
    private int competitors_id;
    private int users_id;

    public Surveys(int id, int competitors_id, int users_id) {
        this.id = id;
        this.competitors_id = competitors_id;
        this.users_id = users_id;
    }

    public Surveys() {
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
    public int hashCode() {
        return Objects.hash(id, competitors_id, users_id);
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
