package com.gridnine.testing.filter;

import com.gridnine.testing.flights.Flight;
import com.gridnine.testing.flights.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/*
*  Более 2х часов на земле между сегментами
*/

public class NotTimeOnGroundMoreThenTwoHoursRule implements Rule {

    @Override
    public boolean checkForRule(Flight flight) {
        List <Segment> currentSegments = flight.getSegments();

        for (int i = 0; i < currentSegments.size(); i++) {
            LocalDateTime departureDate = currentSegments.get(i).getDepartureDate();
            LocalDateTime arrivalDate = currentSegments.get(i).getArrivalDate();

            if (arrivalDate.isAfter(departureDate)) { //если дата вылета позже дата прилета
                Duration duration = Duration.between(departureDate, arrivalDate);
                long seconds = duration.getSeconds();
/*
                long hours = seconds / 3600;
                seconds -= (hours * 3600);
                long minutes = seconds / 60;
                seconds -= (minutes * 60);
                System.out.println(hours + " hours " + minutes + " minutes " + seconds + " seconds" + " для " + currentSegments.get(i));

 */
                if (seconds>7200) return false;
            }

        }
        return true;
    }
}
