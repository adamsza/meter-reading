package hu.reverselogic.meter_reading.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.reverselogic.meter_reading.entities.ConsumptionPlace;

@Repository
public interface ConsumptionPlaceRepository extends CrudRepository<ConsumptionPlace, Long>
{

}