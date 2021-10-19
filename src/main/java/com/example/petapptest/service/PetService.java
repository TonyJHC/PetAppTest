package com.example.petapptest.service;


import com.example.petapptest.models.Entity.Pet;
import com.example.petapptest.models.Repo.PetRepository;
import com.example.petapptest.models.Dto.PetReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // 2. final 선언시 꼭 필요
@Service
public class PetService {
    private final PetRepository petRepository;

    @Transactional // 3. 해당 메소드가 호출될 때 바뀐 내용을 DB에 반영을 해줘야되 !
    public Long update(Long id, PetReqDto requestDto) {
        Pet pet = petRepository.findById(id).orElseThrow( // 예외처리 : 만약에 없다면 ?
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.") // 파라미터가 잘 못 들어왔을 때
        );
        pet.update(requestDto);
        return pet.getId();
    }


}
