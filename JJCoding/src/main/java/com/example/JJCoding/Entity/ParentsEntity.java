package com.example.JJCoding.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "parents")
public class ParentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String parentsName;
    @Column
    private String parentsGender;
    @Column
    private String parentsPhoneNumber;
}
