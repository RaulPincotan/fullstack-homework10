package ro.fasttrackit.fullstackhomework10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.fullstackhomework10.model.TrainFilters;
import ro.fasttrackit.fullstackhomework10.model.entity.TrainEntity;
import ro.fasttrackit.fullstackhomework10.service.TrainService;

import java.util.List;

@RestController
@RequestMapping("/trains")
@RequiredArgsConstructor
public class TrainController {
    private final TrainService service;

    public List<TrainEntity> getAll(TrainFilters filters) {
        return service.getAllTrains(filters);
    }

}
