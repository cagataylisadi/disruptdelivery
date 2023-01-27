package org.disruptdelivery.base.repository;

import org.disruptdelivery.base.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

	@Query("SELECT d FROM Delivery d WHERE d.deliveryid = ?1")
	Delivery getDeliveryById(Long deliveryid);

	@Query("SELECT d FROM Delivery d WHERE d.status = 'PACKING'")
	List<Delivery> getActiveDeliveries();


}
