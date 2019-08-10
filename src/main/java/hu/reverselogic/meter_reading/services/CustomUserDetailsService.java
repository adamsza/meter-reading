package hu.reverselogic.meter_reading.services;

import java.util.Optional;

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

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Email address not found"));
        return optionalUser.map(CustomUserDetails::new).get();
    }

}