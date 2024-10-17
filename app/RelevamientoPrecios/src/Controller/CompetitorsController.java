/**
 * Controlador para gestionar las operaciones relacionadas con los competidores.
 * 
 * Este controlador proporciona métodos para obtener información sobre los competidores,
 * ya sea de manera individual por su ID o en forma de lista para un sitio específico.
 * 
 */
package Controller;

import Model.Sites;
import Model.Competitors;
import Services.CompetitorsServices;
import java.util.ArrayList;

public class CompetitorsController {
    /**
     * Obtiene un competidor basado en su ID.
     *
     * @param competitorId El ID del competidor que se desea obtener.
     * @return Un objeto Competitors que representa al competidor con el ID
     *         especificado.
     */
    public Competitors getCompetitor(int competitorId) {
        CompetitorsServices services = new CompetitorsServices();
        return services.getCompetitor(competitorId);
    }

    /**
     * Obtiene la lista de competidores para un sitio específico.
     *
     * @param site El sitio para el cual se desea obtener la lista de competidores.
     * @return Una lista de objetos Competitors que representan los competidores del
     *         sitio especificado.
     */
    public ArrayList<Competitors> getCompetitorList(Sites site) {
        CompetitorsServices services = new CompetitorsServices();
        return services.getCompetitorList(site.getNumber());
    }
}
