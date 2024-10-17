/**
 * Este paquete contiene las clases relacionadas con la vista de la aplicación.
 * Las clases en este paquete son responsables de la presentación de la interfaz
 * de usuario y la interacción con el usuario.
 */
package View;

import java.util.Scanner;

import Controller.SitesController;
import Model.Sites;

public class SitesView {
    Scanner scanner = new Scanner(System.in);

    /**
     * Este método permite seleccionar un sitio a través de la entrada del usuario.
     * Solicita al usuario que ingrese el número de sitio y utiliza el controlador
     * de sitios
     * para obtener el sitio correspondiente. Si el sitio no es válido (es decir, si
     * es null),
     * seguirá solicitando al usuario que ingrese un número de sitio válido.
     *
     * @return El sitio seleccionado por el usuario.
     */
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
