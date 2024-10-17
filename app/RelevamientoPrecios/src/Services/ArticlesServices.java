package Services;

import java.sql.Connection;
import java.util.ArrayList;

import Model.Articles;
import Model.Brands;

public class ArticlesServices extends Conexion {

    private Connection con = getConnection();

    public ArrayList<Articles> showArticles() {
        try {
            stmt = this.con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM articles;");
            ArrayList<Articles> articles = new ArrayList<Articles>();
            while (rs.next()) {
                articles.add(
                        new Articles(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("sku")));
            }
            rs.close();
            stmt.close();
            con.close();
            return articles;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    public void createArticle(Articles a) {
        {
            try {

                pstmt = con.prepareStatement(
                        "INSERT INTO articles (sku, name) VALUES (?,?);");
                pstmt.setString(1, a.getName());
                pstmt.setString(2, a.getSku());
                pstmt.executeUpdate();
                System.out.println("Articulo creado correctamente");
                pstmt.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
    }

    public void updateArticle(Articles a) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE articles SET name = ?, sku = ? WHERE id=?;");
            pstmt.setString(1, a.getName());
            pstmt.setString(2, a.getSku());
            pstmt.setInt(3, a.getId());
            pstmt.executeUpdate();
            System.out.println("Modificado correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void deleteArticle(Articles a) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM articles WHERE id=?;");
            pstmt.setInt(1, a.getId());
            pstmt.executeUpdate();
            System.out.println("Articulo eliminado correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public ArrayList<Articles> getBrandsArticle(int brand_id) {
        try {

            pstmt = con.prepareStatement(
                    "SELECT  * FROM articles a LEFT JOIN brand_has_articles ba ON a.id=ba.articles_id WHERE ba.brands_id = ?;");
            pstmt.setInt(1, brand_id);
            rs = pstmt.executeQuery();
            ArrayList<Articles> articles = new ArrayList<Articles>();
            while (rs.next()) {
                articles.add(
                        new Articles(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("sku")));
            }
            rs.close();
            pstmt.close();
            con.close();
            return articles;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

}
