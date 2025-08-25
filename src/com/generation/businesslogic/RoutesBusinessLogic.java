package com.generation.businesslogic;

import java.time.LocalTime;

import com.generation.entities.Route;
import com.generation.library.ConsoleV2;
import com.generation.repositories.RepositoryRouteCsv;

public class RoutesBusinessLogic {
    private RepositoryRouteCsv repo;

    public RoutesBusinessLogic() {
        repo = new RepositoryRouteCsv("routes.csv");
    }

    public void printAll() {
        System.out.println("Ecco le tue routes");

        for (Route r : repo.read()) {
            System.out.println(r);
        }
    }

    public void createNewRoutes() {
        Route route = new Route();
        // departureStation,arrivalStation,departureTime,arrivingTime,distance,basePrice,trainType,tier

        route.setArrivalStation(ConsoleV2.askAndReadString("Inserire la stazione di partenza:"));
        route.setDepartureStation(ConsoleV2.askAndReadString("Inserire la stazione di destinazione:"));
        route.setDepartureTime(LocalTime.parse(ConsoleV2.askAndReadString("Inserire l'orario di partenza:")));
        route.setArrivingTime(LocalTime.parse(ConsoleV2.askAndReadString("Inserire l'orario di arrivo:")));
        route.setDistance(ConsoleV2.askAndReadUInt("Inserire la distanza del viaggio:"));
        route.setBasePrice(ConsoleV2.askAndReadUDouble("Inserire il prezzo base:"));
        route.setTrainType(ConsoleV2.askAndReadString("Inserire il tipo di treno [Regional/Intercity/National]:"));
        route.setTier(ConsoleV2.askAndReadString("Inserire il tipo di biglietto [Economy/Business/First Class]:"));

        repo.create(route);
    }

    /**
     * Chiedere a utente una Stazione di partenza
     * Stampare tutte le route che hanno quella come stazione di partenza
     * vi metto sotto il confronto carino con contains
     * al posto di equals
     * route.getDepartureStation().toLowerCase().contains(input.toLowerCase());
     */
    public void printFrom() {
        final String searchInput = ConsoleV2.askAndReadString("Inserire stazione di partenza da cercare:").toLowerCase();

        for (Route r : repo.read()) {
            if (r.getDepartureStation().toLowerCase().contains(searchInput.toLowerCase()))
                System.out.println(r);
        }
    }
}
