package com.example.JJCoding.Entity;

import com.example.JJCoding.DTO.TeacherDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(min = 4, max = 12)
    private String teacherId;
    @Column
    @Size(min = 6, max = 20)
    private String teacherPass;
    @Column
    private String teacherName;
    @Column
    private String teacherGender;
    @Column
    private String teacherPhoneNumber;

    //선생님은 여러개의 유치원을 가질 수 있음
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<KinderGardenEntity> kinderGardenEntityList;


    public static TeacherEntity toTeacherEntity(TeacherDTO teacherDTO) {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(teacherDTO.getId());
        teacherEntity.setTeacherId(teacherDTO.getTeacherId());
        teacherEntity.setTeacherPass(teacherDTO.getTeacherPass());
        teacherEntity.setTeacherName(teacherDTO.getTeacherName());
        teacherEntity.setTeacherGender(teacherDTO.getTeacherGender());
        teacherEntity.setTeacherPhoneNumber(teacherDTO.getTeacherPhoneNumber());
        return teacherEntity;
    }
}
