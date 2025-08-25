package com.generation.businesslogic;

import com.generation.entities.Route;
import com.generation.entities.RouteTier;
import com.generation.entities.TrainType;
import com.generation.library.ConsoleV2;
import com.generation.repositories.RepositoryRouteCsv;

import java.time.LocalDateTime;

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
        // departureStation,arrivalStation,departureTime,arrivingTime,distance,basePrice,trainType,tier
        String[] data = new String[8];
        data[0] = ConsoleV2.askAndReadString("Inserire la stazione di partenza:");
        data[1] = ConsoleV2.askAndReadString("Inserire la stazione di destinazione:");
        data[2] = ConsoleV2.askAndReadString("Inserire l'orario di partenza:");
        data[3] = ConsoleV2.askAndReadString("Inserire l'orario di arrivo:");
        data[4] = ConsoleV2.askAndReadString("Inserire la distanza del viaggio:");
        data[5] = ConsoleV2.askAndReadString("Inserire il prezzo base:");
        data[6] = ConsoleV2.askAndReadString("Inserire il tipo di treno [Regional/Intercity/National]:");
        data[7] = ConsoleV2.askAndReadString("Inserire il tipo di biglietto [Economy/Business/First Class]:");

        Route r = new Route(data[0],
                data[1],
                LocalDateTime.parse(data[2]),
                LocalDateTime.parse(data[3]),
                Integer.parseInt(data[4]),
                Double.parseDouble(data[5]),
                TrainType.valueOf(data[6].toUpperCase()),
                RouteTier.valueOf(data[7].toUpperCase().replaceAll("\\s", "_")));

        repo.create(r);
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
