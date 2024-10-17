package Controller;

import Model.Articles;
import Services.ArticlesServices;

public class ArticlesController {

    protected ArticlesServices as = new ArticlesServices();

    private ArticlesController() {

    }

    public void newArticle(String name, String sku) {
        if (name != null && sku != null) {
            Articles article = new Articles(name, sku);
            as.createArticle(article);
        }
    }

}
