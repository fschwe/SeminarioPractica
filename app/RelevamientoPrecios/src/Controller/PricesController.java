package Controller;

import Model.Competitors;
import Model.Prices;
import Model.Surveys;
import Model.Users;
import Services.PricesServices;
import Services.SurveysServices;

import java.util.ArrayList;

public class PricesController {
    private PricesServices ps = new PricesServices();

    public Prices validate(Prices p) {
        if (p.getPrice() < 0) {
            return null;
        }
        return p;
    }

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
