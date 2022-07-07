package com.Azari.codejournal.Dto;

import com.Azari.codejournal.entities.CodeNote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodingDto implements Serializable {
    private Long id;
    private Set<CodingDto> codingDto = new HashSet<>();
    private String body;
    private UserDto userDto;
    public CodingDto(CodeNote codingDto){
            if(codingDto.getId() != null){
                this.id = codingDto.getId();
            }if (codingDto.getBody() != null){
                this.body = codingDto.getBody();

        }



    }

}
