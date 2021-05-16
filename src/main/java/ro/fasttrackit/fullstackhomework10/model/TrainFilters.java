package ro.fasttrackit.fullstackhomework10.model;

import lombok.Value;
import ro.fasttrackit.fullstackhomework10.model.entity.LocationEntity;

@Value
public class TrainFilters {
    String model;
    LocationEntity locationEntity;
    Integer minCarts;
    Integer maxCarts;

}
