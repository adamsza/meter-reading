package hu.reverselogic.meter_reading.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import hu.reverselogic.meter_reading.entities.User;
import hu.reverselogic.meter_reading.repositories.UserRepository;

@Service
public class LoginService{
    private UserRepository uRepository;

    @Autowired
    public void setRepository(UserRepository uRepository)
    {
        this.uRepository = uRepository;
    }

    public User getUser(String email) throws Exception
    {
        Optional<User> user = uRepository.findByEmail(email);
        user.orElseThrow(() -> new Exception("Email address not found"));
        return user.get();
    }
}