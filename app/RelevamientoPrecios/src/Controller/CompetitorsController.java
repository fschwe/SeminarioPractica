package Controller;

import Model.Sites;
import Model.Competitors;
import Services.CompetitorsServices;
import java.util.ArrayList;

public class CompetitorsController {
    public Competitors getCompetitor(int competitorId) {
        CompetitorsServices services = new CompetitorsServices();
        return services.getCompetitor(competitorId);
    }

    public ArrayList<Competitors> getCompetitorList(Sites site) {
        CompetitorsServices services = new CompetitorsServices();
        return services.getCompetitorList(site.getNumber());
    }
}
