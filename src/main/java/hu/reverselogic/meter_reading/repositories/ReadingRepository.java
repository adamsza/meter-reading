package hu.reverselogic.meter_reading.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.reverselogic.meter_reading.entities.Reading;

public interface ReadingRepository extends CrudRepository<Reading, Long>
{
    List<Reading> findByMeterId(Long meterId);
}