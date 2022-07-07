package com.Azari.codejournal.services;

import com.Azari.codejournal.Dto.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);

}
