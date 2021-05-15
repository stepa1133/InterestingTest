package com.gridnine.testing.filter;

import com.gridnine.testing.flights.Flight;

public interface Rule {
    boolean checkForRule(Flight flight);
}
