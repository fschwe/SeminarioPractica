package View;

import Model.Competitors;
import Model.Sites;
import Model.Users;

public class SurveysView {

    public void newSurvey(Users user) {
        Sites site = null;
        Competitors competitor = null;
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
        pv.inputPrices(competitor, user);
    }
}
