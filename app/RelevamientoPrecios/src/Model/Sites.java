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
    public int hashCode() {
        return Objects.hash(id, number, descrption);
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
