package hu.reverselogic.meter_reading.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import hu.reverselogic.meter_reading.entities.User;

public interface UserRepository extends CrudRepository<User, Long>
{
    //User findByEmail(String email);
    Optional<User> findByEmail(String email);

    User findByID(Long iD);
}