package hu.reverselogic.meter_reading.repositories;


import org.springframework.data.repository.CrudRepository;

import hu.reverselogic.meter_reading.entities.User;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByEmail(String email);
}