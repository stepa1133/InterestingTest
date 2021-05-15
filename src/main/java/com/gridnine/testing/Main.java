package com.gridnine.testing;

import com.gridnine.testing.filter.*;
import com.gridnine.testing.flights.Flight;
import com.gridnine.testing.flights.FlightBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static ArrayList<Rule> createRulesList(){
        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(new NotArrivalBeforeDepartureRule());
        rules.add(new NotDepartureBeforeNowRule());
        rules.add(new NotTimeOnGroundMoreThenTwoHoursRule());
        return rules;
    }

    public static void main(String[] args) {

        List<Flight> flightsListForFiltering = FlightBuilder.createFlights();
        List<Rule> rules = createRulesList();

        System.out.println("До фильтрации списка перелётов:\n" + flightsListForFiltering + "\n----------------------------------------------");

        Filter filter = new Filter(rules);
        List<Flight> flightsListAfterFiltering = filter.checkForRulesAndRemoveFlightIfNeed(flightsListForFiltering);


        System.out.println("После фильтрации списка перелётов:\n" + flightsListAfterFiltering);
    }
}
