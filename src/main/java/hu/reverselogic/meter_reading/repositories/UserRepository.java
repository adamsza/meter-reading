package hu.reverselogic.meter_reading.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.reverselogic.meter_reading.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
    //User findByEmail(String email);
    User findTopByEmail(String email);

    User findByid(Long id);
}