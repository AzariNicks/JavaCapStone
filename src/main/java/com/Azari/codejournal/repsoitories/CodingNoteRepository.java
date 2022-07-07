package com.Azari.codejournal.repsoitories;


import com.Azari.codejournal.entities.CodeNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  CodingNoteRepository extends JpaRepository<CodeNote, Long>{}

