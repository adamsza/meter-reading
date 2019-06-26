package hu.reverselogic.meter_reading.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.reverselogic.meter_reading.entities.ConsumptionPlace;;

public interface ConsumptionPlaceRepository extends CrudRepository<ConsumptionPlace, Long>
{
    List<ConsumptionPlace> findByUserID(Long userID);
}