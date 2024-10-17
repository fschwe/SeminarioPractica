package Controller;

import Model.Sites;
import Services.SitesServices;

public class SitesController {
    Sites sites = null;

    public Sites getSite(String siteNumber) {
        SitesServices services = new SitesServices();
        sites = services.getSite(siteNumber);
        return sites;
    }

}
