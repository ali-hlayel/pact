package db;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrainInfo {
    String station;
    String number;
    Integer arrivalTime;
}
