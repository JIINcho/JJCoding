package com.example.JJCoding.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "child")
public class ChildEntity {

//    dd
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
}
