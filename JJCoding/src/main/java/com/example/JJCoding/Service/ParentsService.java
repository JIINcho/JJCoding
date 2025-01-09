package com.example.JJCoding.Service;

import com.example.JJCoding.DTO.ParentsDTO;
import com.example.JJCoding.Entity.ParentsEntity;
import com.example.JJCoding.Repository.ParentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentsService {
    private final ParentsRepository parentsRepository;

    @Transactional
    public void save(ParentsDTO parentsDTO) {
        ParentsEntity parentsEntity = ParentsEntity.toParentsEntity(parentsDTO);
        parentsRepository.save(parentsEntity);
    }

    public ParentsDTO login(ParentsDTO parentsDTO) {
        if(parentsDTO == null || parentsDTO.getParentsId() == null) {
            throw new IllegalArgumentException("ParentsDTO is null");
        }
        Optional<ParentsEntity> parentsId = parentsRepository.findByParentsId(parentsDTO.getParentsId());
        if(parentsId.isPresent()){
            //isPresent() -> Boolean -> 값이 있으면 true, 없으면 false
            //조회된 결과가 있다면 비밀번호를 비교함
            ParentsEntity parentsEntity = parentsId.get();
            if(parentsEntity.getParentsPass().equals(parentsDTO.getParentsPass())) {
                ParentsDTO dto = ParentsDTO.toParentsDTO(parentsEntity);
                return dto;
            }
            else {
                //비밀번호 불일치
            }
        }
        else {
            return null;
        }
        return null;
    }

    public boolean isParentsIdExists(String parentsId) {
        return parentsRepository.findByParentsId(parentsId).isPresent();
    }

}
