package hu.reverselogic.meter_reading.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.reverselogic.meter_reading.datas.CustomUserDetails;
import hu.reverselogic.meter_reading.entities.User;
import hu.reverselogic.meter_reading.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository uRepository;

    @Autowired
    public void setRepository(UserRepository uRepository)
    {
        this.uRepository = uRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = uRepository.findTopByEmail(email);

        if(user != null) return new CustomUserDetails(user);
        else throw new UsernameNotFoundException("Email address not found");
    }

}