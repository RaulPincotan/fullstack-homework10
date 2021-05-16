package ro.fasttrackit.fullstackhomework10.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private LocationEntity start;

    @OneToOne(cascade = CascadeType.PERSIST)
    private LocationEntity end;

    private double length;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private TrainEntity trainEntity;


}
