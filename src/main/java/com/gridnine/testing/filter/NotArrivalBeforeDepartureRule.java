package com.gridnine.testing.filter;

import com.gridnine.testing.flights.Flight;
import com.gridnine.testing.flights.Segment;

import java.time.LocalDateTime;
import java.util.List;


/*
 *  Взлет раньше чем прилет
 */

public class NotArrivalBeforeDepartureRule implements Rule {

    @Override
    public boolean checkForRule(Flight flight) {
        List<Segment> currentSegments = flight.getSegments();

        for (int i = 0; i < currentSegments.size(); i++) {
            LocalDateTime departureDate = currentSegments.get(i).getDepartureDate();
            LocalDateTime arrivalDate = currentSegments.get(i).getArrivalDate();

            if (arrivalDate.isBefore(departureDate)) return false;
        }
        return true;
    }
}
