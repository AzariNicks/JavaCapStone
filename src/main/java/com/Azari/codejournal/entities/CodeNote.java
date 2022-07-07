package com.Azari.codejournal.entities;

import com.Azari.codejournal.Dto.CodingDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;



@Entity
@Table(name = "code_notes")

public class CodeNote {

    public CodeNote(CodingDto codingDto) {
        if(codingDto.getBody() != null){
            this.body = codingDto.getBody();
        }
    }

    public CodeNote(Long id, String body) {
        this.id = id;
        this.body = body;

    }
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    public CodeNote() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(columnDefinition = "text")
    private String body;

    public String getBody()
    {
        return body;
                        }

                        public void setBody(String body)
                        {this.body = body;}


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JsonBackReference
    private User user;






}
