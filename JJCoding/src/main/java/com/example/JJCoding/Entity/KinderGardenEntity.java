package com.example.JJCoding.Entity;

import com.example.JJCoding.Util.CodeGenerator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "kindergarden")
public class KinderGardenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String kindergardenName;
    @Column
    private String kindergardenClass;

    //유치원의 랜덤코드를 발급해주는 코드
    @Column
    private String kindergardenRandomcode;

    public KinderGardenEntity() {
        this.kindergardenRandomcode = CodeGenerator.generateRandomeCode(6);
    }

    @Column
    private String kindergardenAddress;

    @Column
    private String kindergardenMap;

    //유치원은 하나의 선생님에게 소속
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

    //하나의 유치원에 여러명의 아이들이 소속
    @OneToMany(mappedBy = "kindergarden", cascade = CascadeType.ALL)
    private List<ChildEntity> childList;
}
