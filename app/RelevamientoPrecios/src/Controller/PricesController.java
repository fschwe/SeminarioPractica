package Controller;

import Model.Competitors;
import Model.Prices;
import Model.Surveys;
import Model.Users;
import Services.PricesServices;
import Services.SurveysServices;

import java.util.ArrayList;

/**
 * Controlador para la gestión de precios.
 */
public class PricesController {

    /**
     * Servicio de precios utilizado para realizar operaciones relacionadas con los
     * precios.
     */
    private PricesServices ps = new PricesServices();

    /**
     * Valida un objeto Prices.
     *
     * @param p El objeto Prices a validar.
     * @return El objeto Prices si es válido, de lo contrario, null.
     */
    public Prices validate(Prices p) {
        if (p.getPrice() < 0) {
            return null;
        }
        return p;
    }

    /**
     * Guarda una lista de precios asociados a un competidor y un usuario.
     *
     * @param p Lista de objetos Prices a guardar.
     * @param c Objeto Competitors asociado.
     * @param u Objeto Users asociado.
     * @return true si los precios se guardan correctamente, de lo contrario, false.
     */
    public boolean save(ArrayList<Prices> p, Competitors c, Users u) {
        try {
            SurveysServices ss = new SurveysServices();
            Surveys survey = new Surveys(c.getId(), u.getId());
            survey = ss.createSurvey(survey);
            for (int i = 0; i < p.size(); i++) {
                p.get(i).setSurveys_id(survey.getId());
                ps.createPrice(p.get(i));
                ps = new PricesServices();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
