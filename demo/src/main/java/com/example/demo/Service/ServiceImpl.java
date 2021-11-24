package com.example.demo.Service;
import com.example.demo.Controller.Bo.AddFlightsToDailyScheduleInput;
import com.example.demo.Dao.Model.Flight;
import org.springframework.beans.factory.annotation.Value;
import java.util.*;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    @Value("${parkingCapacity}")
    Integer parkingCapacity;
    List<Flight> dailySchedule = new ArrayList<>();
    AddFlightsToDailyScheduleInput clientInput;

    @Override
    public void addFlightsToDailySchedule(AddFlightsToDailyScheduleInput input) {
        clientInput = input;
        dailySchedule = dailyScheduleAlgo(dailySchedule,input.getFlightList());
    }

    @Override
    public List<Flight> getDailySchedule() {
        return dailySchedule;
    }

    @Override
    public String addFlight(Flight flight) {

        List<Flight> flightList = new ArrayList<>();
        clientInput.getFlightList().add(flight);
        flightList = dailyScheduleAlgo(flightList,clientInput.getFlightList());
        if(flightList.containsAll(dailySchedule)){
            dailySchedule = flightList;
            return "Flight was added";
        }
        clientInput.getFlightList().remove(flight);
        return "The airport is full, can't add more flights";

    }

    public List<Flight> dailyScheduleAlgo(List<Flight> list ,List<Flight> clientInput){

        Deque<Flight> parking = new ArrayDeque<>();
        Collections.sort(clientInput, Comparator.comparing(Flight::getDepartureTime));

        for(Flight flight : clientInput){
            if(!parking.isEmpty()){
                if(parking.getFirst().getDepartureTime().before(flight.getArrivalTime())){
                    list.add(parking.poll());
                }
                if(parking.size() == parkingCapacity){
                    System.out.println("The parking is full");
                    continue;
                }
                else{ parking.add(flight); }
            }
            else{ parking.add(flight); }
        }
        for(Flight flight : parking){
            if(!list.contains(flight)){
                list.add(flight);
            }
        }
        return list;
    }

}
