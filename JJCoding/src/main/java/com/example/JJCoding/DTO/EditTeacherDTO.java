package com.example.JJCoding.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EditTeacherDTO {
    private String teacherName;
    private String teacherGender;
    private String teacherPhoneNumber;
}
