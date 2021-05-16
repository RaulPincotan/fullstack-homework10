package ro.fasttrackit.fullstackhomework10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.fullstackhomework10.model.entity.LocationEntity;
import ro.fasttrackit.fullstackhomework10.model.entity.TrainEntity;

import java.util.List;

public interface TrainRepository extends JpaRepository<TrainEntity, Long> {
    List<TrainEntity> findByLocationEntity(LocationEntity locationEntity);

    TrainEntity findByModel(String model);
}
