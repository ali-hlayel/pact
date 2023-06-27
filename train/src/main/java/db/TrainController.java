package db;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TrainController {

    @GetMapping("/train/{station}/{number}")
    public TrainInfo getArrivalTime(@PathVariable String station, @PathVariable String number) {
        int timeToArrive = getTimeToArrive();
        return  TrainInfo.builder()
                .number(number)
                .station(station)
                .arrivalTime(timeToArrive)
                .build();
    }

    private int getTimeToArrive() {
        Random rn = new Random();
        int maxTime = 10;
        return rn.nextInt(maxTime) + 1;
    }


}