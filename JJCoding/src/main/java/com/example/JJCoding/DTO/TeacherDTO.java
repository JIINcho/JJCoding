package com.example.JJCoding.DTO;


import com.example.JJCoding.Entity.TeacherEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TeacherDTO {
    private Long Id;
    private String teacherId;
    private String teacherPass;
    private String teacherName;
    private String teacherGender;
    private String teacherPhoneNumber;

    //TeacherEntity -> TeacherDTO 로 변환
    public static TeacherDTO toTeacherDTO(TeacherEntity teacherEntity) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacherEntity.getId());
        teacherDTO.setTeacherId(teacherEntity.getTeacherId());
        teacherDTO.setTeacherPass(teacherEntity.getTeacherPass());
        teacherDTO.setTeacherName(teacherEntity.getTeacherName());
        teacherDTO.setTeacherGender(teacherEntity.getTeacherGender());
        teacherDTO.setTeacherPhoneNumber(teacherEntity.getTeacherPhoneNumber());
        return teacherDTO;
    }
}
