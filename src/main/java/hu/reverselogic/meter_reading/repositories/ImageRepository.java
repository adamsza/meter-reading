package hu.reverselogic.meter_reading.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.reverselogic.meter_reading.entities.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long>
{
    Image findByName(String name);
}