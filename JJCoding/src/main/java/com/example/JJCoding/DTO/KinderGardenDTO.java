package com.example.JJCoding.DTO;

import com.example.JJCoding.Entity.KinderGardenEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class KinderGardenDTO {

    private Long id;
    private String kindergardenName;
    private String kindergardenClass;
    private String kindergardenAddress;

}
