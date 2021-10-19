package com.example.petapptest.models.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // final선언한 멤버변수에대한 생성자를 만들어줌
public class PetReqDto {
    private final String name;
    private final String email;
    private final String petName1;
    private final String petName2;

}
