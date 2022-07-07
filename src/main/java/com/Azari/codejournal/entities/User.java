package com.Azari.codejournal.entities;


//import com.Azari.codejournal.Dto.UserDto;
import com.Azari.codejournal.Dto.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Long id;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(UserDto userDto) {
        if(userDto.getUsername() != null){
            this.username = userDto.getUsername();
        }
        if(userDto.getPassword() != null){
            this.password = userDto.getPassword();
        }
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(unique = true)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


//
@Column
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//      THIS DOWN HERE BREAKS IT



    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<CodeNote> CodeSet = new HashSet<>();

// MAKES IT BROKEN UP HERE
}
