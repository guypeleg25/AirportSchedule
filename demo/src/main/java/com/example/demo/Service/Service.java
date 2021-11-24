package com.example.demo.Service;

import com.example.demo.Controller.Bo.AddFlightsToDailyScheduleInput;
import com.example.demo.Dao.Model.Flight;

import java.util.List;

public interface Service {

    List<Flight> getDailySchedule();
    String addFlight(Flight flight);
    void addFlightsToDailySchedule(AddFlightsToDailyScheduleInput input);
}
