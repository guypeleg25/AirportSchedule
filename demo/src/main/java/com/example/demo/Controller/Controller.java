package com.example.demo.Controller;

import com.example.demo.Controller.Bo.AddFlightsToDailyScheduleInput;
import com.example.demo.Service.Service;
import com.example.demo.Dao.Model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class Controller {

    @Autowired
    Service service;

    @RequestMapping(method = RequestMethod.POST, value = "/addFlightsToDailySchedule")
    public void addFlightsToDailySchedule(@RequestBody AddFlightsToDailyScheduleInput input){
        service.addFlightsToDailySchedule(input);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getDailySchedule")
    public List<Flight> getDailySchedule() {
        return service.getDailySchedule();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addFlight")
    public String addFlight(@RequestBody Flight flight) {
        return service.addFlight(flight);
    }
}
