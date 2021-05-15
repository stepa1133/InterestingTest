package com.gridnine.testing.filter;

import com.gridnine.testing.flights.Flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Filter {
    private final List<Rule> rulesForFilteringList;

    public Filter(List<Rule> rulesForFilteringList) {
        this.rulesForFilteringList = rulesForFilteringList;
    }

    public List<Rule> getRulesForFilteringList() {
        return rulesForFilteringList;
    }


    public List<Flight> checkForRulesAndRemoveFlightIfNeed(List<Flight> flightsListForFiltering){
        List <Flight> flightsListAfterFiltering = new LinkedList<>(flightsListForFiltering);  //LinkedList для быстрого исполнения remove

        for (int i = 0; i < rulesForFilteringList.size() ; i++) {    //Rules
            Rule currentRule = rulesForFilteringList.get(i);

            for (int j = flightsListForFiltering.size()-1; j >=0 ; j--) {  //Flights
                Flight currentFlight = flightsListForFiltering.get(j);

                if (!currentRule.checkForRule(currentFlight)){               //Если данный перелет не соответствует правилам то мы можем его удалить
                    if (flightsListAfterFiltering.remove(currentFlight)) {   //Если до этого он не был удален другим правилом, то удалим его
                        System.out.println("После фильтрации согласно правилу " + currentRule.getClass().getSimpleName() + " :\n"
                                + "Удален перелёт - " + currentFlight + "\n"
                                + "----------------------------------------------");
                    }

                }
            }

        }
        return flightsListAfterFiltering;
    }
}
