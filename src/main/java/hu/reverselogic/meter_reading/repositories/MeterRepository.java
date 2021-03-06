package hu.reverselogic.meter_reading.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.reverselogic.meter_reading.entities.Meter;

@Repository
public interface MeterRepository extends CrudRepository<Meter, Long>
{
    Meter findOneById(Long id);
}