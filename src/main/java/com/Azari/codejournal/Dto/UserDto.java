package com.Azari.codejournal.Dto;

import com.Azari.codejournal.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String username;
    private String password;
    private Set<CodingDto> noteDtoSet = new HashSet<>();

    public UserDto(User user){
        if(user.getId() != null){
            this.id = user.getId();

        }
        if(user.getUsername() != null){
            this.password = user.getPassword();

        }
        if (user.getPassword() != null){
            this.password = user.getPassword();
        }

    }








}
