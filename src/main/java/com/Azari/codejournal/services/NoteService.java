package com.Azari.codejournal.services;

import com.Azari.codejournal.Dto.CodingDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface NoteService {



    @Transactional
    void addCode(CodingDto codingDto, Long userId);
    //works /testing in postman/pgAdmin
    @Transactional
    void deleteNoteById(Long codeId);
    //works / tested in postman/pgAdmin
    List<String> getAllNoteByUserId(Long codeId);

    List<String> gettingAllNotes();


    // Doesnt work yet lol
    @Transactional
    void updateNoteById(CodingDto codingDto);

    // prolly be that hard to delete simply find out delete it and then add it

}
