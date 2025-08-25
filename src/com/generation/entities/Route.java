package com.generation.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * La route rappresenta un biglietto generico (non legato a persona o posto)
 */
public class Route {
    private final int distance;
    private final TrainTier tier;
    private final double basePrice;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivingTime;
    private final TrainType trainType;
    private final String departureStation;
    private final String arrivalStation;

    //region Getters
    public int getDistance() {
        return distance;
    }

    public TrainTier getTier() {
        return tier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivingTime() {
        return arrivingTime;
    }

    public TrainType getTrainType() {
        return trainType;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }
    //endregion

    public Route(int distance, int row, TrainTier tier, double basePrice, LocalDateTime departureTime, LocalDateTime arrivingTime, TrainType trainType, String departureStation, String arrivalStation) {
        if (distance <= 0) throw new IllegalArgumentException("Distance cannot be 0 or below.");
        if (basePrice <= 0) throw new IllegalArgumentException("Distance cannot be 0 or below.");
        if (arrivingTime.isBefore(departureTime)) throw new IllegalArgumentException("Arrival time cannot be before departure time.");

        this.distance = distance;
        this.tier = tier;
        this.basePrice = basePrice;
        this.departureTime = departureTime;
        this.arrivingTime = arrivingTime;
        this.trainType = trainType;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
    }

    //region Metodi

    /**
     * @return Prezzo del biglietto
     */
    public double price() {
        double trainTypeMult = switch (this.trainType) {
            case REGIONAL -> 1;
            case INTERCITY -> 1.2;
            case NATIONAL -> 1.5;
        };

        double tierMult = switch (this.tier) {
            case ECONOMY -> 1;
            case BUSINESS -> 1.6;
            case FIRST_CLASS -> 2;
        };

        return basePrice * trainTypeMult * tierMult;
    }

    /**
     * Metodo che calcola il tempo di percorrenza
     *
     * @return il tempo di percorrenza in minuti
     */
    public int travelTime() {
        return (int) departureTime.until(arrivingTime, ChronoUnit.MINUTES);
    }

    /**
     * Calcola la velocità media del treno
     *
     * @return velocità media in km/h
     */
    public double avgSpeed() {
        return (double) distance / (departureTime.until(arrivingTime, ChronoUnit.HOURS));
    }

    /**
     * Deve contenere le informazioni importanti sul biglietto, decidete voi quali
     */
    public String toString() {
        return """
                $%.2f, from %s to %s
                Type: %s
                Tier: %s
                
                Arrival Time:\t\t%s
                """.formatted(price(),
                getDepartureStation(),
                getArrivalStation(),
                getTrainType(),
                getTier(),
                getArrivingTime().format(DateTimeFormatter.ISO_LOCAL_TIME));
    }
    //endregion
}
