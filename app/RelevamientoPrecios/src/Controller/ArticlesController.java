package Controller;

import Model.Articles;
import Services.ArticlesServices;

/**
 * Controlador para gestionar las operaciones relacionadas con los artículos.
 */
public class ArticlesController {

    /**
     * Servicio para manejar las operaciones de los artículos.
     */
    protected ArticlesServices as = new ArticlesServices();

    /**
     * Constructor privado para evitar la instanciación directa de la clase.
     */
    private ArticlesController() {

    }

    /**
     * Crea un nuevo artículo con el nombre y SKU proporcionados.
     *
     * @param name El nombre del artículo.
     * @param sku  El SKU del artículo.
     */
    public void newArticle(String name, String sku) {
        if (name != null && sku != null) {
            Articles article = new Articles(name, sku);
            as.createArticle(article);
        }
    }

}
