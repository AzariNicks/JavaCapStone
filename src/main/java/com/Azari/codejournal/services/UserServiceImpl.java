package com.Azari.codejournal.services;

import com.Azari.codejournal.Dto.UserDto;
import com.Azari.codejournal.entities.User;
import com.Azari.codejournal.repsoitories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        userRepository.saveAndFlush(user);
        response.add("User Added Successfully");
        response.add(String.valueOf(userDto.getUsername()));
        response.add(String.valueOf(userDto.getPassword()));
        response.add(String.valueOf(user.getId()));
        return response;



    }
    @Override
    public List<String> userLogin(UserDto userDto) {
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword()))
        {
            response.add("User Login Successful");
            response.add(String.valueOf(userOptional.get().getUsername()));
            response.add(String.valueOf(userOptional.get().getId()));

        }
        else
        {
            response.add("Username or password incorrect");
            return response;
        }
        return response;

    }



}
