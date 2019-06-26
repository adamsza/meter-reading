package hu.reverselogic.meter_reading.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.reverselogic.meter_reading.entities.Meter;

public interface MeterRepository extends CrudRepository<Meter, Long>
{
    List<Meter> findByConsumptionPlaceID(Long consumptionPlaceID);
}