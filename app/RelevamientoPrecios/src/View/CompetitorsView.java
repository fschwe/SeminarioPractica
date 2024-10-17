
/**
 * La clase CompetitorsView proporciona una interfaz para seleccionar un competidor
 * de una lista de competidores asociados a un sitio específico.
 * 
 * Métodos:
 * - selectCompetitor(Sites site): Permite al usuario seleccionar un competidor
 *   de una lista de competidores asociados al sitio proporcionado.
 * 
 * Atributos:
 * - scanner: Objeto Scanner para leer la entrada del usuario.
 * 
 * selectCompetitor(Sites site):
 * - Parámetros:
 *   - site: Objeto de la clase Sites que representa el sitio del cual se
 *     obtendrán los competidores.
 * - Retorno:
 *   - Competitors: Objeto de la clase Competitors que representa el competidor
 *     seleccionado por el usuario.
 * - Descripción:
 *   - Este método obtiene una lista de competidores asociados al sitio
 *     proporcionado utilizando el CompetitorsController. Luego, muestra la lista
 *     de competidores y solicita al usuario que ingrese el ID del competidor que
 *     desea seleccionar. Si el ID ingresado es válido, se retorna el objeto
 *     Competitors correspondiente. En caso de error, se muestra un mensaje de
 *     error y se solicita nuevamente el ID.
 */
package View;

import java.util.Scanner;

import Controller.CompetitorsController;
import Model.Competitors;
import Model.Sites;
import java.util.ArrayList;

public class CompetitorsView {
    Scanner scanner = new Scanner(System.in);

    /**
     * Selecciona un competidor basado en el sitio proporcionado.
     *
     * @param site El sitio del cual se obtendrán los competidores.
     * @return El competidor seleccionado.
     * 
     *         Este método obtiene una lista de competidores del controlador de
     *         competidores
     *         y los muestra en la consola con sus respectivos IDs y nombres. Luego,
     *         solicita
     *         al usuario que ingrese el ID del competidor que desea seleccionar. Si
     *         el ID es
     *         válido, se devuelve el competidor correspondiente; de lo contrario,
     *         se muestra
     *         un mensaje de error y se solicita nuevamente el ID.
     * 
     * @throws Exception Si ocurre un error al obtener el competidor por ID.
     */
    public Competitors selectCompetitor(Sites site) {
        Competitors competitor = null;
        ArrayList<Competitors> competitorsList = new ArrayList<Competitors>();
        CompetitorsController competitorsController = new CompetitorsController();
        competitorsList = competitorsController.getCompetitorList(site);
        for (int i = 0; i < competitorsList.size(); i++) {
            System.out.println(
                    "ID: " + competitorsList.get(i).getId() + " - Nombre: " + competitorsList.get(i).getName());
        }
        while (competitor == null) {
            System.out.println("Ingrese el id del competidor:");
            try {
                int competitorId = scanner.nextInt();
                competitor = competitorsController.getCompetitor(competitorId);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return competitor;
    }
}
