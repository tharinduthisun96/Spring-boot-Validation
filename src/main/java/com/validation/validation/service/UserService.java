package com.validation.validation.service;

import com.validation.validation.config.PhoneConfig;
import com.validation.validation.config.impl.PhoneService;
import com.validation.validation.domain.User;
import com.validation.validation.dto.UserCreateDto;
import com.validation.validation.exception.UserNotFoundException;
import com.validation.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository user;

    @Autowired
    private PhoneConfig phoneConfig;

    public User saveUser(UserCreateDto userRequest){
        User userData = User.build(0,
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getAge(),
                userRequest.getDob()
        );
        return user.save(userData);
    }

    public List<User> getAllUsers(){
        return user.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        Optional<User> res = user.findById(id);
        phoneConfig.phoneService().printPhone();
        if(res.isEmpty()){
            throw new UserNotFoundException();
        }
        return res.get();
    }

    public boolean emailAvailability(String email){
        return user.existsByEmail(email);
    }
}
