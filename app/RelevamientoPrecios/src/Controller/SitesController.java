package Controller;

import Model.Sites;
import Services.SitesServices;

/**
 * La clase SitesController se encarga de manejar las operaciones relacionadas
 * con los sitios.
 */
public class SitesController {
    Sites sites = null;

    /**
     * Obtiene un sitio basado en el número de sitio proporcionado.
     *
     * @param siteNumber El número del sitio que se desea obtener.
     * @return Un objeto de tipo Sites que representa el sitio obtenido.
     */
    public Sites getSite(String siteNumber) {
        SitesServices services = new SitesServices();
        sites = services.getSite(siteNumber);
        return sites;
    }

}
