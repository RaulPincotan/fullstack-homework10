package ro.fasttrackit.fullstackhomework10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.fullstackhomework10.model.TrainFilters;
import ro.fasttrackit.fullstackhomework10.model.entity.TrainEntity;
import ro.fasttrackit.fullstackhomework10.repository.TrainDao;
import ro.fasttrackit.fullstackhomework10.repository.TrainRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;
    private TrainDao trainDao;


    public List<TrainEntity> getAllTrains(TrainFilters filters) {
        return trainDao.getAll(filters);
    }


}
