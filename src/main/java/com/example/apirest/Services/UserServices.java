package com.example.apirest.Services;


import com.example.apirest.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserServices implements UserDetailsService {

    public Logger logger = Logger.getLogger(UserServices.class.getName());

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("load user by username");
        var user = userRepository.findByName(username);
        if(user != null){
            return user;
        }else{
            throw new UsernameNotFoundException(username + " not found");
        }
    }
}
