package com.gridnine.testing.filter;

import com.gridnine.testing.flights.Flight;
import com.gridnine.testing.flights.Segment;

import java.time.LocalDateTime;
import java.util.List;

/*
 *  Прилёт до текущего времени
 */

public class NotDepartureBeforeNowRule implements Rule {

    @Override
    public boolean checkForRule(Flight flight) {
        List<Segment> currentSegments = flight.getSegments();

        for (int i = 0; i < currentSegments.size(); i++) {
            LocalDateTime departureDate = currentSegments.get(i).getDepartureDate();

            if (departureDate.isBefore(LocalDateTime.now())) return false;

        }
        return true;
    }
}
