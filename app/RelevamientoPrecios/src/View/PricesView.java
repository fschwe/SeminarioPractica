
package View;

import Model.Articles;
import Model.Competitors;
import Model.Prices;
import Model.Users;
import Services.ArticlesServices;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.PricesController;

/**
 * Clase PricesView que maneja la interacción con el usuario para ingresar
 * precios.
 * 
 * Atributos:
 * - sc: Scanner para la entrada de datos del usuario.
 * - pricesList: Lista de precios ingresados.
 * 
 * Métodos:
 * 
 * - inputPrices(Competitors competitor, Users user): Método para ingresar
 * precios de artículos.
 * - Parámetros:
 * - competitor: El competidor para el cual se ingresan los precios.
 * - user: El usuario que ingresa los precios.
 * - Funcionalidad:
 * - Obtiene la lista de artículos asociados a las marcas del competidor.
 * - Itera sobre la lista de artículos y solicita al usuario ingresar el precio
 * para cada uno.
 * - Valida el precio ingresado y lo agrega a la lista de precios.
 * - Guarda la lista de precios ingresados.
 * - Muestra un mensaje indicando si el relevamiento se guardó correctamente o
 * si hubo un error.
 */
public class PricesView {
    Scanner sc = new Scanner(System.in);
    ArrayList<Prices> pricesList = new ArrayList<Prices>();

    /**
     * Método para ingresar precios de artículos.
     * 
     * @param competitor el competidor para el cual se ingresan los precios.
     * @param user       el usuario que ingresa los precios.
     */
    public void inputPrices(Competitors competitor, Users user) {
        ArticlesServices as = new ArticlesServices();
        ArrayList<Articles> articles = as.getBrandsArticle(competitor.getBrands_id());
        PricesController pc = new PricesController();
        for (int i = 0; i < articles.size(); i++) {
            Prices inputedPrice = null;
            while (inputedPrice == null) {
                double price = 0;
                try {
                    System.out.println(
                            "SKU: " + articles.get(i).getSku() + " - Descripcion: " + articles.get(i).getName());
                    System.out.println("Ingrese el precio del articulo:");
                    price = sc.nextDouble();
                    inputedPrice = new Prices();
                    inputedPrice.setArticles_id(articles.get(i).getId());
                    inputedPrice.setPrice(price);
                    inputedPrice = pc.validate(inputedPrice);
                } catch (Exception e) {
                    inputedPrice = null;
                    System.out.println("Por favor coloque un precio valido");
                }
                sc.nextLine();
            }
            pricesList.add(inputedPrice);
        }
        if (pc.save(pricesList, competitor, user)) {
            System.out.println("Relevamiento guardado correctamente");
        } else {
            System.out.println("Error al guardar el relevamiento");
        }
    }
}
