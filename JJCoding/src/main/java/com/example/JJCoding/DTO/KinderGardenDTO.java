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

    public static KinderGardenDTO toKinderGardenDTO(KinderGardenEntity kinderGardenEntity) {
        KinderGardenDTO kinderGardenDTO = new KinderGardenDTO();
        kinderGardenDTO.setId(kinderGardenEntity.getId());
        kinderGardenDTO.setKindergardenName(kinderGardenEntity.getKindergardenName());
        kinderGardenDTO.setKindergardenClass(kinderGardenEntity.getKindergardenClass());
        kinderGardenDTO.setKindergardenAddress(kinderGardenEntity.getKindergardenAddress());
        return kinderGardenDTO;
    }
}
