package View;

import Model.Competitors;
import Model.Prices;
import Model.Sites;
import java.util.ArrayList;

public class SurveysView {

    public void newSurvey() {
        Sites site = null;
        Competitors competitor = null;
        ArrayList<Prices> prices = new ArrayList<Prices>();
        SitesView sv = new SitesView();
        site = sv.selectSite();
        if (site == null) {
            return;
        }
        CompetitorsView cv = new CompetitorsView();
        competitor = cv.selectCompetitor(site);
        if (competitor == null) {
            return;
        }
        PricesView pv = new PricesView();
        ArrayList<Prices> pricesList = pv.inputPrices(competitor);
        if (prices.size() == 0) {
            return;
        }

    }

}
