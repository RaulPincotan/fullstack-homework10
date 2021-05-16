package ro.fasttrackit.fullstackhomework10.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainEntity {

    @ManyToMany(cascade = CascadeType.PERSIST)
    List<LocationEntity> locations;
    @Id
    @GeneratedValue
    private Long id;
    private int carts;


}
