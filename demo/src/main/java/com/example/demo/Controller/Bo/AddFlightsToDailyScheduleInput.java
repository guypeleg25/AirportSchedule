package com.example.demo.Controller.Bo;
import com.example.demo.Dao.Model.Flight;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddFlightsToDailyScheduleInput implements Serializable{

    @JsonProperty("flightList")
    List<Flight> flightList;
}
