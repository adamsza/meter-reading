package hu.reverselogic.meter_reading.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.reverselogic.meter_reading.entities.Reading;

@Repository
public interface ReadingRepository extends CrudRepository<Reading, Long>
{
    List<Reading> findByMeterId(Long meterId);
}