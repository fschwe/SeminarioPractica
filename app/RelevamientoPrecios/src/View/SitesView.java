package View;

import java.util.Scanner;

import Controller.SitesController;
import Model.Sites;

public class SitesView {
    Scanner scanner = new Scanner(System.in);

    public Sites selectSite() {
        Sites site = null;
        while (site == null) {
            System.out.println("Ingrese el numero de sitio: (ingrese la sucursal 3)");
            String siteNumber = scanner.next();
            SitesController sitescontrller = new SitesController();
            site = sitescontrller.getSite(siteNumber);
        }
        return site;
    }
}
