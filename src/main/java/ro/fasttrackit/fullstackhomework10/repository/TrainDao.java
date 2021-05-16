package ro.fasttrackit.fullstackhomework10.repository;

import org.springframework.stereotype.Repository;
import ro.fasttrackit.fullstackhomework10.model.TrainFilters;
import ro.fasttrackit.fullstackhomework10.model.entity.TrainEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
public class TrainDao {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public TrainDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        criteriaBuilder = this.entityManager.getCriteriaBuilder();
    }

    public List<TrainEntity> getAll(TrainFilters filters) {
        CriteriaQuery<TrainEntity> criteria = criteriaBuilder.createQuery(TrainEntity.class);
        Root<TrainEntity> root = criteria.from(TrainEntity.class);

        List<Predicate> whereClause = new ArrayList<>();
        ofNullable(filters.getModel())
                .ifPresent(model -> whereClause.add(criteriaBuilder.equal(root.get("model"), model)));
        ofNullable(filters.getMinCarts())
                .ifPresent(minCarts -> whereClause.add(criteriaBuilder.gt(root.get("carts"), minCarts)));
        ofNullable(filters.getMaxCarts())
                .ifPresent(maxCarts -> whereClause.add(criteriaBuilder.lt(root.get("carts"), maxCarts)));
        CriteriaQuery<TrainEntity> query = criteria.select(root).where(whereClause.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
