package com.example.JJCoding.Entity;

import com.example.JJCoding.DTO.ParentsDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "parents")
public class ParentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(min = 4, max = 12)
    private String parentsId;
    @Column
    @Size(min = 6, max = 20)
    private String parentsPass;
    @Column
    private String parentsName;
    @Column
    private String parentsGender;
    @Column
    private String parentsPhoneNumber;

    //부모는 여러명의 자녀를 가질 수 있음
    @OneToMany(mappedBy = "parents", cascade = CascadeType.ALL)
    private List<ChildEntity> childEntityList;

    //parentsDTO -> parentsEntity 로 변환
    public static ParentsEntity toParentsEntity(ParentsDTO parentsDTO){
        ParentsEntity parentsEntity = new ParentsEntity();
        parentsEntity.setId(parentsDTO.getId());
        parentsEntity.setParentsId(parentsDTO.getParentsId());
        parentsEntity.setParentsPass(parentsDTO.getParentsPass());
        parentsEntity.setParentsName(parentsDTO.getParentsName());
        parentsEntity.setParentsGender(parentsDTO.getParentsGender());
        parentsEntity.setParentsPhoneNumber(parentsDTO.getParentsPhoneNumber());
        return parentsEntity;
    }
}
