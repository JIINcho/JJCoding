package com.example.JJCoding.DTO;

import com.example.JJCoding.Entity.ParentsEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ParentsDTO {

    private Long Id;
    private String parentsId;
    private String parentsPass;
    private String parentsName;
    private String parentsGender;
    private String parentsPhoneNumber;

    public static ParentsDTO toParentsDTO(ParentsEntity parentsEntity) {
        ParentsDTO parentsDTO = new ParentsDTO();
        parentsDTO.setId(parentsEntity.getId());
        parentsDTO.setParentsId(parentsEntity.getParentsId());
        parentsDTO.setParentsPass(parentsEntity.getParentsPass());
        parentsDTO.setParentsName(parentsEntity.getParentsName());
        parentsDTO.setParentsGender(parentsEntity.getParentsGender());
        parentsDTO.setParentsPhoneNumber(parentsEntity.getParentsPhoneNumber());
        return parentsDTO;
    }
}
