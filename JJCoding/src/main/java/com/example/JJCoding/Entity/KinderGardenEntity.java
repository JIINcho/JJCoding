package com.example.JJCoding.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @Column
    private String kindergardenRandomcode;
    @Column
    private String kindergardenAddress;



}
