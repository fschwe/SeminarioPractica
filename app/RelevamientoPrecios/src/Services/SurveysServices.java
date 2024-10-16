package Services;

import java.sql.Connection;
import java.util.ArrayList;

import Model.Surveys;

public class SurveysServices extends Conexion {

    private Connection con = getConnection();

    public ArrayList<Surveys> showSurveys() {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM surveys;");
            ArrayList<Surveys> surveys = new ArrayList<Surveys>();
            while (rs.next()) {
                surveys.add(
                        new Surveys(
                                rs.getInt("id"),
                                rs.getInt("competitors_id"),
                                rs.getInt("user_id"),
                                rs.getString("created_at")));
            }
            rs.close();
            stmt.close();
            con.close();
            return surveys;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    public void createSurvey(Surveys s) {
        {
            try {

                pstmt = con.prepareStatement(
                        "INSERT INTO surveys (competitors_id, user_id, created_at ) VALUES (?,?,?);");
                pstmt.setInt(1, s.getCompetitors_id());
                pstmt.setInt(2, s.getUsers_id());
                pstmt.setString(3, s.getCreated_at());
                pstmt.executeUpdate();
                System.out.println("Relevamiento creada correctamente");
                pstmt.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
    }

    public void updateSurvey(Surveys s) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE surveys SET competitors_id=?, surveys_id=?, created_at=? WHERE id=?;");
            pstmt.setInt(1, s.getCompetitors_id());
            pstmt.setInt(2, s.getUsers_id());
            pstmt.setString(3, s.getCreated_at());
            pstmt.setInt(4, s.getId());
            pstmt.executeUpdate();
            System.out.println("Relevamiento modificada correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void deleteSurvey(Surveys s) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM surveys WHERE id=?;");
            pstmt.setInt(1, s.getId());
            pstmt.executeUpdate();
            System.out.println("Relevamiento eliminada correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
