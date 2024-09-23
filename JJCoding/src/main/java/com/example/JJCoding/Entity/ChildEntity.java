package com.example.JJCoding.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "child")
public class ChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String childName;
    @Column
    private Integer childGender;
    @Column
    private String childHealth;
    @Column
    private String childLifestyle;
    @Column
    private String childPersonal;
    @Column
    private String childSpecial;

    //하나의 아이는 하나의 부모에게만 소속
    @ManyToOne
    @JoinColumn(name = "parents_id")
    private ParentsEntity parents;

    //하나의 아이는 하나의 유치원에 소속
    @ManyToOne
    @JoinColumn(name = "kindergarden_id")
    private KinderGardenEntity kindergarden;
}
