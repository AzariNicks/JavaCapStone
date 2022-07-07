package com.Azari.codejournal.controllers;

import com.Azari.codejournal.Dto.CodingDto;
import com.Azari.codejournal.entities.CodeNote;
import com.Azari.codejournal.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/v1/notes")
public class NoteController {
        @Autowired
        private NoteService noteService;


        @PostMapping("/user/{userId}")
        public String addNote(@RequestBody CodingDto codingDto, @PathVariable Long userId){
            noteService.addCode(codingDto,userId);
            return "Successfully Posted" + "   " + codingDto.getBody() +  " with an id of "  + userId;
        }

        @GetMapping("/allnotes")
        public List<String> LookingForNotes(){
            return noteService.gettingAllNotes();
        }

        @DeleteMapping("/{noteId}")
        public String deleteNoteById(@PathVariable Long noteId){
            noteService.deleteNoteById(noteId);
            return "Note number " + noteId  + "  has been deleted";
        }




        @GetMapping("/user/{userId}")
        public List<String> getNotesByUser(@PathVariable Long userId)
        {
        return noteService.getAllNoteByUserId(userId);
        }




        // down here isnt working
        @PutMapping
        public void updateNote(@RequestBody CodingDto codingDto){
            noteService.updateNoteById(codingDto);
        }
        // Up here is prolly still broken

    }


