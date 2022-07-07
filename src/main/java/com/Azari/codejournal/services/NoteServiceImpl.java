package com.Azari.codejournal.services;

import com.Azari.codejournal.Dto.CodingDto;
import com.Azari.codejournal.entities.CodeNote;
import com.Azari.codejournal.entities.User;
import com.Azari.codejournal.repsoitories.CodingNoteRepository;
import com.Azari.codejournal.repsoitories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CodingNoteRepository noteRepository;



    @Override
    @Transactional
    public void deleteNoteById(Long codeId) {
        Optional<CodeNote> codeNoteOptional = noteRepository.findById(codeId);
        codeNoteOptional.ifPresent(codeNote -> noteRepository.delete(codeNote));

    }

    @Override
    @Transactional
    public void updateNoteById(CodingDto codingDto) {
        Optional<CodeNote> codeNoteOptional = noteRepository.findById(codingDto.getId());
        codeNoteOptional.ifPresent(codeNote -> {
            codeNote.setBody(codingDto.getBody());
            noteRepository.saveAndFlush(codeNote);
        });
    }

    @Override
    public List<String> getAllNoteByUserId(Long userId) {
               List<String> response = new ArrayList<>();
               List<Integer> ExistingNotes = new ArrayList<>();
               int TotalNoteNum = noteRepository.findAll().size();
               int EveryNoteFound = 0;
               int FirstNoteFound = 0;
               int i = 0;
               while(EveryNoteFound < TotalNoteNum){
                   i++;
                   if(EveryNoteFound == 1){
                       FirstNoteFound = i;
                   }
                   if (noteRepository.existsById(Long.valueOf(i))) {
                       {
                           ExistingNotes.add(i);
                           EveryNoteFound++;

                           CodeNote codeNote = noteRepository.getReferenceById((long) i);
                           User user = codeNote.getUser();
                           Long NoteId = codeNote.getId();
                           Long Ids = user.getId();
                           String notes = codeNote.getBody();
                           if (Ids == userId) {
                               response.add(notes + ";AzariSplitter987ef3swilos83r1s3l0s87je7c7c7gc7c7gc7cg" + NoteId);
                           }
                       }
                   }
               }
               return  response;
    }


    @Override
        public List<String> gettingAllNotes(){

            List<String> response = new ArrayList<>();
            for (Long i = Long.valueOf(1); i < 150 + 1; i++) {
                if(noteRepository.existsById(Long.valueOf(i))) {

                CodeNote codeNote = noteRepository.getReferenceById(i);
                User IDNum = codeNote.getUser();
                String note = codeNote.getBody();
                Long id = IDNum.getId();
                response.add("User " + String.valueOf(id) + " send this CodeSnippet " + note);

            }
            }
            return response;
    }

    @Override
    @Transactional
    public void addCode(CodingDto codingDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        CodeNote codeNote = new CodeNote(codingDto);
        userOptional.ifPresent(codeNote::setUser);
        codeNote.setId(userId);
        noteRepository.saveAndFlush(codeNote);

    }





}
