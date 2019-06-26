package hu.reverselogic.meter_reading.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.reverselogic.meter_reading.datas.LoginData;
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

    public User getUser(LoginData data)
    {
        User user = uRepository.findByEmail(data.getEmail());
        if(!user.getPassword().equals(data.getPassword())) return null;
        else return user;
    }
}