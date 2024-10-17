package View;

import java.util.Scanner;

import Controller.CompetitorsController;
import Controller.SitesController;
import Model.Competitors;
import Model.Sites;
import java.util.ArrayList;

public class CompetitorsView {
    Scanner scanner = new Scanner(System.in);

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
