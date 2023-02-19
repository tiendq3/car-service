package tiendq.carservice.car_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tiendq.carservice.car_service.model.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
